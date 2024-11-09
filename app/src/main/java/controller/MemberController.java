package controller;

import java.util.List;
import model.Day;
import view.MenuChoise;

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
        MenuChoise menuChoise = menu.printMenu();
        List<model.Member> members = memberList.getMembers();
        if (menuChoise == MenuChoise.CREATE_MEMBER) {
          String name = menu.getUserInputString("Name: ");
          String email = menu.getUserInputString("Email: ");
          String phone = menu.getUserInputString("Phonenumber: ");
          memberList.createMember(name, email, phone, day);
        }
        if (menuChoise == MenuChoise.DELETE_MEMBER) {
          String email = menu.getUserInputString("Please write the email of the member you want to delete: ");
          for (model.Member member : members) {
            if (email.equals(member.getEmail())) {
              memberList.deleteMember(member);
            }
          }
        }
        if (menuChoise == MenuChoise.UPDATE_MEMBER) {
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
        if (menuChoise == MenuChoise.VIEW_MEMBER) {
          String email = menu.getUserInputString("Please write the email of the member you want to view: ");
          for (model.Member member : members) {
            if (email.equals(member.getEmail())) {
              menu.viewMember(member);
            }
          }
        }
        if (menuChoise == MenuChoise.VIEW_ALL_MEMBERS) {
          menu.viewAllMembers(members);
        }
        if (menuChoise == MenuChoise.VIEW_ALL_MEMBERS_ITEMS) {
          menu.viewAllMembersAndItems(members);
        }
        if (menuChoise == MenuChoise.CREATE_ITEM) {
          model.Member owner = null;
          String ownerOfItem = menu.getUserInputString("Owners email: ");
          for (model.Member member : members) {
            if (ownerOfItem.equals(member.getEmail())) {
              owner = member;
            }
          }
          
          String name = menu.getUserInputString("Name: ");
          String description = menu.getUserInputString("Description: ");
          int price = menu.getUserInputInt("Price: ");
          model.Category category = menu.chooseCategory();

          owner.createItem(category, name, description, price, day);
        }
        if (menuChoise == MenuChoise.DELETE_ITEM) {
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
        // if (menuChoise == MenuChoise.UPDATE_ITEM) {
        //   String itemId = menu.getUserInputString("Please write the item-ID of the item you want to update: ");
        //   String category = menu.getUserInputString("Category: ");
        //   String name = menu.getUserInputString("Name: ");
        //   String description = menu.getUserInputString("Description: ");
        //   int price = menu.getUserInputInt("Price: ");
        //   for (model.Member member : members) {
        //     List<model.Item> items = member.getItems();
        //     for (model.Item a : items) {
        //       if (a.getId().equals(itemId)) {
        //         a.setCategory(category);
        //         a.setName(name);
        //         a.setDescription(description);
        //         a.setPrice(price);
        //       }
        //     }
        //   }
        // }
        if (menuChoise == MenuChoise.VIEW_ITEM) {
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
        if (menuChoise == MenuChoise.LEND_ITEM) {
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
        if (menuChoise == MenuChoise.ADVANCE_DAY) {
          int dayNumber = menu.getUserInputInt("What day would you like it to be?");
          day.setDay(dayNumber);
        }
        if (menuChoise == MenuChoise.QUIT) {
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
