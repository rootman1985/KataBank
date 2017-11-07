import java.util.Scanner;

import com.kata.bank.business.custom.ActionBankImpl;
import com.kata.bank.business.custom.impl.IActionBank;
import com.kata.bank.exception.AccountException;
import com.kata.bank.exception.CustomerException;

public class Test {

    public static void main(String[] args) {
        
        IActionBank bank = new ActionBankImpl();
        
        Scanner input = new Scanner(System.in);
        boolean dontExit = true;
        
        do {
            System.out.println("|==============================================================================|");
            System.out.println("|==================================MENU========================================|");
            System.out.println("|==============================================================================|");
            System.out.println("|                                                                              |");
            System.out.println("|                          1 Create new costomer                               |");
            System.out.println("|                          2 Create new Account for existing costomer          |");
            System.out.println("|                          3 Deposit                                           |");
            System.out.println("|                          4 Withdrawal                                        |");
            System.out.println("|                          5 Show operations for customer                      |");
            System.out.println("|                          6 Show operations for account                       |");
            System.out.println("|                          7 Exit                                              |");
            System.out.println("|==============================================================================|");
            System.out.println("|==============================================================================|");
        try {
            System.out.println("");
            System.out.println("");
            System.out.println("Please enter your chose  : ");
            int inputUser = Integer.parseInt(input.next());


            switch (inputUser) {
            case 1: 
                System.out.println("|=================================================================================================|");
                System.out.println("|==================>                          1 Create new costomer                               |");
                System.out.println("|=================================================================================================|");
                createCostumer(bank, input);
                     break;
            case 2:  
                System.out.println("|=================================================================================================|");
                System.out.println("|==================>                          2 Create new Account for existing costomer          |");
                System.out.println("|=================================================================================================|");
                createAccount(bank, input);
                     break;
            case 3: 
                System.out.println("|=================================================================================================|");
                System.out.println("|==================>                          3 Deposit                                           |");
                System.out.println("|=================================================================================================|");
                deposit(bank, input);
                     break;
            case 4:  
                System.out.println("|=================================================================================================|");
                System.out.println("|==================>                          4 Withdrawal                                        |");
                System.out.println("|=================================================================================================|");
                withdrawal(bank, input);
                     break;
            case 5:  
                System.out.println("|=================================================================================================|");
                System.out.println("|==================>                          5 Show operations for customer                      |");
                System.out.println("|=================================================================================================|");
                operationsHistoryForCustomer(bank, input);
                     break;
            case 6:
                System.out.println("|=================================================================================================|");
                System.out.println("|==================>                          6 Show operations for account                       |");
                System.out.println("|=================================================================================================|");
                operationsHistoryForAccount(bank, input);
                     break;
            case 7:  
                System.out.println("|=================================================================================================|");
                System.out.println("|==================>                          7 Exit                                              |");
                System.out.println("|=================================================================================================|");
                dontExit = false;
                     break;
           }
          } catch (NumberFormatException e) { System.err.println("The entered value is unrecognized!!!");}

        }
        while(dontExit);
    }

    private static void operationsHistoryForAccount(IActionBank bank, Scanner input) {
        System.out.print("Enter the account Id : ");
        String accountIdOp = input.next();
        
        try {
            bank.operationsHistoryForAccount(accountIdOp);
        } catch (AccountException e) {
           System.err.println("Technical problem : make sure the acccount exists : "+accountIdOp);
        }
    }

    private static void operationsHistoryForCustomer(IActionBank bank, Scanner input) {
        System.out.print("Enter the customer Id : ");
        String clientIdOp = input.next();
        
        try {
            bank.operationsHistoryForCustomer(clientIdOp);
        } catch (CustomerException e) {
            System.err.println("Technical problem : make sure the customer exists : "+clientIdOp);
        }
    }

    private static void withdrawal(IActionBank bank, Scanner input) {
        System.out.print("Enter the account Id : ");
        String accountIdW = input.next();
        System.out.print("Enter the amount : ");
        double amountW = Double.parseDouble(input.next());
        
        try {
            bank.withdrawal(accountIdW, amountW);
        } catch (AccountException e) {
            System.err.println("Technical problem : make sure the account exists : "+accountIdW);
        }
    }

    private static void deposit(IActionBank bank, Scanner input) {
        System.out.print("Enter the account Id : ");
        String accountIdD = input.next();
        System.out.print("Enter the amount : ");
        double amountD = Double.parseDouble(input.next());
        
        try {
            bank.deposit(accountIdD, amountD);
        } catch (AccountException e) {
            System.err.println("Technical problem : make sure the account exists : "+accountIdD);
        }
    }

    private static void createAccount(IActionBank bank, Scanner input) {
        System.out.print("Enter the customer Id : ");
        String clientId = input.next();
        System.out.print("Enter the account Id : ");
        String accountId = input.next();
        System.out.print("Enter the balance : ");
        double balance = Double.parseDouble(input.next());
        System.out.print("Enter the overdraft : ");
        double overdraft = Double.parseDouble(input.next());
        
        try {
            bank.createAccount(clientId, accountId, balance, overdraft);
        } catch (AccountException e) {
            System.err.println("Technical problem : Account already exist please change the accountId : "+accountId);
        } catch (CustomerException e) {
            System.err.println("Technical problem : make sure the customer exists : "+clientId);
        }
    }

    private static void createCostumer(IActionBank bank, Scanner input) {
        System.out.print("Enter the customer Id : ");
        String customerId = input.next();
        System.out.print("Enter the name : ");
        String name = input.next();
        System.out.print("Enter the secret code : ");
        String secretCode = input.next();
        
        try {
            bank.createCostumer(customerId, name, secretCode);
        } catch (CustomerException e) {
            System.err.println("Technical problem : Costomer already exist please change the customerId : "+customerId);
        }
    }

}
