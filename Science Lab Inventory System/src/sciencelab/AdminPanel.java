package sciencelab;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AdminPanel {

    private static final String LOGS_FILE_PATH = "logs.json";
    private JPanel panel;
    public static String[][] data;
    private static boolean showHistoryListenerAdded = false;

    public void StartAdminPanel() {
    	JFrame frame = new JFrame("Science Laboratory Inventory System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1300, 800);
        frame.setLocationRelativeTo(null);

        panel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
       
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setColor(new Color(255, 200, 0, 128)); 
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.dispose();
            }
        };
     
        panel.setOpaque(false);


        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(Color.white);
        
        JLabel titleLabel = new JLabel("SCIENCE LABORATORY INVENTORY SYSTEM");
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 60));
        titleLabel.setForeground(Color.black.brighter());
        titleLabel.setFont(new Font("Serif", Font.BOLD, 36));
        titleLabel.setBackground(Color.orange.darker());
        titleLabel.setOpaque(true);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titlePanel.add(titleLabel, BorderLayout.NORTH);
        

        JLabel adminLabel = new JLabel("ADMIN PANEL");
        adminLabel.setFont(new Font("Serif", Font.BOLD, 24));
        adminLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titlePanel.add(adminLabel, BorderLayout.CENTER);

     
        panel.add(titlePanel, BorderLayout.NORTH);
        
   
        JPanel logoutPanel = new JPanel();
        logoutPanel.setBackground(new Color(64, 64, 64, 0)); // transparent
        
        // Create the logout button
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBackground(Color.RED); // Customize the button color if needed
        logoutButton.setForeground(Color.white);
        logoutButton.setFocusPainted(false);
        logoutButton.setFont(new Font("Arial", Font.BOLD, 16));
        logoutButton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        
  
        logoutButton.addActionListener(e -> {
   
            frame.dispose();
        
        });

       
        logoutPanel.add(logoutButton);


        panel.add(logoutPanel, BorderLayout.LINE_END);

        JPanel adminSection = new JPanel(new BorderLayout());
        JLabel adminLabel1 = new JLabel("ADMIN PANEL");
        adminLabel.setFont(new Font("Serif", Font.BOLD, 24));
        adminSection.setBackground(Color.white);
        adminLabel.setHorizontalAlignment(SwingConstants.CENTER);
        adminSection.add(adminLabel1, BorderLayout.NORTH);
       

     

        JPanel buttonsPanel = new JPanel(new GridLayout(1, 5, 20, 0)); 
        buttonsPanel.setBackground(new Color(64, 64, 64, 0));

        JButton logsButton = new JButton("Logs");
        styleButton(logsButton, new Color(58, 128, 189));

        JButton borrowedUsersButton = new JButton("Users who Borrowed");
        styleButton(borrowedUsersButton, new Color(50, 205, 50));

        JButton registeredUsersButton = new JButton("Registered Users");
        styleButton(registeredUsersButton, new Color(255, 69, 0));

        JButton addItemsButton = new JButton("Add Items");
        styleButton(addItemsButton, new Color(255, 215, 0));
        
        JButton addMaterialsButton = new JButton("Add Materials");
        styleButton(addMaterialsButton, new Color(255, 140, 0));

        buttonsPanel.add(logsButton);
        buttonsPanel.add(borrowedUsersButton);
        buttonsPanel.add(registeredUsersButton);
        buttonsPanel.add(addItemsButton);
        buttonsPanel.add(addMaterialsButton);

        logsButton.addActionListener(e -> showLogsDialog());

        borrowedUsersButton.addActionListener(e -> showBorrowedUsersDialog());

        registeredUsersButton.addActionListener(e -> showRegisteredUsersDialog());

        addItemsButton.addActionListener(e -> showAddItemsDialog());
        
        addMaterialsButton.addActionListener(e -> showAddMaterialsDialog());

        panel.add(buttonsPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void styleButton(JButton button, Color backgroundColor) {
        button.setBackground(backgroundColor);
        button.setForeground(Color.white);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
    }

    private void showLogsDialog() {
        JPanel historyPanel = new JPanel(new BorderLayout());

        Font font = new Font(Font.MONOSPACED, Font.PLAIN, 16);

        String[] columns = {"Name", "ID Number", "Item Name", "QTY / Volume"};
        JTable table = new JTable(new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        table.setFont(font);

        JScrollPane scrollPane = new JScrollPane(table);

        historyPanel.add(scrollPane, BorderLayout.CENTER);

        scrollPane.setPreferredSize(new Dimension(900, 500)); 

        JOptionPane.showMessageDialog(null, historyPanel, "Logs", JOptionPane.PLAIN_MESSAGE);
    }


    private void showBorrowedUsersDialog() {
        JPanel borrowedUsersPanel = new JPanel(new BorderLayout());

        Font font = new Font(Font.MONOSPACED, Font.PLAIN, 16);

        String[] columns = {"User Name", "User ID", "Borrowed Item", "Date Borrowed"};
        JTable table = new JTable(new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        table.setFont(font);

        JScrollPane scrollPane = new JScrollPane(table);

        borrowedUsersPanel.add(scrollPane, BorderLayout.CENTER);

        //
        scrollPane.setPreferredSize(new Dimension(900, 500)); 

       
        JOptionPane.showMessageDialog(null, borrowedUsersPanel, "Users who Borrowed", JOptionPane.PLAIN_MESSAGE);
    }


    private void showRegisteredUsersDialog() {
        JPanel registeredUsersPanel = new JPanel(new BorderLayout());

        Font font = new Font(Font.MONOSPACED, Font.PLAIN, 16);

        String[] columns = {"User Name", "User ID", "Registration Date"};
        JTable table = new JTable(new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        table.setFont(font);

        JScrollPane scrollPane = new JScrollPane(table);
        
        // Set preferred size of the scroll pane
        scrollPane.setPreferredSize(new Dimension(900,500));

        registeredUsersPanel.add(scrollPane, BorderLayout.CENTER);

    
        JOptionPane.showMessageDialog(null, registeredUsersPanel, "Registered Users", JOptionPane.PLAIN_MESSAGE);
    }



    private void showAddItemsDialog() {
        JTextField itemNameField = new JTextField(10);
        JTextField quantityField = new JTextField(10);
        
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(new JLabel("Item Name:"), gbc);

        gbc.gridx = 1;
        inputPanel.add(itemNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(new JLabel("Quantity:"), gbc);

        gbc.gridx = 1;
        inputPanel.add(quantityField, gbc);

        int result = JOptionPane.showConfirmDialog(null, inputPanel, "Add Items", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String itemName = itemNameField.getText();
            String quantity = quantityField.getText();
          
        }
    }
    
    private void showAddMaterialsDialog() {
        JTextField materialNameField = new JTextField(10);
        JTextField volumeField = new JTextField(10);
        
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(new JLabel("Material Name:"), gbc);

        gbc.gridx = 1;
        inputPanel.add(materialNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(new JLabel("Volume:"), gbc);

        gbc.gridx = 1;
        inputPanel.add(volumeField, gbc);

        int result = JOptionPane.showConfirmDialog(null, inputPanel, "Add Materials", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String materialName = materialNameField.getText();
            String volume = volumeField.getText();
   
        }
    }
    public JPanel getPanel() {
        return panel;
    }

    public void saveDataToJson() {
        try (Writer writer = new FileWriter(LOGS_FILE_PATH)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(data, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadDataFromJson() {
        try (Reader reader = new FileReader(LOGS_FILE_PATH)) {
            Gson gson = new Gson();
            data = gson.fromJson(reader, String[][].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addData(String[] newData) {
        if (data == null) {
            data = new String[1][];
            data[0] = newData;
        } else {
            String[][] newDataArray = Arrays.copyOf(data, data.length + 1);
            newDataArray[data.length] = newData;
            data = newDataArray;
        }
    }
}