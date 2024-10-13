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

  /**
   * Constructor of contract.
   *
   * @param item The item being lended.
   * @param endTime The endtime of the loan.
   * @param lender The lender of the item.
   */
  public Contract(Item item, int startTime, int endTime, Member lender) {
    this.item = item;
    this.startTime = startTime;
    this.endTime = endTime;
    this.lender = lender;
  }

  /**
   * A method that pays credit to the owner and deducts credit from the lender.
   *
   */
  public void payCredit() {
    Member owner = this.item.getOwnedBy();
    if (owner.getId().equals(lender.getId())) {
      return;
    }
    int price = this.item.getPrice();
    int lendedDays = endTime - startTime;
    int prizeToOwner = lendedDays * price;
    owner.setCredit(prizeToOwner);
    lender.setCredit(-prizeToOwner);
  }

  // public Item getItem() {
  //   return new Item(item);
  // }


  // public void setStartTime(int startTime) {
  //   this.startTime = startTime;
  // }

  public int getStartTime() {
    return this.startTime;
  }

  // public void setEndTime(int endTime) {
  //   this.endTime = endTime;
  // }

  /**
   * A method that gets the endtime.
   *
   * @return The endtime of the contract.
   */
  public int getEndTime() {
    return this.endTime;
  }

  // public void setLendedTo(Member lender) {
  //   this.lender = new Member(lender);
  // }

  /**
   * A method that gets the lending member.
   *
   * @return The lending member.
   */
  // public Member getMember() {
  //   return new Member(lender);
  // }

  @Override
  public String toString() {
    return "      Lended to: " + lender.getName() + ", StartTime: " + getStartTime() + ", EndTime: " + getEndTime();
  }
}
