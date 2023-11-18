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
public class Command_SearchByDate extends Command {
    private final String inputDate;

    public Command_SearchByDate(String inputDate) {
        this.inputDate = inputDate;
    }

    private boolean isTaskWithDate(Tasks tsk, String date){
        if(tsk instanceof Deadline&&date.equals(((Deadline) tsk).getBy())){
            return true;
        }else if (tsk instanceof Event&&date.equals(((Event) tsk).getFrom())){
            return true;
        }else
            return tsk instanceof Event && date.equals(((Event) tsk).getTo());
    }

    /**
     * Executes the command to find task that matches user input date.
     * This method gets stored task list from the saved text file.
     * then convert user input to a time format using InputTimeConvertor method in Task glass
     * then search task in task list for deadline and event instance, filter the date that match input date
     *
     * @param tskList The list of stored tasks.
     * @exception DateTimeParseException catch wrong format date error
     * @exception DukeException throw error message
     */
    @Override
    public void execute(TaskList tskList, Ui ui, Storage store)throws DateTimeParseException, DukeException
    {
        try{
            for (Tasks t:tskList.storedTaskList) {
                String TargetDate=t.convertInputTime(inputDate);

                if(isTaskWithDate(t,TargetDate)){
                    System.out.println(t.toString());
                }
            }
        } catch (DateTimeParseException e){
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
