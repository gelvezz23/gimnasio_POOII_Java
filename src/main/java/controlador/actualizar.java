/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author carlosg
 */
public class actualizar {
    
     private conexionMySQL SQL = new conexionMySQL();
    // Llamas al método que tiene la clase y te devuelve una conexión
    private Connection conn = SQL.conectarMySQL();
    
     public boolean UPDATE (String nombre,String cedula,String correo,String cumplea,String hidden,int salario){
   PreparedStatement pst = null;
       try {
            String up = "UPDATE usuario SET nombre='"+nombre+"',cedula='"+cedula+"',correo='"+correo+"',telefono='"+cumplea+"',salario='"+salario+"'  WHERE nombre='"+hidden+"' ";
            pst = conn.prepareStatement(up);
           
            
             if(pst.executeUpdate() != 0){
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
