package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import controller.Day;

/**
 * A class symbolising an item called Item.
 *
 */
public class Item {
  private String category;
  private String name;
  private String description;
  private int price;
  private int dayOfCreation;
  private String ownedById;
  private String id;
  private ArrayList<Contract> contracts = new ArrayList<Contract>();

  /**
   * Constructor of item.
   *
   * @param category    The category of the item.
   * @param name        The name of the item.
   * @param description A description of the item.
   * @param price       The price of the item.
   */
  public Item(String category, String name, String description, int price) {
    this.category = category;
    this.name = name;
    this.description = description;
    this.price = price;
  }

  public String getCategory() {
    return this.category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getPrice() {
    return this.price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getDayOfCreation() {
    return this.dayOfCreation;
  }

  public void setDayOfCreation(int dayOfCreation) {
    this.dayOfCreation = dayOfCreation;
  }

  public String getOwnedBy() {
    return this.ownedById;
  }

  public void setOwnedBy(String ownedById) {
    this.ownedById = ownedById;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getId() {
    return id;
  }

   /**
   * A method that creates a contract between the lender and the owner.
   *
   * @param item    The item being lended.
   * @param endTime The time the item returns.
   * @param day     The startday of the lending.
   * @param lender  The lender of the item.
   * @throws Exception if the lender doesn´t have enough credit or if the start
   *                   time has expired.
   */
  public int createContract(int startTime, int endTime, Day day, String lenderID)
      throws Exception {
    int price = getPrice();
    int lendedDays = endTime - startTime + 1;
    int prizeToOwner = lendedDays * price;
    model.Contract contract = new model.Contract(startTime, endTime, lenderID);
    addContract(contract);
    return prizeToOwner;
  }

  /**
   * Adds a contract to the item and holds the logic for not creating a contract
   * with conflicting time.
   *
   * @param newContract The contract to be added.
   * @throws Exception if the item is not avaliable the desired time.
   */
  public void addContract(Contract newContract) throws Exception {
    List<model.Contract> contracts = getContracts();
    for (model.Contract existingContract : contracts) {
      if (newContract.getStartTime() >= existingContract.getStartTime()
          && newContract.getStartTime() <= existingContract.getEndTime()) {
        throw new Exception("Item not avaliable.");
      }

      if (newContract.getEndTime() >= existingContract.getStartTime()
          && newContract.getEndTime() <= existingContract.getEndTime()) {
        throw new Exception("Item not avaliable.");
      }

      if (newContract.getStartTime() < existingContract.getStartTime()
          && newContract.getEndTime() > existingContract.getEndTime()) {
        throw new Exception("Item not avaliable.");
      }

      if (newContract.getStartTime() > existingContract.getStartTime()
          && newContract.getEndTime() < existingContract.getEndTime()) {
        throw new Exception("Item not avaliable.");
      }
    }
    this.contracts.add(newContract);
  }

  /**
   * A method that return the contracts that belong to the item.
   *
   * @return The contracts.
   */
  public List<model.Contract> getContracts() {
    return new ArrayList<>(this.contracts);
  }

  @Override
  public String toString() {
    return "   " + getName() + ", Description: " + getDescription() + ", Category: " + getCategory() + ", Prize: "
        + getPrice() + ", ItemID: " + getId();
  }
}
