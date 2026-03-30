package vista;

import modelo.DatosOrdenamiento;
import hilo.HiloOrdenamiento;
import javax.swing.*;
import java.awt.*;

public class PanelControl extends JPanel {

    private DatosOrdenamiento datos;
    private PanelVisualizacion panelVisualizacion;
    private PanelEstadisticas panelEstadisticas;
    private HiloOrdenamiento hilo;

    // Componentes
    private JTextField txtDatos;
    private JButton btnCargar;
    private JButton btnAleatorio;
    private JComboBox<String> cmbAlgoritmo;
    private JComboBox<String> cmbOrden;
    private JComboBox<String> cmbVelocidad;
    private JButton btnIniciar;
    private JButton btnDetener;
    private JButton btnReiniciar;

    public PanelControl(DatosOrdenamiento datos,
                        PanelVisualizacion panelVisualizacion,
                        PanelEstadisticas panelEstadisticas) {
        this.datos = datos;
        this.panelVisualizacion = panelVisualizacion;
        this.panelEstadisticas = panelEstadisticas;
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridLayout(11, 1, 5, 5));
        setBackground(new Color(30, 30, 30));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Etiqueta de datos
        JLabel lblDatos = new JLabel("Datos de entrada (separados por coma):");
        lblDatos.setForeground(Color.WHITE);
        add(lblDatos);

        // Campo de texto
        txtDatos = new JTextField();
        txtDatos.setBackground(new Color(50, 50, 50));
        txtDatos.setForeground(Color.WHITE);
        add(txtDatos);

        // Botones cargar y aleatorio
        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 5, 0));
        panelBotones.setBackground(new Color(30, 30, 30));
        btnCargar = new JButton("Cargar");
        btnAleatorio = new JButton("Aleatorio");
        btnCargar.setBackground(new Color(50, 50, 50));
        btnCargar.setForeground(Color.WHITE);
        btnAleatorio.setBackground(new Color(50, 50, 50));
        btnAleatorio.setForeground(Color.WHITE);
        panelBotones.add(btnCargar);
        panelBotones.add(btnAleatorio);
        add(panelBotones);

        // Algoritmo
        JLabel lblAlgoritmo = new JLabel("Algoritmo:");
        lblAlgoritmo.setForeground(Color.WHITE);
        add(lblAlgoritmo);
        cmbAlgoritmo = new JComboBox<>(new String[]{
            "Bubble Sort", "Shell Sort", "Quick Sort"
        });
        cmbAlgoritmo.setBackground(new Color(50, 50, 50));
        cmbAlgoritmo.setForeground(Color.WHITE);
        add(cmbAlgoritmo);

        // Orden
        JLabel lblOrden = new JLabel("Orden:");
        lblOrden.setForeground(Color.WHITE);
        add(lblOrden);
        cmbOrden = new JComboBox<>(new String[]{
            "Ascendente", "Descendente"
        });
        cmbOrden.setBackground(new Color(50, 50, 50));
        cmbOrden.setForeground(Color.WHITE);
        add(cmbOrden);

        // Velocidad
        JLabel lblVelocidad = new JLabel("Velocidad:");
        lblVelocidad.setForeground(Color.WHITE);
        add(lblVelocidad);
        cmbVelocidad = new JComboBox<>(new String[]{
            "Lento (500ms)", "Medio (100ms)", "Rápido (20ms)"
        });
        cmbVelocidad.setBackground(new Color(50, 50, 50));
        cmbVelocidad.setForeground(Color.WHITE);
        add(cmbVelocidad);

        // Botones iniciar y detener
        JPanel panelAcciones = new JPanel(new GridLayout(1, 2, 5, 0));
        panelAcciones.setBackground(new Color(30, 30, 30));
        btnIniciar = new JButton("Iniciar");
        btnDetener = new JButton("Detener");
        btnIniciar.setBackground(new Color(0, 150, 0));
        btnIniciar.setForeground(Color.WHITE);
        btnDetener.setBackground(new Color(150, 0, 0));
        btnDetener.setForeground(Color.WHITE);
        btnDetener.setEnabled(false);
        panelAcciones.add(btnIniciar);
        panelAcciones.add(btnDetener);
        add(panelAcciones);

        // Botón reiniciar separado
        btnReiniciar = new JButton("Reiniciar");
        btnReiniciar.setBackground(new Color(0, 100, 150));
        btnReiniciar.setForeground(Color.WHITE);
        add(btnReiniciar);

        // Acciones de los botones
        btnCargar.addActionListener(e -> cargarDatos());
        btnAleatorio.addActionListener(e -> generarAleatorio());
        btnIniciar.addActionListener(e -> iniciarOrdenamiento());
        btnDetener.addActionListener(e -> detenerOrdenamiento());
        btnReiniciar.addActionListener(e -> reiniciarTodo());
    }

    private void cargarDatos() {
        String texto = txtDatos.getText().trim();
        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Por favor ingresá los datos.",
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            String[] partes = texto.split(",");
            int[] arreglo = new int[partes.length];
            for (int i = 0; i < partes.length; i++) {
                arreglo[i] = Integer.parseInt(partes[i].trim());
            }
            datos.setArreglo(arreglo);
            datos.setColores(new int[arreglo.length]);
            panelVisualizacion.actualizar(datos);
            JOptionPane.showMessageDialog(this,
                "Datos cargados correctamente.",
                "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Solo se permiten números enteros separados por coma.",
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void generarAleatorio() {
        int n = (int) (Math.random() * 26) + 5;
        int[] arreglo = new int[n];
        for (int i = 0; i < n; i++) {
            arreglo[i] = (int) (Math.random() * 100) + 1;
        }
        datos.setArreglo(arreglo);
        datos.setColores(new int[n]);
        txtDatos.setText("");
        panelVisualizacion.actualizar(datos);
    }

    private void iniciarOrdenamiento() {
        if (datos.getArreglo() == null || datos.getArreglo().length == 0) {
            JOptionPane.showMessageDialog(this,
                "Primero cargá los datos.",
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Restaurar arreglo original
        datos.setArreglo(datos.getArregloOriginal().clone());

        // Configurar opciones
        datos.setAlgoritmo((String) cmbAlgoritmo.getSelectedItem());
        datos.setOrden((String) cmbOrden.getSelectedItem());

        String velocidad = (String) cmbVelocidad.getSelectedItem();
        if (velocidad.contains("500")) {
            datos.setVelocidad(500);
        } else if (velocidad.contains("100")) {
            datos.setVelocidad(100);
        } else {
            datos.setVelocidad(20);
        }

        // Resetear colores
        datos.setColores(new int[datos.getArreglo().length]);

        // Arrancar hilo
        btnIniciar.setEnabled(false);
        btnDetener.setEnabled(true);
        hilo = new HiloOrdenamiento(datos, panelVisualizacion, panelEstadisticas);
        hilo.start();
    }

    private void detenerOrdenamiento() {
        if (hilo != null) {
            hilo.detener();
        }
        btnIniciar.setEnabled(true);
        btnDetener.setEnabled(false);
    }

    private void reiniciarTodo() {
        if (hilo != null) {
            hilo.detener();
        }
        if (datos.getArregloOriginal() != null) {
            datos.setArreglo(datos.getArregloOriginal().clone());
            datos.setColores(new int[datos.getArreglo().length]);
        }
        datos.reiniciarEstadisticas();
        panelVisualizacion.actualizar(datos);
        panelEstadisticas.actualizar(datos);
        btnIniciar.setEnabled(true);
        btnDetener.setEnabled(false);
    }
}