import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class game extends JFrame{
	//create list store picture
	int[] pic = new int[3];
	
	//variable
	private JLabel pic1;
	int computer;
	int userinput;

	//Scissor Rock Paper on panel
	ImageIcon ScissorIcon = new ImageIcon("pic/4.jpg");
	ImageIcon RockIcon = new ImageIcon("pic/5.jpg");
	ImageIcon PaperIcon = new ImageIcon("pic/6.jpg");
	JButton jbtScissor = new JButton(ScissorIcon);
	JButton jbtRock = new JButton(RockIcon);
	JButton jbtPaper = new JButton(PaperIcon); 
	//"Start" on the panel
	private JButton jbtStart = new JButton("Start");
	//create new panel
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel pst = new JPanel();
	ImageIcon[] picx = {new ImageIcon("pic/1.jpg"),
						new ImageIcon("pic/2.jpg"),
						new ImageIcon("pic/3.jpg")};
	

	public game(){
		 
		jbtScissor.setBackground(new Color(248,190,247));
		jbtRock.setBackground(Color.WHITE);
		jbtPaper.setBackground(Color.WHITE);
		p3.add(jbtScissor);
		p3.add(jbtRock); 
		p3.add(jbtPaper); 
		//add Refresh on the panel
		pst.add(jbtStart);
		
		//type
		p1.setLayout(new GridLayout(1,2,1,1));
		p2.setLayout(new GridLayout(2,3,1,1));
		p3.setLayout(new GridLayout(1,3,1,1));
		
		
		for(int i = 0; i < pic.length; i++)
			pic[i] = i;
			
		//refresh cards  
		for(int i = 0; i < pic.length; i++){
			int index = (int)(Math.random() * pic.length);
			int temp = pic[i];
			pic[i] = pic[index];
			pic[index] = temp;
 		}
		//store first 4 cards
		pic1 = new JLabel(picx[pic[0]]);
		
		p1.add(pic1);
		
		this.add(p1,BorderLayout.CENTER);
		this.add(p3,BorderLayout.NORTH);
		this.add(pst,BorderLayout.SOUTH);
		
		//click "start" , compare picture 
		jbtStart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
		
			pic1.setIcon(picx[pic[0]]);
			computer = pic[0];
			p2.repaint();
			for(int i = 0; i < pic.length; i++)
				pic[i] = i;
				
			//refresh cards  
			for(int i = 0; i < pic.length; i++){
				int index = (int)(Math.random() * pic.length);
				int temp = pic[i];
				pic[i] = pic[index];
				pic[index] = temp;
	 		}
			//call method
			String a = compile(computer,userinput);
			//message
			JOptionPane.showMessageDialog(null,a,"Result",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		//if user chose Scissor
		jbtScissor.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				p2.repaint();
				jbtScissor.setBackground(new Color(248,190,247));
				jbtRock.setBackground(Color.WHITE);
				jbtPaper.setBackground(Color.WHITE);
				userinput = 0;
				}
		});
		
		//if user chose Rock
		jbtRock.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				jbtRock.setBackground(new Color(248,190,247));
				jbtScissor.setBackground(Color.WHITE);
				jbtPaper.setBackground(Color.WHITE);
				userinput = 1;

			}
		});
		
		//if user chose Paper
		jbtPaper.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				jbtPaper.setBackground(new Color(248,190,247));
				jbtScissor.setBackground(Color.WHITE);
				jbtRock.setBackground(Color.WHITE);
				userinput = 2;

			}
		});
		
	}
		public static void main(String args[]){
			//main method
			JFrame frame = new game();
			frame.setTitle("game");
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(500,400);
			frame.setVisible(true);
		}
		
		//the method to compare computer and user choose
		public String compile(int computer,int userchose){
					
			String[] a = {"scissor","rock","paper"};
				if (computer == userchose)
					return "The computer is " + a[computer] + ". You are " + a[userchose] +". It is a draw";
				else if (computer == userchose + 1 || computer == userchose - 2)  
					return "The computer is " + a[computer] + ". You are " + a[userchose] +". You lost";
				else
					return "The computer is " + a[computer] + ". You are " + a[userchose] +". You won";
		}
}


