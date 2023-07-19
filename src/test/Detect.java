package test;
import javax.swing.JFrame;
import javax.swing.UIManager;
public class Detect extends JFrame{
    public Detect(){
        UIManager.LookAndFeelInfo[] laf = UIManager.getInstalledLookAndFeels();
        for(int i =0; i < laf.length; i++){
            System.out.println("Nombre: " +laf[i].getName());
            System.out.println("Clase: " +laf[i].getClassName());
        }
    }
    public static void main(String[] args) {
        Detect app = new Detect();
    }
}