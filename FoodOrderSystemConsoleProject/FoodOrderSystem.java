package FoodOrderSystemConsoleProject;
import java.util.*;

public class FoodOrderSystem
{
    static Scanner sc= new Scanner(System.in);
    static DeliveryAgent agent_obj=new DeliveryAgent();
    static OrderType type_obj=new OrderType();
    public static void main (String args[])
    {
        System.out.println("Welcome  To The K.R KING Cafe \n");
        userMainMenu();
    }


   static void userMainMenu()
    {
        System.out.println();
        int userChoice;
        do
        {
        System.out.println("1.View Menu");
        System.out.println("2.Place Order");
        System.out.println("3.Make payment");
        System.out.println("4.View Order Status");
        System.out.println("5.Exit\n");
        System.out.print("Enter Choice:");

            userChoice=sc.nextInt();
            switch(userChoice)
            {
                case 1:
                    FoodItems.displayFoodItems();
                    userMainMenu();
                    break;
                case 2:
                    Order.placeOrder();
                    type_obj.calculateDeliveryTime();
                    userMainMenu();
                    break;
                case 3:
                    Order.viewOrder();
                    type_obj.calculateDeliveryTime(6);
                    System.out.println("Choose Your Payment Mode");
                    System.out.println("1.Upi");
                    System.out.println("2.Card");
                    System.out.println("3.Cash\n");
                    System.out.print("Enter Your Choice");
                    int choice=sc.nextInt();
                    PaymentProcessor payment_obj;
                    if(choice==1)
                    {
                        payment_obj=new UpiPayment();
                        payment_obj.processPayment();
                    }
                    else if(choice==2)
                    {
                        payment_obj=new CardPayment();
                        payment_obj.processPayment();
                    }
                    else if(choice==3)
                    {
                        payment_obj=new CashPayment();
                        payment_obj.processPayment();
                    }
                    agent_obj.assigning_Agent();
                    userMainMenu();
                    break;
                case 4:
                    Order.viewOrder(1);
                    agent_obj.assigning_Agent(1);
                    userMainMenu();
                    break;
                case 5:
                    System.out.println("Thank You for using K.R KING Cafe,Come Again");
                    break;
                default:
                    System.out.println("Invalid Option");

            }
        }
        while(userChoice>5||userChoice<1);
    }

}
