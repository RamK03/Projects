package E_Commerce_Site;
import java.util.Scanner;

public class Payment extends Cart
{
    static Scanner sc=new Scanner(System.in);
   static int total_price;
   static  void payment_Menu()
    {
        Payment obj1=new Payment();
        int user_opt;
        do
        {
            System.out.println();
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
             else if(user_opt==1)
             {
                 obj1.upi();
             }
             else if(user_opt==2)
             {
                 obj1.cash();
             }
             else if(user_opt==3)
             {
                 obj1.card();
             }
         }while(user_opt<1||user_opt>3);
    }

    void upi()
    {

        User_Details user_obj= new User_Details();
        String upi_Id;
        cart_Display();
        System.out.println("Total price :     "+Payment.total_price);
        System.out.println();
        do {
            System.out.println("Enter Your UPI ID ");
            sc.nextLine();
            upi_Id = sc.nextLine();
            if (upi_Id.equalsIgnoreCase(user_obj.upi_Id))
            {
                int upi_pin;
                do{
                    System.out.println("Enter Your UPI pin");
                    upi_pin=sc.nextInt();
                    if( user_obj.get_upi_pin()==upi_pin)
                    {
                        System.out.println("Payment successfull");
                        System.out.println("Thank You");
                        return;
                    }
                    else
                    {
                        System.out.println("Invalid pin");
                    }
                }while(user_obj.get_upi_pin()!=upi_pin);

            } else
            {
                System.out.println("UPI Id Invalid");
            }
        }while(!(upi_Id.equalsIgnoreCase(user_obj.upi_Id)));


    }

    void card()
    {

        User_Details user_obj1= new User_Details();
        long card_no;
        cart_Display();
        System.out.println("Total price :     "+Payment.total_price);
        System.out.println();
        do {
            System.out.println("Enter Your card no ");
            card_no = sc.nextLong();
            if (card_no==user_obj1.card_No)
            {
                int card_pin;
                do{
                    System.out.println("Enter Your card pin");
                    card_pin=sc.nextInt();
                    if( user_obj1.get_card_pin()==card_pin)
                    {
                        System.out.println("Payment successfull");
                        System.out.println("Thank You");
                        return;
                    }
                    else
                    {
                        System.out.println("Invalid pin");
                    }
                }while(user_obj1.get_card_pin()!=card_pin);

            } else
            {
                System.out.println(" Card No Invalid");
                System.out.println();
            }
        }while(card_no!=user_obj1.card_No);

    }
    void cash()
    {
        cart_Display();
        System.out.println("Enter the amount");
        int cash=sc.nextInt();
        if(cash==Payment.total_price)
        {
            System.out.println("Your  payment successful");
            System.out.println("Thank You");
            return;
        }
        else if(cash<Payment.total_price)
        {
            System.out.println("you gave "+(Payment.total_price-cash)+"less");
            System.out.println();
            System.out.println("Give the balance amount");
            int balance=sc.nextInt();
            if(balance>Payment.total_price-cash)
            {
                System.out.println("you gave "+(cash-Payment.total_price)+"more");
                System.out.println("Your balance"+(cash-Payment.total_price));
                System.out.println("Your payment successful");
                System.out.println("Thank You");
            }

        }
        else if(cash>Payment.total_price)
        {
            System.out.println("you gave "+(cash-Payment.total_price)+"more");
            System.out.println("Your balance"+(cash-Payment.total_price));
        }
    }
    void cart_Display()
    {
        boolean b=false;
        int i=0;
        while(i<5)
        {
            if(product_name[i]==null)
            {
                b=false;
            }
            else
            {
                b=true;
                break;
            }
            i++;
        }
        if(b)
        {
            System.out.println("Your Cart");
            System.out.println();
            int k=1;
            for(int j=0;j<5;j++)
            {
                if(product_name[j]!=null)
                {
                    System.out.println(k+"."+product_name[j]+" price-"+amount[j]+" Qty-"+quantity[j]);
                    total_price+=amount[i];
                    k++;

                }
            }
            System.out.println();
        }
    }
}
