package view;

import java.util.Scanner;

import controller.MemberController;

public class Menu {
  controller.MemberController memberC = new MemberController();

  Scanner scanner = new Scanner(System.in);
  /**
   * Shows a menu by printing it to the console.

   * @return The chosen option.
   */
  public String printMenu() {
    
    System.out.println("Welcome to the stuff lending system!");
    System.out.print("\nPress c to create a member:\nPress i to create an item:\n");
    System.out.print("Press q to quit: ");
    String menuchoise = scanner.nextLine();
    
    scanner.close();
    return menuchoise;
    
  }

  public String getUserInputString(String message)
  {
    System.out.println(message);
    return scanner.nextLine();
  }

  public void createMember() {
    System.out.println("To create a member please write:");
    System.out.println("Name: ");
    String name = scanner.nextLine();
    System.out.println("Email: ");
    String email = scanner.nextLine();
    System.out.println("Phonenumber: ");
    int phone = scanner.nextInt();

    memberC.createMember(name, email, phone);

  }
}
