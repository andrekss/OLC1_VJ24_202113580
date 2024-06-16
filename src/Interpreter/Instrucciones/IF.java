package Interpreter.Instrucciones;

import java.util.LinkedList;

import Interpreter.Expresion;
import Interpreter.Instruccion;
import Interpreter.Entornos.Entorno;

public class IF extends Instruccion{
        private Expresion Condicion;
        private LinkedList<Instruccion> Sentencia_Entorno;
        private LinkedList<Instruccion> Sentencia_Entorno_Else;
        private Instruccion Else_If;

    public IF(Expresion Condicion, LinkedList<Instruccion> Sentencia_Entorno,LinkedList<Instruccion> Sentencia_Entorno_Else,Instruccion Else_If,int linea, int col) {
        super(Instruccion.nombres[5], linea, col);
        this.Condicion = Condicion;
        this.Sentencia_Entorno = Sentencia_Entorno;
        this.Sentencia_Entorno_Else = Sentencia_Entorno_Else;
        this.Else_If = Else_If;
    }

    @Override
    public Instruccion interpretar(Entorno entorno) {
        this.Condicion.interpretar(entorno);

        if (this.Else_If !=null && this.Condicion.getValor().equalsIgnoreCase("false")){
            this.Else_If.interpretar(entorno);   // 
        }else{
        

            if (this.Condicion.getTipo() !="BOOL"){
                System.out.println("Error Semántico: la condicion del if debe ser tipo boolean");
                return this;
            }
    
            if (this.Condicion.getValor().equalsIgnoreCase("true")){
                Entorno if_Entorno = new Entorno(Instruccion.nombres[5], entorno);
                
             for ( Instruccion instruccion : this.Sentencia_Entorno) {
                    instruccion.interpretar(if_Entorno);
                    if(instruccion.getTipo().equals("BREAK")){
                        this.setTipo("BREAK");
                             
                        break;
                    } 
                    if(instruccion.getTipo().equals("CONTINUE")){
                        this.setTipo("CONTINUE");
                        break; // detenemos las instrucciones pero el ciclo sigue
                    }                     
                    
             }
                return this;
            }else if (this.Sentencia_Entorno_Else != null){
    
                Entorno if_Entorno = new Entorno(Instruccion.nombres[5], entorno);
                
                for ( Instruccion instruccion : this.Sentencia_Entorno_Else) {
                       instruccion.interpretar(if_Entorno);
                }
                   return this;
            }
        }
        return this;
    }
    
}
