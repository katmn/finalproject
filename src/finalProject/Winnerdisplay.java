package finalProject;

	import javax.swing.*;
	import java.awt.*;
	import javax.swing.*;
	import java.awt.GridLayout;
	import java.awt.FlowLayout;
	import java.awt.BorderLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.util.ArrayList;
	/**
	 * Created by Kalavathi on 4/30/2017.
	 */
	public class Winnerdisplay extends JFrame implements ActionListener {

	    private static final  int W = 650;
	    private static final int H = 650;
	    
	    Characters winner;
	    private ArrayList<Characters>  gryPlayerArraylist = new ArrayList<Characters>();
	    private boolean gravyardFull = false;

	    private JLabel titleLbl = new JLabel("\t\t Winner!   Player!");
	    private JLabel nameLbl = new JLabel("\tName: ");
	    private JLabel healthLbl = new JLabel("Health");
	    private JLabel strgLbl = new JLabel("Strength");
	    private JLabel dextLbl = new JLabel("Dexterity");
	    private JLabel speedLbl = new JLabel("Speed");

//	    private JLabel giveSpaceLbl2 = new JLabel("  ");
//	    private JLabel nameLbl2 = new JLabel("\tName: ");
//	    private JLabel healthLbl2 = new JLabel("Health");
//	    private JLabel strgLbl2 = new JLabel("Strength");
//	    private JLabel dextLbl2 = new JLabel("Dexterity");
//	    private JLabel speedLbl2 = new JLabel("Speed");

//	    private JLabel giveSpaceLbl3 = new JLabel("  ");
//	    private JLabel nameLbl3 = new JLabel("Name: ", SwingConstants.RIGHT);
//	    private JLabel healthLbl3 = new JLabel("Health", SwingConstants.RIGHT);
//	    private JLabel strgLbl3 = new JLabel("Strength", SwingConstants.RIGHT);
//	    private JLabel dextLbl3 = new JLabel("Dexterity", SwingConstants.RIGHT);
//	    private JLabel speedLbl3 = new JLabel("Speed", SwingConstants.RIGHT);
//
//	    private JLabel giveSpaceLbl4 = new JLabel("  ");
//	    private JLabel nameLbl4 = new JLabel("Name: ", SwingConstants.RIGHT);
//	    private JLabel healthLbl4 = new JLabel("Health", SwingConstants.RIGHT);
//	    private JLabel strgLbl4 = new JLabel("Strength", SwingConstants.RIGHT);
//	    private JLabel dextLbl4 = new JLabel("Dexterity", SwingConstants.RIGHT);
//	    private JLabel speedLbl4 = new JLabel("Speed", SwingConstants.RIGHT);

	    private JLabel gameLgtLbl = new JLabel("\t\t Game Length # is:   ", SwingConstants.RIGHT);

//	    private JLabel Player2Lbl = new JLabel("Player 2");
//	    private JLabel player3Lbl = new JLabel("Player 3");
//	    private JLabel player4Lbl = new JLabel("Player 4");
//
//	    private JLabel grvyTitleLbl = new JLabel("\t\t\t\t Graveyard");

	    private JTextField nameTxtField = new JTextField(20);
	    private JTextField healthTxtField = new JTextField(5);
	    private JTextField strgTxtField = new JTextField(5);
	    private JTextField dextTxtField = new JTextField(5);
	    private JTextField speedTxtField = new JTextField(5);

//	    private JTextField name2TxtField = new JTextField(20);
//	    private JTextField health2TxtField = new JTextField(5);
//	    private JTextField strgTxt2Field = new JTextField(5);
//	    private JTextField dextTxt2Field = new JTextField(5);
//	    private JTextField speedTxt2Field = new JTextField(5);
//
//	    private JTextField name3TxtField = new JTextField(20);
//	    private JTextField health3TxtField = new JTextField(5);
//	    private JTextField strg3TxtField = new JTextField(5);
//	    private JTextField dext3TxtField = new JTextField(5);
//	    private JTextField speed3TxtField = new JTextField(5);

//	    private JTextField name4TxtField = new JTextField(20);
//	    private JTextField health4TxtField = new JTextField(5);
//	    private JTextField strg4TxtField = new JTextField(5);
//	    private JTextField dext4TxtField = new JTextField(5);
//	    private JTextField speed4TxtField = new JTextField(5);

	    private JTextField gameLgtTxtField = new JTextField(4);

	    private JPanel winnerTitlePanel = new JPanel(new FlowLayout());
	    private JPanel winnerPanel = new JPanel(new GridLayout(5, 6));
	    private JPanel gameLenghtPanel = new JPanel(new FlowLayout());

//	    private JPanel gravyTitlePanel= new JPanel(new FlowLayout());
//
//	    private JPanel gravyPlayersPanel = new JPanel(new FlowLayout());
//
//	    private JPanel gravyPlayersPanel3 = new JPanel(new GridLayout(6, 2));
//	    private JPanel gravyPlayersPanel2 = new JPanel(new GridLayout(6, 2));
//	    private JPanel gravyPlayersPanel4 = new JPanel(new GridLayout(6, 2));

	    private JPanel topPanel = new JPanel(new BorderLayout());
	    //private JPanel bottomPanel = new JPanel(new BorderLayout());
	    //private JPanel bottomPanel = new JPanel(new GridLayout(3, 1));
	    // private JPanel bottomPanel = new JPanel(new FlowLayout());
	    public Winnerdisplay(String title){
	        super(title);
	        this.setSize(W,H);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setLayout(new GridLayout(2, 1));

	        buildPanels();
	        addPanelsToFrame();
	        addListeners();

	    }//constructor winner display
		
	  

	    public  void buildPanels(){
	    	GameGUI pullWinner = new GameGUI("New GUI");
						
	        Font font1 = new Font("Calibri", Font.BOLD, 24);
	        titleLbl.setFont(font1);
	        titleLbl.setForeground(Color.blue);
	        winnerTitlePanel.add(titleLbl);
	        winnerPanel.setBackground(Color.yellow);
	        	        
	        winnerPanel.add(nameLbl);
	        nameTxtField.setText(pullWinner.getWinner().getName());
	        winnerPanel.add(nameTxtField);
	        winnerPanel.add(healthLbl);
	        healthTxtField.setText(pullWinner.getWinner().getHealth() + (""));
	        winnerPanel.add(healthTxtField);
	        winnerPanel.add(strgLbl);
	        strgTxtField.setText(pullWinner.getWinner().getStrength() + (" "));
	        winnerPanel.add(strgTxtField);
	        winnerPanel.add(dextLbl);
	        dextTxtField.setText(pullWinner.getWinner().getDexterity() + (""));
	        winnerPanel.add(dextTxtField);
	        winnerPanel.add(speedLbl);
	        speedTxtField.setText(pullWinner.getWinner().getSpeed() + (""));
	        winnerPanel.add(speedTxtField);

	        Font font2 = new Font("Calibri", Font.BOLD, 25);
	        gameLgtLbl.setFont(font2);
	        gameLgtLbl.setForeground(Color.pink);
	        gameLenghtPanel.setBackground(Color.BLACK);
	        gameLenghtPanel.add(gameLgtLbl);
	        gameLenghtPanel.add(gameLgtTxtField );

//	        Font font3 = new Font("Calibri", Font.BOLD, 25);
//	        grvyTitleLbl.setFont(font3);
//	        grvyTitleLbl.setForeground(Color.MAGENTA);
//	        gravyTitlePanel.add(grvyTitleLbl);
//
//	        gravyPlayersPanel2.setBackground(Color.CYAN);
//	        gravyPlayersPanel2.add(giveSpaceLbl2);
//	        gravyPlayersPanel2.add(Player2Lbl);
//	        gravyPlayersPanel2.add(nameLbl2);
//	        if (pullWinner.getGraveyard() != null){
//	        	int count = 1;
//	        	for (Characters plyr: pullWinner.getGraveyard()){
//	        	
//	        			name2TxtField.setText(pullWinner.getWinner().getName());
//	    	        	health2TxtField.setText(pullWinner.getWinner().getHealth());
//	    	        	strgTxt2Field.setText(pullWinner.getWinner().getName());
//	    	        	dextTxt2Field.setText(pullWinner.getWinner().getName());
//	    	        	speedTxt2Field.setText(pullWinner.getWinner().getName());
//	        		}
//	        	}
//	        	
//	        
//	        }
//	        
//	        gravyPlayersPanel2.add(name2TxtField);
//	        gravyPlayersPanel2.add(healthLbl2);
//	        gravyPlayersPanel2.add(health2TxtField);
//	        gravyPlayersPanel2.add(strgLbl2);
//	        gravyPlayersPanel2.add(strgTxt2Field);
//	        gravyPlayersPanel2.add(dextLbl2);
//	        gravyPlayersPanel2.add(dextTxt2Field);
//	        gravyPlayersPanel2.add(speedLbl2);
//	        gravyPlayersPanel2.add(speedTxt2Field);
//
//	        gravyPlayersPanel3.setBackground(Color.CYAN);
//	        gravyPlayersPanel3.add(giveSpaceLbl3);
//	        gravyPlayersPanel3.add(player3Lbl);
//	        gravyPlayersPanel3.add(nameLbl3);
//	        gravyPlayersPanel3.add(name3TxtField);
//	        gravyPlayersPanel3.add(healthLbl3);
//	        gravyPlayersPanel3.add(health3TxtField);
//	        gravyPlayersPanel3.add(strgLbl3);
//	        gravyPlayersPanel3.add(strg3TxtField);
//	        gravyPlayersPanel3.add(dextLbl3);
//	        gravyPlayersPanel3.add(dext3TxtField);
//	        gravyPlayersPanel3.add(speedLbl3);
//	        gravyPlayersPanel3.add(speed3TxtField);

//	        gravyPlayersPanel4.setBackground(Color.CYAN);
//	        gravyPlayersPanel4.add(giveSpaceLbl4);
//	        gravyPlayersPanel4.add(player4Lbl);
//	        gravyPlayersPanel4.add(nameLbl4);
//	        gravyPlayersPanel4.add(name4TxtField);
//	        gravyPlayersPanel4.add(healthLbl4);
//	        gravyPlayersPanel4.add(health4TxtField);
//	        gravyPlayersPanel4.add(strgLbl4);
//	        gravyPlayersPanel4.add(strg4TxtField);
//	        gravyPlayersPanel4.add(dextLbl4);
//	        gravyPlayersPanel4.add(dext4TxtField);
//	        gravyPlayersPanel4.add(speedLbl4);
//	        gravyPlayersPanel4.add(speed4TxtField);
	        
	        
	        topPanel.setForeground(Color.DARK_GRAY);
	        //bottomPanel.setBackground(Color.yellow);
	        topPanel.add(winnerTitlePanel, BorderLayout.NORTH);
	        topPanel.add(winnerPanel, BorderLayout.WEST);
	        topPanel.add(gameLenghtPanel, BorderLayout.CENTER);
	    }
//	        topPanel.add(gravyTitlePanel, BorderLayout.SOUTH);
//
//	        bottomPanel.add(gravyPlayersPanel2, BorderLayout.WEST);
//	        bottomPanel.add(gravyPlayersPanel3, BorderLayout.CENTER);
//	        bottomPanel.add(gravyPlayersPanel4, BorderLayout.EAST);
//	    }

	    public void addPanelsToFrame(){
	        this.add(topPanel);
	       // this.add(bottomPanel);
	    }
	    public void addListeners(){

	    }
	    public void actionPerformed(ActionEvent event){

	    }
	    public static void main(String[] args){
	        Winnerdisplay gui = new Winnerdisplay("Adventure Game - Winner");
	        gui.setVisible(true);
	    }


	//Windows display class

	

}
