/*
Matt Butler 
2018
 */

 
public class Invoice implements Payable{

    //instance variables
    private final String partNumber;
    private final String partDescription;
    private final int quantity;
    private final double pricePerItem;

    //constructor
    public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem){

		//validate input
        if(quantity < 0){
            throw new IllegalArgumentException("Quantity cannot be less than 0");
        }

        if(pricePerItem < 0){
            throw new IllegalArgumentException("Price cannot be less than 0");
        }

		//construct the object
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    //getter methods
    public String getPartNumber(){
        return partNumber;
    }

    public String getPartDescription(){
        return partDescription;
    }

    public int getQuantity(){
        return quantity;
    }

    public double getPricePerItem(){
        return pricePerItem;
    }

	//format the output
    @Override
    public String toString(){
        return String.format("%s: %n%s: %s (%s) %n%s: %d %n%s: $%,.2f", "Invoice", "Part Number", getPartNumber(),
                getPartDescription(), "Quantity", getQuantity(), "Price Per Item", getPricePerItem());
    }

	//calculate payment amount
    @Override
    public double getPaymentAmount(){
        return getQuantity() * getPricePerItem();
    }

}
