package finalProject;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ProtectCloseGUI extends JFrame implements ActionListener {
	private JButton yesBtn = new JButton("Yes");
	private JButton noBtn = new JButton("No");
	private JLabel msgLbl = new JLabel("Are you sure?");
	
	private ImageIcon yesIcon = new ImageIcon("yes.png");
	private ImageIcon noIcon = new ImageIcon("no.png");
	
	public ProtectCloseGUI() {
		super();
		setSize(200, 200);
		setLayout(new BorderLayout());
		
		add(msgLbl, BorderLayout.NORTH);
		add(yesBtn, BorderLayout.WEST);
		add(noBtn, BorderLayout.EAST);
		
		yesBtn.setMargin(new Insets(10,10,10,10));
		
		addIcons();
		addListeners();
	}

	private void addIcons() {
		yesBtn.setIcon(yesIcon);
		noBtn.setIcon(noIcon);
	}

	private void addListeners() {
		yesBtn.addActionListener(this);
		noBtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String callingBtn = e.getActionCommand();
		
		if (callingBtn.equals("Yes")) {
			System.exit(1);
		}
		else if (callingBtn.equals("No")) {
			this.dispose();
		}
	}
}
