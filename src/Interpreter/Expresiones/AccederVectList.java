package Interpreter.Expresiones;

import java.util.LinkedList;

import Interpreter.Expresion;
import Interpreter.Entornos.Entorno;
import Interpreter.Utils;

public class AccederVectList extends Expresion{
    private String Id ;
    private Expresion x ;
    private Expresion y;
    private String TipoVector;
    public AccederVectList(String Id,Expresion x, Expresion y,String TipoVector ,int fila, int columna){
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

        if (!this.x.getTipo().equals("INT") || !this.y.getTipo().equals("INT")){
            Utils.ErroresSemánticosExpresion(this,"Alguno de los índices no son tipo int. ");
            return this;
        }
        
        if(entorno.getTablaSimbolos().containsKey(this.Id)){ // Verificar que exista el vector

            if (TipoVector.equals("Vector1") ){ // Vectores de una dimensión
    
                //Obtenemos La lista
                LinkedList<Expresion> Vector1=(LinkedList<Expresion>) entorno.getTablaSimbolos().get(this.Id).getValor();
                
                String Valor = Vector1.get(Integer.parseInt(this.x.getValor())).getValor();
                String Tipo =entorno.getTablaSimbolos().get(this.Id).getTipo();
              
                this.setValor(Valor);
                this.setTipo(Tipo);
                return this;
    
            }else if (TipoVector.equals("Vector2")) { // Vectores de 2 dimensiones
                //Obtenemos La lista
                LinkedList<LinkedList<Expresion>> Vector2=(LinkedList<LinkedList<Expresion>>) entorno.getTablaSimbolos().get(this.Id).getValor();
                String valor = Vector2.get(Integer.parseInt(this.x.getValor())).get(Integer.parseInt(this.y.getValor())).getValor();
                String Tipo =entorno.getTablaSimbolos().get(this.Id).getTipo();
               
                this.setValor(valor);
                this.setTipo(Tipo);
                return this;
            }
        }else if(entorno.getAnterior() == null){ // llega la final

            Utils.ErroresSemánticosExpresion(this,"Este vector no existe. ");
            return this;

        }else{
            this.interpretar(entorno.getAnterior()); // irá retrocediendo hasta encontrar la variable en otro entorno
            return this;
        }
        return this;
    
        
    }
    
}
