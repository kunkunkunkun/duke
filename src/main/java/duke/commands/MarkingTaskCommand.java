package duke.commands;
import duke.utility.*;
import duke.tasks.Tasks;
public class MarkingTaskCommand extends Command
{
    private String[] UserInput;

    public MarkingTaskCommand(String[] UserInput)
    {
        this.UserInput=UserInput;
    }

    public void execute(TaskList tskList, Ui ui, Storage store)
    {
        Tasks Tsk = tskList.StoredTaskList.get(Integer.parseInt(UserInput[1]) - 1);
        if(UserInput[0].equals("mark")){
            Tsk.setDone(true); //
            ui.showMarkedMsg();
        }
        else if (UserInput[0].equals("unmark")){
            Tsk.setDone(false); //
            ui.showUnmarkedMsg();
        }
        ui.PrintTaskMsg(Tsk.toString());
    }
    @Override
    public boolean isExit()
    {
        return false;
    }
}
