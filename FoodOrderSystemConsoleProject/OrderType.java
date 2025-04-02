package FoodOrderSystemConsoleProject;
import java.util.*;
public class OrderType extends FoodOrder
{
    static Scanner sc= new Scanner(System.in);
    void calculateDeliveryTime()
    {
        System.out.println("Choose Order Type\n");
        System.out.println("1.Dine-In");
        System.out.println("2.Delivery\n");
        System.out.print("Enter Your Choice:");
        int choice =sc.nextInt();
        if(choice ==2)
        {
            System.out.print("Enter Delivery Address");
            sc.nextLine();
            String address=sc.nextLine();
            int a=20;
            System.out.println("Estimated Delivery Time : " + (int) ((a--) - (Math.random() * 10)) + "mins");
            System.out.println("Complete Payment to Place Order\n");
        }
        else if(choice ==1)
        {
            System.out.println("Complete Payment to Place Order");
            FoodOrderSystem.userMainMenu();
        }
    }

    void calculateDeliveryTime(int j)
    {
        int a=20;
        System.out.println("Estimated Delivery Time : " + (int) ((a--) - (Math.random() * 10)) + "mins");
    }

}

