package bankaccoutnapp;

public abstract class Account implements IBaseRate {//abstract method must be implement by child
    //abstract class cannot be directly created (no objects)
    //List common properties for savings and checking accounts
    private String name;
    private String ic;//social securiy number
    private double balance;
    private static int index = 10000;
    protected String accountNumber;
    protected double rate;

    //Constructor to set base properties and initialize the account
    public Account(String name, String ic, double initDeposit){
        this.name = name;
        this.ic = ic;
        balance = initDeposit;

        //set account number
        index ++;
        this.accountNumber = setAccountNumber();

        setRate();

    }

    public abstract void setRate();

    public void compound(){
        double accruedInterest =  balance * (rate/100); //interest that has built up (earned or owed) but has not been paid yet.
        balance = balance + accruedInterest;
        System.out.println("Accrued Interest: RM" + accruedInterest);
        printBalance();
    }

    private String setAccountNumber(){

        //substring used to extract character from start index to end index
        String lastTwoIc = ic.substring(ic.length()-2,ic.length());
        int uniqueID = index;
        //random Number from 0 to 999
        int randomNumber = (int) (Math.random() * Math.pow(10,3)); //math pow is 10 to the power of 3
        return lastTwoIc+ uniqueID + randomNumber;  //uniqueId automaticaly converts to String
    }

    //list common methods -  transactions
    public void showInfo(){
              System.out.println(  "NAME: " + name +
                "\nACCOUNT NUMBER: " + accountNumber +
                "\nBALANCE: " + balance +
                      "\nRATE: " + rate + "%");
    }

    public void deposit(double amount){

        balance = balance + amount;
        System.out.println("Depositing RM" + amount);
        printBalance();
    }

    public void withdraw(double amount){
        balance = balance - amount;
        System.out.println("Withdrawing RM" + amount);
        printBalance();
    }
    public void transfer(String toWhere, double amount){

        balance = balance - amount;
        System.out.println("Transferring RM " + amount + " to" + " " + toWhere);
        printBalance();
    }

    private void printBalance() {
        System.out.println("Your current account balance: RM" + balance);
    }

}
