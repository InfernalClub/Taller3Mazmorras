package Juego;

import java.io.IOException;
/**
 * Clase que representa el sistema
 */
public class Main {
    /**
     * Metodo que ejecuta el programa
     * @param args argumentos de la linea de comandos
     * @throws IOException Si no se puede leer el archivo
     */
    public static void main(String[] args) throws IOException {
        InterfaseJuegoImpl interfaseJuego = new InterfaseJuegoImpl();
        interfaseJuego.Iniciar();

    }
}