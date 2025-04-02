package FoodOrderSystemConsoleProject;

public class DeliveryAgent
{
    static final DeliveryAgent []riders= new DeliveryAgent[5];
    private String name;
    private long mobileNo;
    DeliveryAgent(String name,long mobileNo)
    {
            this.name=name;
            this.mobileNo=mobileNo;
    }
    DeliveryAgent(){}

    void setRiders()
    {
        riders[0]=new DeliveryAgent("Dinesh",9146574832l);
        riders[1]=new DeliveryAgent("Rahul",9878654343l);
        riders[2]=new DeliveryAgent("Mathesh",9778657483l);
        riders[3]=new DeliveryAgent("Rohit",8878667483l);
        riders[4]=new DeliveryAgent("Vignesh",9378657483l);

    }
    void assigning_Agent()
    {
        setRiders();
        int j=FoodOrder.j;
        if(FoodOrder.orderList[j]!=null)
        {
            System.out.println("Assigning Delivery Agent.......");
            System.out.println("Rider Name: " + riders[j].name + " Mobile No: " + riders[j++].mobileNo);
        }
    }
    void assigning_Agent(int k)
    {
        int j=FoodOrder.j;
        if(FoodOrder.orderList[j]!=null)
        {
            System.out.println("Rider Name: " + riders[j].name + " Mobile No: " + riders[j++].mobileNo);
        }
    }
}

