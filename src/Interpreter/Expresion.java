package Interpreter;

import Interpreter.Entornos.Entorno;

public class Expresion {
    // Atributos de la clase
    private String valor;
    private String tipo;
    private int fila;
    private int columna;

    public static String[] TiposDatos = {"INT","DOUBLE","BOOL","CHAR","STRING", "ERROR"};

    public Expresion(String valor, String tipo, int fila, int columna) {
        this.valor = valor;
        this.tipo = tipo;
        this.fila = fila;
        this.columna = columna;
    }

    public Expresion interpretar(Entorno entorno) {
        return this;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
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
