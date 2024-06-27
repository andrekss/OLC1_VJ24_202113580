package Interpreter.Expresiones;

import java.util.LinkedList;

import Interpreter.Expresion;
import Interpreter.Utils;
import Interpreter.Entornos.Def_Atributo;
import Interpreter.Entornos.Entorno;

public class AccederStruct extends Expresion {
    private String Id ;
    private String Atributo ;

    public AccederStruct(String Id,String Atributo, int fila, int columna){
        super("ERROR", TiposDatos[5], fila, columna);
        this.Id = Id;
        this.Atributo = Atributo;
    }

    @Override
    public Expresion interpretar(Entorno entorno) {
        if(!entorno.getTablaSimbolos().containsKey(this.Id)){
            Utils.ErroresSemánticosExpresion(this, "Este struct no existe. ");
            return this;
        }

        LinkedList<Def_Atributo> ListaStructsDef = (LinkedList<Def_Atributo>) entorno.getTablaSimbolos().get(this.Id).getValor();
        
        for (Def_Atributo def_Atributo : ListaStructsDef) {  //Recorriendo los atributos del struct seleccionado
            if(def_Atributo.getId().equals(this.Atributo)){
                this.setTipo(def_Atributo.getExpresion().getTipo());
                this.setValor(def_Atributo.getExpresion().getValor());
                return this;
            }
        }
        Utils.ErroresSemánticosExpresion(this, "Este atributo no pertence a este struct. ");

        return this;
    }
    
}
