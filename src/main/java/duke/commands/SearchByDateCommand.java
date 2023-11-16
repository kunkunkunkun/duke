/**
 * Represents a command to search and print the event and deadline tasks that match user's input date.
 * This class is part of the command pattern implementation.
 * It encapsulates all the information needed to search and print the event and deadline tasks that match user's input date.
 *
 * @author Yan Kun
 * @version 1.0
 * @since 1.0
 */

package duke.commands;

import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Tasks;
import duke.utility.DukeException;
import duke.utility.Storage;
import duke.utility.TaskList;
import duke.utility.Ui;

import java.time.format.DateTimeParseException;
public class SearchByDateCommand extends Command
{
    private String InputDate;

    public SearchByDateCommand(String inputDate) {
        this.InputDate = inputDate;
    }

    /**
     * Executes the command to find task that matches user input date.
     * This method gets stored task list from the saved text file.
     * then convert user input to a time format using InputTimeConvertor method in Task glass
     * then search task in task list for deadline and event instance, filter the date that match input date
     *
     * @param tasks The list of stored tasks.
     * @exception DateTimeParseException catch wrong format date error
     * @exception DukeException throw error message
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage)throws DateTimeParseException, DukeException
    {
        //storage.load();
        try{
            for (Tasks t:tasks.StoredTaskList)
            {
                String TargetDate=t.InputTimeConvertor(InputDate);
                if(t instanceof Deadline&&TargetDate.equals(((Deadline) t).getBy())){
                    System.out.println(t.toString());
                }
                if(t instanceof Event &&(TargetDate.equals(((Event) t).getFrom())||TargetDate.equals(((Event) t).getTo()))){
                    System.out.println(t.toString());
                }
            }
        }
        catch (DateTimeParseException e){
            throw new DukeException("Invalid date format. Please use yyyy-MM-dd.");
        }
    }

    /**
     * Check if Command should end.
     * Return a boolean value for Parser parse function to evaluate
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
