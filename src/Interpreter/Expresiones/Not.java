package Interpreter.Expresiones;
import Interpreter.Expresion;
import Interpreter.Utils;
import Interpreter.Entornos.Entorno;
import client.Errors;
import client.TextEditor;

public class Not extends Expresion{

    private Expresion Exp;
    public Not(String valor, String tipo, Expresion Exp,int fila, int columna){
        super(valor, tipo, fila, columna);
        this.Exp= Exp;
    }
    @Override
    public Expresion interpretar(Entorno entorno) {

        this.Exp.interpretar(entorno);

        if (this.Exp.getTipo().equals("BOOL")) {
            if (this.Exp.getValor().equalsIgnoreCase("true")){
                
             this.setValor("false");
             return this;
            }else{
                this.setValor("true");
                return this;
            } 
        } 
        //TextEditor.Print+="Error Semántico: Error en la operacion Not.";
                                        // Interfaz
        Utils.ErroresSemánticosExpresion(this,"Error en la operacion Not. ");                                       
        return this;
    }
}