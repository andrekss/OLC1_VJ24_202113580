package Interpreter.Expresiones;
import Interpreter.Expresion;
import Interpreter.Entornos.Entorno;

public class Dato extends Expresion {
    public Dato(String valor, String tipo, int fila, int columna){
        super(valor, tipo, fila, columna);
    }
    
    @Override
    public Expresion interpretar(Entorno entorno) {
        this.setValor(Funcs.eliminarComillas(this.getValor()));
        // super.interpretar(entorno); 
        return this;
    }
    
}
