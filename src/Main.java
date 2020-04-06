//Vasilis Stavrianoudakis AM: 3140193, Anastasios Tsoukas AM: 3140213, Ektoras Typaldos AM: 3140216
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	
	private static int numbOfBeams = 3; //me posa beams tha trexei o algorithmos beam search
	private static int seconds = 90;  //gia poso megisto xrono tha trexei to programma se deuterolepta
	
	public static void main(String[] args) {
		
		long scoreFinal=1000000000;
		ArrayList<Schedule> children = new ArrayList<Schedule>();
		Schedule sched,schedFinal;
		schedFinal=new Schedule();
		schedFinal.createRandomSchedule();
		ArrayList<Schedule> state = new ArrayList<Schedule>();
		
		firstLemmePrint(); //printarei tis arxikes plirofories tou programmatos
		
		long start = System.currentTimeMillis();
		for(int i = 0; i < numbOfBeams; i++){
			sched = new Schedule();
			sched.createRandomSchedule();
			state.add(sched);
		}

		long min;
		int childPosition;
		int countRep = 0;
		boolean terminalState = false;
		long[] score1 = new long[numbOfBeams];
		long[] score2 = new long[numbOfBeams];
		
		outerloop:
		while(terminalState != true){ 

			for(int i = 0; i < numbOfBeams; i++){
				score1[i] = state.get(0).makeReport();
				//System.out.println(state.get(0).makeReport());
				children.addAll(state.remove(0).createChildren(numbOfBeams));
			}
			
			while(state.size() < numbOfBeams ){
				
			
			for(int i = 0; i < numbOfBeams; i++){

				min = children.get(0).makeReport();
				childPosition = 0;
				for(int r = 0; r < children.size(); r++ ){
					if(children.get(r).makeReport() < min){
						min = children.get(r).makeReport();
						childPosition = r;
					}
				}
				
				state.add(children.remove(childPosition));
				children.trimToSize();

			}
			}
			children.clear();
			
			for(int i = 0; i < numbOfBeams; i++){

				score2[i] = state.get(i).makeReport();
				long end2 = System.currentTimeMillis();
				if( score2[i] < scoreFinal ){
					//System.out.println(scoreFinal);
					scoreFinal=score2[i];
					state.get(i).makeCopy(schedFinal);
				}
				if(state.get(i).makeReport() == 0){
					System.out.println("******************************************************************************************");
					System.out.println("to programma exei score: " + state.get(i).makeReport() + " (teleia lisi)");
					terminalState = true;
					long end = System.currentTimeMillis();
					System.out.println("To programma me beam search vrike lusi se: " + (double)(end - start) / 1000 + " sec.");
					System.out.println((countRep == 1) ?"To programma ekane sinolika " +  countRep + " tixaia epanakkinish." :"To programma ekane sinolika " +  countRep + " tixaies epanakkiniseis." );
					ScheduleToPDF text = new ScheduleToPDF();
					try {
						text.saveFile(state.get(i).getSched(), state.get(i).getLessons(), state.get(i).getTeachers());
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				}else if((double)(end2 - start)/1000 > seconds){ //an perasei to megisto xroniko perithorio ektipwnei to kalitero mexri stigmis paidi.
					if(scoreFinal!=1000000000){
						System.out.println("******************************************************************************************");
						System.out.println("To teliko programma exei score: " + scoreFinal + " (mi veltisti lisi)");
						if(scoreFinal/1000000000>0 ){
							System.out.println("*Den ikanopoihse to kritirio pou afora to na min iparxoun kena endiamesa sto programma. Yparxoun " + (int)scoreFinal/1000000000 + " kena.");
						}
						if(scoreFinal/10000000>0 && (scoreFinal%100000000!=0)){
							System.out.println("*Den ikanopoihse to kritirio pou afora to na min didaskei enas kathigitis se dio tmimata tin idia wra. Yparxei/oun " + (scoreFinal%100000000)/10000000  + " tetoios/oi kathigitis/es." );
						}
						if(scoreFinal/100000>0 && (scoreFinal%1000000!=0)) {
							System.out.println("*Den ikanopoihse to kritirio pou afora to na min kanei enas kathigitis panw apo 2 wres seri. Yparxei/oun " + (scoreFinal%1000000)/100000 + " tetoios/oi kathigitis/es.");
						}
						if(scoreFinal/1000>0 && (scoreFinal%10000!=0) ){
							System.out.println("*Den ikanopoihse to kritirio pou afora to na min pernaei enas kathigitis to max tis ebdomadas tou. Yparxei/oun " + (scoreFinal%10000)/1000 + " tetoios/oi kathigitis/es.");
						}
						if(scoreFinal/100>0 && (scoreFinal%1000!=0) ){
							System.out.println("*Den ikanopoihse to kritirio pou afora na min pernaei enas kathigitis to max tis imeras tou.Yparxei/oun " + (scoreFinal%1000)/100 + " tetoios/oi kathigitis/es.");
						}
						if((scoreFinal/1>0)  && (scoreFinal%100!=0) ){
							System.out.println("*Den ikanopoihse to kritirio tis omoimorfias twn mathimatwn, gia " + (scoreFinal%100)/1 + " mathimata.");
						}
						System.out.println((countRep == 1) ?"To programma ekane sinolika " +  countRep + " tixaia epanakkinish." :"To programma ekane sinolika " +  countRep + " tixaies epanakkiniseis." );
						ScheduleToPDF text = new ScheduleToPDF();
						try {
							text.saveFile(schedFinal.getSched(), schedFinal.getLessons(), schedFinal.getTeachers());
						} catch (IOException e) {
							e.printStackTrace();
						}
					}else{
						System.out.println("Den mou edwses arketo xrono.");
						System.exit(0);
					}
					break outerloop;
					
				}
			}
			
			//tsekarei na dei an xreiazontai tixea epanekkinisi oi rizes
			int countCh = 0;
			for(int i = 0; i < numbOfBeams; i++){
				if(score1[i] == score2[i]){
					countCh++;
				}
			}
			
			if(countCh == numbOfBeams){
				countRep++;

				state.clear();
				for(int i = 0; i < numbOfBeams; i++){
					sched = new Schedule();
					sched.createRandomSchedule();
					state.add(sched);
				}
			}
			////////////
		}
	}
	
	public static void firstLemmePrint(){
		System.out.println("Programma gia tin dimiourgia wrologiou programmatos mathimatwn gimnasiou. Ylopoihsh me algorithmo beam search, me tixaies epanekkiniseis.");
		System.out.println("To programma trexei by default gia n = " + numbOfBeams  + " kai gia megisto xrono ekteleshs = " + seconds + " sec.");
		System.out.println("----shmiwsh: Me to kritirio tis omoiomorfias, me megala n to programma borei na xreiazetai arketo xrono gia na vrei teleia lisi.");
		System.out.println("----Giauto to logo tou exoume dwsei megisto xrono ektelesis, wste ama ton perasei...");
		System.out.println("----to programma pou tha ektipwsei tha plirei ola ta kritiria ektos autou tis omoiomorfias.");
		System.out.println("\nDimiourgia " + numbOfBeams + " random arxikwn katastasewn... ");
	}
}
