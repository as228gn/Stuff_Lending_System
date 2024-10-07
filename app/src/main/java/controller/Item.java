package controller;

import java.util.List;

import model.Member;

/**
 * A class symbolising an item called Item.
 *
 */
public class Item {

  public Item() {
  }

  /**
   * A method that creates an item.
   *
   * @param a item.
   */
  public model.Item createItem(String category, String name, String description, int prize, Day day, Member owner) {
    model.Item item = new model.Item(category, name, description, prize);
    item.setDayOfCreation(day.getDay());
    item.setOwnedBy(owner);
    owner.addOwnedItem(item);
    return item;
  }

  public void viewAllItems(List<Member> members){
    for (model.Member member : members) {
      System.out.println(member.toString());
      List<model.Item> items = member.getItems();

      for (model.Item a : items) {
        System.out.println(a.toString());
      }
    }
  }

  public void ListItemsToLend(List<Member> members, Day day) {
    for (model.Member member : members) {
      List<model.Item> items = member.getItems();

      for (model.Item a : items) {
        List<model.Contract> contracts = a.getContracts();
        for (model.Contract contract : contracts) {
          if (contract.getEndTime() < day.getDay()) {
            a.setFree();
          }
        }
        if (a.isAvaliable() == true) {
          System.out.println(a.toString());
        }
      }
    }
  }
}
