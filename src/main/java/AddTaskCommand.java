import java.io.IOException;

public class AddTaskCommand extends Command
{
    private Tasks tsk;

    public AddTaskCommand(Tasks tsk)
    {
        this.tsk=tsk;
    }

    public void execute(TaskList tskList, Ui ui,Storage store)
    {
        tskList.AddTask(tsk);
        ui.showTaskAdded();
        ui.PrintIndividualTask(tsk);
        try {
            store.save(tskList.getAllTasks());
        } catch (IOException e) {
            ui.showError("Failed to save task: " + e.getMessage());
        }
    }
    @Override
    public boolean isExit()
    {
        return false;
    }
}
