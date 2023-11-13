package duke.tasks;

public class Tasks
{
    protected String description;
    protected boolean isDone;

    protected int SplitStringSize;
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

}
