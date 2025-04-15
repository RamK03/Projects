package BankingSystem;
import java.util.*;
 abstract class BankAccount
{
    static Scanner sc= new  Scanner(System.in);
    private String accountHolderName;
    private long accountNumber;
    private double balance;
    abstract void displayAccountDetails();
    abstract void withdraw();
    abstract void deposit();

    BankAccount(String name,long accountNumber,double balance)
    {
        this.accountNumber=accountNumber;
        this.accountHolderName=name;
        this.balance=balance;
    }

    BankAccount(){}

    public String getName()
    {
      return accountHolderName;
    }

    public void setName(String name)
    {
        this.accountHolderName=name;
    }

    public long getAccountNumber()
    {
        return accountNumber;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double amount,int n)
    {
                if(n == 1)
                {
                    this.balance +=amount;
                }
                else
                {
                    this.balance-=amount;
                }
    }


}

class SavingsAccount extends BankAccount
  {
      Scanner sc=new Scanner (System.in);
      double deposit;
      double withdraw;
      static int l=0;
      int roi=5;
      boolean b=false;
      SavingsAccount [] passBook=new SavingsAccount[100];

      SavingsAccount(double deposit, double withdraw)
      {
         this.withdraw=withdraw;
         this.deposit=deposit;
      }

      SavingsAccount(String name,long accountNumber,double balance)
      {
          super(name,accountNumber,balance);

      }

      SavingsAccount() {}


      void displayAccountDetails()
      {
          System.out.println("Name : "+getName());
          System.out.println("Account Number : "+getAccountNumber());
          System.out.println("Balance : "+getBalance());
          if(b)
          {
              System.out.println("Trnasactions : ")
              ;passbook();
          }
          else{System.out.println("Transactions: 0");}
          interest();
      }

      void withdraw()
      {
          System.out.print("Enter the amount to withdraw : ");
          double amount=sc.nextDouble();
          if(getBalance()<amount)
          {
              System.out.println("Insufficient balance");
              return;
          }
          else if(amount==0)
          {
              System.out.println("Amount cannot be zero");
              return;
          }
          else
          {
              setBalance(amount,0);
              System.out.println("Withdraw Successful");
              passBook[l++]=new SavingsAccount(0,amount);
              this.b=true;
          }
      }

      void deposit()
      {
          System.out.print("Enter your amount to deposit : ");
          double amount=sc.nextDouble();
          setBalance(amount,1);
          System.out.println("Deposit Successfull");
          passBook[l++]=new SavingsAccount(amount,0);
          this.b=true;

      }

      void interest()
      {
          System.out.println("Interest rate : "+this.roi);
          System.out.println("Interest Earned : "+(getBalance()/100)*this.roi);
      }

      void passbook()
      {
          for(SavingsAccount a:passBook)
          {
              if(a!=null)
              {
                  if(a.withdraw!=0) System.out.println("Withdraw : "+a.withdraw);
                  if(a.deposit!=0) System.out.println("Deposit :"+a.deposit);
              }
          }
      }

      void userMenu()
      {

          System.out.println("-----------Menu-----------");
          System.out.println("1.Account Details");
          System.out.println("2.Withdraw ");
          System.out.println("3.Deposit");
          System.out.println("4.Balance");
          System.out.println("5.Change Name");
          System.out.println("---------------------------\n");
          System.out.print("Enter Choice : ");
          int choice=sc.nextInt();

          switch(choice)
          {
              case 1:
                  displayAccountDetails();
                  validate();
                  break;
              case 2:
                  withdraw();
                  validate();
                  break;
              case 3:
                  deposit();
                  validate();
                  break;
              case 4:
                  System.out.println("Your Balance : "+getBalance());
                  validate();
                  break;
              case 5:
                  System.out.println("Enter the New Name");
                  sc.nextLine();
                  String name=sc.nextLine();
                  System.out.println("Name Changed Successfully");
                  setName(name);
                  validate();
                  break;
          }
      }

      void validate()
      {
          System.out.println("Enter 1 to continue 0 to exit");
          int choice =sc.nextInt();

          if(choice==1)userMenu();
          else return;
      }

        public static void main(String args[])
        {
            SavingsAccount user=new SavingsAccount("Vishwa",1234567L,15000);
            System.out.println("Welcome");
            user.userMenu();
        }
  }