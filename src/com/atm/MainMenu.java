package com.atm;

import java.text.DecimalFormat;
import java.util.*;
import java.io.IOException;

public class MainMenu extends Account{
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer,Integer> data = new HashMap<Integer,Integer>();

    public void getLogin() throws IOException{
        int x = 1;
        do{
            try{
                data.put(9876678,990089);
                data.put(887569, 682275);
                data.put(923365, 744563);
                data.put(989076, 324356);

                System.out.println("Welcome to the PNB ATM!");
                System.out.println("Enter your customer number");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("Enter your PIN Number: ");
                setPinNumber(menuInput.nextInt());
            } catch(Exception e){
                System.out.println("\n" + "Invalid Character(s). Only Numbers." + "\n");
                x=2;
            }
            int cn=getCustomerNumber();
            int pn=getPinNumber();
            if(data.containsKey(cn) && data.get(cn) == pn){
                getAccountType();
            } else
                System.out.println("\n" + "Wrong Customer Number or Pin Number" + "\n");
        }while(x==1);
    }
    public void getAccountType(){
        System.out.println("Select the Account you want to access: ");
        System.out.println(" Press 1 - Current Account");
        System.out.println(" Press 2 - Saving Account");
        System.out.println(" Press 3 - Exit");

        int selection =menuInput.nextInt();

        switch (selection){
            case 1:
                getCurrent();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thank You for using this ATM. \n \n");
                break;
            default:
                System.out.println("\n"+"Invalid Choice."+"\n");
                getAccountType();
        }
    }
    public void getCurrent(){
        System.out.println("Current Account: ");
        System.out.println(" Press 1 - View Balance");
        System.out.println(" Press 2 - Withdraw Funds");
        System.out.println(" Press 3 - Deposit Funds");
        System.out.println(" Press 4 - Exit");
        System.out.println(" Choice: ");

        int selection = menuInput.nextInt();

        switch (selection){
            case 1:
                System.out.println("Current Account Balance: "+moneyFormat.format(getCurrentBalance()));
                getAccountType();
                break;

            case 2:
                getCurrentWithdrawInput();
                getAccountType();
                break;

            case 3:
                getCurrentDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank You for using this ATM.");
                break;

            default:

        }
    }

    public void getSaving(){
        System.out.println("Saving Account: ");
        System.out.println(" Press 1 - View Balance");
        System.out.println(" Press 2 - Withdraw Funds");
        System.out.println(" Press 3 - Deposit Funds");
        System.out.println(" Press 4 - Exit");
        System.out.println("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection){
            case 1:
                System.out.println("Saving Account Balance: "+moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getSavingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank You for using this ATM");
                break;

            default:
                System.out.println("\n" + "Invalid Choice."+ "\n");
                getCurrent();

        }
    }
}
