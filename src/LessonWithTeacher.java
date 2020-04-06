//Vasilis Stavrianoudakis AM: 3140193, Anastasios Tsoukas AM: 3140213, Ektoras Typaldos AM: 3140216
public class LessonWithTeacher {

	private int lessonId, teacherId;
	
	public LessonWithTeacher(int lessonId, int teacherId){
		this.lessonId = lessonId;
		this.teacherId = teacherId;
		
	}
	
	public int getLessonId(){
		return lessonId;
	}
	
	public int getTeacherId(){
		return teacherId;
	}
	
	public void print(){
		System.out.println("lesson Id= " + lessonId + " teacher Id = " + teacherId);
	}
}
