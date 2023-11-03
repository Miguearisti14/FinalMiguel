import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

public class Final {

    public static String[][] llenarDiasSemana(String fileName) {
        
        String[][] resultados = new String[100][5];
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null; 
                   
            try {  
                archivo = new File(fileName);
                fr = new FileReader(fileName);

                String linea="";

                for (int i = 0; i < 100; i++) {
                    String[] split = linea.split(";");
                    resultados[i] = split; 
                }
      
            }
            
             catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error al leer el archivo");

            }finally{
                try {
                    if (null != fr) {
                        fr.close();
                        
                    }
                } catch (Exception e2) {
                    e2.getMessage();
                }

            }

            return resultados;           
            
            
        

    }

    public static void main(String[] args) throws Exception {
        
        
        String[][] lunesData = llenarDiasSemana("lunes.txt");
        String[][] martesData = llenarDiasSemana("martes.txt");
        String[][] miercolesData = llenarDiasSemana("miercoles.txt");
        String[][] juevesData = llenarDiasSemana("jueves.txt");
        String[][] viernesData = llenarDiasSemana("viernes.txt");
        String[][] sabadoData = llenarDiasSemana("sabado.txt");
        String[][] domingoData = llenarDiasSemana("domingo.txt");

        String[] dias = {"lunes.txt","martes.txt","miercoles.txt","jueves.txt","viernes.txt","sabado.txt","domingo.txt"};
        

         
    }
}
