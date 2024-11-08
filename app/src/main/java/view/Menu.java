package view;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

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
   * @throws IOException 
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

    int choise = System.in.read();
    while (choise == '\r' || choise == '\n') {
      choise = System.in.read();
    }

    if (choise == 'c') {
      return MenuChoise.CREATE_MEMBER;
    } else if (choise == 'd') {
      return MenuChoise.DELETE_MEMBER;
    } else if (choise == 'u') {
      return MenuChoise.UPDATE_MEMBER;
    } else if (choise == 'v') {
      return MenuChoise.VIEW_MEMBER;
    } else if (choise == 'a') {
      return MenuChoise.VIEW_ALL_MEMBERS;
    } else if (choise == 't') {
      return MenuChoise.VIEW_ALL_MEMBERS_ITEMS;
    } else if (choise == 'i') {
      return MenuChoise.CREATE_ITEM;
    } else if (choise == 'e') {
      return MenuChoise.DELETE_ITEM;
    } else if (choise == 'p') {
      return MenuChoise.UPDATE_ITEM;
    } else if (choise == 'y') {
      return MenuChoise.VIEW_ITEM;
    } else if (choise == 'l') {
      return MenuChoise.LEND_ITEM;
    } else if (choise == 'f') {
      return MenuChoise.ADVANCE_DAY;
    } else if (choise == 'q') {
      return MenuChoise.QUIT;
    }
    return MenuChoise.INVALID;
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
