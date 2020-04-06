//Vasilis Stavrianoudakis AM: 3140193, Anastasios Tsoukas AM: 3140213, Ektoras Typaldos AM: 3140216
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DataForSchedule {
	private ArrayList<LessonWithTeacher> lessonsA = new ArrayList<LessonWithTeacher>(); //afora ta mathimata tis a taksis
	private ArrayList<LessonWithTeacher> lessonsB = new ArrayList<LessonWithTeacher>(); //afora ta mathimata tis b taksis
	private ArrayList<LessonWithTeacher> lessonsC = new ArrayList<LessonWithTeacher>(); //afora ta mathimata tis c taksis
	private ArrayList<Lesson> les = new ArrayList<Lesson>();
	private ArrayList<Teacher> teac = new ArrayList<Teacher>();

	public void createDataBase(){ //dimiourgei to database gia ta mathimata kathe taksis ksexwrista
		LessonWithTeacher temp;
		int countA, countB, countC;
		for(int i = 0; i < les.size(); i++){
			if(les.get(i).getClassRoom().equals("A")){
				countA = 0;
				for(int j = 0; j < les.get(i).getHourly(); j++){
					for(int k = 0; k < teac.size(); k++){
						for(int l = 0; l < teac.get(k).getLessonsLength(); l++){
							if(les.get(i).getId() == teac.get(k).getLesson(l)){
								countA++;
								if(countA <= les.get(i).getHourly()){
									temp = new LessonWithTeacher(les.get(i).getId(), teac.get(k).getInsideId()); //allagh edw gia to Id 
									lessonsA.add(temp);
								}
							}
						}
					}
				}
			}else if(les.get(i).getClassRoom().equals("B")){
				countB = 0;
				for(int j = 0; j < les.get(i).getHourly(); j++){
					for(int k = 0; k < teac.size(); k++){
						for(int l = 0; l < teac.get(k).getLessonsLength(); l++){
							if(les.get(i).getId() == teac.get(k).getLesson(l)){
								countB++;
								if(countB <= les.get(i).getHourly()){
									temp = new LessonWithTeacher(les.get(i).getId(), teac.get(k).getInsideId()); //allagh edw gia to Id 
									lessonsB.add(temp);
								}
							}
						}
					}
				}
			}else{
				countC = 0;
				for(int j = 0; j < les.get(i).getHourly(); j++){
					for(int k = 0; k < teac.size(); k++){
						for(int l = 0; l < teac.get(k).getLessonsLength(); l++){
							if(les.get(i).getId() == teac.get(k).getLesson(l)){
								countC++;
								if(countC <= les.get(i).getHourly()){
									temp = new LessonWithTeacher(les.get(i).getId(), teac.get(k).getInsideId()); //allagh edw gia to Id 
									lessonsC.add(temp);
								}
							}
						}	
					}
				}
			}
		}
	}
	
	public void readLessonsFromText(String textName) {
		try {
			Lesson temp;
			//apo edw einai gia diavasma tou arxeiou
			StringTokenizer multiTokenizer = null;
		    BufferedReader in = new BufferedReader(new FileReader(textName));
		    String str,a="",b="",c="",d="",e="";
		    String strForTokens= "";
		    while ((str = in.readLine()) != null)
		    	strForTokens += str;
		    in.close();
		    //apo dw paizoume me ta tokens
		    multiTokenizer = new StringTokenizer(strForTokens, "://,:");
	        while (multiTokenizer.hasMoreTokens())
	        {
	        	a=multiTokenizer.nextToken();
	            if(a.contentEquals("Lesson Code")){
	            	if(multiTokenizer.hasMoreTokens()){
	            		b=multiTokenizer.nextToken();
	            		b = b.replaceAll("\\s+","");
	            		if(multiTokenizer.hasMoreTokens()){
	            			a=multiTokenizer.nextToken();
	            			if(a.contentEquals(" Lesson Name")){
	        	            	if(multiTokenizer.hasMoreTokens()){
	        	            		c=multiTokenizer.nextToken();
	        	            		c = c.replaceAll("\t", " ");
	        	            	}
	            			}
	            			if(multiTokenizer.hasMoreTokens()){
		            			a=multiTokenizer.nextToken();
		            			if(a.contentEquals(" Class")){
		        	            	if(multiTokenizer.hasMoreTokens()){
		        	            		d=multiTokenizer.nextToken();
		        	            		d = d.replaceAll("\\s+","");
		        	            	}
		            			}
		            			if(multiTokenizer.hasMoreTokens()){
			            			a=multiTokenizer.nextToken();
			            			if(a.contentEquals(" Hours Per Week")){
			        	            	if(multiTokenizer.hasMoreTokens()){
			        	            		e=multiTokenizer.nextToken();
			        	            		e = e.replaceAll("\\s+","");
			        	            	}
			        	            }
			            		}
		            		}
	            		}
	            	}
	            }
	            temp= new Lesson(Integer.parseInt(b),c,d,Integer.parseInt(e));
	            les.add(temp);
	        }
		} catch (IOException e) {
			System.out.println("error in file");
			System.exit(0);
		}
	}
	
	public void readTeachersFromText(String textName) {
		try {
			Teacher temp;
			//apo edw einai gia diavasma tou arxeiou
			ArrayList<Integer> LessonIds = new ArrayList<Integer>();
			StringTokenizer multiTokenizer = null;
		    BufferedReader in = new BufferedReader(new FileReader(textName));
		    String str,a="",b="",c="",d="",e="",f="";
		    String strForTokens= "";
		    while ((str = in.readLine()) != null)
		    	strForTokens += str;
		    in.close();
		    //apo dw paizoume me ta tokens
		    multiTokenizer = new StringTokenizer(strForTokens, "://,:");
	        while (multiTokenizer.hasMoreTokens())
	        {
	        	a=multiTokenizer.nextToken();
	            if(a.contentEquals("Teacher's Code")){
	            	if(multiTokenizer.hasMoreTokens()){
	            		b=multiTokenizer.nextToken();
	            		b = b.replaceAll("\\s+","");
	            		if(multiTokenizer.hasMoreTokens()){
	            			a=multiTokenizer.nextToken();
	            			if(a.contentEquals(" Teacher's Name")){
	            				if(multiTokenizer.hasMoreTokens()){
	        	            		c=multiTokenizer.nextToken();
	        	            		c = c.replaceAll("\t", " ");
	        	            		if(multiTokenizer.hasMoreTokens()){
	        	            			a=multiTokenizer.nextToken();
	        	            			if(a.contentEquals(" Lessons Code")){
	        	            				if(multiTokenizer.hasMoreTokens()){
        	            						a=multiTokenizer.nextToken();
        	            					}
	        	            				while(!a.contentEquals(" Max Number Per Day")){
	        	            					d=a.replaceAll("\\s+","");
	        	            					LessonIds.add(Integer.parseInt(d));
	        	            					if(multiTokenizer.hasMoreTokens()){
	        	            						a=multiTokenizer.nextToken();
	        	            					}
	        	            				}
	        	            				if(multiTokenizer.hasMoreTokens()){
        	            						a=multiTokenizer.nextToken();
        	            					}
	        	            				if(multiTokenizer.hasMoreTokens()){
        	            						a=multiTokenizer.nextToken();
        	            					}
	        	            				e=a.replaceAll("\\s+","");
	        	            				if(multiTokenizer.hasMoreTokens()){
        	            						a=multiTokenizer.nextToken();
        	            					}
	        	            				f=a.replaceAll("\\s+","");
	        	            				
	        	            			}
	        	            		}
	            				}
	            			}
	            		}
	            	}
	            }
	            temp=new Teacher(b,c,LessonIds,Integer.parseInt(e),Integer.parseInt(f));
	            teac.add(temp);
	            LessonIds.clear();
	        }
	        Teacher.ResetCounter();
	        
		} catch (IOException e) {
			System.out.println("error in file");
			System.exit(0);
		}
		
	}
	
	public ArrayList<Lesson> getLessons(){
		return(les);
	}
	
	public ArrayList<Teacher> getTeachers(){
		return(teac);
	}
	
	public void setLessonsA(LessonWithTeacher t){ 
		lessonsA.add(t);
	}
	
	public void setLessonsB(LessonWithTeacher t){ 
		lessonsB.add(t);
	}
	
	public void setLessonsC(LessonWithTeacher t){ 
		lessonsC.add(t);
	}
	
	
	public LessonWithTeacher getElementA(int i){
		if(i < 0 || i > lessonsA.size()){
			return null;
		}else{
			return lessonsA.get(i);
		}
	}
	
	public LessonWithTeacher getElementB(int i){
		if(i < 0 || i > lessonsB.size()){
			return null;
		}else{
			return lessonsB.get(i);
		}
	}
	
	public LessonWithTeacher getElementC(int i){
		if(i < 0 || i > lessonsC.size()){
			return null;
		}else{
			return lessonsC.get(i);
		}
	}
	
	public ArrayList<LessonWithTeacher> getA(){
		return(lessonsA);
	}
	
	public ArrayList<LessonWithTeacher> getB(){
		return(lessonsB);
	}
	
	public ArrayList<LessonWithTeacher> getC(){
		return(lessonsC);
	}
	
}
