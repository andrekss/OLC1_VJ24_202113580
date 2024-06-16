package Interpreter.Expresiones;
import Interpreter.Expresion;
import Interpreter.Entornos.Entorno;

public class AccederVariables extends Expresion{

    private String Id ;

    public AccederVariables(String Id, int fila, int columna){
        super("ERROR", TiposDatos[5], fila, columna);
        this.Id = Id;
    }
    
    @Override
    public Expresion interpretar(Entorno entorno) {

        if(entorno.getTablaSimbolos().containsKey(this.Id)){
            String Valor = entorno.getTablaSimbolos().get(this.Id).getValor();
            String Tipo = entorno.getTablaSimbolos().get(this.Id).getTipo();
    
            // Cambiamos a los valores que tiene la tabla
            this.setValor(Valor);
            this.setTipo(Tipo);
            return this;
        }else if(entorno.getAnterior() == null){ // llega la final
            System.out.println("Error Samántico: Esta variable no existe");
            return this;

        }else{
            this.interpretar(entorno.getAnterior()); // irá retrocediendo hasta encontrar la variable en otro entorno
            return this;
        }
       /*  else{
            System.out.println("Error Samántico: Esta variable no existe");
            return this;
        }*/

    }
    
}
