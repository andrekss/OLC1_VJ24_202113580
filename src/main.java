import java.io.StringReader;
import Interpreter.Entornos.*;
import client.TextEditor;
import Interpreter.*;

public class main {

    public static boolean ModoPrint = false;
    public static boolean ModoPrint_Arrs = false;
    public static int Tipo_Grafica =0;

    public static void main(String[] args) {
    CrearVentana();
        
    //analizadores("src/Language/", "Lexer.flex", "Parser.cup");

    String Entrada3 = """
    
const nota: int = 100;
println("Operaciones aritmeticas");
var cadena: string = "Vamos " + "por " + "ese " + nota;
println(cadena);
var operaciones: int = 1 + 9 - 8  + (5 * 2);
println("El resultado de las operaciones es " + operaciones);
println("");

println("Operaciones Relacionales");
var a: bool = 1 < 2;
println("El valor de a es " + a);

var b: bool = 1 == 2;
println("El valor de b es " + b);

println("");

println("Operaciones Logicas");
var c: bool = !!true;
println("El valor de c es " + c);

var d: bool = (true && false) || (false || false);
println("El valor de d es " + d);

println("");

println("Operaciones combinadas");
var e: bool = (1 == 2) || (10 < 5) || (!false);
println("El valor de e es " + e);

println("");
println("Ciclos, condicionales y saltos de control");
var i: int = 0;
while (i < 11) {
    if (i == 10) {
        println("Terminamos con break");
        break;
    }
    println("Iteracion " + i);
    i = i + 1;
}
println("");
for (i = 0; i <= 5; i++) {
    println("" + 2 + " * " + i + " = " + 2 * i);
    if (i >= 2) {
        continue;
    }
    println("Solo se imprime 2 veces");
}

println("");

var j: int = 0;
var k: int = 10;
    

println("Match Dificil");
while (j <= k) {
    match j {
        1 => { println("j es 1"); }
        2 => { println("j es 2"); }
        3 => { println("j es 3"); }
        4 => { println("j es 4"); }
        5 => { println("j es 5"); }
        6 => { println("j es 6"); }
        7 => { println("j es 7"); }
        8 => { println("j es 8"); }
        9 => { println("j es 9"); }
        10 => { println("j es 10"); }
        _ => { println("j es otro valor"); }
    }
        println(j);
    j++;
}




// SALIDA ESPERADA
/*
Operaciones aritmeticas
Vamos por ese 100
El resultado de las operaciones es 35

Operaciones Relacionales
El valor de a es true
El valor de b es false

Operaciones Logicas
El valor de c es true
El valor de d es false

Operaciones combinadas
El valor de e es true

Ciclos, condicionales y saltos de control
Iteracion 0
Iteracion 1
Iteracion 2
Iteracion 3
Iteracion 4
Iteracion 5
Iteracion 6
Iteracion 7
Iteracion 8
Iteracion 9
Iteracion 10
Terminamos con break

2 * 0 = 0
Solo se imprime 2 veces
2 * 1 = 2
Solo se imprime 2 veces
2 * 2 = 4
2 * 3 = 6
2 * 4 = 8
2 * 5 = 10

j es otro valor
j es 1
j es 2
j es 3
j es 4
j es 5
j es 6
j es 7
j es 8
j es 9
j es 10
*/

            """;


         //analizar(Entrada3);
    
         String Entrada2="""
            var num : int;
            var num2 : int = 10;
            var nota2 : double = 20.6;
            num2 = 90;
            nota2++;

            // Sentencia
            if (false){
              println(num2);
              println(nota2);
              println(num);
              //println(sad);

            }  else {
             println("You are in else 2");
             }
            
            var i: int = 13;

            while (i<=12){
            println(i);
            i++;
            }

            var i2:int = 1;

            do{

            println(i2);
            i2++;
            break;
            }while(i2<12);

            println("-------------------");
            for (as = 0; as < 15; as++){
                println(as);
                break;
            }


            println("---Match---");

            
        
            Match true {
            false =>{
                println("Ahora");
            }
            17 >= 20 =>{
                println("freak");
            }
            _ =>{
                println("dos");
            }
        }
            


        // Sentencias Cíclicas
        for(i = 0; i < 3; i++){
            if (i==2){
             println(i);
            }
        } 

        println("variables---");

        var uto: bool =!false;

        println(uto);
        println("--While--");
        
        var z : int = -5;
        while (z < 5) {
            println("Valor de z: " + z);
            if (z % 2 == 0) {
                println(z + " es par");
            } else {
                println(z + " es impar");
            }
            z = z + 1;
        }    

        println("--Probando continue--");

            //var i: int=0;
             for(i=0; i<=2; i++){
                println(i);

                if (true){
                 if(i==1){
                 
                 continue;
                 }
                } 
                println(i*5);
             }

        """;

         //analizar(Entrada2);
    String Entrada = """
        // variables
        var num : int;
        const nota : double;
        var num2 : int = 10;
        const nota2 : double = 20.6;
        num =10;
        nota = 20.6;

        var edad:int=(10+10)-5;
        
        // Casteo
        var edad : int = (int) 18.6;
        const letra : char = (char) 70;
        var numero : double = (double) 16;
        
        // Funcion print
        println(i);

        // Sentencias de control
        // If
        if (a && a){
            println(i);
        }

        if (a && a){
            println(i);
        }  else if (a==10){
            println(i);
        }else {
            println(i);
        }

        if (10 < 9){
            println(i);
        }else {
            println(i);
        } 

        // Match

        Match arqui {
            17 < 20 =>{
                println(i);
            }
            17 >= 20 =>{
                println(i);
            }
            _ =>{
                println(i);
            }
        }
        // Sentencias Cíclicas
        for(i = 0; i < 3; i++){
            if (i==2){
             println(i);
            }
        } 

        while (15==15 && ui<14){
            println(i);
        }

        do {
            println(i);
        }while (true);

        // Sentencias de transferencias

        do {
            continue;
        }while (false);

        while (15==15 && ui<14){
            break;
        }

        for(i = 0; i < 3; i++){
            return a;
        } 

        println(-1+2-2*10);

            """;
     

    }

    // Crear Analizadores
    public static void analizadores(String ruta, String jflexFile, String cupFile) {  // Created by: KM MASLOWY (El sexo del grupo)
        try {
            String opcionesJflex[] = {ruta + jflexFile, "-d", ruta};
            jflex.Main.generate(opcionesJflex);

            String opcionesCup[] = {"-destdir", ruta, "-parser", "Parser", ruta + cupFile};
            java_cup.Main.main(opcionesCup);

        } catch (Exception e) {
            System.out.println("No se ha podido generar los analizadores");
            System.out.println(e);
        }
    }

    public static void CrearVentana(){
        TextEditor ventana = new TextEditor();
        ventana.setVisible(true);
    }

    // Realizar Analisis
    public static void analizar(String entrada) {
        
        try {

            Language.Lexer lexer = new Language.Lexer(new StringReader(entrada)); // Creación de lexer base en base a la entrada
            Language.Parser parser = new Language.Parser(lexer); // Creación del parser en base al lexer
            parser.parse();// Ejecutamos el parser
            Entorno Global = new Entorno("Global", null);

            for ( Instruccion instruccion : parser.Ejecutar) {
                instruccion.interpretar(Global);
            }


            //System.out.println(parser.parse());
        } catch (Exception e) {
            e.printStackTrace();
            // Imprimir información específica sobre la línea exacta del error
            StackTraceElement[] stackTrace = e.getStackTrace();
            if (stackTrace.length > 0) {
                StackTraceElement element = stackTrace[0];
                System.out.println("Error en la clase: " + element.getClassName());
                System.out.println("Error en el método: " + element.getMethodName());
                System.out.println("Error en la línea: " + element.getLineNumber());
                }

            //System.out.println("Error fatal en compilación de entrada.");
            //System.out.println(e);
        }
    }

    /*public static void Interpretar(String entrada){
        try {
            Language.Lexer lexer = new Language.Lexer(new StringReader(entrada)); // Creación de lexer base en base a la entrada
            Language.Parser parser = new Language.Parser(lexer); // Creación del parser en base al lexer
            var Resultado= parser.parse();// Ejecutamos el parser
            
            for (String nombre : Resultado) {
                System.out.println(nombre);
            }
    
        } catch (Exception e) {
            System.out.println("Error fatal en compilación de entrada.");
            System.out.println(e);
        }
    }*/


}
