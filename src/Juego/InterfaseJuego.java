package Juego;

import java.io.IOException;

public interface InterfaseJuego {
    /**
     * Carga los datos de los archivos de texto e inicia el sistema
     * @throws Exception si no se puede cargar los datos
     */
    void Iniciar() throws IOException;
    /**
     * Menu principal del sistema
     */
    void MenuPrincipal();
    /**
     * Menu donde se crea nuestro personaje
     */
    void CreacionPersonaje();
    /**
     * Menu donde comienza el juego
     */
    void FinalDungeons();
    /**
     * Menu que nos permite observar la mazmorra
     */
    int Inspeccionar();
    /**
     * Menu de batalla donde transcurre el combate entre los enemigos y el personaje
     */
    void Batalla(int enemigos); // enemigos es la cantidad que nos introduce el sistema al azar
    /**
     * Menu que nos permite observar las caracteristicas de nuestro personaje
     */
    void VerPersonaje();
    /**
     * Metodo del sistema que verifica si el NPC esta vivo o muerto
     */
    void InteractuarNPC(boolean NPC); // NPC es la caracteristica que determina en base al azar si nuestro NPC esta vivo o no
    /**
     * AtacarPersonaje es un metodo de nuestro personaje que permite quitar puntos de la vida de un enemigo
     */
    void AtacarPersonaje();
    /**
     * AtacarEnemigo es un metodo del enemigo que le permite quitar puntos de vida al personaje
     */
    int AtacarEnemigo();

    /**
     * AtaqueEspecialEnemigo es un metodo que le permite al enemigo ocupar su habilidad especial
     */

    void AtaqueEspecialEnemigo(int pos);

    /**
     * Efectos es un metodo que guarda los multiples efectos de los enemigos y de los personajes
     */
    int Efectos(int efecto);

    /**
     * Metodo que nos permite salirnos del sistema
     */
    void Salir();

}
