//Muestra 3 números en tiempo real (Comparaciones, intercambios, iteraciones)
package vista;

import modelo.DatosOrdenamiento;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;

public class PanelEstadisticas extends JPanel {

    private JLabel lblComparaciones;
    private JLabel lblIntercambios;
    private JLabel lblIteraciones;

    public PanelEstadisticas() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridLayout(2, 3, 10, 5));
        setBackground(new Color(30, 30, 30));
        setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.WHITE),
            "Estadísticas",
            0, 0,
            new Font("Arial", Font.BOLD, 14),
            Color.WHITE
        ));

        JLabel titComparaciones = new JLabel("Comparaciones", JLabel.CENTER);
        JLabel titIntercambios = new JLabel("Intercambios", JLabel.CENTER);
        JLabel titIteraciones = new JLabel("Iteraciones", JLabel.CENTER);

        titComparaciones.setForeground(Color.WHITE);
        titIntercambios.setForeground(Color.WHITE);
        titIteraciones.setForeground(Color.WHITE);

        lblComparaciones = new JLabel("0", JLabel.CENTER);
        lblIntercambios = new JLabel("0", JLabel.CENTER);
        lblIteraciones = new JLabel("0", JLabel.CENTER);

        lblComparaciones.setForeground(new Color(0, 191, 255));
        lblIntercambios.setForeground(new Color(255, 69, 0));
        lblIteraciones.setForeground(new Color(255, 165, 0));

        lblComparaciones.setFont(new Font("Arial", Font.BOLD, 24));
        lblIntercambios.setFont(new Font("Arial", Font.BOLD, 24));
        lblIteraciones.setFont(new Font("Arial", Font.BOLD, 24));

        add(titComparaciones);
        add(titIntercambios);
        add(titIteraciones);
        add(lblComparaciones);
        add(lblIntercambios);
        add(lblIteraciones);
    }

    public void actualizar(DatosOrdenamiento datos) {
        lblComparaciones.setText(String.valueOf(datos.getComparaciones()));
        lblIntercambios.setText(String.valueOf(datos.getIntercambios()));
        lblIteraciones.setText(String.valueOf(datos.getIteraciones()));
    }
}