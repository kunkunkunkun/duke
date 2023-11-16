/**
 * Represents a command to mark or unmark a task from tasklist.
 * This class is part of the command pattern implementation.
 * It encapsulates all the information needed to mark or unmark a task from tasklist.
 *
 * @author Yan Kun
 * @version 1.0
 * @since 1.0
 */

package duke.commands;
import duke.utility.*;
import duke.tasks.Tasks;

public class MarkingTaskCommand extends Command
{
    private String[] UserInput;

    public MarkingTaskCommand(String[] UserInput)
    {
        this.UserInput=UserInput;
    }


    /**
     * Executes the command to analyse the input and do mark and unmarking function accordingly.
     * This method gets stored task list from the saved text file then check user input to analyse which task to be mark/unmark.
     *
     * @param tskList The list of stored tasks.
     * @param ui The ui that provides Marked and Unmarked message, and also a function to print individual task.
     * @param store The saved task list text file, provides a function to convert the text file to a task list
     */
    public void execute(TaskList tskList, Ui ui, Storage store)
    {
        Tasks Tsk = tskList.StoredTaskList.get(Integer.parseInt(UserInput[1]) - 1);
        if(UserInput[0].equals("mark")){
            Tsk.setDone(true); //
            ui.showMarkedMsg();
        }
        else if (UserInput[0].equals("unmark")){
            Tsk.setDone(false); //
            ui.showUnmarkedMsg();
        }
        ui.PrintTaskMsg(Tsk.toString());
    }

    /**
     * Check if Command should end.
     * Return a boolean value for Parser parse function to evaluate
     */
    @Override
    public boolean isExit()
    {
        return false;
    }
}
