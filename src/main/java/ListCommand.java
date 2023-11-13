import java.io.IOException;

public class ListCommand extends Command
{
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.printTaskList(tasks);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
