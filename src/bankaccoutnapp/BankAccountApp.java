package bankaccoutnapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

    public static void main(String[]args){

        //hard code
        /* Checking checkAcc1 = new Checking("Kwoon Boon", "321456789" ,1500);

        Savings savAcc1 = new Savings ("Richie Lowie","456657897" , 2500);

        checkAcc1.showInfo();
        System.out.println("============================");
        savAcc1.showInfo();

        savAcc1.compound();

         */

        //Read a CSV file then create new accounts based on that data

        List<Account> accounts = new LinkedList<Account>();

        String file = "C:\\Users\\gohkw\\Desktop\\BankAccountApp\\NewBankAccounts.csv";

        List<String[]> newAccountHolders = utilities.CSV.read(file);
        for(String[] accountHolder : newAccountHolders){
           String name = accountHolder[0];
            String IC = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]); //converts string into double
            if(accountType.equals("Savings")){
                accounts.add(new Savings(name,IC,initDeposit));
            }

            else if(accountType.equals("Checking")){
                accounts.add(new Checking(name,IC,initDeposit));
            }

            else{
                System.out.println("ERROR READING ACCOUNT TYPE");
            }

        }
        for(Account acc :accounts){
            System.out.println("\n******************");
            acc.showInfo();
        }
    }
}
