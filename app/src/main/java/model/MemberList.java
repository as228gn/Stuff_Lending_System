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
   * @return a member.
   */
  public void addMember(Member member) {
    this.members.add(member);
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
   * 
   * @return Members.
   */
  public List<model.Member> getMembers() {
    return new ArrayList<>(this.members);
  }

}

