/**
 * Represents a command to add a task to the task list.
 * This class is part of the command pattern implementation.
 * It encapsulates all the information needed to add a new task, including the task details.
 *
 * @author Yan Kun
 * @version 1.0
 * @since 1.0
 */

package duke.commands;

import duke.tasks.Tasks;
import duke.utility.TaskList;
import duke.utility.Ui;
import duke.utility.Storage;
import java.io.IOException;

public class Command_AddTask extends Command {
    private final Tasks tsk;

    public Command_AddTask(Tasks tsk) {
        this.tsk=tsk;
    }

    /**
     * Executes the command to add a new task.
     * This method will ask the user for task details and add the task to the list.
     *
     * @param tskList The list of tasks to which the new task will be added.
     * @param ui The ui to print Message
     * @param store The saved task-list text file
     */
    public void execute(TaskList tskList, Ui ui, Storage store) {

        tskList.addTask(tsk);
        ui.showTaskAdded();
        ui.printIndividualTask(tsk);

        try {
            store.save(tskList.getAllTasks());
            ui.printNumberOfTask(tskList);
        } catch (IOException e) {
            ui.showError("Failed to save task: " + e.getMessage());
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
