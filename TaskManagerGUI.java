import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.JDatePanel;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.UtilDateModel;

/**
 * Graphical User Interface for the Task Manager Application
 * 
 * @author Sabirah Shuaybi
 * @author Tseki Lhamo
 */
public class TaskManagerGUI extends JPanel implements ActionListener{
	
	private static final Color BRIGHT_BLUE = new Color (49, 154, 196);
	private static final Color LIGHT_GREEN = new Color (89, 214, 125);
	private static final Color BACKGROUND_COLOR = new Color (155, 202, 232);
	private static final int NUM_COLS = 25;  //number of characters allowed in text field
	private static final float FONT_SIZE = 20.0f;
	private static final float DATE_FONT_SIZE = 35.0f;
	private static final Font font = new Font("Arial", Font.BOLD, 30);
	
	private JButton addButton = new JButton("Add Task");
	private JButton completedButton = new JButton("Task Completed");
	private JTextField taskStr = new JTextField(NUM_COLS);
	private JComboBox<String> difficultyLevel = new JComboBox<>();
	private JLabel progressLabel = new JLabel("Total Number of Tasks Completed: ");
	private JLabel futureLabel = new JLabel("Total Number of Remaining Tasks: ");
	
	private Task nextTask = new Task();
	
	public TaskManagerGUI() {
		super(new BorderLayout());
		this.setBackground(Color.BLACK);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4)); 
		buildDatePanel();
		buildInputPanel();
		buildDisplayPanel();
		
		addButton.addActionListener(this);
		completedButton.addActionListener(this);
		
		addButton.setFont(font);
		completedButton.setFont(font);
		
		addButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4)); 
		completedButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
		
		colorButton(addButton, BRIGHT_BLUE);
		colorButton(completedButton, LIGHT_GREEN);

		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Button Handling 
	}
	
	
	/**
	 * Builds, designs and adds functionality to the date panel (which is in charge of
	 * displaying the current date at the top of the window)
	 */
	public void buildDatePanel() {
		JPanel datePanel = new JPanel(new BorderLayout());
		datePanel.setBorder(BorderFactory.createLineBorder(new Color(7, 150, 71), 4)); 
		datePanel.setBackground(LIGHT_GREEN);
		
		java.util.Date today = new java.util.Date();
		JLabel date = new JLabel("Today's Date:  " + today.toString()); 
		date.setBorder(new EmptyBorder(25, 25, 25, 25));
		date.setFont (date.getFont().deriveFont(DATE_FONT_SIZE));
		datePanel.add(date, BorderLayout.CENTER);
		
		add(datePanel, BorderLayout.NORTH);
	}
	
	
	/**
	 * Builds the left side of the application, namely the input portion
	 */
	public void buildInputPanel() {
		JPanel inputPanel = new JPanel(new GridLayout(6,1));
		inputPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
		inputPanel.setBackground(BACKGROUND_COLOR);
		
		inputPanel.add(taskStr);
		
		difficultyLevel.addItem("Easy");
	    difficultyLevel.addItem("Medium");
	    difficultyLevel.addItem("Hard");
		JLabel instructions = new JLabel("Select the Difficulty Level of the Task");
		instructions.setFont(instructions.getFont().deriveFont(FONT_SIZE));
	    inputPanel.add(instructions);
		inputPanel.add(difficultyLevel);
		
		UtilDateModel model = new UtilDateModel();
		JDatePicker datePicker = new JDatePicker(model);
		java.util.Date selectedDate = (java.util.Date)datePicker.getModel().getValue();
		JLabel instructions2 = new JLabel("Enter the Task's Due Date");
		instructions2.setFont(instructions2.getFont().deriveFont(FONT_SIZE));
		inputPanel.add(instructions2);
		inputPanel.add(datePicker);
		inputPanel.add(addButton);
		add(inputPanel, BorderLayout.WEST);
	}
	
	/**
	 * Builds the right side of the application, namely the display portion 
	 */
	public void buildDisplayPanel() {
		JPanel displayPanel = new JPanel(new GridLayout(5, 1));
		displayPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
		displayPanel.setBackground(BACKGROUND_COLOR);
		
		
		JLabel upcomingTaskLabel = new JLabel("My Next Task:");
		upcomingTaskLabel.setFont(upcomingTaskLabel.getFont().deriveFont(FONT_SIZE));
		progressLabel.setFont(progressLabel.getFont().deriveFont(FONT_SIZE));
		futureLabel.setFont(futureLabel.getFont().deriveFont(FONT_SIZE));
		
		displayPanel.add(upcomingTaskLabel);
		//displayPanel.add(nextTask); //FILLER object until real functionality is added 
		displayPanel.add(new JLabel("TASK DETAILS GO HERE")); //TEMP
		displayPanel.add(completedButton);
		displayPanel.add(progressLabel);
		displayPanel.add(futureLabel);
		
		add(displayPanel, BorderLayout.EAST);
		
	}
	
	/**
     * A generic method that colors any JButton passed in with
     * the color passed in.
     *
     * @param button: the JButton to be colored
     * @param color: the color of the flavor, which will be
     *             the color of the JButton
     */
    private void colorButton(JButton button, Color color) {
        button.setBackground(color);
        button.setOpaque(true);
    }

}
