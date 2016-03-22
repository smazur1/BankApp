

public class BankCust {
    private String custId;
    private String lastName;
    private String firstName;
    
    
    
    
    BankCust(){}    public BankCust(String custId1, String lastName1, String firstName1 ){
        custId=custId1;
        lastName=lastName1;
        firstName= firstName1;
    }
    
    public String getCustId() {
        return custId;
    }    public void setCustId(String custId) {
        this.custId = custId;
    }    public String getLastName() {
        return lastName;
    }    public void setLastName(String lastName) {
        this.lastName = lastName;
    }    public String getFirstName() {
        return firstName;
    }    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }    public void setInDatabase(boolean b) {
        // TODO Auto-generated method stub
        
    }
}