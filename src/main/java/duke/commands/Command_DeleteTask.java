/**
 * Represents a command to delete a task from the task list.
 * This class is part of the command pattern implementation.
 * It encapsulates all the information needed to delete a new task, including the task details.
 *
 * @author Yan Kun
 * @version 1.0
 * @since 1.0
 */

package duke.commands;

import java.io.IOException;
import duke.utility.Ui;
import duke.utility.Storage;
import duke.utility.TaskList;
public class Command_DeleteTask extends Command
{
    private final int index;

    public Command_DeleteTask(int index) {
        this.index=index;
    }


    /**
     * Executes the command to delete a new task.
     * This method will ask the user for task details and delete the task from the list.
     *
     * @param tskList The list of tasks to which the new task will be added.
     * @param ui The ui to print Message
     * @param store The saved task-list text file
     */
    public void execute(TaskList tskList, Ui ui, Storage store) {

        tskList.deleteTask(index);

        try {
            store.save(tskList.getAllTasks());
            ui.showDeleteMsg();
        } catch (IOException e) {
            ui.showError("Failed to delete task: " + e.getMessage());
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
