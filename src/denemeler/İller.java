package denemeler;
import java.util.*;
import java.util.LinkedList;

public class Ýller {
	double lat; 
	double longg;
	int ID;
	double rakým;
	String isim;
	int[] komsular; //Ýlin komsularýnýn plakalarýný tutar
	Ýller[] komsular_nesne; //Ýlin komsularýný Ýller tipinde nesne olarak tutar
	Double[] weights; //Ýlin komþularýnýn aðýrlýklarýný tutar
	public Ýller(double gelenLat, double gelenLongg, int gelenID, double gelenRakým, String gelenÝsim )
	{
		this.lat=gelenLat;
		this.longg=gelenLongg;
		this.ID=gelenID;
		this.rakým=gelenRakým;
		this.isim=gelenÝsim;
	}
	void setNeighborhoods(String[] neighborhoods){
		this.komsular= new int[neighborhoods.length-1];
		for (int i = 0; i < this.komsular.length; i++) {
			this.komsular[i]=Integer.parseInt(neighborhoods[i+1]);
		}
		this.weights= new Double[this.komsular.length];
	}
	void setNeighborhoods(java.util.LinkedList<Ýller> linkedlist){
		this.komsular_nesne= new Ýller[this.komsular.length];
		for (int i = 0; i < this.komsular_nesne.length; i++) {
			//System.out.println(linkedlist.size());
			this.komsular_nesne[i]=linkedlist.get(this.komsular[i]);
		}
	}
}
