package vista;

import modelo.DatosOrdenamiento;
import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private DatosOrdenamiento datos;
    private PanelControl panelControl;
    private PanelVisualizacion panelVisualizacion;
    private PanelEstadisticas panelEstadisticas;

    public VentanaPrincipal() {
        datos = new DatosOrdenamiento();
        initComponents();
    }

    private void initComponents() {
        // Configuración de la ventana
        setTitle("Visualizador de Algoritmos de Ordenamiento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setBackground(new Color(20, 20, 20));
        getContentPane().setBackground(new Color(20, 20, 20));

        // Crear paneles
        panelVisualizacion = new PanelVisualizacion();
        panelEstadisticas = new PanelEstadisticas();
        panelControl = new PanelControl(datos, panelVisualizacion, panelEstadisticas);

        // Panel derecho que contiene visualización y estadísticas
        JPanel panelDerecho = new JPanel(new BorderLayout(0, 10));
        panelDerecho.setBackground(new Color(20, 20, 20));
        panelDerecho.add(panelVisualizacion, BorderLayout.CENTER);
        panelDerecho.add(panelEstadisticas, BorderLayout.SOUTH);

        // Layout principal
        setLayout(new BorderLayout(10, 10));
        add(panelControl, BorderLayout.WEST);
        add(panelDerecho, BorderLayout.CENTER);

        // Mostrar ventana
        setVisible(true);
    }
}
