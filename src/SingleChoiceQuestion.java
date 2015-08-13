import java.util.Map;

//The extended class is initialized by being recognized by the 
//IVoteService so that different method is called.

public class SingleChoiceQuestion extends Question {
	public SingleChoiceQuestion (String title){
		super(title);
	}
	
	//override the acceptAnswers method, with SingleChoiceQuestion type.
	//Only the last choice of a submission is accepted.
	@override 
	public void registerAnswers(Map <String, int[]> voteResult, Student student){		
					int [] tempHolder =student.submitAnswer();
					int [] singleAnswerHolder = new int[1];
					
					//Hold the last choice of a submission, then put into the Hashmap.
					singleAnswerHolder[0] = tempHolder[tempHolder.length-1];				
					voteResult.put(student.getID(), singleAnswerHolder);
	}
}
