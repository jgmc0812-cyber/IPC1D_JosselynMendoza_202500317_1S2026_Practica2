//Elegir un pivote y reorganizar el arreglo alrededor de él
package algoritmos;

import modelo.DatosOrdenamiento;
import hilo.HiloOrdenamiento;

public class QuickSort {

    public void quickSort(DatosOrdenamiento datos, int low, int high, HiloOrdenamiento hilo) {
        if (low >= high) {
            return;
        }
        int pi = partition(datos, low, high, hilo);
        quickSort(datos, low, pi - 1, hilo);
        quickSort(datos, pi + 1, high, hilo);
    }

    public int partition(DatosOrdenamiento datos, int low, int high, HiloOrdenamiento hilo) {
        int[] arreglo = datos.getArreglo();
        int pivote = arreglo[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            datos.setComparaciones(datos.getComparaciones() + 1);

            boolean condicion;
            if (datos.getOrden().equals("Ascendente")) {
                condicion = arreglo[j] <= pivote;
            } else {
                condicion = arreglo[j] >= pivote;
            }

            if (condicion) {
                i++;
                int temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
                datos.setIntercambios(datos.getIntercambios() + 1);
                hilo.actualizarVista(); // ← línea nueva
            }
        }

        int temp = arreglo[i + 1];
        arreglo[i + 1] = arreglo[high];
        arreglo[high] = temp;
        datos.setIteraciones(datos.getIteraciones() + 1);
        hilo.actualizarVista(); // ← línea nueva

        return i + 1;
    }
}