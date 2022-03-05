package guessing_game;


import java.util.Random;

import javax.swing.*;

public class runner{
	static int count;
	public static int getcount() {
		return count;
	}
    public runner() {
    	int n=Home.getNumber_of_tries();
    	Random rand=new Random();
        int computerNumber = rand.nextInt(Home.getRange())+1;
        int userAnswer = 0;
        count = 0;
        
        boolean pass=false;
        while (userAnswer != computerNumber&& count<n)
        {
            String response = JOptionPane.showInputDialog(null,
                "Enter a guess between 1 and "+Home.getRange(), "Guessing Game", 3);
            try {
            	userAnswer = Integer.parseInt(response);
                if (userAnswer ==computerNumber) {
                	pass=true;
                }
                JOptionPane.showMessageDialog(null, ""+ determineGuess(userAnswer, computerNumber));
                count++;
              
                Home.counter.setText(""+count);
            }catch(NumberFormatException e) {
            	JOptionPane.showMessageDialog(null, "Please enter a number");
            }
            
            
        }
        if (pass) {
        	
        	JOptionPane.showMessageDialog(null,"Congratulations.YOU WON");
        	Home.Input.setText("");
			Home.Input2.setText("");
			Home.error.setText("");
			Home.counter.setText(0+"");
        	
        }else {
        	JOptionPane.showMessageDialog(null, "You ran out of attempts :(\nThe correct guess was " + computerNumber);
        	
        	
        }
    }

    public static String determineGuess(int userAnswer, int computerNumber){
    	if (userAnswer>Home.getRange()) {
    		return "your guess is out of range";
    	}
    	else if (userAnswer<0) {
    		return "Your guess should be positive";
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
