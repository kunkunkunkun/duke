/**
 * Represents a class that takes in user input
 * and analyse their input logic then execute with respective commands
 * This class is part of the utility pattern implementation.
 *
 * @author Yan Kun
 * @version 1.0
 * @since 1.0
 */

package duke.utility;

import duke.commands.Command;
import duke.commands.Command_AddTask;
import duke.commands.Command_DeleteTask;
import duke.commands.Command_DoAfter;
import duke.commands.Command_Exit;
import duke.commands.Command_Find;
import duke.commands.Command_List;
import duke.commands.Command_MarkingTask;
import duke.commands.Command_SearchByDate;

import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.ToDo;

import java.time.format.DateTimeParseException;

public class Parser {

    /**
     * Executes the method to analyse user input
     * This method will ask the user for command input
     * then it'll split the input to match the task type and run relative command
     * it'll throw an error if user input message doesn't contain task of certain type
     * @param input The user input gets from terminal
     */
    public Command parse(String input) throws DukeException {

        String[] splitUserInput = input.split(" ");
        String TaskType = splitUserInput[0].trim().toLowerCase();

        switch (TaskType) {
            case "bye":
                return new Command_Exit();
            case "list":
                return new Command_List();
            case "mark":
                checkInputLength(splitUserInput);
                return new Command_MarkingTask(splitUserInput);
            case "unmark":
                checkInputLength(splitUserInput);
                return new Command_MarkingTask(splitUserInput);
            case "todo":
                checkInputLength(splitUserInput);
                return new Command_AddTask(new ToDo(splitUserInput[1], false));
            case "deadline":
                checkInputLength(splitUserInput);
                return parseDeadlineCommand(input);
            case "event":
                checkInputLength(splitUserInput);
                return parseEventCommand(input);
            case "delete":
                checkInputLength(splitUserInput);
                return new Command_DeleteTask(Integer.parseInt(splitUserInput[1]));
            case"search":
                checkInputLength(splitUserInput);
                return new Command_SearchByDate(splitUserInput[1]);
            case"do":
                checkInputLength(splitUserInput);
                return new Command_DoAfter(input);
            case"find":
                checkInputLength(splitUserInput);
                return new Command_Find(input);
            default:
                throw new DukeException("I'm sorry, but I don't know what that means :-(");
        }
    }

    /**
     * Executes the method to check if the split user input has more than 2 parts
     * it'll throw an error if the input contains less than 2 parts or the second part is empty
     * @param splitInput The split user input passed from paser method
     */
    private void checkInputLength(String[] splitInput) throws DukeException {
        if (splitInput.length < 2 || splitInput[1].trim().isEmpty()) {
            throw new DukeException("The description of a command cannot be empty.");
        }
    }

    /**
     * Add a deadline command if the user input meet the correct requirement.
     * This method check user input contains "/by",
     * if there isn't, it'll throw and invalid deadline format error
     * if there is, it'll extract description, by from the input and create a deadline task and add into task list
     * @param input The list of tasks to which the new task will be added.
     */
    private Command parseDeadlineCommand(String input) throws DukeException {

        Deadline dl=new Deadline("",false,"");

        if (input.contains("/by")) {
            String[] parts = input.split("\\s+/by\\s+", 2);
            String Description = parts[0];
            String by = parts[1].trim();

            try{
                dl.setDescription(Description.substring(9).trim());
                dl.setBy(dl.convertInputTime(by.trim()));
            } catch (DateTimeParseException e){
                throw new DukeException("Invalid date format. Please use yyyy-MM-dd.");
            }
        } else{
            throw new DukeException("Invalid deadline format. Use 'deadline <description> /by <date>'");
        }

    return new Command_AddTask(dl);
}

    /**
     * Add an event command if the user input meet the correct requirement.
     * This method check user input contains "/by",
     * if there isn't, it'll throw and invalid event format error
     * if there is, it'll extract description, by, from and to value from the input
     * and create a deadline task and add into task list
     * @param input The list of tasks to which the new task will be added.
     */
    private Command parseEventCommand(String input) throws DukeException {

        Event evt = new Event("",false,"","");

        if (input.contains("/to")&&input.contains("/from")) {
            String[] parts = input.split("\\s+/from\\s+");
            String[] timeParts = parts[1].split("\\s+/to\\s+", 2);
            String description =parts[0].substring(6).trim();
            String from =timeParts[0].trim();
            String to =timeParts[1].trim();

            try{
                evt.setDescription(description);
                evt.setFrom(evt.convertInputTime(from.trim()));
                evt.setTo(evt.convertInputTime(to.trim()));
            } catch (DateTimeParseException e){
                throw new DukeException("Invalid date format. Please use yyyy-MM-dd.");
            }

        } else {
            throw new DukeException("Invalid event format. Use 'event <description>"
                    + "/from <start time> /to <end time>'");
        }

        return new Command_AddTask(evt);
    }
}
