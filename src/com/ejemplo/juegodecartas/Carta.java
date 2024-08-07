package com.ejemplo.juegodecartas;

public class Carta {
    private int valor;
    private int palo;

    public Carta(int valor, int palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getPalo() {
        return palo;
    }

    public void setPalo(int palo) {
        this.palo = palo;
    }

    @Override
    public String toString() {
        String[] palos = {"Corazón", "Diamante", "Trébol", "Espada"};
        return valor + " de " + palos[palo - 1];
    }
}
