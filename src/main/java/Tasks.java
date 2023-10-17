import java.util.ArrayList;

public class Tasks
{
    public void DoTaskCommand()
    {

    }

    public static String[] getSplitMsg(String TargetMsg,String SpltBy,int splits)
    {
        TargetMsg=TargetMsg.trim();
        return TargetMsg.split(SpltBy,splits);
    }
    public static String[] getSplitMsg(String TargetMsg,String SpltBy)
    {
        TargetMsg=TargetMsg.trim();
        return TargetMsg.split(SpltBy);
    }
//    public static ArrayList<String> getArrayListSplitMsg(String TargetMsg, String SpltBy)
//    {
//        TargetMsg=TargetMsg.trim();
//        return TargetMsg.split(SpltBy);
//    }
    public static void SplitEventCommand(String[]SplitInput,String InputCommand)
    {
        SplitInput=getSplitMsg(InputCommand," ",2);
    }

    public static String GetEventName(String[] SplitInput)
    {
        for (int i =1;i<SplitInput.length;i++)
        {
            if(!SplitInput[i].contains("/"))
            SplitInput[0]+=SplitInput[i];
        }
        return SplitInput[0];
    }
//    public void test ()
//    {
//        System.out.println("This is Tasks");
//    }
    public static void PrintOutMsg(String[] SplitMsg)
    {
        for (String S : SplitMsg)
        {
            System.out.println(S);
            //System.out.println("New line!!!!!");
        }
        //System.out.print("\nNow you have"+ SplitMsg.length +"tasks in the list.\n");
    }

}
