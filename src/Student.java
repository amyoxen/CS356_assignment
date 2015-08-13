//The Student Class contains student id and an int array to hold the questions.
//Only the two elements are essential to the IVoteService.

public class Student {
	private String id;
	private int[]answerHolder;
	
	//Method to initialize the student class.
	public Student (String id, int[] choices){
		this.id = id;
		answerHolder = new int[choices.length];
		for (int i=0; i< choices.length;i++){
			answerHolder[i] = choices[i];
		}
	}
	
	//Method to obtain the student id.
	public String getID(){
		return id;
	}
	
	//Method to obtain the student answers.
	public int[] submitAnswer(){		
		return answerHolder;
	}
}
