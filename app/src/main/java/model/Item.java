package model;

import java.util.ArrayList;
import java.util.List;

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
  private String ownedBy;
  private boolean availability = true;
  private ArrayList<Contract> contracts = new ArrayList<Contract>();

  public Item(String category, String name, String description, int prize) {
    this.category = category;
    this.name = name;
    this.description = description;
    this.prize = prize;
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

  public String getOwnedBy() {
    return this.ownedBy;
  }

  public void setOwnedBy(String member) {
    this.ownedBy = member;
  }

  public void addContract(Contract contract) {
    this.contracts.add(contract);
  }

  /**
   * A method that returns all the contracts.
   * 
   * @return Contracts.
   */
  public List<model.Contract> getContracts() {
    return new ArrayList<>(this.contracts);
  }

  @Override
  public String toString() {
    return "   " + getName() + ", Description: " + getDescription() + ", Category: " + getCategory() + ", Prize: "
        + getPrize() + " Owned by: " + getOwnedBy() + " and lended to: " + getLendedTo();
  }
}
