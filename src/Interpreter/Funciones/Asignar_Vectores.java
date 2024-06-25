package Interpreter.Funciones;
import java.util.LinkedList;

import Interpreter.Expresion;
import Interpreter.Instruccion;
import Interpreter.Entornos.Entorno;
import Interpreter.Utils;

public class Asignar_Vectores extends Instruccion 
{
    private Expresion expresion;
    private String Id;
    private Expresion x;
    private Expresion y;
    private String Modo;
    private int Recursividad;

    public  Asignar_Vectores(Expresion expresion,String Id,Expresion x,Expresion y,String Modo,int Recursividad,int linea, int col) {
        super(Instruccion.nombres[11], linea, col);
        this.expresion = expresion;
        this.Id = Id;
        this.x = x;
        this.y = y;
        this.Modo = Modo;
        this.Recursividad =Recursividad; // Único valor modificable durante la ejecución
    }

    @Override
    public Instruccion interpretar(Entorno entorno) {
        if(this.Recursividad== 0){ // Solo se interpreta una vez
            this.expresion = this.expresion.interpretar(entorno);
            this.x = this.x.interpretar(entorno);
            this.y=this.y.interpretar(entorno);
        }
        if (entorno.getTablaSimbolos().containsKey(this.Id)){
          if (entorno.getTablaSimbolos().get(this.Id).getMutabilidad().equals("VAR")){ 
            this.Recursividad =0;
            Asignacion(entorno,this.Modo,this.expresion.getValor());
            return this;
            
            }
            else{
                Utils.ErroresSemánticosInstruccion(this,"La Mutabilidad es Constante no se puede asignar un valor nuevo. ");
                return this;
            } 
        }else if(entorno.getAnterior() == null){ // llega al final del entorno
            Utils.ErroresSemánticosInstruccion(this,"Este vector no existe. ");          
            return this;

        }else if (entorno.getAnterior() != null){
            this.Recursividad+=1;
            this.interpretar(entorno.getAnterior()); // irá retrocediendo hasta encontrar la variable en otro entorno
            return this;
        }
        return this;
    }

    public void Asignacion(Entorno entorno,String Modo, String Valor){
        
        if (Modo.equals("Vector1")){
         LinkedList<Expresion> Vector1=(LinkedList<Expresion>) entorno.getTablaSimbolos().get(this.Id).getValor();
          Vector1.get(Integer.parseInt(this.x.getValor())).setValor(Valor); // Asignamos el nuevo valor
        } else if (Modo.equals("Vector2")){
            LinkedList<LinkedList<Expresion>> Vector2=(LinkedList<LinkedList<Expresion>>) entorno.getTablaSimbolos().get(this.Id).getValor();
            Vector2.get(Integer.parseInt(this.x.getValor())).get(Integer.parseInt(this.y.getValor())).setValor(Valor);

        }
    }
}
