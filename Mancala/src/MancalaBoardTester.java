/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Will
 */
public class MancalaBoardTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Model model = new Model();
       Controller control = new Controller(model);
       View view = new View(control);
    }
    
}
