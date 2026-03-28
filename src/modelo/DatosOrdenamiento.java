
package modelo;

//TODOS LOS DATOS SE ALMACENARÁN AQUÍ. Guarda todos los datos que las demás clases necesitan compartir.

public class DatosOrdenamiento {
    // Atributos
    private int[] arreglo;
    private int[] arregloOriginal;
    private int comparaciones;
    private int intercambios;
    private int iteraciones;
    private String algoritmo;
    private String orden;
    private int velocidad;
    
    //Constructor
    public DatosOrdenamiento(){
        comparaciones = 0;
        intercambios = 0;
        iteraciones = 0;
        algoritmo = "Bubble Sort";
        orden = "Ascendente";
        velocidad = 0;
    }
    
    //get y set del arreglo
    public int[] getArreglo(){
        return arreglo;
    }
    
    public void setArreglo (int[] arreglo){
        this.arreglo = arreglo;
        this.arregloOriginal = arreglo.clone();
    }
    
    //solo lleva get porque no queremos darle ningún valor
    public int[] getArregloOriginal (){
        return arregloOriginal;
    }
    
    //get y set de comparaciones
    public int getComparaciones(){
        return comparaciones;
    }
    
    public void setComparaciones(int comparaciones){
        this.comparaciones = comparaciones;
    }
    
    //get y set de intercambios
    public int getIntercambios(){
        return intercambios;
    }
    
    public void setIntercambios(int intercambios){
        this.intercambios = intercambios;
    }
    
    //get y set de iteraciones
    public int getIteraciones(){
        return iteraciones;
    }
    
    public void setIteraciones(int iteraciones){
        this.iteraciones = iteraciones;
    }
    
    //get y set de algoritmo
    public String getAlgoritmo(){
        return algoritmo;
    }
    
    public void setAlgortimo(String algoritmo){
        this.algoritmo = algoritmo;
    }
    
    //get y set de orden
    public String getOrden(){
        return orden;
    }
    
    public void setOrden(String orden){
        this.orden = orden;
    }
    
    //get y set de velocidad
    public int getVelocidad(){
        return velocidad;
    }
    
    public void setVelocidad(int velocidad){
        this.velocidad = velocidad;
    }
    
    //reinicia los contadores
    public void reiniciarEstadisticas(){
        comparaciones = 0;
        iteraciones = 0;
        intercambios = 0;
    }
    
}
