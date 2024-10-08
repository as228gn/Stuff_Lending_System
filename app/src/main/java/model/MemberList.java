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
   * A method that adds a member.
   *
   * @param member The member to be added.
   */
  public void addMember(Member member) {
    if (!isIdUnique(member.getId())) {
      System.err.println("Id must be unique");
    }
    if (!isEmailUnique(member.getEmail())) {
      System.err.println("Email must be unique");
    }
    if (!isPhoneUnique(member.getPhone())) {
      System.err.println("Phonenumber must be unique");
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
   * A method that returns all the members.
   
   * @return Members. 
   */
  public List<model.Member> getMembers() {
    return new ArrayList<>(this.members);
  }

}
