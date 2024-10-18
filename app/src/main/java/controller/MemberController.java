package controller;

import java.util.List;
import model.Day;

/**
 * A class called Membercontroller symbolising the controller.
 *
 */
public class MemberController {

  public MemberController() {
  }

  /**
   * A method that starts the application by telling the view to put out the menu.
   *
   * @param day The day counter, telling the application what day it is.
   * @throws Exception if the lender doesn´t have enough credit or if the
   *                   start-time has expired.
   */
  @SuppressWarnings("null")
  public void startMenu(model.MemberList memberList, view.Menu menu, Day day) throws Exception {
    while (true) {
      try {
        String menuChoise = menu.printMenu();
        List<model.Member> members = memberList.getMembers();
        if (menuChoise.equals("c")) {
          String name = menu.getUserInputString("Name: ");
          String email = menu.getUserInputString("Email: ");
          String phone = menu.getUserInputString("Phonenumber: ");
          memberList.createMember(name, email, phone, day);
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

          owner.createItem(category, name, description, price, day);
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
          model.Member owner = null;
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
          String owningMemberId = item.getOwnedBy();
          for (model.Member member : members) {
            if (owningMemberId.equals(member.getId())) {
              owner = member;
            }
          }
          int startDay = menu.getUserInputInt("From what day do you want to lend it? ");
          int endDay = menu.getUserInputInt("Till what day do you want to lend it? ");
          if (startDay < day.getDay()) {
            throw new Exception("Start time has expired.");
          }
          String ownerId = item.getOwnedBy();
          if (!ownerId.equals(lender.getId())) {
            if (lender.getCredit() < item.getPrice() * (endDay - day.getDay())) {
              throw new Exception("Not enough credit.");
            }
          }
          int priceToOwner = item.createContract(startDay, endDay, day, lender.getName());
          lender.setCredit(-priceToOwner);
          owner.setCredit(priceToOwner);

        }
        if (menuChoise.equals("d")) {
          int dayNumber = menu.getUserInputInt("What day would you like it to be?");
          day.setDay(dayNumber);
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
}
