import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;

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

//    public Parser(String UserInput)
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
            default:
                throw new DukeException("I'm sorry, but I don't know what that means :-(");
        }
    }
    private void checkInputLength(String[] splitInput) throws DukeException {
        if (splitInput.length < 2 || splitInput[1].trim().isEmpty()) {
            throw new DukeException("The description of a command cannot be empty.");
        }
    }
//    private Command parseDeadlineCommand(String input) throws DukeException {
//        input=input.substring(8);
//        String[] parts = input.split("/by", 2);
//        if (parts.length < 2 || parts[1].trim().isEmpty()) {
//            throw new DukeException("Invalid deadline format. Use 'deadline <description> /by <date>'");
//        }
//        return new AddTaskCommand(new Deadline(parts[0].trim(), false, parts[1].trim()));
//    }
    private Command parseDeadlineCommand(String input) throws DukeException {
    String[] parts = input.split("\\s+/by\\s+", 2);
    if (parts.length < 2 || parts[1].isEmpty()) {
        throw new DukeException("Invalid deadline format. Use 'deadline <description> /by <date>'");
    }
    return new AddTaskCommand(new Deadline(parts[0].substring(9).trim(), false, parts[1].trim()));
}

//    private Command parseEventCommand(String input) throws DukeException {
//        input=input.substring(5);
//        String[] parts = input.split("/from");
//        String from = input.substring(input.indexOf("/from")+5,input.lastIndexOf("/")).trim();
//        String to = input.substring(input.lastIndexOf("/")+3);
//        if (parts.length < 2 || parts[1].trim().isEmpty()) {
//            throw new DukeException("Invalid event format. Use 'event <description> /at <date/time>'");
//        }
//        return new AddTaskCommand(new Event(parts[0].trim(),false,from.trim(),to.trim()));
//        //return new AddTaskCommand(new Event(parts[0].trim(), false, parts[1].trim()), parts[1].trim());
//    }
    private Command parseEventCommand(String input) throws DukeException {
        String[] parts = input.split("\\s+/from\\s+");
        if (parts.length < 2 || parts[1].isEmpty()) {
            throw new DukeException("Invalid event format. Use 'event <description> /from <start time> /to <end time>'");
        }

        String[] timeParts = parts[1].split("\\s+/to\\s+", 2);
        if (timeParts.length < 2 || timeParts[1].isEmpty()) {
            throw new DukeException("Invalid event time format. Include both start and end times.");
        }

        return new AddTaskCommand(new Event(parts[0].substring(6).trim(), false, timeParts[0].trim(), timeParts[1].trim()));
    }

}
