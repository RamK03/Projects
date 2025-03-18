package E_Commerce_Site;

import java.util.Scanner;

public class Payment
{
    static Scanner sc=new Scanner(System.in);
   static  void payment_Menu()
    {
        int user_opt;
        do
        {
            System.out.println("Your Payment Options");
            System.out.println("1.UPI");
            System.out.println("2.CASH");
            System.out.println("3.CARD");
            System.out.println("Enter your option");
             user_opt=sc.nextInt();
             if(user_opt<1||user_opt>3)
             {
                 System.out.println("Invalid Option");
                 System.out.println();
             }
         }while(user_opt<1||user_opt>3);
    }
    void upi()
    {

    }

    void cash()
    {

    }
    void card()
    {

    }
}
