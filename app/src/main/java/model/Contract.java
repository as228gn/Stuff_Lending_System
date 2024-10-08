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
    if (owner == lender) {
      return;
    }
    int price = this.item.getPrice();
    int lendedDays = endTime - startTime;
    int prizeToOwner = lendedDays * price;
    System.out.println(startTime);
    owner.setCredit(prizeToOwner);
    lender.setCredit(-prizeToOwner);
  }

  /**
   * A method that gets the item.
   *
   * @return an item.
   */
  public Item getItem() {
    return this.item;
  }

  /**
   * A method that sets the starttime.
   *
   * @param startTime The starttime of the contract.
   */
  public void setStartTime(int startTime) {
    this.startTime = startTime;
  }

  /**
   * A method that gets the startTime.
   *
   * @return The starttime of the contrct.
   */
  public int getStartTime() {
    return this.startTime;
  }

  /**
   * A method that sets the endtime.
   *
   * @param endTime The endtime of the contract.
   */
  public void setEndTime(int endTime) {
    this.endTime = endTime;
  }

  /**
   * A method that gets the endtime.
   *
   * @return The endtime of the contract.
   */
  public int getEndTime() {
    return this.endTime;
  }

  /**
   * A method that sets the lender.
   *
   * @param lender The lending member.
   */
  public void setLendedTo(Member lender) {
    this.lender = lender;
  }

  /**
   * A method that gets the lending member.
   *
   * @return The lending member.
   */
  public Member getMember() {
    return this.lender;
  }

  @Override
  public String toString() {
    return "      Lended to: " + lender.getName() + ", StartTime: " + getStartTime() + ", EndTime: " + getEndTime();
  }
}
