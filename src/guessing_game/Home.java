package guessing_game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Home extends JFrame implements ActionListener {
	public  static JTextField Input,Input2;
	public static JTextField counter=new JTextField();
	private static int number_of_tries = 0;
	private static int range= 2;
	public static JLabel error;
	public static int getRange() {
		return range;
	}

	public static void setRange(int range) {
		Home.range = range;
	}

	
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
		this.setSize(670, 430);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		ImageIcon image = new ImageIcon("guess.jpg");
		this.setIconImage(image.getImage());

		JLabel welcome = new JLabel("Challenge your self");
		welcome.setBounds(285, 5, 150, 25);
		this.add(welcome);
		JLabel PS = new JLabel("(PS: Closing this window will close the whole app)");
		PS.setForeground(Color.red);
		PS.setBounds(200, 310, 320, 50);
		this.add(PS);

		JLabel Number = new JLabel("Number of Attempts");
		Number.setBounds(8, 40, 220, 50);
		this.add(Number);
		JLabel range=new JLabel("Range of computer number between 1 and ");
		range.setBounds(300, 40, 260, 50);
		this.add(range);
		Input2=new JTextField();
		Input2.setBounds(569, 50, 50, 30);
		this.add(Input2);
		Input = new JTextField();
		Input.setBounds(155, 50, 120, 30);
		this.add(Input);
		error = new JLabel();
		error.setBounds(200, 260, 320, 50);
		error.setForeground(Color.red);
		this.add(error);
		button.setBounds(130, 85, 220, 70);
		button.addActionListener(this);
		this.add(button);
		JLabel txt=new JLabel("Guesses");
		txt.setBounds(470, 75, 320, 50);
		this.add(txt);
//		success=new JLabel("");
//		success.setBounds(250, 200, 320, 50);
//		this.add(success);
	    
		counter.setBounds(470, 110, 100, 30);
		counter.setText(""+0);
		this.add(counter);
		st.setBounds(130, 165, 220, 70);
		this.add(st);
	    st.addActionListener(this);
		gv.setBounds(450, 160, 180, 70);
		gv.addActionListener(this);
		this.add(gv);
		
		this.setVisible(true);



	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {


			try {
				number_of_tries = Integer.parseInt(Input.getText());
				range= Integer.parseInt(Input2.getText());

				new runner();
				// pass=true;
				error.setText("");
			} catch (NumberFormatException ex) {
				error.setText("Please enter a valid number to start the game.");
			}


		}else if (e.getSource()==st) {
			Input.setText("");
			Input2.setText("");
			error.setText("");
			counter.setText(0+"");
		}else if (e.getSource()==gv) {
			this.dispose();
		}

	}

}
