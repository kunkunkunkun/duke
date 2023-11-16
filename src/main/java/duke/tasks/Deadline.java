/**
 * Represents a deadline task with a specific due date.
 * This class is a kind of tasks type.
 * This class extends the {@link Tasks} class and adds support for
 * deadlines, represented by a date.
 *
 * @author Yan Kun
 * @version 1.0
 * @since 1.0
 */

package duke.tasks;

public class Deadline extends Tasks
{
    protected String by;

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

    /**
     * it's an override function from its super class
     * Return a string that contains the task details
     * which is task type, status, description and by when need to be done.
     */
    @Override
    public String toString()
    {
        //return "[D][X] join sports club /by 2023-02-12";
        return "[D]" + super.toString() + " (by: " + this.by + ")";
    }
}
