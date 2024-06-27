package Interpreter.Expresiones;
import Interpreter.Expresion;
import Interpreter.Entornos.Entorno;
import Interpreter.Utils;

public class AccederVariables extends Expresion{

    private String Id ;

    public AccederVariables(String Id, int fila, int columna){
        super("ERROR", TiposDatos[5], fila, columna);
        this.Id = Id;
    }
    
    @Override
    public Expresion interpretar(Entorno entorno) {


        if(entorno.getTablaSimbolos().containsKey(this.Id)){

            String Valor = (String) entorno.getTablaSimbolos().get(this.Id).getValor();
            //System.out.println(Valor+" ehhh");
            String Tipo = entorno.getTablaSimbolos().get(this.Id).getTipo();
    
            // Cambiamos a los valores que tiene la tabla
            this.setValor(Valor);
            this.setTipo(Tipo);
            return this;
        }else if(entorno.getAnterior() == null){ // llega la final
            Utils.ErroresSemánticosExpresion(this,"Esta variable no existe ");
            
            return this;

        }else{

            this.interpretar(entorno.getAnterior()); // irá retrocediendo hasta encontrar la variable en otro entorno
            return this;
        }
       
    }
    
}
