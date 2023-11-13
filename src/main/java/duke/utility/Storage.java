package duke.utility;

import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Tasks;
import duke.tasks.ToDo;

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
    private String extractBetween(String text, String start, String end) {
        if (text.contains(start) && text.contains(end)) {
            return text.substring(text.indexOf(start) + start.length(), text.indexOf(end)).trim();
        }
        return "";
    }

    private String extractAfter(String text, String start, String end) {
        if (text.contains(start) && text.contains(end)) {
            return text.substring(text.indexOf(start) + start.length(), text.lastIndexOf(end)).trim();
        }
        return "";
    }
    public ArrayList<Tasks> FileToTasks()
    {
        ArrayList<Tasks> Result = new ArrayList<>();
        for(String s:FileContent){
            String description = s.substring(6).split("\\(", 2)[0].trim();
            boolean isDone = s.substring(4, 5).equals("X");

            String by = extractBetween(s, "by: ", ")");
            String from = extractBetween(s, "from: ", "to: ");
            String to = extractAfter(s, "to: ", ")");

            switch (s.substring(1, 2)) {
                case "T":
                    Result.add(new ToDo(description, isDone));
                    break;
                case "D":
                    Result.add(new Deadline(description, isDone, by));
                    break;
                case "E":
                    Result.add(new Event(description, isDone, from, to));
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
