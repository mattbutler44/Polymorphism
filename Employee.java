/*
Matt Butler 
2018
 */
 
 
//defines the structure of an Employee
public abstract class Employee implements Payable{

    private String firstName, lastName, socialSecurityNumber;

	//constructor
    public Employee(String fName, String lName, String ssn){
        firstName = fName;
        lastName = lName;
        socialSecurityNumber = ssn;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getSocialSecurityNumber(){
        return socialSecurityNumber;
    }

    public void setFirstName(String fName){
        firstName = fName;
    }

    public void setLastName(String lName){
        lastName = lName;
    }

    public abstract double earnings();

    @Override
    public String toString(){
        return String.format("%s: %s %s %n%s: %s ", "Employee", getFirstName(), getLastName(), "Social Security Number", getSocialSecurityNumber());
    }

    @Override
    public double getPaymentAmount(){
        return earnings();
    }
}
