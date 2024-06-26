package Interpreter.Expresiones;

import java.util.LinkedList;

import Interpreter.Expresion;
import Interpreter.Utils;
import Interpreter.Entornos.Entorno;

public class Remove_Valor extends Expresion{
    private Expresion Indice;
    private String Id;

    public Remove_Valor(Expresion Indice,String Id,  int linea, int col) { 
        super("ERROR", TiposDatos[5], linea, col);
        this.Indice = Indice;
        this.Id = Id;
    }

    @Override
    public Expresion interpretar(Entorno entorno) {

        this.Indice.interpretar(entorno);
        if(!this.Indice.getTipo().equals("INT")){
            Utils.ErroresSemánticosExpresion(this, "El índice no es de tipo int. ");
            return this;
        }

        LinkedList<Expresion> Listas=(LinkedList<Expresion>) entorno.getTablaSimbolos().get(this.Id).getValor();
        Expresion ValorEliminado =Listas.get(Integer.parseInt(this.Indice.getValor()));
        this.setValor(ValorEliminado.getValor());
        this.setTipo(ValorEliminado.getTipo());
        Listas.remove(Integer.parseInt(this.Indice.getValor()));

        return this;
    }
    
}
