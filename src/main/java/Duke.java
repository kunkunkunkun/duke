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
    private static final String MsgList = "Here are the tasks in your list:";
    private static final String MsgTodo = "Got it. I've added this task:";
    private static final String MsgDeadline = "Got it. I've added this task:";
    private static final String MsgEvent = "Got it. I've added this task:";

    private static final String MsgDelete = "Noted. I've removed this task:";


    public static ArrayList<Tasks> StoredUserInput = new ArrayList<>();
    public static ArrayList<String> UserCommands = new ArrayList<String>();

    public static void TestCases()
    {
        UserCommands.add("list");
        UserCommands.add("bye");
        UserCommands.add("mark");
        UserCommands.add("unmark");
        UserCommands.add("todo");
        UserCommands.add("deadline");
        UserCommands.add("event");
        UserCommands.add("delete");

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
    private static void ErrorChecker(String UserInput,String Command) throws DukeException
    {
        boolean IsValidInput=false;
        for (String S:UserCommands)
        {
            if (S.equals(Command))
            {
                IsValidInput=true;
            }
        }
        if(IsValidInput)
        {
            if(UserInput.split(" ").length<2&&!Command.equals("list")&&!Command.equals("bye"))
            {
                //Result="Test";
                throw new DukeInvalidValueException("OOPS!!! The description of a "+Command+" cannot be empty.");
            }
        }
        else
        {
            throw new DukeInvalidValueException("OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
//        {
//            throw new DukeInvalidValueException("Wrong input");
//        }

    }
    public static void main (String[]args) throws DukeException {
        //General
        TestCases();
        System.out.print(LineBreaker);
        System.out.print(Greeting);
        Enums TaskEnum;

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
            try
            {
                String Command = UserInput.split(" ")[0];
                ErrorChecker(UserInput,Command);
                if(UserInput.split("").length<2)
                {
                    throw new DukeInvalidValueException("");
                }
                else if (UserInput.equals("bye")) {
                    System.out.println(Farewell);
                    break;
                } else if (UserInput.equals("list")) {
                    System.out.println(MsgList);
                    PrintSplitString(StoredUserInput);
                } else if (UserInput.startsWith("mark")) {
                    String[] SplitMsg = UserInput.split(" ");
                    Tasks Tsk = StoredUserInput.get(Integer.parseInt(SplitMsg[1]) - 1); //Used for Mark and Unmark.
                    Tsk.isDone = true; //
                    System.out.println(MsgMark);
                    System.out.println(Tsk.toString());
                } else if (UserInput.startsWith("unmark")) {
                    String[] SplitMsg = UserInput.split(" ");
                    Tasks Tsk = StoredUserInput.get(Integer.parseInt(SplitMsg[1]) - 1); //Used for Mark and Unmark.
                    Tsk.isDone = false;
                    System.out.println(MsgUnmark);
                    System.out.println(Tsk.toString());
                } else if (UserInput.startsWith("todo")) {
                    ToDo TD = new ToDo("", false);
                    TD.ConvertStringToArrayList(UserInput);
                    System.out.println(MsgTodo);
                    System.out.println("  " + TD.toString());
                    StoredUserInput.add(TD);
                    System.out.println("Now you have " + StoredUserInput.size() + " tasks in the list");
                } else if (UserInput.startsWith("deadline")) {
                    Deadline DL = new Deadline("", false, "");
                    DL.ConvertStringToArrayList(UserInput);
                    if(UserInput.contains("/by"))
                    {
                        if(DL.by.isEmpty())
                        {
                            throw new DukeInvalidValueException(" OOPS!!! This is a Deadline Task, Please Indicate an End Time :-(");
                        }
                    }
                    else
                    {
                        throw new DukeInvalidValueException(" OOPS!!! This is a Deadline Task, Please Follow this format " + "deadline *Event Name* /by *End Date*");
                    }
                    System.out.println(MsgDeadline);
                    System.out.println("  " + DL.toString());
                    StoredUserInput.add(DL);
                    System.out.println("Now you have " + StoredUserInput.size() + " tasks in the list");
                } else if (UserInput.startsWith("event")) {
                    Event Evt = new Event("", false, "", "");
                    Evt.ConvertStringToArrayList(UserInput);
                    if(UserInput.contains("/from")&&UserInput.contains("/to"))
                    {
                        if(Evt.From.isEmpty())
                        {
                            throw new DukeInvalidValueException(" OOPS!!! This is a Event Task, Please Indicate a Start Time :-(");
                        }
                        if(Evt.To.isEmpty())
                        {
                            throw new DukeInvalidValueException(" OOPS!!! This is a Event Task, Please Indicate an End Time :-(");
                        }
                    }
                    else
                    {
                        throw new DukeInvalidValueException(" OOPS!!! This is a Event Task, Please Follow this format "+"event *Your Task* /from *Start Date* /to *End Date*");
                    }
                    System.out.println(MsgEvent);
                    System.out.println("  " + Evt.toString());
                    StoredUserInput.add(Evt);
                    System.out.println("Now you have " + StoredUserInput.size() + " tasks in the list");
//                } else if (UserInput.startsWith("delete")) {
//                    String[] SplitMsg = UserInput.split(" ");
//                    Tasks Tsk = StoredUserInput.get(Integer.parseInt(SplitMsg[1]) - 1); //Used for Mark and Unmark.
//                    StoredUserInput.remove(Integer.parseInt(SplitMsg[1]) - 1);
//                    System.out.println(MsgDelete);
//                    System.out.println(Tsk.toString());
//                }
        }
            catch (DukeException e) {
                System.out.println("Error: " + e.getMessage());
            }
//            catch (IllegalArgumentException e) {
//                System.out.println("Invalid command");
//            }

//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
//        System.out.println("Hello from\n" + logo);
    }
}
}

