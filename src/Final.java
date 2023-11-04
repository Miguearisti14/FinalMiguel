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
                br = new BufferedReader(fr);

                String linea;

                while((linea = br.readLine()) != null){

                for (int i = 0; i < 100; i++) {
                    String[] split = linea.split(";");
                    resultados[i] = split;
                    linea = br.readLine();
                    
                }
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
        
        
        String[][] lunesData = llenarDiasSemana("src\\lunes.txt");
        String[][] martesData = llenarDiasSemana("src\\martes.txt");
        String[][] miercolesData = llenarDiasSemana("src\\miercoles.txt");
        String[][] juevesData = llenarDiasSemana("src\\jueves.txt");
        String[][] viernesData = llenarDiasSemana("src\\viernes.txt");
        String[][] sabadoData = llenarDiasSemana("src\\sabado.txt");
        String[][] domingoData = llenarDiasSemana("src\\domingo.txt");

        
        

         
    }
}
