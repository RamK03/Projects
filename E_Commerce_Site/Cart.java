package E_Commerce_Site;
import java.util.*;
public class Cart
{

    Scanner sc=new Scanner(System.in);
    static String [] product_name=new String[5];
    static  int [] amount=new int[5];
    static int [] quantity=new int[5];
    static int [] product_Id={1001,1002,1003,1004,1005};

    void cart_add(String name,int id,int qty,int price)
    {
        for(int i=0;i<product_Id.length;i++)
        {
            if(product_Id[i]==id&&product_name [i]==null&&Products.stock[i]>0)
            {
                product_name [i]=name;
                amount[i]=price*qty;
                quantity[i]=qty;
                Products.stock[i]-=qty;

            }
            else if(Products.stock[i]==0)
            {
                System.out.println(" Product is out of Stock");
                System.out.println("Choose another");
                Main.user_menu();
                return;
            }
        }
        System.out.println();
        System.out.println("your product is added to Cart");
        Main.user_menu();
    }

    void remove(int id)
    {
        product_name[id]=null;
        amount[id]=0;
        Products.stock[id]+=quantity[id];
        quantity[id]=0;
    }

    void   add_Quantity(int id,int qty)
    {
        quantity[id]=Products.price[id]*qty;
    }

    void cart_Menu()
    {
        Products product_obj=new Products();

        int user_opt;
        do
        {
            System.out.println("1.Add or minus Quantity");
            System.out.println("2.Add New Product");
            System.out.println("3.Remove Product");
            System.out.println("4.Payment");
            System.out.println();
            System.out.println("Enter Your Option");
             user_opt=sc.nextInt();
            if(user_opt<1||user_opt>4)
            {
                System.out.println("Invalid Option");
                System.out.println("Enter Correct Option");
                System.out.println();
                cart_Display();
            }
            else if (user_opt==1)
            {
                System.out.println("Enter the  product name");
                sc.nextLine();
                String option=sc.nextLine();
                System.out.println("Enter the new quantity ");
                int  qty=sc.nextInt();
                for(int i=0;i<product_name.length;i++)
                {
                    if(product_name[i]==null){
                        continue;
                    }

                        if (product_name[i].equalsIgnoreCase(option)) {
                            add_Quantity(i, qty);
                            System.out.println("Quantity updated");
                            cart_Display();
                        }

                }
            }
            else if(user_opt==2)
            {
                product_obj.action();
            }
            else if(user_opt==3)
            {
                System.out.println("Enter the  product name to remove");
                sc.nextLine();
                String option=sc.nextLine();
                for(int i=0;i<product_name.length;i++)
                {
                    if(product_name[i]==null)
                    {
                        continue;
                    }
                    if(product_name[i].equalsIgnoreCase(option))
                    {
                        remove(i);
                        System.out.println("Product removed ");
                        cart_Display();
                    }
                }

            }
            else if(user_opt==4)
            {
                Payment.payment_Menu();
            }
        }while( user_opt<1||user_opt>4);
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
                    System.out.println(k+"."+product_name[j]+" price-"+(amount[j]*quantity[j])+" Qty-"+quantity[j]);
                    k++;
                }
            }
           System.out.println();
           cart_Menu();
       }
       else
       {
           int user_opt;
           System.out.println("Your Cart is Empty");
           System.out.println("Add your products");
           do {
               System.out.println("Enter 1 to continue or 0 to exit");
               user_opt= sc.nextInt();
               if (user_opt == 1)
               {
                   Main.user_menu();
               } else if (user_opt == 0)
               {
                   System.out.println("Thank You!");
                   return;
               } else
               {
                   System.out.println("Invalid Option");
               }
           }while(user_opt<0||user_opt>1);
       }
    }
}
