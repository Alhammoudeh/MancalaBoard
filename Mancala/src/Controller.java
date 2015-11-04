/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Will
 */
public class Controller {
    
    private Model model;
    private View view;
    
    public Controller(Model model)
    {
        this.model = model;
    }
    
    // I don't know, maybe we'll use this constructor. 
//    public Controller(Model model, View view)
//    {
//        this.model = model;
//        this.view = view;
//    }
    
    // Called by the move button
    public void move()
    {
        System.out.println("I am move from Controller class");
        System.out.println("Remember to repaint or have the view update itself with the new data.");
    }
    
    // Called by the redo method
    public void redo()
    {
        System.out.println("I am redo from Controller class");
        System.out.println("Remember to repaint or have the view update itself with the new data.");
    }
    
}
