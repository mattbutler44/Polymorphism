/*
Matt Butler 
2018
 */
 

public class PayableInterfaceTest{

//create several different types of "Payable" objects
    public static void main(String[] args){
        Payable[] payableObjects = new Payable[]{
                new Invoice("78A4", "Picture Frame", 20, 27.99),
                new Invoice("62F2", "Book", 15, 12.99),
				//Hourly employee under 40 hours
                new HourlyEmployee("Gary", "Pelfrey", "874-68-8214", 12.77, 38.4),
				//Hourly Employee with overtime to ensure proper overtime calculation
                new HourlyEmployee("Lindsay", "Lowell", "471-36-2099", 13.39, 44.6),
                new CommissionEmployee("Shawn", "Davidson", "257-91-0888", 13411.87, 0.115),
                new BasePlusCommissionEmployee("Dianne", "Kinzberg", "338-62-1574", 8741, 0.055, 700)
            };

            System.out.println("Different employees processed polymorphically:");

			//enhanced for loop to cycle through the array payableObjects
            for(Payable currentPayable : payableObjects){
                if(currentPayable instanceof BasePlusCommissionEmployee){
                    ((BasePlusCommissionEmployee) currentPayable).setBasePay(((BasePlusCommissionEmployee) currentPayable).getBasePay() * 1.1);
                }
                System.out.printf("%n%s %nPayment due: $%,.2f%n", currentPayable.toString(), currentPayable.getPaymentAmount());
            }//close loop
    } //close main
} //close class
