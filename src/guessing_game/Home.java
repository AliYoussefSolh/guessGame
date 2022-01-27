package guessing_game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Home extends JFrame implements ActionListener {
	private JTextField Input;
	public static JTextField counter=new JTextField();
	private static int number_of_tries = 0;
	private JLabel error;
	//public static JLabel success;
	private JButton button = new JButton("Continue to game");
	private JButton st = new JButton("Start new game");
	private JButton gv = new JButton("Give up :(");
	public static int getNumber_of_tries() {
		return number_of_tries;
	}

	public void setNumber_of_tries(int number_of_tries) {
		this.number_of_tries = number_of_tries;
	}

	public Home() {
		this.setTitle("Guess game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(650, 400);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		ImageIcon image = new ImageIcon("guess.jpg");
		this.setIconImage(image.getImage());

		JLabel welcome = new JLabel("Challenge your self");
		welcome.setBounds(285, 5, 150, 25);
		this.add(welcome);
		JLabel PS = new JLabel("(PS: Closing this window will close the whole app)");
		PS.setForeground(Color.red);
		PS.setBounds(200, 300, 320, 50);
		this.add(PS);

		JLabel Number = new JLabel("Number of Attempts");
		Number.setBounds(8, 30, 320, 50);
		this.add(Number);
		Input = new JTextField();
		Input.setBounds(130, 40, 220, 30);
		this.add(Input);
		error = new JLabel();
		error.setBounds(200, 250, 320, 50);
		error.setForeground(Color.red);
		this.add(error);
		button.setBounds(130, 70, 220, 70);
		button.addActionListener(this);
		this.add(button);
		JLabel txt=new JLabel("Guesses");
		txt.setBounds(450, 20, 320, 50);
		this.add(txt);
//		success=new JLabel("");
//		success.setBounds(250, 200, 320, 50);
//		this.add(success);
	    
		counter.setBounds(450, 60, 100, 30);
		counter.setText(""+0);
		this.add(counter);
		st.setBounds(130, 150, 220, 70);
		this.add(st);
	    st.addActionListener(this);
		gv.setBounds(450, 150, 180, 70);
		gv.addActionListener(this);
		this.add(gv);
		
		this.setVisible(true);

//		signUp = new JButton("click here to sign up");
//		logIn = new JButton("click here to log in");
//		signUp.setBounds(67, 40, 149 ,50);
//		signUp.addActionListener(this);
//		logIn.setBounds(67, 100, 149 ,50);
//		logIn.addActionListener(this);
//		this.add(signUp);
//		this.add(logIn);
//		
//		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
//			new runner();

			try {
				number_of_tries = Integer.parseInt(Input.getText());
//				System.out.println(Input.getText());
//				System.out.println(number_of_tries);
				new runner();
				// pass=true;
				error.setText("");
			} catch (NumberFormatException ex) {
				error.setText("Please enter a valid number to start the game.");
			}

		}else if (e.getSource()==st) {
			Input.setText("");
			counter.setText(0+"");
		}else if (e.getSource()==gv) {
			this.dispose();
		}

	}

}
