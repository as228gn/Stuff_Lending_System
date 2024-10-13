package model;

import controller.Day;
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

  /**
   * A method that deletes a member.
   *
   * @param member The member object to delete.
   */
  public void deleteMember(Member member) {
    members.remove(member);
  }

  /**
   * A method that returns a list of members.
   *
   * @return Members.
   */
  public List<model.Member> getMembers() {
    return new ArrayList<>(this.members);
  }

}
