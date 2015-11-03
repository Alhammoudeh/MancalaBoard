
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
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
        
        frame.add(topHeader, BorderLayout.NORTH); // Add the topHeader panel to the top
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
            
    
}