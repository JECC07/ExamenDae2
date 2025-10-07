/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaDatos.clsConexion;
import java.sql.ResultSet;

/**
 *
 * @author JOSE
 */
public class clsCorrelativo {
    clsConexion objCon = new clsConexion();
    ResultSet rs=null;
    String strSQL;
    
    public int correlativo() throws Exception{
        strSQL="Select coalesce(max(ultimo_numero),0)+1 as numero from correlativo";
        try {
            rs=objCon.consultarBD(strSQL);
            while(rs.next()){
                return rs.getInt("numero");
            }
        } catch (Exception e) {
        }
        return 0;
    }
    public void insertarCorrelativo(int corre) throws Exception{
        strSQL="Insert into correlativo(ultimo_numero) values("+corre+")";
        try {
            objCon.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al insertar correlativo");
        }
    }
}
