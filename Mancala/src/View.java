
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private final Controller control;
    
    public View(Controller c)
    {
        control = c;
        textFields = new JTextField[TOTALFIELDS];
        frame = new JFrame();
        redo = new JButton("Redo Move");
        playerTurn = new JTextArea("Player A");
        move = new JButton("Move");
        
        JPanel topHeader = new JPanel(); // Create a panel to use the north area of the JFrame
        topHeader.setLayout(new FlowLayout()); // Set the layout to go from left to right 
        
        // When the redo button is pressed, have the controller class intiate the redo action
        redo.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                c.redo();
            }
        });
        
        // When the move button is pressed, have the controller class intiate the move action
        move.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                c.move();
            }
        });
        
        topHeader.add(redo); // Add the redo button on the left 
        topHeader.add(playerTurn); // Add the playerTurn's signal in the middle 
        topHeader.add(move); // Add the move button on the right
        
        JPanel leftBank = new JPanel(); // Bank A
        JTextArea leftTextArea = new JTextArea(30, 5); // 40 rows and 10 columns
        JLabel bankB = new JLabel();
        bankB.setText("<HTML>M<br>A<br>N<br>C<br>A<br>L<br>A<br><br>B</HTML>");
        // http://stackoverflow.com/questions/92781/how-do-i-present-text-vertically-in-a-jlabel-java-1-6
        leftBank.setLayout(new FlowLayout());
        leftBank.add(bankB);
        leftBank.add(leftTextArea);
        
        JPanel rightBank = new JPanel(); // Bank B
        JTextArea rightTextArea = new JTextArea(30, 5); // 40 rows and 10 columns
        JLabel bankA = new JLabel();
        bankA.setText("<HTML>M<br>A<br>N<br>C<br>A<br>L<br>A<br><br>A</HTML>");
        rightBank.setLayout(new FlowLayout());
        rightBank.add(rightTextArea); 
        rightBank.add(bankA);
        
        // Adding in the JLabels and JTextFields inside the center of the board
        JPanel centerBoard = new JPanel();
        centerBoard.setLayout(new BoxLayout(centerBoard, BoxLayout.Y_AXIS)); // Have the centerBoard display and add components from top to bottom
        
        JLabel playerBDirection = new JLabel("<HTML><p>\u25C4------- PLAYER B</p></HTML>");
        centerBoard.add(playerBDirection);
        JLabel playerADirection = new JLabel("<HTML><p>-------\u25BA PLAYER A</p></HTML>");
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
        for(int i = 6; i >= 0; i--)
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
        centerBoard.add(playerADirection);
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