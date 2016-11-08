/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comida_Caliente;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Logica_Negocio.Planilla_LN;

import Entidad_Negocio.Planilla_EN;
import Entidad_Negocio.Soldado_EN;
import Logica_Negocio.Comedor_LN;
import Logica_Negocio.Planilla_Soldado_LN;
import Logica_Negocio.Soldado_LN;
import com.google.gson.Gson;
import java.sql.ResultSet;



/**
 *
 * @author WILSON
 */
public class Comida_Caliente extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
       
        
        
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
       // response.setContentType("application/json;charset=UTF-8");
         response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
           if(request.getParameter ("Listar_Comedores_Centralizadora") !=null )
              {
                    Comedor_LN Comed_LN=  new Comedor_LN();
                   
                     Integer Id_Centraliz= Integer.parseInt(request.getParameter ("Id_Centraliz"));
                   
                    
                         Gson gson= new Gson();
                          PrintWriter pw=response.getWriter();
                          pw.println(gson.toJson( Comed_LN.Listar_Comedores_Centralizadora(Id_Centraliz) ));
                          pw.close();  
                  
                  
                  
              }
        
        
        
        
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
        
        //
        
         response.setContentType("text/html;charset=UTF-8");
     
          PrintWriter out = response.getWriter();
          
          
          
          
          
          
          if(request.getParameter ("Lista_Solados_Planilla") !=null )
              {
                  
                              
          out.println("<table  class='table table-bordered' style='font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif' align='top' bgcolor='#F4F4F4'>");
          out.println("<thead><td colspan='7' align='center'><b>LISTA DE SOLDADOS ASIGNADOS A LA PLANILLA</b></td>");
          out.println("</thead>");
          out.println("<tr>");
          out.println("<td align='center'><b>Nº</b></td>");
          out.println("<td align='center'><b>Grado</b></td>");
          out.println("<td align='center'><b>Apellidos Nombres</b></td>");
          out.println("<td align='center'><b>Identificación</b></td>");
          out.println("<td align='center'><b>#.Dias</b>");
          out.println("<td align='center'><b>Fecha Inicio</b></td>");
        
          out.println("</tr>");
           out.println("<tr>");
                          

          try{   
         Integer Cod_Planilla= Integer.parseInt(request.getParameter ("Cod_Planilla"));
              
              
           Planilla_Soldado_LN  Plan_Sold_LN= new Planilla_Soldado_LN();
            ResultSet Res3= Plan_Sold_LN.Listar_Soldados_Planilla(Cod_Planilla);
            int j=0;
            while(Res3.next()){
            j++;
            out.println("<tr><td align='center'>"+j+"</td>"
                    + "<td align='center'>"+Res3.getString("Grado")+"</td>"
                    + "<td align='center'>"+Res3.getString("Apellidos")+" "+Res3.getString("Nombres")+"</td>"
                    + "<td align='center'>"+Res3.getString("Ident_Sold")+"</td>"
                    + "<td align='center'>"+Res3.getString("Numb_Dias")+"</td>"
                    + "<td align='center'>"+Res3.getString("Fech_Inicio")+"</td> <td align='center'>"
                          
                        + "<A href=\"javascript:Retirar_Soldado_Planilla('"+Res3.getString("Id_Ciclo")+"','"+Res3.getString("Ident_Sold")+"');\"><img src='../../Iconos/eliminar.png'/> </A>");
                                              
            }
          }catch(Exception e){}

                out.println("</tr>"); 
                out.println("</table>");
         
              }
          
          
          
          
          if(request.getParameter ("Btn_Finalizar_Plan_Cte") !=null )
              {
                  
                Integer Cod_Plan= Integer.parseInt(request.getParameter ("Cod_Planilla"));
                  
                   Planilla_LN Plan_LN= new  Planilla_LN();
              if( Plan_LN.Actualizar_Estado_Planilla(Cod_Plan,"Finalizado"))
              {
                 out.println("PLANILLA FINALIZADA");
                }else{out.println("NO SE FINALIZO LA PLANILLA");}
        
                  
                  
              }
            
                  
                  
                  
          
 if(request.getParameter ("Retirar_Soldado") !=null )
              {
            
               
        
              Planilla_Soldado_LN  Plan_Sold_LN= new Planilla_Soldado_LN();
              if(Plan_Sold_LN.Desvincular_Soldados_Planilla(Integer.parseInt(request.getParameter ("ident_Soldado")),Integer.parseInt(request.getParameter ("Ciclo")) ))
                {
                 out.println("SOLDADO RETIRADO DE  LA PLANILLA");
                }else{out.println("NO SE RETIRO EL SOLDADO DE LA PLANILLA");}
        
              
              
              
              }

          
          
          
                   
          
          
          
          
           if(request.getParameter ("Agregar_Soldado_Plan") !=null )
                        {

                            try{
                            Planilla_Soldado_LN Plan_Sold_LN= new Planilla_Soldado_LN();
                            Integer  ident_Sold= Integer.parseInt(request.getParameter("ident_Soldado").toString());
                            Integer  Ciclo= Integer.parseInt(request.getParameter("Ciclo").toString());
                            Integer  comedor= Integer.parseInt(request.getParameter("comedor").toString());
                            
                           if(Plan_Sold_LN.Registrar_Soldados__Comedor_Planilla(ident_Sold,Ciclo,comedor))
                                {
                                  out.println("SOLDADO ASIGNADO A LA PLANILLA");
                                }
                           else{ out.println("NO SE ASIGNO SOLDADO A LA PLANILLA");}
                            }catch(Exception e){ out.println("SELECCIONE UN CICLO");}
   
                          
                    }
          
          
          
          
          
          
          
          
        if(request.getParameter ("Btn_Crear_Plan_Cte") !=null )
                {  
                 
                    Planilla_LN Plan_LN = new Planilla_LN();
                    Planilla_EN Plan_EN = new Planilla_EN(); 
  
                    try{
                   
                    Plan_EN.setEstado_Plan("Borrador");
                    Plan_EN.setFecha_Reg(request.getParameter("fecha_Planilla"));
                    Plan_EN.setUnidad(Integer.parseInt(request.getParameter("Cod_Unidad")));
                    Integer Id_Centralizador=  Integer.parseInt(request.getParameter("Id_Centraliz"));
                    Plan_EN.setPeriodo(Integer.parseInt(request.getParameter("Periodo")));

                     String RespBd[]=Plan_LN.Crear_Planilla_Comida_Caliente(Plan_EN,Id_Centralizador );
     
                        if( Integer.parseInt(RespBd[1])==1)
                            {
                                out.println(RespBd[4]+"&"+RespBd[5]+"&"+RespBd[6]+"&"+RespBd[7] );
                            }else{out.println("NO SE REGISTRO LA PLANILLA :" + RespBd[4]);
                                }
 
                    }
                   catch(Exception e){}
                    
                                                     
                   
                }
                   
        
                if (request.getParameter("Lista_Solados_Activos") != null) {

            out.println("<br><br><table class='table table-bordered' style='font-family:Gotham, 'Helvetica Neue', Helvetica, Arial, sans-serif' align='top' bgcolor='#F4F4F4'>");

            out.println("<tr>");
            out.println("<td colspan='4'><center> <b>LISTA DE SOLDADOS DE LA UNIDAD</b> </td>  </tr>");
            out.println("<tr>");

            out.println("<td align='center'><b>Nº</b></td>");
            out.println("<td><center><b>Grado</b></center></td>");
            out.println("<td><center><b>Apellidos Nombres</b></center></td>");
            out.println("<td><center><b>Identificación</b></center></td> ");
            out.println(" <td><center><b>[_]</b></center></td>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            out.println("<tr>");

            // Cod_Unidad : Cod_Unidad,
            //        id_planilla : id_planilla,
            try {
                Soldado_EN Sold_EN = new Soldado_EN();
                Soldado_LN Sold_LN = new Soldado_LN();
                ResultSet Res3 = Sold_LN.Listar_Soldados_Unidad(Long.parseLong(request.getParameter("Cod_Unidad")), Integer.parseInt(request.getParameter("id_planilla")));
                int j = 0;
                while (Res3.next()) {
                    j++;
                    out.println("<tr><td>" + j + "</td><td>" + Res3.getString("Grado") + "</td><td>" + Res3.getString("Apellidos") + " " + Res3.getString("Nombres") + "<td>" + Res3.getString("Ident_Sold") + "<td>"
                            + "<A href=\"javascript:Agregar_Soldado_Planilla('" + Res3.getString("Ident_Sold") + "');\"><img src='../../Iconos/mas.png' width='25' height='25'  /> </A>"
                            + "</td> ");
                }
            } catch (Exception e) {
            }

            out.println("</tr>");
            out.println("</tbody>");
            out.println("</table>");

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
