/**
 * Represents a task with task description and status of the project weather it's done or undone.
 * This class has the following subclasses Todo, Deadline, Event
 *
 * @author Yan Kun
 * @version 1.0
 * @since 1.0
 */

package duke.tasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Tasks {
    protected String description;
    protected boolean isDone;

    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM dd yyyy");
    protected String taskName;

    public Tasks(){}
    public Tasks(String description) {
        this.description = description;
        this.isDone = false;
        this.taskName = " ";
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIsDone(boolean done) {
        isDone = done;
    }

    /**
     * it's a function designed to take in a time value in string
     * convert into "yyyy-MM-dd" format and return in MMM dd yyyy format.
     */
    public String convertInputTime(String inputTime) throws DateTimeParseException {
        LocalDate ld = LocalDate.parse(inputTime,INPUT_FORMAT);
        return ld.format(OUTPUT_FORMAT);
    }
    public LocalDate convertStringToDate(String inputTime) throws DateTimeParseException {
        return LocalDate.parse(inputTime,OUTPUT_FORMAT);
    }

    /**
     * it's a function designed to be overridden by subclasses
     * Return a string that contains the task details
     * which is task status, description.
     */
    public String toString() {
        return "["+this.getStatusIcon()+"] "+ this.description;
    }


    /**
     * it's a function to return the string "[X]" or "[ ]" base on the task's status.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

}
