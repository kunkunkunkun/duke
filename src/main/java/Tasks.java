import java.util.ArrayList;
import java.util.Arrays;

public class Tasks
{
    protected String description;
    protected boolean isDone;

    protected String TaskName ="";

    public Tasks(){}
    public Tasks(String description) {
        this.description = description;
        this.isDone = false;
        this.TaskName = " ";
    }

    public String getDescription() {return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String toString()
    {
        //return this.description;
        return "["+this.getStatusIcon()+"] "+ this.description;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }
    public void ConvertStringToArrayList(String Userinput)
    {
    }
    public static void PrintSplitString(ArrayList<Tasks> Input)
    {
        //int count =1;//String output="";
        for (int i =0;i<Input.size();i++)
        {
            System.out.println(i+1+".["+ Input.get(i).TaskName+"]"+"["+Input.get(i).getStatusIcon()+"] "+ Input.get(i).description);
        }
    }

}
