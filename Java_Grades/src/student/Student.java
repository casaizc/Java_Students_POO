package student;

import java.util.Arrays;

public class Student implements Comparable<Student> {
    String id;
	int java;
	int sql;
	int math;
	int chinese;
	int rank;
	String materia[] = {"Java", "SQL", "Math", "Chinese"};
	int[] grades = new int[materia.length];
	// TODO: You have to change this constructor
	
	//constructor of the students object, set the id in the class
	public Student(String id) {
		
		this.id = id;
	}
	
	//method that receives grades from the students object and set the grades
	public void setScores(int grades[]) {
		
		for(int i = 0; i < grades.length; i++){
			
			this.grades[i] = grades[i];
			
		}

	}

	//method that calculates and returns the value of the average of the student's grades
	public double calculateAverage() {
		
		int sum = Arrays.stream(grades).sum();
		double average = sum/(float)(grades.length);
		return average;

	}
	
	public static void calculateAverageMateria(String materia2, int avg, int cantidad) {
		
		double average = avg/(float)(cantidad);
		String num1 = String.format("%.2f", average);
		System.out.println(materia2 + " Class Avg : " + num1);

	}
	
	//method that prints the information of each student (id, grades, average and rank)
	public void printScoreInfo() {

		double avg;
		
		avg = calculateAverage(); //Gets the average value of the method calculateAverage
		
		String num1 = String.format("%.2f", avg); //converts a string to whatever format we are, in this case to a floating number with two decimal places
        System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("[" + id + "] " + "Student's Score Status");
		System.out.println("Java " + grades[0] + ", SQL " + grades[1]  + ", Math " + grades[2]  + ", Chinese " + grades[3] );
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("AVG : " + num1 + " Rank : " + rank);
        System.out.println("-----------------------------------------------------------------------------------------");
	   
	}

	public String getId() { //returns the student id
		
		return id;
	}
	
	public void setId(String id) { //this method gets the student id and updates its value to the next integer
	        
		String aux = id.substring(3);
		int entero = Integer.parseInt(aux);
		entero ++;
		
			if(entero >= 10) {
				
				aux = "STD" + entero;
				
			}	else {
				
				aux = "STD0" + entero;
				
			}
			
		this.id = aux;
		
	}
	
	//returns the student Rank
	public int getRank() {		
		
		return rank;
		}
	
	//set the rank of the student
	public void setRank(int i) {
		
		this.rank = i;	
	}
	
	public void finalScore(String id, int rank , int[] grades) {
		
		double avr;
		String promedio;
		this.id = id;
		this.rank = rank;
		this.grades = grades;
		avr = calculateAverage();
		promedio = String.format("%.2f", avr);
		System.out.println(id+" : =>  AVG : "+promedio+", Rank : "+rank);

	}

	
	//method included in the comparable interface, which orders an array from highest to lowest
	@Override
	public int compareTo(Student other) {
		
		int sum1 = 0;
		int sum2 = 0;
		
		for (int i = 0; i < grades.length; i++ ) {
		
			sum1 = this.grades[i] + sum1;
		
			sum2 = other.grades[i] + sum2;
		}
		return  (sum2 - sum1);

	}

}
