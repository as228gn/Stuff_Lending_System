package controller;

import model.Member;

public class Contract {

  public Contract() {}
  
    /**
   * A method that creates a contract.
   *
   * @param a contract.
   */
  public model.Contract createContract(model.Item item, int endTime, Day day, Member lender) {
    model.Contract contract = new model.Contract(item, endTime, lender);
    contract.setStartTime(day.getDay());
    contract.payCredit();
    item.setLendedTo(lender);
    item.addContract(contract);
    item.setLended();
    return contract;
  }
}
