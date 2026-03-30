//Compara elementos separados por una distancia llamada gap para ordenarlos
package algoritmos;

import modelo.DatosOrdenamiento;
import hilo.HiloOrdenamiento;

public class ShellSort {

    public void sort(DatosOrdenamiento datos, HiloOrdenamiento hilo) {
        int[] arreglo = datos.getArreglo();
        int n = arreglo.length;

        for (int gap = n / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < n; i++) {
                int temp = arreglo[i];
                for (int j = i - gap; j >= 0; j = j - gap) {
                    if (datos.getOrden().equals("Ascendente")) {
                        if (arreglo[j] > temp) {
                            arreglo[j + gap] = arreglo[j];
                            datos.setIntercambios(datos.getIntercambios() + 1);
                            arreglo[j] = temp;
                            hilo.actualizarVista(); // ← línea nueva
                        } else {
                            break;
                        }
                    } else {
                        if (arreglo[j] < temp) {
                            arreglo[j + gap] = arreglo[j];
                            datos.setIntercambios(datos.getIntercambios() + 1);
                            arreglo[j] = temp;
                            hilo.actualizarVista(); // ← línea nueva
                        } else {
                            break;
                        }
                    }
                    datos.setComparaciones(datos.getComparaciones() + 1);
                }
                datos.setIteraciones(datos.getIteraciones() + 1);
            }
        }
    }
}
