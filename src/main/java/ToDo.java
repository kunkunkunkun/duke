public class ToDo extends Tasks
{
//    public void DoTaskCommand(String[]SplitStrings,String EventName)
//    {
//        System.out.print("Got it. I've added this task:\n");
//        SplitStrings[SplitStrings.length-1]="[T][] "+EventName;
//        //System.out.print(SplitStrings[SplitStrings.length-1]);// SplitStrings is the split levelmsg
//        System.out.print("\nNow you have"+ SplitStrings.length +"tasks in the list.\n");
//    }
public void DoTaskCommand(String[]SplitStrings,String EventName)
{
    System.out.print("Got it. I've added this task:\n");
    SplitStrings[SplitStrings.length-1]="[T][] "+EventName;
    //System.out.print(SplitStrings[SplitStrings.length-1]);// SplitStrings is the split levelmsg
    System.out.print("\nNow you have"+ SplitStrings.length +"tasks in the list.\n");
}
//    @Override public void test ()
//    {
//        System.out.println("This is Tasks");
//    }
//    public void test (int i)
//    {
//        System.out.println("This is ToDo");
//    }
}
