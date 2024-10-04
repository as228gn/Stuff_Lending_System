package model;

import java.io.SyncFailedException;
import java.util.ArrayList;
import java.util.List;

/**
 * A class symbolising a member called Member.
 *
 */
public class Member {
  private String name;
  private String email;
  private int id;
  private int credit;
  private ArrayList<Item> ownedItems = new ArrayList<Item>();

  public Member(String name, String email) {
    setName(name);
    setEmail(email);
    setId();
  }

  public Member(){}

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
    return new ArrayList<>(this.ownedItems);
}

  public void addOwnedItem(Item item){
    this.ownedItems.add(item);
    setCredit(100);
    item.setOwnedBy(this.getName());
  }

  public void removeOwnedItem(Item item) {
    this.ownedItems.remove(item);
  }

  @Override
  public String toString() {
    return "Name: " + getName() + ", Email: " + getEmail() + ", Credit: " + getCredit() + ", Number of owned items: " + ownedItems.size();
  }
}
