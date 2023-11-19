package duke;
import duke.commands.Command;
import duke.tasks.Tasks;
import duke.utility.DukeException;
import duke.utility.Storage;
import duke.utility.TaskList;
import duke.utility.Ui;
import duke.utility.Parser;

public class Duke extends Tasks
{

    private final Storage storage;
    private TaskList tskList;
    private final Ui ui;
    private final Parser parser;

    public Duke(String filePath) {

        ui = new Ui();
        storage = new Storage(filePath);
        parser=new Parser();

        try {
            tskList = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showLoadingError();
            tskList = new TaskList();
        }
    }

    public void run() throws DukeException {
        ui.ShowWelcomeMsg();
        boolean isExit =false;

        while (!isExit) {
            try
            {
                String fullCommand = ui.readCommand();
                ui.showLine(); // show the divider line ("_______")
                Command c = parser.parse(fullCommand);
                c.execute(tskList, ui, storage);
                isExit = c.isExit();
                if(isExit){
                    break;
                }
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }
    public static void main (String[]args) throws DukeException {
        new Duke("src/main/java/duke.txt").run();
    }
}
