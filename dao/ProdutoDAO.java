/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Produto;

/**
 *
 * @author snow
 */
public class ProdutoDAO {
    
    private Connection conexao;
    
    public ProdutoDAO() throws SQLException {
        this.conexao = Conexao.getConnection();
    }
    
    public boolean addProduto(Produto p) {
        String query = "insert into produto (prodesc, proqtd, provalor) values (?,?,?)";
        try {
         PreparedStatement stmt = conexao.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
         stmt.setString(1, p.getDescricao());
         stmt.setInt(2, p.getQuantidade());
         stmt.setDouble(3, p.getValor());
         stmt.execute();
        
         final ResultSet resultado = stmt.getGeneratedKeys();
         resultado.next();
         p.setIdProduto(resultado.getInt(1));
         stmt.close();
         conexao.close();
         return true;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public boolean alteraProduto(Produto p) {
        String query = "update produto set prodesc=?, proqtd=?, provalor=? where procodigo=?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1, p.getDescricao());
            stmt.setInt(2, p.getQuantidade());
            stmt.setDouble(3, p.getQuantidade());
            stmt.setInt(4, p.getIdProduto());
            stmt.execute();
            stmt.close();
            conexao.close();
            return true;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public boolean delProduto(int id) {
        String query = "delete from produto where procodigo=?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
            conexao.close();
            return true;
        } catch (SQLException ex) {
            //System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        } 
        //return false;
    }
   
    public List<Produto> consultaProduto(Produto p) {
        List<Produto> lista = new ArrayList<>();
        String query = "select procodigo, prodesc, proqtd, provalor from produto";
        try {
            PreparedStatement stmt = conexao.prepareStatement(query);
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next()) {
                 Produto produto = new Produto();
                 produto.setIdProduto(resultado.getInt("procodigo"));
                 produto.setDescricao(resultado.getString("prodesc"));
                 produto.setQuantidade(resultado.getInt("proqtd"));
                 produto.setValor(resultado.getDouble("provalor"));
                 lista.add(produto);
            }
            stmt.close();
            conexao.close();
            return lista;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
