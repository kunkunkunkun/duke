package duke.utility;

import duke.commands.*;
import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Tasks;
import duke.tasks.ToDo;

import java.time.format.DateTimeParseException;

public class Parser
{
    protected String UserInput;
    protected String TaskType;
    protected String[] SplitUserInput = new String[100];

    public String getUserInput() {
        return UserInput;
    }

    public String getTaskType() {
        return TaskType;
    }

    public String[] getSplitUserInput() {
        return SplitUserInput;
    }

    public void setUserInput(String userInput) {
        UserInput = userInput;
    }

    public void setTaskType(String taskType) {
        TaskType = TaskType;
    }

//    public duke.utility.Parser(String UserInput)
//    {
//        this.UserInput=UserInput;
//        //this.Index=Integer.parseInt(this.SplitUserInput[1]) - 1;
//    }
    public Parser()
    {
    }

    public Command parse(String Input) throws DukeException
    {
        String[] SplitUserInput = Input.split(" ");
        String TaskType = SplitUserInput[0].trim().toLowerCase();

        switch (TaskType)
        {
            case "bye":
                return new ExitCommand();
            case "list":
                return new ListCommand();
            case "mark":
                checkInputLength(SplitUserInput);
                return new MarkingTaskCommand(SplitUserInput);
            case "unmark":
                checkInputLength(SplitUserInput);
                return new MarkingTaskCommand(SplitUserInput);
            case "todo":
                checkInputLength(SplitUserInput);
                return new AddTaskCommand(new ToDo(SplitUserInput[1], false));
            case "deadline":
                checkInputLength(SplitUserInput);
                return parseDeadlineCommand(Input);
            case "event":
                checkInputLength(SplitUserInput);
                return parseEventCommand(Input);
            case "delete":
                checkInputLength(SplitUserInput);
                return new DeleteTaskCommand(Integer.parseInt(SplitUserInput[1]));
            case"search":
                checkInputLength(SplitUserInput);
                return new SearchByDateCommand(SplitUserInput[1]);
            default:
                throw new DukeException("I'm sorry, but I don't know what that means :-(");
        }
    }

    private void checkInputLength(String[] splitInput) throws DukeException {
        if (splitInput.length < 2 || splitInput[1].trim().isEmpty()) {
            throw new DukeException("The description of a command cannot be empty.");
        }
    }
//    private duke.commands.Command parseDeadlineCommand(String input) throws duke.utility.DukeException {
//        input=input.substring(8);
//        String[] parts = input.split("/by", 2);
//        if (parts.length < 2 || parts[1].trim().isEmpty()) {
//            throw new duke.utility.DukeException("Invalid deadline format. Use 'deadline <description> /by <date>'");
//        }
//        return new duke.commands.AddTaskCommand(new duke.tasks.Deadline(parts[0].trim(), false, parts[1].trim()));
//    }
    private Command parseDeadlineCommand(String input) throws DukeException {
        Deadline DL=new Deadline("",false,"");
    if (input.contains("/by")) {
        String[] parts = input.split("\\s+/by\\s+", 2);
        String Description = parts[0];
        String by = parts[1].trim();
        try{
            DL.setDescription(Description.substring(9).trim());
            DL.setBy(DL.InputTimeConvertor(by.trim()));}
        catch (DateTimeParseException e){
            throw new DukeException("Invalid date format. Please use yyyy-MM-dd.");
        }
        //throw new DukeException("Invalid deadline format. Use 'deadline <description> /by <date>'");
    }
    else{throw new DukeException("Invalid deadline format. Use 'deadline <description> /by <date>'");}
    return new AddTaskCommand(DL);
}
    private Command parseEventCommand(String input) throws DukeException {
        Event Evt = new Event("",false,"","");
        if (input.contains("/to")&&input.contains("/from"))
        {
            String[] parts = input.split("\\s+/from\\s+");
            String[] timeParts = parts[1].split("\\s+/to\\s+", 2);
            String Description =parts[0].substring(6).trim();
            String From =timeParts[0].trim();
            String To =timeParts[1].trim();
            try{
                Evt.setDescription(Description);
                Evt.setFrom(Evt.InputTimeConvertor(From.trim()));
                Evt.setTo(Evt.InputTimeConvertor(To.trim()));
            }
            catch (DateTimeParseException e){
                throw new DukeException("Invalid date format. Please use yyyy-MM-dd.");
            }
        }
        else {throw new DukeException("Invalid event format. Use 'event <description> /from <start time> /to <end time>'");}
        return new AddTaskCommand(Evt);
    }
}
