package controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Responsible for staring the application.
 */
public class App {
  /**
   * Application starting point.

   * @param args command line arguments.
   * @throws Exception 
   */
  public static void main(String[] args) {
    Day day = new Day(6);
    Menu menu = new Menu(day);
    menu.startMenu();
    // MemberController controller = new MemberController();
    // Contract contract = new Contract();
    // Item itemController = new Item();
    // var member1 = controller.createMember("Anna", "emailo", 2376, day);
    // var member2 = controller.createMember("Banna", "emaila", 2378, day);
    // var member3 = controller.createMember("Canna", "email", 2347, day);

    // var item1 = itemController.createItem("Sport", "Ball", "Football", 5, day, member2);
    // itemController.createItem("Leisure", "Harry Potter", "Book", 50, day, member2);
    // itemController.createItem("Kitchen", "Pot", "Pot", 60, day, member1);

    // contract.createContract(item1, 8, day, member1);
    

    //System.out.println(item.toString());
    // List<model.Member> members = controller.getMembers();
    
    // for (model.Member member : members) {
    //   System.out.println(member.toString());
    //   List<model.Item> items = member.getItems();

    //   for (model.Item a : items) {
    //     System.out.println(a.toString());

    //     List<model.Contract> contracts = a.getContracts();
    //     for (model.Contract c : contracts) {
    //       System.out.println(c.toString());
    //     }
    //   }
    // }

    //itemController.ListItemsToLend(members, day);
      
    // adapt to start the application in your way
    model.Simple m = new model.Simple();
    Simple c = new Simple();
    view.Simple v = new view.Simple();

    c.doSomethingSimple(m, v);
  }
}
