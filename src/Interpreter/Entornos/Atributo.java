package Interpreter.Entornos;

public class Atributo {

    private String Id;
    private String Tipo;

    public Atributo(String Id, String Tipo){
        this.Id = Id;
        this.Tipo = Tipo;
        
    } 

    // Getter and Setter for Id
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    // Getter and Setter for Tipo
    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

}
