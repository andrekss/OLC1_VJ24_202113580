package Interpreter.Entornos;

public class Simbolo {

    private String nombre;
    private String valor;
    private String tipo;
    private String Mutabilidad;
    private String tipoSym;
    private String Entorno;
    private int fila;
    private int columna;

    public Simbolo(String nombre, String valor, String tipo,String Mutabilidad ,String tipoSym,String Entorno ,int fila, int columna) {
        this.nombre = nombre;
        this.valor = valor;
        this.tipo = tipo;
        this.Mutabilidad = Mutabilidad;
        this.tipoSym = tipoSym;
        this.Entorno = Entorno;
        this.fila = fila;
        this.columna = columna;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTipoSym() {
        return tipoSym;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public String getMutabilidad(){
        return Mutabilidad;
    }

    public String getEntorno(){
        return Entorno;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTipoSym(String tipoSym) {
        this.tipoSym = tipoSym;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setMutabilidad(String Mutabilidad){
        this.Mutabilidad = Mutabilidad;

    }
    public void setEntorno(String Entorno){
        this.Entorno = Entorno;
    }
}
