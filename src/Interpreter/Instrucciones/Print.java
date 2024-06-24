package Interpreter.Instrucciones;
import Interpreter.Expresion;
import Interpreter.Instruccion;
import Interpreter.Utils;
import Interpreter.Entornos.Entorno;
import client.*;

public class Print extends Instruccion {

    private Expresion expresion;

    public Print(Expresion expresion, int linea, int col) {
        super(Instruccion.nombres[1], linea, col);
        this.expresion = expresion;
    }

    @Override
    public Instruccion interpretar(Entorno entorno) {
        this.expresion.interpretar(entorno); // Interpretamos la expresion
        //this.expresion = this.expresion.interpretar(entorno);

        if (this.expresion.getTipo().equals(Instruccion.nombres[0])){
            // System.out.println("Error Semántico: No se puede imprimir negativos.");
            Utils.ErroresSemánticosInstruccion(this,"No se puede imprimir. ");
            
            return this;

        }

        System.out.println(this.expresion.getValor());
        TextEditor.Print+=this.expresion.getValor()+"\n";
        

        //TextEditor.Consola.setText("");
        //arreglo.push(this.expresion.valor);
        return this;
    }

}