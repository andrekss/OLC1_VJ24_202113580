package Interpreter.Instrucciones;
import Interpreter.Expresion;
import Interpreter.Instruccion;
import Interpreter.Entornos.Entorno;
import Interpreter.Entornos.Simbolo;
import client.*;

import java.util.LinkedList;

public class While extends Instruccion {
    private Expresion Condicion;
    private LinkedList<Instruccion> Sentencia_Entorno;
    private String TipoWhile;
    public boolean AvisoBreak ;

    public While(Expresion Condicion,LinkedList<Instruccion> Sentencia_Entorno,String TipoWhile, int linea, int col) {
        super(Instruccion.nombres[7], linea, col);
        this.Condicion = Condicion;
        this.Sentencia_Entorno = Sentencia_Entorno;
        this.TipoWhile = TipoWhile;
        this.AvisoBreak = false;
    }

    @Override
    public Instruccion interpretar(Entorno entorno) {
        this.Condicion.interpretar(entorno);
        Entorno While_Entorno;
        while (true) { // Ciclo principal
            While_Entorno = new Entorno(Instruccion.nombres[7], entorno);
            if (this.Condicion.getValor().equalsIgnoreCase("false") && this.TipoWhile.equals("While")){
                break;
            }
            
            
            String Tipo;
                
            for ( Instruccion instruccion : this.Sentencia_Entorno) {
                   instruccion.interpretar(While_Entorno);
                   Tipo = instruccion.getTipo();
                   if(instruccion.getTipo().equals("BREAK")){ //Rompemos las instrucciones
                    this.AvisoBreak = true;
                    instruccion.setTipo(Tipo);
                    //this.setTipo("BREAK");
                         
                    break;
                } 
                if(instruccion.getTipo().equals("CONTINUE")){ // Rompemos a las instrucciones pero el ciclo principal sigue
                   instruccion.setTipo(Tipo); 
                   break; // detenemos las instrucciones pero el ciclo sigue
                } 
                  
            }
            if (AvisoBreak){ // Rompemos el ciclo principal
                this.AvisoBreak = false; 
                break;
            }
            this.Condicion.interpretar(entorno); // Actualizamos la condicion
            
            if (this.Condicion.getValor().equalsIgnoreCase("false") && this.TipoWhile.equals("Do")){
                break;
            }

        }

            for (Simbolo Sym : While_Entorno.getTablaSimbolos().values()) {
                TextEditor.TablaSimbolos.add(Sym);
            }
        return this;
        
    }
    
}
