/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mooc.logic;

import mooc.ui.UserInterface;

/**
 *
 * @author EduardoPC
 */
public class ApplicationLogic {
    
    private UserInterface ui;
    
    public ApplicationLogic(UserInterface ui){
        this.ui = ui;
    }
    
    public void execute(int times){
        int start = 0;
        while (start < times){
            System.out.println("Application logic is working");
            ui.update();
            start++;
        }
    }
    
}
