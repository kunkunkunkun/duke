package duke.commands;
import duke.utility.DukeException;
public enum CommandEnum
{
    LIST, BYE, MARK, UNMARK, TODO, DEADLINE, EVENT, DELETE, SAVE;

    public static CommandEnum parse(String commandString) throws DukeException {
        for (CommandEnum command : CommandEnum.values()) {
            if (commandString.equalsIgnoreCase(command.name())) {
                return command;
            }
        }
        throw new DukeException("OOPS!!! I'm sorry, but I don't know what that means :-(");
    }
}
