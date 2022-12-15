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
     * Metodo que determina los efectos que pueden emplear el personaje y los enemigos
     * @param efecto va dependiendo del tipo de enemigo y de la clase escogida por el usuario
     * @return la habilidad respectiva del personaje o el enemigo
     */
    int Efectos(int efecto);

    /**
     * Metodo que nos permite salirnos del sistema
     */
    void Salir();

}
