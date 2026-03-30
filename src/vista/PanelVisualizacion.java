package vista;

import modelo.DatosOrdenamiento;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class PanelVisualizacion extends JPanel {

    private DefaultCategoryDataset dataset;
    private BarRenderer renderer;
    private JFreeChart chart;

    // Colores para cada estado
    public static final Color COLOR_NORMAL = new Color(0, 191, 255);
    public static final Color COLOR_COMPARANDO = new Color(255, 165, 0);
    public static final Color COLOR_INTERCAMBIANDO = new Color(255, 69, 0);
    public static final Color COLOR_ORDENADO = new Color(0, 200, 0);

    public PanelVisualizacion() {
        setLayout(new BorderLayout());
        initChart();
    }

    private void initChart() {
        dataset = new DefaultCategoryDataset();

        chart = ChartFactory.createBarChart(
            "",           // título
            "",           // eje x
            "",           // eje y
            dataset,
            PlotOrientation.VERTICAL,
            false,        // leyenda
            false,        // tooltips
            false         // urls
        );

        // Estilo oscuro
        chart.setBackgroundPaint(new Color(20, 20, 20));

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(30, 30, 30));
        plot.setRangeGridlinePaint(Color.DARK_GRAY);

        renderer = new BarRenderer() {
            @Override
            public java.awt.Paint getItemPaint(int row, int column) {
                return COLOR_NORMAL;
            }
        };

        renderer.setDrawBarOutline(false);
        plot.setRenderer(renderer);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBackground(new Color(30, 30, 30));
        add(chartPanel, BorderLayout.CENTER);
    }

    public void actualizar(DatosOrdenamiento datos) {
        if (datos.getArreglo() == null) return;

        dataset.clear();
        int[] arreglo = datos.getArreglo();
        int[] colores = datos.getColores();

        for (int i = 0; i < arreglo.length; i++) {
            dataset.addValue(arreglo[i], "valor", String.valueOf(i));
        }

        renderer = new BarRenderer() {
            @Override
            public java.awt.Paint getItemPaint(int row, int column) {
                if (colores == null) return COLOR_NORMAL;
                switch (colores[column]) {
                    case 1: return COLOR_COMPARANDO;
                    case 2: return COLOR_INTERCAMBIANDO;
                    case 3: return COLOR_ORDENADO;
                    default: return COLOR_NORMAL;
                }
            }
        };

        renderer.setDrawBarOutline(false);
        chart.getCategoryPlot().setRenderer(renderer);
    }
}
