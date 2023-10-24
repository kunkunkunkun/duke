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

    public static void TestCases()
    {
        //level 3
        //StoredUserInput.add(new Tasks("read book",false));
        //StoredUserInput.add(new Tasks ("return book",false));
        //StoredUserInput.add(new Tasks("buy book",false));

        //level 4
        StoredUserInput.add(new ToDo("read book",true));
        StoredUserInput.add(new Deadline("return book",false,"June 6th"));
        StoredUserInput.add(new Event("project meeting ",false,"Aug 6th 2pm","4pm"));
        StoredUserInput.add(new ToDo("join sports club",true));
    }
    public static void main (String[]args)
    {
        //General
        TestCases();
        System.out.print(LineBreaker);
        System.out.print(Greeting);

        Scanner SCAN = new Scanner(System.in);
        String UserInput = "";

        //Level 0
        //System.out.println(LineBreaker);
        //System.out.print(Greeting);
        //System.out.println(LineBreaker);
        //System.out.print(Farewell);
        //System.out.println(LineBreaker);

        //Level 1&2&3
        while (true) {
            UserInput = SCAN.nextLine().trim(); // Get user input in string
            if (UserInput.equals("bye")) {
                System.out.println(Farewell);
                break;
            }
            else if (UserInput.equals("list"))
            {
                System.out.println("Here are the tasks in your list:");
                PrintSplitString(StoredUserInput);
            }
            else if (UserInput.startsWith("mark"))
            {
                String[]SplitMsg = UserInput.split(" ");
                Tasks Tsk = StoredUserInput.get(Integer.parseInt(SplitMsg[1])-1); //Used for Mark and Unmark.
                Tsk.isDone=true; //
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(Tsk.toString());

            }
            else if (UserInput.startsWith("unmark"))
            {
                String[]SplitMsg = UserInput.split(" ");
                Tasks Tsk = StoredUserInput.get(Integer.parseInt(SplitMsg[1])-1); //Used for Mark and Unmark.
                Tsk.isDone=false;
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println(Tsk.toString());
            }
            else if (UserInput.startsWith("todo"))
            {
                ToDo TD = new ToDo("",false);
                TD.ConvertStringToArrayList(UserInput);
                System.out.println("Got it. I've added this task:");
                System.out.println("  "+TD.toString());
                StoredUserInput.add(TD);
                System.out.println("Now you have " +StoredUserInput.size()+ " tasks in the list");
            }
            else if (UserInput.startsWith("deadline"))
            {
                Deadline DL = new Deadline("",false,"");
                DL.ConvertStringToArrayList(UserInput);
                System.out.println("Got it. I've added this task:");
                System.out.println("  "+DL.toString());
                StoredUserInput.add(DL);
                System.out.println("Now you have " +StoredUserInput.size()+ " tasks in the list");
            }
            else if (UserInput.startsWith("event"))
            {
                Event Evt = new Event("",false,"","");
                Evt.ConvertStringToArrayList(UserInput);
                System.out.println("Got it. I've added this task:");
                System.out.println("  "+Evt.toString());
                StoredUserInput.add(Evt);
                System.out.println("Now you have " +StoredUserInput.size()+ " tasks in the list");
            }
            else {
                StoredUserInput.add(new Tasks (UserInput));
                System.out.println("New Item added!!");
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

