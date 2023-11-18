/**
 * Represents a command to end the conversation.
 * This class is part of the command pattern implementation.
 * It encapsulates all the information needed to end the conversation.
 *
 * @author Yan Kun
 * @version 1.0
 * @since 1.0
 */

package duke.commands;
import duke.utility.Ui;
import duke.utility.Storage;
import duke.utility.TaskList;

public class Command_Exit extends Command {
    /**
     * Executes the command to print a Goodbye message from ui.
     *
     * @param ui The ui to print Message
     */
    @Override
    public void execute(TaskList tskList, Ui ui, Storage store) {
        ui.ShowGoodByeMsg();
    }

    /**
     * Check if Command should end.
     * Return a boolean value for Parser parse function to evaluate
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
