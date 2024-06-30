package Interpreter.Instrucciones;

import java.util.LinkedList;

import Interpreter.Instruccion;
import Interpreter.Utils;
import Interpreter.Entornos.Atributo;
import Interpreter.Entornos.Def_Atributo;
import Interpreter.Entornos.Entorno;

public class Instanciar_Struct extends Instruccion{


    private String Mutabilidad;
    private String Id;
    private String TipoStruct;
    private LinkedList<Def_Atributo> AtributosDefinidos;
    
    public Instanciar_Struct(String Mutabilidad,String Id,String TipoStruct, LinkedList<Def_Atributo> AtributosDefinidos,int linea, int col){
        super(Instruccion.nombres[13], linea, col);
        this.Mutabilidad = Mutabilidad;
        this.Id = Id;
        this.TipoStruct = TipoStruct;
        this.AtributosDefinidos = AtributosDefinidos;
    }
    
    @Override
    public Instruccion interpretar(Entorno entorno) {

        if (!Utils.StructsDefinidos.containsKey(this.TipoStruct)){
            Utils.ErroresSemánticosInstruccion(this, "Este struct no existe. ");
            return this;
        }
        
        for (Atributo Atributo : Utils.StructsDefinidos.get(this.TipoStruct)) { // Definición de structs
            boolean avisoEntrada = true;
            for (Def_Atributo Definición : this.AtributosDefinidos) { // Definición de structs
            
                Definición.getExpresion().interpretar(entorno);                  
                if(Atributo.getId().equals(Definición.getId())){ // Match con nombre
                    if(!Atributo.getTipo().equals(Definición.getExpresion().getTipo())){
                        Utils.ErroresSemánticosInstruccion(this, "hay una definición con un tipo de dato fuera del struct. ");
                    }
                    avisoEntrada = false;
                }

            }
            if(avisoEntrada){ // Nunca hizo match
                Utils.ErroresSemánticosInstruccion(this, "Este atributo no existe en el struct. ");
            }
        }
        
        entorno.AgregarSimbolo(this.Id, this.AtributosDefinidos, this.TipoStruct, this.Mutabilidad, Instruccion.nombres[2], entorno.getNombre(), this.getFila(), this.getColumna());
        

        return this;
    }
}
