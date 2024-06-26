package Interpreter.Instrucciones;

import Interpreter.Expresion;
import Interpreter.Instruccion;
import Interpreter.Entornos.Entorno;

public class Structs extends Instruccion {

    public Structs(Expresion expresion, int linea, int col) {
        super(Instruccion.nombres[13], linea, col);
    }

    @Override
    public Instruccion interpretar(Entorno entorno) {
        
        return this;
    }

    
}
