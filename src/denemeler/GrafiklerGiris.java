package denemeler;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class GrafiklerGiris extends JLabel {
private int x2;
private int y2;
private int x1;
private int y1;
JButton [] buttons = new JButton[82];
int x[]= new int [82];
int y[]= new int [82];
int[] cizilecekler;
	public GrafiklerGiris(int[] gelenCizilecekler) throws IOException{
	this.cizilecekler = gelenCizilecekler;
	FareDinleyici dinleyici = new FareDinleyici();
	addMouseMotionListener(dinleyici);
	File kor = new File("kor.txt");
	BufferedReader reader = new BufferedReader(new FileReader(kor));
	String sentence;
	String [] values= new String[2];
	int i;
	i=1;
	while((sentence = reader.readLine())!=null){
		values=sentence.split(",");
		x[i] = Integer.parseInt(values[0]);
		y[i] = Integer.parseInt(values[1]);
		buttons[i] = new JButton("");
		buttons[i].setBounds(x[i], y[i], 10, 10);
		i++;
	}
	
	
	}

	@Override
protected void paintComponent(Graphics g){
		super.paintComponent(g);
		int[] dizi = this.cizilecekler;
		int a,b;
		for (int j = 0; j < dizi.length; j++) {
			a=dizi[j];
			b=dizi[j+1];
			g.setColor(Color.RED);
		    g.drawLine(x[a], y[a], x[b], y[b]);
		    if(b==dizi[dizi.length-1]){
		    	break;
		    }
		}
		
	
}
private class FareDinleyici extends MouseMotionAdapter{
	
	@Override
public void mouseDragged(MouseEvent e){		
	super.mouseDragged(e);

	x1=e.getX();
	y1=e.getY();
	repaint();
	}
		
}
}


