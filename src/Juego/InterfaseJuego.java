package Juego;

public interface InterfaseJuego {
    void Iniciar();
    void MenuPrincipal();
    void CreacionPersonaje();
    void FinalDungeons();
    void Inspeccionar();


    void Batalla(int enemigos);

    void VerPersonaje();


    int InteractuarNPC(boolean NPC);

    int AtacarPersonaje();
    int AtacarEnemigo();
    int AtaqueEspecialPersonaje();
    int AtaqueEspecialEnemigo();


    int Efectos(int efecto);

    int Defender();
    void Salir();

}
