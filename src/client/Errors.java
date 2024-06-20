package client;

public class Errors {

    private String TipoError;
    private String Descripcion;
    private int Linea;
    private int Columna;

    public Errors(String TipoError, String Descripcion, int Linea, int Columna) {
        this.TipoError = TipoError;
        this.Descripcion = Descripcion;
        this.Linea = Linea;
        this.Columna = Columna;
    }

    // Getters
    public String getTipoError() {
        return TipoError;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public int getLinea() {
        return Linea;
    }

    public int getColumna() {
        return Columna;
    }

    // Setters
    public void setTipoError(String TipoError) {
        this.TipoError = TipoError;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setLinea(int Linea) {
        this.Linea = Linea;
    }

    public void setColumna(int Columna) {
        this.Columna = Columna;
    }
}
