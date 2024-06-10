package Interpreter.Expresiones;

import Interpreter.Expresion;
import Interpreter.Entornos.Entorno;

public class Aritmeticas extends Interpreter.Expresion {
    private Expresion izq;
    private String Operacion;
    private Expresion der;
    private int fila;
    private int columna;  

    public Aritmeticas(Expresion izq,String Operacion,Expresion der,int fila,int columna){
        super("ERROR", TiposDatos[5], fila, columna);
        this.izq = izq;
        this.der = der;
        this.Operacion = Operacion;
    }

    @Override
    public Interpreter.Expresion interpretar(Entorno entorno) {
        // Interpretamos los operadores
        this.izq.interpretar(entorno);
        this.der.interpretar(entorno);
        
        if (this.Operacion== "+"){
            Funciones.Suma(this.izq, this.Operacion, this.der,this);
        }else if (this.Operacion== "-"){
            Funciones.Resta(this.izq, this.Operacion, this.der,this);
        }else if (this.Operacion== "*"){
            Funciones.Multiplicación(this.izq, this.Operacion, this.der,this);
        }else if (this.Operacion== "/"){
            Funciones.Division(this.izq, this.Operacion, this.der,this);
        }else if (this.Operacion== "%"){
            Funciones.Modulo(this.izq, this.Operacion, this.der,this);
        }else if (this.Operacion== "**"){
            Funciones.Potencia(this.izq, this.Operacion, this.der,this);
        }
        return this;
    }
    
}