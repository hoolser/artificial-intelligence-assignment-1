//Vasilis Stavrianoudakis AM: 3140193, Anastasios Tsoukas AM: 3140213, Ektoras Typaldos AM: 3140216
public class Lesson {

	private int id;
	private String lessonName;
	private String classRoom;
	private int hourly;  
	
	public Lesson(int id, String lessonName, String classRoom, int hourly){
		this.id = id;
		this.lessonName = lessonName;
		this.classRoom = classRoom;
		this.hourly=hourly;
	}
	
	public int getId(){
		return id;
	}
	
	public String getLessonName(){
		return lessonName;
	}
	
	public String getClassRoom(){
		return classRoom;
	}
	
	public int getHourly(){
		return hourly;
	} 
	
	public void print(){
		System.out.print("id= " + id + " lesson name = " + lessonName + " classroom = " + classRoom + " wres didaskalias kathe tmimatos =");
		System.out.print(  " " + hourly);
		System.out.print("\n");
	}
}
