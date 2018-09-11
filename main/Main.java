/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.InicioController;
import view.TelaInicial;

/**
 *
 * @author snow
 */
public class Main {
    
    public static void main(String[] args) {
        
        TelaInicial theView = new TelaInicial();
        InicioController theController = new InicioController(theView);
        theView.setLocationRelativeTo(null);
        theView.setVisible(true);
        
    }
}
