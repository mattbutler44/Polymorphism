/*
Matt Butler 
2018
 */

public class CommissionEmployee extends Employee implements Payable{

    private double grossSales, commissionRate;

	//constructor
    public CommissionEmployee(String fName, String lName, String ssn, double grossSales, double commissionRate){
        super(fName, lName, ssn); //call super (parent) class
		//validate sales
        if(grossSales > 0){
            this.grossSales = grossSales;
        }
        else{
            throw new IllegalArgumentException("Gross sales must be above zero");
        }

		//validate commissions
        if(commissionRate >= 0.0 && commissionRate < 1.0){ //don't allow negative commissions, nor 100%, which seems unrealistic
            this.commissionRate = commissionRate;
        }
        else{
            throw new IllegalArgumentException("Commission rate must be above 0 and below 1.0 (0.15 = 15%)");
        }
    }

    public void setGrossSales(double sales){
		//validate sales
        if(sales > 0){
            grossSales = sales;
        }
        else{
            throw new IllegalArgumentException("Gross sales must be above zero");
        }
    }

    public void setCommissionRate(double rate){
		//validate commission rate
        if(rate > 0 && rate < 1.0){
            commissionRate = rate;
        }
        else{
            throw new IllegalArgumentException("Commission rate must be above 0 and below 1.0 (0.15 = 15%)");
        }
    }

    public double getGrossSales(){
        return grossSales;
    }

    public double getCommissionRate(){
        return commissionRate;
    }

	//calculate earnings
    public double earnings(){
        return getGrossSales() * getCommissionRate();
    }

	//format output
    @Override
    public String toString(){
        return String.format("%s %s%n%s: $%.2f %n%s: %.2f", "Commission-based", super.toString(),
                "Gross Sales", getGrossSales(), "Commission Rate", getCommissionRate());
    }

}
