package Juego;


import Enemigo.Enemigo;
import Personaje.Personaje;
import ucn.StdIn;
import ucn.StdOut;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
/**
 * Clase que representa el sistema
 */
public class InterfaseJuegoImpl implements InterfaseJuego {
    /**
     * Personaje creado
     */
    Personaje nuevoPersonaje;
    /**
     * Lista qye almacena los tipos de personajes
     */
    List<Personaje> nuevaClase = new ArrayList<>();
    /**
     * Mazmorra donde parte el personaje
     */
    int numeroMazmorra = 1;
    /**
     * Mazmorra donde se encuentra el personaje
     */
    int mazmorraActual = numeroMazmorra;
    /**
     * Funcion que determina si nuestro personaje esta explorando la mazmorra
     */
    boolean explorado = false;
    /**
     * Funcion que establece una cantidad de enemigos
     */
    int cantEnemigos;
    /**
     *  Variable que sirve para guaradar temporalmente la cantidad de enemigos
     */
    int cantTempEne;
    /**
     * Variable que guarda la vida del personaje
     */
    int vidaOriginal;
    /**
     * Es la experiencia que otorga el encuentro con el NPC
     */
    int extraXP;
    /**
     * Contador que sirve para aplicar los efectos durante una cantidad determinada de tiempo
     */
    int contador = 0;
    /**
     * Variable que guarda la velocidad del jugador
     */
    int velocidadOriginal;
    /**
     * Lista que almacena los nombres de los enemigos
     */
    List<String> nombresEnemigos = new ArrayList<>();
    /**
     * Lista que almacena las descripciones de los enemigos
     */
    List<String> descripcionesEnemigos = new ArrayList<>();
    /**
     * Lista que almacena los tipos de enemigos
     */
    List<String> tipoEnemigos = new ArrayList<>();
    /**
     * Lista que almacena al contenedor de enemigos
     */
    List<Enemigo> ListaEnemigos = new ArrayList<>();


    {
        // Metodo de la lista nombresEnemigos y se usa para agregar los nombres
        nombresEnemigos.add(0, "Silvo");
        nombresEnemigos.add(1, "Begelle");
        nombresEnemigos.add(2, "Laegon");
        nombresEnemigos.add(3, "Tand");
        nombresEnemigos.add(4, "Juvento");
        nombresEnemigos.add(5, "Tigrit");

        // Metodo de la lista descripcionesEnemigos y se usa para agregar las descripciones
        descripcionesEnemigos.add(0, "El Lider");
        descripcionesEnemigos.add(1, "El Ordenado");
        descripcionesEnemigos.add(2, "El Feliz");
        descripcionesEnemigos.add(3, "El Grande");
        descripcionesEnemigos.add(4, "El Feroz");
        descripcionesEnemigos.add(5, "El Dios");
        // Metodo de la lista tipoEnemigos y se usa para agregar los tipos de enemigos
        tipoEnemigos.add(0, "Vampiro");
        tipoEnemigos.add(1, "Hombre Lobo");
        tipoEnemigos.add(2, "Zombie");
        /**
         * Aqui se agregan a los enemigos en base a sus estadisticas y lo unico que varia seria su nombre,descripcion y habilidad, el nombre y descripcion ocupa un metodo llamado RandomizerDescripcionesYNombres que nos
         * permite seleccionar de las listas un nombre y una descripcion al azar y luego a cada enemigo se le denomina una unica habilidad
         */
        Enemigo Zombie = new Enemigo(nombresEnemigos.get(RandomizerDescripcionesYNombres()), descripcionesEnemigos.get(RandomizerDescripcionesYNombres()), 1, 110, 25, 10, 25, 100, "Normal", "Relentizar", tipoEnemigos.get(2));
        Enemigo HombreLobo = new Enemigo(nombresEnemigos.get(RandomizerDescripcionesYNombres()), descripcionesEnemigos.get(RandomizerDescripcionesYNombres()), 1, 110, 25, 10, 25, 100, "Normal", "Sangrar", tipoEnemigos.get(0));
        Enemigo Vampiro = new Enemigo(nombresEnemigos.get(RandomizerDescripcionesYNombres()), descripcionesEnemigos.get(RandomizerDescripcionesYNombres()), 1, 110, 25, 10, 25, 100, "Normal", "Araniar", tipoEnemigos.get(1));

        // Aqui se agregan los enemigos creados al contenedor ListaEnemigos
        ListaEnemigos.add(Zombie);
        ListaEnemigos.add(HombreLobo);
        ListaEnemigos.add(Vampiro);

    }

    /**
     *  Metodo que inicia el juego
     */
    @Override
    public void Iniciar()  {
        MenuPrincipal();
    }

    /**
     * Menu principal del juego
     */
    @Override
    public void MenuPrincipal() {
        // Aqui se le da al usuario 2 opciones, jugar o salir
        StdOut.println("----->ZENKAI GAMES PRESENTA<-----");
        StdOut.println("");
        StdOut.println("FINAL DUNGEONS");
        StdOut.println("");
        StdOut.println("[1] INICIAR JUEGO");
        StdOut.println("[2] SALIR");
        // Dependiendo de la opcion, se analiza lo ingresado por consola si lo que ingreso el usuario es valido
        // y luego de la validacion determina que hacer
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

    /**
     * Menu para la creacion del personaje
     */
    @Override
    public void CreacionPersonaje() {
        // Aqui se ingresa por consola el nombre que quiera el usuario
        StdOut.println("----->FINAL DUNGEONS<-----");
        StdOut.println("");
        StdOut.println("[*] CREACION DE PERSONAJE [*]");
        StdOut.println("");
        StdOut.println("INGRESE UN NOMBRE: ");
        String nombrePersonaje = StdIn.readString();

        // Aqui se ingresa por consola la descripcion que quiera el usuario
        StdOut.println("----->FINAL DUNGEONS<-----");
        StdOut.println("");
        StdOut.println("[*] CREACION DE PERSONAJE [*]");
        StdOut.println("");
        StdOut.println("INGRESE UNA DESCRIPCION: ");
        String descripcionPersonaje = StdIn.readString();

        // Aqui se escribe por consola la clase que escogera el usuario para iniciar el juego
        StdOut.println("----->FINAL DUNGEONS<-----");
        StdOut.println("");
        StdOut.println("[*] CREACION DE PERSONAJE [*]");
        StdOut.println("");
        StdOut.println(" ESCOJA UNA CLASE:");
        StdOut.println("[1] Espadachin");
        StdOut.println("[2] Arquero");
        StdOut.println("[3] Mago");
        try
        {
            String opcion = StdIn.readLine();
            int decision;
            if (isNumeric(opcion)) Integer.parseInt(opcion);
            decision = Integer.parseInt(opcion);
            switch (decision)
            {
                case 1: // Si el caracter ingresado es 1 obtiene la habilidad de Ataque Doble
                    nuevoPersonaje = new Personaje(nombrePersonaje,descripcionPersonaje,1,100,20,10,17,0,"Normal","Ataque Doble");
                    nuevaClase.add(nuevoPersonaje);
                    StdOut.println("Personaje Creado, ¡que comienze la aventura!");
                    FinalDungeons();

                case 2: // Si el caracter ingresado es 2 obtiene la habilidad de Ataque Multiple
                    nuevoPersonaje = new Personaje(nombrePersonaje,descripcionPersonaje,1,100,20,10,17,0,"Normal","Ataque Multiple");
                    nuevaClase.add(nuevoPersonaje);
                    StdOut.println("Personaje Creado, ¡que comienze la aventura!");
                    FinalDungeons();

                case 3: // Si el caracter ingresado es 3 obtiene la habilidad de Regeneracion
                    nuevoPersonaje = new Personaje(nombrePersonaje,descripcionPersonaje,1,100,20,10,17,0,"Normal","Regenerar");
                    nuevaClase.add(nuevoPersonaje);
                    StdOut.println("Personaje Creado, ¡que comienze la aventura!");
                    FinalDungeons();


                default:
                    StdOut.println("Ingrese una opcion de la lista de personajes: ");
                    CreacionPersonaje();


            }

        }
        catch (Exception e) {
            StdOut.println("Ingrese una opción válida.");
            CreacionPersonaje();
        }
    }

    /**
     * Metodo donde comienza el juego
     */
    @Override
    public void FinalDungeons() {
        boolean corriendo = true;

        // Mientras la condicion de corriendo siga en true, el juego seguira ejecutandose
        // para sacar esto nuestro personaje debe morir o encontrarse con el NPC y salir de la mazmorra
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
            // Aqui se le ofrece al usuario multiples decisiones acorde a lo que quiera hacer, puede inspeccionar la mazmorra,
            // ver sus estadisticas, avanzar o retroceder en la mazmorra y salir de la mazmorra
            try {
                String opcion = StdIn.readLine();
                int decision;
                if (isNumeric(opcion)) Integer.parseInt(opcion);
                decision = Integer.parseInt(opcion);
                switch (decision) {
                    // En el caso 1 el personaje decide explorar la mazmorra, donde pueden pasar 2 cosas
                    // entra en combate o se encuentra al NPC
                    case 1:
                        if (!explorado)
                        {

                            Inspeccionar();
                        }
                        // Esto pas cuando el combate o la interaccion del NPC finalizan
                        else {
                            System.out.println("Ya exploraste la masmorra.");
                            StdOut.println("Presione enter para continuar");
                            String decision3 = StdIn.readString();
                        }
                        FinalDungeons();

                        break;

                    case 2:
                        // Llama al metodo VerPersonaje para mostrar las estadisticas actuales del personaje
                        VerPersonaje();
                        break;

                    case 3:
                        // Aqui dependiendo de si el personaje entro en combate o esta en el menu del juego pueden pasar
                        // 2 cosas, si el personaje no a peleado o hablado con el NPC no puede avanzar
                        // Y si ya hizo una de las 2 cosas entonces ahi recien se puede mover
                        if (!explorado)
                        {
                            System.out.println("No haz explorado la masmorra actual para poder subir.");
                            StdOut.println("Presione enter para continuar");
                            String decision2 = StdIn.readString();
                        }
                        else
                        {
                            numeroMazmorra++;

                            if (numeroMazmorra == mazmorraActual){explorado = false;}
                            FinalDungeons();
                        }
                        break;
                    case 4:
                        // Este metodo sirve para retroceder de mazmorra, pero con la condicion de que
                        // si el personaje se encuentra en la mazmorra 1 no puede retroceder de esta
                        if (numeroMazmorra == 1)
                        {
                            System.out.println("Ya te encuentras en la primera mazmorra, no se puede volver mas.");
                            StdOut.println("Presione enter para continuar");
                            String decision5 = StdIn.readString();
                            FinalDungeons();
                        }

                        else
                        {
                            numeroMazmorra--;
                            FinalDungeons();

                        }
                        break;
                    case 5:
                        // Esta opcion sirve para salir de la mazmorra y por ende, salir del juego
                        StdOut.println("Saliendo de la mazmorra");
                        System.exit(5);
                        break;
                    // Este metodo sirve por si el usuario no ingreso lo que se pedia por pantalla
                    default:
                        StdOut.println("Ingrese una opcion de la lista: ");
                        FinalDungeons();


                }
                // Este metodo sirve por si el usuario no ingreso los caracteres requeridos por pantalla
            } catch (Exception e) {
                StdOut.println("Ingrese una opción válida.");
                FinalDungeons();


            }
        }
    }

    /**
     * Metodo que se encarga de manera aleatoria poner o no enemigos en la mazmorra
     * @return la cantidad de enemigos que nos va a tocar en la mazmorra
     */
    @Override
    public int Inspeccionar()
    {
        int enemigos = Randomizer();
            switch (enemigos)
            {
                case 0:
                    extraXP = 100;
                    InteractuarNPC(true);
                    break;


                case 1:
                    extraXP = 150;
                    cantEnemigos = 1;
                    cantTempEne = cantEnemigos;
                    vidaOriginal = ListaEnemigos.get(1).getVida();
                    int enemigoAzar = RandomizerEnemigo();
                    Batalla(enemigoAzar);
                    break;



                case 2:
                    extraXP = 200;
                    cantEnemigos = 2;
                    cantTempEne = cantEnemigos;
                    vidaOriginal = ListaEnemigos.get(1).getVida();
                    enemigoAzar = RandomizerEnemigo();
                    Batalla(enemigoAzar);
                    break;



                case 3:
                    extraXP = 250;
                    cantEnemigos = 3;
                    cantTempEne = cantEnemigos;
                    vidaOriginal = ListaEnemigos.get(1).getVida();
                    enemigoAzar = RandomizerEnemigo();
                    Batalla(enemigoAzar);
                    break;


            }
            return enemigos;

    }

    /**
     * Metodo que se encarga de mostrarnos los enemigos a combatir y las variadas opciones del personaje
     * @param enemigos cantidad de enemigos que nos otorga el sistema
     */
    @Override
    public void Batalla(int enemigos)
    {
        boolean batallando = true;

        if (!nuevoPersonaje.getEstado().equalsIgnoreCase("Normal") )
        {
            if (contador < 3)
            {
                if (nuevoPersonaje.getEstado().equalsIgnoreCase("Vampirismo"))
                {
                    nuevoPersonaje.setVida(nuevoPersonaje.getVida() - 5);
                    ListaEnemigos.get(enemigos).setVida(ListaEnemigos.get(enemigos).getVida() + 5);
                    contador++;
                }
                if (nuevoPersonaje.getEstado().equalsIgnoreCase("Sangrado")) {
                    nuevoPersonaje.setVida(nuevoPersonaje.getVida() - 5);
                    contador++;
                }
                if (nuevoPersonaje.getEstado().equalsIgnoreCase("Regeneracion"))
                {
                    nuevoPersonaje.setVida(nuevoPersonaje.getVida() + 5);
                    contador++;
                }
                if (nuevoPersonaje.getEstado().equalsIgnoreCase("Ralentizado"))
                {
                    nuevoPersonaje.setVelocidad(nuevoPersonaje.getVelocidad()/2);
                    contador++;
                }
            }
            else
            {
                contador = 0;
                if (nuevoPersonaje.getEstado().equalsIgnoreCase("Ralentizado"))
                {
                    nuevoPersonaje.setVelocidad(velocidadOriginal);
                }
                nuevoPersonaje.setEstado("Normal");
            }
        }

        System.out.println("¡Te haz encontrado "+cantTempEne+" enemigo/s, preparate!");


        // Menu que presenta por pantalla las estadisticas de los enemigos
        System.out.println("*****ENEMIGO*****");
        System.out.println("[*] Tipo: " + ListaEnemigos.get(enemigos).getTipo());
        System.out.println("[*] Nivel:  " + ListaEnemigos.get(enemigos).getNivel() + " " + ListaEnemigos.get(enemigos).getNombre() + " " + ListaEnemigos.get(enemigos).getDescripcion());
        System.out.println("[*] Vida: " + ListaEnemigos.get(enemigos).getVida());
        System.out.println("[*] Estado:  " + ListaEnemigos.get(enemigos).getEstado());
        System.out.println(" ");
        System.out.println(" ");

            while (batallando)
            {

                    // Menu que presenta por pantalla las estadisticas del personaje
                    System.out.println("*****TU*****");
                    System.out.println("[*] Nivel: " + nuevoPersonaje.getNivel() + " " + nuevoPersonaje.getNombre() + " " + nuevoPersonaje.getDescripcion());
                    System.out.println("[*] Vida: " + nuevoPersonaje.getVida());
                    System.out.println("[*] Estado: " + nuevoPersonaje.getEstado());
                    System.out.println(" ");
                    System.out.println(" ");

                    StdOut.println("¿Que deseas hacer?");
                    System.out.println("[1] Atacar");
                    System.out.println("[2] Usar el ataque especial");
                    System.out.println("[3] Defender");

                // Dependiendo de la velocidad del personaje y del enemigo, determina quien pelea primero
                if (nuevoPersonaje.getVelocidad() > ListaEnemigos.get(enemigos).getVelocidad())
                {

                    int opcion = StdIn.readInt();

                    switch (opcion) {
                        case 1:
                            calculoFinal(1, enemigos);
                            break;

                        case 2:
                            calculoFinal(2, enemigos);
                            break;

                        case 3:
                            calculoFinal(3, enemigos);
                            break;

                        default:
                            StdOut.println("Error, ingrese una opcion correcta");
                    }


                }
                else
                {
                    int opcion = StdIn.readInt();

                    switch (opcion) {
                        case 1:
                            turnoEnemigo(1, enemigos);
                            break;

                        case 2:
                            turnoEnemigo(2, enemigos);
                            break;

                        case 3:
                            turnoEnemigo(3, enemigos);
                            break;

                        default:
                            StdOut.println("Error, ingrese una opcion correcta");
                    }
                }



            }

    }

    /**
     * Metodo que calcular los danios que nuestro personaje le hace a los enemigos
     * @param opcion es lo que el usuario ingresa a la hora de combatir
     */
    public void calculoFinal(int opcion, int pos)
    {

        switch (opcion)
        {
            case 1:
            System.out.println("Atacas a tu enemigo! ");
            int danio = nuevoPersonaje.getAtaque();
            int vidaEnemigo = ListaEnemigos.get(pos).getVida() - danio;
            if (vidaEnemigo <= 0)
                {
                    ListaEnemigos.get(pos).setVida(vidaOriginal);
                    System.out.println("Haz derrotado al enemigo!");
                    System.out.println("Presione enter para continuar");
                    String enter = StdIn.readString();
                    cantTempEne--;
                    nuevoPersonaje.setExperiencia(nuevoPersonaje.getExperiencia()+100);
                    levelUP();
                    if (cantTempEne == 0) {
                        InteractuarNPC(sobrevivirNPC(cantEnemigos));
                    }
                    else {Batalla(RandomizerEnemigo());}

                    break;
                }
            ListaEnemigos.get(pos).setVida(vidaEnemigo);
            System.out.println("Haz inflingido un total de "+ danio+ " de danio! ");
            calculoFinalEnemigo(RandomOpcionEnemigo(), pos );
            break;



            case 2:

                if (nuevoPersonaje.getAtaqueEspecial().equalsIgnoreCase("Regenerar"))
                {
                    Efectos(4);
                    calculoFinalEnemigo(RandomOpcionEnemigo(), pos);
                }

                else
                {
                    danio = nuevoPersonaje.getAtaque() * 2;
                    vidaEnemigo = ListaEnemigos.get(0).getVida() - danio;
                    if (vidaEnemigo <= 0)
                    {
                        ListaEnemigos.get(pos).setVida(vidaOriginal);
                        System.out.println("Haz derrotado al enemigo!");
                        System.out.println("Presione enter para continuar");
                        String enter = StdIn.readString();
                        cantTempEne--;
                        nuevoPersonaje.setExperiencia(nuevoPersonaje.getExperiencia() + 100);
                        levelUP();
                        if (cantTempEne == 0)
                        {
                            InteractuarNPC(sobrevivirNPC(cantEnemigos));
                        }
                        else
                        {
                            Batalla(RandomizerEnemigo());
                        }


                    }
                    ListaEnemigos.get(pos).setVida(vidaEnemigo);
                    calculoFinalEnemigo(RandomOpcionEnemigo(), pos);

                }
                break;
            case 3:
                calculoFinalEnemigo(4, pos);
                break;
        }


    }

    /**
     * Metodo que calcular los danios que el enemigo le hace al personaje
     * @param opcion es lo que hara el enemigo 
     */
    public void calculoFinalEnemigo(int opcion, int pos)
    {
        switch (opcion)
        {
            case 4:
                System.out.println("El enemigo ataco pero no pudo romper tus defensas! ");
                Batalla(pos);
                break;
            case 1:
                System.out.println("El enemigo te ataca! ");
                int danio = ListaEnemigos.get(pos).getAtaque();
                int vidaJugador = nuevoPersonaje.getVida() - danio;
                if (vidaJugador <= 0)
                {
                    System.out.println("Te han derrotado!");
                    Salir();
                    break;
                }
                System.out.println("Te han inflingido un total de "+ danio+ " de danio! ");
                System.out.println("Presione enter para continuar la batalla");
                String enter = StdIn.readString();
                nuevoPersonaje.setVida(vidaJugador);
                Batalla(pos);
                break;



            case 2:
                System.out.println("¡El enemigo ocupo su habilidad especial, cuidado! ");
                System.out.println("Presione enter para continuar la batalla");
                String enter2 = StdIn.readString();
                Efectos(pos);
                vidaJugador = nuevoPersonaje.getVida();
                if (vidaJugador <= 0)
                {
                    System.out.println("¡Te han derrotado!");
                    Salir();
                    break;
                }

                Batalla(pos);
                break;

            case 3:
                System.out.println("¡Él enemigo se defiende!");
                turnoJugador(0, pos);
                break;
        }


    }

    /**
     * Metodo para cuando ele enemigo ataca primero en la batalla
     * @param opcion es la variable que decide lo que nos hara el enemigo
     * @param pos sirve para establecer que habilidad puede usar el enemigo
     */
    public void turnoEnemigo(int opcion, int pos)
    {
        switch (opcion)
        {
            case 1:
                System.out.println("¡El enemigo te ataca! ");
                System.out.println("Presione enter para continuar la batalla");
                String enter = StdIn.readString();
                int danio = ListaEnemigos.get(pos).getAtaque();
                int vidaJugador = nuevoPersonaje.getVida() - danio;
                if (vidaJugador <= 0)
                {
                    System.out.println("¡Te han derrotado!");
                    Salir();
                    break;
                }
                System.out.println("¡Te han inflingido un total de "+ danio+ " de danio! ");
                System.out.println("Presione enter para continuar la batalla");
                String enter2 = StdIn.readString();
                nuevoPersonaje.setVida(vidaJugador);
                turnoJugador(opcion, pos);
                break;



            case 2:
                System.out.println("¡El enemigo ocupo su habilidad especial, cuidado! ");
                System.out.println("Presione enter para continuar la batalla");
                String enter4 = StdIn.readString();
                Efectos(pos);

                vidaJugador = nuevoPersonaje.getVida();
                if (vidaJugador <= 0)
                {
                    System.out.println("¡Te han derrotado!");
                    Salir();
                    break;
                }

                turnoJugador(opcion, pos);
                break;

            case 3:
                System.out.println("¡Él enemigo se defiende !");
                turnoJugador(0, pos);
                break;
        }


    }

    /**
     * Este metod sirve para cuando a nuestro personaje le toque atacar de segundo
     * @param opcion es la decision que utiliza el usuario al combatir al enemigo
     * @param pos sirve para daniar al enemigo que estamos combatiendo
     */
    public void turnoJugador(int opcion, int pos)
    {

        switch (opcion)
        {
            case 1:
                System.out.println("Atacas a tu enemigo! ");
                int danio = nuevoPersonaje.getAtaque();
                int vidaEnemigo = ListaEnemigos.get(pos).getVida() - danio;
                if (vidaEnemigo <= 0)
                {
                    ListaEnemigos.get(pos).setVida(vidaOriginal);
                    System.out.println("Haz derrotado al enemigo!");
                    System.out.println("Presione enter para continuar");
                    String enter = StdIn.readString();
                    cantTempEne--;
                    nuevoPersonaje.setExperiencia(nuevoPersonaje.getExperiencia()+100);
                    levelUP();
                    if (cantTempEne == 0) {
                        InteractuarNPC(sobrevivirNPC(cantEnemigos));
                    }
                    else {Batalla(RandomizerEnemigo());}

                    break;
                }
                ListaEnemigos.get(pos).setVida(vidaEnemigo);
                System.out.println("Haz inflingido un total de "+ danio+ " de danio! ");
                System.out.println("Presione enter para continuar la batalla");
                String enter = StdIn.readString();
                Batalla(pos);
                break;



            case 2:

                if (nuevoPersonaje.getAtaqueEspecial().equalsIgnoreCase("Regenerar"))
                {
                    Efectos(4);
                    calculoFinalEnemigo(RandomOpcionEnemigo(), pos);
                }

                else
                {
                    danio = nuevoPersonaje.getAtaque() * 2;
                    vidaEnemigo = ListaEnemigos.get(0).getVida() - danio;
                    if (vidaEnemigo <= 0)
                    {
                        ListaEnemigos.get(pos).setVida(vidaOriginal);
                        System.out.println("Haz derrotado al enemigo!");
                        System.out.println("Presione enter para continuar");
                        String enter3 = StdIn.readString();
                        cantTempEne--;
                        nuevoPersonaje.setExperiencia(nuevoPersonaje.getExperiencia() + 100);
                        levelUP();
                        if (cantTempEne == 0)
                        {
                            InteractuarNPC(sobrevivirNPC(cantEnemigos));
                        }
                        else
                        {
                            Batalla(pos);
                        }


                    }
                    ListaEnemigos.get(pos).setVida(vidaEnemigo);
                    calculoFinalEnemigo(RandomOpcionEnemigo(), pos);

                }
                break;
            case 3:
                calculoFinalEnemigo(4, pos);
                break;

            case 4:
                System.out.println("El enemigo ha bloqueado nuestro ataque! ");
                Batalla(pos);
                break;
        }


    }
    /**
     * VerPersonaje permite observar las estadisticas del personaje
     */
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
        StdOut.println("[*] Experiencia: "+nuevoPersonaje.getExperiencia()+" [*]");
        StdOut.println("");
        StdOut.println("");
        StdOut.println("---------------------------------------------");

        StdOut.println("Presione enter para volver al menu");
        String respuesta = StdIn.readString();
        FinalDungeons();
    }

    /**
     * Permite al personaje interactuar con el NPC, el cual otorga experiencia a la hora de encontrarlo
     * @param NPC este varia dependiendo de la cantidad de enemigos y del porcentaje de aparicion
     */
    @Override
    public void InteractuarNPC(boolean NPC)
    {

        explorado = true;

        if (NPC)
        {
            mazmorraActual++;

            nuevoPersonaje.setExperiencia(nuevoPersonaje.getExperiencia()+ extraXP);
            levelUP();
            System.out.println("Muchas gracias extranjero, obten esto como muestra de mi agradecimiento");
            System.out.println("Haz obtenido "+extraXP+" de experiencia");
            FinalDungeons();
        }

        else
        {

            System.out.println("No parece haber reaccion");
            mazmorraActual++;
            FinalDungeons();

        }

    }



    /**
     * Metodo que guarda los efectos que puede sufri o aplicarse el personaje en el combate
     * @param efecto depende de si un enemigo lo ocupa o si la clase del mago ocupa su habilidad
     * @return el efecto aplicado
     */
    @Override
    public int Efectos(int efecto) {
        switch (efecto) {
            case 1 -> {
                System.out.println("¡Has sido ralentizado! ");
                velocidadOriginal = nuevoPersonaje.getVelocidad();
                nuevoPersonaje.setEstado("Ralentizado");
                return 1;
            }
            case 2 -> {
                System.out.println("¡Te han vampirificado! ");
                nuevoPersonaje.setEstado("Vampirismo");
                return 2;
            }
            case 3 -> {
                System.out.println("¡Te han hecho sangrar! ");
                nuevoPersonaje.setEstado("Sangrado");
                return 3;
            }
            case 4 -> {
                System.out.println("Estas regenerando vida");
                nuevoPersonaje.setEstado("Regenerar");
                return 4;
            }
            case 5 -> {
                System.out.println("Vuelves a la normalidad");
                nuevoPersonaje.setEstado("Normal");
                return 5;
            }
        }

        return 0;
    }


    /**
     * Metodo que nos permite salir de la aplicacion
     */
    @Override
    public void Salir() {
        System.exit(2);
    }

    /**
     * Metodo que permite al personaje subir de nivel cumpliendo con los requerimientos para
     * poder subir de nivel al igual que multiplicar las estadisticas del personaje
     */
    public void SubirDeNivel()
    {
        nuevoPersonaje.setNivel(nuevoPersonaje.getNivel()+1);
        if (nuevoPersonaje.getNivel()== 2)
        {
            nuevoPersonaje.setAtaque((int) (nuevoPersonaje.getAtaque()*1.5));
            nuevoPersonaje.setDefensa((int) (nuevoPersonaje.getDefensa()*1.5));
            nuevoPersonaje.setVida((int) (nuevoPersonaje.getVida()*1.5));
            nuevoPersonaje.setVelocidad((int) (nuevoPersonaje.getVelocidad()*1.5));
        }

        if (nuevoPersonaje.getNivel() == 3)
        {
            nuevoPersonaje.setAtaque((int) (nuevoPersonaje.getAtaque()*2));
            nuevoPersonaje.setDefensa((int) (nuevoPersonaje.getDefensa()*2));
            nuevoPersonaje.setVida((int) (nuevoPersonaje.getVida()*2));
            nuevoPersonaje.setVelocidad((int) (nuevoPersonaje.getVelocidad()*2));
        }

        if (nuevoPersonaje.getNivel() == 4)
        {
            nuevoPersonaje.setAtaque((int) (nuevoPersonaje.getAtaque()*3));
            nuevoPersonaje.setDefensa((int) (nuevoPersonaje.getDefensa()*3));
            nuevoPersonaje.setVida((int) (nuevoPersonaje.getVida()*3));
            nuevoPersonaje.setVelocidad((int) (nuevoPersonaje.getVelocidad()*3));
        }
    }

    /**
     * Metodo que verifica el cumplimiento de los requerimientos a la hora de subir el nivel del personaje
     */
    public void levelUP()
    {
        if (nuevoPersonaje.getExperiencia() >= 300 && nuevoPersonaje.getNivel() == 1){nuevoPersonaje.setVida(vidaOriginal);SubirDeNivel();}
        if (nuevoPersonaje.getExperiencia() >= 750 && nuevoPersonaje.getNivel() == 2){nuevoPersonaje.setVida(vidaOriginal);SubirDeNivel();}
        if (nuevoPersonaje.getExperiencia() >= 1250 && nuevoPersonaje.getNivel() == 3){nuevoPersonaje.setVida(vidaOriginal);SubirDeNivel();}
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

    /**
     * Metodo que nos da de manera aleatoria un numero
     * @return nos da un numero del 0 al 3
     */

    public int RandomOpcionEnemigo()
    {
        int randomOpcion = ThreadLocalRandom.current().nextInt(1,   4);
        return randomOpcion;
    }
    public static int Randomizer()
    {
        int randomNumber = ThreadLocalRandom.current().nextInt(0,   4);
        return randomNumber;
    }

    /**
     * Metodo que nos da de manera aleatoria un numero para la seleccion de un enemigo al azar
     * @return nos da un numero del 0 al 2
     */
    public int RandomizerEnemigo()
    {
        int randomNumber = ThreadLocalRandom.current().nextInt(0,   3);
        return randomNumber;
    }

    /**
     * Metodo que sirve para determinar un nombre y una descripcion  al azar
     * @return un numero desde el 0 al 5
     */
    public static int RandomizerDescripcionesYNombres()
    {
        int randomNumber = ThreadLocalRandom.current().nextInt(0,   6);
        return randomNumber;
    }

    /**
     * Metodo que verifica si nuestro personaje se puede encontrar con el NPC
     * @param cantEnemigos valor que se utiliza para determinar la probabilidad de aparicion del NPC
     * @return true si nos encontramos al NPC y False sino
     */
    public static boolean sobrevivirNPC(int cantEnemigos)
    {

        boolean NPC = false;
        int chanceSobrevivir = ThreadLocalRandom.current().nextInt(1,21);
        if (cantEnemigos == 0)
        {
            NPC = true;
        }
        if (cantEnemigos == 1)
            if(chanceSobrevivir >=18)
            {
                NPC = false;
            }
            else
            {
                NPC = true;
            }

        else if (cantEnemigos == 2)
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

}
