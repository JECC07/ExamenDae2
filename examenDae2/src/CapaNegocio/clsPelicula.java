/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaDatos.clsConexion;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author JOSE
 */
public class clsPelicula {

    clsConexion objCon = new clsConexion();
    ResultSet rs = null;
    String strSQL;

    public ResultSet listarPeliculas() throws Exception {
        strSQL = "Select * from pelicula";
        try {
            rs = objCon.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar peliculas");
        }
    }

    public void nuevoPelicula(String cod, String nom, int idGen, int año, int idPai, int dura, int idCla, String audi, String idio, Date fecha, String pro, boolean est) throws Exception {
        strSQL = "Insert into pelicula values('" + cod + "','" + nom + "'," + idGen + "," + año + "," + idPai + "," + dura + "," + idCla + ",'" + audi + "','" + idio + "','" + fecha + "','" + pro + "'," + est + ")";
        try {
            objCon.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al insertar peliculas");
        }
    }

    public void actualizarPelicula(String cod, String nom, int idGen, int año, int idPai, int dura, int idCla, String audi, String idio, Date fecha, String pro, boolean est) throws Exception {
        // Usamos el código como identificador único para actualizar el registro
        strSQL = "UPDATE pelicula SET "
                + "nombre='" + nom + "', "
                + "id_genero=" + idGen + ", "
                + "anio=" + año + ", "
                + "id_pais=" + idPai + ", "
                + "duracion_min=" + dura + ", "
                + "id_clasificacion=" + idCla + ", "
                + "audiencia_recomendada='" + audi + "', "
                + "idioma_original='" + idio + "', "
                + "fecha_estreno='" + fecha + "', "
                + "productor='" + pro + "', "
                + "estado=" + est + " "
                + "WHERE codigo='" + cod + "'";

        try {
            objCon.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al actualizar película");
        }
    }

    public ResultSet buscarPelicula(String codigo) throws Exception {
        strSQL = "select * from pelicula where codigo='" + codigo + "'";
        try {
            rs = objCon.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar peliculas");
        }
    }

    public void darDeBaja(String cod) throws Exception {
        strSQL = "update pelicula set estado= false where codigo='" + cod + "'";
        try {
            objCon.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al dar de baja peliculas");
        }
    }

    public void eliminarPelicula(String cod) throws Exception {
        strSQL = "delete from pelicula where codigo='" + cod + "'";
        try {
            objCon.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al eliminar peliculas");
        }
    }

}
