//Vasilis Stavrianoudakis AM: 3140193, Anastasios Tsoukas AM: 3140213, Ektoras Typaldos AM: 3140216
import java.util.ArrayList;

public class Teacher {
	
	private static int counter=0;
	private int insideId; //einai to id pou xrisimopoiei o kodikas gia an treksei wste na min eksartate apo to text.
	private String id;
	private String name;
	private ArrayList<Integer> lessons = new ArrayList<Integer>();
	private int maxDay;
	private int maxWeek;
	
	public Teacher(String id, String name, ArrayList<Integer> lesson, int maxDay, int maxWeek){
		insideId=counter;
		counter++;
		this.id = id;
		this.name = name;
		this.maxDay = maxDay;
		this.maxWeek = maxWeek;
		for(int i = 0; i < lesson.size(); i++){
			lessons.add(lesson.get(i));
		}
	}
	
	public int getCounter(){
		return counter;
	}
	
	public int getInsideId(){
		return insideId;
	}
	
	public static void ResetCounter(){
		counter=0;
	}
	
	public String getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public int getMaxDay(){
		return maxDay;
	}
	
	public int getMaxWeek(){
		return maxWeek;
	}
	
	public int getLesson(int i){
		return lessons.get(i);
	} 
	
	public int getLessonsLength(){
		return lessons.size();
	}
	
	public void print(){
		System.out.print("id= " + id + "  name = " + name + " maxDay = " + maxDay + " maxWeek = " + maxWeek + " mathimata =");
		for(int i = 0; i < lessons.size(); i++){
			System.out.print( " " + (i+1) + " " + lessons.get(i));
		}
		System.out.print("\n");
	}	
	
}
