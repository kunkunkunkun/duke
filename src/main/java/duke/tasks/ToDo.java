/**
 * Represents a to-do task with description and status.
 * This class is a kind of tasks type.
 * This class extends the {@link Tasks} class and adds support for
 * to-do, represented by description and status.
 *
 * @author Yan Kun
 * @version 1.0
 * @since 1.0
 */

package duke.tasks;

public class ToDo extends Tasks
{
    //String TaskName = "T";
    public ToDo(String description,Boolean isDone)
    {
        this.description=description;
        this.isDone=isDone;
        this.TaskName=Enums.T.toString();
    }

    /**
     * it's an override function from its super class
     * Return a string that contains the task details
     * which is task type, status, description.
     */
    @Override
    public String toString()
    {
        return "[T]" + super.toString();
    }

}
