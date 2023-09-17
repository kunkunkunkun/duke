import java.util.Scanner;

public class Duke {
    private static String LineBreaker = "____________________________________________________________\n";
    private static String Greeting = "Hello! I'm JohnCena\n" + " What can I do for you?";
    private static String Farewell = "Bye. Hope to see you again soon!\n";
    //Level 0. Rename, Greet, Exit
    public static void Level0()
    {
        System.out.println(LineBreaker);
        System.out.println(Greeting);
        System.out.println(LineBreaker);
        System.out.println(Farewell);
        System.out.println(LineBreaker);
    }
    public static void Level1()
    {
        Scanner SCAN = new Scanner(System.in);
        System.out.println(LineBreaker);
        System.out.println(Greeting);
        while (true)
        {
            String UserInput = SCAN.nextLine();
            if (UserInput.equals("bye"))
            {
                System.out.println(Farewell);
                break;
            }
            else {
                System.out.println(UserInput + "\n");
                continue;
            }
        }
    }
    public static void Level2()
    {
        Scanner SCAN = new Scanner(System.in);
        System.out.println(LineBreaker);
        System.out.println(Greeting);
        int index = 0;
        String Inputs[]=new String[100];
        String CurrentString="";
        while(true)
        {
            CurrentString = SCAN.nextLine();
            if(CurrentString.equals("bye"))
            {
                System.out.println(Farewell);
                break;
            }
            else if(CurrentString.equals("list"))
            {
                for (int i=0;Inputs[i]!=null;i++)
                {
                    System.out.println( i + "." + Inputs[i]);
                }
                continue;
            }
            Inputs[index] = CurrentString;
            System.out.println("added: " +Inputs[index]);
            index++;

        }
        SCAN.close();
    }
    public static void main(String[] args)
    {
        //Level0();
        Level1();
        //Level2();


//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
//        System.out.println("Hello from\n" + logo);
    }
}
