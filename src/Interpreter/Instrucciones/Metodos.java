package Interpreter.Instrucciones;

import java.util.LinkedList;

import Interpreter.Instruccion;
import Interpreter.Utils;
import Interpreter.Entornos.Atributo;
import Interpreter.Entornos.Entorno;
import Interpreter.Entornos.MetodosList;

public class Metodos extends Instruccion{

    private String id;
    private LinkedList<Atributo> parametros;
    private LinkedList<Instruccion> Instrucciones;

    public Metodos( String id,LinkedList<Atributo> parametros,LinkedList<Instruccion> Instrucciones, int linea, int col) {
        super(Instruccion.nombres[14], linea, col);
        this.id = id;
        this.parametros = parametros;
        this.Instrucciones = Instrucciones;
    }

    @Override
    public Instruccion interpretar(Entorno entorno) { // Solo para llamar funciones
        if (entorno.getNombre().equals("Global")){

         for (MetodosList object : Utils.Metodos) {
            if(object.getId().equals(this.id)){
                Utils.ErroresSemánticosInstruccion(this,"Este método ya existe. ");
            }
         }
          Utils.Metodos.add(new MetodosList(this.id,this.parametros,this.Instrucciones)); // Definimos globalmente
        }else{
            Utils.ErroresSemánticosInstruccion(this,"El método no esta en el entorno global. ");
        }
        return this;
    }

}
