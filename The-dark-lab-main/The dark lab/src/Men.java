import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Men {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Men window = new Men();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Men() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1615, 875);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.getContentPane().setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1600, 839);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(0, 0, 1600, 839);
        lblNewLabel.setIcon(new ImageIcon("Imag\\FondoGif1600x900.gif"));
        panel.add(lblNewLabel);
        
        JButton BotonInicio = new JButton("Inicio");
        BotonInicio.setBounds(650, 360, 320, 138);
        panel.add(BotonInicio);
        BotonInicio.setOpaque(false);
        
        BotonInicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PA newframe = new PA();
                newframe.setVisible(true);
                frame.dispose();          	
            }		
        });
        
        JButton BotonOptions = new JButton("Options");
        BotonOptions.setBounds(630, 525, 360, 100);
        panel.add(BotonOptions);
        BotonOptions.setOpaque(false);
        
        BotonOptions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PA newframe = new PA();
                newframe.setVisible(true);
                frame.dispose();          	
            }		
        });
        
        
        JButton BotonExit = new JButton("Exit");
        BotonExit.setBounds(670, 648, 250, 133);
        panel.add(BotonExit);
        BotonExit.setOpaque(false);
        
        BotonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	frame.dispose();
            	
            }		
        });

		
		
	
	}
}
