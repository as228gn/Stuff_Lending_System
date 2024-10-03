package model;

import java.util.ArrayList;
import java.util.List;

public class Member {
  private String name;
  private String email;
  private int id;
  private int credit;
  private ArrayList<Item> items = new ArrayList<Item>();

  public Member(String name, String email) {
    setName(name);
    setEmail(email);
    setId();
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getId() {
    return this.id;
  }

  public void setId() {
    //this.id =
  }

  public int getCredit() {
    return this.credit;
  }

  public void setCredit(int credit) {
    this.credit += credit;
  }

  public List<Item> getItems() {
    return new ArrayList<>(this.items);
}

  public void setItem(Item item) {
    this.items.add(item);
  }

  public void removeItem(Item item) {
    this.items.remove(item);
  }

  @Override
  public String toString() {
    return "Name: " + getName() + ", Email: " + getEmail() + ", Credit: " + getCredit() + ", Number of owned items: " + items.size();
  }
}
