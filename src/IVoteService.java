//IVoteSerive Class is an engine to work with the questions and the student submissions together.
//It utilizes a Hashmap to store the data, so that when mutiple submissions are accepted
//from a single student ID, only the last one exists.

import java.util.Map;
import java.util.HashMap;

public class IVoteService { 
	//Use the interface type so that it can adapt to other types of map.
	private Map <String, int[]> voteResult = new HashMap <String, int[]>();
	private Question questionForVote;
	
	//overload the acceptAnswers method, with MultipleChoiceQuestion type.
	public void acceptAnswers (MultipleChoiceQuestion question, Student student){
		voteResult.put(student.getID(), student.submitAnswer());
		questionForVote = question;
	}
	
	//overload the acceptAnswers method, with SingleChoiceQuestion type.
	//Only the last choice of a submission is accepted.
	public void acceptAnswers(SingleChoiceQuestion question, Student student){
				int [] tempHolder =student.submitAnswer();
				int [] singleAnswerHolder = new int[1];
				
				//Hold the last choice of a submission, then put into the Hashmap.
				singleAnswerHolder[0] = tempHolder[tempHolder.length-1];				
				voteResult.put(student.getID(), singleAnswerHolder);		
				questionForVote = question;
	}
	
	public void displayStats () {
		StringBuffer display = new StringBuffer();
		display.append(questionForVote.getTitle()+"\n");
		String [] answers = questionForVote.getCondidatedAnswers();
		int [] votingsum = sumOfVote ();
		for (int i=0; i<answers.length; i++){	
			display.append(answers[i]+": "+votingsum[i]+"\n");		
		}
		//return display;
		System.out.println(display);
	}
	
	//The method is to loop through the Hashmap to collect sum of a particular selection.
	private int[] sumOfVote (){
		int theVoteIndexLimit = questionForVote.getCondidatedAnswers().length;
		
		//countforVoteIndexArray is to hold the sum of all vote for a certain answer,
		//which are arranged by the candidate answer order.
		int [] countforVoteIndexArray = new int[theVoteIndexLimit];
		
		//The countforVoteIndex is the sum of a candidate answer in a Hashmap.
		int countforVoteIndex;
		
		//loop through the candidate answers
		for (int theVoteIndex=0; theVoteIndex<theVoteIndexLimit; theVoteIndex++){
			countforVoteIndex=0;
			//loop through the map to accumulate the count for each vote
			for (String name:voteResult.keySet()){
			
				int[] voteUnderName = voteResult.get(name);
				//loop through each submitted answer holder to find the match.
				for (int i = 0; i<voteUnderName.length; i++){
					if (voteUnderName[i] == theVoteIndex){
						countforVoteIndex++;
					}
				}
			}
			//assigned the sum of each answer into the array.
			countforVoteIndexArray[theVoteIndex]=countforVoteIndex;
		}
		return countforVoteIndexArray;
	}
}
