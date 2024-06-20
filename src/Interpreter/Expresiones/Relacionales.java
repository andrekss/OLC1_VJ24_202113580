package Interpreter.Expresiones;

import Interpreter.Expresion;
import Interpreter.Entornos.Entorno;


public class Relacionales extends  Expresion{
        private Expresion izq;
    private String Operacion;
    private Expresion der;

    public Relacionales(Expresion izq,String Operacion,Expresion der,int fila,int columna){
        super("ERROR", TiposDatos[5], fila, columna);
        this.izq = izq;
        this.der = der;
        this.Operacion = Operacion;
    }

    @Override
    public Expresion interpretar(Entorno entorno) {
        // Interpretamos los operadores
        this.izq.interpretar(entorno);
        this.der.interpretar(entorno);
        
        // no se pueden hacer con valores booleanos
        if (this.Operacion== "=="){
            try {
                
                Funciones.Relacionar(this.izq, this.Operacion, this.der,this, izq.getValor().equalsIgnoreCase(der.getValor()),izq.getValor().charAt(0)==Integer.parseInt(der.getValor()), Integer.parseInt(izq.getValor())==der.getValor().charAt(0));
            } catch (Exception e) {

                if(this.izq.getTipo() == "STRING"){
                  Funciones.RelacionarBoolean(this.izq, this.Operacion, this.der,this, this.izq.getValor().length()== this.der.getValor().length());
                } else if(this.izq.getTipo()=="BOOL"){
                    int val1;
                    int val2;
                    if(this.izq.getValor().equalsIgnoreCase("True")){
                        val1 =1;
                        
                    }else{
                        val1 = 0;
                    }

                    if(this.der.getValor().equalsIgnoreCase("True")){
                        val2 =1;
                        
                    }else{
                        val2 = 0;
                    }

                    Funciones.RelacionarBoolean(this.izq, this.Operacion, this.der,this, val1==val2);

                }
            }
           
        }else if (this.Operacion== "!="){
            try {
                Funciones.Relacionar(this.izq, this.Operacion, this.der,this, !izq.getValor().equalsIgnoreCase(der.getValor()),izq.getValor().charAt(0)!=Integer.parseInt(der.getValor()), Integer.parseInt(izq.getValor())!=der.getValor().charAt(0));
            } catch (Exception e) {
                if(this.izq.getTipo() == "STRING"){
                    Funciones.RelacionarBoolean(this.izq, this.Operacion, this.der,this, this.izq.getValor().length()!= this.der.getValor().length());
                  } else if(this.izq.getTipo()=="BOOL"){
                      int val1;
                      int val2;
                      if(this.izq.getValor().equalsIgnoreCase("True")){
                          val1 =1;
                          
                      }else{
                          val1 = 0;
                      }
  
                      if(this.der.getValor().equalsIgnoreCase("True")){
                          val2 =1;
                          
                      }else{
                          val2 = 0;
                      }
  
                      Funciones.RelacionarBoolean(this.izq, this.Operacion, this.der,this, val1!=val2);
  
                  }            }
        }else if (this.Operacion== "<"){
            try {

                boolean MainCondicion = compararValores(izq,der,"<");
                Funciones.Relacionar(this.izq, this.Operacion, this.der,this, MainCondicion,izq.getValor().charAt(0)<Integer.parseInt(der.getValor()), Integer.parseInt(izq.getValor())<der.getValor().charAt(0));
            } catch (Exception e) {
                if(this.izq.getTipo() == "STRING"){
                  Funciones.RelacionarBoolean(this.izq, this.Operacion, this.der,this, this.izq.getValor().length()< this.der.getValor().length());
                } else if(this.izq.getTipo()=="BOOL"){
                    int val1;
                    int val2;
                    if(this.izq.getValor().equalsIgnoreCase("True")){
                        val1 =1;
                        
                    }else{
                        val1 = 0;
                    }

                    if(this.der.getValor().equalsIgnoreCase("True")){
                        val2 =1;
                        
                    }else{
                        val2 = 0;
                    }

                    Funciones.RelacionarBoolean(this.izq, this.Operacion, this.der,this, val1<val2);

                }           
            }

        }else if (this.Operacion== "<="){
            try {
                boolean MainCondicion = compararValores(izq,der,"<=");
                Funciones.Relacionar(this.izq, this.Operacion, this.der,this, MainCondicion,izq.getValor().charAt(0)<Integer.parseInt(der.getValor()), Integer.parseInt(izq.getValor())<=der.getValor().charAt(0));
            } catch (Exception e) {
                if(this.izq.getTipo() == "STRING"){
                    Funciones.RelacionarBoolean(this.izq, this.Operacion, this.der,this, this.izq.getValor().length()<= this.der.getValor().length());
                  } else if(this.izq.getTipo()=="BOOL"){
                      int val1;
                      int val2;
                      if(this.izq.getValor().equalsIgnoreCase("True")){
                          val1 =1;
                          
                      }else{
                          val1 = 0;
                      }
  
                      if(this.der.getValor().equalsIgnoreCase("True")){
                          val2 =1;
                          
                      }else{
                          val2 = 0;
                      }
  
                      Funciones.RelacionarBoolean(this.izq, this.Operacion, this.der,this, val1<=val2);
  
                  }           
             }
            
        }else if (this.Operacion== ">"){
            try {
                boolean MainCondicion = compararValores(izq,der,"<=");
                Funciones.Relacionar(this.izq, this.Operacion, this.der,this, MainCondicion,izq.getValor().charAt(0)<Integer.parseInt(der.getValor()), Integer.parseInt(izq.getValor())>der.getValor().charAt(0));
            } catch (Exception e) {
                if(this.izq.getTipo() == "STRING"){
                    Funciones.RelacionarBoolean(this.izq, this.Operacion, this.der,this, this.izq.getValor().length()> this.der.getValor().length());
                  } else if(this.izq.getTipo()=="BOOL"){
                      int val1;
                      int val2;
                      if(this.izq.getValor().equalsIgnoreCase("True")){
                          val1 =1;
                          
                      }else{
                          val1 = 0;
                      }
  
                      if(this.der.getValor().equalsIgnoreCase("True")){
                          val2 =1;
                          
                      }else{
                          val2 = 0;
                      }
  
                      Funciones.RelacionarBoolean(this.izq, this.Operacion, this.der,this, val1>val2);
  
                  }           
              }
            
        }else if (this.Operacion== ">="){
            try {
                boolean MainCondicion = compararValores(izq,der,"<=");
                Funciones.Relacionar(this.izq, this.Operacion, this.der,this, MainCondicion,izq.getValor().charAt(0)<Integer.parseInt(der.getValor()), Integer.parseInt(izq.getValor())>=der.getValor().charAt(0));
            } catch (Exception e) {
                if(this.izq.getTipo() == "STRING"){
                    Funciones.RelacionarBoolean(this.izq, this.Operacion, this.der,this, this.izq.getValor().length()>= this.der.getValor().length());
                  } else if(this.izq.getTipo()=="BOOL"){
                      int val1;
                      int val2;
                      if(this.izq.getValor().equalsIgnoreCase("True")){
                          val1 =1;
                          
                      }else{
                          val1 = 0;
                      }
  
                      if(this.der.getValor().equalsIgnoreCase("True")){
                          val2 =1;
                          
                      }else{
                          val2 = 0;
                      }
  
                      Funciones.RelacionarBoolean(this.izq, this.Operacion, this.der,this, val1>=val2);
  
                  }           
              }
           
        }
        return this;
    }

    public static boolean compararValores(Expresion izq, Expresion der,String type) {
        String izqTipo = izq.getTipo();
        String derTipo = der.getTipo();
        String izqValor = izq.getValor();
        String derValor = der.getValor();

        switch (izqTipo) {
            case "CHAR":
                char izqChar = izqValor.charAt(0);
                switch (derTipo) {
                    case "CHAR":
                        char derChar = derValor.charAt(0);

                        if (type.equals("<")){
                            return izqChar < derChar;
                        }else if (type.equals("<=")){
                            return izqChar <= derChar;
                        }else if (type.equals(">")){
                            return izqChar > derChar;   
                        }else if (type.equals(">=")){
                            return izqChar >= derChar;   
                        }
                        return false;
                    case "INT":
                        int derInt = Integer.parseInt(derValor);
                        if (type.equals("<")){
                            return izqChar < derInt;
                        }else if (type.equals("<=")){
                            return izqChar <= derInt;
                        }else if (type.equals(">")){
                            return izqChar > derInt;   
                        }else if (type.equals(">=")){
                            return izqChar >= derInt;   
                        }
                        return false;
                        //return izqChar < derInt;
                    case "DOUBLE":
                        double derDouble = Double.parseDouble(derValor);

                        if (type.equals("<")){
                            return izqChar < derDouble;
                        }else if (type.equals("<=")){
                            return izqChar <= derDouble;
                        }else if (type.equals(">")){
                            return izqChar > derDouble;   
                        }else if (type.equals(">=")){
                            return izqChar >= derDouble;   
                        }
                        return false;
                        
                        //return izqChar < derDouble;
                }
                break;
            case "INT":
                int izqInt = Integer.parseInt(izqValor);
                switch (derTipo) {
                    case "CHAR":
                        char derChar = derValor.charAt(0);

                        if (type.equals("<")){
                            return izqInt < derChar;
                        }else if (type.equals("<=")){
                            return izqInt <= derChar;
                        }else if (type.equals(">")){
                            return izqInt > derChar;   
                        }else if (type.equals(">=")){
                            return izqInt >= derChar;   
                        }
                        return false;
                        
                        //return izqInt < derChar;
                    case "INT":
                        int derInt = Integer.parseInt(derValor);
                        if (type.equals("<")){
                            return izqInt < derInt;
                        }else if (type.equals("<=")){
                            return izqInt <= derInt;
                        }else if (type.equals(">")){
                            return izqInt > derInt;   
                        }else if (type.equals(">=")){
                            return izqInt >= derInt;   
                        }
                        
                        //return izqInt < derInt;
                    case "DOUBLE":
                        double derDouble = Double.parseDouble(derValor);

                        if (type.equals("<")){
                            return izqInt < derDouble;
                        }else if (type.equals("<=")){
                            return izqInt <= derDouble;
                        }else if (type.equals(">")){
                            return izqInt > derDouble;   
                        }else if (type.equals(">=")){
                            return izqInt >= derDouble;   
                        }
                        //return izqInt < derDouble;
                }
                break;
            case "DOUBLE":
                double izqDouble = Double.parseDouble(izqValor);
                switch (derTipo) {
                    case "CHAR":
                        char derChar = derValor.charAt(0);

                        if (type.equals("<")){
                            return izqDouble < derChar;
                        }else if (type.equals("<=")){
                            return izqDouble <= derChar;
                        }else if (type.equals(">")){
                            return izqDouble > derChar;   
                        }else if (type.equals(">=")){
                            return izqDouble >= derChar;   
                        }
                        
                        //return izqDouble < derChar;
                    case "INT":
                        int derInt = Integer.parseInt(derValor);
                        if (type.equals("<")){
                            return izqDouble < derInt;
                        }else if (type.equals("<=")){
                            return izqDouble <= derInt;
                        }else if (type.equals(">")){
                            return izqDouble > derInt;   
                        }else if (type.equals(">=")){
                            return izqDouble >= derInt;   
                        }
                        
                        //return izqDouble < derInt;
                    case "DOUBLE":
                        double derDouble = Double.parseDouble(derValor);

                        if (type.equals("<")){
                            return izqDouble < derDouble;
                        }else if (type.equals("<=")){
                            return izqDouble <= derDouble;
                        }else if (type.equals(">")){
                            return izqDouble > derDouble;   
                        }else if (type.equals(">=")){
                            return izqDouble >= derDouble;   
                        }
                        //return izqDouble < derDouble;
                }
                break;
        }
        return false; // or throw an exception for unsupported types
    }


    
}


