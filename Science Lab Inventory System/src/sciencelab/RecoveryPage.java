package sciencelab;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.toedter.calendar.JCalendar;

public class RecoveryPage {
	
	JPanel panel;
	
	public void StartRecovery() {
        JFrame frame = new JFrame("Science Laboratory Inventory System");
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
        label.setForeground(Color.ORANGE);
        label.setFont(new Font("Serif", Font.PLAIN, 36));
        label.setBackground(Color.DARK_GRAY.brighter()); 
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
        

        JPanel innerPanel3 = new JPanel(); 
        innerPanel3.setLayout(new GridBagLayout());
        innerPanel3.setBackground(new Color(64, 64, 64, 0));
        innerPanel3.setPreferredSize(new Dimension(0, 450)); 

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
      
        Font font = new Font("Serif", Font.BOLD, 24);
        JLabel headerMainPage = new JLabel("<html><font color='#CCCCCC'>Cebu Technological University</font><br><font color='black'>Account Recovery</font><br></font></html>");
        headerMainPage.setFont(font);



        headerMainPage.setHorizontalAlignment(SwingConstants.CENTER); // Center the text horizontally

        // GridBagConstraints for POTANGG INA label
        GridBagConstraints gbcHeader = new GridBagConstraints();
        gbcHeader.gridx = 0;  
        gbcHeader.gridy = 0;  
        gbcHeader.gridwidth = 2; 
        gbcHeader.insets = new Insets(-100, 0, 0, 0); 

        innerPanel3.add(headerMainPage, gbcHeader);




        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        
        JLabel itemNameLabel1 = new JLabel("Enter your ID Number");
        itemNameLabel1.setForeground(Color.WHITE);
        innerPanel3.add(itemNameLabel1, gbc);

        gbc.gridx = 1;
        innerPanel3.add(new JTextField(16), gbc);//first input

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel itemNameLabel2 = new JLabel("Enter your Last Name");
        itemNameLabel2.setForeground(Color.WHITE);
        innerPanel3.add(itemNameLabel2, gbc);

        gbc.gridx = 1;
        innerPanel3.add(new JTextField(16), gbc);//second input
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(10, 10, 10, 10);
        
        JLabel itemNameLabel3 = new JLabel("Enter your Birthday");
        itemNameLabel3.setForeground(Color.WHITE);
        innerPanel3.add(itemNameLabel3, gbc);
        JTextField textField = new JTextField(16);
        gbc.gridx = 1;
        innerPanel3.add(textField, gbc);//second input
        
    
        
        textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JDialog calendarDialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(panel), true);
                
            
                calendarDialog.setUndecorated(true);
                calendarDialog.setLocationRelativeTo(textField);

                JCalendar calendar = new JCalendar();
                calendar.addPropertyChangeListener("calendar", evt -> {
                    if (evt.getPropertyName().equals("calendar")) {
                        Date selectedDate = calendar.getDate();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        textField.setText(sdf.format(selectedDate));
                    }
                });

                JPanel otherpanel = new JPanel(new BorderLayout());
                otherpanel.add(calendar, BorderLayout.CENTER);

                JButton okButton = new JButton("OK");
                okButton.addActionListener(e1 -> {
                    calendarDialog.dispose(); // Close the dialog when "OK" button is clicked
                });
                otherpanel.add(okButton, BorderLayout.SOUTH);

                calendarDialog.add(otherpanel);

                calendarDialog.pack();
                calendarDialog.setVisible(true);
            }
        });




        
        
     

        
    
     // GridBagConstraints for Sign In button
        GridBagConstraints gbcSignInButton = new GridBagConstraints();
        gbcSignInButton.gridx = 1;
        gbcSignInButton.gridy = 5;
        gbcSignInButton.gridwidth = 1;
        gbcSignInButton.insets = new Insets(40, 90, 0, 20);

        JButton signUpButton = new JButton("RESET PASSWORD");
        Color skyBlue = new Color(135, 206, 235);
        signUpButton.setBackground(skyBlue.darker());
        signUpButton.setForeground(Color.WHITE); // Set text color to white
        innerPanel3.add(signUpButton, gbcSignInButton);

        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              
                System.out.println("Sign In button clicked");
            }
        });

        

  
     // GridBagConstraints for Sign Up label
        GridBagConstraints gbcSignUpLabel = new GridBagConstraints();
        gbcSignUpLabel.gridx = 1;
        gbcSignUpLabel.gridy = 5;
        gbcSignUpLabel.gridwidth = 1;
        gbcSignUpLabel.insets = new Insets(40, -200, 0, 200);

        JLabel signUpLabel = new JLabel("Back to login page");
        signUpLabel.setForeground(Color.WHITE);
        innerPanel3.add(signUpLabel, gbcSignUpLabel);

        
        GridBagConstraints gbcSignUpLinkLabel = new GridBagConstraints();
        gbcSignUpLinkLabel.gridx = 1;
        gbcSignUpLinkLabel.gridy = 5;
        gbcSignUpLinkLabel.gridwidth = 1;
        gbcSignUpLinkLabel.insets = new Insets(40, -200, 0,  30); 

        JLabel signUpLinkLabel = new JLabel("Click here");
        signUpLinkLabel.setForeground(skyBlue.brighter());
        signUpLinkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signUpLinkLabel.addMouseListener(new MouseAdapter() {
       	 public void mouseClicked(MouseEvent e) {
              
                   System.out.println("Back to Sign in");
                   HomePage homePage = new HomePage();
                   homePage.ShowGUI();
               
                   JFrame CreationPageFrame = (JFrame) SwingUtilities.getWindowAncestor(panel);
                   CreationPageFrame.dispose(); // Close the current frame
               
                   
       		 
       	 }
               
       });

        innerPanel3.add(signUpLinkLabel, gbcSignUpLinkLabel);



        innerPanel2.add(innerPanel3,BorderLayout.SOUTH);
        innerPanel2.add(imageLabel,BorderLayout.NORTH);
        innerPanel.add(innerPanel2,BorderLayout.WEST);
        label.setHorizontalAlignment(SwingConstants.CENTER); 
        panel.add(label, BorderLayout.NORTH);
        panel.add(innerPanel);
        frame.add(panel);
        frame.setVisible(true);
    }
	 public JPanel getPanel() {
	        return panel;
	    }
}
