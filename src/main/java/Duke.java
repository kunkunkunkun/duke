import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Duke extends Tasks{
    private static final String LineBreaker = "____________________________________________________________\n";
    private static final String Greeting = "Hello! I'm JohnCena\n" + "What can I do for you?\n";
    private static final String Farewell = "Bye. Hope to see you again soon!\n";
    private static final String MsgMark = "Nice! I've marked this task as done:";
    private static final String MsgUnmark = "OK, I've marked this task as not done yet:";

    public static ArrayList<Tasks> StoredUserInput = new ArrayList<>();
    public static ArrayList<String> SplitUserInput = new ArrayList<>();
    public static String[] Userinput;

    //public static String[] SplitStrings = new String[100];

    //public static ArrayList<String> SplitMsg = new ArrayList<>();
    //public static ArrayList<String> SplitCommand = new ArrayList<>();

//    public static void Level3()
//    {
//        Scanner SCAN = new Scanner(System.in);
//        //Tasks Tsk = new Tasks();
//        //currentInput = SCAN.nextLine().trim();
//        SplitStrings = getSplitMsg(Level3_Tasks,"\n",2);
//        //Tasks Tsk = new Tasks();
//
//        System.out.println(LineBreaker);
//        System.out.println("Please type in list to start");
//
//        while (true)
//        {
//            currentInput = SCAN.nextLine().trim();
//            SplitInput=currentInput.split(" ",2);
//            if (currentInput.equals("list"))
//            {
//                PrintOutMsg(SplitStrings);
//            }
//            else if (currentInput.contains("mark")||currentInput.startsWith("unmark"))
//            {
//                if(currentInput.length()>4)
//                {
//                    int index = Integer.parseInt(SplitInput[1]);
//                    if(currentInput.startsWith("mark")) {
//                        SplitStrings[index] = SplitStrings[index].replace("[ ]", "[X]");
//                        System.out.println(MsgMark);
//                    }
//                    else {
//                        SplitStrings[index] = SplitStrings[index].replace("[X]", "[ ]");
//                        System.out.println(MsgUnmark);
//                    }
//                    System.out.println(SplitStrings[index].substring(5).replace(SplitStrings[index].substring(0,2),"  "));
//
//                }
//                continue;
//            }
//            else if (currentInput.equals("bye")) {
//                System.out.println(Farewell);
//                break;
//            }
//        }
//        SCAN.close();
//    }
//    public static void Level4()
//    {
//        String EventName;
//        String[] ByWhen = new String[100];
//        String[] Event = new String[100];
//
//        //SplitMsg=getArrayListSplitMsg(Level4_Tasks,"\n");
//        System.out.println("Please type in list to start");
//        Scanner SCAN = new Scanner(System.in);
//        while (true)
//        {
//            currentInput=SCAN.nextLine();
//            SplitInput=getSplitMsg(currentInput," ",2);
////            Event = getSplitMsg(SplitInput[0],"/",2);
////            ByWhen = getSplitMsg(SplitInput[1],"/",2);
//
//            switch (SplitInput[0].toUpperCase())
//            {
//                case "TODO":
//                    ToDo Todo = new ToDo();
//                    Todo.DoTaskCommand(SplitStrings,SplitInput[1]);
//                    break;
//                case "DEADLINE":
//                    break;
//                case "EVENT":
//                    break;
//                case "LIST":
//                    PrintOutMsg(SplitStrings);
//                    break;
//            }
//        }
////        //Tasks.currentInput=SCAN.nextLine().trim();
////        Tasks TodoTask = new ToDo(SCAN.nextLine().trim());
////        SCAN.close();
//    }
public static ArrayList<String> ConvertStringToArrayList(String Userinput)
{
    ArrayList<String> Output=new ArrayList<String>();
    String[] SplitString=Userinput.split(" ");
    Output.addAll(Arrays.asList(SplitString));
    return Output;
}
public static void PrintSplitString(ArrayList<Tasks> Input)
{
    int count =1;//String output="";
    for(Tasks S:Input)
    {
        System.out.println(count+".["+S.getStatusIcon()+"] "+ S.description);
        count++;
    };
}
    public static void main (String[]args)
    {
        //General
        StoredUserInput.add(new Tasks("read book",false));
        StoredUserInput.add(new Tasks ("return book",false));
        StoredUserInput.add(new Tasks("buy book",false));
        System.out.print(LineBreaker);
        System.out.print(Greeting);
        //StoredUserInput=null;
        Scanner SCAN = new Scanner(System.in);
        String UserInput = "";
        //SplitUserInput=ConvertStringToArrayList(UserInput);

        //Level 0
        //System.out.println(LineBreaker);
        //System.out.print(Greeting);
        //System.out.println(LineBreaker);
        //System.out.print(Farewell);
        //System.out.println(LineBreaker);

        //Level 1&2
        while (true) {
            UserInput = SCAN.nextLine().trim();
            SplitUserInput=ConvertStringToArrayList(UserInput);
            int index = 0; // Find which element to mark.unmark
            if (UserInput.equals("bye")) {
                System.out.println(Farewell);
                break;
            } else if (UserInput.equals("list"))
            {
                System.out.println("Here are the tasks in your list:");
                PrintSplitString(StoredUserInput);
            }
            else if (SplitUserInput.get(0).equals("mark"))
            {
                index = Integer.parseInt(SplitUserInput.get(1))-1;
                StoredUserInput.get(index).isDone=true;
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("["+StoredUserInput.get(index).getStatusIcon()+"] "+ StoredUserInput.get(index).description);
            }
            else if (SplitUserInput.get(0).equals("unmark"))
            {
                index = Integer.parseInt(SplitUserInput.get(1))-1;
                StoredUserInput.get(index).isDone=false;
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println("["+StoredUserInput.get(index).getStatusIcon()+"] "+ StoredUserInput.get(index).description);
            }else {
                StoredUserInput.add(new Tasks (UserInput,false));
                System.out.println("New Item added!!");
                //System.out.println(UserInput + "\n"); // level 1
                continue;
            }
        }

//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
//        System.out.println("Hello from\n" + logo);
    }
}

