package gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CargaImagen extends JPanel {
	private Image imagenFondo;

	public CargaImagen() {
        // Cargar la imagen de fondo
    	try {
            // Cargar la imagen de fondo
            imagenFondo = new ImageIcon("src/img/Aluraoracle.png").getImage();
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar la imagen de fondo
        g.drawImage(imagenFondo, 40, 90, 561, 230, this);
    
    }	
	
	
}
