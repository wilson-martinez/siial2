/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso_Datos;
import java.util.ArrayList;
import java.sql.ResultSet;
import Entidad_Negocio.Consolidado_Planilla_EN;

/**
 *
 * @author WILSON
 */
public class Consolidado_Planilla_AD {
    
     Conectar Con= new Conectar();
     ResultSet Res=null;
    
     
     /*

  Consolidado_Planilla
     
  "IdCons_Planilla" 
  "Consolidado" integer,
  "Planilla" integer,
 
     */
    
     
       public Boolean Eliminar_Planilla_Consolidado(Integer Id_Planilla, Integer Id_Cosolidado) {

           String SqlInst =" delete  from \"Consolidado_Planilla\" where \"Consolidado\"='"+Id_Cosolidado+"' and  \"Planilla\"='"+Id_Planilla+"' ";

        try {
            return Con.Ejecutar_Actualizacion(SqlInst);
        } catch (Exception x) {
            return false;
        }

    }
     
     
     
     
     
    public Boolean Registrar_Planilla_Consolidado(Consolidado_Planilla_EN Cons_Plan_EN) {

        String SqlInst = "INSERT INTO  \"Consolidado_Planilla\"(\"Consolidado\",\"Planilla\") VALUES ";
        SqlInst = SqlInst + "('" + Cons_Plan_EN.getConsolidado() + "','" + Cons_Plan_EN.getPlanilla() + "');";

        try {
            return Con.Ejecutar_Actualizacion(SqlInst);
        } catch (Exception x) {
            return false;
        }

    }
    
    
    
     public ResultSet Listar_Planillas_Consolidadas(Integer Id_Consolidado) {
            
       
            
         String Sql = " select distinct  Ci.\"Tipo_Ciclo\" ,Cp.\"Planilla\",Cp.\"Consolidado\",Pla.\"Fecha_Reg\",Pla.\"Secos\",Pla.\"Frescos\",Pla.\"Sl_Abas\",Pla.\"Dias_Abas\",Pla.\"Val_Estancia\",Pla.\"Sl_Rac\",Pla.\"Dias_Rac\" from \"Planilla\"  Pla\n"
                 + " inner join \"Consolidado_Planilla\" Cp on Cp.\"Planilla\" = Pla.\"Id_Planilla\"\n"
                 + " inner join \"Consolidado\" Cons on Cons.\"Id_Consolidado\" = Cp.\"Consolidado\"\n"
                 + " inner join \"Ciclo\" Ci on Ci.\"Planilla\"= Pla.\"Id_Planilla\"\n"
                 + " where Cp.\"Consolidado\"='"+Id_Consolidado+"' and Cons.\"Estado_Cons\"='Borrador'  order by Ci.\"Tipo_Ciclo\" ";

        try {
            Res = Con.Ejecutar_Consulta(Sql);
        } catch (Exception x) {
        }
        return Res;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
}
