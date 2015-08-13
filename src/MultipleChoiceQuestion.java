import java.util.Map;

//The extended class is initialized by being recognized by the 
//IVoteService so that different method is called.

public class MultipleChoiceQuestion extends Question {
		public MultipleChoiceQuestion (String title){
			super(title);
		}
		
		//override the acceptAnswers method, with MultipleChoiceQuestion type.
		@override 
		public void registerAnswers(Map <String, int[]> voteResult, Student student){
			voteResult.put(student.getID(), student.submitAnswer());
		}

}
