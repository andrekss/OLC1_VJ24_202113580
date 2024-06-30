package Interpreter.Instrucciones;

import java.util.LinkedList;

import Interpreter.Instruccion;
import Interpreter.Utils;
import Interpreter.Entornos.Atributo;
import Interpreter.Entornos.Entorno;
import Interpreter.Entornos.MetodosList;

public class Metodos extends Instruccion{

    private String Tipo;  // Solo funciones
    private String id;
    private LinkedList<Atributo> parametros;
    private LinkedList<Instruccion> Instrucciones;

    public Metodos(String Tipo, String id,LinkedList<Atributo> parametros,LinkedList<Instruccion> Instrucciones, int linea, int col) {
        super(Instruccion.nombres[14], linea, col);
        this.Tipo = Tipo;
        this.id = id;
        this.parametros = parametros;
        this.Instrucciones = Instrucciones;
    }

    @Override
    public Instruccion interpretar(Entorno entorno) { // Solo para llamar funciones
        if (entorno.getNombre().equals("Global")){

         for (MetodosList object : Utils.MetodosFuncs) {
            if(object.getId().equals(this.id)){
                Utils.ErroresSemánticosInstruccion(this,"Este método ya existe. ");
            }
         }
          Utils.MetodosFuncs.add(new MetodosList(this.Tipo,this.id,this.parametros,this.Instrucciones)); // Definimos globalmente
        }else{
            Utils.ErroresSemánticosInstruccion(this,"El método no esta en el entorno global. ");
        }
        return this;
    }

}
