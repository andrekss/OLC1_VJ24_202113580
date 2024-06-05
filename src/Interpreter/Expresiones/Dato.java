package Interpreter.Expresiones;

public class Dato extends Interpreter.Expresion {
    public Dato(Object valor, String tipo, int fila, int columna){
        super(valor, tipo, fila, columna);
    }
    
    @Override
    public Interpreter.Expresion interpretar(Object entorno) {
        // super.interpretar(entorno); 
        return this;
    }
    
}
