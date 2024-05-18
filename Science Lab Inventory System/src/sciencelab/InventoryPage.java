package sciencelab;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.*;




public class InventoryPage {
	
	public static int userIndex;
	static LabDashBoard labDashBoard = new LabDashBoard();
	ScienceLabItems scienceLabItems = new ScienceLabItems();
	UserInformation userInformation = new UserInformation();

    public void StartInventoryPage() {
        JFrame frame = new JFrame("Science Laboratory Inventory System");
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 102, 102));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1300, 800);
        frame.setLocationRelativeTo(null);
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("SCIENCE LABORATORY INVENTORY SYSTEM");
        label.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 60));
        label.setForeground(Color.black.brighter());
        label.setFont(new Font("Showcard Gothic", Font.BOLD, 36));
        label.setBackground(Color.orange.darker());
        label.setOpaque(true);
        label.setHorizontalAlignment(SwingConstants.CENTER);


     // Create the button
        JButton button = new JButton("GET ITEMS");

     // Add ActionListener to the button
     button.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             
        	 JOptionPane.showMessageDialog(null, "You have successfully acquired the items", " ", JOptionPane.INFORMATION_MESSAGE);
        	JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(panel);
             topFrame.dispose(); 
             labDashBoard.getUserIndex(userIndex);
             userInformation.loadFromJson();
             
            String user = userInformation.Email.get(userIndex);
             
            String userPass = userInformation.Password.get(userIndex);
               userInformation.loginAccount(user, userPass, null);
          
             

         }
     });


        // Set the preferred size of the button
        button.setPreferredSize(new Dimension(150, 20));

        // Set the font size of the button
        button.setFont(new Font("Roboto", Font.BOLD, 15));

        // Create a JPanel to hold the button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.gray);
        buttonPanel.add(button);

        // Add the button panel to the main panel
        panel.add(buttonPanel, BorderLayout.SOUTH);


        

      
        

        panel.add(label, BorderLayout.NORTH);
        JPanel leftContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftContainer.setBorder(BorderFactory.createEmptyBorder(40,100, 0, 0)); 
        leftContainer.setBackground(Color.gray);
        leftContainer.setPreferredSize(new Dimension(300, 200)); 
        panel.add(leftContainer, BorderLayout.WEST);

        JPanel rightContainer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightContainer.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 100));
        rightContainer.setBackground(Color.gray);
        rightContainer.setPreferredSize(new Dimension(300, 200)); 
        panel.add(rightContainer, BorderLayout.EAST);

        Font serifFont = new Font("Serif", Font.PLAIN, 16);
    
        for (int i = 1; i <= 6; i++) {
        	 ImageIcon icon = new ImageIcon();
     
        	 JLabel leftNameLabel = new JLabel();
        	
        	if(i==1) {
        		icon = new ImageIcon("flashGlass.png");
        		leftNameLabel = new JLabel("Erlenmeyer Flask");
        		
              	
              }
               if(i==2) {
            	   icon = new ImageIcon("beakerGlass.png");
            	   leftNameLabel = new JLabel("Beaker Glass    ");
               }
               if(i==3) {
            	   icon = new ImageIcon("microscope.png");
            	   leftNameLabel = new JLabel("Microscope         ");
               }
               if(i==4) {
            	   icon = new ImageIcon("testTube.png");
            	   leftNameLabel = new JLabel("testTube          ");
               }
               if(i==5) {
            	   icon = new ImageIcon("thermometers.png");
            	   leftNameLabel = new JLabel("Thermometer");
               }
               if(i==6) {
            	   icon = new ImageIcon("weighingBalance.png");
            	   leftNameLabel = new JLabel("Weighing Scale" );
               }
               leftNameLabel.setFont(serifFont);
           
            Image img = icon.getImage();
            BufferedImage resizedImg = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB); 
            Graphics2D g2d = resizedImg.createGraphics();
            g2d.setColor(Color.gray);
            g2d.fillRect(0, 0, resizedImg.getWidth(), resizedImg.getHeight()); 
            g2d.drawImage(img, 0, 0, 100, 100, null);
            g2d.dispose();
            ImageIcon resizedIcon = new ImageIcon(resizedImg);
            JLabel leftImageLabel = new JLabel(resizedIcon);
            leftNameLabel.setBackground(Color.gray);
            leftNameLabel.setOpaque(true);
          
            JPanel leftPanel = new JPanel(new BorderLayout());
            leftPanel.add(leftImageLabel, BorderLayout.CENTER);
            leftPanel.add(leftNameLabel, BorderLayout.WEST);
            leftContainer.add(leftPanel);
        }

      
        for (int i = 1; i <= 6; i++) {
        	
        	
        	ImageIcon icon = new ImageIcon();
        	JLabel rightNameLabel = new JLabel(); 
        	if(i==1) {
        		icon = new ImageIcon("salt.png");
        		 rightNameLabel = new JLabel("         Salt");
              	
              }
               if(i==2) {
            	   icon = new ImageIcon("glucose.png");
            	   rightNameLabel = new JLabel("Glucose" );
               }
               if(i==3) {
            	   icon = new ImageIcon("calciumCarbonate.png");
            	   rightNameLabel = new JLabel("Calcium ");
            	  
               }
               if(i==4) {
            	   icon = new ImageIcon("sulfur.png");
            	   rightNameLabel = new JLabel("Sulfur ");
               }
               if(i==5) {
            	   icon = new ImageIcon("buffers.png");
            	   rightNameLabel= new JLabel("Buffers");
               }
               if(i==6) {
            	   icon = new ImageIcon("solvent.png");
            	   rightNameLabel = new JLabel("Solvent ");
               }
               rightNameLabel.setFont(serifFont);
            
            Image img = icon.getImage();
            BufferedImage resizedImg = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB); 
            Graphics2D g2d = resizedImg.createGraphics();
            g2d.setColor(Color.gray); 
            g2d.fillRect(0, 0, resizedImg.getWidth(), resizedImg.getHeight()); 
            g2d.drawImage(img, 0, 0, 100, 100, null);
            g2d.dispose();
            ImageIcon resizedIcon = new ImageIcon(resizedImg);
            JLabel rightImageLabel = new JLabel(resizedIcon);
         
            
            rightNameLabel.setBackground(Color.gray);
            rightNameLabel.setOpaque(true); 
            JPanel rightPanel = new JPanel(new BorderLayout());
           
            rightPanel.add(rightImageLabel, BorderLayout.CENTER);
            rightPanel.add(rightNameLabel, BorderLayout.EAST); 
            
            rightContainer.add(rightPanel);
        }
     
        JPanel innerPanel = new JPanel(new GridLayout(0, 2));
       // innerPanel.setBackground(Color.BLUE);
        panel.add(innerPanel, BorderLayout.CENTER);

        JPanel leftPanel = new JPanel(new GridLayout(6, 1));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(80, 0, 0, 0)); 
        leftPanel.setBackground(Color.gray);
        for (int i = 0; i < 6; i++) {
        	SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, 40, 1);
            JSpinner spinner = new JSpinner(spinnerModel);
            spinner.setPreferredSize(new Dimension(40, spinner.getPreferredSize().height)); 
            JPanel spinnerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel spinnerLabel = new JLabel("Stock Left: "+scienceLabItems.equipments[i]); 
          spinnerPanel.setBackground(Color.gray);
          
          
          int index = i;
          
          
          int originalValueEquipments = scienceLabItems.equipments[index];
          
          
          
         
          //change sa vvalue using spinner//equipments
 
          spinnerModel.addChangeListener(e -> {
              int newValue = (int) spinner.getValue(); 
               scienceLabItems.equipments[index] = originalValueEquipments - newValue;
              spinnerLabel.setText("Stock Left: " + scienceLabItems.equipments[index] );
          });
          
          
     

     // for the keyboard input ni siya // equipments
          ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().addKeyListener(new KeyAdapter() {
              public void keyReleased(KeyEvent e) {
                  String inputText = ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().getText();
                  
                 
                  
                  try {
                      if (inputText.isEmpty()) {
                      
                          scienceLabItems.equipments[index] = originalValueEquipments ;
                      } else {
                          int inputInt = Integer.parseInt(inputText);
                
                          if (inputInt >originalValueEquipments ) {
                            
                              inputInt = originalValueEquipments ;
                              
                             
                              ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().setText(String.valueOf(inputInt));
                          }
                        
                          scienceLabItems.equipments[index] = originalValueEquipments  - inputInt;
                      }
                      spinnerLabel.setText("Stock Left: " + scienceLabItems.equipments[index]);
                      System.out.println(scienceLabItems.equipments[index]);
                  } catch (NumberFormatException ex) {
                      
                  }
              }
          });

          
          
          
     
            if(i==1) {
           	 spinnerPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0)); 
           }
            if(i==2) {
            	 spinnerPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0)); 
            }
            if(i==3) {
            	 spinnerPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0)); 
            }
            if(i==4) {
            	 spinnerPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
            }
            if(i==5) {
           	 spinnerPanel.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0)); 
           }
           
            spinnerPanel.add(spinnerLabel); 
            spinnerPanel.add(spinner);
            leftPanel.add(spinnerPanel);
            
        }
        innerPanel.add(leftPanel);

        JPanel rightPanel = new JPanel(new GridLayout(6, 1));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(80, 0, 0, 0)); 
        rightPanel.setBackground(Color.gray);
        
        String[] measurements = {"g", "mL", "mL", "g", "g", "g"};
        for (int i = 0; i < 6; i++) {
        	SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, 400, 10);
            JSpinner spinner = new JSpinner(spinnerModel);
            spinner.setPreferredSize(new Dimension(60, spinner.getPreferredSize().height)); 
            JPanel spinnerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            spinnerPanel.setBackground(Color.GRAY);
            JLabel spinnerLabel = new JLabel("Stock Left: " + scienceLabItems.materials[i] +measurements[i]); 
            
            int index = i;
            
        
            int originalValueMaterials = scienceLabItems.materials[index];
            
            
            
           
            
   
            spinnerModel.addChangeListener(e -> {
                int newValue = (int) spinner.getValue(); 
                 scienceLabItems.materials[index] = originalValueMaterials - newValue;
                spinnerLabel.setText("Stock Left: " + scienceLabItems.materials[index] + measurements[index]);
            });
            
            
       

       // for the keyboard input ni siya
            ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().addKeyListener(new KeyAdapter() {
                public void keyReleased(KeyEvent e) {
                    String inputText = ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().getText();
                    
                   
                    
                    try {
                        if (inputText.isEmpty()) {
                        
                            scienceLabItems.materials[index] = originalValueMaterials;
                        } else {
                            int inputInt = Integer.parseInt(inputText);
                  
                            if (inputInt > originalValueMaterials) {
                              
                                inputInt = originalValueMaterials;
                                
                               
                                ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().setText(String.valueOf(inputInt));
                            }
                          
                            scienceLabItems.materials[index] = originalValueMaterials - inputInt;
                        }
                        spinnerLabel.setText("Stock Left: " + scienceLabItems.materials[index] + measurements[index]);
                        System.out.println(scienceLabItems.materials[index]);
                    } catch (NumberFormatException ex) {
                        
                    }
                }
            });






            if(i==1) {
              	 spinnerPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0)); 
              }
               if(i==2) {
               	 spinnerPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0)); 
               }
               if(i==3) {
               	 spinnerPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0)); 
               }
               if(i==4) {
               	 spinnerPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
               }
               if(i==5) {
              	 spinnerPanel.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0)); 
              }
              
              
               spinnerPanel.add(spinnerLabel); 
            spinnerPanel.add(spinner);
            rightPanel.add(spinnerPanel);
            
        }
        innerPanel.add(rightPanel);
        
        
         frame.add(panel);
        frame.setVisible(true);
        frame.setResizable(false); 
   }
    
    public void getUserIndex(int index) {
		this.userIndex=index;
		System.out.println(userIndex);
	}
}
