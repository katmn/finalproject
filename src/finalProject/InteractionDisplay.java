package finalProject;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InteractionDisplay extends JFrame implements ActionListener  {
	// creates a String array list for holding the names of players of have died
	// in the game
	private ArrayList<Characters> graveyard = new ArrayList<Characters>();
	
	
	//	JFrame variables
	private JTextArea messageField = new JTextArea();
	private JButton yesBtn = new JButton("Yes");
	private JButton noBtn = new JButton("No");
	private JButton okBtn = new JButton("OK");
	private JPanel messagePanel = new JPanel(new FlowLayout());
	private JPanel inputPanel = new JPanel(new FlowLayout());
	private JPanel questionPanel = new JPanel(new GridLayout(2, 1));
	private JPanel statementPanel = new JPanel(new GridLayout(2, 1));
	private JPanel mainPanel = new JPanel(new FlowLayout());
	
	//	gameplay interaction
	private Interaction gameplay = new Interaction();
	
	//	listners for buttons	
	private void addListners() {
		yesBtn.addActionListener(this);
		noBtn.addActionListener(this);
		okBtn.addActionListener(this);

	}


		
	public void actionPerformed(ActionEvent e) {
		String callingBtn = e.getActionCommand();

		if (callingBtn.equals("OK")) {
			dispose();

		} else {
			gameplay.setQuestionReady(true);
			gameplay.setAnswer(callingBtn);

		}
	}
	public void InteractionDisplay() {
		addListners();
		ArrayList<String> graveyard = new ArrayList<String>();
		this.setSize(600, 200);
		this.setTitle("Interaction Window");
	}
	
	public void statementPanel(String statement) {
		if (inputPanel != null) {
			inputPanel.removeAll();
		}
		if (messagePanel != null) {
			messagePanel.removeAll();
		}
		gameplay.setQuestionReady(false);
		gameplay.setAnswer(null);
		messageField.setText(gameplay.getStatement());
		messagePanel.add(messageField);
		inputPanel.add(okBtn);
		statementPanel.add(messagePanel);
		statementPanel.add(inputPanel);
		mainPanel.add(statementPanel);
		buildPanel();

	}
	
	public void questionPanel(String question) {
		if (gameplay.isQuestionReady()) {
			gameplay.setQuestionReady(false);
		}
		if (gameplay.getAnswer() != null) {
			gameplay.setAnswer(null);
		}
		if (inputPanel != null) {
			inputPanel.removeAll();
		}
		messageField.setText(gameplay.getQuestion());
		messagePanel.add(messageField);
		inputPanel.add(yesBtn);
		inputPanel.add(noBtn);
		questionPanel.add(messagePanel);
		questionPanel.add(inputPanel);
		mainPanel.add(questionPanel);
		buildPanel();

	}

	private void buildPanel() {
		
		addListners();
		
		setVisible(true);
	}
	
	public boolean nextPlayer(Characters player, ArrayList<Characters> playerList){
		int playerCount = playerList.size();
		int gravyardCount = this.getGraveyard().size();
		
		if(playerCount == 1 && player.equals(this.getWinner())){
			return false;
		} else if (playerCount == gravyardCount){
			return false;
		} else if(this.getWinner() != null && gravyardCount == (playerCount - 1)){
			return false;
		}else {
			return true;
		}
		
	}
	

	/**
	 * @return the graveyard
	 */
	public ArrayList<Characters> getGraveyard() {
		return graveyard;
	}

	/**
	 * @param graveyard
	 *            the graveyard to set
	 */
	public void setGraveyard(ArrayList<Characters> graveyard) {
		this.graveyard = graveyard;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
