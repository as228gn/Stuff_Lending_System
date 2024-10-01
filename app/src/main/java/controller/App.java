package controller;

import model.Item;

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
    var member1 = controller.createMember("Anna", "email");
    var member2 = controller.createMember("Banna", "email");
    var member3 = controller.createMember("Canna", "email");
    model.Item item = new model.Item("Sport", "Ball", "Football", 20, member1);
    member1.setItem(item);
    controller.deleteMember(member1);
    // adapt to start the application in your way
    model.Simple m = new model.Simple();
    Simple c = new Simple();
    view.Simple v = new view.Simple();

    c.doSomethingSimple(m, v);
  }
}
