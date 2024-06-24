package Interpreter.Instrucciones;

import java.util.LinkedList;

import Interpreter.Expresion;
import Interpreter.Instruccion;
import Interpreter.Entornos.Entorno;
import client.Errors;
import client.TextEditor;

public class Vectores extends Instruccion{

    private LinkedList<Expresion> Vector1;              // Para vectores de una dimension
    private LinkedList<LinkedList<Expresion>> Vector2; // Para vectores de dos dimensiones    
    private String Tipo;
    private String Identificador;
    private String Mutabilidad;
    
    public Vectores( LinkedList<Expresion> Vector1,LinkedList<LinkedList<Expresion>> Vector2,String Tipo,String Identificador,String Mutabilidad,int linea, int columna) {
        super(Instruccion.nombres[11], linea, columna);
        this.Vector1 = Vector1;
        this.Vector2= Vector2;
        this.Tipo = Tipo;
        this.Identificador = Identificador;
        this.Mutabilidad = Mutabilidad;
    }

    @Override
    public Instruccion interpretar(Entorno entorno) {
        if (this.Vector1 != null){   // Para vectores de una dimension
            // Errores e interpretación
            //System.out.println("--Vector--");
            for (Expresion expresion : this.Vector1) {
                expresion.interpretar(entorno);
               // System.out.println(expresion.getValor());
                if(!this.Tipo.equalsIgnoreCase(expresion.getTipo())){
                    Semántico(this);
                }
            }
            
            entorno.AgregarSimbolo(this.Identificador, this.Vector1, this.Tipo,this.Mutabilidad,Instruccion.nombres[11] ,entorno.getNombre() ,this.getFila(), this.getColumna());

            return this;
        }else if (this.Vector2 != null){ // Para vectores de dos dimensiones
            // Errores e interpretación
            //System.out.println("--Vector 2 dimensiones--");
            for (LinkedList<Expresion> Vector1: this.Vector2) {
                for (Expresion expresion : Vector1) {
                    expresion.interpretar(entorno);
                    //System.out.println(expresion.getValor());
                    if (!this.Tipo.equalsIgnoreCase(expresion.getTipo())) {
                        Semántico(this);
                    }
                    
                }
                //System.out.println("\n");   
            }

            entorno.AgregarSimbolo(this.Identificador, this.Vector1, this.Tipo,this.Mutabilidad,Instruccion.nombres[11] ,entorno.getNombre() ,this.getFila(), this.getColumna());
            return this;
        }
        return this;
    }

    public static void Semántico(Instruccion Object){
        System.out.println("Error semántico: Error de tipo de dato en declaracion del vector");

        // Interfaz
        Errors error = new Errors("Error semántico","Error de tipo de dato en declaracion del vector", Object.getFila(),Object.getColumna());
        TextEditor.Errores.add(error);
        TextEditor.Print+="Error semántico: Error de tipo de dato en declaracion del vector." + " | Fila:" +Object.getFila() + " | Columna: " + Object.getColumna()+"\n";
        
    }


}
