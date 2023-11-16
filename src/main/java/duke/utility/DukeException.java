/**
 * it's the exception class which extends from @link Exception
 * This class is part of the utility pattern implementation.
 *
 * @author Yan Kun
 * @version 1.0
 * @since 1.0
 */

package duke.utility;

public class DukeException extends Exception
{
    public DukeException (String Message)
    {
        super(Message);
    }
}
