/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static controller.CadastroC.getSHA256;
import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;
import view.MenuNormalView;

/**
 *
 * @author eduar
 */
public class MenuNormalC {

    private MenuNormalView view;

    public MenuNormalC(MenuNormalView view) {
        this.view = view;
    }
    
    public void editarNormal(){
        
        String nome = view.getjTextFieldMUnome().getText();
        String email = view.getjTextFieldMUemail().getText();
        String telefone = view.getjTextFieldMUtelefone().getText();
        String perg = view.getjTextFieldMUJogo().getText();
        String senha = view.getjPasswordFieldMUsenha().getText();
        senha = getSHA256(senha);
        
        Usuario usuario = new Usuario(email, nome, telefone, senha, perg);
        
        try {
            Connection conexao = new Conexao().getConnection();
            UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
            usuarioDao.atualizarse(usuario);
            
            JOptionPane.showMessageDialog(null, "Usuario atualizado com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(MenuNormalView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
