package model;

/**
 * A class symbolising a contract called contract.
 *
 */
public class Contract {
  private int startTime;
  private int endTime;
  private String lenderName;

  /**
   * Constructor of contract.
   *
   * @param startTime The startTime of the loan.
   * @param endTime The endtime of the loan.
   * @param lenderName The name of the lender.
   */
  public Contract(int startTime, int endTime, String lenderName) {
    this.startTime = startTime;
    this.endTime = endTime;
    this.lenderName = lenderName;
  }

  public Contract contractCopy() {
    return new Contract(this.startTime, this.endTime, this.lenderName);
  }

  public int getStartTime() {
    return this.startTime;
  }

  /**
   * A method that gets the endtime.
   *
   * @return The endtime of the contract.
   */
  public int getEndTime() {
    return this.endTime;
  }

  @Override
  public String toString() {
    return "      Lended to: " + lenderName + ", StartTime: " + getStartTime() + ", EndTime: " + getEndTime();
  }
}
