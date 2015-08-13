import java.util.Random;

//The SimulationDriver is a real live simulation to test the IVoteService.
public class SimulationDriver {
	static final int NUMBER_OF_SIMULATION = 30;
	
	public static void main(String[] args){
		//Declare and initialize the random number generator;
		Random rn = new Random();
		
		//Initiate the questions, including one SingleChoiceQuestion and one Multiple Choice Question.
		SingleChoiceQuestion question1 = new SingleChoiceQuestion("What is the largest planet in the solar system?");
		MultipleChoiceQuestion question2 = new MultipleChoiceQuestion("What are your favorate fruits?");
		
		question1.addCandidatedAnswer("a. Jupiter")
					.addCandidatedAnswer("b. Saturn")
					.addCandidatedAnswer("c. Neptune");
		
		question2.addCandidatedAnswer("a. apple")
					.addCandidatedAnswer("b. pear")
					.addCandidatedAnswer("c. grape")
					.addCandidatedAnswer("d. grapefruit");
		
		//Initialize the maximum allowable size of answer entries.
		int randomUpperLimit = question2.getCondidatedAnswers().length;
		
		//Generate fixed number of random answer entries. Answer entry length may vary.
		int[][] choices = new int[NUMBER_OF_SIMULATION][];
		for (int i=0; i<NUMBER_OF_SIMULATION; i++ ){
			 int choicesLength = rn.nextInt(randomUpperLimit)+1;
			 choices[i] = randomChoices(choicesLength, randomUpperLimit);		
			}
		
		//Initialize fixed number of students with random IDs and answer entries.
		//The student IDs may be repeated. Only the final input is accepted by HashMap.
		Student[] studentArray = new Student[NUMBER_OF_SIMULATION];
		for (int i=0; i<NUMBER_OF_SIMULATION; i++){
			studentArray[i]=new Student((String.valueOf(rn.nextInt(NUMBER_OF_SIMULATION))),choices[i]);
		}
		
		//Initialize IvoteService and accept student answers.
		IVoteService voteService = new IVoteService(question2);
		for (int i=0; i<NUMBER_OF_SIMULATION; i++){
			voteService.acceptAnswers(studentArray[i]);
		}
		
		//Call the display method.
		voteService.displayStats();
	}
	
	//Method to generate an array of certain size and within 0 to an integer limit.
	public static int[] randomChoices(int length, int limit){
		Random rn = new Random();
		int[] randomArray = new int[length];
		for (int i=0; i<length; i++){
			randomArray[i]=rn.nextInt(limit);
		}
		return randomArray;
	}
	
}
