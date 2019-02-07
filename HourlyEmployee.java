/*
Matt Butler 
2018
 */

public class HourlyEmployee extends Employee implements Payable{

	//instance variables
    private double wage, hours;
    private static final double MIN_WAGE = 2.13; //this is the minimum wage for servers, the lowest realistic wage I could find (for the U.S.)
    private static final double OVERTIME_MULTIPLIER = 1.5;
    private static final double OVERTIME_CUTOFF = 40;
    private static final double HOURS_IN_WEEK = 168;

	//constructor
    public HourlyEmployee(String fName, String lName, String ssn, double wage, double hours) {
		//call super (parent) class
        super(fName, lName, ssn);

		//validate wage
        if(wage >= MIN_WAGE){
            this.wage = wage;
        }
        else{
            throw new IllegalArgumentException("Wage cannot be below minimum wage: " + MIN_WAGE);
        }

		//validate hours worked
        if(hours >= 0 && hours <= HOURS_IN_WEEK){
            this.hours = hours;
        }
        if(hours < 0){
            throw new IllegalArgumentException("Hours must be above zero.");
        }
		if(hours > HOURS_IN_WEEK){
			throw new IllegalArgumentException("Hours cannot be greater than the number of hours in a week: " + HOURS_IN_WEEK);
		}
    } //close constructor

	//setter methods
	
    public void setWage(double wage){
		//validate wage
        if(wage >= MIN_WAGE) {
            this.wage = wage;
        }
        else{
            throw new IllegalArgumentException("Wage cannot be below minimum wage: " + MIN_WAGE);
        }
    }

    public void setHours(double hours){
		//validate hours
        if(hours >= 0 && hours < HOURS_IN_WEEK){
            this.hours = hours;
        }
		
        if(hours < 0){
            throw new IllegalArgumentException("Hours must be above zero.");
        }
		
		if(hours > HOURS_IN_WEEK){
			throw new IllegalArgumentException("Hours cannot be greater than the number of hours in a week: " + HOURS_IN_WEEK);
		}
    }

	//getter methods
	
    public double getWage(){
        return wage;
    }

    public double getHours(){
        return hours;
    }

	//override (define) earnings method
    @Override
    public double earnings(){
		//calculate wage without overtime
        if(hours <= OVERTIME_CUTOFF){
            return getWage() * getHours();
        }

		//calculate wage with overtime
        else{       // regular wage for first 40 hrs + (overtime wage * hours above 40)
            return (getWage() * OVERTIME_CUTOFF) + ((getWage() * OVERTIME_MULTIPLIER) * (getHours() - OVERTIME_CUTOFF));
        }
    }

	//format output
    @Override
    public String toString(){
        return String.format("%s %s%n%s: $%.2f %n%s: %.2f", "Hourly", super.toString(),
                "Wage", getWage(), "Hours Worked", getHours());
    }
}
