package duke.commands;

import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Tasks;
import duke.utility.DukeException;
import duke.utility.Storage;
import duke.utility.TaskList;
import duke.utility.Ui;

import java.time.format.DateTimeParseException;

public class SearchByDateCommand extends Command
{
    private String InputDate;

    public SearchByDateCommand(String inputDate) {
        this.InputDate = inputDate;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage)throws DateTimeParseException, DukeException
    {
        //storage.load();
        try{
            for (Tasks t:tasks.StoredTaskList)
            {
                String TargetDate=t.InputTimeConvertor(InputDate);
                if(t instanceof Deadline&&TargetDate.equals(((Deadline) t).getBy())){
                    System.out.println(t.toString());
                }
                if(t instanceof Event &&(TargetDate.equals(((Event) t).getFrom())||TargetDate.equals(((Event) t).getTo()))){
                    System.out.println(t.toString());
                }
            }
        }
        catch (DateTimeParseException e){
            throw new DukeException("Invalid date format. Please use yyyy-MM-dd.");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
