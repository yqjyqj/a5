/* NetId(s): djg17, ret87. Time spent: hh hours, mm minutes. */

package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Game;
import model.GameListener;
import model.NotImplementedException;


public class Main extends JFrame implements MouseListener {
	JPanel p=new JPanel();
	JPanel center = new JPanel();
	JPanel right = new JPanel();
	JPanel down = new JPanel();
	private JLabel label;
	private Container a;

	JLabel player1=new JLabel("Player1");
	JRadioButton human1= new JRadioButton("Human1");
	JRadioButton dumb1= new JRadioButton("Dumb1");
	JRadioButton smart1= new JRadioButton("Smart1");
	JLabel player2=new JLabel("Player2");
	JRadioButton human2= new JRadioButton("Human2");
	JRadioButton dumb2= new JRadioButton("Dumb2");
	JRadioButton smart2= new JRadioButton("Smart2");
	JButton submit=new JButton("Select 2 players and start.");
	public Main(){

		super("Main");

		
		setPreferredSize(new Dimension(300,100));
		center.setLayout(new GridLayout(9,9));
		right.setLayout(new BoxLayout(right, getHeight()));
		down.setLayout(new BoxLayout(down, getWidth()));
		//add squares to left
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				center.add(new Square(i,j));
		//add buttons to right
		
		right.add(player1);
		
		//group as radio buttons
		ButtonGroup group1= new ButtonGroup();
		group1.add(human1);
		human1.addMouseListener(this);
        group1.add(dumb1);
        dumb1.addMouseListener(this);
        group1.add(smart1);
        smart1.addMouseListener(this);
        //add to right
		right.add(human1);
		right.add(dumb1);
		right.add(smart1);
		right.add(submit);
		submit.addMouseListener(this);
		//add buttons to down
		down.add(player2);
		down.add(human2);
		down.add(dumb2);
		down.add(smart2);
		//group as radio buttons
		ButtonGroup group2= new ButtonGroup();
		group2.add(human2);
		human2.addMouseListener(this);
        group2.add(dumb2);
        dumb2.addMouseListener(this);
        group2.add(smart2);
        smart2.addMouseListener(this);
		//layout
		add(center, BorderLayout.CENTER);
		add(right, BorderLayout.EAST);
		add(down, BorderLayout.SOUTH);
		pack();
	}



	public class Square extends JPanel implements MouseListener{
		private final int i, j;
		private boolean selected;
		private boolean colorStatus;

		public Square(int i, int j) {
			this.i = i; this.j = j;
			selected = false;
			colorStatus= false;
			setPreferredSize(new Dimension(10,10));
			addMouseListener(this);
		}

		public void toggle() {
			this.selected = !this.selected;
			repaint();
		}
		public void changeColor(){
			this.colorStatus = !this.colorStatus;
			repaint();
		}

		public @Override void paint(Graphics g) {
			if ((i + j) % 2 == 0)
				g.setColor(Color.GREEN);
			else
				g.setColor(Color.RED);

			g.fillRect(0, 0, getWidth()-1, getHeight()-1);

			g.setColor(Color.BLACK);
			g.drawRect(0, 0, getWidth()-1, getHeight()-1);

			if (selected) {
				g.setColor(Color.PINK);
				g.fillArc(0, 0, getWidth()-1, getHeight()-1, 0, 360);
			}
			if(colorStatus){
				g.setColor(Color.BLACK);
				g.fillArc(0, 0, getWidth()-1, getHeight()-1, 0, 360);
			}

			g.setColor(Color.BLACK);
			g.drawString("(" + i + ", " + j + ")", 20, 20);
		}

		@Override

		public void mouseClicked(MouseEvent e) {
			toggle();
			int row = this.i;
			int col = this.j;
			//g.submitMove(Player, Location(row, col));
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			changeColor();
		}

		@Override
		public void mouseExited(MouseEvent e) {
			changeColor();
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub	throw new NotImplementedException();
		}




	}
	
	public static void main(String[] args) {
		Main main=new Main();

		main.setVisible(true);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// if the button clicked is the "submit" button, start a game with empty board.
		if(e.getSource()==submit) {
			Game g= new Game();
			//prompt whose turn it is
			System.out.println(g.nextTurn());
			right.add(new JLabel("It's"+" "+g.nextTurn()+"'s turn."));
		}
		
		if(human1.isSelected() && human2.isSelected()){
			
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void gameChanged(Game g) {
//		
//		clear();
//		System.out.println("Current Board:");
//		printBoard(g.getBoard());
//		System.out.println();
//		switch(g.getBoard().getState()) {
//		case HAS_WINNER:
//			System.out.println(g.getBoard().getWinner().winner + " wins!");
//			break;
//		case DRAW:
//			System.out.println("Game ended in a draw!");
//			break;
//		case NOT_OVER:
//			System.out.println("It is " + g.nextTurn() + "'s turn");
//			break;
//		}
//	}
}
