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
import javax.swing.JOptionPane;
import model.Usuario;
import view.EsqueciSenhaView;
import view.Loginview;

/**
 *
 * @author eduar
 */
public class EsqueciSenhaC {
    
    private EsqueciSenhaView view;

    public EsqueciSenhaC(EsqueciSenhaView view) {
        this.view = view;
    }

    public void trocarSenha() throws SQLException{
        String perg = view.getjTextFieldJogoFavorito().getText();
        String email = view.getjTextFieldIDSenha().getText();
        String senha = view.getjPasswordFieldNovaSenha().getText();
        
        senha = getSHA256(senha);
        
        Usuario usuario = new Usuario(email, senha, perg);
        Usuario usuarioverificar = new Usuario(email);
        
        Connection conexao = new Conexao().getConnection();
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        usuarioDao.mudarSenha(usuario);
        
        boolean verificarSenha = usuarioDao.verificaTrocaSenha(usuarioverificar);
        
        if(verificarSenha){
            JOptionPane.showMessageDialog(null, "Senha alterada com sucesso");
            Loginview login = new Loginview();
            login.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Dados Invalidos");
        }
        
        
    }
    
}
