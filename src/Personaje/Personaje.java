package Personaje;
/**
 * Clase que representa a nuestro personaje
 */
public class Personaje {
    /**
     * Nombre del personaje
     */
    private String Nombre;
    /**
     * Descripcion del personaje
     */
    private String Descripcion;
    /**
     * Nivel del personaje
     */
    private int Nivel;
    /**
     * Vida del personaje
     */
    private int Vida;
    /**
     * Ataque del personaje
     */
    private int Ataque;
    /**
     * Defensa del personaje
     */
    private int Defensa;
    /**
     * Velocidad del personaje
     */
    private int Velocidad;
    /**
     * Experiencia del personaje
     */
    private int Experiencia;
    /**
     * Estado del personaje
     */
    private String Estado;
    /**
     * Ataque Especial del personaje
     */
    private String AtaqueEspecial;

    /**
     *
     * @param nombre del personaje
     * @param descripcion del personaje
     * @param nivel del personaje
     * @param vida del personaje
     * @param ataque del personaje
     * @param defensa del personaje
     * @param velocidad del personaje
     * @param experiencia del personaje
     * @param estado del personaje
     * @param ataqueEspecial del personaje
     */
    public Personaje(String nombre, String descripcion, int nivel, int vida, int ataque, int defensa, int velocidad, int experiencia, String estado, String ataqueEspecial) {
        Nombre = nombre;
        Descripcion = descripcion;
        Nivel = nivel;
        Vida = 100;
        Ataque = 40;
        Defensa = 21;
        Velocidad = 30;
        Experiencia = 0;
        Estado = estado;
        AtaqueEspecial = ataqueEspecial;
    }

    // Getters y Setters
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

    public int setVida(int vida) {
        Vida = vida;
        return vida;
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
