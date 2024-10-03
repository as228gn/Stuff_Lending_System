package controller;

import java.util.ArrayList;
import java.util.List;

import model.Item;

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
    String nameToRemove = member.getName();
    members.removeIf(members -> members.getName() == nameToRemove);
  }

  public model.Item addItem(String category, String name, String description, int prize, model.Member ownedBy) {
    model.Item item = new model.Item(category, name, description, prize, ownedBy);
    ownedBy.setCredit(100);
    ownedBy.setItem(item);
    return item;
  }

  public void deleteItem(model.Item item) {
    String nameToRemove = item.getName();
    for (model.Member member : members) {
      List<model.Item> items = member.getItems();

      for (model.Item thing : items) {
        if (thing.getName() == nameToRemove) {
          member.removeItem(thing);
        }
      }
    }
  }


  public List<model.Member> getMembers() {
    return new ArrayList<>(this.members);
  }

}
