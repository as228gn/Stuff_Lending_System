package controller;

import java.util.ArrayList;

public class Member {
  private ArrayList<model.Member> members = new ArrayList<model.Member>();

  public Member() {
  }

  public model.Member createMember(String name, String email) {
    model.Member member = new model.Member(name, email);
    this.members.add(member);
    return member;
  }

  public void deleteMember(model.Member member) {
    for (model.Member membe : members) {
      System.out.println(membe.getName());
    }
    String nameToRemove = member.getName();
    members.removeIf(members -> members.getName() == nameToRemove);
    for (model.Member membe : members) {
      System.out.println(membe.getName());
    }
  }
}
