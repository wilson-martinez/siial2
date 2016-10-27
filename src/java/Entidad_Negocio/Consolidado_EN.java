/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad_Negocio;

import java.util.Date;

/**
CREATE TABLE "Consolidado"
(
  Id_Consolidado" serial NOT NULL,
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
public class Consolidado_EN {
    
   public  Integer Id_Consolidado;
   public  String  Fecha_Cons;
   public  Long Unidad;
   public  Integer Sold_Abast;
   public  Integer Dias_Abast;
   public  Number Val_Estancia;
   public  Number Val_Secos;
   public  Number Val_Frescos;
   public  String  Estado_Cons;
   public  Integer Dias_Ras;
   public  Integer Sold_Rac;
   
  

    public void setId_Consolidado(Integer Id_Consolidado) {
        this.Id_Consolidado = Id_Consolidado;
    }

    public void setFecha_Cons(String Fecha_Cons) {
        this.Fecha_Cons = Fecha_Cons;
    }

    public void setUnidad(Long Unidad) {
        this.Unidad = Unidad;
    }

    public void setSold_Abast(Integer Sold_Abast) {
        this.Sold_Abast = Sold_Abast;
    }

    public void setDias_Abast(Integer Dias_Abast) {
        this.Dias_Abast = Dias_Abast;
    }

    public void setVal_Estancia(Number Val_Estancia) {
        this.Val_Estancia = Val_Estancia;
    }

    public void setVal_Secos(Number Val_Secos) {
        this.Val_Secos = Val_Secos;
    }

    public void setVal_Frescos(Number Val_Frescos) {
        this.Val_Frescos = Val_Frescos;
    }

    public void setEstado_Cons(String Estado_Cons) {
        this.Estado_Cons = Estado_Cons;
    }

    public void setDias_Ras(Integer Dias_Ras) {
        this.Dias_Ras = Dias_Ras;
    }

    public void setSold_Rac(Integer Sold_Rac) {
        this.Sold_Rac = Sold_Rac;
    }

    public Integer getId_Consolidado() {
        return Id_Consolidado;
    }

    public String getFecha_Cons() {
        return Fecha_Cons;
    }

    public Long getUnidad() {
        return Unidad;
    }

    public Integer getSold_Abast() {
        return Sold_Abast;
    }

    public Integer getDias_Abast() {
        return Dias_Abast;
    }

    public Number getVal_Estancia() {
        return Val_Estancia;
    }

    public Number getVal_Secos() {
        return Val_Secos;
    }

    public Number getVal_Frescos() {
        return Val_Frescos;
    }

    public String getEstado_Cons() {
        return Estado_Cons;
    }

    public Integer getDias_Ras() {
        return Dias_Ras;
    }

    public Integer getSold_Rac() {
        return Sold_Rac;
    }

    public Consolidado_EN() {
    }

    
 
    
    
}
