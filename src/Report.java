//Vasilis Stavrianoudakis AM: 3140193, Anastasios Tsoukas AM: 3140213, Ektoras Typaldos AM: 3140216
import java.util.ArrayList;

public class Report {
	private ArrayList<Teacher> teachers;
	private ArrayList<Integer> condition1=new ArrayList<>(); //arraylists gia tis theseis twn prwtwn lanthasmenwn synthikwn
	private ArrayList<Integer> condition2=new ArrayList<>();
	private ArrayList<Integer> condition3=new ArrayList<>();
	private ArrayList<Integer> condition4=new ArrayList<>();
	private ArrayList<Integer> condition5=new ArrayList<>();
	private ArrayList<Integer> condition6=new ArrayList<>();
	private boolean flag1=false, flag2=false, flag3=false, flag4=false, flag5=false, flag6=false;

	public void setTeachers(ArrayList<Teacher> teac){
		teachers = new ArrayList<Teacher>(teac);
	}
	
	public long score(LessonWithTeacher[][] sched, Schedule holeObj){
		long totalScore = 0;
		int teachersReport[][][] = new int[teachers.size()][5][7];
		for(int i = 0; i < teachers.size(); i++){
			for(int j = 0; j < 5; j++){
				for(int n = 0; n < 7; n++){
					teachersReport[i][j][n] = 0;
				}
			}
		}
		for(int i = 0; i < 63; i++){
			for(int j = 0; j < 5; j++){
				if(sched[i][j] == null){ //vathmologei ta kena
					if(i != 6 && i != 13 && i != 20 && i != 27 && i != 34 && i != 41 && i != 48 && i != 55 && i != 62){
						totalScore = totalScore + 1000000000;
						if( flag1 == false ){
							condition1.add(1); //edw ousiastika to 1 einai o kwdikos pou simenei oti ayto to araylist einai gia ta kena tha vohthisei wste na to kseroume sthn Schedule otan to paroume ap thn getTheProblem()
							condition1.add(i); //i,j syntetagmenes tou prwtou kenou pou entwpistike se lathos thesh
							condition1.add(j);
						}
						flag1=true;			
					}
				}else{
					teachersReport[sched[i][j].getTeacherId()][j][i % 7] += 1; //gemizei o o teachersReport pou ousiastiuka kanei count tis wres kathe kathigith kathe mera
					
					if( ( flag2 == false ) && ( teachersReport[sched[i][j].getTeacherId()][j][i % 7] >= 2 ) ){ //ousiastika simenei oti vriskw ton prwto daskalo pou exei se mia sygkekrimenh wra parapanw apo 2 mathimata tautoxrona.
						if( flag2 == false ){
							condition2.add(2); //kwdikos 2 gia provlhma pou sxetizete me kathigiti pou exei se mia wra parapano apo ena mathimata.
							condition2.add(i); //i,j h thesh ston sched[][] gia to DEUTERO mathima!!!! kapoiou kathigith, pou peytei panw se allo, dld didaskonte idia wra, idia mera sto programa
							condition2.add(j);
						}
						flag2=true;
					}
				}
			}
		}
		int count = 0;
		int countMaxDay = 0;
		int countMaxWeek = 0;
		for(int i = 0; i < teachers.size(); i++){ 
			for(int j = 0; j < 5; j++){
				for(int n = 0; n < 7; n++){
					countMaxDay += teachersReport[i][j][n];
					if(teachersReport[i][j][n] > 1){ //vathmologei kathigites pou exoun mathima se 2 h perissotera tmimata tin idia wra
						totalScore = totalScore + (teachersReport[i][j][n] - 1) * 10000000;
					}
					if(teachersReport[i][j][n] >= 1){ //apo edw kai katw vathmologei ta seri
						count += 1;
					}else{
						count = 0;
					}
					if(count > 2){
						///////////////////////////////////
						int tempLine=-1;
						if(flag3 == false){ //edw mesa tha krathsoume tis syntetagmenes ston schedule gia to trito mathima (pou tha vrethei prwta) otan yparxoun seri wres sto programma
							condition3.add(3); //kwdikos 3 dld to Problem einai oti exoume sinexomenes wres parapanw apo 2 gia enan kathigith.
							outerloop:
							for(int o = 0; o < 63; o++){ //psaxnw gia thn sthlh tou sched giati den thn exw ston teachersReport[][][] ayth thn pliroforia
								if( sched[o][j] != null ){
									if( ( sched[o][j].getTeacherId() == i ) && ( o%7 == n) ){ // to o%7 eksasfalizei oti milame gia thn idia wra me aythn ston pinaka teachersReport[][][n] opou to n symvolizei thn wra.
										tempLine=o;
										break outerloop;
									}
								}
							}
							condition3.add(tempLine); //[tempLine][j] h thesh ston sched[][] gia to TRITO synexomeno mathima!!!! kapoiou kathigith...
							condition3.add(j);
							flag3=true;
						}
						///////////////////////////////////////////
						totalScore = totalScore + (count - 2) * 100000;
						count = 2; //to count ginetai 2 giati--> an exei px 4 wres seri h poini einai 2x5 = 10
					}			   //gia tis 3 prwtes tha dwsi +5 poini, to count meta ginetai 2 kai ara   
				}				   //stin 4 wra seri to count tha ginei 3 tha bei sto if kai tha dwsei alla +5 poini
				if(countMaxDay > teachers.get(i).getMaxDay()){//vathmologei poses wres epipleon kanei enas kathigitis kathe mera apo to megisto tou
					totalScore = totalScore + (((countMaxDay - teachers.get(i).getMaxDay()) * 1)*100);
					if(flag5 == false){
						condition5.add(5);
						outerloop:
						for(int o = 0; o < 63; o++){
							if(sched[o][j] != null){
								if(sched[o][j].getTeacherId() == i ){
									condition5.add(o);
									break outerloop;
								}
							}
						}
						condition5.add(j);
						flag5 = true;
					}
				}
				countMaxWeek += countMaxDay;
				countMaxDay = 0;
			}
			if(countMaxWeek > teachers.get(i).getMaxWeek()){//vathmologei poses wres epipleon kanei enan kathigitis kathe ebdomada apo to megisto tou
				totalScore = totalScore + (((countMaxWeek - teachers.get(i).getMaxWeek()) * 1)*1000);
				if(flag4 == false){
					condition4.clear();
					condition4.add(4);
					outerloop:
					for(int o = 0; o < teachers.get(i).getLessonsLength(); o++){
						for(int b = 0; b < teachers.size(); b++){
							for(int v = 0; v < teachers.get(b).getLessonsLength(); v++){
								if(teachers.get(i).getLesson(o) == teachers.get(b).getLesson(v) && b != i){
									for(int x = 0; x < 63; x++){
										for(int y = 0; y < 5; y++){
											if(sched[x][y] != null && sched[x][y].getLessonId() == teachers.get(i).getLesson(o) && sched[x][y].getTeacherId() == i ){
												condition4.add(x);
												condition4.add(y);
												flag4 = true;
												break outerloop;
											}
										}
									}
								}
							}
						}
					}
				}
			}
			countMaxWeek = 0;
			count = 0;
		}
		
		for(int n = 0; n < holeObj.getLessons().size() ; n++){ //tha kanw to score + 1  an exw ena mathima pou didaskeute se ena tmhma olh thn hmera.
			if(holeObj.getLessons().get(n).getHourly()>1 && holeObj.getLessons().get(n).getHourly()<4){
				for(int j=0; j<5; j++){
					int t0=0,t1=0,t2=0;
					if(holeObj.getLessons().get(n).getClassRoom().equals("A")){
						for(int i = 0; i<21; i++){
							if(i/7==0){
								if(sched[i][j]!=null){
									if( holeObj.getLessons().get(n).getId() == sched[i][j].getLessonId()) {
										t0=t0+1;
										if(t0 == holeObj.getLessons().get(n).getHourly()){//simenei oti exw oles tis wres se mia mera
											totalScore = totalScore + 1;
											if(flag6==false){
												flag6=true;
												condition6.add(6);
												condition6.add(i);
												condition6.add(j);
											}
										}
									}
								}
							}else if(i/7==1){
								if(sched[i][j]!=null){
									if( holeObj.getLessons().get(n).getId() == sched[i][j].getLessonId()) {
										t1=t1+1;
										if(t1 == holeObj.getLessons().get(n).getHourly()){//simenei oti exw oles tis wres se mia mera
											totalScore = totalScore + 1;
											if(flag6==false){
												flag6=true;
												condition6.add(6);
												condition6.add(i);
												condition6.add(j);
											}
										}
									}
								}
								
							}else if(i/7==2){
								if(sched[i][j]!=null){
									if( holeObj.getLessons().get(n).getId() == sched[i][j].getLessonId()) {
										t2=t2+1;
										if(t2 == holeObj.getLessons().get(n).getHourly()){//simenei oti exw oles tis wres se mia mera
											totalScore = totalScore + 1;
											if(flag6==false){
												flag6=true;
												condition6.add(6);
												condition6.add(i);
												condition6.add(j);
											}
										}
									}
								}
							}
						}
							
					}else if(holeObj.getLessons().get(n).getClassRoom().equals("B")){
						for(int i = 21; i<42; i++){
							if(i/7==3){
								if(sched[i][j]!=null){
									if( holeObj.getLessons().get(n).getId() == sched[i][j].getLessonId()) {
										t0=t0+1;
										if(t0 == holeObj.getLessons().get(n).getHourly()){//simenei oti exw oles tis wres se mia mera
											totalScore = totalScore + 1;
											if(flag6==false){
												flag6=true;
												condition6.add(6);
												condition6.add(i);
												condition6.add(j);
											}
										}
									}
								}
							}else if(i/7==4){
								if(sched[i][j]!=null){
									if( holeObj.getLessons().get(n).getId() == sched[i][j].getLessonId()) {
										t1=t1+1;
										if(t1 == holeObj.getLessons().get(n).getHourly()){//simenei oti exw oles tis wres se mia mera
											totalScore = totalScore + 1;
											if(flag6==false){
												flag6=true;
												condition6.add(6);
												condition6.add(i);
												condition6.add(j);
											}
										}
									}
								}
							}else if(i/7==5){
								if(sched[i][j]!=null){
									if( holeObj.getLessons().get(n).getId() == sched[i][j].getLessonId()) {
										t2=t2+1;
										if(t2 == holeObj.getLessons().get(n).getHourly()){//simenei oti exw oles tis wres se mia mera
											totalScore = totalScore + 1;
											if(flag6==false){
												flag6=true;
												condition6.add(6);
												condition6.add(i);
												condition6.add(j);
											}
										}
									}
								}
							}
						}
						
					}else if(holeObj.getLessons().get(n).getClassRoom().equals("C")){
						for(int i = 42; i<63; i++){
							if(i/7==6){
								if(sched[i][j]!=null){
									if( holeObj.getLessons().get(n).getId() == sched[i][j].getLessonId()) {
										t0=t0+1;
										if(t0 == holeObj.getLessons().get(n).getHourly()){//simenei oti exw oles tis wres se mia mera
											totalScore = totalScore + 1;
											if(flag6==false){
												flag6=true;
												condition6.add(6);
												condition6.add(i);
												condition6.add(j);
											}
										}
									}
								}
							}else if(i/7==7){
								if(sched[i][j]!=null){
									if( holeObj.getLessons().get(n).getId() == sched[i][j].getLessonId()) {
										t1=t1+1;
										if(t1 == holeObj.getLessons().get(n).getHourly()){//simenei oti exw oles tis wres se mia mera
											totalScore = totalScore + 1;
											if(flag6==false){
												flag6=true;
												condition6.add(6);
												condition6.add(i);
												condition6.add(j);
											}
										}
									}
								}
							}else if(i/7==8){
								if(sched[i][j]!=null){
									if( holeObj.getLessons().get(n).getId() == sched[i][j].getLessonId()) {
										t2=t2+1;
										if(t2 == holeObj.getLessons().get(n).getHourly()){//simenei oti exw oles tis wres se mia mera
											totalScore = totalScore + 1;
											if(flag6==false){
												flag6=true;
												condition6.add(6);
												condition6.add(i);
												condition6.add(j);
											}
										}
									}
								}
							}
						}
					}
					
				}
			}else if(holeObj.getLessons().get(n).getHourly()>3) {
				for(int j=0; j<5; j++){
					int t0=0,t1=0,t2=0;
					if(holeObj.getLessons().get(n).getClassRoom().equals("A")){
						for(int i = 0; i<21; i++){
							if(i/7==0){
								if(sched[i][j]!=null){
									if( holeObj.getLessons().get(n).getId() == sched[i][j].getLessonId()) {
										t0=t0+1;
										if(t0 > 2){//simenei oti exw oles tis wres se mia mera
											totalScore = totalScore + 1;
											if(flag6==false){
												flag6=true;
												condition6.add(6);
												condition6.add(i);
												condition6.add(j);
											}
										}
									}
								}
							}else if(i/7==1){
								if(sched[i][j]!=null){
									if( holeObj.getLessons().get(n).getId() == sched[i][j].getLessonId()) {
										t1=t1+1;
										if(t1 > 2){//simenei oti exw oles tis wres se mia mera
											totalScore = totalScore + 1;
											if(flag6==false){
												flag6=true;
												condition6.add(6);
												condition6.add(i);
												condition6.add(j);
											}
										}
									}
								}
								
							}else if(i/7==2){
								if(sched[i][j]!=null){
									if( holeObj.getLessons().get(n).getId() == sched[i][j].getLessonId()) {
										t2=t2+1;
										if(t2 > 2){//simenei oti exw oles tis wres se mia mera
											totalScore = totalScore + 1;
											if(flag6==false){
												flag6=true;
												condition6.add(6);
												condition6.add(i);
												condition6.add(j);
											}
										}
									}
								}
							}
						}
							
					}else if(holeObj.getLessons().get(n).getClassRoom().equals("B")){
						for(int i = 21; i<42; i++){
							if(i/7==3){
								if(sched[i][j]!=null){
									if( holeObj.getLessons().get(n).getId() == sched[i][j].getLessonId()) {
										t0=t0+1;
										if(t0> 2){//simenei oti exw oles tis wres se mia mera
											totalScore = totalScore + 1;
											if(flag6==false){
												flag6=true;
												condition6.add(6);
												condition6.add(i);
												condition6.add(j);
											}
										}
									}
								}
							}else if(i/7==4){
								if(sched[i][j]!=null){
									if( holeObj.getLessons().get(n).getId() == sched[i][j].getLessonId()) {
										t1=t1+1;
										if(t1 > 2){//simenei oti exw oles tis wres se mia mera
											totalScore = totalScore + 1;
											if(flag6==false){
												flag6=true;
												condition6.add(6);
												condition6.add(i);
												condition6.add(j);
											}
										}
									}
								}
							}else if(i/7==5){
								if(sched[i][j]!=null){
									if( holeObj.getLessons().get(n).getId() == sched[i][j].getLessonId()) {
										t2=t2+1;
										if(t2 > 2){//simenei oti exw oles tis wres se mia mera
											totalScore = totalScore + 1;
											if(flag6==false){
												flag6=true;
												condition6.add(6);
												condition6.add(i);
												condition6.add(j);
											}
										}
									}
								}
							}
						}
						
					}else if(holeObj.getLessons().get(n).getClassRoom().equals("C")){
						for(int i = 42; i<63; i++){
							if(i/7==6){
								if(sched[i][j]!=null){
									if( holeObj.getLessons().get(n).getId() == sched[i][j].getLessonId()) {
										t0=t0+1;
										if(t0 > 2){//simenei oti exw oles tis wres se mia mera
											totalScore = totalScore + 1;
											if(flag6==false){
												flag6=true;
												condition6.add(6);
												condition6.add(i);
												condition6.add(j);
											}
										}
									}
								}
							}else if(i/7==7){
								if(sched[i][j]!=null){
									if( holeObj.getLessons().get(n).getId() == sched[i][j].getLessonId()) {
										t1=t1+1;
										if(t1 > 2){//simenei oti exw oles tis wres se mia mera
											totalScore = totalScore + 1;
											if(flag6==false){
												flag6=true;
												condition6.add(6);
												condition6.add(i);
												condition6.add(j);
											}
										}
									}
								}
							}else if(i/7==8){
								if(sched[i][j]!=null){
									if( holeObj.getLessons().get(n).getId() == sched[i][j].getLessonId()) {
										t2=t2+1;
										if(t2 > 2){//simenei oti exw oles tis wres se mia mera
											totalScore = totalScore + 1;
											if(flag6==false){
												flag6=true;
												condition6.add(6);
												condition6.add(i);
												condition6.add(j);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return totalScore;
	}//telos score..
	
	
	public ArrayList<Integer> getTheProblem(){ //ousiastika aksiologei poio provlhma prepei na antimetopistei prwta kai epistrefei to katallhlo arraylist
		if( flag1 == true ){
			flag1=flag2=flag3=flag4=flag5=flag6=false;
			return this.getCondition1();
		}else if( flag2 == true ){
			flag1=flag2=flag3=flag4=flag5=flag6=false;
			return this.getCondition2();
		}else if( flag3 == true ){
			flag1=flag2=flag3=flag4=flag5=flag6=false;
			return this.getCondition3();
		}else if( flag4 == true ){
			flag1=flag2=flag3=flag4=flag5=flag6=false;
			return this.getCondition4();
		}else if( flag5 == true ){
			flag1=flag2=flag3=flag4=flag5=flag6=false;
			return this.getCondition5();
		}else if( flag6 == true ){
			flag1=flag2=flag3=flag4=flag5=flag6=false;
			return this.getCondition6();
		}else{
			return new ArrayList<Integer>(0); //ayto simenei oti den exeis kanena sfalma ara to programma sou einai teleio me vash tous elegxous ayths ths klashs...
		}
	}
	
	
	public int getElementCon1(int i) {
		if(i < 0 || i > condition1.size()){
			return -1;
		}else{
			return condition1.get(i);
		}
	}
	
	public int getElementCon2(int i) {
		if(i < 0 || i > condition2.size()){
			return -1;
		}else{
			return condition2.get(i);
		}
	}
	
	public int getElementCon3(int i) {
		if(i < 0 || i > condition3.size()){
			return -1;
		}else{
			return condition3.get(i);
		}
	}
	
	public int getElementCon4(int i) {
		if(i < 0 || i > condition4.size()){
			return -1;
		}else{
			return condition4.get(i);
		}
	}
	
	public int getElementCon5(int i) {
		if(i < 0 || i > condition5.size()){
			return -1;
		}else{
			return condition5.get(i);
		}
	}
	
	public int getElementCon6(int i) {
		if(i < 0 || i > condition6.size()){
			return -1;
		}else{
			return condition6.get(i);
		}
	}
	
	public ArrayList<Integer> getCondition1(){
		return(condition1);
	}
	
	public ArrayList<Integer> getCondition2(){
		return(condition2);
	}
	
	public ArrayList<Integer> getCondition3(){
		return(condition3);
	}
	
	public ArrayList<Integer> getCondition4(){
		return(condition4);
	}
	
	public ArrayList<Integer> getCondition5(){
		return(condition5);
	}
	
	public ArrayList<Integer> getCondition6(){
		return(condition6);
	}
	
}
