package Juego;

import Enemigo.Enemigo;
import Personaje.Personaje;
import ucn.ArchivoEntrada;
import ucn.Registro;
import ucn.StdIn;
import ucn.StdOut;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class InterfaseJuegoImpl implements InterfaseJuego {

    Personaje nuevoPersonaje;

    List<Personaje> nuevaClase = new ArrayList<>();

    int numeroMazmorra = 1;
    int mazmorraActual = numeroMazmorra;
    boolean explorado = false;
    Enemigo Zombie1, Vampiro1, HombreLobo1;
    ArrayList<Enemigo> enemigos = new ArrayList<Enemigo>(3);
    ArrayList<Personaje> nuevaCLase = new ArrayList<Personaje>(100);


    @Override
    public void Iniciar() throws IOException {
        if (!cargarNombres() || !cargarDescripciones()) {
            StdOut.println("No se pudo iniciar el programa");
        }


        enemigos.add(Zombie1);
        enemigos.add(Vampiro1);
        enemigos.add(HombreLobo1);


        MenuPrincipal();
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
        StdOut.println("Espadachin");
        StdOut.println("Arquero");
        StdOut.println("Mago");
        String claseEscogida = StdIn.readString();

        if (claseEscogida.equalsIgnoreCase("Espadachin")){
            nuevoPersonaje = new Personaje(nombrePersonaje,descripcionPersonaje,1,100,20,10,17,0,"Normal","Ataque Doble");
            nuevaClase.add(nuevoPersonaje);
            StdOut.println("Personaje Creado, ¡que comienze la aventura!");
            FinalDungeons();
        }
        if (claseEscogida.equalsIgnoreCase("Arquero")){
            nuevoPersonaje = new Personaje(nombrePersonaje,descripcionPersonaje,1,100,20,10,17,0,"Normal","Ataque Multiple");
            nuevaClase.add(nuevoPersonaje);
            StdOut.println("Personaje Creado, ¡que comienze la aventura!");
            FinalDungeons();
        }
        if (claseEscogida.equalsIgnoreCase("Mago")){
            nuevoPersonaje = new Personaje(nombrePersonaje,descripcionPersonaje,1,100,20,10,17,0,"Normal","Regeneracion");
            nuevaClase.add(nuevoPersonaje);
            StdOut.println("Personaje Creado, ¡que comienze la aventura!");
            FinalDungeons();
        }else {
            StdOut.println("Error, ingrese una opcion correcta");
            CreacionPersonaje();
        }

        ;
    }

    @Override
    public void FinalDungeons() {
        boolean corriendo = true;



        while (corriendo) {
            StdOut.println("------------->FINAL DUNGEONS<-------------");
            StdOut.println("[!] Te encuentras en la mazmorra N°" + numeroMazmorra + " [!]");
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
                        explorado = true;
                        Inspeccionar();

                        break;

                    case 2:
                        VerPersonaje();
                        break;

                    case 3:
                        if (!explorado)
                        {
                            System.out.println("No haz explorado la masmorra actual para poder subir.");
                        }
                        else
                        {
                            numeroMazmorra =+1;
                            FinalDungeons();
                        }
                        break;
                    case 4:
                        if (numeroMazmorra == 1)
                        {
                            System.out.println("Ya te encuentras en la primera mazmorra, no se puede volver mas.");
                            FinalDungeons();
                        }

                        else
                        {
                            numeroMazmorra = numeroMazmorra -1;
                            FinalDungeons();

                        }
                        break;
                    case 5:
                        System.exit(5);
                        break;
                    default:
                        StdOut.println("Ingrese una opcion de la lista: ");
                        FinalDungeons();


                }

            } catch (Exception e) {
                StdOut.println("Ingrese una opción válida.");
                FinalDungeons();


            }
        }
    }

    @Override
    public void Inspeccionar()
    {
        int enemigos = Randomizer();
            switch (enemigos)
            {
                case 0:
                    InteractuarNPC(true);
                    break;

                case 1:
                    Batalla(1);

                case 2:
                    Batalla(2);

                case 3:
                    Batalla(3);
            }


    }

    @Override
    public void Batalla(int enemigos)
    {
        switch (enemigos) {
            case 1:
                System.out.println("Te haz encontrado a ");
        }


    }

    @Override
    public void VerPersonaje() {
        StdOut.println("--------------->FINAL DUNGEONS<--------------");
        StdOut.println("");
        StdOut.println("");
        StdOut.println("[*] Nivel: "+nuevoPersonaje.getNivel()+" [*]");
        StdOut.println("[*] Vida: "+nuevoPersonaje.getVida()+" [*]");
        StdOut.println("[*] Ataque: "+nuevoPersonaje.getAtaque()+" [*]");
        StdOut.println("[*] Defensa: "+nuevoPersonaje.getDefensa()+" [*]");
        StdOut.println("[*] Velocidad: "+nuevoPersonaje.getVelocidad()+" [*]");
        StdOut.println("");
        StdOut.println("");
        StdOut.println("---------------------------------------------");

        StdOut.println("Presione enter para volver al menu");
        String respuesta = StdIn.readString();
        FinalDungeons();
    }

    @Override
    public int InteractuarNPC(boolean NPC)
    {
        int extraEXP = 0;

        if (NPC = true)
        {
            extraEXP = 100;
        }

        else
        {
            extraEXP = 0;
            System.out.println("No parece haber reaccion");


        }

        return extraEXP;
    }

    @Override
    public int AtacarPersonaje() {
        return (int) (nuevaCLase.get(0).getAtaque()*enemigos.get(0).getDefensa());
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
    public int Efectos(int efecto) {
        return 0;
    }

    @Override
    public int Defender() {
        return 0;
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

    public static boolean sobrevivirNPC(int randomNumber)
    {
        boolean NPC = false;
        int chanceSobrevivir = ThreadLocalRandom.current().nextInt(1,21);
        if (randomNumber == 0)
        {
            NPC = true;
        }
        if (randomNumber == 1)
            if(chanceSobrevivir >=18)
            {
                NPC = false;
            }
            else {NPC = true;}

        else if (randomNumber == 2)
        {
            if(chanceSobrevivir >= 14)
            {
                NPC = false;
            }
            else {NPC = true;}
        }

        else
        {
            if(chanceSobrevivir >= 10)
            {NPC = false;}
            else {NPC = true;}
        }

        return NPC;
    }

    public boolean cargarNombres() throws IOException {
        ArchivoEntrada archivo = new ArchivoEntrada("nombres.txt");
        int contador = 0;
        while (!archivo.isEndFile()) {
            Registro regEnt = archivo.getRegistro();
            String nombre = regEnt.getString();

            contador++;
        }
        archivo.close();
        return true;
    }

    public boolean cargarDescripciones() throws IOException {
        ArchivoEntrada archivo = new ArchivoEntrada("descripciones.txt");
        int contador = 0;
        while (!archivo.isEndFile()) {
            Registro regEnt = archivo.getRegistro();
            String descripcion = regEnt.getString();

            contador++;
        }
        archivo.close();
        return true;
    }
}
