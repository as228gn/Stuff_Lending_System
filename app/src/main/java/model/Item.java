package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
  private Member lendedTo;
  private Member ownedBy;
  private String id;
  private ArrayList<Contract> contracts = new ArrayList<Contract>();

  /**
   * Constructor of item.
   *
   * @param category The category of the item.
   * @param name The name of the item.
   * @param description A description of the item.
   * @param price The price of the item.
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

  public Member getLendedTo() {
    return this.lendedTo;
  }

  public void setLendedTo(Member lendedTo) {
    this.lendedTo = lendedTo;
  }

  public Member getOwnedBy() {
    return this.ownedBy;
  }

  public void setOwnedBy(Member member) {
    this.ownedBy = member;
  }

  /**
   * A method that creates a unique id for the item.
   *
   */
  public void setId() {
    ArrayList<String> letters = new ArrayList<>();
    letters.addAll(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
        "r", "s", "t", "u", "v", "w", "x", "y", "z"));

    ArrayList<Integer> numbers = new ArrayList<>();
    for (int i = 0; i <= 9; i++) {
      numbers.add(i);
    }
    StringBuilder id = new StringBuilder();

    Random random = new Random();
    for (int i = 0; i < 3; i++) {
      int randomIndex = random.nextInt(letters.size());
      id.append(letters.get(randomIndex));
    }

    for (int i = 0; i < 3; i++) {
      int randomIndex = random.nextInt(numbers.size());
      id.append(numbers.get(randomIndex));
    }
    this.id = id.toString();
  }

  public String getId() {
    return id;
  }

  public void addContract(Contract newContract) {
    List<model.Contract> contracts = getContracts();
    for (model.Contract existingContract : contracts) {
      if (newContract.getStartTime() >= existingContract.getStartTime() && newContract.getStartTime() <= existingContract.getEndTime()) {
        //throw err
        System.out.println("Conflicting time");
      }
      
      if (newContract.getEndTime() >= existingContract.getStartTime() && newContract.getEndTime() <= existingContract.getEndTime()) {
        System.out.println("Conflicting time 2");
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
