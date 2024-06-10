package Interpreter.Instrucciones;
import Interpreter.Expresion;
import Interpreter.Instruccion;
import Interpreter.Entornos.Entorno;

public class Print extends Instruccion {

    private Expresion expresion;

    public Print(Expresion expresion, int linea, int col) {
        super(Instruccion.nombres[0], linea, col);
        this.expresion = expresion;
    }

    @Override
    public Interpreter.Instruccion interpretar(Entorno entorno) {
        this.expresion.interpretar(entorno); // Interpretamos la expresion

        if (this.expresion.getTipo() == Instruccion.nombres[1]){
            // System.out.println("Error Semántico: No se puede imprimir negativos.");
            System.out.println("Error Semántico: No se puede imprimir.");
            return this;
        }

        System.out.println(this.expresion.getValor());
        //arreglo.push(this.expresion.valor);
        return this;
    }

}