/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static controller.CadastroC.getSHA256;
import view.MenuAdminView;
import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.UIManager.get;
import javax.swing.table.DefaultTableModel;
import model.Usuario;


/**
 *
 * @author eduar
 */
public class MenuAdminC {
    
    private MenuAdminView view;

    public MenuAdminC(MenuAdminView view) {
        this.view = view;
    }
    
    public void cadastrar(){
        
        String nome = view.getjTextFieldMAnome().getText();
        String email = view.getjTextFieldMAemail().getText();
        String telefone = view.getjTextFieldMAtelefone().getText();
        String senha = view.getjPasswordFieldMAsenha().getText();
        String nivelUsuario = view.getjTextFieldMAnivelUsuario().getText();
        String ativo = view.getjTextFieldMAativo().getText();
        String perg = view.getjTextFieldMAperg().getText();
        
        
        senha = getSHA256(senha);
        
        Usuario usuario = new Usuario(perg, email, nome, telefone, nivelUsuario, ativo, senha);
        
        try {
            Connection conexao = new Conexao().getConnection();
            UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
            usuarioDao.inserirAdm(usuario);
            
            JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(MenuAdminView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizar(){
        String nome = view.getjTextFieldMAnome().getText();
        String email = view.getjTextFieldMAemail().getText();
        String telefone = view.getjTextFieldMAtelefone().getText();
        String senha = view.getjPasswordFieldMAsenha().getText();
        String nivelUsuario = view.getjTextFieldMAnivelUsuario().getText();
        String id = view.getjTextFieldMAid().getText();
        String ativo = view.getjTextFieldMAativo().getText();
        String perg = view.getjTextFieldMAperg().getText();
        
        senha = getSHA256(senha);
        
        Usuario usuario = new Usuario(id, email, nome, telefone, nivelUsuario, ativo, senha, perg); 
        
        try {
            Connection conexao = new Conexao().getConnection();
            UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
            usuarioDao.atualizarUser(usuario);
            
            JOptionPane.showMessageDialog(null, "Usuario atualizado com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(MenuAdminView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deletaUser(){
        
        String email = view.getjTextFieldMAemail().getText();
        Usuario usuario = new Usuario(email);
        
        try {
            Connection conexao = new Conexao().getConnection();
            UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
            usuarioDao.deletarUser(usuario);
            
            JOptionPane.showMessageDialog(null, "Usuario deletado com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(MenuAdminView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
 
}
