package Interpreter.Instrucciones;
import Interpreter.*;
import Interpreter.Entornos.Entorno;
import Interpreter.Entornos.Simbolo;
import client.TextEditor;

import java.util.LinkedList;


public class Match extends Instruccion {

    private LinkedList<LinkedList<Instruccion>> Cases;
    private LinkedList<Expresion> Caso;
    private Expresion Comparación;
    private boolean Default;
    private boolean AvisoBreak;

    public Match(LinkedList<LinkedList<Instruccion>> Cases,LinkedList<Expresion> Caso,Expresion Comparación, int linea, int col) {
        super(Instruccion.nombres[8], linea, col);
        this.Cases = Cases;
        this.Comparación = Comparación;
        this.Caso = Caso;
        this.Default = true;
        this.AvisoBreak=false;
    }

    @Override
    public Instruccion interpretar(Entorno entorno) {
      
     
        this.Comparación.interpretar(entorno);
        Entorno Match_Entorno = new Entorno(Instruccion.nombres[8], entorno);
        int iteracion = 0; // Recorriendo los casos
        for (LinkedList<Instruccion> Case  : this.Cases) { // Primero recorremos los Casos ó ciclo principal
            Match_Entorno = new Entorno(Instruccion.nombres[8], entorno);
            Caso.get(iteracion).interpretar(Match_Entorno);
            
            
            if (Caso.get(iteracion).getValor().equals(this.Comparación.getValor()) ){
              //System.out.println("yeiiiiiiiiiiiiiiiiii");
              this.Default = false;
              for (Instruccion InstruccionCase : Case) { // Luego ya recorremos las instrucciones de los casos
                InstruccionCase.interpretar(Match_Entorno); 

                if(InstruccionCase.getTipo().equals("BREAK")){ // Rompemos las instrucciones y cambiamos su tipo
                  this.AvisoBreak = true;     
                  break;
                } 
                if(InstruccionCase.getTipo().equals("CONTINUE")){ // Rompemos las instrucciones y cambiamos su tipo
                    break; // detenemos las instrucciones pero el ciclo sigue
                }
                  return this;
                }
             
            }
            
            if (Caso.get(iteracion).getValor().equals("_")  && this.Default){  // nunca hace match entonces se ejecuta
              this.Default = false;
              for (Instruccion InstruccionCase : Case) { // Luego ya recorremos las instrucciones de los casos
                InstruccionCase.interpretar(Match_Entorno);
                return this;
              }
            }

            if(this.AvisoBreak){  // Rompemos ciclo principal
              this.AvisoBreak = false;
              break;
            }
            iteracion++;
            return this;
        }

        // Tabla de simbolos
        for (Simbolo Sym : Match_Entorno.getTablaSimbolos().values()) {
                TextEditor.TablaSimbolos.add(Sym);
        }
        return this;
    }
}
