
public class Tasks
{
    protected String description;
    protected boolean isDone;

    public Tasks(){

    }
    public Tasks(String description,Boolean isDone) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

}
