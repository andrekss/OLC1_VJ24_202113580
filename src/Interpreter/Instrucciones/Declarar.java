package Interpreter.Instrucciones;
import Interpreter.Expresion;
import Interpreter.Instruccion;
import Interpreter.Entornos.Entorno;

public class Declarar extends Instruccion {
    private Expresion expresion;
    private String Tipo;
    private String Identificador;

    public Declarar(Expresion expresion, String Tipo,String Identificador, int linea, int col) { 
        super(Instruccion.nombres[2], linea, col);
        this.expresion = expresion;
        this.Tipo = Tipo;
        this.Identificador = Identificador;
    }

    @Override
    public Instruccion interpretar(Entorno entorno) {
        this.expresion.interpretar(entorno);

        if(this.expresion.getTipo() != this.Tipo){
            System.out.println("Error semántico: Error de tipo de dato en declaracion de variable");
            return this;
        }

        //Agregamos la variable
        entorno.AgregarSimbolo(this.Identificador, this.expresion.getValor(), this.Tipo,Instruccion.nombres[2] , this.getFila(), this.getColumna());
        return this;

    }


    
}
