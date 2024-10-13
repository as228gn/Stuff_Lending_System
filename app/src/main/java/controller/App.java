package controller;

import model.Member;

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
    model.Member member = new Member();
    Day day = new Day(4);

    controller.createMember("Joe", "joe.jones@email.com", "12938", day);
    controller.createMember("Sara", "sara.smith@email.com", "13456", day);
    controller.createMember("Benny", "benny.andersson@email.com", "23457", day);

    member.createItem("Sport", "Ball", "Football", 5, day);
    member.createItem("Leisure", "Harry Potter", "Book", 10, day);
    member.createItem("Kitchen", "Pot", "Pot", 60, day);

    //controller.createContract(item1, 7, 10, day, member1);
    controller.startMenu(day);
  }
}
