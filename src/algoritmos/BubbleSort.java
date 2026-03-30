//ORDENAMIENTO DE BURBUJA: compara elementos vecinos y los intercambia si están en el orden incorrecto
package algoritmos;

import modelo.DatosOrdenamiento;
import hilo.HiloOrdenamiento;

public class BubbleSort {

    public void sort(DatosOrdenamiento datos, HiloOrdenamiento hilo) {
        int[] arreglo = datos.getArreglo();
        int n = arreglo.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (datos.getOrden().equals("Ascendente")) {
                    if (arreglo[j] > arreglo[j + 1]) {
                        int temp = arreglo[j];
                        arreglo[j] = arreglo[j + 1];
                        arreglo[j + 1] = temp;
                        datos.setIntercambios(datos.getIntercambios() + 1);
                        hilo.actualizarVista(); 
                    }
                } else {
                    if (arreglo[j] < arreglo[j + 1]) {
                        int temp = arreglo[j];
                        arreglo[j] = arreglo[j + 1];
                        arreglo[j + 1] = temp;
                        datos.setIntercambios(datos.getIntercambios() + 1);
                        hilo.actualizarVista(); 
                    }
                }
                datos.setComparaciones(datos.getComparaciones() + 1);
            }
            datos.setIteraciones(datos.getIteraciones() + 1);
        }
    }
}
