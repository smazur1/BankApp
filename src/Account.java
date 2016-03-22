

public class Account {        
	private String accountId;
    private String accountNum;
    private double balance;
    private String custId;
    private String accountType;
    
    
    
    
    Account(){}    
    
    public Account(String accountId1, String accountNum1, 
    		double balance1, String custId1, String accountType1 ){
        accountId=accountId1;
        accountNum=accountNum1;
        balance=balance1;
        custId=custId1;
        accountType=accountType1;
        
    }   
    
    public String getAccountId() {
        return accountId;
    }
    
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    } 
    
    public String getAccountNum() {
        return accountNum;
    }
    
    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public String getCustId() {
        return custId;
    } 
    
    public void setCustId(String custId) {
        this.custId = custId;
    } 
    
    public String getAccountType() {
        return accountType;
    } 
    
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    } 
    
    public void setInDatabase(boolean b) {
        // TODO Auto-generated method stub
        
    }
    }