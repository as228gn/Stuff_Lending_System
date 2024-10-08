package controller;

import java.util.ArrayList;
import java.util.List;

import model.Member;

public class MemberController {
  model.MemberList memberList = new model.MemberList();
  model.Member memberModel = new model.Member();
  view.Menu menu = new view.Menu();

  public MemberController() {
  }

  public void startMenu(Day day) {
    while (true) {
      String menuChoise = menu.printMenu();
      List<model.Member> members = memberList.getMembers();
      if (menuChoise.equals("c")) {
        String name = menu.getUserInputString("Name: ");
        String email = menu.getUserInputString("Email: ");
        String phone = menu.getUserInputString("Phonenumber: ");
        createMember(name, email, phone, day);
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
        int endDay = menu.getUserInputInt("Till what day do you want to lend it? ");
        createContract(item, endDay, day, lender);

      }
      if (menuChoise.equals("q")) {
        break;
      }
    }
    System.out.println("Thank you for using the stuff lending system and helping the enviroment!");
  }

  /**
   * A method that creates a member.
   *
   * @param a member.
   */
  public model.Member createMember(String name, String email, String phone, Day day) {
    model.Member member = new model.Member(name, email, phone);
    member.setDayOfCreation(day.getDay());
    member.setId();
    memberList.addMember(member);
    return member;
  }

  /**
   * A method that updates a member.
   *
   * @param a member.
   */
  public void updateMember(String name, String email, String memberID) {

  }

  /**
   * A method that deletes a member.
   *
   * @param member The member object to delete.
   */
  public void deleteMember(model.Member member) {
    memberList.deleteMember(member);
  }

  public void ListAllItems() {
    List<model.Member> members = memberList.getMembers();
    for (model.Member member : members) {
      List<model.Item> items = member.getItems();

      for (model.Item a : items) {
        if (a.isAvaliable() == true) {
          System.out.println(a.toString());
        }
      }
    }
  }

  /**
   * A method that creates an item.
   *
   * @param a item.
   */
  public model.Item createItem(String category, String name, String description, int prize, Day day, Member owner) {
    model.Item item = new model.Item(category, name, description, prize);
    item.setDayOfCreation(day.getDay());
    item.setOwnedBy(owner);
    item.setId();
    String id = item.getId();
    List<model.Member> members = memberList.getMembers();
    for (model.Member member : members) {
      List<model.Item> items = member.getItems();

      for (model.Item a : items) {
        if (a.getId().equals(id)) {
          System.out.println("Id already exists.");
        }
      }
    }
    owner.addOwnedItem(item);
    return item;
  }

  public void ListItemsToLend(List<Member> members, Day day) {
    for (model.Member member : members) {
      List<model.Item> items = member.getItems();

      for (model.Item a : items) {
        List<model.Contract> contracts = a.getContracts();
        for (model.Contract contract : contracts) {
          if (contract.getEndTime() < day.getDay()) {
            a.setFree();
          }
        }
        if (a.isAvaliable() == true) {
          System.out.println(a.toString());
        }
      }
    }
  }

  /**
   * A method that creates a contract.
   *
   * @param a contract.
   */
  public model.Contract createContract(model.Item item, int endTime, Day day, Member lender) {
    List<model.Contract> contracts = item.getContracts();
    for (model.Contract contract : contracts) {
      if (contract.getEndTime() > day.getDay()) {
        System.out.println("Item not avaliable.");
      }
    }
    if (lender.getCredit() < item.getPrize() * endTime - day.getDay()) {
      System.out.println("Not enough credits.");
    }
    model.Contract contract = new model.Contract(item, endTime, lender);
    contract.setStartTime(day.getDay());
    contract.payCredit();
    item.setLendedTo(lender);
    item.addContract(contract);
    item.setLended();
    return contract;
  }

}
