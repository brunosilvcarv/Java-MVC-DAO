/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.TelaInicial;
import view.TelaProdutoLista;

/**
 *
 * @author snow
 */
public class InicioController {
    
    TelaInicial theView;
    
    public InicioController(TelaInicial theView){
        this.theView = theView;
        theView.addBotaoAreaProdutoEventListener(new AreaProduto());
    }
    
    class AreaProduto implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            TelaProdutoLista tela = new TelaProdutoLista();
            ListaProdutoController controller = new ListaProdutoController(tela);
            try {
                controller.carregaTabela();
            } catch (SQLException ex) {
                Logger.getLogger(InicioController.class.getName()).log(Level.SEVERE, null, ex);
            }
            tela.setLocationRelativeTo(null);
            tela.setVisible(true);
        }
        
    }
}
