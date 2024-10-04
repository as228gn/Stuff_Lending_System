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
    MemberController controller = new MemberController();
    Item itemController = new Item();
    var member1 = controller.createMember("Anna", "email");
    var member2 = controller.createMember("Banna", "email");
    var member3 = controller.createMember("Canna", "email");
    
    model.Item item1 = new model.Item("Sport", "Ball", "Football", 20);
    model.Item item2 = new model.Item("Leisure", "Harry Potter", "Book", 3);
    model.Item item3 = new model.Item("Kitchen", "Pot", "Pot", 60);
  
    member2.addOwnedItem(item3);
    member2.addOwnedItem(item2);
    member1.addOwnedItem(item1);
    //System.out.println(item.toString());
    List<model.Member> members = controller.getMembers();
    
    for (model.Member member : members) {
      System.out.println(member.toString());
      List<model.Item> items = member.getItems();

      for (model.Item a : items) {
        System.out.println(a.toString());
      }
    }

    controller.ListAllItems();
      
    // adapt to start the application in your way
    model.Simple m = new model.Simple();
    Simple c = new Simple();
    view.Simple v = new view.Simple();

    c.doSomethingSimple(m, v);
  }
}
