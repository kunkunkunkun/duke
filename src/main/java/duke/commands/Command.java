/**
 * Represents an abstract command class.
 * This class is part of the command pattern implementation.
 * It encapsulates the basic execute and isExit function for all other Commands to include
 *
 * @author Yan Kun
 * @version 1.0
 * @since 1.0
 */

package duke.commands;
import duke.utility.*;

public abstract class Command {
    /**
     * Executes the command.
     * This method will ask the user for task details to be executed.
     *
     * @param tasks The list of tasks to which the new task will be added.
     * @param ui The ui to print Message
     * @param storage The saved task-list text file
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;
    /**
     * Check if Command should end.
     * Return a boolean value for Parser parse function to evaluate
     */
    public abstract boolean isExit();
}