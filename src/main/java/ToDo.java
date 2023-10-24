import java.util.ArrayList;
import java.util.Arrays;

public class ToDo extends Tasks
{
    //String TaskName = "T";
    public ToDo(String description,Boolean isDone)
    {
        this.description=description;
        this.isDone=isDone;
        this.TaskName="T";
    }
    ToDo()
    {

    }
    @Override
    public void ConvertStringToArrayList(String Userinput)
    {
        Userinput=Userinput.substring(5).trim(); //get string after Todo
        this.description=Userinput;
    }

    @Override
    public String toString()
    {
        return "[T]" + super.toString();
    }

}
