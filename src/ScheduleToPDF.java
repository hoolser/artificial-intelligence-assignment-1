//Vasilis Stavrianoudakis AM: 3140193, Anastasios Tsoukas AM: 3140213, Ektoras Typaldos AM: 3140216
import java.io.IOException;
import java.util.ArrayList;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class ScheduleToPDF {
	private PDDocument doc = new PDDocument();
    private LessonWithTeacher[][] a1 = new LessonWithTeacher[7][5];
    private LessonWithTeacher[][] a2 = new LessonWithTeacher[7][5];
    private LessonWithTeacher[][] a3 = new LessonWithTeacher[7][5];
    private LessonWithTeacher[][] b1 = new LessonWithTeacher[7][5];
    private LessonWithTeacher[][] b2 = new LessonWithTeacher[7][5];
    private LessonWithTeacher[][] b3 = new LessonWithTeacher[7][5];
    private LessonWithTeacher[][] c1 = new LessonWithTeacher[7][5];
    private LessonWithTeacher[][] c2 = new LessonWithTeacher[7][5];
    private LessonWithTeacher[][] c3 = new LessonWithTeacher[7][5];
	private ArrayList<Lesson> les;
	private ArrayList<Teacher> teac;
	
	public void saveFile (LessonWithTeacher[][] sched, ArrayList<Lesson> les1, ArrayList<Teacher> teac1) throws IOException {
		les = new ArrayList<Lesson>(les1);
		teac = new ArrayList<Teacher>(teac1);
	    for(int i = 0; i < sched.length; i++){
	    	for(int j = 0; j < sched[0].length; j++){
		    	if(i < 7){
		    		a1[i][j] = sched[i][j];
		    	}else if(i >= 7 && i < 14){
		    		a2[i % 7][j] = sched[i][j];
		    	}else if(i >= 14  && i < 21){
		    		a3[i % 7][j] = sched[i][j];
		    	}else if(i >= 21 && i < 28){
		    		b1[i % 7][j] = sched[i][j];
		    	}else if(i >= 28 && i < 35){
		    		b2[i % 7][j] = sched[i][j];
		    	}else if(i >= 35 && i < 42){
		    		b3[i % 7][j] = sched[i][j];
		    	}else if(i >= 42 && i < 49){
		    		c1[i % 7][j] = sched[i][j];
		    	}else if(i >= 49 && i < 56){
		    		c2[i % 7][j] = sched[i][j];
		    	}else if(i >= 56 && i < 63){
		    		c3[i % 7][j] = sched[i][j];
		    	}
		    }
	    }
	    PDFont font = PDType1Font.TIMES_ROMAN;

	    
	    PDPage page = new PDPage();
	    doc.addPage( page );
	    PDPageContentStream contentStream = new PDPageContentStream(doc, page);
	    contentStream.beginText();
	    contentStream.setFont( font, 18 );
	    contentStream.newLineAtOffset( page.getCropBox().getWidth()/3, page.getCropBox().getHeight() - 50 );
	    contentStream.showText( "PROGRAMMA A1" );
	    contentStream.endText();
	    drawTable(page, contentStream, 700, 0, a1);
	    contentStream.close();
	    
	    page = new PDPage();
	    doc.addPage( page );
	    contentStream = new PDPageContentStream(doc, page);
	    contentStream.beginText();
	    contentStream.setFont( font, 18 );
	    contentStream.newLineAtOffset( page.getCropBox().getWidth()/3, page.getCropBox().getHeight() - 50 );
	    contentStream.showText( "PROGRAMMA A2" );
	    contentStream.endText();
	    drawTable(page, contentStream, 700, 0, a2);
	    contentStream.close();
	    
	    page = new PDPage();
	    doc.addPage( page );
	    contentStream = new PDPageContentStream(doc, page);
	    contentStream.beginText();
	    contentStream.setFont( font, 18 );
	    contentStream.newLineAtOffset( page.getCropBox().getWidth()/3, page.getCropBox().getHeight() - 50 );
	    contentStream.showText( "PROGRAMMA A3" );
	    contentStream.endText();
	    drawTable(page, contentStream, 700, 0, a3);
	    contentStream.close();
	    
	    page = new PDPage();
	    doc.addPage( page );
	    contentStream = new PDPageContentStream(doc, page);
	    contentStream.beginText();
	    contentStream.setFont( font, 18 );
	    contentStream.newLineAtOffset( page.getCropBox().getWidth()/3, page.getCropBox().getHeight() - 50 );
	    contentStream.showText( "PROGRAMMA B1" );
	    contentStream.endText();
	    drawTable(page, contentStream, 700, 0, b1);
	    contentStream.close();
	    
	    page = new PDPage();
	    doc.addPage( page );
	    contentStream = new PDPageContentStream(doc, page);
	    contentStream.beginText();
	    contentStream.setFont( font, 18 );
	    contentStream.newLineAtOffset( page.getCropBox().getWidth()/3, page.getCropBox().getHeight() - 50 );
	    contentStream.showText( "PROGRAMMA B2" );
	    contentStream.endText();
	    drawTable(page, contentStream, 700, 0, b2);
	    contentStream.close();
	    
	    page = new PDPage();
	    doc.addPage( page );
	    contentStream = new PDPageContentStream(doc, page);
	    contentStream.beginText();
	    contentStream.setFont( font, 18 );
	    contentStream.newLineAtOffset( page.getCropBox().getWidth()/3, page.getCropBox().getHeight() - 50 );
	    contentStream.showText( "PROGRAMMA B3" );
	    contentStream.endText();
	    drawTable(page, contentStream, 700, 0, b3);
	    contentStream.close();
	    
	    page = new PDPage();
	    doc.addPage( page );
	    contentStream = new PDPageContentStream(doc, page);
	    contentStream.beginText();
	    contentStream.setFont( font, 18 );
	    contentStream.newLineAtOffset( page.getCropBox().getWidth()/3, page.getCropBox().getHeight() - 50 );
	    contentStream.showText( "PROGRAMMA C1" );
	    contentStream.endText();
	    drawTable(page, contentStream, 700, 0, c1);
	    contentStream.close();
	    
	    page = new PDPage();
	    doc.addPage( page );
	    contentStream = new PDPageContentStream(doc, page);
	    contentStream.beginText();
	    contentStream.setFont( font, 18 );
	    contentStream.newLineAtOffset( page.getCropBox().getWidth()/3, page.getCropBox().getHeight() - 50 );
	    contentStream.showText( "PROGRAMMA C2" );
	    contentStream.endText();
	    drawTable(page, contentStream, 700, 0, c2);
	    contentStream.close();
	    
	    page = new PDPage();
	    doc.addPage( page );
	    contentStream = new PDPageContentStream(doc, page);
	    contentStream.beginText();
	    contentStream.setFont( font, 18 );
	    contentStream.newLineAtOffset( page.getCropBox().getWidth()/3, page.getCropBox().getHeight() - 50 );
	    contentStream.showText( "PROGRAMMA C3" );
	    contentStream.endText();
	    drawTable(page, contentStream, 700, 0, c3);
	    
	    
	    
	    contentStream.close();
	    doc.save("Schedule.pdf" );
	}
	
	
	
	public void drawTable(PDPage page, PDPageContentStream contentStream, float y, float margin, LessonWithTeacher[][] sched) throws IOException {
		final int rows = sched.length;
		final int cols = sched[0].length;
		final float rowHeight = 20f;
		final float tableWidth = page.getCropBox().getWidth();
		final float tableHeight = rowHeight * rows;
		final float colWidth = tableWidth/(float)cols;
		final float cellMargin=5f;
		
		//draw the rows
		float nexty = y ;
		for (int i = 0; i <= rows; i++) {
			contentStream.moveTo(margin, nexty);
			contentStream.lineTo(margin+tableWidth, nexty);
			contentStream.stroke();
			nexty-= rowHeight;
		}
		
		//draw the columns
		float nextx = margin;
		for (int i = 0; i <= cols; i++) {
			contentStream.moveTo(nextx, y);
			contentStream.lineTo(nextx, y-tableHeight);
			contentStream.stroke();
			nextx += colWidth;
		}
		
		//now add the text
		contentStream.setFont( PDType1Font.HELVETICA , (float) 5.5 );
		
		float textx = margin+cellMargin;
		float texty = y-15;
		for(int i = 0; i < sched.length; i++){
			for(int j = 0 ; j < sched[0].length; j++){
				String lesson = "";
				String teacher = "";
				if(sched[i][j] != null){
					for(int n = 0; n < les.size(); n++){
						if(les.get(n).getId() == sched[i][j].getLessonId()){
							lesson = les.get(n).getLessonName();
							break;
						}
					}
					for(int n = 0; n < teac.size(); n++){
						if(teac.get(n).getInsideId() == sched[i][j].getTeacherId()){
							teacher = teac.get(n).getName();
							break;
						}
					}
					String text = lesson + teacher ;
					contentStream.beginText();
					contentStream.newLineAtOffset(textx,texty);
					contentStream.showText(text);
					contentStream.endText();
					textx += colWidth;
				}else {
					String text = " " ;
					contentStream.beginText();
					contentStream.newLineAtOffset(textx,texty);
					contentStream.showText(text);
					contentStream.endText();
					textx += colWidth;
				}

			}
			texty-=rowHeight;
			textx = margin+cellMargin;
		}
	}
}