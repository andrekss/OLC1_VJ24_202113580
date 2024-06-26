package Interpreter.Instrucciones;

import java.util.LinkedList;

import Interpreter.Expresion;
import Interpreter.Instruccion;
import Interpreter.Utils;
import Interpreter.Entornos.Entorno;

public class Listas extends Instruccion{
    private LinkedList<Expresion> Lista;              // Para Listaes de una dimension 
    private String Tipo;
    private String Identificador;
    private String Mutabilidad;
    
    public Listas( LinkedList<Expresion> Lista,String Tipo,String Identificador,int linea, int columna) {
        super(Instruccion.nombres[12], linea, columna);
        this.Lista = Lista;
        this.Tipo = Tipo;
        this.Identificador = Identificador;
        this.Mutabilidad = "VAR";
    }

    @Override
    public Instruccion interpretar(Entorno entorno) {

        for (Expresion expresion : this.Lista) {
              expresion.interpretar(entorno);
              if(!this.Tipo.equalsIgnoreCase(expresion.getTipo())){
                  Utils.ErroresSemánticosInstruccion(this,"Error de tipo de dato en declaracion de la lista. ");
              }
        }
        entorno.AgregarSimbolo(this.Identificador, this.Lista, this.Tipo,this.Mutabilidad,Instruccion.nombres[12] ,entorno.getNombre() ,this.getFila(), this.getColumna());

        return this;
    }

    
}
