/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlosg
 */
public class insertar {
    // Instancias la clase que hemos creado anteriormente
private conexionMySQL SQL = new conexionMySQL();
// Llamas al método que tiene la clase y te devuelve una conexión
private Connection conn = SQL.conectarMySQL();
// Query que usarás para hacer lo que necesites
String sSQL = "";
// PreparedStatement
PreparedStatement pstm;
    ResultSet st;

public boolean INSERTARINSTRUC(String nombre,String apellido, String telefono,String especialidad,String horario,String jornada){
   PreparedStatement pst = null;
       try {
            String insert = "insert into instructor(codigo,cedula,nombre,apellido,telefono,especialidad,jornada)values(?,?,?,?,?,?)";
            pst = conn.prepareStatement(insert);
            
            pst.setString(1, nombre);
            pst.setString(2, apellido);
            pst.setString(3, telefono);
            pst.setString(4, especialidad);
            pst.setString(5, horario);
             pst.setString(6, jornada);
             if(pst.executeUpdate()==1){
             return true;
             }
            
       }catch(Exception ex){
           System.err.println("ERROR"  +ex);
       }finally{
           try {
               if(conn != null)conn.close();
               if(pst != null) pst.close();
           } catch (Exception e) {
           System.err.println("ERROR"  +e);
           }
       
       }
       return false;
   }
        


    
}
