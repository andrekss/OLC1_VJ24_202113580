package Interpreter.Entornos;

import java.util.TreeMap;
import java.util.function.Function;


public class Entorno {
    private String nombre;
    private Entorno Anterior;
    private TreeMap<String, Simbolo> TablaSimbolos;
    private TreeMap<String, Function<Entorno, Object>> functions;

    public Entorno(String nombre, Entorno Anterior) {
        this.nombre = nombre;
        this.Anterior = Anterior;
        this.TablaSimbolos = new TreeMap<>();
        this.functions = new TreeMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Entorno getAnterior() {
        return Anterior;
    }

    public void setAnterior(Entorno Anterior) {
        this.Anterior = Anterior;
    }

    public TreeMap<String, Simbolo> getTablaSimbolos() {
        return TablaSimbolos;
    }

    public void setTablaSimbolos(TreeMap<String, Simbolo> TablaSimbolos) {
        this.TablaSimbolos = TablaSimbolos;
    }

    public TreeMap<String, Function<Entorno, Object>> getFunctions() {
        return functions;
    }

    public void setFunctions(TreeMap<String, Function<Entorno, Object>> functions) {
        this.functions = functions;
    } 

}