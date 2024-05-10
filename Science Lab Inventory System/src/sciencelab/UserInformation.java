package sciencelab;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UserInformation {
	
	private String password = "CTULibrary";

	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9_]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$");
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z]+$");


    List<String> Email = new ArrayList<>();
    List<String> Password = new ArrayList<>();
    List<String> IDNumber = new ArrayList<>();
    List<String> LastName = new ArrayList<>();
    List<String> Birthdate = new ArrayList<>();
    List<String>FirstName = new ArrayList<>();

    public void CreateAccount(String emailAddress, String idNumber, String birthdate,String firstName,String lastName) {
    	
    	 if (Email.contains(emailAddress)) {
    	        System.out.println("Email Address already registered");
    	        return;
    	    }
    	 if(IDNumber.contains(idNumber)) {
    		 System.out.println("ID Number already registered");
    		 return;
    	 }
    	
        System.out.println("Validating email address: " + emailAddress);

        if (!isValidEmail(emailAddress)) {
            System.out.println("Invalid Email Address");
            return;
        }

      
        try {
            int id = Integer.parseInt(idNumber);
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID Number");
            return;
        }

        
        if (!isValidName(firstName)) {
            System.out.println("Invalid First Name");
            return;
        }

       
        if (!isValidName(lastName)) {
            System.out.println("Invalid Last Name");
            return;
        }

       
        Email.add(emailAddress);
        IDNumber.add(idNumber);
        Birthdate.add(birthdate);
        FirstName.add(firstName);
        LastName.add(lastName);
        Password.add(password+Email.indexOf(emailAddress));
        
    }


    private boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

   
    private boolean isValidName(String name) {
        return NAME_PATTERN.matcher(name).matches();
    }
}



