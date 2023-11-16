/**
 * Represents a class that deals with user interaction
 * it provides messages to be printed out and also read user input
 * This class is part of the utility pattern implementation.
 *
 * @author Yan Kun
 * @version 1.0
 * @since 1.0
 */
package duke.utility;

import duke.tasks.Tasks;

import java.util.Scanner;

public class Ui
{
    private final String LineBreaker = "____________________________________________________________\n";
    private static final String Greeting = "Hello! I'm JohnCena\n" + "What can I do for you?\n";
    private static final String Farewell = "Bye. Hope to see you again soon!\n";
    private static final String MsgMark = "Nice! I've marked this task as done:";
    private static final String MsgUnmark = "OK, I've marked this task as not done yet:";
    private static final String MsgList = "Here are the duke.tasks in your list:";
    private static final String MsgTaskAdded = "Got it. I've added this task:";
    private static final String MsgDelete = "Noted. I've removed this task:";
    private static final String LoadingError = "Sorry, I couldn't find the file, But i'll help you navigate to the correct place :D";

    /** * print specific message */
    public void ShowWelcomeMsg()
    {
        System.out.println(LineBreaker);
        System.out.println(Greeting);
    }
    /** * print specific message */
    public void ShowGoodByeMsg()
    {
        System.out.println(Farewell);
    }

    /** * print specific message */
    public void showMarkedMsg()
    {
        System.out.println(MsgMark);
    }

    /** * print specific message */
    public void showTaskAdded() {System.out.println(MsgTaskAdded);}

    /** * print specific message */
    public void showListMsg()
    {
        System.out.println(MsgList);
    }

    /** * print specific message */
    public void showDeleteMsg()
    {
        System.out.println(MsgDelete);
    }

    /** * print specific message */
    public void showUnmarkedMsg()
    {
        System.out.println(MsgUnmark);
    }

    /** * print level 0 message */
    public void Lvl0Msg()
    {
        System.out.println(LineBreaker);
        System.out.print(Greeting);
        System.out.println(LineBreaker);
        System.out.print(Farewell);
        System.out.println(LineBreaker);
    }

    /** * print specific message */
    public void showLoadingError()
    {
        showError(LoadingError);
    }

    /** * print specific message */
    public void PrintTaskMsg(String ToString)
    {
        System.out.println("  " + ToString);
    }

    /** * print specific message */
    public void printTaskList(TaskList tskList)
    {
        tskList.PrintTaskList(tskList.StoredTaskList);
    }

    /** * print specific message */
    public void showLine()
    {
        System.out.println("________________________________________________________________");
    }

    /** * print specific message */
    public void showError(String Error){
        System.out.println("Error: "+Error);
    }

    /** * read command from user */
    public String readCommand()
    {
        Scanner SCAN = new Scanner(System.in);
        return SCAN.nextLine().trim();
    }

    /**
     * print all tasks in the task list message
     * it runs tostring function to turn task into string then print out
     * */
    public void PrintIndividualTask(Tasks tsk){System.out.println(tsk.toString());}
}
