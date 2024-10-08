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
        if (movimientosEnTurno >= 3) {
            System.out.println("No puedes mover más de 3 cartas por turno.");
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
        // Reiniciar el contador de movimientos al comienzo de cada turno
        movimientosEnTurno = 0;
    }

    public void mostrarEstado() {
        for (int i = 0; i < pilas.size(); i++) {
            System.out.println("Pila " + (i + 1) + ": " + pilas.get(i));
        }
    }

    public int calcularPuntaje(List<Carta> pila) {
        int puntaje = 0;
        for (Carta carta : pila) {
            puntaje += carta.getValor();
        }
        return puntaje;
    }

    public String verificarEstadoJuego(List<Carta> pila) {
        int puntaje = calcularPuntaje(pila);
        if (puntaje == 21) {
            return "¡Felicidades! Has ganado con un puntaje de 21.";
        } else if (puntaje > 21) {
            return "Has perdido. Tu puntaje es " + puntaje + " y se pasó de 21.";
        } else {
            return "Tu puntaje actual es " + puntaje + ".";
        }
    }

    public List<List<Carta>> getPilas() {
        return pilas;
    }
}

