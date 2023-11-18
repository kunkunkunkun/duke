import duke.tasks.Tasks;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DeadlineTaskTest {

    static Tasks tsk;
    @BeforeAll
     public static void setUp() {
        tsk = new Tasks("TaskTest");
    }

    @Test
     void testCreation() {
        assertEquals("TaskTest",tsk.getDescription(),"Description not matched");
        assertFalse(tsk.isDone(),"New task should be undone upon creation");
        assertEquals(" ",tsk.getTaskName(),"New task should be empty string at first ");
    }

    @Test
    void testConvertInputTime(){
        tsk = new Tasks("TaskTest");
        String test = tsk.convertInputTime("2022-02-20");
        assertEquals("Feb 20 2022",test,"Date is not properly converted into String");
    }

    @Test
    void testConvertStringToDate(){
        tsk = new Tasks("TaskTest");
        LocalDate ld = tsk.convertStringToDate("Feb 20 2022");
        assertEquals(LocalDate.parse("2022-02-20",DateTimeFormatter.ofPattern("yyyy-MM-dd")),ld,"Date is not properly converted into Date");
    }

    @Test
    void testToString(){
        tsk = new Tasks("TaskTest");
        String test = tsk.toString();
        assertEquals("[ ] TaskTest",test,"toString methods is not matching");
    }

    @Test
    void testGetStatusIcon(){
        tsk = new Tasks("TaskTest");
        tsk.setIsDone(true);
        String test = tsk.getStatusIcon();
        assertEquals("X",test,"getStatusIcon methods is not matching");
    }
}
