package view;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import model.Category;

/**
 * A class symbolising the view called Menu.
 *
 */
public class Menu {

  Scanner scanner = new Scanner(System.in);

  /**
   * A method that prints a menu to the console.
   *
   * @return The menuchoise.
   * @throws IOException Throws exception.
   */
  public MenuChoise printMenu() throws IOException {
    System.out.println("");
    System.out.println("Welcome to the stuff lending system!");
    System.out.println("Press c to create a member:");
    System.out.println("Press d to delete a member:");
    System.out.println("Press u to update a member:");
    System.out.println("Press v to view a member:");
    System.out.println("Press a to view all members");
    System.out.println("Press t to view all members and their items:");
    System.out.println("Press i to create an item:");
    System.out.println("Press e to delete an item:");
    System.out.println("Press p to update an item:");
    System.out.println("Press y to view an item:");
    System.out.println("Press l to lend an item:");
    System.out.println("Press f to advance the day:");
    System.out.print("Press q to quit: ");
    System.out.println("");

    String choise = scanner.nextLine();

    if (choise.equals("c")) {
      return MenuChoise.CREATE_MEMBER;
  } else if (choise.equals("d")) {
      return MenuChoise.DELETE_MEMBER;
  } else if (choise.equals("u")) {
      return MenuChoise.UPDATE_MEMBER;
  } else if (choise.equals("v")) {
      return MenuChoise.VIEW_MEMBER;
  } else if (choise.equals("a")) {
      return MenuChoise.VIEW_ALL_MEMBERS;
  } else if (choise.equals("t")) {
      return MenuChoise.VIEW_ALL_MEMBERS_ITEMS;
  } else if (choise.equals("i")) {
      return MenuChoise.CREATE_ITEM;
  } else if (choise.equals("e")) {
      return MenuChoise.DELETE_ITEM;
  } else if (choise.equals("p")) {
      return MenuChoise.UPDATE_ITEM;
  } else if (choise.equals("y")) {
      return MenuChoise.VIEW_ITEM;
  } else if (choise.equals("l")) {
      return MenuChoise.LEND_ITEM;
  } else if (choise.equals("f")) {
      return MenuChoise.ADVANCE_DAY;
  } else if (choise.equals("q")) {
      return MenuChoise.QUIT;
  } else {
      return MenuChoise.INVALID;
  }
  }

  public Category chooseCategory() throws IOException {
    System.out.println("Choose your category");
    System.out.println("Press t for tool");
    System.out.println("Press v for vehicle");
    System.out.println("Press g for game");
    System.out.println("Press y for toy");
    System.out.println("Press s for sport");
    System.out.println("Press o for other");

    String choise = scanner.nextLine();

    if (choise.equals("t")) {
      return Category.TOOL;
  } else if (choise.equals("v")) {
      return Category.VEHICLE;
  } else if (choise.equals("g")) {
      return Category.GAME;
  } else if (choise.equals("y")) {
      return Category.TOY;
  } else if (choise.equals("s")) {
      return Category.SPORT;
  } else if (choise.equals("o")) {
      return Category.OTHER;
  } else {
      return Category.INVALID;
  }
  }

  public String getUserInputString(String message) {
    System.out.println(message);
    return scanner.nextLine();
  }

  public int getUserInputInt(String message) {
    System.out.println(message);
    return scanner.nextInt();
  }

  public void printMessage(String message) {
    System.out.println(message);
  }

  /**
   * A method that views a member.
   *
   * @param member The member to be viewed.
   */
  public void viewMember(model.Member member) {
    System.out.println(member.fullInformation());
  }

  /**
   * A method that views all the members.
   *
   * @param members The members to be viewed.
   */
  public void viewAllMembers(List<model.Member> members) {
    for (model.Member member : members) {
      System.out.println(member.toString());
    }
  }

  /**
   * A method that views all the members and their items.
   *
   * @param members The members to be viewed.
   */
  public void viewAllMembersAndItems(List<model.Member> members) {
    for (model.Member member : members) {
      System.out.println(member.toString());
      List<model.Item> items = member.getItems();
      for (model.Item a : items) {
        System.out.println(a.toString());
        List<model.Contract> contracts = a.getContracts();
        for (model.Contract c : contracts) {
          System.out.println(c.toString());
        }
      }
    }
  }

  /**
   * A method that views an item.
   *
   * @param item The item to be viewed.
   */
  public void viewAnItem(model.Item item) {
    System.out.println(item.toString());
    List<model.Contract> contracts = item.getContracts();
    for (model.Contract c : contracts) {
      System.out.println(c.toString());
    }
  }
}
