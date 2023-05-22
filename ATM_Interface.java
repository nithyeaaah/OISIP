import java.util.*;

class InterfaceOfAtm{
    String name;
    String username;
    String password;
    String accno;
    double balance = 250000;
    int transactions = 0;
    String Transactionhistory = "";

    public void register()  //registration code
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Please Enter Your Name:");
        this.name = sc.nextLine();
        System.out.println("Enter Username:");
        this.username = sc.nextLine();
        System.out.println("Enter Password:");
        this.password = sc.nextLine();
        System.out.println("Enter Your Account Number:");
        this.accno = sc.nextLine();
        System.out.println("Account Registration Is Successful! Kindly Login To Your Account.");
    }
    public boolean login() //Login Credintials code
    {
        boolean islogin = false;
        Scanner sc = new Scanner(System.in);
        while(!islogin)
        {
            System.out.println("Enter Username:");
            String username = sc.nextLine();
            if(username.equals(username))
            {
                while(!islogin)
                {
                    System.out.println("Enter Your Password:");
                    String password = sc.nextLine();
                    if(password.equals(password))
                    {
                        System.out.println("Login Successful!");
                        islogin = true;
                    }
                    else
                    System.out.println("Incorrect Password!.. Please Try Again");
                }    
            } else
            System.out.println("Username Not Found");
        }
        return islogin;
    }
    public void withdraw()
    {
        System.out.println("Enter The Amount To Be Withdrwan");
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();
        try{
            if(balance >= amount)
            {
                balance -= amount;
                System.out.println("Withdrawl Was Successful!");
                String str = "Rs "+ amount+ " Withdrawn\n";
                Transactionhistory = Transactionhistory.concat(str);
            }
            else
            System.out.println("Insufficient Balance!");
        }catch(Exception e)
        {

        }
    }

    public void deposit() //Deposit code
    {
        System.out.println("Emount Amount To Deposit:");
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();
        try
        {
            if(amount <= 150000.00)
            {
                transactions++;
                balance += amount;
                System.out.println("Deposit Was Successful");
                String str = "Rs"+ amount + " deposited\n";
                Transactionhistory = Transactionhistory.concat(str);
            }
            else
            System.out.println("Limit Exceeded!");
        }catch (Exception e){

        }
    }

    public void transfer()  //transfering code
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Recepient Name:");
        String recepient = sc.nextLine();
        System.out.println("Enter Amount To Be Transferred:");
        double amount = sc.nextDouble();
        try
        {
            if(balance >= amount) {  
                if(amount <= 50000.00)  {
                    transactions++;
                    balance -= amount;
                    System.out.println("Successfully Transferred To "+recepient);
                     String str = "Rs "+amount+" Transferred to "+recepient+"\n";
                    Transactionhistory = Transactionhistory.concat(str);
                }
                else
                System.out.println("Sorry Limit Is Rs50000.00");
            }
            else
            System.out.println("Insufficient Balance.");
        }catch(Exception e){
        }
    }

    public void checkbalance() {
        System.out.println("Rs "+balance); 
    }

   public void transhistory() {
        if(transactions == 0)
            System.out.println("Empty!");
        else
            System.out.println("\n "+Transactionhistory);
    }
}
 class ATM_Interface{
    public static int takeinput(int lmt)
    {
        int input = 0;
        boolean flag = false;
        while(!flag){
             try {
                    Scanner sc = new Scanner(System.in);
                    input = sc.nextInt();
                    flag = true;
                    if(flag && input > lmt || input < 1)
                    {
                        System.out.println("Select The Number between 1 to "+lmt);
                        flag = false;
                    }
                }catch (Exception e)
            {
                System.out.println("Enter Integer Value Only:");
                flag = false;
            }
        }
        return input;
    }

    public static void main(String[] args)
    {
        System.out.println("Welcome To ICICU ATM :");
        System.out.println("1.Register  2.Exit");
        System.out.println("Enter Your Choice:");
        int choice = takeinput(2);
        if(choice == 1)
        {
            InterfaceOfAtm b = new InterfaceOfAtm();
            b.register();
            while(true)
            {
                System.out.println("1.Login  2.Exit");
                System.out.println("Enter Your choice:\n");
                int ch = takeinput(2);
                if(ch == 1)
                {
                    if(b.login())
                    {
                        System.out.println("Welcome Back! "+b.name+"\n\n");
                        boolean isfinished = false;
                        while(!isfinished)
                        {
                            System.out.println("1. Deposit  2.Withdraw  3.Transfer  4.Transaction History  5.Check Balance");
                            System.out.println("Enter Your choice:");
                            int c = takeinput(6);
                            switch(c)
                            {
                                case 1:b.deposit(); break;
                                case 2:b.withdraw(); break;
                                case 3:b.transfer(); break;
                                case 4:b.transhistory(); break;
                                case 5:b.checkbalance(); break;
                                case 6:isfinished = true; break;
                                default: System.out.println("Wrong Choice:\n");
                            }
                        } 
                    }
                } else
                System.exit(0);
            }    
       }
    };

}
