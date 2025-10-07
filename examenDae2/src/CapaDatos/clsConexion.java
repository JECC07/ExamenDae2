/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaDatos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author JOSE
 */
public class clsConexion {
    private String driver,url,user,password;
    private Connection con;
    private Statement sent=null;
    
    public clsConexion(){
        this.driver="org.postgresql.Driver";
        this.url="jdbc:postgresql://localhost:5432/examenDae2";
        this.user="postgres";
        this.password="123456789";
        this.con=null;
    }
    
    public void conectar() throws Exception{
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url, user, password);
            
        } catch (ClassNotFoundException | SQLException e) {
            throw new Exception("Error al conectar a la bd");
        }
    }
    
    public void desconectar() throws Exception{
        try {
            con.close();
        } catch (SQLException e) {
            throw new Exception("Error al desconectar la bd");
        }
    }
    
    public ResultSet consultarBD(String strSQL) throws Exception{
        ResultSet rs = null;
        try {
            conectar();
            sent=con.createStatement();
            rs=sent.executeQuery(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al ejecutar consulta");
        }finally{
            if(con!=null){
                desconectar();
            }
        }
    }
    
    public void ejecutarBD(String strSQL) throws Exception{
        try {
            conectar();
            sent=con.createStatement();
            sent.executeUpdate(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al ejecutar consulta");
        }finally{
            if(con!=null){
                desconectar();
            }
        }
    }
}
