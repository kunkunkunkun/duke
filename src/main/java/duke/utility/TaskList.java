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
  protected String filePath="src/main/java/duke.txt";
  public ArrayList<Tasks> StoredTaskList = new ArrayList<>();

    public TaskList(ArrayList<Tasks> LoadedTask) throws DukeException
    {
        File F =new File(filePath);
        this.StoredTaskList=LoadedTask;
    }

    public TaskList(){
        filePath="src/main/java/duke.txt";
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    public String getFilePath() {
        return filePath;
    }

    /**
     * Executes the command to add task into task list
     * Return the updated task list
     * @param TaskToAdd Task to be added into the task
     */
    public ArrayList<Tasks> AddTask(Tasks TaskToAdd)
    {
        StoredTaskList.add(TaskToAdd);
        return StoredTaskList;
    }

    /**
     * Executes the command to delete task from task list
     * base on user specified index
     * @param index the index of the task from the task list
     */
    public Tasks DeleteTask(int index)
    {
        Tasks Result=StoredTaskList.get(index-1);
        StoredTaskList.remove(index-1);
        return Result;
    }

    /**
     * Return all the tasks in a list
     */
    public ArrayList<Tasks> getAllTasks()
    {
        return StoredTaskList;
    }

    /**
     * Executes the command to print all task from task list
     * It loops through the task list and do toString to turn task into string
     * and print out
     * @param Input the index of the task from the task list
     */
    public void PrintTaskList(ArrayList<Tasks> Input)
    {
        int i =1;
        for (Tasks t:Input)
        {
            System.out.println(i+t.toString());
            i++;
        }
    }
}
