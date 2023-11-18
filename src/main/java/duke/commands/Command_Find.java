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

import duke.tasks.Tasks;

import duke.utility.DukeException;
import duke.utility.Storage;
import duke.utility.TaskList;
import duke.utility.Ui;

import java.util.ArrayList;

public class Command_Find extends Command {
    private final String input;
    public Command_Find(String Input) {
        this.input=Input;
    }
    /**
     * Executes the command to print a Goodbye message from ui.
     * @param ui The ui that provide a printTaskList function to print all task
     * @param tskList The stored task list to be printed out.
     */
    @Override
    public void execute(TaskList tskList, Ui ui, Storage store) throws DukeException {

        String item = input.substring(5).trim();
        ArrayList<Tasks> results = new ArrayList<>();

        ui.findCommand();

        for (Tasks T:tskList.storedTaskList) {
            if(T.getDescription().contains(item)){
                results.add(T);
            }
        }
        if (!results.isEmpty()){
            ui.printTaskList(new TaskList(results));
        } else{
            System.out.println("No matching tasks found");
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
