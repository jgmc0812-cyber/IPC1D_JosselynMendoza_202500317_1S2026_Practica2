package practica2;
//CLASE PRINCIPAL, PARA EJECUTAR EL PROGRAMA

import vista.VentanaPrincipal;
import javax.swing.SwingUtilities;

public class Practica2 {

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal();
        });
        
    }
    
}
