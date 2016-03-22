
	
	public class Trans {    private String accountId;
    private String transType;
    private double amount;
    private int checkNum;
//    private date checkDate;
//    private date transDate;    
    Trans(){}    public Trans(String transId1, String accountId1, String transType1, double amount1, int checkNum1){
        transId=transId1;
        accountId=accountId1;
        transType=transType1;
        amount=amount1;
        checkNum=checkNum1;
    }    private String transId;
    public String getTransId() {
        return transId;
    }    public void setTransId(String transId) {
        this.transId = transId;
    }    public String getAccountId() {
        return accountId;
    }    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }    public String getTransType() {
        return transType;
    }    public void setTransType(String transType) {
        this.transType = transType;
    }    public double getAmount() {
        return amount;
    }    public void setAmount(double amount) {
        this.amount = amount;
    }    public int getCheckNum() {
        return checkNum;
    }    public void setCheckNum(int checkNum) {
        this.checkNum = checkNum;
    }}


