package controller;

import model.Member;
import model.MemberList;
import view.Menu;

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
    model.MemberList memberList = new MemberList();
    view.Menu menu = new Menu();
    Day day = new Day(4);

    var joe = memberList.createMember("Joe", "joe.jones@email.com", "12938", day);
    var sara = memberList.createMember("Sara", "sara.smith@email.com", "13456", day);
    memberList.createMember("Benny", "benny.andersson@email.com", "23457", day);

    sara.createItem("Sport", "Ball", "Football", 5, day);
    sara.createItem("Leisure", "Harry Potter", "Book", 10, day);
    joe.createItem("Kitchen", "Pot", "Pot", 60, day);

    controller.startMenu(memberList, menu, day);
  }
}
