package Interpreter.Instrucciones;

import Interpreter.Expresion;
import Interpreter.Instruccion;
import Interpreter.Utils;
import Interpreter.Entornos.Atributo;
import Interpreter.Entornos.Entorno;
import Interpreter.Entornos.MetodosList;

import java.util.LinkedList;

public class Llamadas extends Instruccion{
    private LinkedList<Expresion> Parámetros_Def;
    private String ID;
    private String TipoLlamada;

    public Llamadas(LinkedList<Expresion> Parámetros_Def,String ID,String TipoLlamada, int linea, int col) {
        super(Instruccion.nombres[15], linea, col);
        this.Parámetros_Def = Parámetros_Def;
        this.ID = ID;
        this.TipoLlamada = TipoLlamada;
    }

    @Override
    public Instruccion interpretar(Entorno entorno) {

        /*
        // Interpretamos los parámetros
        for (int i = 0; i < Parámetros_Def.size(); i++) {
            this.Parámetros_Def.set(i, this.Parámetros_Def.get(i).interpretar(entorno));
        }
        */


        for ( MetodosList Metodo : Utils.Metodos) {
            if (Metodo.getId().equals(this.ID)) { // Encontró el método
                EjecutarMétodo(entorno,Metodo.getInstrucciones(), Metodo.getParametros());
                break;
            } 
        }

        

        Utils.ReporteSyms(entorno);
        return this;
    }

    public void EjecutarMétodo(Entorno entorno,LinkedList<Instruccion> Instruccion, LinkedList<Atributo> parametros){
        
        if(parametros.size() != this.Parámetros_Def.size()){
            Utils.ErroresSemánticosInstruccion(this, "Hay un parámetro extra o menos en el método. ");  
        }else if (parametros.size() == this.Parámetros_Def.size()) {
            for (int i = 0; i < parametros.size(); i++) { // Recorrer parámetros del método
                if(parametros.get(i).getTipo().equals(this.Parámetros_Def.get(i).getTipo())){ 
                    Declarar variable = new Declarar(this.Parámetros_Def.get(i),parametros.get(i).getTipo(), parametros.get(i).getId(),"VAR",this.getFila(),this.getColumna());                
                    variable.interpretar(entorno);
                }else{
                    Utils.ErroresSemánticosInstruccion(this, "El dato parámetro no tiene el tipo de dato del método. ");
                }
            }

            
            Entorno Global ;
            if (this.TipoLlamada.equals("ST")){  // Para start_with

                Global = new Entorno("Main", entorno);
                this.setTipo("START_WITH");
            }else{
                Global = entorno;
            }

            for (Instruccion instruccion : Instruccion) {
                instruccion.interpretar(Global);                    
            }


        }

    }

    
}
