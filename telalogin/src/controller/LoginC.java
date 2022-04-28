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
import view.Loginview;
import view.MenuAdminView;
import view.MenuNormalView;

/**
 *
 * @author eduar
 */
public class LoginC {
    private Loginview view;

    public LoginC(Loginview view) {
        this.view = view;
    }
    
    public void verAdmin() throws SQLException{
        String email = view.getjTextField2Email().getText();
        
        Usuario usuarioCargo = new Usuario(email);
        
        Connection conexao = new Conexao().getConnection();
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        
        boolean cargo = usuarioDao.ehAdmin(usuarioCargo);
        
       if(cargo){
           MenuAdminView menuAdmin = new MenuAdminView();
           menuAdmin.setVisible(true);
       }  
    }
   
    public void verNormal() throws SQLException{
        String email = view.getjTextField2Email().getText();
        
        Usuario usuarioCargo = new Usuario(email);
        
        Connection conexao = new Conexao().getConnection();
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        
        boolean cargo = usuarioDao.ehNormal(usuarioCargo);
        
       if(cargo){
            MenuNormalView telaDeMenu = new MenuNormalView();
            telaDeMenu.setVisible(true);
       }       
    }
    
    public void autenticar() throws SQLException {
        
        String email = view.getjTextField2Email().getText();
        String senha = view.getjPasswordField2Senha().getText();
        
        senha = getSHA256(senha);
        
        Usuario usuarioAutenticar = new Usuario(email, senha);
        Usuario usuarioCargo = new Usuario(email);
        Usuario usuarioduplicado = new Usuario(email);
        
        Connection conexao = new Conexao().getConnection();
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);

        boolean existe = usuarioDao.existeUsuario(usuarioAutenticar);
        boolean admin = usuarioDao.ehAdmin(usuarioCargo);
        boolean normal = usuarioDao.ehNormal(usuarioCargo);

        if(existe){
            if(admin){
                MenuAdminView menuAdmin = new MenuAdminView();
                menuAdmin.setVisible(true);
            } else if(normal) {
                MenuNormalView telaDeMenu = new MenuNormalView();
                telaDeMenu.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(view, "Usuario ou senha invalidos");
        }  
    }
    
}
