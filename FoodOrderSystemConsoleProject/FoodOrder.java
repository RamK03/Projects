package FoodOrderSystemConsoleProject;
import java.util.*;

 abstract class FoodOrder
{

    static Scanner sc=new Scanner(System.in);
    static FoodOrder []orderList=new FoodOrder[100];
    FoodOrder(){}

     String customerName;
    static String  []foodList=new String [4];
    static int []foodQuantity=new int[4];
    static double []foodPrice=new double[4];
    static double totalPrice=0;
    static int j=0;


    int k=0;
    public FoodOrder(String customerName, String []food,int i,int []quantity,double []price,double totalPrice)
    {
        this.customerName=customerName;
        this.totalPrice=totalPrice;
        while(k<=i)
        {
            foodList[k]=food[k];
            foodQuantity[k]=quantity[k];
            foodPrice[k]=price[k];
            k++;
        }
    }
    abstract void calculateDeliveryTime();


}
class Order extends FoodOrder
{
    void calculateDeliveryTime(){}
    static Order order_obj=new Order();

    static void placeOrder()
    {
        FoodItems.displayFoodItems();
        System.out.print("Enter Customer Name :");
        order_obj.customerName=sc.nextLine();

        System.out.print("Enter Choice (Comma-separated :");
        String input=sc.nextLine();
        String [] input1=input.split(",");
        Arrays.sort(input1);
        int j=0,l=0;

        for(int i=0;i<input1.length;i++)
        {
            int var=(Integer.parseInt(input1[i])-1);
            if(input1[i]!=null)
            {
                j++;
                System.out.print("Enter "+FoodItems.food[var].name+" quantity");
                foodQuantity[var]=sc.nextInt();
                foodList[var]=FoodItems.food[var].name;
                foodPrice[var]=(FoodItems.food[var].price*foodQuantity[var]);
            }
        }
        for(double a:foodPrice)
        {
            totalPrice+=a;
        }
        orderList[l++]= new FoodOrder(order_obj.customerName, foodList ,j,foodQuantity,foodPrice,totalPrice) {void calculateDeliveryTime() {}};
        order_obj.viewOrder();

    }

    static void viewOrder()
    {

        for(FoodOrder a:orderList)
        {
            if(a!=null)
            {
                j++;
                System.out.println("---------Order Details---------\n");
                System.out.println("Customer Name : " + a.customerName);
                System.out.println("Items Orderd :");
                for(int n=0;n<4;n++) {
                    if (a.foodQuantity[n] != 0)
                    {
                        System.out.println("-" + a.foodQuantity[n] + " x " + a.foodList[n] + " = Rs." + a.foodPrice[n]);
                        System.out.println("Total Amount = "+a.totalPrice);
                        System.out.println(Arrays.toString(a.foodQuantity));
                    }
                }
                System.out.println("--------------------------------\n");
            }
        }
    }

    static void viewOrder(int h)
    {

        System.out.println("");

        for(FoodOrder a:orderList)
        {
            if(a!=null)
            {
                j++;
                System.out.println("Fetching Order Status");
                System.out.println("---------Order Details---------");
                System.out.println("Customer Name : " + a.customerName);
                System.out.println("Order Id:  #"+Math.random()*10000);
                System.out.println("Items Orderd :");
                for(int n=0;n<4;n++) {
                    if (a.foodQuantity[n] != 0)
                    {
                        System.out.println(n + 1 + a.foodQuantity[n] + " x " + a.foodList[n] + " = Rs." + a.foodPrice[n]);
                        System.out.println("Total Amount = "+a.totalPrice);
                        System.out.println(Arrays.toString(a.foodQuantity));
                    }
                }
                System.out.println("Order Status: Out For Delivery");
                int s=20;
                System.out.println("ETA: "+ (int) ((s--) - (Math.random() * 10)) + "mins");
                System.out.println("--------------------------------");
            }
        }


    }
}


