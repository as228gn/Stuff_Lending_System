package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;

/**
 * A class symbolising an item called Item.
 *
 */
public class Item {
  private String category;
  private String name;
  private String description;
  private int prize;
  private int dayOfCreation;
  private Member lendedTo;
  private Member ownedBy;
  private boolean isAvaliable = true;
  private String id;
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

  public Boolean isAvaliable() {
    return this.isAvaliable;
  }

  public void setFree() {
    this.isAvaliable = true;
  }

  public void setLended() {
    this.isAvaliable = false;
  }

  public Member getOwnedBy() {
    return this.ownedBy;
  }

  public void setOwnedBy(Member member) {
    this.ownedBy = member;
  }

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
        + getPrize() + ", ItemID: " + getId();
  }
}
