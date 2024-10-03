package controller;

import java.util.ArrayList;
import java.util.List;

public class Member {
  private ArrayList<model.Member> members = new ArrayList<model.Member>();
  private ArrayList<model.Item> items = new ArrayList<model.Item>();

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
    this.items.add(item);
    ownedBy.setCredit(100);
    ownedBy.setItem(item);
    return item;
  }

  public void deleteItem(model.Item item) {
    String nameToRemove = item.getName();
    items.removeIf(items -> items.getName() == nameToRemove);
  }

  public List<model.Member> getMembers() {
    return new ArrayList<>(this.members);
  }

}
