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

public class Event extends Tasks {
    protected String from;
    protected String to;

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Event(String description, Boolean isDone, String from, String to) {

        this.description=description;
        this.isDone=isDone;
        this.taskName =Enums.E.toString();
        this.from=from;
        this.to=to;
    }
    /**
     * it's an override function from its super class
     * Return a string that contains the task details
     * which is task type, status, description and start time and end time.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + this.from +" to: "+this.to+ ")";
    }
}
