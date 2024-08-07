package com.ejemplo.juegodecartas;

import java.util.Scanner;

public class JuegoConsola {
    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.crearMazo();
        juego.mezclarMazo();
        juego.crearPilas();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            juego.mostrarEstado();
            System.out.println("Ingrese el número de la pila de origen y destino (ej. 1 2): ");
            int origen = scanner.nextInt() - 1;
            int destino = scanner.nextInt() - 1;

            if (origen < 0 || origen >= 4 || destino < 0 || destino >= 4) {
                System.out.println("Movimiento inválido.");
                continue;
            }

            System.out.println("Ingrese el valor y palo de la carta (ej. 1 1 para As de Corazón): ");
            int valor = scanner.nextInt();
            int palo = scanner.nextInt();

            Carta carta = new Carta(valor, palo);
            if (!juego.moverCarta(carta, origen, destino)) {
                System.out.println("Movimiento inválido.");
            }

            juego.aplicarReglas();
        }
    }
}
