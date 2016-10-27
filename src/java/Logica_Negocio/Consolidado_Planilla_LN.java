/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica_Negocio;

import Entidad_Negocio.Consolidado_Planilla_EN;
import Acceso_Datos.Consolidado_Planilla_AD;
import java.sql.ResultSet;

/**
 *
 * @author WILSON
 */
public class Consolidado_Planilla_LN {
    
    Consolidado_Planilla_AD Cons_Plan_AD= new Consolidado_Planilla_AD();
      
    public Boolean Registrar_Planilla_Consolidado(Consolidado_Planilla_EN Cons_Plan_EN)
        {
        return  Cons_Plan_AD.Registrar_Planilla_Consolidado(Cons_Plan_EN);
   
        }  
    
      public ResultSet Listar_Planillas_Consolidadas(Integer Id_Consolidado) {
            
            return Cons_Plan_AD.Listar_Planillas_Consolidadas(Id_Consolidado);
        }
            
 
      public Boolean Eliminar_Planilla_Consolidado(Integer Id_Planilla, Integer Id_Cosolidado) 
                {
                    
                     return Cons_Plan_AD.Eliminar_Planilla_Consolidado(Id_Planilla,Id_Cosolidado);
          
                }

      
      
      
      
      
    
    
}
