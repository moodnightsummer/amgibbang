package bbang;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;

public class bbbb extends JFrame{
	JPanel contentPane;
	JLabel imageLabel = new JLabel();
	
	
	public bbbb() {
		try {
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			contentPane = (JPanel) getContentPane();
            contentPane.setLayout(new BorderLayout());
            setSize(new Dimension(700, 700));
            setTitle("Your Job Crashed!");
            
            ImageIcon ii = new ImageIcon(this.getClass().getResource(
                    "rundora1.gif"));
            imageLabel.setIcon(ii);
            contentPane.setLayout(null);
            imageLabel.setLayout(null);
            contentPane.setBounds(0, 0, 700, 700);
            imageLabel.setBounds(0, 500, 200, 200);
            contentPane.add(imageLabel);
            // show it
            this.setLocationRelativeTo(null);
            this.setVisible(true);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		bbbb b = new bbbb();
	}
	
	
	
	
}
