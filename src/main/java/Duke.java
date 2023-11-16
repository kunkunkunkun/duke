import duke.commands.Command;
import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Tasks;
import duke.tasks.ToDo;
import duke.utility.*;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Duke extends Tasks
{

    private Storage storage;
    private TaskList tskList;
    private Ui ui;
    private Parser parser;

    private static final String FILE_PATH = "main/java/duke.txt";

    public static ArrayList<Tasks> StoredUserInput = new ArrayList<>();
    public static ArrayList<String> UserCommands = new ArrayList<String>();

    public static void LoadTestCases()
    {
//        UserCommands.add("list");
//        UserCommands.add("bye");
//        UserCommands.add("mark");
//        UserCommands.add("unmark");
//        UserCommands.add("todo");
//        UserCommands.add("deadline");
//        UserCommands.add("event");
//        UserCommands.add("delete");
//        UserCommands.add("save");

        //level 3
        //StoredUserInput.add(new duke.tasks.Tasks("read book",false));
        //StoredUserInput.add(new duke.tasks.Tasks ("return book",false));
        //StoredUserInput.add(new duke.tasks.Tasks("buy book",false));

        //level 4
        StoredUserInput.add(new ToDo("read book",true));
        StoredUserInput.add(new Deadline("return book",false,"June 6th"));
        StoredUserInput.add(new Event("project meeting ",false,"Aug 6th 2pm","4pm"));
        StoredUserInput.add(new ToDo("join sports club",true));
    }
    private static void printFileContents(File F) throws FileNotFoundException {
//        File f = new File("/data/duke.txt"); // create a File for the given file path
        Scanner s = new Scanner(F);
        String New = new String();// create a Scanner using the File as the source
        while (s.hasNext()) {
            New=s.nextLine();
        }
        s.close();
    }
    public static <Task> File UpdateSavedFile(File DukeFile) throws IOException {
        //System.out.println(DukeFile.getAbsoluteFile());
        //System.out.println(DukeFile.exists());
        try{
            printFileContents(DukeFile);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error: Sorry, I couldn't find the file, But i'll help you navigate to the correct place :D");
            DukeFile = new File("src/main/java/duke.txt");
            return DukeFile;
        }
        FileWriter FW = new FileWriter(DukeFile);
        for(Tasks T:StoredUserInput)
        {
            FW.write(T.toString());
            FW.write("\n");
        }
        FW.close();
        return DukeFile;
    }

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        parser=new Parser();
        //LoadTestCases();

        try {
            tskList = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showLoadingError();
            tskList = new TaskList();
        }
    }

    public void run() throws DukeException
    {
        ui.ShowWelcomeMsg();
        boolean isExit =false;

        while (!isExit)
        {
            try
            {
                String fullCommand = ui.readCommand();
                ui.showLine(); // show the divider line ("_______")
                Command c = parser.parse(fullCommand);
                c.execute(tskList, ui, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }
    public static void main (String[]args) throws DukeException
    {
        new Duke("src/main/java/duke.txt").run();
    }
}
