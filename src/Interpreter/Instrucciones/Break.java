package Interpreter.Instrucciones;

import Interpreter.Instruccion;
import Interpreter.Entornos.Entorno;

public class Break extends Instruccion {
        

    public Break( int linea, int col) {
        super(Instruccion.nombres[9], linea, col);
    }
    
    @Override
    public Instruccion interpretar(Entorno entorno) {
        return this;
    }
}
