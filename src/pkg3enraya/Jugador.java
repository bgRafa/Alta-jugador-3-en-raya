/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3enraya;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import utilidades67.personas.Persona;

/**
 *
 * @author Rafa
 */
public class Jugador implements Serializable{

    
    String nombre;
    int edad;
    String contrasenia;

    public Jugador(String nombre, int edad, String contrasenia) {
        this.nombre = nombre;
        this.edad = edad;
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int f_nacimiento) {
        this.edad = f_nacimiento;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.nombre);
        hash = 83 * hash + Objects.hashCode(this.edad);
        hash = 83 * hash + Objects.hashCode(this.contrasenia);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jugador other = (Jugador) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.contrasenia, other.contrasenia)) {
            return false;
        }
        if (!Objects.equals(this.edad, other.edad)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Jugador-->   "+"Nombre: "+ nombre +"\t"+"Edad: " + edad;
    }
    
   
    
    
    
    
    
}
