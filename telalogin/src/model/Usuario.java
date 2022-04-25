/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author eduar
 */
public class Usuario {
    private String id;
    private String email;
    private String nome;
    private String telefone;
    private String nivelUsuario;
    private String ativo;
    private String senha;

    public Usuario(String id, String email, String nome, String nivelUsuario) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.nivelUsuario = nivelUsuario;
    }
    private String perg;

    public Usuario(String email, String senha, String perg) {
        this.email = email;
        this.senha = senha;
        this.perg = perg;
    }
    
    public Usuario(String email){
        this.email = email;
    }

    public Usuario(String perg, String email, String nome, String telefone, String nivelUsuario, String ativo, String senha) {
        this.perg = perg;
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
        this.nivelUsuario = nivelUsuario;
        this.ativo = ativo;
        this.senha = senha;
    }

    public Usuario(String id, String email, String nome, String telefone, String nivelUsuario, String ativo, String senha, String perg) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
        this.nivelUsuario = nivelUsuario;
        this.ativo = ativo;
        this.senha = senha;
        this.perg = perg;
    }

    public Usuario(String email, String nome, String telefone, String senha, String perg) {
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
        this.senha = senha;
        this.perg = perg;
    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Usuario(String id, String email, String nome, String telefone, String nivelUsuario, String ativo) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
        this.nivelUsuario = nivelUsuario;
        this.ativo = ativo;
    }

    
    
    public String getPerg() {
        return perg;
    }

    public void setPerg(String perg) {
        this.perg = perg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNivelUsuario() {
        return nivelUsuario;
    }

    public void setNivelUsuario(String nivelUsuario) {
        this.nivelUsuario = nivelUsuario;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
