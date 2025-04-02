package E_Commerce_Site_Console_Project;

import java.util.Scanner;

public class Products
{
    Scanner sc=new Scanner(System.in);

    static String [] name={"Apple 1kg","Onion 1kg","coconut_oil 1l","Ghee 1l","Milk 1l"};
    static int [] price={10,30,100,500,50};
    static int [] product_Id={1001,1002,1003,1004,1005};
    static int [] stock={100,100,100,100,100};


    void product_Display()
    {
        System.out.println("Product List");
        int k=1;
        for(int i=0;i<name.length;i++)
        {
            if(stock[i]>0)
            {
                System.out.println(( k++) + "." + name[i] + " Price-" + price[i]);
            }
        }
        System.out.println();
    }
    void action()
    {
        Cart cart_obj=new Cart();

        int user_opt;
        do
        {
            System.out.println("Menu");
            System.out.println();
            product_Display();
            System.out.println();
            System.out.println("1.Add to Cart");
            System.out.println("2.Go to Cart");
            System.out.println("3.Exit");
            System.out.println();
            System.out.println("Enter Your Option");
            user_opt = sc.nextInt();
            System.out.println();
            if (user_opt<0||user_opt>3)
            {
                System.out.println("Invalid Option");
                System.out.println("Enter Correct Option");
                System.out.println();

            }
            else if(user_opt==1)
            {
                add_To_Cart();
            }
            else if(user_opt==2)
            {
                cart_obj.cart_Display();
            }
            else if(user_opt==3)
            {
               return;
            }
        }while(user_opt<0||user_opt>3);
    }

    void add_To_Cart()
    {
        Cart cart_obj=new Cart();
        int option;

        do {
            product_Display();
            System.out.println("Choose Your Product To buy");
            System.out.println("Enter 1 to 5");
            option= sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter Quantity");
                    int qty1 = sc.nextInt();
                    cart_obj.cart_add("Apple", product_Id[option - 1], qty1, price[option - 1]);
                    break;

                case 2:
                    System.out.println("Enter Quantity");
                    int qty2 = sc.nextInt();
                    cart_obj.cart_add("Onion", product_Id[option - 1], qty2, price[option - 1]);
                    break;

                case 3:
                    System.out.println("Enter Quantity");
                    int qty3 = sc.nextInt();
                    cart_obj.cart_add("coconut oil", product_Id[option - 1], qty3, price[option - 1]);
                    break;

                case 4:
                    System.out.println("Enter Quantity");
                    int qty4 = sc.nextInt();
                    cart_obj.cart_add("ghee", product_Id[option - 1], qty4, price[option - 1]);
                    break;

                case 5:
                    System.out.println("Enter Quantity");
                    int qty5 = sc.nextInt();
                    cart_obj.cart_add("milk", product_Id[option - 1], qty5, price[option - 1]);
                    break;

                default:
                    System.out.println("Invalid Option");
                    System.out.println("Enter Correct Option");
                    System.out.println();
            }
        }while(option<1||option>5);
    }
}
