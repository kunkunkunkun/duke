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

import duke.utility.Storage;
import duke.utility.TaskList;
import duke.utility.Ui;

import duke.tasks.Tasks;

public class Command_MarkingTask extends Command {
    private final String[] userInputs;

    public Command_MarkingTask(String[] UserInput) {
        this.userInputs=UserInput;
    }

    /**
     * Executes the command to analyse the input and do mark and unmarking function accordingly.
     * This method gets stored task list from the saved text file then check user input to analyse which task to be mark/unmark.
     *
     * @param tskList The list of stored tasks.
     * @param ui The ui that provides Marked and Unmarked message, and also a function to print individual task.
     * @param store The saved task list text file, provides a function to convert the text file to a task list
     */
    public void execute(TaskList tskList, Ui ui, Storage store) {

        Tasks tsk = tskList.storedTaskList.get(Integer.parseInt(userInputs[1]) - 1);

        if(userInputs[0].equals("mark")){
            tsk.setDone(true); //
            ui.showMarkedMsg();
        }
        else if (userInputs[0].equals("unmark")){
            tsk.setDone(false); //
            ui.showUnmarkedMsg();
        }

        ui.printTaskMsg(tsk.toString());
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
