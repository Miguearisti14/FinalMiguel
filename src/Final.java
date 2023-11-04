import java.io.FileReader;
import java.util.HashMap;
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

            while ((linea = br.readLine()) != null) {

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

        } finally {
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

    public static double ventasPorDia(String[][] resultados) {
        
        double transaccion;
        double ventasDia = 0;

        for (int x = 0; x < 100; x++) {
            transaccion = Double.parseDouble(resultados[x][1]);

            if (Integer.parseInt(resultados[x][2]) == 1) {
                transaccion = transaccion * 2;
            }
            if (Integer.parseInt(resultados[x][2]) == 2) {
                transaccion = transaccion * 2.8;
            }
            ventasDia += transaccion;

        }

        
        return ventasDia;
    }

    public static void main(String[] args) throws Exception {

        String[][] lunesData = llenarDiasSemana("src\\lunes.txt");
        String[][] martesData = llenarDiasSemana("src\\martes.txt");
        String[][] miercolesData = llenarDiasSemana("src\\miercoles.txt");
        String[][] juevesData = llenarDiasSemana("src\\jueves.txt");
        String[][] viernesData = llenarDiasSemana("src\\viernes.txt");
        String[][] sabadoData = llenarDiasSemana("src\\sabado.txt");
        String[][] domingoData = llenarDiasSemana("src\\domingo.txt");

        HashMap<String, Double> ventas = new HashMap<String, Double>();

        ventas.put("lunes", ventasPorDia(lunesData));
        ventas.put("martes", ventasPorDia(martesData));
        ventas.put("miercoles", ventasPorDia(miercolesData));
        ventas.put("jueves", ventasPorDia(juevesData));
        ventas.put("viernes", ventasPorDia(viernesData));
        ventas.put("sabado", ventasPorDia(sabadoData));
        ventas.put("domingo", ventasPorDia(domingoData));

        
        String mayoresVentas = null;
        double valorMayor = Double.MIN_VALUE;

        for (String dia : ventas.keySet()) {
            double venta = ventas.get(dia);

            if (venta > valorMayor) {
                valorMayor = venta;
                mayoresVentas = dia;
            }
        }

        System.out.println("El dia que mas ventas tuvo fue el " + mayoresVentas);

    }
}
