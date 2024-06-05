import java.io.StringReader;

public class main {

    public static boolean ModoPrint = false;
    public static boolean ModoPrint_Arrs = false;
    public static int Tipo_Grafica =0;

    public static void main(String[] args) {
    CrearVentana();
        
    //analizadores("src/Language/", "Lexer.flex", "Parser.cup");

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

            """;
     //analizar(Entrada);

    }

    // Crear Analizadores
    public static void analizadores(String ruta, String jflexFile, String cupFile) {
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
        } catch (Exception e) {
            System.out.println("Error fatal en compilación de entrada.");
            System.out.println(e);
        }
    }

}
