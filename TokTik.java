import java.util.Scanner;

public class TokTik
{
    public static void main(String[] args)
    {
        int choice = 0;

        do {
            System.out.println("Choose an action from the menu:");
            System.out.println(
                "1. Find the profile description for a given account\n" +
                "2. List all accounts\n" +
                "3. Create an account\n" +
                "4. Delete an account\n" +
                "5. Display all posts for a single account\n" +
                "6. Add a new post for an account\n" +
                "7. Load a file of actions from disk and process this\n" +
                "8. Quit\n" +
                "Enter your choice: ");

                Scanner sc = new Scanner(System.in);
                choice = Integer.parseInt(sc.next());

                if(choice == 1)
                {
                    System.out.println("Enter the account name: ");
                    String accountName = sc.next();


                }

        } while(choice != 8);
    }
}