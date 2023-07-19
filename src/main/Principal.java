package main;

import java.awt.EventQueue;

import javax.swing.UIManager;

import gui.Aplicacion;

public class Principal {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 try{
	            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
	        } catch(Exception e){
	            System.out.println(e);
	        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aplicacion frame = new Aplicacion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
