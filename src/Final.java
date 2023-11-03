import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

public class Final {

    public static String[][] llenarDiasSemana(String fileName) {
        for (int i = 0; i < fileName.length(); i++) {                     

                FileReader fr = null;
                BufferedReader br = null; 
                   
            try {  

            fr = new FileReader(fileName);
            String linea;

           
                while ((linea = br.readLine()) != null) {
                String[] subcadenas = linea.split(";");

                    for (String subcadena : subcadenas) {
                   
                }
            }
            
            } catch (Exception e) {
            System.out.println(e.getMessage());

                } finally {
                    try {
                fr.close();
                        } catch (Exception e) {
                
                        }
                } 
            
            
        }

    }

    public static void main(String[] args) throws Exception {
        File archivo1 = null;
        
        String[][] lunesData = new String[100][5];
        String[][] martesData = new String[100][5];
        String[][] miercolesData = new String[100][5];
        String[][] juevesData = new String[100][5];
        String[][] viernesData = new String[100][5];
        String[][] sabadoData = new String[100][5];
        String[][] domingoData = new String[100][5];

        String[] dias = {"lunes.txt","martes.txt","miercoles.txt","jueves.txt","viernes.txt","sabado.txt","domingo.txt"};
        

         
    }
}
