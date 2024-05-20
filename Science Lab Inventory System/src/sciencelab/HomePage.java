package sciencelab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePage {
	
	static JPanel panel ;
	UserInformation userInformation = new UserInformation();
	
	  
	
	
	
	public void ShowGUI() {
        JFrame frame = new JFrame("Science Laboratory Inventory System");
      //  frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1300, 800);
        frame.setLocationRelativeTo(null);

        ImageIcon imageIcon = new ImageIcon("sciencelab7.jpg");
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

         panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(scaledImageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        }; 
        
        panel.setLayout(new BorderLayout());
     
       
        

        JLabel label = new JLabel("SCIENCE LABORATORY INVENTORY SYSTEM");
        label.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 60)); // Add border
        label.setForeground(Color.black.brighter());
        label.setFont(new Font("Serif", Font.BOLD, 36));
        label.setBackground(Color.orange.darker()); 
        label.setOpaque(true); 

        JPanel innerPanel = new JPanel();  
        innerPanel.setLayout(new BorderLayout());
        innerPanel.setBackground(new Color(64, 64, 64, 128).darker()); 

        JPanel innerPanel2 = new JPanel(); 
        innerPanel2.setLayout(new BorderLayout());
        innerPanel2.setBackground(new Color(64, 64, 64, 128));
        innerPanel2.setPreferredSize(new Dimension(500, 200)); 

        ImageIcon icon = new ImageIcon("CTU.png"); 
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0)); // Add border
        
        JPanel innerPanel3 = new JPanel(); 
        innerPanel3.setLayout(new GridBagLayout());
        innerPanel3.setBackground(new Color(64, 64, 64, 0));
        innerPanel3.setPreferredSize(new Dimension(0, 450)); 

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
      
        Font font = new Font("Serif", Font.BOLD, 24);
        JLabel headerMainPage = new JLabel("<html><font color='#CCCCCC'>Sign in<br>Cebu Technological University</font></html>");

        headerMainPage.setFont(font);



        headerMainPage.setHorizontalAlignment(SwingConstants.CENTER); 

       
        GridBagConstraints gbcHeader = new GridBagConstraints();
        gbcHeader.gridx = 0;  
        gbcHeader.gridy = 0;  
        gbcHeader.gridwidth = 2; 
        gbcHeader.insets = new Insets(-200, 0, 0, 0); 

        innerPanel3.add(headerMainPage, gbcHeader);




        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        
        JLabel itemNameLabel1 = new JLabel("Email Address");
        itemNameLabel1.setForeground(Color.WHITE);
        innerPanel3.add(itemNameLabel1, gbc);

        gbc.gridx = 1;
        
        JTextField textFieldEmail = new JTextField(16); 
        innerPanel3.add(textFieldEmail, gbc);//second input

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel itemNameLabel2 = new JLabel("Password");
        itemNameLabel2.setForeground(Color.WHITE);
        innerPanel3.add(itemNameLabel2, gbc);

        
        gbc.gridx = 1;
        JTextField textFieldPassword = new JTextField(16); 
        innerPanel3.add(textFieldPassword, gbc);//second input
        
        
    
  
        GridBagConstraints gbcSignInButton = new GridBagConstraints();
        gbcSignInButton.gridx = 1;
        gbcSignInButton.gridy = 5;
        gbcSignInButton.gridwidth = 1;
        gbcSignInButton.insets = new Insets(40, 90, 0, 0);

        JButton signInButton = new JButton("SIGN IN");
        Color skyBlue = new Color(135, 206, 235);
        signInButton.setBackground(skyBlue.darker());
        signInButton.setForeground(Color.WHITE);
        innerPanel3.add(signInButton, gbcSignInButton);

        signInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
             
                String inputtedEmail = textFieldEmail.getText();
                String inputtedPassword = textFieldPassword.getText();
                userInformation.loadFromJson();
                userInformation.loginAccount(inputtedEmail,inputtedPassword,panel);
            }
        });

        

        GridBagConstraints gbcForgotPasswordLabel = new GridBagConstraints();
        gbcForgotPasswordLabel.gridx = 1;
        gbcForgotPasswordLabel.gridy = 4;
        gbcForgotPasswordLabel.gridwidth = 1;
        gbcForgotPasswordLabel.insets = new Insets(0, 60 ,0, 0);

        JLabel forgotPasswordLabel = new JLabel("<html>Forgot Password?</html>");
        skyBlue = new Color(135, 206, 235); 
        forgotPasswordLabel.setForeground(skyBlue.brighter()); 
        innerPanel3.add(forgotPasswordLabel, gbcForgotPasswordLabel);

        forgotPasswordLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        forgotPasswordLabel.addMouseListener(new MouseAdapter() {
        	 public void mouseClicked(MouseEvent e) {
               
               
                    RecoveryPage recoveryPage = new RecoveryPage();
                    recoveryPage.StartRecovery();            
                    JFrame loginHomePage = (JFrame) SwingUtilities.getWindowAncestor(panel);
                    loginHomePage.dispose(); 
                    
        		 
        	 }
                
        });
  
    
        GridBagConstraints gbcSignUpLabel = new GridBagConstraints();
        gbcSignUpLabel.gridx = 1;
        gbcSignUpLabel.gridy = 5;
        gbcSignUpLabel.gridwidth = 1;
        gbcSignUpLabel.insets = new Insets(40, -200, 0, 100);

        JLabel signUpLabel = new JLabel("Don't have an account?");
        signUpLabel.setForeground(Color.WHITE);
        innerPanel3.add(signUpLabel, gbcSignUpLabel);

        
        GridBagConstraints gbcSignUpLinkLabel = new GridBagConstraints();
        gbcSignUpLinkLabel.gridx = 1;
        gbcSignUpLinkLabel.gridy = 5;
        gbcSignUpLinkLabel.gridwidth = 1;
        gbcSignUpLinkLabel.insets = new Insets(40, -200, 0, -110); 

        JLabel signUpLinkLabel = new JLabel("Sign up Here");
        signUpLinkLabel.setForeground(skyBlue.brighter());
        signUpLinkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signUpLinkLabel.addMouseListener(new MouseAdapter() {
       	 public void mouseClicked(MouseEvent e) {
              
            
                   CreationPage creationPage = new CreationPage();
                   creationPage.createAndShowGUI();
                   JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(panel);
                   topFrame.dispose(); // Close the current frame
                  
               
               
             
                   
                   
       		 
       	 }

		
               
       });
        
    
        JButton aboutUsButton = new JButton("About Us");
        aboutUsButton.setPreferredSize(new Dimension(100, 40));
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));      
        buttonPanel.add(aboutUsButton);
        
        buttonPanel.setBackground(new Color(64, 64, 64, 0)); 


        aboutUsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
         
            	JPanel panel = new JPanel(new BorderLayout());
                 panel.setBackground(Color.BLACK.darker()); 
                 panel.setOpaque(true);
            	
            	JPanel imagePanel = new JPanel(new GridLayout(1, 2)); 
            	
            	ImageIcon icon2 = new ImageIcon("angs.png");
            	Image image2 = icon2.getImage();
         
            	int width = 200; 
            	int height = 200; 
            	Image resizedImage2 = image2.getScaledInstance(250, height, Image.SCALE_SMOOTH);
            	ImageIcon resizedIcon2 = new ImageIcon(resizedImage2);
            	JLabel imageLabel2 = new JLabel(resizedIcon2);
            	imagePanel.add(imageLabel2); 
            	panel.add(imagePanel, BorderLayout.CENTER); 
            	imagePanel.setBackground(new Color(64, 64, 64, 123)); 
            	
            	ImageIcon icon = new ImageIcon("clark.jpg");
            	Image image = icon.getImage();
         
            	 
            	Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            	ImageIcon resizedIcon = new ImageIcon(resizedImage);
            	JLabel imageLabel = new JLabel(resizedIcon);
            	imagePanel.add(imageLabel); 
            	panel.add(imagePanel, BorderLayout.CENTER); 
            	imagePanel.setBackground(new Color(64, 64, 64, 123)); 

            	
            	JPanel textPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
            	textPanel.add(new JLabel("<html><b><font color='#FFFFFF'>ANGILBERT ANGCON</font></b><br><center><font color='#00FF00'>PROGRAMMER</font></center></html>"));
            	textPanel.add(new JLabel("                                                  "));
            	textPanel.add(new JLabel("<html><b><font color='#FFFFFF'>KENT IBALE</font></b><br><center><font color='#00FF00'>DESIGNER</font></center></html>"));

            	
            	panel.add(textPanel, BorderLayout.SOUTH); 
            	textPanel.setBackground(new Color(64, 64, 64, 123));

       
            	JOptionPane.showMessageDialog(
            	    frame,
            	    panel,
            	    "About Us",
            	    JOptionPane.PLAIN_MESSAGE
            	);




                    

            

            }
        });

    
    
        
        JPanel panelForDesign = new JPanel(new BorderLayout());
        panelForDesign.setBackground(new Color(64, 64, 64, 0)); 
        panelForDesign.setOpaque(true);
        panelForDesign.setPreferredSize(new Dimension(700, 0));
        

        innerPanel3.add(signUpLinkLabel, gbcSignUpLinkLabel);
        
        ImageIcon iconLogo = new ImageIcon("BagongMukha.png"); 
        JLabel imageLabelLogo = new JLabel(iconLogo);
        imageLabelLogo.setBorder(BorderFactory.createEmptyBorder(-30, 0, 450, 60)); 
        
        
        
      panelForDesign.add( buttonPanel,BorderLayout.SOUTH);
      
      
        panelForDesign.add(imageLabelLogo,BorderLayout.NORTH);
        innerPanel.add(panelForDesign,BorderLayout.EAST);



        innerPanel2.add(innerPanel3,BorderLayout.SOUTH);
        innerPanel2.add(imageLabel,BorderLayout.NORTH);
        innerPanel.add(innerPanel2,BorderLayout.WEST);
        label.setHorizontalAlignment(SwingConstants.CENTER); 
        panel.add(label, BorderLayout.NORTH);
        panel.add(innerPanel);
        frame.add(panel);
        frame.setVisible(true);
        
        
    }
	
	
	  
	
}