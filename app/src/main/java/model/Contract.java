package model;

/**
 * A class symbolising a contract called contract.
 *
 */
public class Contract {
  private Item item;
  private int startTime;
  private int endTime;
  private Member lender;

  public Contract(Item item, int startTime, int endTime, Member lender) {
    if(item.getPrize() < lender.getCredit()) {
      System.out.println("Får ej låna");
    }
    this.item = item;
    this.startTime = startTime;
    this.endTime = endTime;
    this.lender = lender;
  }

  public Item getItem() {
    return this.item;
  }

  public int getStarTime() {
    return this.startTime;
  }

  public int getEndTime() {
    return this.endTime;
  }

  public Member getMember() {
    return this.lender;
  }
}
