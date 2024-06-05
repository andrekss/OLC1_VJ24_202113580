package Interpreter;

public class Expresion {
    // Atributos de la clase
    private Object valor;
    private String tipo;
    private int fila;
    private int columna;

    public static String[] TiposDatos = {"INT","DOUBLE","BOOL","CHAR","STRING"};

    public Expresion(Object valor, String tipo, int fila, int columna) {
        this.valor = valor;
        this.tipo = tipo;
        this.fila = fila;
        this.columna = columna;
    }

    public Expresion interpretar(Object entorno) {
        return this;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
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
