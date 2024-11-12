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
    MemberController controller = new MemberController();
    model.MemberList memberList = new MemberList();
    view.Menu menu = new Menu();
    model.Day day = new Day(4);

    // var joe = memberList.createMember("Joe", "joe.jones@email.com", "12938", day);
    // var sara = memberList.createMember("Sara", "sara.smith@email.com", "13456", day);
    // memberList.createMember("Benny", "benny.andersson@email.com", "23457", day);

    // sara.createItem(Category.SPORT, "Ball", "Football", 5, day);
    // sara.createItem(Category.OTHER, "Harry Potter", "Book", 10, day);
    // joe.createItem(Category.OTHER, "Pot", "Pot", 60, day);
    
    model.MemberList memberListCopy = memberList.deepCopy();
    controller.startMenu(memberListCopy, menu, day);
  }
}
