package Interpreter.Entornos;

import java.util.LinkedList;
import Interpreter.Instruccion;

public class MetodosList {

    private String Id;
    private LinkedList<Atributo> parametros;
    private LinkedList<Instruccion> Instrucciones;

    public MetodosList(String Id, LinkedList<Atributo> parametros, LinkedList<Instruccion> Instrucciones){
        this.Id = Id;
        this.parametros = parametros;
        this.Instrucciones = Instrucciones;
    }

    // Getters
    public String getId() {
        return Id;
    }

    public LinkedList<Atributo> getParametros() {
        return parametros;
    }

    public LinkedList<Instruccion> getInstrucciones() {
        return Instrucciones;
    }

    // Setters
    public void setId(String Id) {
        this.Id = Id;
    }

    public void setParametros(LinkedList<Atributo> parametros) {
        this.parametros = parametros;
    }

    public void setInstrucciones(LinkedList<Instruccion> Instrucciones) {
        this.Instrucciones = Instrucciones;
    }
}
