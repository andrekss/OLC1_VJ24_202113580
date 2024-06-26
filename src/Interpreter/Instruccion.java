package Interpreter;

import Interpreter.Entornos.Entorno;

public class Instruccion {

    private String tipo;
    private int fila;
    private int columna;
    public static String[] nombres = {"ERROR","PRINT","VARIABLE","ASIGNAR","INCREMENTODECREMENTO", "IF","FOR", "WHILE","MATCH","BREAK","CONTINUE", "VECTORES","LISTAS"};

    public Instruccion(String tipo, int fila, int columna) {
        this.tipo = tipo; // Tipo de instruccion
        this.fila = fila;
        this.columna = columna;
    }

    public Instruccion interpretar(Entorno entorno) {
        return this;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
}

