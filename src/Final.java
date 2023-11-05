import java.io.FileReader;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.File;

public class Final {

    // * Funcion para llenar las matrices de cada dia */
    public static String[][] llenarDiasSemana(String fileName) {

        // * Inicializacion de variables */
        String[][] resultados = new String[100][5];
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // * Asignacion de valor a cada variable segun el archivo */
            archivo = new File(fileName);
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);

            String linea;

            // * Ciclo para leer cada linea e ir saltando de linea */
            while ((linea = br.readLine()) != null) {

                for (int i = 0; i < 100; i++) {
                    String[] split = linea.split(";");
                    resultados[i] = split;
                    linea = br.readLine();

                }
            }
        }

        // * Catch para capturar cualquier error */
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

        // * Retorna una matriz llena en base al archivo */
        return resultados;

    }

    // * Funcion para calcular las ventas totales en un dia */
    public static double ventasPorDia(String[][] resultados) {

        double transaccion;
        double ventasDia = 0;

        // * Ciclo para recorrer todas las lineas de un archivo */
        for (int x = 0; x < 100; x++) {

            // * Variable que representa el valor en la posicion de la matriz */
            transaccion = Double.parseDouble(resultados[x][1]);

            // * If para saber a cuanto equivale la transaccion */
            if (Integer.parseInt(resultados[x][2]) == 1) {
                transaccion = transaccion * 2;
            }
            if (Integer.parseInt(resultados[x][2]) == 2) {
                transaccion = transaccion * 2.8;
            }

            // * Sumatoria de cada linea en la posicion requerida */
            ventasDia += transaccion;

        }

        return ventasDia;
    }

    //* Funcion para saber cual es la hora que mas se repite en un archivo */
    public static int hora(String[][] resultados) {

        //* Array vacio para cada numero*/
        int[] reps = new int[resultados.length];

        //* Llenado del array */
        for (int i = 0; i < resultados.length; i++) {
            int numero = Integer.parseInt(resultados[i][4]);
            reps[numero]++;
        }

        int horaDeCadaDia = 0;
        int repMayor = 0;

        //* Recorrido del array para saber cual es el mayor */
        for (int i = 0; i < reps.length; i++) {
            if (reps[i] > repMayor) {
                repMayor = reps[i];
                horaDeCadaDia = i;
                
            }
        }

        return horaDeCadaDia;
    }

    public static void main(String[] args) throws Exception {

        // * Llamado a la funcion para llenarla en base a un archivo especifico */

        String[][] lunesData = llenarDiasSemana("src\\lunes.txt");
        String[][] martesData = llenarDiasSemana("src\\martes.txt");
        String[][] miercolesData = llenarDiasSemana("src\\miercoles.txt");
        String[][] juevesData = llenarDiasSemana("src\\jueves.txt");
        String[][] viernesData = llenarDiasSemana("src\\viernes.txt");
        String[][] sabadoData = llenarDiasSemana("src\\sabado.txt");
        String[][] domingoData = llenarDiasSemana("src\\domingo.txt");

        // * Hashmap que contiene el dia y la suma de ventas de ese dia */
        HashMap<String, Double> ventas = new HashMap<String, Double>();

        ventas.put("lunes", ventasPorDia(lunesData));
        ventas.put("martes", ventasPorDia(martesData));
        ventas.put("miercoles", ventasPorDia(miercolesData));
        ventas.put("jueves", ventasPorDia(juevesData));
        ventas.put("viernes", ventasPorDia(viernesData));
        ventas.put("sabado", ventasPorDia(sabadoData));
        ventas.put("domingo", ventasPorDia(domingoData));

        // * Ciclo para sacar el dia con mayor numero de ventas */
        String mayoresVentas = null;
        double valorMayor = Double.MIN_VALUE;

        // * Ciclo para recorrer cada key del hashmap */
        for (String dia : ventas.keySet()) {
            double venta = ventas.get(dia);

            if (venta > valorMayor) {
                valorMayor = venta;
                mayoresVentas = dia;
            }
        }
        System.out.println("El dia que mas ventas tuvo fue el " + mayoresVentas);


        //* Hallar a que hora se movio mas dinero */


        //* Hashmap de las horas que mas se repiten cada dia */
        HashMap<String, Integer> horaDeCadaDia = new HashMap<String, Integer>();

        horaDeCadaDia.put("Lunes", hora(lunesData));
        horaDeCadaDia.put("Martes", hora(martesData));
        horaDeCadaDia.put("Miercoles", hora(miercolesData));
        horaDeCadaDia.put("Jueves", hora(juevesData));
        horaDeCadaDia.put("Viernes", hora(viernesData));
        horaDeCadaDia.put("Sabado", hora(sabadoData));
        horaDeCadaDia.put("Domingo", hora(domingoData));


        //* Hashmap para saber cuantas veces se repite un valor en el hashmap anterior */
        HashMap<Integer, Integer> repeticionDeHoras = new HashMap<>();

        //* Ciclo que recorre cada valor del hashmap "horaDeCadaDia" */
        for (int hora : horaDeCadaDia.values()) {
            repeticionDeHoras.put(hora, repeticionDeHoras.getOrDefault(hora, 0) + 1);
        }

        int horaMasRepetida = 0;
        int repMayor = 0;

        //* Ciclo para ver cual hora se repite mas */
        for (HashMap.Entry<Integer, Integer> entry : repeticionDeHoras.entrySet()) {
            if (entry.getValue() > repMayor) {
                repMayor = entry.getValue();
                horaMasRepetida = entry.getKey();
                
            }
        }

        //* Impresion de la hora mas repetida */
        System.out.print("La hora en la que más dinero se mueve es la hora " + horaMasRepetida + " con mayoría en ");
        
        //* Impresion de los dias en los que esta este valor */
        String separador = "";
        for (HashMap.Entry<String, Integer> entry : horaDeCadaDia.entrySet()) {
            if (entry.getValue() == horaMasRepetida) {
                System.out.print(separador + entry.getKey());
                separador = " y ";
           }
        }

    }
}
