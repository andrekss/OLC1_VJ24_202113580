package Interpreter.Expresiones;
import Interpreter.Expresion;
import Interpreter.Entornos.Entorno;

public class Not extends Expresion{
    public Not(String valor, String tipo, int fila, int columna){
        super(valor, tipo, fila, columna);
    }
    @Override
    public Expresion interpretar(Entorno entorno) {
        if (this.getTipo().equals("BOOL")) {
            if (this.getValor().equalsIgnoreCase("true")){
             this.setValor("false");
             return this;
            }else{
                this.setValor("true");
                return this;
            } 
        } 
        System.out.println("Error Semántico: Error en la operacion Not.");
        return this;
    }
}
