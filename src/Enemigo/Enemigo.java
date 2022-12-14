package Enemigo;

import java.util.ArrayList;
import java.util.List;

public class Enemigo  {
    private String Nombre;
    private String Descripcion;
    private int Nivel;
    private int Vida ;
    private int Ataque ;
    private int Defensa ;
    private int Velocidad;
    private int Experiencia;
    private String Estado;
    private String AtaqueEspecial;
    private String Tipo;

    public Enemigo(String nombre, String descripcion, int nivel, int vida, int ataque, int defensa, int velocidad, int experiencia, String estado, String AtaqueEspecial,String tipo) {
        Nombre = nombre;
        Descripcion = descripcion;
        Nivel = 1;
        Vida = 110;
        Ataque = 25;
        Defensa = 10;
        Velocidad = 25;
        Experiencia = 100;
        Estado = "Normal";
        Tipo = tipo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getNivel() {
        return Nivel;
    }

    public void setNivel(int nivel) {
        Nivel = nivel;
    }

    public int getVida() {
        return Vida;
    }

    public void setVida(int vida) {
        Vida = vida;
    }

    public int getAtaque() {
        return Ataque;
    }

    public void setAtaque(int ataque) {
        Ataque = ataque;
    }

    public int getDefensa() {
        return Defensa;
    }

    public void setDefensa(int defensa) {
        Defensa = defensa;
    }

    public int getVelocidad() {
        return Velocidad;
    }

    public void setVelocidad(int velocidad) {
        Velocidad = velocidad;
    }


    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getAtaqueEspecial() {
        return AtaqueEspecial;
    }

    public void setAtaqueEspecial(String ataqueEspecial) {
        AtaqueEspecial = ataqueEspecial;
    }

    public int getExperiencia() {
        return Experiencia;
    }

    public void setExperiencia(int experiencia) {
        Experiencia = experiencia;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }
}
