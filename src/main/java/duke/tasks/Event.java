/**
 * Represents an event task with a start and end date.
 * This class is a kind of tasks type.
 * This class extends the {@link Tasks} class and adds support for
 * event, represented by a pair of start and end date.
 *
 * @author Yan Kun
 * @version 1.0
 * @since 1.0
 */

package duke.tasks;

public class Event extends Tasks
{
    protected String From;
    protected String To;

    public String getFrom() {
        return From;
    }

    public String getTo() {
        return To;
    }

    public void setFrom(String from) {
        From = from;
    }

    public void setTo(String to) {
        To = to;
    }

    public Event(String description, Boolean isDone, String From, String To)
    {
        this.description=description;
        this.isDone=isDone;
        this.TaskName=Enums.E.toString();
        this.From=From;
        this.To=To;
    }
    /**
     * it's an override function from its super class
     * Return a string that contains the task details
     * which is task type, status, description and start time and end time.
     */
    @Override
    public String toString()
    {
        return "[E]" + super.toString() + " (from: " + this.From +" to: "+this.To+ ")";
    }
}
