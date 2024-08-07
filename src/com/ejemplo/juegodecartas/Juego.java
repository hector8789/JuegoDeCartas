package com.ejemplo.juegodecartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Juego {
    private List<Carta> mazo;
    private List<List<Carta>> pilas;
    private int movimientosEnTurno;

    public Juego() {
        mazo = new ArrayList<>();
        pilas = new ArrayList<>();
        movimientosEnTurno = 0;
    }

    public void crearMazo() {
        for (int palo = 1; palo <= 4; palo++) {
            for (int valor = 1; valor <= 13; valor++) {
                mazo.add(new Carta(valor, palo));
            }
        }
    }

    public void mezclarMazo() {
        Collections.shuffle(mazo);
    }

    public void crearPilas() {
        for (int i = 0; i < 4; i++) {
            pilas.add(new ArrayList<>());
        }
    }

    public boolean moverCarta(Carta carta, int pilaOrigen, int pilaDestino) {
        if (movimientosEnTurno >= 2) {
            System.out.println("No puedes mover más de 2 cartas por turno.");
            return false;
        }

        List<Carta> origen = pilas.get(pilaOrigen);
        List<Carta> destino = pilas.get(pilaDestino);

        if (origen.remove(carta)) {
            destino.add(carta);
            movimientosEnTurno++;
            return true;
        }
        return false;
    }

    public void aplicarReglas() {
        // Reglas del juego (por ejemplo, mover cartas solo a pilas de mayor valor)
        // Reiniciar el contador de movimientos al comienzo de cada turno
        movimientosEnTurno = 0;
    }

    public void mostrarEstado() {
        for (int i = 0; i < pilas.size(); i++) {
            System.out.println("Pila " + (i + 1) + ": " + pilas.get(i));
        }
    }
}
