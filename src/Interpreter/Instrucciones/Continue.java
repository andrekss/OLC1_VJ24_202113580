package Interpreter.Instrucciones;

import Interpreter.Instruccion;
import Interpreter.Entornos.Entorno;

public class Continue extends Instruccion {
        

    public Continue( int linea, int col) {
        super(Instruccion.nombres[10], linea, col);
    }
    
    @Override
    public Instruccion interpretar(Entorno entorno) {
        return this;
    }
}
