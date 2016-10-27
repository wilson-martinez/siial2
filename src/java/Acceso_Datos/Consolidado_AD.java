/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso_Datos;
import java.util.ArrayList;
import java.sql.ResultSet;
import Entidad_Negocio.Consolidado_EN;

/**
 CREATE TABLE "Consolidado"
(
  "Id_Consolidado" serial NOT NULL,
  "fecha_Cons" date,
  "Unidad" bigint,
  "Cant_Sold" integer,
  "Cant_Dias" integer,
  "Val_Estancia" numeric(10,2),
  "Val_Total" numeric(10,2),
  "Val_Racion" numeric(10,2),
 */
public class Consolidado_AD {
    

    Conectar Con= new Conectar();
    Consolidado_EN Cons_LN= new Consolidado_EN();
    ResultSet Res=null;
   
    public Boolean Generar_Codigo_Consolidado( Consolidado_EN Cons_EN)
            {
                
                   

                String SqlInst ="INSERT INTO  \"Consolidado\" ( \"Fecha_Cons\",\"Unidad\",\"Estado_Cons\" ) VALUES ";
                SqlInst =SqlInst+ " ('"+Cons_EN.getFecha_Cons()+"','"+Cons_EN.getUnidad()+"','"+Cons_EN.getEstado_Cons()+"' )";

    try{
      return Con.Ejecutar_Actualizacion(SqlInst);
      }catch( Exception x ) { return false;}     
  
    }
    
 
 public ResultSet Buscar_Existencia_Codigo_Consolidado(Long Cod_Undad)
        {
 
    String Sql="Select \"Id_Consolidado\" from \"Consolidado\"\n" +
                "where \"Unidad\"='"+Cod_Undad+"' and \"Estado_Cons\"='Borrador';"; 
            System.out.println(Sql);
        try{
                Res =Con.Ejecutar_Consulta(Sql);
            }catch( Exception x ) {}
                return Res;
   
 
        }
 
 
    
    
    
    public ResultSet Listar_Consolidados_Avtivos(Integer Cod_Undad)
        {
           
            String Sql="Select \"Id_Consolidado\",\"fecha_Cons\",\"Unidad\",\"Cant_Sold\",\"Cant_Dias\",\"Val_Estancia\",\"Val_Total\",\"Val_Racion\",\"Estado_Cons\"     "
                       + " from \"Consolidado\" Where \"Id_Consolidado\"  ="+Cod_Undad+" and \"Estado_Cons\"='Activo' "; 
            System.out.println(Sql);
        try{
                Res =Con.Ejecutar_Consulta(Sql);
            }catch( Exception x ) {}
                return Res;

        } 
    /*
    
CREATE TABLE "Consolidado"
(
  "Id_Consolidado" serial NOT NULL,
  "Fecha_Cons" date,
  "Unidad" bigint,
  "Sold_Abast" integer,
  "Dias_Abast" integer,
  "Val_Estancia" numeric(10,2),
  "Val_Secos" numeric(10,2),
  "Val_Frescos" numeric(10,2),
  "Estado_Cons" character varying(20),
  "Dias_Ras" integer,
  "Sold_Rac" integer,
    
    */
    
     public Boolean Finalizar_Consolidados(Consolidado_EN Cons_EN)
            {
         
            String Sql=" UPDATE \"Consolidado\"  SET \"Estado_Cons\"  = 'Finalizado',\"Sold_Abast\" = '"+Cons_EN.getSold_Abast()+"',   "
                         + " \"Dias_Abast\"  = '"+Cons_EN.getDias_Abast()+"', \"Val_Estancia\" = '"+Cons_EN.getVal_Estancia()+"',\"Val_Secos\" = '"+Cons_EN.getVal_Secos()+"',    "
                         + " \"Val_Frescos\"  = '"+Cons_EN.getVal_Frescos()+"', \"Dias_Ras\"  = '"+Cons_EN.getDias_Ras()+"',  "
                         + " \"Sold_Rac\"  = '"+Cons_EN.Sold_Rac+"' "
                         + " where \"Id_Consolidado\" ='"+Cons_EN.getId_Consolidado()+"';"; 
                   try{
                     return Con.Ejecutar_Actualizacion(Sql);
            }catch( Exception x ) { return false;}   
                      
                      
                      
            }
    
    
    
    
    
    
    
    
    
}
