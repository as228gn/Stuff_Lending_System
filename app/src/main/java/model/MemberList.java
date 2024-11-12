package model;

import java.util.ArrayList;
import java.util.List;

/**
 * A class symbolising a memberlist called MemberList.
 *
 */
public class MemberList {
  private ArrayList<Member> members = new ArrayList<Member>();

  public MemberList() {
  }

  /**
   * Creates a deep copy of the MemberList.
   * 
   * @return A new MemberList instance with deep-copied Members.
   */
  public MemberList deepCopy() {
    MemberList copiedList = new MemberList();
    for (Member member : this.members) {
      copiedList.members.add(member.deepCopy());
    }
    return copiedList;
  }

  public List<Member> getMembers() {
    List<Member> copiedMembers = new ArrayList<>();
    for (Member member : this.members) {
      copiedMembers.add(member.deepCopy());
    }
    return copiedMembers;
  }

  /**
   * A method that creates a member.
   *
   * @param name  The name of the member.
   * @param email The email of the member.
   * @param phone The phonenumber of the member.
   * @param day   Symbolising the day of creation.
   * @throws Exception if the member email, phonenumber or ID is not unique.
   */
  public Member createMember(String name, String email, String phone, Day day) throws Exception {
    model.Member member = new model.Member(name, email, phone);
    member.setDayOfCreation(day.getDay());
    member.setId();
    addMember(member);
    return member;
  }

  /**
   * A method that adds a member.
   *
   * @param member The member to be added.
   * @throws Exception if argument is not unique.
   */
  private void addMember(Member member) throws Exception {
    if (!isIdUnique(member.getId())) {
      throw new Exception("Id must be unique.");
    }
    if (!isEmailUnique(member.getEmail())) {
      throw new Exception("Email must be unique.");
    }
    if (!isPhoneUnique(member.getPhone())) {
      throw new Exception("Phonenumber must be unique.");
    }
    this.members.add(member);
  }

  private boolean isIdUnique(String id) {
    for (Member member : members) {
      if (member.getId().equals(id)) {
        return false;
      }
    }
    return true;
  }

  private boolean isEmailUnique(String email) {
    for (Member member : members) {
      if (member.getEmail().equals(email)) {
        return false;
      }
    }
    return true;
  }

  private boolean isPhoneUnique(String phone) {
    for (Member member : members) {
      if (member.getPhone().equals(phone)) {
        return false;
      }
    }
    return true;
  }

  public void deleteMember(String email) {
    for (model.Member member : members) {
      if (email.equals(member.getEmail())) {
        members.remove(member);
      }
    }
  }

  public void updateMemberDetails(String email, String name, String newEmail, String phone) {
    for (model.Member member : members) {
      if (email.equals(member.getEmail())) {
        member.updateMemberDetails(name, newEmail, phone);
      }
    }
  }

  public void createItem(String email, Category category, String name, String description, int price, Day day)
      throws Exception {
    for (model.Member member : members) {
      if (email.equals(member.getEmail())) {
        member.createItem(category, name, description, price, day);
      }
    }
  }

  public void removeOwnedItem(String itemId) {
    for (model.Member member : members) {
      List<model.Item> items = member.getItems();

      for (model.Item a : items) {
        if (a.getId().equals(itemId)) {
          member.removeOwnedItem(a);
        }
      }
    }
  }

  public void updateItemDetails(String itemId, Category category, String name, String description, int price) {
    for (model.Member member : members) {
      member.updateItemDetails(itemId, category, name, description, price);
    }
  }

  @SuppressWarnings("null")
  public void lendItem(String email, String itemId, int startDay, int endDay, Day day) throws Exception {

    model.Member lender = null;
    model.Member owner = null;
    model.Item item = null;
    for (model.Member member : members) {
      if (email.equals(member.getEmail())) {
        lender = member;
      }
    }

    for (model.Member member : members) {
      item = member.getItemToLend(itemId);
      if (item != null) {
        break;
      }
    }
    String owningMemberId = item.getOwnedBy();
    for (model.Member member : members) {
      if (owningMemberId.equals(member.getId())) {
        owner = member;
      }
    }
    if (startDay < day.getDay()) {
      throw new Exception("Start time has expired.");
    }
    String ownerId = item.getOwnedBy();
    if (!ownerId.equals(lender.getId())) {
      if (lender.getCredit() < item.getPrice() * (endDay - day.getDay())) {
        throw new Exception("Not enough credit.");
      }
    }
    int priceToOwner = item.createContract(startDay, endDay, day, lender.getName());
    lender.setCredit(-priceToOwner);
    owner.setCredit(priceToOwner);

  }
}
