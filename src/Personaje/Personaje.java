package Personaje;

public class Personaje {
    private String Nombre;
    private String Descripcion;
    private int Nivel;
    private int Vida;
    private int Ataque;
    private int Defensa;
    private int Velocidad;
    private int Experiencia;
    private String Estado;
    private String AtaqueEspecial;

    public Personaje(String nombre, String descripcion, int nivel, int vida, int ataque, int defensa, int velocidad, int experiencia, String estado, String AtaqueEspecial) {
        Nombre = nombre;
        Descripcion = descripcion;
        Nivel = nivel;
        Vida = 100;
        Ataque = 40;
        Defensa = 21;
        Velocidad = 30;
        Experiencia = 0;
        Estado = estado;
        AtaqueEspecial = AtaqueEspecial;
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

    public int getExperiencia() {
        return Experiencia;
    }

    public void setExperiencia(int experiencia) {
        Experiencia = experiencia;
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
}
