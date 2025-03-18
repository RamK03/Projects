package E_Commerce_Site;
import java.util.*;
public class Main
{
   static Scanner sc=new Scanner(System.in);
   static Products product_obj=new Products();
   static Cart cart_Obj=new Cart();

  static  void menu()
    {
        int user_opt;
        do
        {
            System.out.println("1.Product List");
            System.out.println("2.Cart ");

            System.out.println("Enter Your Option");
            user_opt= sc.nextInt();

             if(user_opt<0||user_opt>4)
             {
                 System.out.println("Invalid Option");
                 menu();
             }
             else if(user_opt==1)
             {
                 product_obj.action();
             }
             else if(user_opt==2)
             {
                 cart_Obj.cart_Display();
             }
        }while(user_opt<0||user_opt>4);

    }

    public static void main(String[] args)
    {
        System.out.println("Welcome");
       // menu();
       Payment.payment_Menu();
    }
}
