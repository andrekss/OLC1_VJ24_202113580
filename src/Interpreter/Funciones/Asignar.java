package Interpreter.Funciones;
import Interpreter.Expresion;
import Interpreter.Instruccion;
import Interpreter.Entornos.Entorno;
import client.Errors;
import client.TextEditor;
import Interpreter.Utils;

public class Asignar extends Instruccion 
{
    private Expresion expresion;
    private String Id;

    public Asignar(Expresion expresion,String Id,int linea, int col) {
        super(Instruccion.nombres[3], linea, col);
        this.expresion = expresion;
        this.Id = Id;
    }

    @Override
    public Instruccion interpretar(Entorno entorno) {

        if (entorno.getTablaSimbolos().containsKey(this.Id)){
            if (entorno.getTablaSimbolos().get(this.Id).getMutabilidad() =="VAR"){ 
          this.expresion.interpretar(entorno);
          entorno.getTablaSimbolos().get(this.Id).setValor(this.expresion.getValor()); // Asignamos el valor
          return this;
            }
            else{
                Utils.ErroresSemánticosInstruccion(this,"La Mutabilidad es Constante no se puede asignar un valor nuevo. ");
                return this;
            } 
        }else if(entorno.getAnterior() == null){ // llega al final del entorno
            Utils.ErroresSemánticosInstruccion(this,"Esta variable no existe. ");          
            return this;

        }else if (entorno.getAnterior() != null){
            this.interpretar(entorno.getAnterior()); // irá retrocediendo hasta encontrar la variable en otro entorno
            return this;
        }
        return this;
    }
}
