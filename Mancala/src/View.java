
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Will
 */
public class View {
    private final int TOTALFIELDS = 12;
    private final JTextField [] textFields;
    private final JFrame frame;
    private final JButton redo;
    private final JButton move;
    private final JTextArea playerTurn;
    
    public View()
    {
        textFields = new JTextField[TOTALFIELDS];
        frame = new JFrame();
        redo = new JButton("Redo Move");
        playerTurn = new JTextArea("Player A");
        move = new JButton("Move");
        
        JPanel topHeader = new JPanel(); // Create a panel to use the north area of the JFrame
        topHeader.setLayout(new FlowLayout()); // Set the layout to go from left to right 
        topHeader.add(redo); // Add the redo button on the left 
        topHeader.add(playerTurn); // Add the playerTurn's signal in the middle 
        topHeader.add(move); // Add the move button on the right
        
        JPanel leftBank = new JPanel(); // Bank A
        JTextArea leftTextArea = new JTextArea(30, 5); // 40 rows and 10 columns
        leftBank.add(leftTextArea);
        
        JPanel rightBank = new JPanel(); // Bank B
        JTextArea rightTextArea = new JTextArea(30, 5); // 40 rows and 10 columns
        rightBank.add(rightTextArea); 
        
        // Adding in the JLabels and JTextFields inside the center of the board
        JPanel centerBoard = new JPanel();
        centerBoard.setLayout(new BoxLayout(centerBoard, BoxLayout.Y_AXIS)); // Have the centerBoard display and add components from top to bottom
        
        // Create the titles for Pit B
        JPanel labelsForPitB = new JPanel();
        labelsForPitB.setLayout(new FlowLayout());
        for(int i = 0; i < 6; i++)
        {
            JLabel pitLabel = new JLabel(); // Create a label/title for the pit
            pitLabel.setText("B" + i); // B1, B2, ... B5
            labelsForPitB.add(pitLabel);
        }
        centerBoard.add(labelsForPitB); // Add the labelsForPitB into centerBoard's panel
        
        JPanel pitsB = new JPanel();
        pitsB.setLayout(new FlowLayout());
        for(int i = 0; i < 6; i++)
        {
            JTextField pit = new JTextField();
            pit.setText(Integer.toString(i));
            pitsB.add(pit);
            addTextFields(pit);
        }
        centerBoard.add(pitsB);
        
        JPanel pitsA = new JPanel();
        pitsA.setLayout(new FlowLayout());
        for(int i = 0; i < 6; i++)
        {
            JTextField pit = new JTextField();
            pit.setText(Integer.toString(i));
            pitsA.add(pit);
            addTextFields(pit);
        }
        centerBoard.add(pitsA);
        
        // Create the titles for Pit A
        JPanel labelsForPitA = new JPanel();
        labelsForPitB.setLayout(new FlowLayout());
        for(int i = 0; i < 6; i++)
        {
            JLabel pitLabel = new JLabel(); // Create a label/title for the pit
            pitLabel.setText("A" + i); // B1, B2, ... B5
            labelsForPitA.add(pitLabel);
        }
        centerBoard.add(labelsForPitA); // Add the labelsForPitB into centerBoard's panel
       
        frame.add(topHeader, BorderLayout.NORTH); // Add the topHeader panel to the top
        frame.add(leftBank, BorderLayout.WEST); // Put the left Bank on the West of the board.
        frame.add(rightBank, BorderLayout.EAST); // Put the right Bank on the East of the board.
        frame.add(centerBoard, BorderLayout.CENTER); // Put all the pits and labels in the center.
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public void addTextFields(JTextField field)
    {
        for(int i = 0; i < TOTALFIELDS; i++)
        {
            if(textFields[i] == null)
                textFields[i] = field;
        }
    }
}