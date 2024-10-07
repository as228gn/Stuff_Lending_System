package controller;

public class Menu {
  view.Menu menu = new view.Menu();

  public void startMenu(){
    String menuChoise = menu.printMenu();
    if (menuChoise == "c") {
      
      

      menu.createMember();

    }
  }
}
