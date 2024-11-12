package controller;

import model.Category;
import model.Day;
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
    model.MemberList memberList = new MemberList();
    model.Day day = new Day(4);
    MemberController controller = new MemberController();
    
    var joe = memberList.createMember("Joe", "joe.jones@email.com", "12938", day);
    joe.createItem(Category.OTHER, "Pot", "Pot", 60, day);
    
    var sara = memberList.createMember("Sara", "sara.smith@email.com", "13456", day);
    sara.createItem(Category.SPORT, "Ball", "Football", 5, day);
    sara.createItem(Category.OTHER, "Harry Potter", "Book", 10, day);

    memberList.createMember("Benny", "benny.andersson@email.com", "23457", day);
    
    view.Menu menu = new Menu();
    controller.startMenu(memberList, menu, day);
  }
}
