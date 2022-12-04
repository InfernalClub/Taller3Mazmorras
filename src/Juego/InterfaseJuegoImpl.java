package Juego;

import Enemigo.Enemigo;
import Personaje.Personaje;
import ucn.StdIn;
import ucn.StdOut;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class InterfaseJuegoImpl implements InterfaseJuego {

    Personaje nuevoPersonaje;
    Enemigo enemigo;

    @Override
    public void Iniciar() {

    }

    @Override
    public void MenuPrincipal() {
        StdOut.println("----->ZENKAI GAMES PRESENTA<-----");
        StdOut.println("");
        StdOut.println("FINAL DUNGEONS");
        StdOut.println("");
        StdOut.println("[1] INICIAR JUEGO");
        StdOut.println("[2] SALIR");

        try
        {
            String opcion = StdIn.readLine();
            int decision;
            if (isNumeric(opcion)) Integer.parseInt(opcion);
            decision = Integer.parseInt(opcion);
            switch (decision)
            {
                case 1:
                    CreacionPersonaje();
                    break;

                case 2:
                    StdOut.println("Se cierra el programa");
                    StdOut.println("Gracias por jugar");
                    Salir();
                    break;

                default:
                    StdOut.println("Ingrese una opcion de la lista: ");
                    MenuPrincipal();


            }

        }
        catch (Exception e) {
            StdOut.println("Ingrese una opción válida.");
            MenuPrincipal();
        }
    }

    @Override
    public void CreacionPersonaje() {
        StdOut.println("----->FINAL DUNGEONS<-----");
        StdOut.println("");
        StdOut.println("[*] CREACION DE PERSONAJE [*]");
        StdOut.println("");
        StdOut.println("INGRESE UN NOMBRE: ");
        String nombrePersonaje = StdIn.readString();

        StdOut.println("----->FINAL DUNGEONS<-----");
        StdOut.println("");
        StdOut.println("[*] CREACION DE PERSONAJE [*]");
        StdOut.println("");
        StdOut.println("INGRESE UNA DESCRIPCION: ");
        String descripcionPersonaje = StdIn.readString();

        StdOut.println("----->FINAL DUNGEONS<-----");
        StdOut.println("");
        StdOut.println("[*] CREACION DE PERSONAJE [*]");
        StdOut.println("");
        StdOut.println(" ESCOJA UNA CLASE: ");
        StdOut.println("GUERRERO");
        StdOut.println("ARQUERO");
        StdOut.println("MAGO");
        try
        {
            String opcion = StdIn.readLine();
            int decision;
            if (isNumeric(opcion)) Integer.parseInt(opcion);
            decision = Integer.parseInt(opcion);
            switch (decision)
            {
                case 1:
                    // nuevoPersonaje = new Personaje(nombrePersonaje,descripcionPersonaje,1,100,20,10,17,0,true,"Ataque Doble");
                    break;

                case 2:
                    // nuevoPersonaje = new Personaje(nombrePersonaje,descripcionPersonaje,1,100,20,10,17,0,true,"Ataque Rapido");
                    break;

                case 3:
                    // nuevoPersonaje = new Personaje(nombrePersonaje,descripcionPersonaje,1,100,20,10,17,0,true,"Regeneracion");
                    break;
                default:
                    StdOut.println("Ingrese una opcion de la lista: ");
                    MenuPrincipal();


            }

        }
        catch (Exception e) {
            StdOut.println("Ingrese una opción válida.");
            MenuPrincipal();
        }



    }

    @Override
    public void FinalDungeons() {
        boolean corriendo = true;

        while (corriendo) {
            StdOut.println("------------->FINAL DUNGEONS<-------------");
            StdOut.println("[!] Te encuentras en la mazmorra N°" + " [!]");
            StdOut.println("");
            StdOut.println("[1] Inspeccionar");
            StdOut.println("[2] Ver Personaje");
            StdOut.println("[3] Siguiente Mazmorra");
            StdOut.println("[4] Anterior Mazmorra");
            StdOut.println("[5] Salir");
            StdOut.println("");
            StdOut.println("------------------------------------------");

            try {
                String opcion = StdIn.readLine();
                int decision;
                if (isNumeric(opcion)) Integer.parseInt(opcion);
                decision = Integer.parseInt(opcion);
                switch (decision) {
                    case 1:
                        Inspeccionar();
                        break;

                    case 2:
                        VerPersonaje();
                        break;

                    case 3:
                        //();
                        break;
                    case 4:
                        //();
                        break;
                    case 5:
                        Salir();
                        break;
                    default:
                        StdOut.println("Ingrese una opcion de la lista: ");
                        MenuPrincipal();


                }

            } catch (Exception e) {
                StdOut.println("Ingrese una opción válida.");
                MenuPrincipal();


            }
        }
    }

    @Override
    public void Inspeccionar() {

    }

    @Override
    public void Batalla() {

    }

    @Override
    public void VerPersonaje() {
        StdOut.println("-------------->FINAL DUNGEONS<--------------");
        StdOut.println("[*] Perfil de "+nuevoPersonaje.getNombre()+" [*]");
        StdOut.println("");
        StdOut.println("");
        StdOut.println("[Nivel]: "+nuevoPersonaje.getNivel());
        StdOut.println("[Vida]: "+nuevoPersonaje.getVida());
        StdOut.println("[Ataque]: "+nuevoPersonaje.getAtaque());
        StdOut.println("[Defensa]: "+nuevoPersonaje.getDefensa());
        StdOut.println("[Velocidad]: "+nuevoPersonaje.getVelocidad());
        StdOut.println("");
        StdOut.println("");
        StdOut.println("--------------------------------------------");
    }

    @Override
    public int InteractuarNPC() {
        return 0;
    }

    @Override
    public int AtacarPersonaje() {
       return -1;

    }

    @Override
    public int AtacarEnemigo() {
        return 0;
    }

    @Override
    public int AtaqueEspecialPersonaje() {
        return 0;
    }

    @Override
    public int AtaqueEspecialEnemigo() {
        return 0;
    }

    @Override
    public int Efectos() {
        return 0;
    }

    @Override
    public void Defender() {
        StdOut.println("Ataque defendido");

        StdOut.println("El enemigo se defendio de tu ataque");
    }

    @Override
    public void Salir() {
        System.exit(2);
    }

    /**
     *  Metodo que pasa un dato de String a un dato double
     * @param str String a verificar
     * @return retorna falso si el numero ingresado esta mal ingresado y true si esta correctamente ingresado
     */
    private boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static int Randomizer()
    {
        int randomNumber = ThreadLocalRandom.current().nextInt(0,   4);
        return randomNumber;
    }

}
