import java.io.IOException;

public class DeleteTaskCommand extends Command
{
    private int index;

    public DeleteTaskCommand(int index)
    {
        this.index=index;
    }

    public void execute(TaskList tskList, Ui ui,Storage store)
    {
        Tasks RemovedTask = tskList.DeleteTask(index);
        //ui.showDeleteMsg(tskList.TaskName);
        try {
            store.save(tskList.getAllTasks());
            ui.showDeleteMsg();
        } catch (IOException e) {
            ui.showError("Failed to delete task: " + e.getMessage());
        }
    }
    @Override
    public boolean isExit()
    {
        return false;
    }
}
