/**
 * Represents a command to add a task to the task list.
 * This class is part of the command pattern implementation.
 * It encapsulates all the information needed to add a new task, including the task details.
 *
 * @author Yan Kun
 * @version 1.0
 * @since 1.0
 */

package duke.commands;

import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Tasks;
import duke.tasks.ToDo;

import duke.utility.Ui;
import duke.utility.Storage;
import duke.utility.TaskList;
import duke.utility.DukeException;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Command_DoAfter extends Command{
    private final String userInput;

    public Command_DoAfter(String userInput) {
        this.userInput=userInput;
    }

    private boolean isDate(String input)throws DateTimeParseException {

        boolean resultBool = true;
        try{
            new Tasks().convertInputTime(input);
        } catch ( DateTimeParseException e){
            resultBool=false;
        }
        return resultBool;
    }
    private boolean isNum(String input)throws NumberFormatException {
        boolean resultbool = true;
        try{
            Integer.parseInt(input);
        } catch ( NumberFormatException e){
            resultbool=false;
        }
        return resultbool;
    }
    private LocalDate getTaskLocalDate(Tasks tsk) throws DukeException {

        if(tsk instanceof Deadline) {
            return tsk.convertStringToDate(((Deadline) tsk).getBy());
        } else if (tsk instanceof Event) {
            return tsk.convertStringToDate(((Event) tsk).getTo());
        } else{
            throw new DukeException("It's neither deadline or event task, unable to compare");
        }
    }

    private LocalDate convertStringToDate(String input) throws DukeException {

        Tasks temp=new Tasks();

        try {
            return temp.convertStringToDate(temp.convertInputTime(input));
        } catch (DateTimeParseException e) {
            throw new DukeException("Invalid date format: " + input);
        }

    }
    private Tasks getTaskFromInput(String input, TaskList taskList) throws DukeException {
        int index = Integer.parseInt(input) - 1;
        return taskList.storedTaskList.get(index);
    }
    /**
     * Executes the command to add a new task.
     * This method will ask the user for task details and add the task to the list.
     *
     * @param tskList The list of tasks to which the new task will be added.
     * @param ui The ui to print Message
     * @param store The saved task-list text file
     */
    public void execute(TaskList tskList, Ui ui, Storage store) throws DukeException,NumberFormatException {

        if (!userInput.startsWith("do ") || !userInput.contains("/after")) {
            throw new DukeException("Invalid DoAfter format. Use 'do <index> " +
                                    "/after <yyyy-MM-dd> or <index>'");
        }

        String[] parts = userInput.split("\\s+/after\\s+", 2);
        String firstPart = parts[0].substring(3).trim(); // Task index
        String secondPart = parts[1].trim(); // Task index or date

        if (!isNum(firstPart)) {
            throw new DukeException("First part must be a task index.");
        }

        Tasks firstTask = getTaskFromInput(firstPart, tskList);

        LocalDate firstDate;
        LocalDate secondDate = LocalDate.parse("1000-01-01");
        Tasks secondTask = new Tasks();
        String result;

        if (isNum(secondPart)) {
            secondTask = getTaskFromInput(secondPart, tskList);
        } else if (isDate(secondPart)){

            try{
                secondDate = convertStringToDate(secondPart);
            } catch (DateTimeParseException e) {
                throw new DukeException(" Wrong date format !!!");
            }

        } else {
            throw new DukeException("Invalid second input");
        }

        if((firstTask instanceof ToDo)&&(secondTask instanceof ToDo)) {
            result = "Do " + firstTask.getDescription() + " after " + secondTask.getDescription();
        } else {
            firstDate = getTaskLocalDate(firstTask);
            String secPartStr=secondPart;

            if(isNum(secondPart)){
                secondDate = getTaskLocalDate(secondTask);
                secPartStr=secondTask.getDescription();
            }
            if (firstDate.isAfter(secondDate)) {
                result = "Do " + firstTask.getDescription() + " after " + secPartStr;
            } else {
                secPartStr = secondDate.toString();
                throw new DukeException(firstTask.getDescription() + " cannot be placed after " + secondPart);
            }
        }
        tskList.notes.add(result);
        tskList.printNotes();
    }


    /**
     * Check if Command should end.
     * Return a boolean value for Parser parse function to evaluate
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
