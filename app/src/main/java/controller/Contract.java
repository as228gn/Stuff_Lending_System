package controller;

import java.util.List;

import model.Member;

public class Contract {

  public Contract() {}
  
    /**
   * A method that creates a contract.
   *
   * @param a contract.
   */
  public model.Contract createContract(model.Item item, int endTime, Day day, Member lender) {
    List<model.Contract> contracts = item.getContracts();
        for (model.Contract contract : contracts) {
          if (contract.getEndTime() > day.getDay()) {
            System.out.println("Item not avaliable.");
          }}
    if(lender.getCredit() < item.getPrize() * endTime - day.getDay()){
      System.out.println("Not enough credits.");
    }
    model.Contract contract = new model.Contract(item, endTime, lender);
    contract.setStartTime(day.getDay());
    contract.payCredit();
    item.setLendedTo(lender);
    item.addContract(contract);
    item.setLended();
    return contract;
  }
}
