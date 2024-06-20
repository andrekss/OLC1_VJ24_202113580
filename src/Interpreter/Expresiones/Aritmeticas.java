package Interpreter.Expresiones;

import Interpreter.Expresion;
import Interpreter.Entornos.Entorno;

public class Aritmeticas extends Expresion {
    private Expresion izq;
    private String Operacion;
    private Expresion der;

    public Aritmeticas(Expresion izq,String Operacion,Expresion der,int fila,int columna){
        super("ERROR", TiposDatos[5], fila, columna);
        this.izq = izq;
        this.der = der;
        this.Operacion = Operacion;
    }

    @Override
    public Expresion interpretar(Entorno entorno) {
        // Interpretamos los operadores
        this.izq.interpretar(entorno);
        this.der.interpretar(entorno);
        
        if (this.Operacion.equals( "+")){
            Funcs.Suma(this.izq, this.der,this);
        }else if (this.Operacion.equals("-")){
            Funcs.Resta(this.izq, this.der,this);
        }else if (this.Operacion.equals("*")){
            Funcs.Multiplicación(this.izq,this.der,this);
        }else if (this.Operacion.equals("/")){
            Funcs.Division(this.izq, this.der,this);
        }else if (this.Operacion.equals("%")){
            Funcs.Modulo(this.izq,  this.der,this);
        }else if (this.Operacion.equals("**")){
            Funcs.Potencia(this.izq, this.der,this);
        }
        return this;
    }
    
}