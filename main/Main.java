/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.AdicionaProdutoController;
import controller.EditaProdutoController;
import controller.ListaProdutoController;
import model.Produto;
import view.TelaProduto;
import view.TelaProdutoLista;

/**
 *
 * @author snow
 */
public class Main {
    
    public static void main(String[] args) {
        
        TelaProdutoLista theView = new TelaProdutoLista();
        ListaProdutoController theController = new ListaProdutoController(theView);
        theView.setLocationRelativeTo(null);
        theView.setVisible(true);
        
    }
}
