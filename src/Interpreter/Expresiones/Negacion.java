package Interpreter.Expresiones;
import Interpreter.Entornos.Entorno;
import client.Errors;
import client.TextEditor;
import Interpreter.Expresion;
import Interpreter.Utils;

public class Negacion extends Expresion {

    private Expresion Exp;
    public Negacion(String valor, String tipo,Expresion Exp, int fila, int columna){
        super(valor, tipo, fila, columna);
        this.Exp = Exp;
    }

    @Override
    public Expresion interpretar(Entorno entorno) {

        // Interpretación de la expresión
        this.Exp.interpretar(entorno);
        this.setValor(this.Exp.getValor());
        this.setTipo(this.Exp.getTipo());

        if (this.Exp.getTipo().equals("INT")) {
            this.setValor(String.valueOf(-1 * Integer.parseInt(this.Exp.getValor())));
            return this;
        } else if (this.Exp.getTipo().equals("DOUBLE")){
            this.setValor(String.valueOf(-1 * Double.parseDouble(this.Exp.getValor())));
            return this;
        }

        Utils.ErroresSemánticosExpresion(this,"Error en la operacion negativo. ");
        return this;
        
    }
}
