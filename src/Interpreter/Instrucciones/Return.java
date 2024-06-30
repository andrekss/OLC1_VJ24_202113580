package Interpreter.Instrucciones;

import Interpreter.Expresion;
import Interpreter.Instruccion;
import Interpreter.Entornos.Entorno;

public class Return extends Instruccion {
    private Expresion expresion;
    public Return( Expresion expresion,int linea, int col) {
        super(Instruccion.nombres[16], linea, col);
        this.expresion = expresion;
    }

    @Override
    public Instruccion interpretar(Entorno entorno) {
        this.expresion.interpretar(entorno);
        return this;
    }

    public Expresion getExpresion(){
        return expresion;
    }

    
}
