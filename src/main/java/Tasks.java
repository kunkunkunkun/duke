public class Tasks
{
    public Tasks()
    {
    }
    public static String Level3_Tasks =
            "   Here are the tasks in your list:\n" +
                    "     1.[X] read book\n" +
                    "     2.[ ] return book\n" +
                    "     3.[ ] buy bread";
    public static String Level4_Tasks =
            "     Here are the tasks in your list:\n" +
                    "     1.[T][X] read book\n" +
                    "     2.[D][ ] return book (by: June 6th)\n" +
                    "     3.[E][ ] project meeting (from: Aug 6th 2pm to: 4pm)\n" +
                    "     4.[T][X] join sports club\n" +
                    "     5.[T][ ] borrow book";
    public static String currentInput;
    public static String[] SplitInput = new String[100];
    public static String[] SplitStrings = new String[100];

    public static String[] getSplitMsg(String TargetMsg,String SpltBy)
    {
        TargetMsg=TargetMsg.trim();
        return TargetMsg.split(SpltBy);
    }

    public static void PrintOutMsg(String[] SplitMsg)
    {
        for (String S : SplitMsg)
        {
            System.out.println(S);
        }
    }

}
