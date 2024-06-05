package Interpreter;

class Instruccion {

    private String tipo;
    private int fila;
    private int columna;
    public static String[] nombres = {"PRINT"};

    public Instruccion(String tipo, int fila, int columna) {
        this.tipo = tipo; // Tipo de instruccion
        this.fila = fila;
        this.columna = columna;
    }

    public void interpretar() {}

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
