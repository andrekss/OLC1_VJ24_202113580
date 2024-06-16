package Interpreter.Instrucciones;
import Interpreter.Expresion;
import Interpreter.Instruccion;
import Interpreter.Entornos.Entorno;

public class Declarar extends Instruccion {
    private Expresion expresion;
    private String Tipo;
    private String Identificador;
    private String Mutabilidad;

    public Declarar(Expresion expresion, String Tipo,String Identificador, String Mutabilidad, int linea, int col) { 
        super(Instruccion.nombres[2], linea, col);
        this.expresion = expresion;
        this.Tipo = Tipo;
        this.Identificador = Identificador;
        this.Mutabilidad = Mutabilidad;
    }

    @Override
    public Instruccion interpretar(Entorno entorno) {
        this.expresion.interpretar(entorno);
        if (this.expresion != null){
         this.expresion.interpretar(entorno);
         if(this.expresion.getTipo() != this.Tipo){
             System.out.println("Error semántico: Error de tipo de dato en declaracion de variable");
             return this;
         }
         //Agregamos la variable
         entorno.AgregarSimbolo(this.Identificador, this.expresion.getValor(), this.Tipo,this.Mutabilidad,Instruccion.nombres[2] ,entorno.getNombre() ,this.getFila(), this.getColumna());
         return this;
        }else{ // valores por defecto
            if (this.Tipo.equalsIgnoreCase("int")){
                entorno.AgregarSimbolo(this.Identificador, "0", this.Tipo,this.Mutabilidad,Instruccion.nombres[2] ,entorno.getNombre() , this.getFila(), this.getColumna());
                return this;
            }else if (this.Tipo.equalsIgnoreCase("double")){
                entorno.AgregarSimbolo(this.Identificador, "0.0", this.Tipo,this.Mutabilidad,Instruccion.nombres[2] ,entorno.getNombre() , this.getFila(), this.getColumna());
                return this;
            }else if (this.Tipo.equalsIgnoreCase("bool")){
               
                entorno.AgregarSimbolo(this.Identificador, "true", this.Tipo,this.Mutabilidad,Instruccion.nombres[2] ,entorno.getNombre() , this.getFila(), this.getColumna());
                return this;
            } else if (this.Tipo.equalsIgnoreCase("char")){
                entorno.AgregarSimbolo(this.Identificador, "0", this.Tipo,this.Mutabilidad,Instruccion.nombres[2] ,entorno.getNombre() , this.getFila(), this.getColumna());
                return this;
            } else if (this.Tipo.equalsIgnoreCase("string")){
                entorno.AgregarSimbolo(this.Identificador, "", this.Tipo,this.Mutabilidad,Instruccion.nombres[2] ,entorno.getNombre() , this.getFila(), this.getColumna());
                return this;
            }
        } 
        return this;

    }


    
}
