/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.security.interfaces.RSAKey;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import model.Usuario;
import view.Cadastroview;
import view.MenuAdminView;
import view.MenuNormalView;
/**
 *
 * @author eduar
 */
public class UsuarioDAO {
    
    private final Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(Usuario usuario) throws SQLException{        
           
        String QUERY = "INSERT INTO usuarios (email, nome, senha, telefone, perg)" 
                + "VALUES('"+usuario.getEmail()+"', '"+usuario.getNome()+"', '"+usuario.getSenha()+"', '"+usuario.getTelefone()+"', '"+usuario.getPerg()+"')";           
        System.out.println(QUERY);
        PreparedStatement statement = connection.prepareStatement(QUERY);
        statement.execute();
        connection.close();
        
    }

    public boolean existeUsuario(Usuario usuario) throws SQLException {
        String QUERY = "SELECT * FROM usuarios WHERE email = '"+usuario.getEmail()+"' AND senha = '"+usuario.getSenha()+"'";
        System.out.println(QUERY);
        PreparedStatement statement = connection.prepareStatement(QUERY);
        statement.execute();
        
        ResultSet resultSet = statement.getResultSet();
        
        if (resultSet.next()){
            return true;
        } else{
            return false;
        }
                   
    }
    
    public void inserirAdm(Usuario usuario) throws SQLException{
        String QUERY = "INSERT INTO usuarios (nome, email , senha , telefone ,ativo, nivelUsuario, perg)"
                + "VALUES('"+usuario.getNome()+"', '"+usuario.getEmail()+"', '"+usuario.getSenha()+"', '"+usuario.getTelefone()+"', '"+usuario.getAtivo()+"', '"+usuario.getNivelUsuario()+"','"+usuario.getPerg()+"')";
        PreparedStatement statement = connection.prepareStatement(QUERY);
        statement.executeUpdate();
        connection.close();
    }
    
    public void atualizarUser(Usuario usuario) throws SQLException{
        String QUERY = "UPDATE usuarios SET nome = '"+usuario.getNome()+"',"
                + " email = '"+usuario.getEmail()+"',"
                + " senha = '"+usuario.getSenha()+"',"
                + " telefone = '"+usuario.getTelefone()+"',"
                + " ativo = '"+usuario.getAtivo()+"',"
                + " perg = '"+usuario.getPerg()+"',"
                + " nivelUsuario = '"+usuario.getNivelUsuario()+"'"
                + " WHERE id = '"+usuario.getId()+"'";
        PreparedStatement statement = connection.prepareStatement(QUERY);
        statement.executeUpdate();
        connection.close();
    }
    
    public void deletarUser(Usuario usuario) throws SQLException{
        String QUERY = "UPDATE usuarios set ativo = 0 WHERE email = '"+usuario.getEmail()+"'";
        PreparedStatement statement = connection.prepareStatement(QUERY);
        statement.executeUpdate();
        connection.close();
    }
    
    public void mudarSenha(Usuario usuario) throws SQLException{
        String QUERY = "UPDATE usuarios SET senha = '"+usuario.getSenha()+"' WHERE email = '"+usuario.getEmail()+"' AND perg = '"+usuario.getPerg()+"'";
        PreparedStatement statement = connection.prepareStatement(QUERY);
        statement.executeUpdate();
    }
    
    public boolean ehAdmin(Usuario usuario) throws SQLException{
        String QUERY = "SELECT * FROM usuarios WHERE email = '"+usuario.getEmail()+"' AND nivelUsuario = 'ADMIN'";
   
        PreparedStatement statement = connection.prepareStatement(QUERY);
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        if (resultSet.next()){
            return true;
        } else{
            return false;
        }
    }
    
    public boolean ehNormal(Usuario usuario) throws SQLException{
        String QUERY = "SELECT * FROM usuarios WHERE email = '"+usuario.getEmail()+"' AND nivelUsuario = 'NORMAL'";
        PreparedStatement statement = connection.prepareStatement(QUERY);
        statement.execute();
        ResultSet resultSet = statement.getResultSet();      
        if (resultSet.next()){           
            return true;
        } else{
            return false;
        }
        
    }
    
    public void atualizarse(Usuario usuario) throws SQLException{
        String QUERY = "UPDATE usuarios SET nome = '"+usuario.getNome()+"',"
                + " email = '"+usuario.getEmail()+"',"
                + " telefone = '"+usuario.getTelefone()+"',"
                + " perg = '"+usuario.getPerg()+"'"
                + " WHERE senha = '"+usuario.getSenha()+"' AND nivelUsuario = 'NORMAL'";
        PreparedStatement statement = connection.prepareStatement(QUERY);
        statement.executeUpdate();
        connection.close();
    }
    
    public boolean verificaTrocaSenha(Usuario usuario) throws SQLException{
        String QUERY = "SELECT * FROM usuarios WHERE email = '"+usuario.getEmail()+"'";
        PreparedStatement statement = connection.prepareStatement(QUERY);
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        if (resultSet.next()){
            return true;
        } else{
            return false;
        }
    }
    
    public boolean emailDuplicado(Usuario usuario) throws SQLException{
        String QUERY = "SELECT * FROM usuarios WHERE email = '"+usuario.getEmail()+"'";
        PreparedStatement statement = connection.prepareStatement(QUERY);
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        if (resultSet.next()){
            return false;
        } else{
            return true;
        }
    }
    
    
}
