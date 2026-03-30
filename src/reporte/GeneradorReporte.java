package reporte;

import modelo.DatosOrdenamiento;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class GeneradorReporte {

    public static void generarReporte(DatosOrdenamiento datos, long tiempoMs) {
        String html = "<!DOCTYPE html><html><head><meta charset='UTF-8'>"
            + "<title>Reporte de Ordenamiento</title>"
            + "<style>"
            + "body { font-family: Arial; background: #1e1e1e; color: white; padding: 20px; }"
            + "h1 { color: #00bfff; }"
            + "h2 { color: #ffa500; }"
            + "table { border-collapse: collapse; width: 100%; }"
            + "th { background: #333; padding: 10px; }"
            + "td { border: 1px solid #555; padding: 8px; text-align: center; }"
            + "</style></head><body>"
            + "<h1>Reporte de Ordenamiento</h1>"
            + "<h2>Información General</h2>"
            + "<p><b>Algoritmo:</b> " + datos.getAlgoritmo() + "</p>"
            + "<p><b>Orden:</b> " + datos.getOrden() + "</p>"
            + "<p><b>Velocidad:</b> " + datos.getVelocidad() + " ms</p>"
            + "<p><b>Tiempo total:</b> " + tiempoMs + " ms</p>"
            + "<h2>Arreglos</h2>"
            + "<p><b>Arreglo original:</b> " + Arrays.toString(datos.getArregloOriginal()) + "</p>"
            + "<p><b>Arreglo ordenado:</b> " + Arrays.toString(datos.getArreglo()) + "</p>"
            + "<h2>Estadísticas</h2>"
            + "<table><tr><th>Comparaciones</th><th>Intercambios</th><th>Iteraciones</th></tr>"
            + "<tr><td>" + datos.getComparaciones() + "</td>"
            + "<td>" + datos.getIntercambios() + "</td>"
            + "<td>" + datos.getIteraciones() + "</td></tr>"
            + "</table>"
            + "</body></html>";

        try {
            FileWriter fw = new FileWriter("reporte.html");
            fw.write(html);
            fw.close();
            javax.swing.JOptionPane.showMessageDialog(null,
                "Reporte generado: reporte.html",
                "Reporte",
                javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            System.err.println("Error al generar reporte: " + e.getMessage());
        }
    }
}
