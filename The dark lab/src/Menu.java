import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {

    public static void main(String[] args) {
        JFrame frame = new JFrame("");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza el frame
        frame.setUndecorated(true); // Elimina los bordes y barra de título
        
        // Agrega un ActionListener para salir del modo de pantalla completa cuando se presiona ESC
        frame.getRootPane().getInputMap().put(javax.swing.KeyStroke.getKeyStroke("ESCAPE"), "cerrarFullscreen");
        frame.getRootPane().getActionMap().put("cerrarFullscreen", (Action) new AbstractAction(){
            public void actionPerformed(ActionEvent e){
                frame.dispose(); // Cierra el frame
            }
        });

        // Obtiene el dispositivo de pantalla actual
        GraphicsDevice dispositivo = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        
        // Verifica si el dispositivo de pantalla soporta el modo de pantalla completa
        if (dispositivo.isFullScreenSupported()) {
            // Establece el frame en modo de pantalla completa
            dispositivo.setFullScreenWindow(frame);
        } else {
            // Si el modo de pantalla completa no es compatible, muestra el frame en modo normal
            frame.setVisible(true);
        }
    }
}
