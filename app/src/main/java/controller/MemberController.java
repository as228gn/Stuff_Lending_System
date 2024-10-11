package controller;

import java.util.List;
import model.Member;

/**
 * A class called Membercontroller symbolising the controller.
 *
 */
public class MemberController {
  model.MemberList memberList = new model.MemberList();
  view.Menu menu = new view.Menu();

  public MemberController() {
  }

  /**
   * A method that starts the application by telling the view to put out the menu.
   *
   * @param day The day counter, telling the application what day it is.
   * @throws Exception if the lender doesn´t have enough credit or if the
   *                   starttime has expired.
   */
  public void startMenu(Day day) throws Exception {
    while (true) {
      try {
        String menuChoise = menu.printMenu();
        List<model.Member> members = memberList.getMembers();
        if (menuChoise.equals("c")) {
          String name = menu.getUserInputString("Name: ");
          String email = menu.getUserInputString("Email: ");
          String phone = menu.getUserInputString("Phonenumber: ");
          createMember(name, email, phone, day);
        }
        if (menuChoise.equals("dm")) {
          String email = menu.getUserInputString("Please write the email of the member you want to delete: ");
          for (model.Member member : members) {
            if (email.equals(member.getEmail())) {
              memberList.deleteMember(member);
            }
          }
        }
        if (menuChoise.equals("um")) {
          String email = menu.getUserInputString("Please write the email of the member you want to update: ");
          String name = menu.getUserInputString("Updated name: ");
          String newEmail = menu.getUserInputString("Updated email: ");
          String phone = menu.getUserInputString("Updated phonenumber: ");
          for (model.Member member : members) {
            if (email.equals(member.getEmail())) {
              member.setName(name);
              member.setEmail(newEmail);
              member.setPhone(phone);
            }
          }
        }
        if (menuChoise.equals("vm")) {
          String email = menu.getUserInputString("Please write the email of the member you want to view: ");
          for (model.Member member : members) {
            if (email.equals(member.getEmail())) {
              menu.viewMember(member);
            }
          }
        }
        if (menuChoise.equals("vam")) {
          menu.viewAllMembers(members);
        }
        if (menuChoise.equals("vami")) {
          menu.viewAllMembersAndItems(members);
        }
        if (menuChoise.equals("i")) {
          model.Member owner = null;
          String ownerOfItem = menu.getUserInputString("Owners email: ");
          for (model.Member member : members) {
            if (ownerOfItem.equals(member.getEmail())) {
              owner = member;
            }
          }
          String category = menu.getUserInputString("Category: ");
          String name = menu.getUserInputString("Name: ");
          String description = menu.getUserInputString("Description: ");
          int price = menu.getUserInputInt("Price: ");

          createItem(category, name, description, price, day, owner);
        }
        if (menuChoise.equals("di")) {
          String itemId = menu.getUserInputString("Please write the item-ID of the item you want to delete: ");
          for (model.Member member : members) {
            List<model.Item> items = member.getItems();

            for (model.Item a : items) {
              if (a.getId().equals(itemId)) {
                member.removeOwnedItem(a);
              }
            }
          }
        }
        if (menuChoise.equals("ui")) {
          String itemId = menu.getUserInputString("Please write the item-ID of the item you want to update: ");
          String category = menu.getUserInputString("Category: ");
          String name = menu.getUserInputString("Name: ");
          String description = menu.getUserInputString("Description: ");
          int price = menu.getUserInputInt("Price: ");
          for (model.Member member : members) {
            List<model.Item> items = member.getItems();
            for (model.Item a : items) {
              if (a.getId().equals(itemId)) {
                a.setCategory(category);
                a.setName(name);
                a.setDescription(description);
                a.setPrice(price);
              }
            }
          }
        }
        if (menuChoise.equals("vi")) {
          String itemId = menu.getUserInputString("Please write the item-ID of the item you want to view: ");
          for (model.Member member : members) {
            List<model.Item> items = member.getItems();
            for (model.Item a : items) {
              if (a.getId().equals(itemId)) {
                menu.viewAnItem(a);
              }
            }
          }
        }
        if (menuChoise.equals("l")) {
          String email = menu.getUserInputString("Email of the lending member: ");
          model.Member lender = null;
          model.Item item = null;
          for (model.Member member : members) {
            if (email.equals(member.getEmail())) {
              lender = member;
            }
          }
          String itemId = menu.getUserInputString("ID of the item you want to lend:");
          for (model.Member member : members) {
            List<model.Item> items = member.getItems();

            for (model.Item a : items) {
              if (a.getId().equals(itemId)) {
                item = a;
              }
            }
          }
          int startDay = menu.getUserInputInt("From what day do you want to lend it? ");
          int endDay = menu.getUserInputInt("Till what day do you want to lend it? ");
          createContract(item, startDay, endDay, day, lender);

        }
        if (menuChoise.equals("q")) {
          break;
        }
      } catch (Exception e) {
        menu.printMessage(e.getMessage());
        continue;
      }
    }
    menu.printMessage("Thank you for using the stuff lending system and helping the enviroment!");
  }

  /**
   * A method that creates a member.
   *
   * @param name  The name of the member.
   * @param email The email of the member.
   * @param phone The phonenumber of the member.
   * @param day   Symbolising the day of creation.
   * @throws Exception if the member email, phonenumber or ID is not unique.
   */
  public model.Member createMember(String name, String email, String phone, Day day) throws Exception {
    model.Member member = new model.Member(name, email, phone);
    member.setDayOfCreation(day.getDay());
    member.setId();
    memberList.addMember(member);
    return member;
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
   * @throws Exception 
   */
  public model.Item createItem(String category, String name, String description, int price, Day day, Member owner) throws Exception {
    model.Item item = new model.Item(category, name, description, price);
    item.setDayOfCreation(day.getDay());
    item.setOwnedBy(owner);
    item.setId();
    String id = item.getId();
    List<model.Member> members = memberList.getMembers();
    for (model.Member member : members) {
      List<model.Item> items = member.getItems();

      for (model.Item a : items) {
        if (a.getId().equals(id)) {
          throw new Exception("Id must be unique.");
        }
      }
    }
    owner.addOwnedItem(item);
    return item;
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
  public model.Contract createContract(model.Item item, int startTime, int endTime, Day day, Member lender)
      throws Exception {
    if (lender.getCredit() < item.getPrice() * endTime - day.getDay()) {
      throw new Exception("Not enough credit.");
    }
    if (startTime < day.getDay()) {
      throw new Exception("Start time has expired.");
    }
    model.Contract contract = new model.Contract(item, startTime, endTime, lender);
    item.addContract(contract);
    contract.payCredit();
    return contract;
  }

}
