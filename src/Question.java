import java.util.Map;

//The Question class consists of title and candidate answers as string array.
//The acceptable candidate answers are up to ten.

public abstract class Question {
	private String title;
	private String[] candidatedAnswers = new String[10];
	
	//Initialize the question with a title.
	public Question (String title){
		this.title = title;
	}
	
	//Add method to add answers to the question.
	public Question addCandidatedAnswer(String answer){
		int index = 0;
		while (candidatedAnswers[index]!=null){
			index++;
		}
		this.candidatedAnswers[index]=answer;
		return this;
	}
	
	//Set the candidate answers with an index.
	public void setCandidatedAnswer(int index, String answer){
		this.candidatedAnswers[index]= answer;
	}

	//Return the title of the question.
	public String getTitle () {
		return this.title;
	}
	
	//Return a trimmed set of candidate answers in a string array.
	public String[] getCondidatedAnswers () {
		int notNullSize = 0;
		for (int i = 0; i<candidatedAnswers.length; i++){
			if (candidatedAnswers[i]!=null){
				notNullSize++;
			}
		}
		
		String [] trimmedAnswers = new String [notNullSize];
		for (int i = 0; i<notNullSize; i++){
			trimmedAnswers[i]=candidatedAnswers[i];
		}
		return trimmedAnswers;
	}
	
	//to be overload method
	public void registerAnswers(Map <String, int[]> voteResult, Student student){
	}
	
}
