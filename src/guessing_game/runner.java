package guessing_game;

import java.util.Random;

import javax.swing.*;

public class runner{
	//int n=Home.getNumber_of_tries();
	static int count;
	public static int getcount() {
		return count;
	}
    public runner() {
    	int n=Home.getNumber_of_tries();
    	Random rand=new Random();
        int computerNumber = rand.nextInt(Home.getRange())+1;
        int userAnswer = 0;
       // System.out.println("The correct guess is " + computerNumber);
        count = 0;
        //enter the number of tries
        //enter name and such info
        //max score
        //give up button
        //play again
        //show numner of guesses
        boolean pass=false;
        while (userAnswer != computerNumber&& count<n)
        {
            String response = JOptionPane.showInputDialog(null,
                "Enter a guess between 1 and "+Home.getRange(), "Guessing Game", 3);
            
            userAnswer = Integer.parseInt(response);
            if (userAnswer ==computerNumber) {
            	pass=true;
            }
            JOptionPane.showMessageDialog(null, ""+ determineGuess(userAnswer, computerNumber));
            count++;
          //  Home.countt.setText(String.valueOf(count));
            Home.counter.setText(""+count);
        }
        if (pass) {
        	//Home.success.setText("Congratulations.YOU WON");
        	JOptionPane.showMessageDialog(null,"Congratulations.YOU WON");
        	
        }else {
        	JOptionPane.showMessageDialog(null, "You ran out of attempts :(\nThe correct guess was " + computerNumber);
        	//Home.success.setText("You ran out of attempts :(");
        	
        }
    }

    public static String determineGuess(int userAnswer, int computerNumber){
    	if (userAnswer>Home.getRange()) {
    		return "your guess is out of range";
    	}
    	if (userAnswer<0) {
    		return "Your guess should e positive";
    	}
        if (userAnswer <=0 || userAnswer >100) {
            return "Your guess is invalid";
        }
        else if (userAnswer == computerNumber ){
            return "Correct!";
        }
        else if (userAnswer > computerNumber) {
            return "Your guess is too high, try again.You still have "+(Home.getNumber_of_tries()-count-1)+" attempts.";
        }
        else if (userAnswer < computerNumber) {
            return "Your guess is too low, try again.You still have " +(Home.getNumber_of_tries()-count-1)+" attempts." ;
        }
        else {
            return "Your guess is incorrect\n";
        }
    }
}
