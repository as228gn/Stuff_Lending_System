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
   */
  public static void main(String[] args) {
    Member controller = new Member();
    Item itemController = new Item();
    var member1 = controller.createMember("Anna", "email");
    var member2 = controller.createMember("Banna", "email");
    var member3 = controller.createMember("Canna", "email");
    
    var item1 = itemController.createItem("Sport", "Ball", "Football", 20, member1);
    var item2 = itemController.createItem("Leisure", "Harry Potter", "Book", 3, member1);
    var item3 = itemController.createItem("Kitchen", "Pot", "Pot", 60, member2);
    //System.out.println(item.toString());
    List<model.Member> members = controller.getMembers();
    
    for (model.Member member : members) {
      System.out.println(member.toString());
      List<model.Item> items = member.getItems();

      for (model.Item a : items) {
        System.out.println(a.toString());
      }
    }

    itemController.deleteItem(item1);

    for (model.Member member : members) {
      System.out.println(member.toString());
      List<model.Item> items = member.getItems();

      for (model.Item a : items) {
        System.out.println(a.toString());
      }
    }

      
    // adapt to start the application in your way
    model.Simple m = new model.Simple();
    Simple c = new Simple();
    view.Simple v = new view.Simple();

    c.doSomethingSimple(m, v);
  }
}
