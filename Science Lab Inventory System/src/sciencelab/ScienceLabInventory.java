package sciencelab;



public class ScienceLabInventory {
    
    static HomePage homePage = new HomePage();
    static CreationPage creationPage = new CreationPage();
    static RecoveryPage recoveryPage = new RecoveryPage();

    public static void main(String[] args) {
        
    	//recoveryPage.StartRecovery();
   homePage.ShowGUI();
    }
}
