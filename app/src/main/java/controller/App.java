package controller;

/**
 * Responsible for staring the application.
 */
public class App {
  /**
   * Application starting point.

   * @param args command line arguments.
   */
  public static void main(String[] args) {
    Day day = new Day(4);
    MemberController controller = new MemberController();
    var member1 = controller.createMember("Anna", "emailo", "1293", day);
    var member2 = controller.createMember("Banna", "emaila", "1345", day);
    controller.createMember("Canna", "email", "2345", day);
    
    var item1 = controller.createItem("Sport", "Ball", "Football", 5, day, member2);
    controller.createItem("Leisure", "Harry Potter", "Book", 1, day, member2);
    controller.createItem("Kitchen", "Pot", "Pot", 60, day, member1);

    controller.createContract(item1, 7, 10, day, member1);
    controller.createContract(item1, 11, 14, day, member1);
    controller.startMenu(day);

   
  }
}
