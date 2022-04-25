/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
/**
 *
 * @author eduar
 */
public class Conexao {
    
    public static Connection getConnection() throws SQLException{
        Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuario", "root","");
        return conexao;
    }
}
