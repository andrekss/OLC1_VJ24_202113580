package Interpreter.Expresiones;

import Interpreter.Expresion;
import Interpreter.Entornos.Entorno;

public class Casteo extends Expresion {

    private String Tipo;
    private Expresion expresion;
    
    public Casteo(String Tipo,Expresion expresion, int fila, int columna){
        super("ERROR", TiposDatos[5], fila, columna);
        this.Tipo = Tipo;
        this.expresion = expresion;
    }
    
    @Override
    public Expresion interpretar(Entorno entorno) {
        this.expresion.interpretar(entorno);

        if(this.expresion.getTipo().equals("INT") && this.Tipo.equals("DOUBLE")){
            Castear();
        }else if (this.expresion.getTipo().equals("DOUBLE") && this.Tipo.equals("INT")){
            Castear();
        }else if (this.expresion.getTipo().equals("INT") && this.Tipo.equals("CHAR")){
            Castear();
        }else if (this.expresion.getTipo().equals("CHAR") && this.Tipo.equals("INT")){
            Castear();
        }else if (this.expresion.getTipo().equals("CHAR") && this.Tipo.equals("DOUBLE")){
            Castear();
        }else{
            Interpreter.Utils.ErroresSemánticosExpresion(this, "No es posible realizar este casteo. ");
            return this;
        }

        return this;
    }

    public void Castear(){
        this.setValor(this.expresion.getValor());
        this.setTipo(this.Tipo);

    }
    
}
