//Vasilis Stavrianoudakis AM: 3140193, Anastasios Tsoukas AM: 3140213, Ektoras Typaldos AM: 3140216
import java.util.ArrayList;
import java.util.Random;


public class Schedule {

	private LessonWithTeacher[][] sched;
	private Random random;
	private DataForSchedule data = new DataForSchedule();
	private ArrayList<LessonWithTeacher> tempA1;
	private ArrayList<LessonWithTeacher> tempB1;
	private ArrayList<LessonWithTeacher> tempC1;
	private ArrayList<LessonWithTeacher> tempA2;
	private ArrayList<LessonWithTeacher> tempB2;
	private ArrayList<LessonWithTeacher> tempC2;
	private ArrayList<LessonWithTeacher> tempA3;
	private ArrayList<LessonWithTeacher> tempB3;
	private ArrayList<LessonWithTeacher> tempC3;
	private ArrayList<Lesson> les = new ArrayList<Lesson>();
	private ArrayList<Teacher> teac = new ArrayList<Teacher>();
	
	public Schedule(){
		sched = new LessonWithTeacher[63][5];
		random = new Random();
		data.readLessonsFromText("lessons.txt");
		data.readTeachersFromText("teachers.txt");
		data.createDataBase();
		les = new ArrayList<Lesson>(data.getLessons());
		teac = new ArrayList<Teacher>(data.getTeachers());
	}
	
	public Schedule(int seed){
		sched = new LessonWithTeacher[63][5];
		if (seed > 0){
			random = new Random(seed);
		}else{
		    random = new Random();
		}
		data.readLessonsFromText("lessons.txt");
		data.readTeachersFromText("teachers.txt");
		data.createDataBase();
		les = data.getLessons();
		teac = data.getTeachers();
	}
	
	public void createRandomSchedule(){
		tempA1 = new ArrayList<LessonWithTeacher>(data.getA());
		tempB1 = new ArrayList<LessonWithTeacher>(data.getB());
		tempC1 = new ArrayList<LessonWithTeacher>(data.getC());
		tempA2 = new ArrayList<LessonWithTeacher>(data.getA());
		tempB2 = new ArrayList<LessonWithTeacher>(data.getB());
		tempC2 = new ArrayList<LessonWithTeacher>(data.getC());
		tempA3 = new ArrayList<LessonWithTeacher>(data.getA());
		tempB3 = new ArrayList<LessonWithTeacher>(data.getB());
		tempC3 = new ArrayList<LessonWithTeacher>(data.getC());
		int positionI, positionJ, element;
		while(!tempA1.isEmpty() || !tempA2.isEmpty() || !tempA3.isEmpty() || !tempB1.isEmpty() || !tempB2.isEmpty() || !tempB3.isEmpty() || !tempC1.isEmpty() || !tempC2.isEmpty() || !tempC3.isEmpty()){
	    	positionI = random.nextInt(63);
	    	positionJ = random.nextInt(5);
	    	while(sched[positionI][positionJ] != null){
	    		positionI = random.nextInt(63);
		    	positionJ = random.nextInt(5);
	    	}
	    	if(positionI < 21){ //gemizw tis takseis tis A
				if(positionI < 7){ //gemizw tin A1
					if(!tempA1.isEmpty()){ //an exei adiasei i tempA1 simenei oti to programma tis A1 exei ftiaxtei
						element = random.nextInt(tempA1.size());
						while(tempA1.get(element) == null){
							element = random.nextInt(tempA1.size());
						}
						sched[positionI][positionJ] = tempA1.remove(element);
					}
				}else if(positionI > 6 && positionI < 14){ //gemizw tin A2
					if(!tempA2.isEmpty()){ //an exei adiasei i tempA2 simenei oti to programma tis A2 exei ftiaxtei
						element = random.nextInt(tempA2.size());
						while(tempA2.get(element) == null){
							element = random.nextInt(tempA2.size());
						}
						sched[positionI][positionJ] = tempA2.remove(element);
					}
				}else{ //gemizw tin A3
					if(!tempA3.isEmpty()){ //an exei adiasei i tempA3 simenei oti to programma tis A3 exei ftiaxtei
						element = random.nextInt(tempA3.size());
						while(tempA3.get(element) == null){
							element = random.nextInt(tempA3.size());
						}
						sched[positionI][positionJ] = tempA3.remove(element);
					}
				}
			}else if(positionI > 20 && positionI < 42){ //gemizw tis takseis tis B
				if(positionI < 28){ //gemizw tin B1
					if(!tempB1.isEmpty()){ //an exei adiasei i tempB1 simenei oti to programma tis B1 exei ftiaxtei
						element = random.nextInt(tempB1.size());
						while(tempB1.get(element) == null){
							element = random.nextInt(tempB1.size());
						}
						sched[positionI][positionJ] = tempB1.remove(element);
					}
				}else if(positionI > 27 && positionI < 35){ //gemizw tin B2
					if(!tempB2.isEmpty()){ //an exei adiasei i tempB2 simenei oti to programma tis B2 exei ftiaxtei
						element = random.nextInt(tempB2.size());
						while(tempB2.get(element) == null){
							element = random.nextInt(tempB2.size());
						}
						sched[positionI][positionJ] = tempB2.remove(element);
					}
				}else{ //gemizw tin B3
					if(!tempB3.isEmpty()){ //an exei adiasei i tempB3 simenei oti to programma tis B3 exei ftiaxtei
						element = random.nextInt(tempB3.size());
						while(tempB3.get(element) == null){
							element = random.nextInt(tempB3.size());
						}
						sched[positionI][positionJ] = tempB3.remove(element);
					}
				}
			}else{ //gemizw tis takseis tis C
				if(positionI < 49){ //gemizw tin C1
					if(!tempC1.isEmpty()){ //an exei adiasei i tempC1 simenei oti to programma tis C1 exei ftiaxtei
						element = random.nextInt(tempC1.size());
						while(tempC1.get(element) == null){
							element = random.nextInt(tempC1.size());
						}
						sched[positionI][positionJ] = tempC1.remove(element);
					}
				}else if(positionI > 48 && positionI < 56){ //gemizw tin C2
					if(!tempC2.isEmpty()){ //an exei adiasei i tempC2 simenei oti to programma tis C2 exei ftiaxtei
						element = random.nextInt(tempC2.size());
						while(tempC2.get(element) == null){
							element = random.nextInt(tempC2.size());
						}
						sched[positionI][positionJ] = tempC2.remove(element);
					}
				}else{ //gemizw tin C3
					if(!tempC3.isEmpty()){ //an exei adiasei i tempC3 simenei oti to programma tis C3 exei ftiaxtei
						element = random.nextInt(tempC3.size());
						while(tempC3.get(element) == null){
							element = random.nextInt(tempC3.size());
						}
						sched[positionI][positionJ] = tempC3.remove(element);
					}
				}
			}
		}
	}

	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public ArrayList<Schedule> createChildren(int beams){
		ArrayList<Schedule> children= new ArrayList<Schedule>();
		ArrayList<Integer> problem;
		Report rep = new Report();
		rep.setTeachers(data.getTeachers());
		rep.score(sched,this);
		problem = new ArrayList<Integer>(rep.getTheProblem());
		if(problem.size()>0){//edw shmenei oti exoume astoxies
			Schedule ReturnableSched = new Schedule();
			if( problem.get(0) == 1 ){ //simenei oti exw keno
				boolean flag1 = true;
				for(int j=0; j<5; j++){
					this.makeCopy(ReturnableSched);
					Schedule forArray = new Schedule();
					if(problem.get(1) <= 6){ //gia to A1
						swap(problem.get(1),problem.get(2),6,j,ReturnableSched);
						ReturnableSched.makeCopy(forArray);
						children.add(forArray);
						if(flag1){                             //ekasfalizei na exw diathesima paidia gia ola ta NumberOfBeams
							flag1 = false;
							forArray = new Schedule();
							for(int i=0; i<beams-5; i++){
								this.makeCopy(forArray);
								swap(problem.get(1),problem.get(2),random.nextInt(6),random.nextInt(4),forArray);
								children.add(forArray);
							}
						}
					}else if(problem.get(1) <= 13){  //gia to A2
						swap(problem.get(1),problem.get(2),13,j,ReturnableSched);
						ReturnableSched.makeCopy(forArray);
						children.add(forArray);
						if(flag1){                             //ekasfalizei na exw diathesima paidia gia ola ta NumberOfBeams
							flag1 = false;
							forArray = new Schedule();
							for(int i=0; i<beams-5; i++){
								this.makeCopy(forArray);
								swap(problem.get(1),problem.get(2),random.nextInt(6) + 7,random.nextInt(4),forArray);
								children.add(forArray);
							}
						}
					}else if(problem.get(1) <= 20){  //gia to A3
						swap(problem.get(1),problem.get(2),20,j,ReturnableSched);
						ReturnableSched.makeCopy(forArray);
						children.add(forArray);
						if(flag1){                             //ekasfalizei na exw diathesima paidia gia ola ta NumberOfBeams
							flag1 = false;
							forArray = new Schedule();
							for(int i=0; i<beams-5; i++){
								this.makeCopy(forArray);
								swap(problem.get(1),problem.get(2),random.nextInt(6) + 14,random.nextInt(4),forArray);
								children.add(forArray);
							}
						}
					}else if(problem.get(1) <= 27){  //gia to b1
						swap(problem.get(1),problem.get(2),27,j,ReturnableSched);
						ReturnableSched.makeCopy(forArray);
						children.add(forArray);
						if(flag1){                             //ekasfalizei na exw diathesima paidia gia ola ta NumberOfBeams
							flag1 = false;
							forArray = new Schedule();
							for(int i=0; i<beams-5; i++){
								this.makeCopy(forArray);
								swap(problem.get(1),problem.get(2),random.nextInt(6) + 21,random.nextInt(4),forArray);
								children.add(forArray);
							}
						}
					}else if(problem.get(1) <= 34){  //gia to b2
						swap(problem.get(1),problem.get(2),34,j,ReturnableSched);
						ReturnableSched.makeCopy(forArray);
						children.add(forArray);
						if(flag1){                             //ekasfalizei na exw diathesima paidia gia ola ta NumberOfBeams
							flag1 = false;
							forArray = new Schedule();
							for(int i=0; i<beams-5; i++){
								this.makeCopy(forArray);
								swap(problem.get(1),problem.get(2),random.nextInt(6) + 28,random.nextInt(4),forArray);
								children.add(forArray);
							}
						}
					}else if(problem.get(1) <= 41 ){  //gia to b3
						swap(problem.get(1),problem.get(2),41,j,ReturnableSched);
						ReturnableSched.makeCopy(forArray);
						children.add(forArray);
						if(flag1){                             //ekasfalizei na exw diathesima paidia gia ola ta NumberOfBeams
							flag1 = false;
							forArray = new Schedule();
							for(int i=0; i<beams-5; i++){
								this.makeCopy(forArray);
								swap(problem.get(1),problem.get(2),random.nextInt(6) + 35,random.nextInt(4),forArray);
								children.add(forArray);
							}
						}
					}else if(problem.get(1) <= 48 ){  //gia to g1
						swap(problem.get(1),problem.get(2),48,j,ReturnableSched);
						ReturnableSched.makeCopy(forArray);
						children.add(forArray);
						if(flag1){                             //ekasfalizei na exw diathesima paidia gia ola ta NumberOfBeams
							flag1 = false;
							forArray = new Schedule();
							for(int i=0; i<beams-5; i++){
								this.makeCopy(forArray);
								swap(problem.get(1),problem.get(2),random.nextInt(6) + 42,random.nextInt(4),forArray);
								children.add(forArray);
							}
						}
					}else if(problem.get(1) <= 55 ){  //gia to g2
						swap(problem.get(1),problem.get(2),55,j,ReturnableSched);
						ReturnableSched.makeCopy(forArray);
						children.add(forArray);
						if(flag1){                             //ekasfalizei na exw diathesima paidia gia ola ta NumberOfBeams
							flag1 = false;
							forArray = new Schedule();
							for(int i=0; i<beams-5; i++){
								this.makeCopy(forArray);
								swap(problem.get(1),problem.get(2),random.nextInt(6) + 49,random.nextInt(4),forArray);
								children.add(forArray);
							}
						}
					}else if(problem.get(1) <= 62){  //gia to g3
						swap(problem.get(1),problem.get(2),62,j,ReturnableSched);
						ReturnableSched.makeCopy(forArray);
						children.add(forArray);
						if(flag1){                             //ekasfalizei na exw diathesima paidia gia ola ta NumberOfBeams
							flag1 = false;
							forArray = new Schedule();
							for(int i=0; i<beams-5; i++){
								this.makeCopy(forArray);
								swap(problem.get(1),problem.get(2),random.nextInt(6) + 56,random.nextInt(4),forArray);
								children.add(forArray);
							}
						}
					}
				}
			}else if( problem.get(0) == 2 ){ //simenei oti exw ena kathigith na didaskei se duo tmhmata thn idia wra
				this.makeCopy(ReturnableSched);
				for(int i=0; i<data.getTeachers().size(); i++){
	        		 if(data.getTeachers().get(i).getInsideId() !=  ReturnableSched.getSched()[problem.get(1)][problem.get(2)].getTeacherId() ){
	        			 for (int p = 0; p < data.getTeachers().get(i).getLessonsLength(); p++) {
	        				 if( data.getTeachers().get(i).getLesson(p) == ReturnableSched.getSched()[problem.get(1)][problem.get(2)].getLessonId() ){
	        					 this.makeCopy(ReturnableSched);
	        					 ReturnableSched.setSchedIJ(new LessonWithTeacher(data.getTeachers().get(i).getLesson(p),data.getTeachers().get(i).getInsideId()),problem.get(1),problem.get(2) );
	        					 Schedule forArray = new Schedule();
	        					 ReturnableSched.makeCopy(forArray);
	 							children.add(forArray);
	        				 }
	        			 }
	        		 }
	        	 }	
				this.makeCopy(ReturnableSched);
				for(int j=0; j<5; j++){
					if(problem.get(1) <= 6){ //gia to A1
						for(int i=0; i<=6; i++){
							this.makeCopy(ReturnableSched);
							Schedule forArray = new Schedule();
							swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
							ReturnableSched.makeCopy(forArray);
							children.add(forArray);
						}
					}else if(problem.get(1) <= 13){  //gia to A2
						for(int i=7; i<=13; i++){
							this.makeCopy(ReturnableSched);
							Schedule forArray = new Schedule();
							swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
							ReturnableSched.makeCopy(forArray);
							children.add(forArray);
						}
					}else if(problem.get(1) <= 20){  //gia to A3
						for(int i=14; i<=20; i++){
							this.makeCopy(ReturnableSched);
							Schedule forArray = new Schedule();
							swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
							ReturnableSched.makeCopy(forArray);
							children.add(forArray);
						}
					}else if(problem.get(1) <= 27){  //gia to b1
						for(int i=21; i<=27; i++){
							this.makeCopy(ReturnableSched);
							Schedule forArray = new Schedule();
							swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
							ReturnableSched.makeCopy(forArray);
							children.add(forArray);
						}
					}else if(problem.get(1) <= 34){  //gia to b2
						for(int i=28; i<=34; i++){
							this.makeCopy(ReturnableSched);
							Schedule forArray = new Schedule();
							swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
							ReturnableSched.makeCopy(forArray);
							children.add(forArray);
						}
					}else if(problem.get(1) <= 41 ){  //gia to b3
						for(int i=35; i<=41; i++){
							this.makeCopy(ReturnableSched);
							Schedule forArray = new Schedule();
							swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
							ReturnableSched.makeCopy(forArray);
							children.add(forArray);
						}
					}else if(problem.get(1) <= 48 ){  //gia to g1
						for(int i=42; i<=48; i++){
							this.makeCopy(ReturnableSched);
							Schedule forArray = new Schedule();
							swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
							ReturnableSched.makeCopy(forArray);
							children.add(forArray);
						}
					}else if(problem.get(1) <= 55 ){  //gia to g2
						for(int i=49; i<=55; i++){
							this.makeCopy(ReturnableSched);
							Schedule forArray = new Schedule();
							swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
							ReturnableSched.makeCopy(forArray);
							children.add(forArray);
						}
					}else if(problem.get(1) <= 62){  //gia to g3
						for(int i=56; i<=62; i++){
							this.makeCopy(ReturnableSched);
							Schedule forArray = new Schedule();
							swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
							ReturnableSched.makeCopy(forArray);
							children.add(forArray);
						}
					}
				}
			}else if( problem.get(0) == 3 ){ //simenei oti exw ena kathigith na didaskei panw apo 3 sinexomenes wres
				this.makeCopy(ReturnableSched);
				for(int i=0; i<data.getTeachers().size(); i++){
	        		 if(data.getTeachers().get(i).getInsideId() !=  ReturnableSched.getSched()[problem.get(1)][problem.get(2)].getTeacherId() ){
	        			 for (int p = 0; p < data.getTeachers().get(i).getLessonsLength(); p++) {
	        				 if( data.getTeachers().get(i).getLesson(p) == ReturnableSched.getSched()[problem.get(1)][problem.get(2)].getLessonId() ){
	        					 this.makeCopy(ReturnableSched);
	        					 ReturnableSched.setSchedIJ(new LessonWithTeacher(data.getTeachers().get(i).getLesson(p),data.getTeachers().get(i).getInsideId()),problem.get(1),problem.get(2) );
	        					 Schedule forArray = new Schedule();
	        					 ReturnableSched.makeCopy(forArray);
	 							children.add(forArray);
	        				 }
	        			 }
	        		 }
	        	 }	
				this.makeCopy(ReturnableSched);
				for(int j=0; j<5; j++){
					if(problem.get(1) <= 6){ //gia to A1
						for(int i=0; i<=6; i++){
							this.makeCopy(ReturnableSched);
							Schedule forArray = new Schedule();
							swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
							ReturnableSched.makeCopy(forArray);
							children.add(forArray);
						}
					}else if(problem.get(1) <= 13){  //gia to A2
						for(int i=7; i<=13; i++){
							this.makeCopy(ReturnableSched);
							Schedule forArray = new Schedule();
							swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
							ReturnableSched.makeCopy(forArray);
							children.add(forArray);
						}
					}else if(problem.get(1) <= 20){  //gia to A3
						for(int i=14; i<=20; i++){
							this.makeCopy(ReturnableSched);
							Schedule forArray = new Schedule();
							swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
							ReturnableSched.makeCopy(forArray);
							children.add(forArray);
						}
					}else if(problem.get(1) <= 27){  //gia to b1
						for(int i=21; i<=27; i++){
							this.makeCopy(ReturnableSched);
							Schedule forArray = new Schedule();
							swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
							ReturnableSched.makeCopy(forArray);
							children.add(forArray);
						}
					}else if(problem.get(1) <= 34){  //gia to b2
						for(int i=28; i<=34; i++){
							this.makeCopy(ReturnableSched);
							Schedule forArray = new Schedule();
							swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
							ReturnableSched.makeCopy(forArray);
							children.add(forArray);
						}
					}else if(problem.get(1) <= 41 ){  //gia to b3
						for(int i=35; i<=41; i++){
							this.makeCopy(ReturnableSched);
							Schedule forArray = new Schedule();
							swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
							ReturnableSched.makeCopy(forArray);
							children.add(forArray);
						}
					}else if(problem.get(1) <= 48 ){  //gia to g1
						for(int i=42; i<=48; i++){
							this.makeCopy(ReturnableSched);
							Schedule forArray = new Schedule();
							swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
							ReturnableSched.makeCopy(forArray);
							children.add(forArray);
						}
					}else if(problem.get(1) <= 55 ){  //gia to g2
						for(int i=49; i<=55; i++){
							this.makeCopy(ReturnableSched);
							Schedule forArray = new Schedule();
							swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
							ReturnableSched.makeCopy(forArray);
							children.add(forArray);
						}
					}else if(problem.get(1) <= 62){  //gia to g3
						for(int i=56; i<=62; i++){
							this.makeCopy(ReturnableSched);
							Schedule forArray = new Schedule();
							swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
							ReturnableSched.makeCopy(forArray);
							children.add(forArray);
						}
					}
				}				
			}else if( problem.get(0) == 5 ){ //maxhourPerDay
				this.makeCopy(ReturnableSched);
				for(int i=0; i<data.getTeachers().size(); i++){
	        		 if(data.getTeachers().get(i).getInsideId() !=  ReturnableSched.getSched()[problem.get(1)][problem.get(2)].getTeacherId() ){
	        			 for (int p = 0; p < data.getTeachers().get(i).getLessonsLength(); p++) {
	        				 if( data.getTeachers().get(i).getLesson(p) == ReturnableSched.getSched()[problem.get(1)][problem.get(2)].getLessonId() ){
	        					 this.makeCopy(ReturnableSched);
	        					 ReturnableSched.setSchedIJ(new LessonWithTeacher(data.getTeachers().get(i).getLesson(p),data.getTeachers().get(i).getInsideId()),problem.get(1),problem.get(2) );
	        					 Schedule forArray = new Schedule();
	        					 ReturnableSched.makeCopy(forArray);
	 							children.add(forArray);
	        				 }
	        			 }
	        		 }
	        	 }	
				this.makeCopy(ReturnableSched);				
				for(int j=0; j<5; j++){
					if(problem.get(1) <= 6){ //gia to A1
						for(int i=0; i<=6; i++){
							this.makeCopy(ReturnableSched);
							Schedule forArray = new Schedule();
							swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
							ReturnableSched.makeCopy(forArray);
							children.add(forArray);
						}
					}else if(problem.get(1) <= 13){  //gia to A2
						for(int i=7; i<=13; i++){
							this.makeCopy(ReturnableSched);
							Schedule forArray = new Schedule();
							swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
							ReturnableSched.makeCopy(forArray);
							children.add(forArray);
						}
					}else if(problem.get(1) <= 20){  //gia to A3
						for(int i=14; i<=20; i++){
							this.makeCopy(ReturnableSched);
							Schedule forArray = new Schedule();
							swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
							ReturnableSched.makeCopy(forArray);
							children.add(forArray);
						}
					}else if(problem.get(1) <= 27){  //gia to b1
						for(int i=21; i<=27; i++){
							this.makeCopy(ReturnableSched);
							Schedule forArray = new Schedule();
							swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
							ReturnableSched.makeCopy(forArray);
							children.add(forArray);
						}
					}else if(problem.get(1) <= 34){  //gia to b2
						for(int i=28; i<=34; i++){
							this.makeCopy(ReturnableSched);
							Schedule forArray = new Schedule();
							swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
							ReturnableSched.makeCopy(forArray);
							children.add(forArray);
						}
					}else if(problem.get(1) <= 41 ){  //gia to b3
						for(int i=35; i<=41; i++){
							this.makeCopy(ReturnableSched);
							Schedule forArray = new Schedule();
							swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
							ReturnableSched.makeCopy(forArray);
							children.add(forArray);
						}
					}else if(problem.get(1) <= 48 ){  //gia to g1
						for(int i=42; i<=48; i++){
							this.makeCopy(ReturnableSched);
							Schedule forArray = new Schedule();
							swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
							ReturnableSched.makeCopy(forArray);
							children.add(forArray);
						}
					}else if(problem.get(1) <= 55 ){  //gia to g2
						for(int i=49; i<=55; i++){
							this.makeCopy(ReturnableSched);
							Schedule forArray = new Schedule();
							swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
							ReturnableSched.makeCopy(forArray);
							children.add(forArray);
						}
					}else if(problem.get(1) <= 62){  //gia to g3
						for(int i=56; i<=62; i++){
							this.makeCopy(ReturnableSched);
							Schedule forArray = new Schedule();
							swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
							ReturnableSched.makeCopy(forArray);
							children.add(forArray);
						}
					}
				}
			}else if(problem.get(0) == 4 ){    //edw einai gia to maxHourPerWeek    
				this.makeCopy(ReturnableSched);
				for(int i=0; i<data.getTeachers().size(); i++){
	        		 if(data.getTeachers().get(i).getInsideId() !=  ReturnableSched.getSched()[problem.get(1)][problem.get(2)].getTeacherId() ){
	        			 for (int p = 0; p < data.getTeachers().get(i).getLessonsLength(); p++) {
	        				 if( data.getTeachers().get(i).getLesson(p) == ReturnableSched.getSched()[problem.get(1)][problem.get(2)].getLessonId() ){
	        					 this.makeCopy(ReturnableSched);
	        					 ReturnableSched.setSchedIJ(new LessonWithTeacher(data.getTeachers().get(i).getLesson(p),data.getTeachers().get(i).getInsideId()),problem.get(1),problem.get(2) );
	        					 Schedule forArray = new Schedule();
	        					 ReturnableSched.makeCopy(forArray);
	 							 children.add(forArray); 
	        				 }
	        			 }
	        		 }
	        	 }	
				if(problem.get(1) <= 6){                         //ekasfalizei na exw diathesima paidia gia ola ta NumberOfBeams
					for(int i = 0; i < (beams - children.size()); i++) {
						Schedule forArray = new Schedule();
						this.makeCopy(forArray);
						swap(problem.get(1),problem.get(2),random.nextInt(6),random.nextInt(4),forArray);
						children.add(forArray);
					}
				}else if(problem.get(1) <= 13){                         //ekasfalizei na exw diathesima paidia gia ola ta NumberOfBeams
					for(int i = 0; i < (beams - children.size()); i++) {
						Schedule forArray = new Schedule();
						this.makeCopy(forArray);
						swap(problem.get(1),problem.get(2),random.nextInt(6) + 7,random.nextInt(4),forArray);
						children.add(forArray);
					}
				}else if(problem.get(1) <= 20){                         //ekasfalizei na exw diathesima paidia gia ola ta NumberOfBeams
					for(int i = 0; i < (beams - children.size()); i++) {
						Schedule forArray = new Schedule();
						this.makeCopy(forArray);
						swap(problem.get(1),problem.get(2),random.nextInt(6) + 14,random.nextInt(4),forArray);
						children.add(forArray);
					}
				}else if(problem.get(1) <= 27){                         //ekasfalizei na exw diathesima paidia gia ola ta NumberOfBeams
					for(int i = 0; i < (beams - children.size()); i++) {
						Schedule forArray = new Schedule();
						this.makeCopy(forArray);
						swap(problem.get(1),problem.get(2),random.nextInt(6) + 21,random.nextInt(4),forArray);
						children.add(forArray);
					}
				}else if(problem.get(1) <= 34){                         //ekasfalizei na exw diathesima paidia gia ola ta NumberOfBeams
					for(int i = 0; i < (beams - children.size()); i++) {
						Schedule forArray = new Schedule();
						this.makeCopy(forArray);
						swap(problem.get(1),problem.get(2),random.nextInt(6) + 28,random.nextInt(4),forArray);
						children.add(forArray);
					}
				}else if(problem.get(1) <= 41){                         //ekasfalizei na exw diathesima paidia gia ola ta NumberOfBeams
					for(int i = 0; i < (beams - children.size()); i++) {
						Schedule forArray = new Schedule();
						this.makeCopy(forArray);
						swap(problem.get(1),problem.get(2),random.nextInt(6) + 35,random.nextInt(4),forArray);
						children.add(forArray);
					}
				}else if(problem.get(1) <= 48){                         //ekasfalizei na exw diathesima paidia gia ola ta NumberOfBeams
					for(int i = 0; i < (beams - children.size()); i++) {
						Schedule forArray = new Schedule();
						this.makeCopy(forArray);
						swap(problem.get(1),problem.get(2),random.nextInt(6) + 42,random.nextInt(4),forArray);
						children.add(forArray);
					}
				}else if(problem.get(1) <= 55){                         //ekasfalizei na exw diathesima paidia gia ola ta NumberOfBeams
					for(int i = 0; i < (beams - children.size()); i++) {
						Schedule forArray = new Schedule();
						this.makeCopy(forArray);
						swap(problem.get(1),problem.get(2),random.nextInt(6) + 49,random.nextInt(4),forArray);
						children.add(forArray);
					}
				}else if(problem.get(1) <= 62){                         //ekasfalizei na exw diathesima paidia gia ola ta NumberOfBeams
					for(int i = 0; i < (beams - children.size()); i++) {
						Schedule forArray = new Schedule();
						this.makeCopy(forArray);
						swap(problem.get(1),problem.get(2),random.nextInt(6) + 56,random.nextInt(4),forArray);
						children.add(forArray);
					}
				}
			}else if(problem.get(0) == 6 ){    //edw einai gia ena mathima pou didaskete ekoloklhrou se mia mera 
				this.makeCopy(ReturnableSched);
				if(problem.get(1) <= 6){ //gia to A1
					for(int j=0; j<5 ; j++){
							for(int i=0; i<7 ; i++){
								this.makeCopy(ReturnableSched);
								Schedule forArray = new Schedule();
								swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
								ReturnableSched.makeCopy(forArray);
								children.add(forArray);
							}
					}
				}else if(problem.get(1) <= 13){ //a2
					for(int j=0; j<5 ; j++){
							for(int i=7; i<=13; i++){
								this.makeCopy(ReturnableSched);
								Schedule forArray = new Schedule();
								swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
								ReturnableSched.makeCopy(forArray);
								children.add(forArray);
							}
					}
				}else if(problem.get(1) <= 20){ //a3
					for(int j=0; j<5 ; j++){
							for(int i=14; i<=20; i++){
								this.makeCopy(ReturnableSched);
								Schedule forArray = new Schedule();
								swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
								ReturnableSched.makeCopy(forArray);
								children.add(forArray);
							}
					}
				}else if(problem.get(1) <= 27){  //b1
					for(int j=0; j<5 ; j++){
							for(int i=21; i<=27; i++){
								this.makeCopy(ReturnableSched);
								Schedule forArray = new Schedule();
								swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
								ReturnableSched.makeCopy(forArray);
								children.add(forArray);
							}
					}
				}else if(problem.get(1) <= 34){ //b2
					for(int j=0; j<5 ; j++){
							for(int i=28; i<=34; i++){
								this.makeCopy(ReturnableSched);
								Schedule forArray = new Schedule();
								swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
								ReturnableSched.makeCopy(forArray);
								children.add(forArray);
							}
					}
				}else if(problem.get(1) <= 41){ //b3
					for(int j=0; j<5 ; j++){
							for(int i=35; i<=41; i++){
								this.makeCopy(ReturnableSched);
								Schedule forArray = new Schedule();
								swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
								ReturnableSched.makeCopy(forArray);
								children.add(forArray);
							}
					}
				}else if(problem.get(1) <= 48){ //c1
					for(int j=0; j<5 ; j++){
							for(int i=42; i<=48; i++){
								this.makeCopy(ReturnableSched);
								Schedule forArray = new Schedule();
								swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
								ReturnableSched.makeCopy(forArray);
								children.add(forArray);
							}
					}
				}else if(problem.get(1) <= 55){ //c2
					for(int j=0; j<5 ; j++){
							for(int i=49; i<=55; i++){
								this.makeCopy(ReturnableSched);
								Schedule forArray = new Schedule();
								swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
								ReturnableSched.makeCopy(forArray);
								children.add(forArray);
							}
					}
				}else if(problem.get(1) <= 62){ //c3
					for(int j=0; j<5 ; j++){
							for(int i=56; i<=62; i++){
								this.makeCopy(ReturnableSched);
								Schedule forArray = new Schedule();
								swap(problem.get(1),problem.get(2),i,j,ReturnableSched);
								ReturnableSched.makeCopy(forArray);
								children.add(forArray);
							}
					}
				}
			}
	
			ArrayList<Schedule> retChildren = new ArrayList<Schedule>();
			long min;
			int childPosition; 
			int countCh = 0;
			while(!children.isEmpty() && countCh != beams){
				min = children.get(0).makeReport();
				childPosition = 0;
				for(int r = 0; r < children.size(); r++ ){
					if(children.get(r).makeReport() < min){
						min = children.get(r).makeReport();
						childPosition = r;
					}
				}
				if(retChildren.isEmpty()){
					retChildren.add(children.remove(childPosition));
					countCh++;
					children.trimToSize();
				}else{
					boolean flag = true;
					for(int j = 0; j < retChildren.size(); j++){
						if(retChildren.get(j).makeReport() == children.get(childPosition).makeReport()){
							flag = false;
							children.remove(childPosition);
							break;
						}
					}
					
					if(flag == true){
						retChildren.add(children.remove(childPosition));
						countCh++;
						children.trimToSize();
					}
					
				}
			}
			return retChildren;
		}else{                    //shmenei oti to programma pou hdh exoume den exei astoxies...
			return new ArrayList<Schedule>();
		}
	}
	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	
	
	public long makeReport(){ //pernei to score gia to wrologio programma pou tou stelnoume.
		Report rep = new Report();
		rep.setTeachers(data.getTeachers());
		return rep.score(sched,this);
	}
	
	public void makeCopy(Schedule test){ //kanei to test adigrafo tou sched. Diladi auto pou dineis stin parenthesi to  kanei adigrafo autounou pou to kalei.
		if( test != null ){
			test.setSched(this.sched);
		}
	}
	
	public void setSched(LessonWithTeacher[][] sched2){
		if( this.sched != null ){
			for(int i=0; i<63; i++ ){
				for(int j=0; j<5; j++){
					this.sched[i][j]=sched2[i][j];
				}
			}
		}
	}
	
	public void swap(int i, int j, int k, int z, Schedule s1 ){ //pragmatopoiei to swap enos mathimatos tis wras i kai meras j me to mathima tis wras k kai meras z.
		LessonWithTeacher temp = s1.getSchedIJ(i,j);
		s1.setSchedIJ(s1.getSchedIJ(k, z), i, j);
		s1.setSchedIJ(temp, k, z);
	}
	
	public void setSchedIJ(LessonWithTeacher t, int i , int j){
		this.sched[i][j]=t;
	}
	
	public LessonWithTeacher getSchedIJ( int i, int j ){
		if(this.sched[i][j]!=null){
			return this.sched[i][j];
		}else{
			return null;
		}
	}
	
	public LessonWithTeacher[][] getSched(){
		if(this.sched !=null){
			return sched;
		}else{
			return null;
		}
	}
	
	public ArrayList<Lesson> getLessons(){
		return(les);
	}
	
	public ArrayList<Teacher> getTeachers(){
		return(teac);
	}
	
}