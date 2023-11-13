import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage
{
    protected String filePath="src/main/java/duke.txt";
    protected ArrayList<Tasks> LoadedTasks= new ArrayList<>();
    protected ArrayList<String> FileContent = new ArrayList<>();
    Ui ui=new Ui();

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<Tasks> load() throws DukeException
    {
        File file = new File(filePath);
        this.LoadedTasks = new ArrayList<>();
        try {
            Scanner SCAN =new Scanner(file);
            while (SCAN.hasNext()){
                FileContent.add(SCAN.nextLine());
            }
        }
        catch (FileNotFoundException e)
        {
            ui.showLoadingError();
            throw new DukeException("");
        }
        LoadedTasks=FileToTasks();
        return LoadedTasks;
    }
    public ArrayList<Tasks> FileToTasks()
    {
        ArrayList<Tasks> Result = new ArrayList<>();
        for(String s:FileContent){
            String Discription = s.contains("(")?s.substring(6,s.indexOf("(")).trim():s.substring(6,s.length()).trim();
            Boolean isDone = s.substring(4,5).equals("X");
            String by = s.contains("by: ")?s.substring(s.indexOf("by"),s.length()-1):"";
            String from = s.contains("from: ")?s.substring(s.indexOf("from: "),s.indexOf("to")):"";
            String to = s.contains("to: ")?s.substring(s.indexOf("to: "),s.length()-2):"";
            switch (s.substring(1,2)){
                case "T":
                    Result.add(new ToDo(Discription,isDone));
                    break;
                case "D":
                    Result.add(new Deadline(Discription,isDone,by));
                    break;
                case "E":
                    Result.add(new Event(Discription,isDone,from,to));
                    break;
            }
        }
        return Result;
    }
    public void save(ArrayList<Tasks> tasks) throws IOException {
        try {
            File file = new File(filePath);
            FileWriter FW = new FileWriter(file);
            for (Tasks T : LoadedTasks) {
                FW.write(T.toString());
                FW.write("\n");
            }
            FW.close();
        }catch (IOException e){
            throw new IOException("Unable to write to file:"+filePath);
        }
    }
}
