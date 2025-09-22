package bankaccoutnapp;

public class Savings extends Account{
    //List properties specific to the Savings account
     private int safetyDepositBoxID;
    private int safetyDepositBoxKey;

    //Constructor to initialize settings for saving properties
    public Savings(String name , String ic , double initDeposit) {
        super(name , ic, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    private void setSafetyDepositBox(){
            safetyDepositBoxID = (int) (Math.random() * Math.pow(10,3));
            safetyDepositBoxKey = (int)(Math.random() * Math.pow(10,4));
    }

    public void showInfo(){
        super.showInfo(); //call the method from parent class
        System.out.println( "ACCOUNT TYPE: SAVING" +
                "\n******************************" +
                "\nYour Saving Account Features" +
                "\n******************************" +
                "\nSafety Deposit Box ID: " + safetyDepositBoxID +
                "\nSafety Deposit Box Key: " + safetyDepositBoxKey);
    }

    @Override // This method is meant to override (replace) a method from the parent class or interface.”
    public void setRate(){

        rate = getBaseRate() - .25;

    }
}
