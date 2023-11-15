package duke.tasks;

public class Deadline extends Tasks
{
    protected String by="1000-01-01";

    public Deadline(String description,Boolean isDone,String by)
    {
        this.by=by;
        this.description=description;
        this.isDone=isDone;
        this.TaskName=Enums.D.toString();
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getBy() {
        return by;
    }

    @Override
    public void ConvertStringToArrayList(String Userinput)
    {

        Userinput=Userinput.substring(9).trim(); //get string after Todo
        String[] SplitString=Userinput.split("/by");
        this.SplitStringSize=SplitString.length;
        if (SplitStringSize<2)
        {
            this.description=SplitString[0].trim();
            this.by="";
        }
        else
        {
            this.description=SplitString[0].trim();
            this.by=SplitString[1].trim();
        }
    }
    @Override
    public String toString()
    {
        //return "[D][X] join sports club /by 2023-02-12";
        return "[D]" + super.toString() + " (by: " + this.by + ")";
    }
}
