package view;

import java.util.Scanner;
import java.util.List;

public class Menu {

  Scanner scanner = new Scanner(System.in);
  /**
   * Shows a menu by printing it to the console.

   * @return The chosen option.
   */
  public String printMenu() {
    
    System.out.println("Welcome to the stuff lending system!");
    System.out.print("\nPress c to create a member:\nPress dm to delete a member:\nPress um to update a member:\nPress vm to view a member:\nPress vam to view all members\nPress vami to view all members and their items:\nPress i to create an item:\nPress di to delete an item:\nPress ui to update an item:\nPress vi to view an item:\nPress l to lend an item:");
    System.out.print("Press q to quit: ");
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

  public void viewMember(model.Member member) {
    System.out.println(member.fullInformation());
  }

  public void viewAllMembers(List<model.Member> members) {
    for (model.Member member : members) {
      System.out.println(member.toString());
    }
  }

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



}
