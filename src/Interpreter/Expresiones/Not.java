package Interpreter.Expresiones;
import Interpreter.Expresion;
import Interpreter.Entornos.Entorno;

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
        System.out.println("Error Semántico: Error en la operacion Not.");
        return this;
    }
}