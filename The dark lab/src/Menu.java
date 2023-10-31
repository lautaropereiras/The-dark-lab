import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu {

    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Menu window = new Menu();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Menu() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.getContentPane().setLayout(null);

        // Crea un panel para contener la etiqueta con la imagen
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1280, 986);
        frame.getContentPane().add(panel);


        // Crea la etiqueta con la imagen escalada
        JLabel etiqueta = new JLabel("");
        etiqueta.setIcon(new ImageIcon("Imagenes//MenuIcon (1).gif"));
        

        // Añade la etiqueta al panel en lugar de directamente al JFrame
        panel.add(etiqueta);

        frame.setVisible(true);
    }
}
