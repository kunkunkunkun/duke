import java.util.Arrays;
import java.util.Scanner;

public class Duke extends Tasks{
    private static String LineBreaker = "____________________________________________________________\n";
    private static String Greeting = "Hello! I'm JohnCena\n" + " What can I do for you?";
    private static String Farewell = "Bye. Hope to see you again soon!\n";
    private static String MsgMark = "Nice! I've marked this task as done:";
    private static String MsgUnmark = "OK, I've marked this task as not done yet:";

    //Level 0. Rename, Greet, Exit
    public void Level0() {
        System.out.println(LineBreaker);
        System.out.println(Greeting);
        System.out.println(LineBreaker);
        System.out.println(Farewell);
        System.out.println(LineBreaker);
    }

    public void Level1() {
        Scanner SCAN = new Scanner(System.in);
        System.out.println(LineBreaker);
        System.out.println(Greeting);
        while (true) {
            String UserInput = SCAN.nextLine();
            if (UserInput.equals("bye")) {
                System.out.println(Farewell);
                break;
            } else {
                System.out.println(UserInput + "\n");
                continue;
            }
        }
        SCAN.close();
    }

    public void Level2() {
        Scanner SCAN = new Scanner(System.in);
        System.out.println(LineBreaker);
        System.out.println(Greeting);
        int index = 0;
        String[] Inputs = new String[100];
        String CurrentString = "";
        while (true) {
            CurrentString = SCAN.nextLine();
            if (CurrentString.equals("bye")) {
                System.out.println(Farewell);
                break;
            } else if (CurrentString.equals("list")) {
                for (int i = 0; Inputs[i] != null; i++) {
                    System.out.println(i + "." + Inputs[i]);
                }
                continue;
            }
            Inputs[index] = CurrentString;
            System.out.println("added: " + Inputs[index]);
            index++;

        }
        SCAN.close();
    }

    public void Level3()
    {
        Scanner SCAN = new Scanner(System.in);
        currentInput = SCAN.nextLine().trim();
        SplitStrings = Tasks.getSplitMsg(Level3_Tasks,"\n");

        System.out.println(LineBreaker);
        System.out.println("Please type in list to start");

        while (true)
        {
            SplitInput=currentInput.split(" ",2);
            if (currentInput.equals("list"))
            {
                Tasks.PrintOutMsg(SplitStrings);
                continue;
            }
            else if (currentInput.contains("mark")||currentInput.startsWith("unmark"))
            {
                if(currentInput.length()>4)
                {
                    int index = Integer.parseInt(SplitInput[1]);
                    if(currentInput.startsWith("mark")) {
                        SplitStrings[index] = SplitStrings[index].replace("[ ]", "[X]");
                        System.out.println(MsgMark);
                    }
                    else {
                        SplitStrings[index] = SplitStrings[index].replace("[X]", "[ ]");
                        System.out.println(MsgUnmark);
                    }
                    System.out.println(SplitStrings[index].substring(5).replace(SplitStrings[index].substring(0,2),"  "));

                }
                continue;
            }
            else if (currentInput.equals("bye")) {
                System.out.println(Farewell);
                break;
            }
        }
        SCAN.close();
    }
    public void Level4()
    {
        Scanner SCAN = new Scanner(System.in);
        Tasks.currentInput=SCAN.nextLine().trim();
        Tasks Todo = new Tasks();
        SCAN.close();
    }
    public void main (String[]args)
    {
        ///Testing
//        String Test = "Hello World";
//        String[] TestArray = new String[100];
//        TestArray=Level3_Tasks.split("\n",4);
//        for (String s:TestArray)
//        {
//            System.out.println("NewLine");
//            System.out.println(s);
//        }
//        System.out.println(TestArray[1]);
        //Level0();
        //Level1();
        //Level2();
        //Level3();
        Level4();


//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
//        System.out.println("Hello from\n" + logo);
    }
}

