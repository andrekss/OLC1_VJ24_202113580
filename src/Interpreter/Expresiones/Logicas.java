package Interpreter.Expresiones;

import Interpreter.Expresion;
import Interpreter.Entornos.Entorno;

public class Logicas extends  Expresion{
    private Expresion izq;
    private String Operacion;
    private Expresion der;

    public Logicas(Expresion izq,String Operacion,Expresion der,int fila,int columna){
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
        
        // no se pueden hacer con valores booleanos
        if (this.Operacion== "||"){
            Funciones.OperacionesLogicas(this.izq, this.Operacion, this.der, this,Boolean.parseBoolean(this.izq.getValor()) || Boolean.parseBoolean(this.der.getValor()));
        }else if (this.Operacion== "&&"){
            Funciones.OperacionesLogicas(this.izq, this.Operacion, this.der, this,Boolean.parseBoolean(this.izq.getValor()) && Boolean.parseBoolean(this.der.getValor()));
        }else if (this.Operacion== "^"){
            Funciones.OperacionesLogicas(this.izq, this.Operacion, this.der, this,Boolean.parseBoolean(this.izq.getValor()) ^ Boolean.parseBoolean(this.der.getValor()));
        }

        return this;
    }
    
}
