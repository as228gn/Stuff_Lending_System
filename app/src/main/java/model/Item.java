package model;

import java.util.ArrayList;
import java.util.List;

/**
 * A class symbolising an item called Item.
 *
 */
public class Item {
  private Category category;
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
  public Item(Category category, String name, String description, int price) {
    this.category = category;
    this.name = name;
    this.description = description;
    this.price = price;
  }

  public Item deepCopy() {
    Item copiedItem = new Item(this.category, this.name, this.description, this.price);
    copiedItem.dayOfCreation = this.dayOfCreation;
    copiedItem.ownedById = this.ownedById;
    copiedItem.id = this.id;

    for (Contract contract : this.contracts) {
      copiedItem.contracts.add(contract.contractCopy());
    }

    return copiedItem;
  }

  public Category getCategory() {
    return this.category;
  }

  private void setCategory(Category category) {
    this.category = category;
  }

  public String getName() {
    return this.name;
  }

  private void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  private void setDescription(String description) {
    this.description = description;
  }

  public int getPrice() {
    return this.price;
  }

  private void setPrice(int price) {
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

  public void setId(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  /**
   * A method that updates the item details.
   *
   * @param category    The category of the item.
   * @param name        The name of th item.
   * @param description The description of the item.
   * @param price       The price of the item.
   */
  public void updateItemDetails(model.Category category, String name, String description, int price) {
    setCategory(category);
    setName(name);
    setDescription(description);
    setPrice(price);
  }

  /**
   * A method that creates a contract between the lender and the owner.
   *
   * @param endTime    The time the item returns.
   * @param day        The startday of the lending.
   * @param lenderName The lender of the item.
   * @throws Exception if the lender doesn´t have enough credit or if the start
   *                   time has expired.
   */
  public int createContract(int startTime, int endTime, Day day, String lenderName)
      throws Exception {
    int price = getPrice();
    int lendedDays = endTime - startTime + 1;
    int prizeToOwner = lendedDays * price;
    model.Contract contract = new model.Contract(startTime, endTime, lenderName);
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
  private void addContract(Contract newContract) throws Exception {
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

  public List<model.Contract> getContracts() {
    List<model.Contract> contractsCopy = new ArrayList<>();
    for (model.Contract contract : this.contracts) {
        contractsCopy.add(contract.contractCopy());
    }
    return contractsCopy;
}

  @Override
  public String toString() {
    return "   " + getName() + ", Description: " + getDescription() + ", Category: " + getCategory() + ", Prize: "
        + getPrice() + ", ItemID: " + getId();
  }
}
