import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Application for Task Manager GUI (start of execution) 
 *
 * @author Sabirah Shuaybi
 * @author Tseki Lhamo
 */
public class TaskManagerApplication {
	
	//Window/Frame dimensions
    private static final int FRAME_WIDTH = 750;
    private static final int FRAME_HEIGHT = 650;

    /**
     * Create a JFrame that holds a TaskManagerGUI.
     **/
    public static void main(String[] args)
    {
        JFrame taskFrame;

        //Create a new JFrame to hold an A Task Manager
        taskFrame = new JFrame("My Task Manager");

        //Set size
        taskFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        //Create an TaskManagerGUI and add it to frame
        taskFrame.getContentPane().add(new TaskManagerGUI());

        //Exit normally on closing the window
        taskFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Show frame
        taskFrame.setVisible(true);
    }
}
