package sciencelab;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AdminPanel {

    private static final String LOGS_FILE_PATH = "logs.json";
    private JPanel panel;
    public static String[][] data;
    private static boolean showHistoryListenerAdded = false;
    JLabel userLiveTime = new JLabel();

    public void StartAdminPanel() {
        JFrame frame = new JFrame("Science Laboratory Inventory System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1300, 800);
        frame.setLocationRelativeTo(null);

        panel = new JPanel(new BorderLayout());
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
        
        
        
        
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTimeLabel(userLiveTime);
            }
        });
        timer.start();
        
        
        
        
        
        
        
        
        

        JLabel adminLabel = new JLabel("ADMIN PANEL");
        adminLabel.setFont(new Font("Serif", Font.BOLD, 24));
    
      
      adminLabel.setBorder(BorderFactory.createEmptyBorder(10, 220, 10, 25));
        titlePanel.add(adminLabel, BorderLayout.CENTER);
    
        panel.add(titlePanel, BorderLayout.NORTH);

 
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBackground(Color.RED); 
        logoutButton.setForeground(Color.white);
        logoutButton.setFocusPainted(false);
        logoutButton.setFont(new Font("Arial", Font.BOLD, 16));
        logoutButton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));

        logoutButton.addActionListener(e -> {
            frame.dispose();
        });

     

        titlePanel.add(logoutButton,BorderLayout.EAST);
        titlePanel.add(userLiveTime,BorderLayout.WEST);
        userLiveTime.setFont(new Font("Serif", Font.BOLD, 20));



        
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(new Color(64, 64, 64, 0)); // Transparent background

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0); // Adjust the padding as needed
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel buttonsPanel = new JPanel(new GridLayout(1, 5, 20, 0));
        buttonsPanel.setBackground(new Color(64, 64, 64, 0)); // Transparent background
        

        // Add buttons to the buttonsPanel
        JButton logsButton = new JButton("Logs");
        styleButton(logsButton, new Color(58, 128, 189));
       

        JButton borrowedUsersButton = new JButton("Users who Borrowed");
        styleButton(borrowedUsersButton, new Color(58, 128, 189));

        JButton registeredUsersButton = new JButton("Registered Users");
        styleButton(registeredUsersButton, new Color(58, 128, 189));

        JButton addItemsButton = new JButton("Add Items");
        styleButton(addItemsButton, new Color(58, 128, 189));

        JButton addMaterialsButton = new JButton("Add Materials");
        styleButton(addMaterialsButton, new Color(58, 128, 189));

        buttonsPanel.add(logsButton);
        buttonsPanel.add(borrowedUsersButton);
        buttonsPanel.add(registeredUsersButton);
        buttonsPanel.add(addItemsButton);
        buttonsPanel.add(addMaterialsButton);

     
        centerPanel.add(buttonsPanel, gbc);

        panel.add(centerPanel, BorderLayout.CENTER);

        logsButton.addActionListener(e -> showLogsDialog());
        borrowedUsersButton.addActionListener(e -> showBorrowedUsersDialog());
        registeredUsersButton.addActionListener(e -> showRegisteredUsersDialog());
        addItemsButton.addActionListener(e -> showAddItemsDialog());
        addMaterialsButton.addActionListener(e -> showAddMaterialsDialog());

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
        scrollPane.setPreferredSize(new Dimension(900, 500));

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
    
    private static void updateTimeLabel(JLabel label) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM dd, yyyy - h:mm:ss a");
        String formattedDateTime = dateFormat.format(new Date());
        label.setText(formattedDateTime);
        label.setForeground(Color.black.darker().darker());
    }
    
    
    
}
