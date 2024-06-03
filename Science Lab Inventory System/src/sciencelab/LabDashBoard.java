package sciencelab;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class LabDashBoard {
    
    public static int userIndex;
    InventoryPage inventoryPage = new InventoryPage();
    UserInformation userInformation = new UserInformation();
    JLabel userWelcome = new JLabel();
    JLabel userHistory = new JLabel();
    JLabel userLiveTime = new JLabel();
     HomePage homePage = new HomePage();
    
     public void StartDashBoard() {
    	    JFrame frame = new JFrame("Science Laboratory Inventory System");
    	    
    	    JPanel panel = new JPanel();
    	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	    frame.setSize(1300, 800);
    	    frame.setLocationRelativeTo(null);
    	    
    	    panel.setLayout(new BorderLayout());
    	    
    	    JLabel label = new JLabel("SCIENCE LABORATORY INVENTORY SYSTEM");
    	    label.setBorder(BorderFactory.createEmptyBorder(10, 200, 0, 60)); // Add border
    	    label.setForeground(Color.black.brighter());
    	    label.setFont(new Font("Serif", Font.BOLD, 36));
    	    label.setBackground(Color.orange.darker());
    	    label.setOpaque(true); 
    	    
    	    JButton logout = new JButton("LOGOUT");
    	    Font buttonFont = new Font("Roboto", Font.BOLD, 18);
    	    logout.setForeground(Color.black.brighter());
    	    logout.setFont(buttonFont);
    	    logout.setBackground(Color.orange);
    	    
    	    logout.addActionListener(new ActionListener() {
    	        public void actionPerformed(ActionEvent e) {
    	            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(panel);
    	            UserInformation.firstTimeLogin = false;
    	            homePage.ShowGUI();
    	            topFrame.dispose();
    	        }
    	    });
    	    
    	    JPanel titlePanel = new JPanel(new BorderLayout());
    	    titlePanel.setBackground(label.getBackground());
    	    titlePanel.add(logout, BorderLayout.EAST);
    	    titlePanel.add(label, BorderLayout.CENTER);

    	    ImageIcon imageIcon = new ImageIcon("xctug.jpg");
    	    Image image = imageIcon.getImage();
    	    Image scaledImage = image.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
    	    ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
    	    JPanel innerPanel = new JPanel() {
    	        @Override
    	        protected void paintComponent(Graphics g) {
    	            super.paintComponent(g);
    	            g.drawImage(scaledImageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
    	        }
    	    };
    	    
    	    innerPanel.setLayout(new BorderLayout());

    	    Timer timer = new Timer(1000, new ActionListener() {
    	        @Override
    	        public void actionPerformed(ActionEvent e) {
    	            updateTimeLabel(userLiveTime);
    	        }
    	    });
    	    timer.start();
    	    
    	    Font robotoFont = new Font("Serif", Font.BOLD, 20);    
    	    
    	    userWelcome.setBorder(BorderFactory.createEmptyBorder(100, 20, 0, 0)); // Add border 
    	    userWelcome.setFont(robotoFont);
    	    userWelcome.setForeground(Color.WHITE.brighter().brighter().brighter());
    	    
    	    userHistory.setBorder(BorderFactory.createEmptyBorder(100, 50, 0, 0)); // Add border 
    	    userHistory.setFont(robotoFont);
    	    userHistory.setForeground(Color.WHITE.brighter().brighter().brighter());

    	    userLiveTime.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0)); // Add border 
    	    userLiveTime.setFont(robotoFont);
    	    userLiveTime.setOpaque(true); 
    	    userLiveTime.setPreferredSize(new Dimension(100, 100));
    	    userLiveTime.setBackground(Color.orange.darker());
    	    
    	    JButton proceed = new JButton("Proceed To Laboratory");
    	    proceed.setForeground(Color.black.brighter());
    	    proceed.setFont(buttonFont);
    	    proceed.setBackground(Color.orange);
    	    
    	    proceed.addActionListener(new ActionListener() {
    	        public void actionPerformed(ActionEvent e) {
    	            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(panel);
    	            inventoryPage.StartInventoryPage();
    	            inventoryPage.getUserIndex(userIndex);
    	            topFrame.dispose();
    	        }
    	    });

    	    JPanel contentPane = new JPanel(new GridBagLayout());
    	    GridBagConstraints gbc = new GridBagConstraints();
    	    contentPane.setBackground(new Color(64, 64, 64, 0)); 
    	    gbc.insets = new Insets(10, 10, 10, 10); 

    	    contentPane.add(proceed, gbc);

    	    JPanel userDetails = new JPanel();
    	    userDetails.setLayout(new BorderLayout());
    	    userDetails.setBackground(new Color(64, 64, 64, 128).darker().darker().darker());
    	    userDetails.setPreferredSize(new Dimension(400, 200)); 

    	    JPanel userBorrowHistory = new JPanel();
    	    userBorrowHistory.setLayout(new BorderLayout());
    	    userBorrowHistory.setBackground(new Color(64, 64, 64, 128).darker().darker().darker()); 
    	    userBorrowHistory.setPreferredSize(new Dimension(400, 200)); 

    	    userDetails.add(userWelcome, BorderLayout.NORTH);
    	    userDetails.add(userLiveTime, BorderLayout.SOUTH);
    	    userBorrowHistory.add(userHistory, BorderLayout.NORTH);

    	    innerPanel.add(userDetails, BorderLayout.WEST);
    	    innerPanel.add(userBorrowHistory, BorderLayout.EAST);
    	    innerPanel.add(contentPane, BorderLayout.CENTER);
    	    
    	    panel.add(titlePanel, BorderLayout.NORTH);
    	    panel.add(innerPanel);
    	    frame.add(panel);
    	    frame.setVisible(true);
    	}

    	private static void updateTimeLabel(JLabel label) {
    	    SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM dd, yyyy - h:mm:ss a");
    	    String formattedDateTime = dateFormat.format(new Date());
    	    label.setText(formattedDateTime);
    	    label.setForeground(Color.black.darker().darker());
    	}

    	public void getUserIndex(int index) {
    	    this.userIndex = index;
    	}

}
