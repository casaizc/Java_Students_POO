package student;

import utilidades.Funciones;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int cantidad = Funciones.getUserIntegerInput();
		Student[] students = new Student[cantidad];
		Student student = new Student("STD01");
		int[] grades = new int[student.materia.length];
		
		for(int i = 0; i < students.length; i++) {
			
			String id = student.getId();
			students[i] = new Student(id);
         

			for(int j = 0; j < student.materia.length; j++) {
				
				grades[j] = (int) Funciones.getUserDoubleInput(id, student.materia[j]);
				
			}
			
			student.setScores(grades);
			students[i].setScores(grades);
			student.setRank(i+1);
			students[i].setRank(i+1);
			
			if ( i > 0 ) {
           	for(int a = 0 ; a < i ; a++) {
        		for(int b = 0 ; b <= i  ; b++) {
        			
        			student.setScores(students[a].grades);
        			double aux1 = students[a].calculateAverage();
        			student.setScores(students[b].grades);
        			double aux2 = students[b].calculateAverage();
    				if(aux1 < aux2 && students[a].rank < students[b].rank) {
    					
    					int aux3 = students[a].rank;
    					students[a].rank = students[b].rank;
    					students[b].rank = aux3;
    					student.setRank(aux3);
    				
    					}
        			}
        		}
			}

			student.printScoreInfo(); //The complete and updated information of the student who was assigned the grades is shown
			student.setId(id);
    
		}
		
    	Arrays.sort(students);
    	
		for (int i = 0; i < students.length; i++) {
			double promedio;
			student.setScores(students[i].grades);
			promedio = student.calculateAverage();
			String num1 = String.format("%.2f", promedio);
			System.out.println(students[i].id + " : =>  AVG : " + num1 + " Rank : " + students[i].rank);
		}
		
		System.out.println("=============================================");
		
		for (int i = 0; i < student.materia.length; i++) {
		
			int Avg = 0;
			
			for (int j = 0; j < student.materia.length ; j++) {
          			Avg = students[j].grades[i] + Avg;		
				}
				
			Student.calculateAverageMateria(student.materia[i], Avg, cantidad);
			
		}
		
		System.out.println("=============================================");	
	}	
	
}
		

