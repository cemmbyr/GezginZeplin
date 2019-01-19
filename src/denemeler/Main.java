package denemeler;
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException{
		System.out.println("***ZepemeyenLin'e Hoþ Geldiniz***");
		//Graph graph = new Graph(10);
		//graph.Dijkstra(graph.linkedlist);
		funcZeplin();
		int[] cizilecekler = {34,41,54,2};
		//GrafiklerGirisMain ciz = new GrafiklerGirisMain(cizilecekler);
		denemeler.GrafiklerGirisMain.main(cizilecekler);
		System.out.println((javax.swing.JComponent.class));
		//funcGraph(10);
		
	}
	public static void funcZeplin() throws IOException{
		Scanner scanner1 = new Scanner(System.in);
		int passengers=1;
		int islem;
		int beginningIndex;
		int targetIndex;
		int preSetTicketPrice;
		/*System.out.println("Yolcu Sayýsýný 5-50 arasýnda giriniz:");
		while(passengers>50 || passengers<5){
			passengers = scanner1.nextInt();
			if(passengers>50 || passengers<5){
				System.out.println("Lütfen 5-50 arasýnda bir sayý giriniz");
			}
		}
		Zeplin zeplin = new Zeplin(passengers);*/
		System.out.println("Ýþlem Seçiniz\n%50 Kâr problemi:1\nSabit Ücret Problemi: 2");
		islem = scanner1.nextInt();
		if(islem==1){
			System.out.println("Baþlangýç ili giriniz:");
			beginningIndex= scanner1.nextInt();
			System.out.println("Varýþ ili giriniz: ");
			targetIndex = scanner1.nextInt();
			prob1(beginningIndex,targetIndex);
		}
		else if(islem==2){
			System.out.println("Baþlangýç ili giriniz:");
			beginningIndex= scanner1.nextInt();
			System.out.println("Varýþ ili giriniz: ");
			targetIndex = scanner1.nextInt();
			System.out.println("Sabit ücreti giriniz");
			preSetTicketPrice = scanner1.nextInt();
			prob2(beginningIndex,targetIndex,preSetTicketPrice);
		}
		
	}
		public static void prob1(int beginningIndex, int targetIndex) throws IOException{
			Zeplin[] zeplins = new Zeplin[5];
			Graph[] graphs = new Graph[5];
			int passengers;
			for (int i = 0; i < zeplins.length; i++) {
				passengers = (i+1)*10;
				zeplins[i] = new Zeplin(passengers);
				graphs[i] = new Graph(passengers);
				graphs[i].Dijkstra(graphs[i].linkedlist, zeplins[i], beginningIndex, targetIndex);
				System.out.println("Ticket Price = "+zeplins[i].ticketPrice+"\n");
			}
		}
		public  static void prob2(int beginningIndex, int targetIndex, int preSetTicketPrice) throws IOException{
			Double maxProfit = Double.MIN_VALUE;
			int maxProfitPassengers = 0; 
			Zeplin[] zeplins = new Zeplin[46];
			Graph[] graphs = new Graph[46];
			int passengers= 0;
			for (int i = 0; i < zeplins.length; i++) {
				passengers = i+5;
				zeplins[i] = new Zeplin(passengers);
				graphs[i] = new Graph(passengers);
				graphs[i].Dijkstra(graphs[i].linkedlist, zeplins[i], beginningIndex, targetIndex, preSetTicketPrice);
				if(zeplins[i].profit > maxProfit){
					maxProfit = zeplins[i].profit;
					maxProfitPassengers = passengers;
				}
			}
			System.out.println("Maximum kar: "+passengers+" yolcuda elde edilir: "+maxProfit);
		}
	/*public static void funcGraph(int passengers)throws IOException{
		Scanner scanner = new Scanner(System.in);
		LinkedList<Ýller> linkedlist = new LinkedList<Ýller>();
		linkedlist.add(null);
		File iller = new File("iller.txt");
		File neighborhoods = new File("neighborhoods.txt");
		BufferedReader reader_iller = null;
		BufferedReader reader_neighborhoods = null;
		boolean exists = iller.exists();
		if(exists){
			exists = neighborhoods.exists();
			if(exists){
				reader_iller = new BufferedReader(new FileReader(iller));
				reader_neighborhoods= new BufferedReader(new FileReader(neighborhoods));
				String sentence=reader_iller.readLine();
				String[] values = new String[5];
				String[] neighbors;
				Double lat,longg,rakým;
				int ID;
				String isim;
				Ýller ArrayOfObjects[]= new Ýller[81];
				int i=0;
				while ((sentence= reader_iller.readLine()) != null) {//Creating objects from "iller.txt" dynamically
					values=sentence.split(",");
					lat=Double.parseDouble(values[0]);
					longg=Double.parseDouble(values[1]);
					ID=Integer.parseInt(values[2]);
					rakým=Double.parseDouble(values[3]);
					isim=values[4];
					ArrayOfObjects[i]= new Ýller(lat,longg,ID,rakým,isim);
					neighbors= reader_neighborhoods.readLine().split(",");//Reading neighborhoods from "neighborhoods.txt"
					ArrayOfObjects[i].setNeighborhoods(neighbors);//Setting neighborhoods for all objects
					linkedlist.add(ArrayOfObjects[i]);
					i++;
				}
				CreateGraph(linkedlist);
				setWeights(linkedlist, passengers);
				System.out.println("Baþlangýç düðümünü giriniz:");
				int baslangic=scanner.nextInt();
				Dijkstra(linkedlist,baslangic);
			}
			else
				System.out.println("Belirtilen Dosya Bulunamadý: neighborhoods.txt");
		}
		else
			System.out.println("Belirtilen Dosya Bulunamadý: iller.txt");
	}
		
		public static void CreateGraph(java.util.LinkedList<Ýller> linkedlist)
		{
			for (int i = 1; i < linkedlist.size(); i++) {
				linkedlist.get(i).setNeighborhoods(linkedlist);
			}
		}
		public static void setWeights(java.util.LinkedList<Ýller> linkedlist,int passengers){
			double lat1,lat2,long1,long2,theta,miles,kilometers,rak1,rak2,rakfark,angle=0.0,distance;
			for (int i = 1; i < linkedlist.size(); i++) {
				lat1=linkedlist.get(i).lat;
				long1=linkedlist.get(i).longg;
				rak1= linkedlist.get(i).rakým * 0.001;
				for (int j = 0; j < linkedlist.get(i).komsular_nesne.length ; j++) {
					rak2 = linkedlist.get(i).komsular_nesne[j].rakým * 0.001;
					rakfark=rak2-rak1;
					lat2=linkedlist.get(i).komsular_nesne[j].lat;
					long2=linkedlist.get(i).komsular_nesne[j].longg;
					theta = long1-long2;
					miles = (Math.sin(Math.toRadians(lat1))*Math.sin(Math.toRadians(lat2))) + (Math.cos(Math.toRadians(lat1))*Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta)));
					miles = Math.acos(miles);
					miles = Math.toDegrees(miles);
					miles = miles * 60 * 1.1515;
					kilometers = miles * 1.609344;
					angle = Math.atan2(rakfark, kilometers);
					angle = Math.toDegrees(angle);
					angle = Math.abs(angle);
					distance = kilometers * (1/Math.cos(angle));
					distance = Math.abs(distance);
					linkedlist.get(i).weights[j] = distance;
					if((angle-passengers) < 30){
						linkedlist.get(i).weights[j] = Double.MAX_VALUE;
					}
				}	
			}
		}

		public static void Dijkstra(java.util.LinkedList<Ýller> linkedlist, int baslangic){
			Double weightsArray[] = new Double[82];
			Arrays.fill(weightsArray, Double.MAX_VALUE);
			Map paths = new HashMap();
			Map changes = new HashMap();
			Ýller node;
			boolean visiteds[] = new boolean[82];
			boolean ischange=true;
			double minValue=Double.MAX_VALUE;
			int minIndex=baslangic;
			node = linkedlist.get(baslangic);
			weightsArray[baslangic] = 0.0;
			visiteds[baslangic] = true;
			for (int i = 0; i < node.komsular.length; i++) {
				weightsArray[node.komsular[i]] = node.weights[i];
				changes.put(node.komsular[i], weightsArray[node.komsular[i]] );
			}
			for (Object key : changes.keySet()) {
				paths.remove(key);
				paths.put(key, node.isim+"->"+linkedlist.get(Integer.parseInt(key.toString())).isim);
			}
			int sayac=0;
			while(!changes.isEmpty() || sayac<81){
				sayac++;
				minValue = Double.MAX_VALUE;
				changes.clear();
				for (int i = 1; i < weightsArray.length; i++) {
					if(minValue > weightsArray[i] && !visiteds[i]){
						minValue = weightsArray[i];
						minIndex = i;
					}
				}
				node=linkedlist.get(minIndex);
				visiteds[minIndex] = true;
				for (int i = 0; i < node.komsular.length; i++) {
					if(weightsArray[node.ID]+node.weights[i]< weightsArray[node.komsular[i]]){
						weightsArray[node.komsular[i]] = weightsArray[node.ID]+node.weights[i];
						changes.put(node.komsular[i], weightsArray[node.komsular[i]]);
					}
				}
				for(Object key : changes.keySet()){
					paths.remove(key);
					paths.put(key, paths.get(node.ID)+"->"+linkedlist.get(Integer.parseInt(key.toString())).isim);
				}
			}
			for (int i = 1; i < paths.size(); i++) {
				
				System.out.println(linkedlist.get(i).isim+"= "+paths.get(i));
			}
		}*/
}