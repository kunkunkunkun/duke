/**
 * Represents a class that stores all tasks and provide tasklist function;
 * This class is part of the utility pattern implementation.
 *
 * @author Yan Kun
 * @version 1.0
 * @since 1.0
 */

package duke.utility;

import duke.tasks.Tasks;

import java.io.File;
import java.util.ArrayList;

public class TaskList extends Tasks
{
  protected String filePath= new Storage().filePath;
  public ArrayList<Tasks> storedTaskList = new ArrayList<>();

  public ArrayList<String> notes = new ArrayList<>();

    public TaskList(ArrayList<Tasks> loadedTasks) throws DukeException {
        File f =new File(filePath);
        this.storedTaskList=loadedTasks;
    }
    public TaskList() {
    }

    /**
     * Executes the command to add task into task list
     * Return the updated task list
     *
     * @param taskToAdd Task to be added into the task
     */
    public void addTask(Tasks taskToAdd) {
        storedTaskList.add(taskToAdd);
    }

    /**
     * Executes the command to delete task from task list
     * base on user specified index
     *
     * @param index the index of the task from the task list
     */
    public void deleteTask(int index) {

        Tasks result=storedTaskList.get(index-1);
        storedTaskList.remove(index-1);
    }

    /**
     * Return all the tasks in a list
     */
    public ArrayList<Tasks> getAllTasks() {
        return storedTaskList;
    }

    /**
     * Executes the command to print all task from task list
     * It loops through the task list and do toString to turn task into string
     * and print out
     * @param input the index of the task from the task list
     */
    public void printTaskList(ArrayList<Tasks> input) {

        int i =1;

        for (Tasks t:input) {
            System.out.println(i+t.toString());
            i++;
        }
    }

    public void printNotes() {

        System.out.println("All your notes are as follow");

        int i =1;
        for(String s: notes) {
            System.out.println("["+i+"]"+s);
            i++;
        }
    }
}
