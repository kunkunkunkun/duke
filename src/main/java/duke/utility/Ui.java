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
    //******** Generic String ********
    private static final String LINE_BREAKER = "____________________________________________________________\n";
    private static final String GREETING = "Hello! I'm JohnCena\n What can I do for you?\n";
    private static final String FAREWELL = "Bye. Hope to see you again soon!\n";

    //******** Command Message ********
    private static final String MSG_MARK = "Nice! I've marked this task as done:";
    private static final String MSG_UNMARK = "OK, I've marked this task as not done yet:";
    private static final String MSG_LIST = "Here are the duke.tasks in your list:";
    private static final String MSG_TASK_ADDED = "Got it. I've added this task:";
    private static final String MSG_DELETE = "Noted. I've removed this task:";
    private static final String COMMAND_FIND = "Here is the find result:";

    //******** Error Message ********
    private static final String LOADING_ERROR = "Sorry, I couldn't find the file, "
                                                + "But i'll help you navigate to the correct place :D";
    private static final String DUKE_LOGO =
                  " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";


    /** * print specific message */
    public void ShowWelcomeMsg() {
        System.out.println(LINE_BREAKER);
        System.out.println(GREETING);
    }
    /** * print specific message */
    public void ShowGoodByeMsg() {
        System.out.println(FAREWELL);
    }

    /** * print specific message */
    public void showMarkedMsg() {
        System.out.println(MSG_MARK);
    }

    /** * print specific message */
    public void showTaskAdded() {
        System.out.println(MSG_TASK_ADDED);
    }

    /** * print specific message */
    public void showListMsg() {
        System.out.println(MSG_LIST);
    }

    /** * print specific message */
    public void showDeleteMsg() {
        System.out.println(MSG_DELETE);
    }

    /** * print specific message */
    public void showUnmarkedMsg() {
        System.out.println(MSG_UNMARK);
    }

    public void showDukeLogo(){System.out.println("Hello from\n" + DUKE_LOGO);}

    /** * print level 0 message */
    public void Lvl0Msg() {
        System.out.println(LINE_BREAKER);
        System.out.print(GREETING);
        System.out.println(LINE_BREAKER);
        System.out.print(FAREWELL);
        System.out.println(LINE_BREAKER);
    }

    /** * print specific message */
    public void showLoadingError() {
        showError(LOADING_ERROR);
    }

    /** * print specific message */
    public void printTaskMsg(String toString) {
        System.out.println("  " + toString);
    }

    /** * print specific message */
    public void printTaskList(TaskList tskList) {
        tskList.printTaskList(tskList.storedTaskList);
    }

    /** * print specific message */
    public void showLine() {
        System.out.println(LINE_BREAKER);
    }

    /** * print specific message */
    public void showError(String error){
        System.out.println("Error: "+error);
    }

    public void findCommand(){
        System.out.println(COMMAND_FIND);
    }

    /** * read command from user */
    public String readCommand() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine().trim();
    }
    public void printNumberOfTask(TaskList tskList){
        System.out.println("Now you have "+ tskList.storedTaskList.size()+ " tasks in the list");
    }

    /**
     * print all tasks in the task list message
     * it runs tostring function to turn task into string then print out
     * */
    public void printIndividualTask(Tasks tsk){
        System.out.println(tsk.toString());
    }
}
