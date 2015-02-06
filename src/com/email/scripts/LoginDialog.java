package com.email.scripts;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

/*  Owner			:		Udanka HS 
 * 	Email ID		:		udanka.hs@cognizant.com
 * 	Associate ID	:		266241
 * 	Organization	: 		Cognizant Technology Solutions	
*/

@SuppressWarnings("serial")
public class LoginDialog extends JDialog {

	private JTextField tfUsername;
	private JTextField tfUserEmail;
	private JPasswordField pfPassword;
	
	private JLabel lbUsername;
	private JLabel lbUserEmail;
	private JLabel lbPassword;
	private JButton btnLogin;
	private JButton btnCancel;
	private boolean succeeded;
	public static String CTSUsername;
	public static String CTSPassword;
	public static String CTSUserEmail;

	public LoginDialog(Frame parent) {
		super(parent, "Login", true);
		//
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints cs = new GridBagConstraints();

		cs.fill = GridBagConstraints.HORIZONTAL;

		lbUserEmail = new JLabel("Cognizant Email ID");
		cs.gridx = 0;
		cs.gridy = 0;
		cs.gridwidth = 1;
		panel.add(lbUserEmail, cs);

		tfUserEmail = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
		panel.add(tfUserEmail, cs);

		lbUsername = new JLabel("Cognizant Associate ID");
		cs.gridx = 0;
		cs.gridy = 1;
		cs.gridwidth = 1;
		panel.add(lbUsername, cs);

		tfUsername = new JTextField(20);
		cs.gridx = 1;
		cs.gridy = 1;
		cs.gridwidth = 2;
		panel.add(tfUsername, cs);

		
		lbPassword = new JLabel("Cognizant Password: ");
		cs.gridx = 0;
		cs.gridy = 2;
		cs.gridwidth = 1;
		panel.add(lbPassword, cs);

		pfPassword = new JPasswordField(20);
		cs.gridx = 1;
		cs.gridy = 2;
		cs.gridwidth = 2;
		panel.add(pfPassword, cs);
		panel.setBorder(new LineBorder(Color.GRAY));

		btnLogin = new JButton("Login");

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CTSUsername = getUsername();
				CTSPassword = getPassword();
				CTSUserEmail = getUserEmail();
				succeeded = true;
					dispose();
				} 			
		});
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		JPanel bp = new JPanel();
		bp.add(btnLogin);
		bp.add(btnCancel);

		getContentPane().add(panel, BorderLayout.CENTER);
		getContentPane().add(bp, BorderLayout.PAGE_END);

		pack();
		setResizable(false);
		setLocationRelativeTo(parent);
	}

	public String getUsername() {
		return tfUsername.getText().trim();
	}

	public String getUserEmail() {
		return tfUserEmail.getText().trim();
	}
	
	public String getPassword() {
		return new String(pfPassword.getPassword());
	}

	public boolean isSucceeded() {
		return succeeded;
	}
}