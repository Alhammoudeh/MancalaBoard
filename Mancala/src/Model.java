
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Will
 */
public class Model {
    
    private final int ROWS = 2; // 0 index row = player A, 1 index row = player B
    private final int COLUMN = 6; // 0 - 5 columns belong to player A or player B these are the pits including their bank
    private int [][] pits; // current pits 
    private int [][] redoPits; // for the redo button to put back the original pits
    private final ArrayList <JTextField> textFields; // The Pits
    private final ArrayList <ChangeListener> listeners; // Updating the number of stones in each pit
    private final JTextArea textArea; // PLayer A's or B's turn. Next to the redo and move buttons.
    
    public Model()
    {
        pits = new int[ROWS][COLUMN];
        redoPits = new int[ROWS][COLUMN];
        textFields = new ArrayList<JTextField>();
        textArea = new JTextArea("Player A"); // by default 
        listeners = new ArrayList<ChangeListener>();
    }
    
    public int getStonesFromPit(int row, int column)
    {
        return pits[row][column];
    }
    
    public void updateStonesFromPit(int row, int column, int stones)
    {
        pits[row][column] = stones;
    }
    
    public ArrayList <JTextField> getListOfTextFields()
    {
        return (ArrayList<JTextField>) textFields.clone();
    }
    
    public void addTextFields(JTextField field)
    {
        textFields.add(field);
    }
    
    public void togglePlayerTurn()
    {
        if(textArea.getText().equals("Player A"))
            textArea.setText("Player B");
        else 
            textArea.setText("Player A");
    }
    
    // Update the view
    public void updateView()
    {
        for(ChangeListener l: listeners)
        {
            l.stateChanged(new ChangeEvent(this));
        }
    }
    
    // Add changeListener to list (maybe add a change listener. I don't know)
    public void addListener(ChangeListener listener)
    {
        listeners.add(listener);
    }
    
}
