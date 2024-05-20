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
        label.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 60)); // Add border
        label.setForeground(Color.black.brighter());
        label.setFont(new Font("Showcard Gothic", Font.BOLD, 36));
        label.setBackground(Color.orange.darker()); 
        label.setOpaque(true); 
        
        
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
        Font buttonFont = new Font("Roboto", Font.BOLD, 18);
        proceed.setForeground(Color.black.brighter());
        proceed.setFont(buttonFont);
        
        JButton logout = new JButton("Back");
      
        logout.setForeground(Color.black.brighter());
        logout.setFont(buttonFont);
        
        
        logout.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(panel);
                homePage.ShowGUI();
                topFrame.dispose();
            }
        });
 
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
        gbc.gridy = 0; // Row 0

        contentPane.add(proceed, gbc);
        gbc.gridy = 1; // Row 0

        contentPane.add(logout,gbc);
       
        JPanel userDetails = new JPanel();
        userDetails.setLayout(new BorderLayout());
        userDetails.setBackground(new Color(64, 64, 64, 128).darker().darker().darker());
        userDetails.setPreferredSize(new Dimension(400, 200)); 

        JPanel userBorrowHistory = new JPanel();
        userBorrowHistory.setLayout(new BorderLayout());
        userBorrowHistory.setBackground(new Color(64, 64, 64, 128).darker().darker().darker()); 
        userBorrowHistory.setPreferredSize(new Dimension(400, 200)); 

        userDetails.add(userWelcome, BorderLayout.NORTH);
        userDetails.add(userLiveTime,BorderLayout.SOUTH);
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
    
   
    

    private static void updateTimeLabel(JLabel label) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM dd, yyyy - h:mm:ss a");
        String formattedDateTime = dateFormat.format(new Date());
        label.setText(formattedDateTime);
        label.setForeground(Color.black.darker().darker());
    }


    public void getUserIndex(int index ) {
        this.userIndex=index;
    }
}
