package com.ejemplo.juegodecartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Juego {
    private List<Carta> mazo;
    private List<List<Carta>> pilas;

    public Juego() {
        mazo = new ArrayList<>();
        pilas = new ArrayList<>();
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
        List<Carta> origen = pilas.get(pilaOrigen);
        List<Carta> destino = pilas.get(pilaDestino);

        if (origen.stream().count()>0)
        {
            origen.remove(carta);
            destino.add(carta);
            return true;
        }
        else if (origen.stream().count() == 0)
        {
            destino.add(carta);
            return true;
        }
        return false;
    }

    public void aplicarReglas() {
        // Reglas del juego (por ejemplo, mover cartas solo a pilas de mayor valor)
    }

    public void mostrarEstado() {
        for (int i = 0; i < pilas.size(); i++) {
            System.out.println("Pila " + (i + 1) + ": " + pilas.get(i));
        }
    }
}
