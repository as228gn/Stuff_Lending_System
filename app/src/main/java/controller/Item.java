package controller;

import java.util.List;

import model.Member;

/**
 * A class symbolising an item called Item.
 *
 */
public class Item {

  public Item(){}

  public void ListAllItems(List<Member> members) {
    for (model.Member member : members) {
      List<model.Item> items = member.getItems();

      for (model.Item a : items) {
        System.out.println(a.toString());
      }
    }
  }
}
