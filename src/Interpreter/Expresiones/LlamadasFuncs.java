package Interpreter.Expresiones;

import java.util.LinkedList;

import Interpreter.Expresion;
import Interpreter.Instruccion;
import Interpreter.Utils;
import Interpreter.Entornos.Atributo;
import Interpreter.Entornos.Entorno;
import Interpreter.Entornos.MetodosList;
import Interpreter.Instrucciones.Declarar;
import Interpreter.Instrucciones.Return;

public class LlamadasFuncs extends Expresion {
    
    private LinkedList<Expresion> Parámetros_Def;
    private String ID;
    
    public LlamadasFuncs(LinkedList<Expresion> Parámetros_Def,String ID, int fila, int columna){
        super("ERROR", TiposDatos[5], fila, columna);

    }

    @Override
    public Expresion interpretar(Entorno entorno) {
        for ( MetodosList Metodo : Utils.MetodosFuncs) {
            if (Metodo.getId().equals(this.ID)) { // Encontró el método
                if(Metodo.getTipo().equals("FUNCIONES")){
                 EjecutarFunción(entorno,Metodo.getInstrucciones(), Metodo.getParametros());
                }else{
                    System.out.println("Esta no es una función. ");
                }
                break;
            } 
        }

        Utils.ReporteSyms(entorno);
        return this;
    }

        public void EjecutarFunción(Entorno entorno,LinkedList<Instruccion> Instruccion, LinkedList<Atributo> parametros){
        
        if(parametros.size() != this.Parámetros_Def.size()){
            Utils.ErroresSemánticosExpresion(this, "Hay un parámetro extra o menos en el método. ");  
        }else if (parametros.size() == this.Parámetros_Def.size()) {
            for (int i = 0; i < parametros.size(); i++) { // Recorrer parámetros del método
                if(parametros.get(i).getTipo().equals(this.Parámetros_Def.get(i).getTipo())){ 
                    Declarar variable = new Declarar(this.Parámetros_Def.get(i),parametros.get(i).getTipo(), parametros.get(i).getId(),"VAR",this.getFila(),this.getColumna());                
                    variable.interpretar(entorno);
                }else{
                    Utils.ErroresSemánticosExpresion(this, "El dato parámetro no tiene el tipo de dato de la función. ");
                }
            }

        
            for (Instruccion instruccion : Instruccion) {
                if (instruccion.getTipo().equals("RETURN")){
                    Return retornable = (Return) instruccion.interpretar(entorno);
                    this.setValor(retornable.getExpresion().getValor());
                    this.setTipo(retornable.getExpresion().getTipo());
                    break;   
                }
                instruccion.interpretar(entorno);                    
            }


        }

    }
}
