package E_Commerce_Site;

import java.util.Scanner;

public class Products
{
    Scanner sc=new Scanner(System.in);
    Cart cart_obj=new Cart();

    String name="";
    int price;
    int product_Id;
    private int stock_available;

    int getStock_available(Products obj)
    {
        return obj.stock_available;
    }

    void set_stock_available(int stock)
    {
        this.stock_available=stock;
    }

    Products(){}
    Products(String name,int price,int product_Id,int stock_available)
    {
        this.name=name;
        this.price=price;
        this.product_Id=product_Id;
        this.stock_available=stock_available;
    }


    void product_Display()
    {
        Products a=new Products("Apple 1kg",10,001,100);
        Products o=new Products("Onion 1kg",30,002,100);
        Products c=new Products("coconut_oil 1l",100,003,100);
        Products g=new Products("Ghee 1l",500,004,100);
        Products m=new Products("Milk 1l",50,005,100);


        System.out.println("1."+a.name+" Price:"+a.price);
        System.out.println("2."+o.name+" Price:"+o.price);
        System.out.println("3."+c.name+" Price:"+c.price);
        System.out.println("4."+g.name+" Price:"+g.price);
        System.out.println("5."+m.name+" Price:"+m.price);

        System.out.println("Choose Your Product To buy");
        int option=sc.nextInt();
        switch(option)
        {
            case 1:
                System.out.println("Enter Quantity");
                int qty1=sc.nextInt();
                cart_obj.add("Apple",0,qty1,a.price);
                break;

            case 2:
                System.out.println("Enter Quantity");
                int qty2=sc.nextInt();
                cart_obj.add("Onion",1,qty2,o.price);
                break;

            case 3:
                System.out.println("Enter Quantity");
                int qty3=sc.nextInt();
                cart_obj.add("coconut oil",2,qty3,c.price);
                break;

            case 4:
                System.out.println("Enter Quantity");
                int qty4=sc.nextInt();
                cart_obj.add("ghee",3,qty4,g.price);
                break;

            case 5:
                System.out.println("Enter Quantity");
                int qty5=sc.nextInt();
                cart_obj.add("milk",4,qty5,m.price);
                break;
        }
    }


}
