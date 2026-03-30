//Corre el algortimo en paralelo con la interfaz
package hilo;

import algoritmos.BubbleSort;
import algoritmos.ShellSort;
import algoritmos.QuickSort;
import modelo.DatosOrdenamiento;
import vista.PanelVisualizacion;
import vista.PanelEstadisticas;
import javax.swing.SwingUtilities;

public class HiloOrdenamiento extends Thread {

    private DatosOrdenamiento datos;
    private PanelVisualizacion panelVisualizacion;
    private PanelEstadisticas panelEstadisticas;
    private boolean corriendo;

    public HiloOrdenamiento(DatosOrdenamiento datos,
                            PanelVisualizacion panelVisualizacion,
                            PanelEstadisticas panelEstadisticas) {
        this.datos = datos;
        this.panelVisualizacion = panelVisualizacion;
        this.panelEstadisticas = panelEstadisticas;
        this.corriendo = true;
    }

    @Override
    public void run() {
        datos.reiniciarEstadisticas();
        long inicio = System.currentTimeMillis();
        
        String algoritmo = datos.getAlgoritmo();

        if (algoritmo.equals("Bubble Sort")) {
            BubbleSort bubble = new BubbleSort();
            bubble.sort(datos, this);
        } else if (algoritmo.equals("Shell Sort")) {
            ShellSort shell = new ShellSort();
            shell.sort(datos, this);
        } else if (algoritmo.equals("Quick Sort")) {
            QuickSort quick = new QuickSort();
            quick.quickSort(datos, 0, datos.getArreglo().length - 1, this);
        }
        
        long tiempoTotal = System.currentTimeMillis() - inicio;
        reporte.GeneradorReporte.generarReporte(datos, tiempoTotal);
    
        SwingUtilities.invokeLater(() -> {
            panelVisualizacion.actualizar(datos);
            panelEstadisticas.actualizar(datos);
        });
    }

    public void actualizarVista() {
        try {
            Thread.sleep(datos.getVelocidad());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        SwingUtilities.invokeLater(() -> {
            panelVisualizacion.actualizar(datos);
            panelEstadisticas.actualizar(datos);
        });
    }

    public void detener() {
        corriendo = false;
    }
    
    public boolean isCorriendo() {
        return corriendo;
    }
}
