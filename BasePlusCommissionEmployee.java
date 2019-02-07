/*
Matt Butler 
2018
 */

public class BasePlusCommissionEmployee extends CommissionEmployee implements Payable{

    private double basePay;

	//constructor
    public BasePlusCommissionEmployee(String fName, String lName, String ssn, double grossSales, double commissionRate, double basePay){
        super(fName, lName, ssn, grossSales, commissionRate); //call super (parent) class

		//validate base pay
        if(basePay < 0.0){
            throw new IllegalArgumentException("Base pay must be above zero");
        }

        this.basePay = basePay;
    }

    public void setBasePay(double basePay){
		//validate base pay
        if(basePay < 0.0){
            throw new IllegalArgumentException("Base pay must be above zero");
        }

        this.basePay = basePay;
    }

    public double getBasePay(){
        return basePay;
    }

	//calculate earnings
    @Override
    public double earnings(){
       return getBasePay() + (getGrossSales() * getCommissionRate());
    }

	//format output
    @Override
    public String toString(){
        return String.format("%s %s %n%s: $%.2f", "Base Plus", super.toString(), "Base Pay", getBasePay());
    }

}
