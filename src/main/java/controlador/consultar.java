/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author carlosg
 */
public class consultar {
    
    private conexionMySQL SQL = new conexionMySQL();
// Llamas al método que tiene la clase y te devuelve una conexión
private Connection conn = SQL.conectarMySQL();

 public boolean SELECTINSTRUC(String cedula){
        
           
           
            PreparedStatement pst = null;
            ResultSet rs=null;
              try {
            String select = "SELECT * FROM instructor WHERE cedula = ? ";
            pst = conn.prepareStatement(select);
            
            pst.setString(1, cedula);
            
            
            rs = pst.executeQuery();
            if(rs.absolute(1)){
                while(rs.next()){
                    
                }
                return true; }
            
        } catch (Exception e) {
                  System.err.println("ERROR" +e);
        } finally{
      
                  try {
                    if(conn != null) conn.close();
                    if(pst != null) pst.close();
                    if(rs != null) rs.close();
                  } catch (Exception e) {  System.err.println("ERROR" +e);
                  }
              }
        return false;
    
    }   
}
