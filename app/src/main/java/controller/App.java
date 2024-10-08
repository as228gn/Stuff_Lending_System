package controller;

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
    MemberController controller = new MemberController();
    
    var member1 = controller.createMember("Anna", "emailo", "1293", day);
    var member2 = controller.createMember("Banna", "emaila", "1345", day);
    var member3 = controller.createMember("Canna", "email", "2345", day);
    
    var item1 = controller.createItem("Sport", "Ball", "Football", 5, day, member2);
    controller.createItem("Leisure", "Harry Potter", "Book", 50, day, member2);
    controller.createItem("Kitchen", "Pot", "Pot", 60, day, member1);

    controller.createContract(item1, 8, day, member1);
    controller.startMenu(day);

   
  }
}
