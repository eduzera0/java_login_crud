/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.Conexao;
import dao.UsuarioDAO;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;
import view.Cadastroview;
import view.Loginview;

/**
 *
 * @author eduar
 */
public class CadastroC {
    
    private Cadastroview view;

    public CadastroC(Cadastroview view) {
        this.view = view;
    }
    
    public void salvaUsuario() throws SQLException{
        String email = view.getjTextFieldEmail().getText();
        String nome = view.getjTextFieldNome().getText();
        String telefone = view.getjTextFieldTelefone().getText();
        String senha = view.getjPasswordFieldSenha().getText();
        String perg = view.getjTextFieldperg1().getText();
        String confirmSenha = view.getjPasswordFieldSenhaConfirm().getText();
        
        Usuario usuariodupli = new Usuario(email);
        Connection conexao = new Conexao().getConnection();
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        boolean emailusado = usuarioDao.emailDuplicado(usuariodupli);
        
        if(senha.equals(confirmSenha)){
            if(emailusado){
                try {
                    senha = getSHA256(senha);
                    Usuario usuario = new Usuario(email, nome, telefone, senha, perg);
                
                    usuarioDao.insert(usuario);
            
                    JOptionPane.showMessageDialog(null, "Usuario salvo com sucesso");
                    Loginview login = new Loginview();
                    login.setVisible(true);
            
                } catch (SQLException ex) {
                    Logger.getLogger(Cadastroview.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else {
                JOptionPane.showMessageDialog(null, "Email ja cadastrado");
            }

        } else{
            JOptionPane.showMessageDialog(null, "As senhas devem combinar");
        }
        
    }
    
    public static String getSHA256(String senha){

	String toReturn = null;
	try {
	    MessageDigest digest = MessageDigest.getInstance("SHA-256");
	    digest.reset();
	    digest.update(senha.getBytes("utf8"));
	    toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	return toReturn;
    }
    
}
