package denemeler;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class GrafiklerGirisPencere extends JFrame {
	private int x2;
	private int x1;
	private int y1;
	private int y2;
	GrafiklerGiris panel;
public GrafiklerGirisPencere(int[] cizilecekler) throws IOException{
	GrafiklerGiris panel=new GrafiklerGiris(cizilecekler);
	setLayout(new BorderLayout());
	add(panel,BorderLayout.CENTER);
	Container content = panel;
	Image img = new ImageIcon(this.getClass().getResource("/türkiye.png")).getImage();
	panel.setIcon(new ImageIcon(img));
	Scanner keyboard = new Scanner(System.in);
	File kor = new File("kor.txt");
	BufferedReader reader = new BufferedReader(new FileReader(kor));
	String sentence;
	String [] values= new String[2];
	int x,y,i;
	i=1;
	JButton [] buttons = new JButton[82];
	while((sentence = reader.readLine())!=null){
		values=sentence.split(",");
		x = Integer.parseInt(values[0]);
		y = Integer.parseInt(values[1]);
		buttons[i] = new JButton("");
		buttons[i].setBounds(x, y, 10, 10);
		panel.add(buttons[i]);
		i++;
	}
	
	}

	
	
}
	

