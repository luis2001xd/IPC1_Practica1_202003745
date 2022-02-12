
import java.util.Scanner;

public class Pract1 {
    public static void main (String args[]){
        Scanner entrada= new Scanner(System.in);
   String nombre1;
        int opc;
        int cantpre=1;
        int cantpared=1;
        int cantramp=1;
        int contador=0;
        int posicionf=1;
        int posicionc=1;
        String nuevap;
        boolean salida=true;
        int vidas=3;
        int posant=1;
        int posdes=1;
        int punteo=0;
        int pospar;
        int opcpau;
String estado1;

        String nombres[]=new String[99];
        int punteous[]=new int[99];
        String estados[]= new String[99];
        String pausa="";
        System.out.println("Bienvenido a Pacman en java  \n");
        do {
            System.out.println("\n------MENÚ DE INICIO------");
            System.out.println("1.Iniciar juego");
            System.out.println("2.Historial de partidas");
            System.out.println("3.Salir");
            opc= entrada.nextInt();
            // Menú de inicio

switch (opc){
    case 1:
        // datos del usuario
        entrada.nextLine();
        System.out.print("Escriba su nombre: ");
        nombre1= entrada.nextLine();
        nombres[contador]=nombre1;
        System.out.println("Bienvenido "+nombre1+"\n");
        //especifica los tamaños del tablero y cuantas itéms habrán

        System.out.println("--------ESPECIFICAR TABLERO---------");
        System.out.print("Por favor especificar el tamaño del tablero G o P ");
        String tab= entrada.next();

        // pide el tamaño del tablero

            switch (tab) {

                // TABLERO PEQUEÑO

                case "P":
                    System.out.print("\nPREMIOS [1-12]: ");
                    cantpre=entrada.nextInt();
                    while (cantpre>12 || cantpre<1){
                        System.out.println("Por favor introducir un número en el rango dado");
                        System.out.print("\nPREMIOS [1-12]: ");
                        cantpre=entrada.nextInt();
                    }
                    System.out.print("\nPAREDES [1-6]: ");
                    cantpared=entrada.nextInt();
                    while (cantpared>6 || cantpared<1){
                        System.out.println("Por favor introducir un número en el rango dado");
                        System.out.print("\nPAREDES [1-6]: ");
                        cantpared=entrada.nextInt();
                    }
                    System.out.print("\nTRAMPAS [1-6]: ");
                    cantramp=entrada.nextInt();
                    while (cantramp>6 || cantramp<1){
                        System.out.println("Por favor introducir un número en el rango dado");
                        System.out.print("\nTRAMPAS [1-6]: ");
                        cantramp=entrada.nextInt();
                    }
                    String[][] tablerop = new String[7][8];
                    int x, y;
                    String espacios;
                    // hace al arreglo recorrer las posiciones del tablero
                    for (x = 0; x < 7; x++) {
                        for (y = 0; y < 8; y++) {
                            if (y == 0 || y == 7 || x == 0 || x == 6) {
                                espacios = "* ";
                                tablerop[x][y] = espacios;
                            } else {
                                espacios = "  ";
                                tablerop[x][y] = espacios;

                            }
                        }
                    }
                    //termina de recorrer los espacios del tablero

                    //INICIA EL ARREGLO DE LOS PREMIOS
                    premios(tablerop,cantpre,5,6);

                    //INICIA EL ARREGLO DE LAS PAREDES

                    partra(tablerop,cantpared,5,6,"X ");

                    //FINALIZA EL ARREGLO DE LAS PAREDES

                    // INICIA EL ARREGLO DE LOS FANTASMAS
                    partra(tablerop,cantramp,5,6,"@ ");
                    System.out.println();
                    System.out.println(punteo);
                    for (x = 0; x < 7; x++) {
                        for (y = 0; y < 8; y++) {
                            System.out.print(tablerop[x][y]);
                        }
                        System.out.println();
                    }
                    System.out.println("Introduzca la posición inicial del pacman: ");
                    System.out.print("Fila: ");
                    posicionf=entrada.nextInt();
                    System.out.print("\nColumna: ");
                    posicionc=entrada.nextInt();
                    while (!tablerop[posicionf][posicionc].equals("  ")){
                        System.out.println("Por favor introduzca su pacman en una posicion vacía");
                        System.out.print("Fila: ");
                        posicionf=entrada.nextInt();
                        System.out.print("\nColumna: ");
                        posicionc=entrada.nextInt();
                    }
                    tablerop[posicionf][posicionc]="< ";
                    while (salida) {
                        System.out.println("----------------------");
                        System.out.println("USUARIO:"+nombre1);
                        System.out.println("PUNTEO:"+punteo);
                        System.out.println("VIDAS:"+vidas);
                        for (x = 0; x < 7; x++) {
                            for (y = 0; y < 8; y++) {
                                System.out.print(tablerop[x][y]);
                            }
                            System.out.println();
                        }
                        nuevap= entrada.next();
                        //identifica la posición del tablero

                        switch (nuevap){

                            //Movimiento hacia arriba

                            case "8":
                                tablerop[posicionf][posicionc]="  ";
                                posant=posicionf;
                                posicionf=posicionf-1;
                                if (tablerop[posicionf][posicionc].equals("X ")){
                                    pospar=posicionf;
                                    tablerop[pospar][posicionc]="X ";
                                    posicionf=posicionf+1;
                                    tablerop[posicionf][posicionc]="< ";
                                }
                                else if (tablerop[posicionf][posicionc]==tablerop[0][0]){
                                    posicionf=5;
                                    if (tablerop[posicionf][posicionc].equals("@ ")){
                                        System.out.println("Has perdido una vida ☠");
                                        tablerop[posicionf][posicionc]="< ";
                                        vidas--;
                                    }
                                    if (tablerop[posicionf][posicionc].equals("X ")){
                                        pospar=posicionf;
                                        tablerop[pospar][posicionc]="X ";
                                        posicionf=1;
                                        tablerop[posicionf][posicionc]="< ";
                                    }
                                    if (tablerop[posicionf][posicionc].equals("0 ")){
                                        System.out.println("Has ganado un premio simple ★");
                                        punteo+=10;
                                        cantpre--;
                                        tablerop[posicionf][posicionc]="< ";
                                    } if (tablerop[posicionf][posicionc].equals("$ ")){
                                        System.out.println("Has ganado un premio especial ★");
                                        tablerop[posicionf][posicionc]="< ";
                                        punteo+=15;
                                        cantpre--;
                                    } else{
                                        tablerop[posicionf][posicionc]="< ";
                                    }
                                }else if(tablerop[posicionf][posicionc].equals("@ ")){
                                    System.out.println("Has perdido una vida ☠");
                                    tablerop[posicionf][posicionc]="< ";
                                    vidas--;
                                } else if (tablerop[posicionf][posicionc].equals("0 ")){
                                    System.out.println("Has ganado un premio simple ★");
                                    tablerop[posicionf][posicionc]="< ";
                                    punteo+=10;
                                    cantpre--;
                                } else if (tablerop[posicionf][posicionc].equals("$ ")){
                                    System.out.println("Has ganado un premio especial ★");
                                    tablerop[posicionf][posicionc]="< ";
                                    punteo+=15;
                                    cantpre--;
                                }
                                else {
                                    tablerop[posicionf][posicionc]="< ";
                                }
                                break;

                            //Movimiento hacia abajo

                            case "5":
                                tablerop[posicionf][posicionc]="  ";
                                posant=posicionf;
                                posicionf=posicionf+1;
                                if (tablerop[posicionf][posicionc].equals("X ")){
                                    pospar=posicionf;
                                    tablerop[pospar][posicionc]="X ";
                                    posicionf=posicionf-1;
                                    tablerop[posicionf][posicionc]="< ";
                                }
                                else if (tablerop[posicionf][posicionc]==tablerop[0][0]){
                                    posicionf=1;
                                    if (tablerop[posicionf][posicionc].equals("@ ")){
                                        System.out.println("Has perdido una vida ☠");
                                        tablerop[posicionf][posicionc]="< ";
                                        vidas--;
                                    }
                                    if (tablerop[posicionf][posicionc].equals("X ")){
                                        pospar=posicionf;
                                        tablerop[pospar][posicionc]="X ";
                                        posicionf=5;
                                        tablerop[posicionf][posicionc]="< ";
                                    }
                                    if (tablerop[posicionf][posicionc].equals("0 ")){
                                        System.out.println("Has ganado un premio simple ★");
                                        tablerop[posicionf][posicionc]="< ";
                                        punteo+=10;
                                        cantpre--;
                                    } if (tablerop[posicionf][posicionc].equals("$ ")){
                                        System.out.println("Has ganado un premio especial ★");
                                        tablerop[posicionf][posicionc]="< ";
                                        punteo+=15;
                                        cantpre--;
                                    }
                                    else{
                                        tablerop[posicionf][posicionc]="< ";
                                    }
                                }else if(tablerop[posicionf][posicionc].equals("@ ")){
                                    System.out.println("Has perdido una vida ☠");
                                    tablerop[posicionf][posicionc]="< ";
                                    vidas--;

                                } else if (tablerop[posicionf][posicionc].equals("0 ")){
                                    System.out.println("Has ganado un premio simple ★");
                                    tablerop[posicionf][posicionc]="< ";
                                    punteo+=10;
                                    cantpre--;
                                } else if (tablerop[posicionf][posicionc].equals("$ ")){
                                    System.out.println("Has ganado un premio especial ★");
                                    tablerop[posicionf][posicionc]="< ";
                                    punteo+=15;
                                    cantpre--;
                                }
                                else {
                                    tablerop[posicionf][posicionc]="< ";
                                }
                                break; //FINALIZA EL MOVIMIENTO HACIA ABAJO

                            //Movimiento a la derecha
                            case "6":
                                tablerop[posicionf][posicionc]="  ";
                                posant=posicionc;
                                posicionc=posicionc+1;
                                if (tablerop[posicionf][posicionc].equals("X ")){
                                    pospar=posicionc;
                                    tablerop[posicionf][pospar]="X ";
                                    posicionc=posicionc-1;
                                    tablerop[posicionf][posicionc]="< ";
                                }
                                else if (tablerop[posicionf][posicionc]==tablerop[0][0]){
                                    posicionc=1;
                                    if (tablerop[posicionf][posicionc].equals("@ ")){
                                        System.out.println("Has perdido una vida ☠");
                                        tablerop[posicionf][posicionc]="< ";
                                        vidas--;
                                    }
                                    if (tablerop[posicionf][posicionc].equals("X ")){
                                        pospar=posicionc;
                                        tablerop[posicionf][pospar]="X ";
                                        posicionc=6;
                                        tablerop[posicionf][posicionc]="< ";
                                    }
                                    if (tablerop[posicionf][posicionc].equals("0 ")){
                                        System.out.println("Has ganado un premio simple ★");
                                        tablerop[posicionf][posicionc]="< ";
                                        punteo+=10;
                                        cantpre--;
                                    } if (tablerop[posicionf][posicionc].equals("$ ")){
                                        System.out.println("Has ganado un premio especial ★");
                                        tablerop[posicionf][posicionc]="< ";
                                        punteo+=15;
                                        cantpre--;
                                    } else{
                                        tablerop[posicionf][posicionc]="< ";
                                    }
                                }else if(tablerop[posicionf][posicionc].equals("@ ")){
                                    System.out.println("Has perdido una vida ☠");
                                    tablerop[posicionf][posicionc]="< ";
                                    vidas--;
                                } else if (tablerop[posicionf][posicionc].equals("0 ")){
                                    System.out.println("Has ganado un premio simple ★");
                                    tablerop[posicionf][posicionc]="< ";
                                    punteo+=10;
                                    cantpre--;
                                } else if (tablerop[posicionf][posicionc].equals("$ ")){
                                    System.out.println("Has ganado un premio especial ★");
                                    tablerop[posicionf][posicionc]="< ";
                                    punteo+=15;
                                    cantpre--;
                                }
                                else {
                                    tablerop[posicionf][posicionc]="< ";
                                }
                                break;

                            //Movimiento a la izquierda

                            case "4":
                                tablerop[posicionf][posicionc]="  ";
                                posant=posicionc;
                                posicionc=posicionc-1;
                                if (tablerop[posicionf][posicionc].equals("X ")){
                                    pospar=posicionc;
                                    tablerop[posicionf][pospar]="X ";
                                    posicionc=posicionc+1;
                                    tablerop[posicionf][posicionc]="< ";
                                }
                                else if (tablerop[posicionf][posicionc]==tablerop[0][0]){
                                    posicionc=6;
                                    if (tablerop[posicionf][posicionc].equals("@ ")){
                                        System.out.println("Has perdido una vida ☠");
                                        tablerop[posicionf][posicionc]="< ";
                                        vidas--;
                                    }
                                    if (tablerop[posicionf][posicionc].equals("X ")){
                                        pospar=posicionc;
                                        tablerop[posicionf][pospar]="X ";
                                        posicionc=1;
                                        tablerop[posicionf][posicionc]="< ";
                                    }
                                    if (tablerop[posicionf][posicionc].equals("0 ")){
                                        System.out.println("Has ganado un premio simple ★");
                                        tablerop[posicionf][posicionc]="< ";
                                        punteo+=10;
                                        cantpre--;
                                    } if (tablerop[posicionf][posicionc].equals("$ ")){
                                        System.out.println("Has ganado un premio especial ★");
                                        tablerop[posicionf][posicionc]="< ";
                                        punteo+=15;
                                        cantpre--;
                                    } else{
                                        tablerop[posicionf][posicionc]="< ";
                                    }
                                }else if(tablerop[posicionf][posicionc].equals("@ ")){
                                    System.out.println("Has perdido una vida ☠");
                                    tablerop[posicionf][posicionc]="< ";
                                    vidas--;
                                } else if (tablerop[posicionf][posicionc].equals("0 ")){
                                    System.out.println("Has ganado un premio simple ★");
                                    tablerop[posicionf][posicionc]="< ";
                                    punteo+=10;
                                    cantpre--;
                                } else if (tablerop[posicionf][posicionc].equals("$ ")){
                                    System.out.println("Has ganado un premio especial ★");
                                    tablerop[posicionf][posicionc]="< ";
                                    punteo+=15;
                                    cantpre--;
                                }
                                else {
                                    tablerop[posicionf][posicionc]="< ";
                                }
                                break;
                            case "F":
                                System.out.println("-----PAUSA-------");
                                System.out.println("1.Reanudar juego");
                                System.out.println("2.Terminar Partida");
                                opcpau= entrada.nextInt();
                                if (opcpau==2){
                                    System.out.println("Hasta pronto, gracias por jugar");
                                    salida=false;
                                }
                        }


                        if (cantpre==0){
                            salida=false;
                            System.out.println("Felicidades has ganado ✪");
                            System.out.println("USUARIO: "+nombre1);
                            System.out.println("PUNTEO: "+punteo);
                            System.out.println("VIDAS: "+vidas);
                            for (x = 0; x < 7; x++) {
                                for (y = 0; y < 8; y++) {
                                    System.out.print(tablerop[x][y]);
                                }
                                System.out.println();
                            }
                        } if (vidas==0){
                            salida=false;
                            System.out.println("Fin del juego, has perdido todas las vidas ☣");
                            System.out.println("USUARIO: "+nombre1);
                            System.out.println("PUNTEO: "+punteo);
                            System.out.println("VIDAS: "+vidas);
                            for (x = 0; x < 7; x++) {
                                for (y = 0; y < 8; y++) {
                                    System.out.print(tablerop[x][y]);
                                }
                                System.out.println();
                            }
                        }


                    }
                    salida=true;
                    break;

                    // TABLERO GRANDE








                case "G":

                    System.out.print("\nPREMIOS [1-40]: ");
                    cantpre=entrada.nextInt();
                    while (cantpre<1 || cantpre>40){
                        System.out.println("Por favor introduzca un rango dentro de las especificaciones indicadas");
                        System.out.print("PREMIOS [1-40]: ");
                        cantpre=entrada.nextInt();
                    }
                    System.out.print("\nPAREDES [1-20]: ");
                    cantpared=entrada.nextInt();
                    while (cantpared<1 || cantpared>20){
                        System.out.println("Por favor introduzca un rango dentro de las especificaciones indicadas");
                        System.out.print("PAREDES [1-20]: ");
                        cantpared=entrada.nextInt();
                    }
                    System.out.print("\nTRAMPAS [1-20]: ");
                    cantramp=entrada.nextInt();
                   while (cantramp<1 || cantramp>20){
                    System.out.println("Por favor introduzca un rango dentro de las especificaciones indicadas");
                    System.out.print("TRAMPAS [1-20]: ");
                    cantramp=entrada.nextInt();
                  }
                    String[][] tablerog = new String[12][12];

                    // hace al arreglo recorrer las posiciones del tablero
                    for (x = 0; x < 12; x++) {
                        for (y = 0; y < 12; y++) {
                            if (y == 0 || y == 11 || x == 0 || x == 11) {
                                espacios = "* ";
                                tablerog[x][y] = espacios;
                            } else {
                                espacios = "  ";
                                tablerog[x][y] = espacios;

                            }
                        }
                    }

                    //termina de recorrer los espacios del tablero

                    //INICIA EL ARREGLO DE LOS PREMIOS
                    premios(tablerog,cantpre,10,10);

                    //INICIA EL ARREGLO DE LAS PAREDES

                    partra(tablerog,cantpared,10,10,"X ");

                    //FINALIZA EL ARREGLO DE LAS PAREDES

                    // INICIA EL ARREGLO DE LOS FANTASMAS
                    partra(tablerog,cantramp,10,10,"@ ");

                    for (x = 0; x < 12; x++) {
                        for (y = 0; y < 12; y++) {
                            System.out.print(tablerog[x][y]);
                        }
                        System.out.println();
                    }
                    System.out.println("Introduzca la posición inicial del pacman: ");
                    System.out.print("Fila: ");
                    posicionf=entrada.nextInt();
                    System.out.print("\nColumna: ");
                    posicionc=entrada.nextInt();
                    while (!tablerog[posicionf][posicionc].equals("  ")){
                        System.out.println("Por favor introduzca su pacman en una posicion vacía");
                        System.out.print("Fila: ");
                        posicionf=entrada.nextInt();
                        System.out.print("\nColumna: ");
                        posicionc=entrada.nextInt();
                    }
                    tablerog[posicionf][posicionc]="< ";
                    while (salida) {
                        System.out.println("-----------------------");
                        System.out.println("USUARIO:"+nombre1);
                        System.out.println("PUNTEO:"+punteo);
                        System.out.println("VIDAS:"+vidas);
                        for (x = 0; x < 12; x++) {
                            for (y = 0; y < 12; y++) {
                                System.out.print(tablerog[x][y]);
                            }
                            System.out.println();
                        }
                        nuevap= entrada.next();
                        //identifica la posición del tablero

                        switch (nuevap){

                            //Movimiento hacia arriba

                            case "8":
                                tablerog[posicionf][posicionc]="  ";

                                posicionf=posicionf-1;
                               if (tablerog[posicionf][posicionc].equals("X ")){
                                   pospar=posicionf;
                                   tablerog[pospar][posicionc]="X ";
                                   posicionf=posicionf+1;
                                   tablerog[posicionf][posicionc]="< ";
                               }
                                else if (tablerog[posicionf][posicionc]==tablerog[0][0]){
                                    posicionf=10;
                                   if (tablerog[posicionf][posicionc].equals("@ ")){
                                       System.out.println("Has perdido una vida ☠");
                                       tablerog[posicionf][posicionc]="< ";
                                       vidas--;
                                   }
                                   if (tablerog[posicionf][posicionc].equals("X ")){
                                       pospar=posicionf;
                                       tablerog[pospar][posicionc]="X ";
                                       posicionf=1;
                                       tablerog[posicionf][posicionc]="< ";
                                   }
                                   if (tablerog[posicionf][posicionc].equals("0 ")){
                                       System.out.println("Has ganado un premio simple ★");
                                       punteo+=10;
                                       cantpre--;
                                       tablerog[posicionf][posicionc]="< ";
                                   } if (tablerog[posicionf][posicionc].equals("$ ")){
                                       System.out.println("Has ganado un premio especial ★");
                                       tablerog[posicionf][posicionc]="< ";
                                       punteo+=15;
                                       cantpre--;
                                   } else{
                                       tablerog[posicionf][posicionc]="< ";
                                   }
                                }else if(tablerog[posicionf][posicionc].equals("@ ")){
                                   System.out.println("Has perdido una vida ☠");
                                   tablerog[posicionf][posicionc]="< ";
                                   vidas--;
                               } else if (tablerog[posicionf][posicionc].equals("0 ")){
                                   System.out.println("Has ganado un premio simple ★");
                                   tablerog[posicionf][posicionc]="< ";
                                   punteo+=10;
                                   cantpre--;
                               } else if (tablerog[posicionf][posicionc].equals("$ ")){
                                   System.out.println("Has ganado un premio especial ★");
                                   tablerog[posicionf][posicionc]="< ";
                                   punteo+=15;
                                   cantpre--;
                               }
                                else {
                                   tablerog[posicionf][posicionc]="< ";
                               }
                                break;

                                //Movimiento hacia abajo

                            case "5":
                                tablerog[posicionf][posicionc]="  ";
                                posicionf=posicionf+1;
                                if (tablerog[posicionf][posicionc].equals("X ")){
                                    pospar=posicionf;
                                    tablerog[pospar][posicionc]="X ";
                                    posicionf=posicionf-1;
                                    tablerog[posicionf][posicionc]="< ";
                                }
                                else if (tablerog[posicionf][posicionc]==tablerog[0][0]){
                                    posicionf=1;
                                    if (tablerog[posicionf][posicionc].equals("@ ")){
                                        System.out.println("Has perdido una vida ☠");
                                        tablerog[posicionf][posicionc]="< ";
                                        vidas--;
                                    }
                                    if (tablerog[posicionf][posicionc].equals("X ")){
                                        pospar=posicionf;
                                        tablerog[pospar][posicionc]="X ";
                                        posicionf=10;
                                        tablerog[posicionf][posicionc]="< ";
                                    }
                                    if (tablerog[posicionf][posicionc].equals("0 ")){
                                        System.out.println("Has ganado un premio simple ★");
                                        tablerog[posicionf][posicionc]="< ";
                                        punteo+=10;
                                        cantpre--;
                                    } if (tablerog[posicionf][posicionc].equals("$ ")){
                                        System.out.println("Has ganado un premio especial ★");
                                        tablerog[posicionf][posicionc]="< ";
                                        punteo+=15;
                                        cantpre--;
                                    }
                                    else{
                                        tablerog[posicionf][posicionc]="< ";
                                    }
                                }else if(tablerog[posicionf][posicionc].equals("@ ")){
                                    System.out.println("Has perdido una vida ☠");
                                    tablerog[posicionf][posicionc]="< ";
                                    vidas--;

                                } else if (tablerog[posicionf][posicionc].equals("0 ")){
                                    System.out.println("Has ganado un premio simple ★");
                                    tablerog[posicionf][posicionc]="< ";
                                    punteo+=10;
                                    cantpre--;
                                } else if (tablerog[posicionf][posicionc].equals("$ ")){
                                System.out.println("Has ganado un premio especial ★");
                                tablerog[posicionf][posicionc]="< ";
                                punteo+=15;
                                cantpre--;
                            }
                                else {
                                    tablerog[posicionf][posicionc]="< ";
                                }
                                break; //FINALIZA EL MOVIMIENTO HACIA ABAJO

                            //Movimiento a la derecha
                            case "6":
                                tablerog[posicionf][posicionc]="  ";
                                posicionc=posicionc+1;
                                if (tablerog[posicionf][posicionc].equals("X ")){
                                    pospar=posicionc;
                                    tablerog[posicionf][pospar]="X ";
                                    posicionc=posicionc-1;
                                    tablerog[posicionf][posicionc]="< ";
                                }
                                else if (tablerog[posicionf][posicionc]==tablerog[0][0]){
                                    posicionc=1;
                                    if (tablerog[posicionf][posicionc].equals("@ ")){
                                        System.out.println("Has perdido una vida ☠");
                                        tablerog[posicionf][posicionc]="< ";
                                        vidas--;
                                    }
                                    if (tablerog[posicionf][posicionc].equals("X ")){
                                        pospar=posicionc;
                                        tablerog[posicionf][pospar]="X ";
                                        posicionc=10;
                                        tablerog[posicionf][posicionc]="< ";
                                    }
                                    if (tablerog[posicionf][posicionc].equals("0 ")){
                                        System.out.println("Has ganado un premio simple ★");
                                        tablerog[posicionf][posicionc]="< ";
                                        punteo+=10;
                                        cantpre--;
                                    } if (tablerog[posicionf][posicionc].equals("$ ")){
                                        System.out.println("Has ganado un premio especial ★");
                                        tablerog[posicionf][posicionc]="< ";
                                        punteo+=15;
                                        cantpre--;
                                    } else{
                                        tablerog[posicionf][posicionc]="< ";
                                    }
                                }else if(tablerog[posicionf][posicionc].equals("@ ")){
                                    System.out.println("Has perdido una vida ☠");
                                    tablerog[posicionf][posicionc]="< ";
                                    vidas--;
                                } else if (tablerog[posicionf][posicionc].equals("0 ")){
                                    System.out.println("Has ganado un premio simple ★");
                                    tablerog[posicionf][posicionc]="< ";
                                    punteo+=10;
                                    cantpre--;
                                } else if (tablerog[posicionf][posicionc].equals("$ ")){
                                    System.out.println("Has ganado un premio especial ★");
                                    tablerog[posicionf][posicionc]="< ";
                                    punteo+=15;
                                    cantpre--;
                                }
                                else {
                                    tablerog[posicionf][posicionc]="< ";
                                }
                                break;
                              //Movimiento a la izquierda

                            case "4":
                                tablerog[posicionf][posicionc]="  ";
                                posant=posicionc;
                                posicionc=posicionc-1;
                                if (tablerog[posicionf][posicionc].equals("X ")){
                                    pospar=posicionc;
                                    tablerog[posicionf][pospar]="X ";
                                    posicionc=posicionc+1;
                                    tablerog[posicionf][posicionc]="< ";
                                }
                                else if (tablerog[posicionf][posicionc]==tablerog[0][0]){
                                    posicionc=10;
                                    if (tablerog[posicionf][posicionc].equals("@ ")){
                                        System.out.println("Has perdido una vida ☠");
                                        tablerog[posicionf][posicionc]="< ";
                                        vidas--;
                                    }
                                    if (tablerog[posicionf][posicionc].equals("X ")){
                                        pospar=posicionc;
                                        tablerog[posicionf][pospar]="X ";
                                        posicionc=1;
                                        tablerog[posicionf][posicionc]="< ";
                                    }
                                    if (tablerog[posicionf][posicionc].equals("0 ")){
                                        System.out.println("Has ganado un premio simple ★");
                                        tablerog[posicionf][posicionc]="< ";
                                        punteo+=10;
                                        cantpre--;
                                    } if (tablerog[posicionf][posicionc].equals("$ ")){
                                        System.out.println("Has ganado un premio especial ★");
                                        tablerog[posicionf][posicionc]="< ";
                                        punteo+=15;
                                        cantpre--;
                                    } else{
                                        tablerog[posicionf][posicionc]="< ";
                                    }
                                }else if(tablerog[posicionf][posicionc].equals("@ ")){
                                    System.out.println("Has perdido una vida ☠");
                                    tablerog[posicionf][posicionc]="< ";
                                    vidas--;
                                } else if (tablerog[posicionf][posicionc].equals("0 ")){
                                    System.out.println("Has ganado un premio simple ★");
                                    tablerog[posicionf][posicionc]="< ";
                                    punteo+=10;
                                    cantpre--;
                                } else if (tablerog[posicionf][posicionc].equals("$ ")){
                                    System.out.println("Has ganado un premio especial ★");
                                    tablerog[posicionf][posicionc]="< ";
                                    punteo+=15;
                                    cantpre--;
                                }
                                else {
                                    tablerog[posicionf][posicionc]="< ";
                                }
                                break;
                            case "F":
                                System.out.println("-----PAUSA-------");
                                System.out.println("1.Reanudar juego");
                                System.out.println("2.Terminar Partida");
                                opcpau= entrada.nextInt();
                                if (opcpau==2){
                                    System.out.println("Hasta pronto, gracias por jugar");
                                    salida=false;
                                }
                        }
                        if (cantpre==0){
                            salida=false;
                            System.out.println("Felicidades has ganado ✪");
                            System.out.println("USUARIO: "+nombre1);
                            System.out.println("PUNTEO: "+punteo);
                            System.out.println("VIDAS: "+vidas);
                            for (x = 0; x < 12; x++) {
                                for (y = 0; y < 12; y++) {
                                    System.out.print(tablerog[x][y]);
                                }
                                System.out.println();
                            }
                        } if (vidas==0){
                            salida=false;
                            System.out.println("Fin del juego, has perdido todas las vidas ☣");
                            System.out.println("USUARIO:"+nombre1);
                            System.out.println("PUNTEO:"+punteo);
                            System.out.println("VIDAS:"+vidas);
                            for (x = 0; x < 12; x++) {
                                for (y = 0; y < 12; y++) {
                                    System.out.print(tablerog[x][y]);
                                }
                                System.out.println();
                            }
                        }


                    }
                    salida=true;
                    break;

            }
            punteous[contador]=punteo;
            contador++;
            punteo=0;
            vidas=3;
        break;

        //historial de partidas

    case 2:
        System.out.println("-----------Historial de Partidas-----------");
        System.out.println("No.           Usuario            Punteo");
        int i=1;
        String espacios1="               ";
        for (int K=0;K<contador;K++){
            System.out.println(i+espacios1+nombres[K]+espacios1+punteous[K]);
            i++;


        }

             }

        } while (opc!=3);
        System.out.println("Hasta pronto ...");
    }
    // METODO QUE IMRPIME LAS PAREDES Y LAS TRAMPAS
    public static void partra(String luis[][],int m,int g,int f,String h){
        int paredx=1;
        int paredy=1;
        for (int x=1;x<=m;x++) {
            paredx = (int) (Math.random() * g) + 1;
            paredy = (int) (Math.random() * f) + 1;
            if (luis[paredx][paredy].equals("  ")) {
                luis[paredx][paredy] = h;
            } else{
                while (!luis[paredx][paredy].equals("  ")) {
                    paredx = (int) (Math.random() * g) + 1;
                    paredy = (int) (Math.random() * f) + 1;
                }
                luis[paredx][paredy]=h;
            }

        }

    }
    //FINALIZA LAS PAREDES Y LAS TRAMPAS

    //METODO QUE IMPRIME PREMIOS
    public static void premios(String luis[][],int m,int g,int f){
        int premiox=1;
        int premioy=1;
        int x=1;
        int l=1;
        for (x=1;x<=m;x++) {
            premiox = (int) (Math.random() * g) + 1;
            premioy = (int) (Math.random() * f) + 1;
            if (luis[premiox][premioy].equals("  ")) {
                l=(int) (Math.random()*2)+1;
                if (l==1) {
                    luis[premiox][premioy] = "0 ";
                }
                if (l==2){
                    luis[premiox][premioy] = "$ ";
                }
            } else{
                while (!luis[premiox][premioy].equals("  ")) {
                    premiox = (int) (Math.random() * 5) + 1;
                    premioy = (int) (Math.random() * 6) + 1;
                }
                l=(int) (Math.random()*2)+1;
                if (l==1) {
                    luis[premiox][premioy] = "0 ";
                }
                if (l==2){
                    luis[premiox][premioy] = "$ ";
                }
            }

        } // finalizar premios
    }

}

