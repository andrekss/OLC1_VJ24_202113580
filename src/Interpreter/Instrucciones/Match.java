package Interpreter.Instrucciones;
import Interpreter.*;
import Interpreter.Entornos.Entorno;

import java.util.LinkedList;


public class Match extends Instruccion {

    private LinkedList<LinkedList<Instruccion>> Cases;
    private LinkedList<Expresion> Caso;
    private Expresion Comparación;

    public Match(LinkedList<LinkedList<Instruccion>> Cases,LinkedList<Expresion> Caso,Expresion Comparación, int linea, int col) {
        super(Instruccion.nombres[8], linea, col);
        this.Cases = Cases;
        this.Comparación = Comparación;
        this.Caso = Caso;
    }

    @Override
    public Instruccion interpretar(Entorno entorno) {
        this.Comparación.interpretar(entorno);
        System.out.println("asdesadass");
        Entorno Match_Entorno = new Entorno(Instruccion.nombres[8], entorno);
        int iteracion = 0;
        for (LinkedList<Instruccion> Case  : this.Cases) { // Primero recorremos los Caso
            Caso.get(iteracion).interpretar(Match_Entorno);
            
            
            if (Caso.get(iteracion).getValor().equalsIgnoreCase(this.Comparación.getValor()) || Caso.get(iteracion).getValor().equals("_")){
              for (Instruccion InstruccionCase : Case) { // Luego ya recorremos las instrucciones de los casos
                InstruccionCase.interpretar(Match_Entorno);
                return this;
              }
            }  
            iteracion++;
            return this;
        }
        return this;
    }
}
