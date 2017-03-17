package com.example.irving.retrofitclientes.servicios;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Irving on 17/03/2017.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class EmpleadosResponse
{

    @Override
    public String toString() {
        return "EmpleadosResponse{" +
                "apellido='" + apellido + '\'' +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", sexo=" + sexo +
                ", sueldo='" + sueldo +"$" + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", fechaRegistro='" + fechaRegistro + '\'' +
                ", nombreProfesion='" + nombreProfesion + '\'' +
                '}';
    }

    @SerializedName("id")
        @Expose
        private int id;
        @SerializedName("Nombre")
        @Expose
        private String nombre;
        @SerializedName("Correo")
        @Expose
        private String correo;
        @SerializedName("Apellido")
        @Expose
        private String apellido;
        @SerializedName("Sexo")
        @Expose
        private int sexo;
        @SerializedName("Sueldo")
        @Expose
        private String sueldo;
        @SerializedName("FechaNacimiento")
        @Expose
        private String fechaNacimiento;
        @SerializedName("FechaRegistro")
        @Expose
        private String fechaRegistro;
        @SerializedName("Nombre_profesion")
        @Expose
        private String nombreProfesion;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public int getSexo() {
            return sexo;
        }

        public void setSexo(int sexo) {
            this.sexo = sexo;
        }

        public String getSueldo() {
            return sueldo;
        }

        public void setSueldo(String sueldo) {
            this.sueldo = sueldo;
        }

        public String getFechaNacimiento() {
            return fechaNacimiento;
        }

        public void setFechaNacimiento(String fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
        }

        public String getFechaRegistro() {
            return fechaRegistro;
        }

        public void setFechaRegistro(String fechaRegistro) {
            this.fechaRegistro = fechaRegistro;
        }

        public String getNombreProfesion() {
            return nombreProfesion;
        }

        public void setNombreProfesion(String nombreProfesion) {
            this.nombreProfesion = nombreProfesion;
        }

    }


