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

  public Contract(Item item, int endTime, Member lender) {
    if(item.getPrize() > lender.getCredit()) {
      System.out.println("Får ej låna");
    }
    this.item = item;
    this.endTime = endTime;
    this.lender = lender;
  }

  public void payCredit() {
    Member owner = this.item.getOwnedBy();
    int prize = this.item.getPrize();
    int lendedDays = endTime - startTime;
    int prizeToOwner = lendedDays * prize;
    System.out.println(startTime);
    owner.setCredit(prizeToOwner);
    lender.setCredit(-prizeToOwner);
  }

  public Item getItem() {
    return this.item;
  }

  public void setStartTime(int startTime) {
    this.startTime = startTime;
  }
  public int getStarTime() {
    return this.startTime;
  }

  public void setEndTime(int endTime){
    this.endTime = endTime;
  }

  public int getEndTime() {
    return this.endTime;
  }

  public void setLendedTo(Member lender) {
    this.lender = lender;
  }

  public Member getMember() {
    return this.lender;
  }

  @Override
  public String toString() {
    return "   " + getItem() + ", StartTime: " + getStarTime() + ", EndTime: " + getEndTime();
  }
}
