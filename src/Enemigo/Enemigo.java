package Enemigo;
/**
 * Clase que representa al enemigo
 */
public class Enemigo  {
    /**
     * Nombre del enemigo
     */
    private String Nombre;
    /**
     * Descripcion del enemigo
     */
    private String Descripcion;
    /**
     * Nivel del enemigo
     */
    private int Nivel;
    /**
     * Vida del enemigo
     */
    private int Vida ;
    /**
     * Ataque del enemigo
     */
    private int Ataque ;
    /**
     * Defensa del enemigo
     */
    private int Defensa ;
    /**
     * Velocidad del enemigo
     */
    private int Velocidad;
    /**
     * Experiencia del enemigo
     */
    private int Experiencia;
    /**
     * Estado del enemigo
     */
    private String Estado;
    /**
     * AtaqueEspecial del enemigo
     */
    private String AtaqueEspecial;
    /**
     * Tipo de enemigo
     */
    private String Tipo;

    /**
     *
     * @param nombre del enemigo
     * @param descripcion del enemigo
     * @param nivel del enemigo
     * @param vida del enemigo
     * @param ataque del enemigo
     * @param defensa del enemigo
     * @param velocidad del enemigo
     * @param experiencia del enemigo
     * @param estado del enemigo
     * @param AtaqueEspecial del enemigo
     * @param tipo de enemigo
     */
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
