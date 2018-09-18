/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author snow
 */
public class Compra {
    
    private int idCompra;
    private Calendar dataCompra;
    private List<ItemCompra> itens;

    public Compra() {
    }

    public Compra(Calendar dataCompra, List<ItemCompra> itens) {
        this.dataCompra = dataCompra;
        this.itens = itens;
    }

    public Compra(int idCompra, Calendar dataCompra, List<ItemCompra> itens) {
        this.idCompra = idCompra;
        this.dataCompra = dataCompra;
        this.itens = itens;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Calendar getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Calendar dataCompra) {
        this.dataCompra = dataCompra;
    }

    public List<ItemCompra> getItens() {
        return itens;
    }

    public void setItens(List<ItemCompra> itens) {
        this.itens = itens;
    }
    
    /*
    public double calculaValorTotal() {
        return 2;
    }
    
    public void addItemLista(ItemCompra item) {
        
    }
    */
}
