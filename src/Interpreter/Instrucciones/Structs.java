package Interpreter.Instrucciones;

import java.util.LinkedList;
import Interpreter.Entornos.Atributo;
import Interpreter.Instruccion;
import Interpreter.Utils;
import Interpreter.Entornos.Entorno;

public class Structs extends Instruccion {

    private String TipoIdentificador;
    private LinkedList<Atributo> Atributos;

    public Structs(String TipoIdentificador,LinkedList<Atributo> Atributos,int linea, int col) {
        super(Instruccion.nombres[13], linea, col);
        this.TipoIdentificador = TipoIdentificador;
        this.Atributos = Atributos;
    }

    @Override
    public Instruccion interpretar(Entorno entorno) {

        Utils.StructsDefinidos.put(this.TipoIdentificador, this.Atributos); // Guardamos los structs
        
        /* 
        for (Atributo Att : Utils.StructsDefinidos.get(this.TipoIdentificador)) {
            System.out.println(Att.getId());
            System.out.println(Att.getTipo());
            System.out.println("----------------");
        }*/
        
        return this;
    }


}
