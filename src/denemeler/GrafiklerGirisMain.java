package denemeler;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;




public class GrafiklerGirisMain {

public static void main(int[] cizilecekler) throws IOException{
	GrafiklerGirisPencere pencere=new GrafiklerGirisPencere(cizilecekler);
	pencere.setLocationRelativeTo(null);
	pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	pencere.setBounds(100, 100, 814, 468);
	pencere.setVisible(true);
	
}

	
}
