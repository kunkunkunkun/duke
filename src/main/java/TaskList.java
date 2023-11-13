import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class TaskList extends Tasks
{
  protected String filePath="src/main/java/duke.txt";
  protected ArrayList<Tasks> StoredTaskList = new ArrayList<>();

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
    public ArrayList<Tasks> AddTask(Tasks TaskToAdd)
    {
        StoredTaskList.add(TaskToAdd);
        return StoredTaskList;
    }
    public Tasks DeleteTask(int index)
    {
        Tasks Result=StoredTaskList.get(index-1);
        StoredTaskList.remove(index-1);
        return Result;
    }
    public ArrayList<Tasks> getAllTasks()
    {
        return StoredTaskList;
    }
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
