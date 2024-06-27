package Interpreter.Entornos;

import Interpreter.Expresion;

public class Def_Atributo {

    private String Id;
    private Expresion expresion;

    public Def_Atributo(String Id, Expresion expresion){
        this.Id = Id;
        this.expresion = expresion;
        
    }

    // Getter and Setter for Id
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    // Getter and Setter for expresion
    public Expresion getExpresion() {
        return expresion;
    }

    public void setEpresion(Expresion expresion) {
        this.expresion = expresion;
    }

}
