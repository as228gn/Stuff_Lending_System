package controller;

import java.util.ArrayList;
import java.util.List;

import model.Member;

public class MemberController {
  model.MemberList memberList = new model.MemberList();
  model.Member memberModel = new model.Member();

  public MemberController(){}

  /**
   * A method that creates a member.
   *
   * @param a member.
   */
  public model.Member createMember(String name, String email, int phone, Day day) {
    model.Member member = new model.Member(name, email, phone);
    member.setDayOfCreation(day.getDay());
    member.setId();
    memberList.addMember(member);
    return member;
  }

  /**
   * A method that updates a member.
   *
   * @param a member.
   */
  public void updateMember(String name, String email, String memberID) {
    
  }

  /**
   * A method that deletes a member.
   *
   * @param member The member object to delete.
   */
  public void deleteMember(model.Member member) {
    memberList.deleteMember(member);
  }

  /**
   * A method that returns all the members.
   * 
   * @return Members.
   */
  public List<model.Member> getMembers() {
    return memberList.getMembers();
  }

  public void ListAllItems() {
    List<model.Member> members = getMembers();
    for (model.Member member : members) {
      List<model.Item> items = member.getItems();

      for (model.Item a : items) {
        if(a.isAvaliable() == true) {
        System.out.println(a.toString());}
      }
    }
  }

}
