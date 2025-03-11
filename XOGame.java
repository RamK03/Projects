import java.util.*;

class XOGame
{

    static Scanner sc=new Scanner(System.in);

    String user1;
    String user2;
    String  [][]arr=new String [3][3];
    boolean []occupied= new boolean[9];
    int position1;
    int position2;

    //Printing game template and calling prerequisites
    void gameTemplate()
    {
        System.out.println();

        for(int i=0;i<arr.length;i++)
        {
            Arrays.fill(arr[i],"-");
            for(int j=0;j<arr[0].length;j++)
            {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

        gamePrerequisites();
    }

    //getting icons for both users
    void gamePrerequisites()
    {
        do{
            user1Icon();
            user2Icon();

            if(user1==user2)
            {
                System.out.println(user2+" is already choosed, choose another");
                user2Icon();
            }
            else
            {
                System.out.println("Hi user1, your Icon is "+user1);
                System.out.println("Hi user2, your Icon is "+user2);
            }

        }
        while(!(user1.equals("x")&&user2.equals("o"))&&!(user2.equals("x")&&user1.equals("o")));
        gameAction();
    }

    //game validation
    void gameAction()
    {
        int count=0;
        int c=0;
        for(int i=0;i<9;i++)
        {

            positionOccupied1();
            boolean s=winnerValidation().equals(user1);
            c=c+1;

            if(s)
            {
                System.out.println("User1 is the Winner");
                count =1;
                break;
            }
            else
            {
                if(c==9){
                    break;
                }
                positionOccupied2();
                c=c+1;
                boolean s1=winnerValidation().equals(user2);
                if(s1)
                {
                    System.out.println("User2 is the Winner");
                    count=1;
                    break;
                }
            }


        }
        if(count==0)
        {
            System.out.println("Match is Draw");
        }
    }

    void user1Icon()
    {
        System.out.println("Hi user1,Choose your Icon X or O");
        user1=sc.next();
    }

    void user2Icon()
    {
        System.out.println("Hi user2,Choose your Icon X or O");
        user2=sc.next();
    }

    void position(int position,String s)
    {
        switch (position)
        {
            case 0:
                arr[0][0]=s;
                break;
            case 1:
                arr[0][1]=s;
                break;
            case 2:
                arr[0][2]=s;
                break;
            case 3:
                arr[1][0]=s;
                break;
            case 4:
                arr[1][1]=s;
                break;
            case 5:
                arr[1][2]=s;
                break;
            case 6:
                arr[2][0]=s;
                break;
            case 7:
                arr[2][1]=s;
                break;
            case 8:
                arr[2][2]=s;
                break;
        }

    }

    void arrayTraverse()
    {
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    //setting the user1 input
    void positionOccupied1()
    {
        System.out.println("user1 Enter you position from 0 to 8");
        position1=sc.nextInt();
        if(!(occupied[position1]))
        {
            position(position1,user1);
            occupied[position1]=true;
            arrayTraverse();
        }
        else
        {
            System.out.println("Position is already occupied");
            positionOccupied1();
        }

    }

    //setting the user2 input
    void positionOccupied2()
    {
        System.out.println("user2 Enter you position from 0 to 8");
        position2=sc.nextInt();
        if(!(occupied[position2]))
        {
            position(position2,user2);
            occupied[position2]=true;
            arrayTraverse();
        }
        else
        {
            System.out.println("Position is already occupied");
            positionOccupied2();
        }

    }

    String winnerValidation()
    {
        if((arr[0][0].equals(arr[0][1])) && (arr[0][0].equals(arr[0][2])) && arr[0][0].equals(user1))
        {
            return user1;
        }
        else if((arr[0][0].equals(arr[0][1])) && (arr[0][0].equals(arr[0][2])) && arr[0][0].equals(user2))
        {
            return user2;
        }
        else if((arr[1][0].equals(arr[1][1])) && (arr[1][0].equals(arr[1][2])) && arr[1][0].equals(user1))
        {
            return user1;
        }
        else if((arr[1][0].equals(arr[1][1])) && (arr[1][0].equals(arr[1][2])) && arr[1][0].equals(user2))
        {
            return user2;
        }
        else if((arr[2][0].equals(arr[2][1])) && (arr[2][0].equals(arr[2][2])) && arr[2][0].equals(user1))
        {
            return user1;
        }
        else  if((arr[2][0].equals(arr[2][1])) && (arr[2][0].equals(arr[2][2])) && arr[2][0].equals(user2))
        {
            return user2;
        }
        else if((arr[0][0].equals(arr[1][0])) && (arr[0][0].equals(arr[2][0])) && arr[0][0].equals(user1))
        {
            return user1;
        }
        else  if((arr[0][0].equals(arr[1][0])) && (arr[0][0].equals(arr[2][0])) && arr[0][0].equals(user2))
        {
            return user2;
        }
        else if((arr[0][2].equals(arr[1][2])) && (arr[0][2].equals(arr[2][2])) && arr[0][2].equals(user1))
        {
            return user1;
        }
        else  if((arr[0][2].equals(arr[1][2])) && (arr[0][2].equals(arr[2][2])) && arr[0][2].equals(user2))
        {
            return user2;
        }
        else if((arr[0][2].equals(arr[1][1])) && (arr[0][2].equals(arr[2][0])) && arr[0][2].equals(user1))
        {
            return user1;
        }
        else if((arr[0][2].equals(arr[1][1])) && (arr[0][2].equals(arr[2][0])) && arr[0][2].equals(user2))
        {
            return user2;
        }
        else if((arr[0][0].equals(arr[1][1])) && (arr[0][0].equals(arr[2][2])) && arr[0][0].equals(user1))
        {
            return user1;
        }
        else if((arr[0][0].equals(arr[1][1])) && (arr[0][0].equals(arr[2][2])) && arr[0][0].equals(user2))
        {
            return user2;
        }
        else
        {

            return "No winner";
        }




    }


    public static void main(String [] args)
    {
        XOGame obj= new XOGame();
        System.out.println("Welcome to the TicTacToe");
        obj.gameTemplate();
    }
}