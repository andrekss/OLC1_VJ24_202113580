package Interpreter.Instrucciones;

import java.util.LinkedList;

import Interpreter.Expresion;
import Interpreter.Instruccion;
import Interpreter.Utils;
import Interpreter.Entornos.Entorno;

public class Append extends Instruccion {
    private Expresion expresion;
    private String Id;

    public Append(Expresion expresion,String Id,  int linea, int col) { 
        super(Instruccion.nombres[12], linea, col);
        this.expresion = expresion;
        this.Id = Id;
    }
    @Override
    public Instruccion interpretar(Entorno entorno) {

        this.expresion.interpretar(entorno);

        // Verificamos
        if(this.expresion.getTipo().equals(entorno.getTablaSimbolos().get(this.Id).getTipo())){
            LinkedList<Expresion> Listas=(LinkedList<Expresion>) entorno.getTablaSimbolos().get(this.Id).getValor();
            Listas.add(this.expresion);
            return this;
        }else{
            Utils.ErroresSemánticosInstruccion(this, "Este valor no es del tipo de la lista");
            return this;
        }
    }
    
    
}
