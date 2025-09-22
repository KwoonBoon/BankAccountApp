package bankaccoutnapp;

public class Checking extends Account{

    //List properties specific to a Checking account
    private long debitCardNumber;
    private int debitCardPIN;


    public Checking(String name, String ic, double initDeposit){

        super(name, ic, initDeposit); //super is for child to callparents contructor
        accountNumber = "2" + accountNumber;
        setDebitCard();

    }

    @Override // This method is meant to override (replace) a method from the parent class or interface.”
    public void setRate(){

       rate = getBaseRate() * .15;

    }

    private void setDebitCard() {
        debitCardNumber = (long) (Math.random() * Math.pow(10,12));
        debitCardPIN = (int)(Math.random() * Math.pow(10,4));
    }

    public void showInfo(){
        super.showInfo(); //call the method from parent class
        System.out.println( "ACCOUNT TYPE: CHECKING" +
                "\n******************************" +
                "\nYour Checking Account Features" +
                "\n******************************" +
                "\nDebit Card Number: " + debitCardNumber +
                "\nDebit Card Pin: " + debitCardPIN);
    }




}
