package Interpreter.Instrucciones;
import java.util.LinkedList;
import Interpreter.Expresion;
import Interpreter.Instruccion;
import Interpreter.Utils;
import Interpreter.Entornos.Entorno;
import Interpreter.Entornos.Simbolo;
import Interpreter.Funciones.*;
import client.TextEditor;

public class For extends Instruccion{
    private LinkedList<Instruccion> Sentencia_Entorno;
    private Expresion expresion1;
    private Expresion expresion2;
    private String IncrementoDecremento;
    private String Tipo;
    //Variable for
    private String Id;
    private boolean AvisoBreak;
    
    // AQUI ME QUEDE
    public For( LinkedList<Instruccion> Sentencia_Entorno,Expresion expresion1,Expresion expresion2,String IncrementoDecremento,String Tipo,String Id,int linea, int col) {
        super(Instruccion.nombres[6], linea, col);
        this.Sentencia_Entorno = Sentencia_Entorno;
        this.expresion1 = expresion1;
        this.expresion2 = expresion2;
        this.IncrementoDecremento = IncrementoDecremento;
        this.Tipo = Tipo;
        this.Id = Id;
        this.AvisoBreak= false;
    }

    @Override
    public Instruccion interpretar(Entorno entorno) {
        this.expresion1.interpretar(entorno);
        this.expresion2.interpretar(entorno);

        if (!this.expresion1.getTipo().equals("INT") && !this.expresion2.getTipo().equals("INT")){
            System.out.println("Error Semántico: Los rangos deben de ser de tipo int");
           // Utils.ErroresSemánticosInstruccion(this,"Los rangos deben de ser de tipo int. ");
            return this;
        }
        
        int ValorInicial = Integer.parseInt(expresion1.getValor());
        int ValorFinal = Integer.parseInt(expresion2.getValor());
        Entorno For_Entorno = new Entorno(Instruccion.nombres[6], entorno);
        // Agregamos la variable FOR
        Declarar VariableFor = new Declarar(this.expresion1, "INT", this.Id, "VAR", this.getFila(), this.getColumna());
        VariableFor.interpretar(For_Entorno);
                if(this.IncrementoDecremento.equals("++")){

            if(this.Tipo.equals("<")){
                
                for (int i = ValorInicial; i < ValorFinal; i++) { // Ciclo principal
                    For_Entorno = new Entorno(Instruccion.nombres[6], entorno);
                    this.Ejecutar(For_Entorno,this.Id);

                    // Incremento
                    IncrementoDecremento a = new Interpreter.Funciones.IncrementoDecremento(this.Id, "++",this.getFila(), this.getColumna());
                    a.interpretar(For_Entorno);
                    
                    if(this.AvisoBreak==true){ // Rompemos el ciclo principal
                        this.AvisoBreak = false;
                        break;
                    }
                    
                }
                for (Simbolo Sym : For_Entorno.getTablaSimbolos().values()) {
                TextEditor.TablaSimbolos.add(Sym);
                }
            }else if (this.Tipo.equals(">")){
                for (int i = ValorInicial; i > ValorFinal; i++) {
                    For_Entorno = new Entorno(Instruccion.nombres[6], entorno);
                    this.Ejecutar(For_Entorno,this.Id);
                    IncrementoDecremento a = new Interpreter.Funciones.IncrementoDecremento(this.Id, "++",this.getFila(), this.getColumna());
                    a.interpretar(For_Entorno);
                    if(this.AvisoBreak==true){
                        this.AvisoBreak = false;
                        break;
                    }
                    
                }
                for (Simbolo Sym : For_Entorno.getTablaSimbolos().values()) {
                    TextEditor.TablaSimbolos.add(Sym);
                    }

            }else if(this.Tipo.equals("<=")){
                for (int i = ValorInicial; i <= ValorFinal; i++) {
                    For_Entorno = new Entorno(Instruccion.nombres[6], entorno);
                    this.Ejecutar(For_Entorno,this.Id);
                    IncrementoDecremento a = new Interpreter.Funciones.IncrementoDecremento(this.Id, "++",this.getFila(), this.getColumna());
                    a.interpretar(For_Entorno);
                    if(this.AvisoBreak==true){
                        this.AvisoBreak = false;
                        break;
                    }
                }
                for (Simbolo Sym : For_Entorno.getTablaSimbolos().values()) {
                    TextEditor.TablaSimbolos.add(Sym);
                    }

            }else if (this.Tipo.equals(">=")){
                for (int i = ValorInicial; i >= ValorFinal; i++) {
                    For_Entorno = new Entorno(Instruccion.nombres[6], entorno);
                    this.Ejecutar(For_Entorno,this.Id);
                    IncrementoDecremento a = new Interpreter.Funciones.IncrementoDecremento(this.Id, "++",this.getFila(), this.getColumna());
                    a.interpretar(For_Entorno);
                    if(this.AvisoBreak==true){
                        this.AvisoBreak = false;
                        break;
                    }
                }
                for (Simbolo Sym : For_Entorno.getTablaSimbolos().values()) {
                    TextEditor.TablaSimbolos.add(Sym);
                    }

            }
        } else if (this.IncrementoDecremento.equals("--")){
            if(this.Tipo.equals("<")){
                
                for (int i = ValorInicial; i < ValorFinal; i--) {
                    For_Entorno = new Entorno(Instruccion.nombres[6], entorno);
                    this.Ejecutar(For_Entorno,this.Id);
                    IncrementoDecremento a = new Interpreter.Funciones.IncrementoDecremento(this.Id, "--",this.getFila(), this.getColumna());
                    a.interpretar(For_Entorno);
                    if(this.AvisoBreak==true){
                        this.AvisoBreak = false;
                        break;
                    }
                    
                }
                for (Simbolo Sym : For_Entorno.getTablaSimbolos().values()) {
                    TextEditor.TablaSimbolos.add(Sym);
                    }
            }else if (this.Tipo.equals(">")){
                for (int i = ValorInicial; i > ValorFinal; i--) {
                    For_Entorno = new Entorno(Instruccion.nombres[6], entorno);
                    this.Ejecutar(For_Entorno,this.Id);
                    IncrementoDecremento a = new Interpreter.Funciones.IncrementoDecremento(this.Id, "--",this.getFila(), this.getColumna());
                    a.interpretar(For_Entorno);
                    if(this.AvisoBreak==true){
                        this.AvisoBreak = false;
                        break;
                    }
                    
                }
                for (Simbolo Sym : For_Entorno.getTablaSimbolos().values()) {
                    TextEditor.TablaSimbolos.add(Sym);
                    }

            }else if(this.Tipo.equals("<=")){
                for (int i = ValorInicial; i <= ValorFinal; i--) {
                    For_Entorno = new Entorno(Instruccion.nombres[6], entorno);
                    this.Ejecutar(For_Entorno,this.Id);
                    IncrementoDecremento a = new Interpreter.Funciones.IncrementoDecremento(this.Id, "--",this.getFila(), this.getColumna());
                    a.interpretar(For_Entorno);
                    if(this.AvisoBreak==true){
                        this.AvisoBreak = false;

                        break;
                    }
                }
                for (Simbolo Sym : For_Entorno.getTablaSimbolos().values()) {
                    TextEditor.TablaSimbolos.add(Sym);
                    }

            }else if (this.Tipo.equals(">=")){
                for (int i = ValorInicial; i >= ValorFinal; i--) {
                    For_Entorno = new Entorno(Instruccion.nombres[6], entorno);
                    this.Ejecutar(For_Entorno,this.Id);
                    IncrementoDecremento a = new Interpreter.Funciones.IncrementoDecremento(this.Id, "--",this.getFila(), this.getColumna());
                    a.interpretar(For_Entorno);
                    if(this.AvisoBreak==true){
                        this.AvisoBreak = false;
                        break;
                    }
                }
                for (Simbolo Sym : For_Entorno.getTablaSimbolos().values()) {
                    TextEditor.TablaSimbolos.add(Sym);
                    }

            }
        }

        return this;
    }

    public void Ejecutar(Entorno For_Entorno, String id){

        String Tipo;
                
        for ( Instruccion instruccion : this.Sentencia_Entorno) {
               Tipo =instruccion.getTipo();
               instruccion.interpretar(For_Entorno);
               if(instruccion.getTipo().equals("BREAK")){ 
                ///this.setTipo("BREAK");
                instruccion.setTipo(Tipo);
                this.AvisoBreak = true;
                break;
            } 
            if(instruccion.getTipo().equals("CONTINUE")){
                //this.setTipo("CONTINUE");
                //System.out.println("there?");
                instruccion.setTipo(Tipo);
                break; // detenemos las instrucciones pero el ciclo sigue
            } 
              
        }
    }
    
}
