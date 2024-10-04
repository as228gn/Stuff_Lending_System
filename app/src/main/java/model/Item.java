package model;

import java.util.ArrayList;

/**
 * A class symbolising an item called Item.
 *
 */
public class Item {
  private String category;
  private String name;
  private String description;
  private int prize;
  private Member lendedTo;
  private Member ownedBy;
  private boolean availability = true;
  private ArrayList<Contract> contracts = new ArrayList<Contract>();

  public Item(String category, String name, String description, int prize, Member ownedBy) {
    this.category = category;
    this.name = name;
    this.description = description;
    this.prize = prize;
    this.ownedBy = ownedBy;
  }

  public String getCategory() {
    return this.category;
  }

  public String getName() {
    return this.name;
  }

  public String getDescription() {
    return this.description;
  }

  public int getPrize() {
    return this.prize;
  }

  public Member getLendedTo() {
    return this.lendedTo;
  }

  public void setLendedTo(Member lendedTo) {
    this.lendedTo = lendedTo;
  }

  public boolean getAvilability() {
    return this.availability;
  }

  public void setAvilability(boolean availability) {
    this.availability = false;
  }

  public Member getOwnedBy(){
    return this.ownedBy;
  }

  @Override
  public String toString() {
    return "   " + getName() + ", Description: " + getDescription() + ", Category: " + getCategory() + ", Prize: "
      + getPrize() + " and lended to: " + getLendedTo();
  }
}
