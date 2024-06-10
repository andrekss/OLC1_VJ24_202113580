package Interpreter.Expresiones;

import Interpreter.Entornos.Entorno;

public class Dato extends Interpreter.Expresion {
    public Dato(String valor, String tipo, int fila, int columna){
        super(valor, tipo, fila, columna);
    }
    
    @Override
    public Interpreter.Expresion interpretar(Entorno entorno) {
        this.setValor(Funciones.eliminarComillas(this.getValor()));
        // super.interpretar(entorno); 
        return this;
    }
    
}
