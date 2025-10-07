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
public class clsClasificacion {
    clsConexion objCon = new clsConexion();
    ResultSet rs=null;
    String strSQL;
    
    public ResultSet listarClasificacion() throws Exception{
        strSQL="Select * from clasificacion";
        try {
            rs=objCon.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al consultar clasificacion");
        }
    }
    public String buscarPorId(int id) throws Exception{
        strSQL="Select nombre from clasificacion where id_clasificacion="+id;
        try {
            rs=objCon.consultarBD(strSQL);
            while(rs.next()){
                return rs.getString("nombre");
            }
        } catch (Exception e) {
        }
        return "";
    }
    public int buscarPorNombre(String nom) throws Exception{
        strSQL="Select id_clasificacion from clasificacion where nombre='"+nom+"'";
        try {
            rs=objCon.consultarBD(strSQL);
            while(rs.next()){
                return rs.getInt("id_clasificacion");
            }
        } catch (Exception e) {
        }
        return 0;
    }
}
