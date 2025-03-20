package E_Commerce_Site;
import java.util.*;

public class Main
{

    static Scanner sc = new Scanner(System.in);
    static Products product_obj = new Products();
    static Cart cart_Obj = new Cart();



   private static void admin()
    {
        Products disp=new Products();
        System.out.println("Your options");
        System.out.println("1.Add Stock ");
        System.out.println("2.check Stocks Quantity");
        System.out.println("Enter 0 to exit");
        int opt =sc.nextInt();
        int  product_opt;
        if(opt ==1)
        {
            disp.product_Display();
            System.out.println("Enter the Product to stock update");
            product_opt=sc.nextInt();
            System.out.println("Enter Quantity to add");
            int quantity=sc.nextInt();
            switch (product_opt)
            {
                case 1:
                    disp.stock[0]+=quantity;
                    System.out.println("Quantity added");
                    System.out.println("Enter 1 to continue any other to exit");
                    int option=sc.nextInt();
                    if(option==1)
                    {
                        admin();
                    }
                    break;

                case 2:
                    disp.stock[1]+=quantity;
                    System.out.println("Quantity added");
                    System.out.println("Enter 1 to continue any other to exit");
                    int option1=sc.nextInt();
                    if(option1==1)
                    {
                        admin();
                    }
                    break;

                case 3:
                    disp.stock[2]+=quantity;
                    System.out.println("Quantity added");
                    System.out.println("Enter 1 to continue any other to exit");
                    int option2=sc.nextInt();
                    if(option2==1)
                    {
                        admin();
                    }
                    break;

                case 4:
                    disp.stock[3]+=quantity;
                    System.out.println("Quantity added");
                    System.out.println("Enter 1 to continue any other to exit");
                    int option3=sc.nextInt();
                    if(option3==1)
                    {
                        admin();
                    }
                    break;

                case 5:
                    disp.stock[4]+=quantity;
                    System.out.println("Quantity added");
                    System.out.println("Enter 1 to continue any other to exit");
                    int option4=sc.nextInt();
                    if(option4==1)
                    {
                        admin();
                    }
                    break;

                default:
                    System.out.println("No Products Found");
                    System.out.println("choose correct options");
                    admin();
            }
        }
        else if(opt ==2)
        {
            product_Display();
            admin();
        }
        else
        {
            System.out.println("Thank You");
            return;
        }
    }
    static void welcome()
    {
        int opt;
        do
        {
            System.out.println("Welcome to Shopping Cart");
            System.out.println("You are?");
            System.out.println("1.USER");
            System.out.println("2.ADMIN");
            System.out.println("Enter your option");
            opt = sc.nextInt();
            if (opt < 1 || opt > 2) {
                System.out.println("Invalid Option");
            }
            else if(opt==1)
            {
                user_menu();
            }
            else if(opt ==2)
            {
                System.out.println("Welcome Admin");
                admin();
            }

        }while(opt < 1 || opt > 2);

    }
    static void user_menu()
    {

        int user_opt;
        do {
            System.out.println();
            System.out.println("1.Product List");
            System.out.println("2.Cart ");

            System.out.println("Enter Your Option");
            user_opt = sc.nextInt();
            System.out.println();

            if (user_opt < 0 || user_opt > 4) {
                System.out.println("Invalid Option");
                user_menu();
            } else if (user_opt == 1) {
                product_obj.action();
            } else if (user_opt == 2) {
                cart_Obj.cart_Display();
            }
        } while (user_opt < 0 || user_opt > 4);

    }
   static void product_Display()
    {
        System.out.println("Product List");
        for(int i=0;i<Products.name.length;i++)
        {
            System.out.println((i+1)+"."+Products.name[i]+" Avalaible Quantity-"+Products.stock[i]);
        }
        System.out.println();
    }


    public static void main(String[] args)
    {
        welcome();
    }
}
