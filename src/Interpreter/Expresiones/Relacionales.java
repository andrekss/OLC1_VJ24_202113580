package Interpreter.Expresiones;

import Interpreter.Expresion;
import Interpreter.Entornos.Entorno;


public class Relacionales extends  Expresion{
        private Expresion izq;
    private String Operacion;
    private Expresion der;

    public Relacionales(Expresion izq,String Operacion,Expresion der,int fila,int columna){
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
        if (this.Operacion== "=="){
            try {
                
                Funciones.Relacionar(this.izq, this.Operacion, this.der,this, izq.getValor().equalsIgnoreCase(der.getValor()),izq.getValor().charAt(0)==Integer.parseInt(der.getValor()), Integer.parseInt(izq.getValor())==der.getValor().charAt(0));
            } catch (Exception e) {
                Funciones.RelacionarBoolean(this.izq, this.Operacion, this.der,this, izq.getValor().equalsIgnoreCase(der.getValor()));
            }
           
        }else if (this.Operacion== "!="){
            try {
                Funciones.Relacionar(this.izq, this.Operacion, this.der,this, !izq.getValor().equalsIgnoreCase(der.getValor()),izq.getValor().charAt(0)!=Integer.parseInt(der.getValor()), Integer.parseInt(izq.getValor())!=der.getValor().charAt(0));
            } catch (Exception e) {
                Funciones.RelacionarBoolean(this.izq, this.Operacion, this.der,this, !izq.getValor().equalsIgnoreCase(der.getValor()));
            }
        }else if (this.Operacion== "<"){
            try {
                Funciones.Relacionar(this.izq, this.Operacion, this.der,this, izq.getValor().length()<der.getValor().length(),izq.getValor().charAt(0)<Integer.parseInt(der.getValor()), Integer.parseInt(izq.getValor())<der.getValor().charAt(0));
            } catch (Exception e) {
                Funciones.RelacionarBoolean(this.izq, this.Operacion, this.der,this, izq.getValor().length()<der.getValor().length());
            }

        }else if (this.Operacion== "<="){
            try {
                Funciones.Relacionar(this.izq, this.Operacion, this.der,this, izq.getValor().length()<=der.getValor().length(),izq.getValor().charAt(0)<Integer.parseInt(der.getValor()), Integer.parseInt(izq.getValor())<=der.getValor().charAt(0));
            } catch (Exception e) {
                Funciones.RelacionarBoolean(this.izq, this.Operacion, this.der,this, izq.getValor().length()<=der.getValor().length());
            }
            
        }else if (this.Operacion== ">"){
            try {
                Funciones.Relacionar(this.izq, this.Operacion, this.der,this, izq.getValor().length()>der.getValor().length(),izq.getValor().charAt(0)<Integer.parseInt(der.getValor()), Integer.parseInt(izq.getValor())>der.getValor().charAt(0));
            } catch (Exception e) {
                Funciones.RelacionarBoolean(this.izq, this.Operacion, this.der,this, izq.getValor().length()>der.getValor().length());
            }
            
        }else if (this.Operacion== ">="){
            try {
                Funciones.Relacionar(this.izq, this.Operacion, this.der,this, izq.getValor().length()>=der.getValor().length(),izq.getValor().charAt(0)<Integer.parseInt(der.getValor()), Integer.parseInt(izq.getValor())>=der.getValor().charAt(0));
            } catch (Exception e) {
                Funciones.RelacionarBoolean(this.izq, this.Operacion, this.der,this, izq.getValor().length()>=der.getValor().length());
            }
           
        }
        return this;
    }
    
}
