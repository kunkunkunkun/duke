/**
 * Represents a command to list all tasks from the task list.
 * This class is part of the command pattern implementation.
 * It encapsulates all the information needed to list all tasks.
 *
 * @author Yan Kun
 * @version 1.0
 * @since 1.0
 */

package duke.commands;
import duke.utility.*;
public class ListCommand extends Command
{
    /**
     * Executes the command to print a Goodbye message from ui.
     * @param ui The ui that provide a printTaskList function to print all task
     * @param tasks The stored task list to be printed out.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.printTaskList(tasks);
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
