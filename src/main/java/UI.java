import java.util.Scanner;

public class Ui
{
    private final String LineBreaker = "____________________________________________________________\n";
    private static final String Greeting = "Hello! I'm JohnCena\n" + "What can I do for you?\n";
    private static final String Farewell = "Bye. Hope to see you again soon!\n";
    private static final String MsgMark = "Nice! I've marked this task as done:";
    private static final String MsgUnmark = "OK, I've marked this task as not done yet:";
    private static final String MsgList = "Here are the tasks in your list:";
    private static final String MsgTaskAdded = "Got it. I've added this task:";
    private static final String MsgDelete = "Noted. I've removed this task:";
    private static final String LoadingError = "Sorry, I couldn't find the file, But i'll help you navigate to the correct place :D";

    public void ShowWelcomeMsg()
    {
        System.out.println(LineBreaker);
        System.out.println(Greeting);
    }
    public void ShowGoodByeMsg()
    {
        System.out.println(Farewell);
    }
    public void showMarkedMsg()
    {
        System.out.println(MsgMark);
    }
    public void showTaskAdded() {System.out.println(MsgTaskAdded);}
    public void showListMsg()
    {
        System.out.println(MsgList);
    }
    public void showDeleteMsg()
    {
        System.out.println(MsgDelete);
    }

    public void showUnmarkedMsg()
    {
        System.out.println(MsgUnmark);
    }
    public void Lvl0Msg()
    {
        System.out.println(LineBreaker);
        System.out.print(Greeting);
        System.out.println(LineBreaker);
        System.out.print(Farewell);
        System.out.println(LineBreaker);
    }
    public void showLoadingError()
    {
        showError(LoadingError);
    }
    public void PrintTaskMsg(String ToString)
    {
        System.out.println("  " + ToString);
    }

    public void printTaskList(TaskList tskList)
    {
        tskList.PrintTaskList(tskList.StoredTaskList);
    }
    public void showLine()
    {
        System.out.println("________________________________________________________________");
    }
    public void showError(String Error){
        System.out.println("Error: "+Error);
    }

    public String readCommand()
    {
        Scanner SCAN = new Scanner(System.in);
        return SCAN.nextLine().trim();
    }

    public void PrintIndividualTask(Tasks tsk){System.out.println(tsk.toString());}
}
