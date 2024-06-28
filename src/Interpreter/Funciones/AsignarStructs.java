package Interpreter.Funciones;

import java.util.LinkedList;

import Interpreter.Expresion;
import Interpreter.Instruccion;
import Interpreter.Utils;
import Interpreter.Entornos.Def_Atributo;
import Interpreter.Entornos.Entorno;

public class AsignarStructs extends Instruccion{
    private String Id;
    private String Atributo;
    private Expresion expresion;

    public AsignarStructs(String Id,String Atributo ,Expresion expresion,int linea, int col) {
        super(Instruccion.nombres[13], linea, col);
        this.expresion = expresion;
        this.Id = Id;
        this.Atributo = Atributo;
    }

    @Override
    public Instruccion interpretar(Entorno entorno) {
        
        if(!entorno.getTablaSimbolos().containsKey(this.Id)){
            Utils.ErroresSemánticosInstruccion(this, "Este struct no existe. ");
            return this;
        }
        this.expresion.interpretar(entorno);

        LinkedList<Def_Atributo> ListaStructsDef = (LinkedList<Def_Atributo>) entorno.getTablaSimbolos().get(this.Id).getValor();

        if (entorno.getTablaSimbolos().get(this.Id).getMutabilidad().equals("VAR")){
            for (Def_Atributo def_Atributo : ListaStructsDef) { // Definicón id y expresion
                if(def_Atributo.getId().equals(this.Atributo)){  // Encontramos el match con el atributo
    
                    if (def_Atributo.getExpresion().getTipo().equals(expresion.getTipo())){ // Verificamos que sea del mismo tipo
                     def_Atributo.getExpresion().setValor(expresion.getValor());
                     
                     break;
                    }else{
                        Utils.ErroresSemánticosInstruccion(this, "El atributo no tiene el mismo tipo que la expresion descrita. ");
                        break;
    
                    }
                }
                
            }
        }else{
            Utils.ErroresSemánticosInstruccion(this, "No se puede modificar esta instancia struct porque la mutabilida es constante. ");
            return this;
        }
        return this;
    }
    
}
