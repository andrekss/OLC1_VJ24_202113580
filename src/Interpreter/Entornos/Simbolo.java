package Interpreter.Entornos;

public class Simbolo {

    private String nombre;
    private Object valor;
    private String tipo;
    private String tipoVar;
    private int fila;
    private int columna;

    public Simbolo(String nombre, Object valor, String tipo, String tipoVar, int fila, int columna) {
        this.nombre = nombre;
        this.valor = valor;
        this.tipo = tipo;
        this.tipoVar = tipoVar;
        this.fila = fila;
        this.columna = columna;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public Object getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTipoVar() {
        return tipoVar;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTipoVar(String tipoVar) {
        this.tipoVar = tipoVar;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
}
