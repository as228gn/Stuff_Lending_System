package controller;

/**
 * Responsible for staring the application.
 */
public class App {
  /**
   * Application starting point.
   *
   * @param args command line arguments.
   */
  public static void main(String[] args) throws Exception {
    MemberController controller = new MemberController();
    Day day = new Day(4);

    var member1 = controller.createMember("Joe", "joe.jones@email.com", "12938", day);
    var member2 = controller.createMember("Sara", "sara.smith@email.com", "13456", day);
    controller.createMember("Benny", "benny.andersson@email.com", "23457", day);

    var item1 = controller.createItem("Sport", "Ball", "Football", 5, day, member2);
    controller.createItem("Leisure", "Harry Potter", "Book", 10, day, member2);
    controller.createItem("Kitchen", "Pot", "Pot", 60, day, member1);

    controller.createContract(item1, 7, 10, day, member1);
    controller.startMenu(day);
  }
}
