/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Produto;

/**
 *
 * @author snow
 */
public class TableModelProdutos extends AbstractTableModel{
    
    private Produto produto;
    private ProdutoDAO dao;
    private List<Produto> produtos;
    
    public TableModelProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    @Override
    public int getRowCount() {
        return produtos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        produto = produtos.get(linha);
        switch(coluna) {
            case 0 : return produto.getIdProduto();
            case 1: return produto.getDescricao();
            case 2: return produto.getQuantidade();
            case 3: return produto.getValor();
        }
        return null;
    }
    
    
    public String getColumnName(int coluna) {
        switch(coluna) {
            case 0 : return "código";
            case 1: return "Descrição";
            case 2: return "Quantidade";
            case 3: return "Valor";
        }
        return null;
    }
    
    
}