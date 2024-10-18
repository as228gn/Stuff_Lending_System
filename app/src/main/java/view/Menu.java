package view;

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
   */
  public String printMenu() {
    System.out.println("");
    System.out.println("Welcome to the stuff lending system!");
    System.out.println("Press c to create a member:");    
    System.out.println("Press dm to delete a member:");    
    System.out.println("Press um to update a member:");    
    System.out.println("Press vm to view a member:");    
    System.out.println("Press vam to view all members");    
    System.out.println("Press vami to view all members and their items:");    
    System.out.println("Press i to create an item:");
    System.out.println("Press di to delete an item:");    
    System.out.println("Press ui to update an item:");    
    System.out.println("Press vi to view an item:");   
    System.out.println("Press l to lend an item:");
    System.out.println("Press d to advance the day:");     
    System.out.print("Press q to quit: ");
    System.out.println("");
    String menuChoise = scanner.nextLine();
    return menuChoise;
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
