package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import controller.Day;

/**
 * A class symbolising a member called Member.
 *
 */
public class Member {
  private String name;
  private String email;
  private String phone;
  private String id;
  private int credit;
  private int dayOfCreation;
  private ArrayList<Item> ownedItems = new ArrayList<Item>();
  private Random random;

  /**
   * Constructor of member.
   *
   * @param name  The name of the member.
   * @param email The email of the member.
   * @param phone The phonenumber of the member.
   */
  public Member(String name, String email, String phone) {
    this.random = new Random();
    setName(name);
    setEmail(email);
    setPhone(phone);
  }

  /**
   * A copyconstructor of member.
   *
   * @param copyMember The member to be copied.
   */
  public Member(Member copyMember) {
    if (copyMember != null) {
      this.name = copyMember.name;
      this.email = copyMember.email;
      this.phone = copyMember.phone;
      this.random = new Random();
    }
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

  public String getPhone() {
    return phone;
  }
  
  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getId() {
    return this.id;
  }

  /**
   * A method that creates a unique id for the member.
   *
   */
  public void setId() {
    ArrayList<String> letters = new ArrayList<>();
    letters.addAll(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h",
            "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"));

    ArrayList<Integer> numbers = new ArrayList<>();
    for (int i = 0; i <= 9; i++) {
      numbers.add(i);
    }
    StringBuilder id = new StringBuilder();

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

  public void setCredit(int cost) {
    this.credit += cost;
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

   /**
   * A method that creates an item.
   *
   * @param category    A category for the item.
   * @param name        The name of the item.
   * @param description A description of the item.
   * @param price       The price of the item.
   * @param day         Symbolising the day of creation.
   * @param owner       The owner of the item.
   * @throws Exception If Id is not unique.
   */
  public void createItem(String category, String name, String description, int price, Day day)
      throws Exception {
    Item item = new model.Item(category, name, description, price);
    int id = generateItemId();
    System.out.println("Id:" + id);
    item.setId(id);
    item.setDayOfCreation(day.getDay());
    addOwnedItem(item);
  }

  private int generateItemId()
  {
    int highestId = 0;

    for (Item item : ownedItems) {
      if (item.getId() > highestId)
        highestId = item.getId();  
    }

    return highestId+1;
  }

  public void addOwnedItem(Item item) {
    this.ownedItems.add(item);
    setCredit(100);
  }

  public void removeOwnedItem(Item item) {
    this.ownedItems.remove(item);
  }

  /**
   * A copyconstructor of member.
   *
   * @return A string of full information of the member.
   */
  public String fullInformation() {
    return "Name: " + getName() + ", Email: " + getEmail() + ", Phonenumber: " + getPhone() + ", MemberID: " + getId()
        + ", Credit: " + getCredit() + ", Number of owned items: "
        + ownedItems.size() + ", Member sence day: " + getDayOfCreation();
  }

  @Override
  public String toString() {
    return "Member: " + getName() + ", Email: " + getEmail() + ", Credit: " + getCredit() + ", Number of owned items: "
        + ownedItems.size();
  }
}
