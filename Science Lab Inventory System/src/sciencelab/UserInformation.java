package sciencelab;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.swing.*;
import java.util.Date;
import java.text.SimpleDateFormat;



import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;




public class UserInformation {
	
	static Date currentDate = new Date();
	public static HomePage homePage = new HomePage();
	ScienceLabItems sciencelabitems = new ScienceLabItems();
	 
	
	public static boolean firstTimeLogin=false;
	
    private static final String JSON_FILE = "user_information.json"; 
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9_]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$");
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z]+$");
    
  

    String lastLogin;
    String userActivity;
    int index;
    private String password = "CTULibrary";

    public List<String> Email = new ArrayList<>();
    public List<String> Password = new ArrayList<>();
    private List<String> IDNumber = new ArrayList<>();
    private List<String> LastName = new ArrayList<>();
    private List<String> Birthdate = new ArrayList<>();
    private List<String> FirstName = new ArrayList<>();
    private List<String> AccountDateCreated = new ArrayList<>();
    private List<String> LastLogin = new ArrayList<>();
    private List<String> UserHistory = new ArrayList<>();
    

  


    public void createAccount(String emailAddress, String idNumber, String birthdate, String firstName, String lastName) {
    	
    	
    	
        if (Email.contains(emailAddress.toLowerCase())) {
            showMessageDialog("Email Address already registered");
            return;
        }

        if (IDNumber.contains(idNumber)) {
            showMessageDialog("ID Number already registered");
            return;
        }

        if (!isValidEmail(emailAddress.toLowerCase())) {
            showMessageDialog("Invalid Email Address");
            return;
        }

        try {
            int id = Integer.parseInt(idNumber);
        } catch (NumberFormatException e) {
            showMessageDialog("Invalid ID Number");
            return;
        }

        if (!isValidBirthdate(birthdate)) {
            showMessageDialog("Invalid Birthdate");
            return;
        }

        if (!isValidName(firstName)) {
            showMessageDialog("Invalid First Name");
            return;
        }

        if (!isValidName(lastName)) {
            showMessageDialog("Invalid Last Name");
            return;
        }

        Email.add(emailAddress.toLowerCase());
        IDNumber.add(idNumber);
        Birthdate.add(birthdate);
        FirstName.add(firstName);
        LastName.add(lastName);
        Password.add(password + Email.indexOf(emailAddress));
        showPasswordDialog(password + Email.indexOf(emailAddress));
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM dd, yyyy\nh:mm:ss a");
    	String formattedDateTime = dateFormat.format(currentDate);
    	AccountDateCreated.add(formattedDateTime);
    	LastLogin.add("");
    	UserHistory.add("");

        saveToJson();
        
    }

   


    public void loginAccount(String email, String password,JPanel jpanel) {
         index = Email.indexOf(email.toLowerCase());
        if (index != -1) {
            if (Password.get(index).equals(password)) {
            	
            	
            	if(!firstTimeLogin) {
            		showLoginSuccessDialog();
            		firstTimeLogin=true;
            	}
            	
            	
            	
            	
            	
            	
            	
            	 try {
            		 
            	 JFrame tobeDestroyed= (JFrame) SwingUtilities.getWindowAncestor(jpanel); //gikuha nako ang panel sa main page/login page para e destroy diri
            	  if(tobeDestroyed!=null) {
                  	tobeDestroyed.dispose();
                  }
              	
                 
                 } catch (Exception ex) {
                    
                	 System.out.println("panel cant be found");
                 }
            	
            	
            	SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM dd, yyyy\nh:mm:ss a");
            	
            	String formattedDateTime = dateFormat.format(currentDate);
            	
            	
            	if(!LastLogin.isEmpty() && LastLogin.get(index).length()>2) {
            		
            		lastLogin = LastLogin.get(index);
            	}else {
            		lastLogin = formattedDateTime;
            		LastLogin.set(index, formattedDateTime);
            		saveToJson();

            	}
            	
                LabDashBoard labDashBoard = new LabDashBoard();
                String userIDNumber = "ID Number: "+IDNumber.get(index);
                String userInfo = "<html>"
                		+ "Welcome, " + FirstName.get(index) + " " + LastName.get(index) + "<br>"+
                		   userIDNumber+"<br><br>Account Date Created: <br>"+AccountDateCreated.get(index)+"<br><br>"+
                		   "Date and Time: <br>"+"time time"+"<br><br>"+
                		   "Last login: <br>"+lastLogin+"</html>";   
                LastLogin.set(index, formattedDateTime);
                
        		saveToJson();
        		
        		
                if(!UserHistory.isEmpty() && UserHistory.get(index).length()>2) {
            		
                	userActivity = UserHistory.get(index);
            		
            	}else {
            		userActivity = "<html> <br><br><br>This account has no activity history.</html>";

            	
            	}
                
        		String userHistory = "<html>Account Activity History  /  Type<br>"+
        		                        userActivity+"</html>";



                
        		
        		labDashBoard.userHistory.setText(userHistory );
                labDashBoard.userWelcome.setText(userInfo);
                labDashBoard.getUserIndex(index);
                
                
                   
                
                labDashBoard.StartDashBoard();  
              
            	
                
            	
            	
    
                
            } else {
                showPasswordIncorrectDialog();
            }
        } 
        else {
        	showAccountNotFoundtDialog();
        }
    }


    private boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    private boolean isValidName(String name) {
        return NAME_PATTERN.matcher(name).matches();
    }

    private boolean isValidBirthdate(String birthdate) {
        return birthdate.matches("\\d{4}-\\d{1,2}-\\d{1,2}");
    }

    private void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void showLoginSuccessDialog() {
        JOptionPane.showMessageDialog(null, "Login success!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showPasswordDialog(String password) {
        JOptionPane.showMessageDialog(null, "Your Password is: " + password, "Password", JOptionPane.INFORMATION_MESSAGE);
        
    }

    private void showAccountNotFoundtDialog() {
        JOptionPane.showMessageDialog(null, "Account Not Found", "Error", JOptionPane.ERROR_MESSAGE);
    }
    private void showPasswordIncorrectDialog() {
        JOptionPane.showMessageDialog(null, "Your Password is incorrect", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    


    private void saveToJson() {
        try (Writer writer = new FileWriter(JSON_FILE)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(this, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void loadFromJson() {
        File file = new File(JSON_FILE);
        if (file.exists()) {
            try (Reader reader = new FileReader(JSON_FILE)) {
                Gson gson = new Gson();
                UserInformation data = gson.fromJson(reader, UserInformation.class);
                if (data != null) {
                    Email = data.Email;
                    Password = data.Password;
                    IDNumber = data.IDNumber;
                    LastName = data.LastName;
                    Birthdate = data.Birthdate;
                    FirstName = data.FirstName;
                    AccountDateCreated = data.AccountDateCreated;
                    LastLogin = data.LastLogin;
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Error reading JSON file: " + e.getMessage());
            }
        } else {
            System.err.println("JSON file does not exist: " + JSON_FILE);
        }
    }
    

 
}

