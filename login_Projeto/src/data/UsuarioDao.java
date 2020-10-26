/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDao {
   //chamado de con
    Connection conecta;
    //chamado de st
    PreparedStatement autorizacao;
    ResultSet rs;
    
    
    public boolean conectar(){
        try {  
            Class.forName("com.mysql.jdbc.Driver");
            //                      url, usuario, senha
            conecta = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "");
            //                                                ipdamaquina  
            
            
            return true;
            
        } catch (ClassNotFoundException | SQLException ex) {
            return false;
        }
    
    }
    
    
   /* public int salvar(Usuarios usuario){
       int status;
        
        try {  
            
            autorizacao = conecta.prepareStatement("INSERT INTO funcionario VALUES(?,?,?,?)");
            autorizacao.setString(1, funcionario.getMatricula());
            autorizacao.setString(2, funcionario.getNome());
            autorizacao.setString(3, funcionario.getCargo());
            autorizacao.setDouble(4, funcionario.getSalario());
            
            status = autorizacao.executeUpdate();
            return status;//retorna 1
        }catch(SQLException ex){    
            //System.out.println(ex.getErrorCode());
            return ex.getErrorCode();
            //1062 pk ja cadastrada
        }
    }
    */
    
    public void desconectar(){
        try {
            conecta.close();
        } catch (SQLException ex) {
            
        }
    }
    
    /*public Funcionario Consultar(String matricula){
        Funcionario funcionario = new Funcionario();
        try {
           
            
            autorizacao = conecta.prepareStatement("SELECT * FROM funcionario WHERE matricula = ?");
            autorizacao.setString(1, matricula);
            rs = autorizacao.executeQuery();
            //rs.next verifica se a consulta encontrou o funcionario com a matricula informada
            if(rs.next()){//se encontrou o funcionario
                funcionario.setMatricula(rs.getString("matricula"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setSalario(rs.getDouble("salario"));
                return funcionario;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    */
}