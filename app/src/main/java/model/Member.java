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
  private String phone;
  private String id;
  private int itemIdCounter;
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

  public Member() {
  }

  public Member deepCopy() {
    Member copiedMember = new Member(this.name, this.email, this.phone);
    copiedMember.id = this.id;
    copiedMember.credit = this.credit;
    copiedMember.dayOfCreation = this.dayOfCreation;
    copiedMember.itemIdCounter = this.itemIdCounter;

    copiedMember.ownedItems = new ArrayList<>();
    for (Item item : this.ownedItems) {
      copiedMember.ownedItems.add(item.deepCopy());
    }

    return copiedMember;
  }

  public String getName() {
    return this.name;
  }

  private void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  private void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  private void setPhone(String phone) {
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

  /**
   * A method that updates the member details.
   *
   * @param name  The name of the member.
   * @param email The email of the member.
   * @param phone The phonenumber of the member.
   */
  public void updateMemberDetails(String name, String email, String phone) {
    setName(name);
    setEmail(email);
    setPhone(phone);
  }

  /**
   * A method that creates an item.
   *
   * @param category    A category for the item.
   * @param name        The name of the item.
   * @param description A description of the item.
   * @param price       The price of the item.
   * @param day         Symbolising the day of creation.
   * @throws Exception If Id is not unique.
   */
  public Item createItem(Category category, String name, String description, int price, Day day)
      throws Exception {
    Item item = new model.Item(category, name, description, price);
    String itemId = this.getId() + "-" + this.itemIdCounter;
    itemIdCounter = itemIdCounter + 1;

    item.setId(itemId);
    item.setOwnedBy(getId());
    item.setDayOfCreation(day.getDay());
    addOwnedItem(item);
    return item;
  }

  public void updateItemDetails(String itemId, Category category, String name, String description, int price) {
    for (model.Item a : ownedItems) {
      if (a.getId().equals(itemId)) {
        a.updateItemDetails(category, name, description, price);
      }
    }
  }

  public Item getItemToLend(String itemId) {
    for (model.Item a : ownedItems) {
      if (a.getId().equals(itemId)) {
        return a;
      }
    }
    return null;
  }

  private void addOwnedItem(Item item) {
    this.ownedItems.add(item);
    setCredit(100);
  }

  public void removeOwnedItem(Item item) {
    this.ownedItems.remove(item);
  }

  public List<Item> getItems() {
    List<Item> deepCopiedItems = new ArrayList<>();
    for (Item item : this.ownedItems) {
      deepCopiedItems.add(item.deepCopy());
    }
    return deepCopiedItems;
  }

  public String fullInformation() {
    return "Name: " + getName() + ", Email: " + getEmail() + ", Phonenumber: " + getPhone() + ", MemberID: " + getId()
        + ", Credit: " + getCredit() + ", Number of owned items: "
        + ownedItems.size() + ", Member sence day: " + getDayOfCreation();
  }

  @Override
  public String toString() {
    return "Member: " + getName() + ", Email: " + getEmail() + ", Credit: " + getCredit() + ", Number of owned items: "
        + ownedItems.size() + ", MemberID: " + getId();
  }
}
