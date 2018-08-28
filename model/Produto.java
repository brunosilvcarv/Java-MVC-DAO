/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author snow
 */
public class Produto {
    
    private int idProduto;
    private String descricao;
    private int quantidade;
    private double valor;

    public Produto() {
    }

    public Produto(String descricao, int quantidade, double valor) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public Produto(int idProduto, String descricao, int quantidade, double valor) {
        this.idProduto = idProduto;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valor = valor;
    }
    

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
}
