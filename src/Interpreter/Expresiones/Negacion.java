package Interpreter.Expresiones;
import Interpreter.Entornos.Entorno;

public class Negacion extends Interpreter.Expresion {


    public Negacion(String valor, String tipo, int fila, int columna){
        super(valor, tipo, fila, columna);
    }

    @Override
    public Interpreter.Expresion interpretar(Entorno entorno) {
        if (this.getTipo()=="INT") {
            this.setValor(String.valueOf(-1 * Integer.parseInt(this.getValor())));
            return this;
        } else if (this.getTipo()=="DOUBLE"){
            this.setValor(String.valueOf(-1 * Double.parseDouble(this.getValor())));
            return this;
        }
        System.out.println("Error Semántico: Error en la operacion negativo.");
        return this;
        
    }
}
