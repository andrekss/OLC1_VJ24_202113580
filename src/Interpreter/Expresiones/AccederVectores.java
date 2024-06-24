package Interpreter.Expresiones;

import java.util.LinkedList;

import Interpreter.Expresion;
import Interpreter.Entornos.Entorno;

public class AccederVectores extends Expresion{
    private String Id ;
    private Expresion x ;
    private Expresion y;
    private String TipoVector;
    public AccederVectores(String Id,Expresion x, Expresion y,String TipoVector ,int fila, int columna){
        super("ERROR", TiposDatos[5], fila, columna);
        this.Id = Id;
        this.x = x;
        this.y = y;
        this.TipoVector = TipoVector;
    }

    @Override
    public Expresion interpretar(Entorno entorno) {
        this.x.interpretar(entorno);
        this.y.interpretar(entorno);

        if (!this.x.getTipo().equals("INT") || !this.getTipo().equals("INT")){
            
            return this;
        }

        if (TipoVector.equals("Vector1")){ // Vectores de una dimensión

            //Obtenemos La lista
            LinkedList<Expresion> Vector1=(LinkedList<Expresion>) entorno.getTablaSimbolos().get(this.Id).getValor();
            
            String Valor = Vector1.get(Integer.parseInt(this.x.getValor())).getValor();
            String Tipo =entorno.getTablaSimbolos().get(this.Id).getTipo();
          
            this.setValor(Valor);
            this.setTipo(Tipo);
            return this;

        }else if (TipoVector.equals("Vector2")) { // Vectores de 2 dimensiones

        }
        return this;
    }
    
}
