public class Event extends Tasks
{
    protected String From;
    protected String To;
    public Event(String description,Boolean isDone,String From,String To)
    {
        this.description=description;
        this.isDone=isDone;
        this.TaskName=Enums.E.toString();
        this.From=From;
        this.To=To;
    }
    @Override
    public void ConvertStringToArrayList(String Userinput)
    {
        Userinput=Userinput.substring(6).trim(); //get string after Event
        String[] SplitString=Userinput.split("/");
        this.SplitStringSize=SplitString.length;
        if (SplitStringSize<4)
        {
            this.description=SplitString[0].trim();
            this.From="";
            this.To="";
        }
        else
        {
            this.description=SplitString[0].trim();
            this.From=SplitString[1].substring(5).trim();
            this.To=SplitString[2].substring(3).trim();
        }
        this.description=SplitString[0].trim();

    }
    @Override
    public String toString()
    {
        return "[E]" + super.toString() + " (from: " + From +" to: "+To+ ")";
    }
}
