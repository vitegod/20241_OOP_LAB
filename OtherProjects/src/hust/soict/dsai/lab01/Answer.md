-	What happens if users choose “Cancel”?
    "You've choose: I don't"
-	How to customize the options to users, e.g. only two options: “Yes” and “No”, OR “I do” and “I don’t” (Suggestion: Use Javadocs or using Eclipse/Netbean IDE help). 
    Add "YES_NO_OPTION" to showConfirmDialog.
    "
    import javax.swing.JOptionPane;
    public class ChoosingOption {
        public static void main(String[] arg) {
            int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket?", "Confirmation", JOptionPane.YES_NO_OPTION); //Here
            JOptionPane.showMessageDialog(null, "You've chosen: " + (option == JOptionPane.YES_NO_OPTION? "I do": "I don't"));
            System.exit(0);
        }
    }
    "