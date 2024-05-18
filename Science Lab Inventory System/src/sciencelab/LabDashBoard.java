package sciencelab;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class LabDashBoard {
    
	public static int userIndex;
	InventoryPage inventoryPage = new InventoryPage();
	UserInformation userInformation = new UserInformation();
	JLabel  userWelcome = new JLabel();
	JLabel userHistory = new JLabel();
	HomePage homePage = new HomePage();
	
	//white buttons
	//text black 
	// [0,102,102] background 
	//showcard gothic font title
	
	
	public void StartDashBoard() {
		
		JFrame frame = new JFrame("Science Laboratory Inventory System");
		 JPanel panel = new JPanel();
		 panel.setBackground(new Color(0, 102, 102));

	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(1300, 800);
	        frame.setLocationRelativeTo(null);
	        
	        panel.setLayout(new BorderLayout());
	        JLabel label = new JLabel("SCIENCE LABORATORY INVENTORY SYSTEM");
	        label.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 60)); // Add border
	        label.setForeground(Color.black.brighter());
	        label.setFont(new Font("Showcard Gothic", Font.BOLD, 36));
	        label.setBackground(Color.orange.darker()); 
	        label.setOpaque(true); 
	        JPanel innerPanel = new JPanel();  
	        innerPanel.setLayout(new BorderLayout());       
	        innerPanel.setBackground(Color.black); 
	        
	        
	  
	        Font robotoFont = new Font("Serif", Font.BOLD, 20);	 
	       
	        userWelcome.setBorder(BorderFactory.createEmptyBorder(100, 20, 0, 0)); // Add border 
	        userWelcome.setFont(robotoFont);
	        userWelcome.setForeground(Color.WHITE.brighter().brighter().brighter());
	        
	        
	        userHistory.setBorder(BorderFactory.createEmptyBorder(100, 50, 0, 0)); // Add border 
	        userHistory.setFont(robotoFont);
	        userHistory.setForeground(Color.WHITE.brighter().brighter().brighter());

	        
	        

	        
	        
	        JButton proceed = new JButton("Proceed To Laboratory");
	        Font buttonFont = new Font("Roboto", Font.BOLD, 18);
	        proceed.setFont(buttonFont);
	 
	        proceed.addActionListener(new ActionListener() {
	            
	            public void actionPerformed(ActionEvent e) {
	         
	                System.out.println("Button clicked: Proceed To Laboratory");
	                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(panel);
	                   topFrame.dispose(); // Close the current frame
	                   inventoryPage.StartInventoryPage();
	                   inventoryPage.getUserIndex(userIndex);
	            }
	        });
	        
	        


	     
	        JPanel contentPane = new JPanel(new GridBagLayout());
	        GridBagConstraints gbc = new GridBagConstraints();
	        contentPane.setBackground(new Color(64, 64, 64, 0)); // transpar
	        gbc.insets = new Insets(-250, 10, 10, 10); // Padding
	       
	        
	
	       contentPane.add(proceed, gbc);
	  
	       
	       
	       
	       JPanel userDetails = new JPanel();
	       userDetails.setLayout(new BorderLayout());
	       userDetails.setBackground(new Color(64, 64, 64, 0)); // transpar
	       userDetails.setPreferredSize(new Dimension(400, 200)); // Set the size of userDetails

	       JPanel userBorrowHistory = new JPanel();
	       userBorrowHistory.setLayout(new BorderLayout());
	       userBorrowHistory.setBackground(new Color(64, 64, 64, 0)); // transpar
	       userBorrowHistory.setPreferredSize(new Dimension(400, 200)); // Set the size of userBorrowHistory

	       
	       userDetails.add(userWelcome, BorderLayout.NORTH);
	       userBorrowHistory.add(userHistory, BorderLayout.NORTH);
	       
	       innerPanel.add(userDetails, BorderLayout.WEST);
	       innerPanel.add(userBorrowHistory, BorderLayout.EAST);

	      
	       innerPanel.add(contentPane, BorderLayout.CENTER);

	       label.setHorizontalAlignment(SwingConstants.CENTER);

	        panel.add(label, BorderLayout.NORTH);
	        panel.add(innerPanel);
	        frame.add(panel);
	        frame.setVisible(true);
	}
	
	
	public void getUserIndex(int index ) {
		this.userIndex=index;
		System.out.println(userIndex);
	}
	

}