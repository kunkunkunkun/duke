package duke.tasks;

import duke.utility.DukeException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Tasks
{
    protected String description;
    protected boolean isDone;

    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM dd yyyy");
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

    public String InputTimeConvertor(String InputTime) throws DateTimeParseException
    {
        LocalDate LD = LocalDate.parse(InputTime,INPUT_FORMAT);
        return LD.format(OUTPUT_FORMAT);
    }
    public String OutputTimeConvertor(String InputTime) throws DateTimeParseException
    {
        LocalDate LD = LocalDate.parse(InputTime,OUTPUT_FORMAT);
        return LD.format(INPUT_FORMAT);
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
