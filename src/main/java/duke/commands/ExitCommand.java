package duke.commands;
import duke.utility.*;
public class ExitCommand extends Command
{
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage)
    {
        ui.ShowGoodByeMsg();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
