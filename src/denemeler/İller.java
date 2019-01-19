package denemeler;
import java.util.*;
import java.util.LinkedList;

public class �ller {
	double lat; 
	double longg;
	int ID;
	double rak�m;
	String isim;
	int[] komsular; //�lin komsular�n�n plakalar�n� tutar
	�ller[] komsular_nesne; //�lin komsular�n� �ller tipinde nesne olarak tutar
	Double[] weights; //�lin kom�ular�n�n a��rl�klar�n� tutar
	public �ller(double gelenLat, double gelenLongg, int gelenID, double gelenRak�m, String gelen�sim )
	{
		this.lat=gelenLat;
		this.longg=gelenLongg;
		this.ID=gelenID;
		this.rak�m=gelenRak�m;
		this.isim=gelen�sim;
	}
	void setNeighborhoods(String[] neighborhoods){
		this.komsular= new int[neighborhoods.length-1];
		for (int i = 0; i < this.komsular.length; i++) {
			this.komsular[i]=Integer.parseInt(neighborhoods[i+1]);
		}
		this.weights= new Double[this.komsular.length];
	}
	void setNeighborhoods(java.util.LinkedList<�ller> linkedlist){
		this.komsular_nesne= new �ller[this.komsular.length];
		for (int i = 0; i < this.komsular_nesne.length; i++) {
			//System.out.println(linkedlist.size());
			this.komsular_nesne[i]=linkedlist.get(this.komsular[i]);
		}
	}
}
