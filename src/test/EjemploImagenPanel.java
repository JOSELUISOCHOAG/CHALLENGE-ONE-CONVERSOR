package test;

import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;

public class EjemploImagenPanel extends JPanel {
    private Image imagenFondo;

    public EjemploImagenPanel() {
        // Cargar la imagen de fondo
    	try {
            // Cargar la imagen de fondo
            imagenFondo = new ImageIcon("src/img/logo_oracleAlura.jpg").getImage();
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar la imagen de fondo
        g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de imagen de fondo en JPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        EjemploImagenPanel panel = new EjemploImagenPanel();
        panel.setLayout(new FlowLayout());

        JButton boton = new JButton("Botón");
        panel.add(boton);

        frame.getContentPane().add(panel);
        frame.setSize(700, 300);
        frame.setVisible(true);
    }
}
