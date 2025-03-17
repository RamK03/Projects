package E_Commerce_Site;
import java.util.*;
public class Cart extends Products
{
    Scanner sc=new Scanner(System.in);

    String [] name=new String[5];
    int [] price=new int[5];
    int [] quantity=new int[5];

    void add(String name,int id,int qty,int price)
    {
        this.name [id]=name;
        this.price[id]=price*qty;
        quantity[id]=qty;
    }

    void remove(int id)
    {
        name[id]=null;
        price[id]=0;
        quantity[id]=0;
    }

    void cart_Display()
    {
        boolean b=false;
        int i=0;
       while(i<5)
       {
           if(name[i]==null)
           {
               b=false;
           }
           else
           {
               b=true;
               break;
           }
       }
       if(b)
       {
            System.out.println("Your Cart");
            System.out.println();
            System.out.println();
            for(int j=0;j<5;j++)
            {
                if(name[i]!=null)
                {
                    System.out.println(name[i]+"\nprice"+price[i]+"\nQty"+quantity[i]);
                }
            }
       }
       else
       {
           System.out.println("Your Cart is Empty");
       }
    }
}
