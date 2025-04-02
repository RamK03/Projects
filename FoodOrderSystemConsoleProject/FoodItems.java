package FoodOrderSystemConsoleProject;

public class FoodItems
{
    static FoodItems food_obj= new FoodItems();
    String name;
    double price;
    static int id;
    static FoodItems []food=new FoodItems[4];

   FoodItems(){}
   FoodItems(String name, double price, int id)
   {
        this.name=name;
       this.price=price;
       this.id=id;
   }

   void setFood()
   {
       food[0]=new FoodItems("Burger",120,0);
       food[1]=new FoodItems("Pizza",320,1);
       food[2]=new FoodItems("Coke",100,2);
       food[3]=new FoodItems("Hot Choclate",200,3);
   }

  static void displayFoodItems()
   {
       food_obj.setFood();
       System.out.println("--------Available Items--------");
       int c=1;
       for(FoodItems a:food_obj.food)
       {
           System.out.println("  "+(c++)+". "+a.name+" - "+"Rs."+a.price+" ");
       }
       System.out.println("---------------------------------");
   }
}
