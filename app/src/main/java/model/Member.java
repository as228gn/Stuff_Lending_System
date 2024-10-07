package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * A class symbolising a member called Member.
 *
 */
public class Member {
  private String name;
  private String email;
  private int phone;
  private String id;
  private int credit;
  private int dayOfCreation;
  private ArrayList<Item> ownedItems = new ArrayList<Item>();

  public Member(String name, String email, int phone) {
    setName(name);
    setEmail(email);
    setPhone(phone);
  }

  public Member() {
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

  public void setPhone(int phone){
    this.phone = phone;
  }

  public int getPhone() {
    return phone;
  }

  public String getId() {
    return this.id;
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

  public int getCredit() {
    return this.credit;
  }

  public void setCredit(int credit) {
    this.credit += credit;
  }

  public int getDayOfCreation() {
    return this.dayOfCreation;
  }

  public void setDayOfCreation(int dayOfCreation) {
    this.dayOfCreation = dayOfCreation;
  }

  public List<Item> getItems() {
    return new ArrayList<>(this.ownedItems);
  }

  public void addOwnedItem(Item item) {
    this.ownedItems.add(item);
    setCredit(100);
  }

  public void removeOwnedItem(Item item) {
    this.ownedItems.remove(item);
  }

  @Override
  public String toString() {
    return "Name: " + getName() + ", Email: " + getEmail() + ", Credit: " + getCredit() + ", Number of owned items: "
        + ownedItems.size();
  }
}
