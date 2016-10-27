/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Abastecimiento;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Logica_Negocio.Consolidado_LN;
import Entidad_Negocio.Consolidado_EN;
import Logica_Negocio.Consolidado_Planilla_LN;
import Logica_Negocio.Planilla_LN;
import Logica_Negocio.Planilla_Soldado_LN;
import Logica_Negocio.Planilla_LN;
import Entidad_Negocio.Consolidado_Planilla_EN;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author WILSON
 */
public class Consolidado extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        
  
    
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        
         response.setContentType("text/html;charset=UTF-8");
     
          PrintWriter out = response.getWriter();
          
          
          
            if (request.getParameter("Finalizar_Consolidado") != null)
                {

                    
                    /*
                       Cod_Cons : Cod_Cons,
                          Dias_Abas : Dias_Abast,
                          Sold_Abas  : Sold_Abast,
                          Estan  : Estancia,
                          Sec :  Secos,
                          Fresc : Frescos,
                          Dias_Ra : Dias_Rac,
                          Sold_Rac : Sold_Raci
        
                    */
                    
                   
                   Consolidado_LN Cons_LN = new Consolidado_LN();
                   Consolidado_EN Cons_EN= new Consolidado_EN();
                   
                   Cons_EN.setId_Consolidado( Integer.parseInt(request.getParameter ("Cod_Cons")) );
                   Cons_EN.setDias_Abast(Integer.parseInt(request.getParameter ("Dias_Abas")));
                   Cons_EN.setSold_Abast(Integer.parseInt(request.getParameter ("Sold_Abas")));
                   Cons_EN.setVal_Estancia(Float.parseFloat(request.getParameter ("Estan")));
                   Cons_EN.setVal_Secos(Float.parseFloat(request.getParameter ("Sec")));
                   Cons_EN.setVal_Frescos(Float.parseFloat(request.getParameter ("Fresc")));
                   Cons_EN.setDias_Ras(Integer.parseInt(request.getParameter ("Dias_Ra")));
                   Cons_EN.setSold_Rac(Integer.parseInt(request.getParameter ("Sold_Rac")));
                   
                    
                    
           
                    if(Cons_LN.Finalizar_Consolidados(Cons_EN))
                    
                    {
                     out.println("CONSOLIDADO Nº. :"+Cons_EN.getId_Consolidado()+" FINALIZADO" );
                    
                    }
                    else{out.println("NO SE FINALIZO EL CONSOLIDADO" );}
                    
                    
                }
          
          
          
          
          
          
          
           if (request.getParameter("Eliminar_Planilla_Consolidado") != null)
                {

                    Planilla_LN Plan_LN = new Planilla_LN();
                    Consolidado_Planilla_LN Cons_Plan_LN = new Consolidado_Planilla_LN(); 
                     Integer Cod_Consolidado = Integer.parseInt(request.getParameter ("Id_Consolidado"));
                    Integer Id_Planilla = Integer.parseInt(request.getParameter ("Id_Planilla"));
           
                    if(Cons_Plan_LN.Eliminar_Planilla_Consolidado(Id_Planilla,Cod_Consolidado))
                    
                    {
                     Plan_LN.Actualizar_Estado_Planilla(Id_Planilla,"Finalizado");
                    
                    }
                }
          
          
      
          
         if (request.getParameter("Listar_Planillas_Consolidadas") != null)
         {

              ResultSet Rs =null;
             
              
           Integer Cod_Consolidado = Integer.parseInt(request.getParameter("Cod_Consolidado"));
            
            
             Consolidado_Planilla_LN Cons_Plan_LN = new Consolidado_Planilla_LN();
             
        
                out.println("<center><table border='0'>"); 
               
                out.println("<tbody>");
                out.println("<tr width=\'250\'>");
                out.println("<td align=\'center\' bgcolor='#F2F2F2'><b>MODALIDAD</b></td>");
                out.println("<td align=\'center\' bgcolor='#F2F2F2'><b>DIAS</b></td>");
                out.println("<td align=\'center\' bgcolor='#F2F2F2'><b>SL</b></td>"); 
                out.println("<td align=\'center\' bgcolor='#F2F2F2'><b>ESTANCIA</b></td>");
                out.println("<td align=\'center\' bgcolor='#F2F2F2'><b>SECOS</b></td>");
                out.println("<td align=\'center\' bgcolor='#F2F2F2'><b>FRESCOS</b></td>");
        
               
                out.println("<td align='center' bgcolor='#F2F2F2'><b>Eliminar</b></td> ");    
                Integer Dias_Abast=0;
                Integer Dias_Rac=0;
                Integer Sold_Abast=0;
                Integer Sold_Raci=0;
                float Estancia=0;
                float Secos =0;
                float Frescos =0;
              
                
               
           try{
            
               
                Rs = Cons_Plan_LN.Listar_Planillas_Consolidadas(Cod_Consolidado);
                
                while(Rs.next()) {
                 if (Rs.getString("Tipo_Ciclo").equals("Abastecimiento")){
                    
                 Dias_Abast= Dias_Abast + Integer.parseInt(Rs.getString("Dias_Abas"));
                 Sold_Abast = Sold_Abast + Integer.parseInt(Rs.getString("Sl_Abas"));
                 Estancia = Float.parseFloat(Rs.getString("Val_Estancia"));
                 Secos = Secos + Float.parseFloat(Rs.getString("Secos"));
                 Frescos = Frescos + Float.parseFloat(Rs.getString("Frescos"));
                
                 out.println("<tr><td align='center'>"+Rs.getString("Tipo_Ciclo")+ "</td>");
                 out.println("<td align='center'>"+Rs.getString("Dias_Abas")+"</td>"); 
                 out.println("<td align='center'>"+Rs.getString("Sl_Abas")+"</td>");
                 out.println("<td align='center'>"+Rs.getString("Val_Estancia")+ "</td>");
                 out.println("<td align='center'>"+Rs.getString("Secos")+"</td>");
                 out.println("<td align='center'>"+Rs.getString("Frescos")+"</td>");
                 out.println("<td align='center' ><A href='javascript:Eliminar_Planilla_Consolidado(" + Rs.getString("Planilla") + ","+Rs.getString("Consolidado")+")'><img src='../../Iconos/eliminar.png'  /> </A></td>");
              
                 }
      
                   if (Rs.getString("Tipo_Ciclo").equals("Raciones")){
                       
                       Dias_Rac= Dias_Rac+Integer.parseInt(Rs.getString("Dias_Rac"));
                       Sold_Raci= Sold_Raci+Integer.parseInt(Rs.getString("Sl_Rac"));
                      
                  out.println("<tr><td align='center'>"+Rs.getString("Tipo_Ciclo")+ "</td>");
                  out.println("<td align='center'>"+Rs.getString("Dias_Abas")+"</td>"); 
                  out.println("<td align='center'>"+Rs.getString("Sl_Abas")+"</td>");
                  out.println("<td align='center'>"+Rs.getString("Val_Estancia")+ "</td>");
                  out.println("<td></td><td></td>");
                  out.println("<td align='center'><A href='javascript:Eliminar_Planilla_Consolidado(" + Rs.getString("Planilla") + ","+Rs.getString("Consolidado")+")'><img src='../../Iconos/eliminar.png'  /> </A></td>");

                 }
             
         //Dias_Abast, Sold_Abast,Estancia, Secos, Frescos, Dias_Rac, Sold_Raci
            }
                   
                 out.println("<tr><td>TOTALES ABASTECIMIENTO</td><td><input type='text' style='text-align:center;' id='Dias_Abast' value='"+Dias_Abast+"'  name='Secos' size='10' readonly></td>"
                         + " <td><input type='text' style='text-align:right;' id='Sold_Abast' value='"+Sold_Abast+"'  name='Secos' size='10' readonly></td>"
                         + "<td><input type='text' style='text-align:right;' id='Estancia' value='"+Estancia+"'  name='Secos' size='10' readonly></td>"
                         + "<td><input type='text' style='text-align:right;' id='Secos' value='"+Secos+"'  name='Secos' size='10' readonly></td>"
                         + "<td><input type='text' style='text-align:right;' id='Frescos' value='"+Frescos+"'  name='Secos' size='10' readonly></td>");  
               
                   
                 out.println("<tr><td>TOTALES RACIONES</td><td><input type='text' style='text-align:right;' id='Dias_Rac' value='"+Dias_Rac+"'  name='Secos' size='10' readonly></td>"
                         + " <td><input type='text' style='text-align:right;' id='Sold_Raci' value='"+Sold_Raci+"'  name='Secos' size='10' readonly></td>" );
                       
               
            }catch(Exception ex ){ out.println(ex.getMessage());}
            


            out.println("  </table></center>");
            

        }


          
         
         
         
         
         
         
         
         
         
          
          if(request.getParameter ("Agregar_Planilla_Consolidado") !=null )
                {
             
                   try{
                    Consolidado_Planilla_LN Cons_Plan_LN = new Consolidado_Planilla_LN();
                    Consolidado_Planilla_EN Cons_Plan_EN = new Consolidado_Planilla_EN();
                    Planilla_LN Plan_LN = new Planilla_LN();
                    
                    Integer Cod_Consolidado = Integer.parseInt(request.getParameter ("Cod_Consolidado"));
                    Integer Id_Planilla = Integer.parseInt(request.getParameter ("Cod_Planilla"));
                    
                    Cons_Plan_EN.setConsolidado(Cod_Consolidado);
                     Cons_Plan_EN.setPlanilla(Id_Planilla);
                     
                    if(Cons_Plan_LN.Registrar_Planilla_Consolidado(Cons_Plan_EN))
                    {
                        Plan_LN.Actualizar_Estado_Planilla(Id_Planilla,"Consolidado");
                        
                        
                        out.println("Planilla Registrada");
                        
                    }
                    else{    out.println("No se registro");}
                    
                    
                    
                    
                    
                    
                   }catch(Exception e){}
                    
             
                }
          
          
          
               if (request.getParameter("Listar_Planillas_Abastecimmiento_Finalizadas") != null) {

            Planilla_LN Plan_LN = new Planilla_LN();

            Integer Unidad = Integer.parseInt(request.getParameter("Cod_Unidad"));

            try {
                ResultSet Res = Plan_LN.Listar_Planillas_Abastecimmiento_Finalizada(Unidad);

                out.println("'<div class='container'><div class='row'><hr><div class='col-md-10 col-md-offset-1'><div class='panel panel-default panel-info'><div class='panel-heading'><h4><center>BANDEJA DE ENTRADA: PLANILLA(S) FINALIZADA(S)</center></h4></div><table class='table table-hover table-bordered table-condensed >'<tr><td><center><STRONG>ID</STRONG></center></td><td><center><STRONG>FECHA</STRONG></center></td><td><center><STRONG>COMPAÑIA</STRONG></center></td><td><center><STRONG>CARGO AL MES</STRONG></center></td><td><center><STRONG>ESTADO</STRONG></center></td><td align='center'><STRONG>AGREGAR</STRONG></td></tr></div></div></div></div></div>");

                int j = 0;

                while (Res.next()) {
                    j++;
                    out.println("<tr><td>"
                            + j + "</td><td align='center'>" + Res.getString("Fecha_Reg")
                            + "</td><td align='center'>" + Res.getString("Nomb_Comp") + "</td>"
                            + "<td align='center'>" + Res.getString("Mes_Per") + " " + Res.getString("Anio_Per") + "</td>" + "</td>"
                            + "<td align='center'>" + Res.getString("Estado_Plan") + "</td>" + "</td>"
                            + "<td align='center'> <A href=\"javascript:Agregar_Planilla_Consolidado('" + Res.getString("Id_Planilla") + "');\"><center><img  src='../../Iconos/mas.png'  width='25' height='25'  /></td> ");

                }

                out.println("</td></tr></table></center>");

            } catch (Exception e) {
                out.println("error");
            }

        }


      
          
          if(request.getParameter ("Buscar_Existencia_Codigo_Consolidado") !=null )
                {   
                       Consolidado_LN Cons_LN = new Consolidado_LN();
                       long cod_Unidad = Long.parseLong(request.getParameter ("Cod_Unidad"));
                       
                       try{
                       ResultSet Res1=  Cons_LN.Buscar_Existencia_Codigo_Consolidado(cod_Unidad);;
                                 while(Res1.next()){
                                                   out.println(Res1.getString("Id_Consolidado"));
                                                   }
                       }catch(Exception e){}
                    
                }
          
          
          if(request.getParameter ("Generar_Codigo_Consolidado") !=null )
                {
                         Consolidado_LN Cons_LN = new Consolidado_LN();
                         Consolidado_EN Cons_EN = new Consolidado_EN();
                    try{
                        long cod_Unidad = Long.parseLong(request.getParameter ("Cod_Unidad"));
                         Date fechaActual = new Date();
                         DateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
                         
                         
                        Cons_EN.setUnidad(cod_Unidad);
                        Cons_EN.setEstado_Cons("Borrador");
                        Cons_EN.setFecha_Cons(formatoFecha.format(fechaActual).toString());
                        
                        if(Cons_LN.Generar_Codigo_Consolidado(Cons_EN))
                        
                                {  out.println("CODIGO GENERADO"); 

                                
                                }
                        else{ out.println("NO SE GENERO EL CODIGO");}
            
                    }catch(Exception e){}
                
         
                } 
          
          
  
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
