public class Deadline extends Tasks
{
    protected String by;

    public Deadline(String description,Boolean isDone,String by)
    {
        this.description=description;
        this.isDone=isDone;
        this.TaskName=Enums.D.toString();
        this.by=by;
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
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
