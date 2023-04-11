import java.util.Scanner;

public class TokTik
{
    public static void main(String[] args)
    {
        BinarySearchTree<Account> tree = new BinarySearchTree<Account>();
        
        int choice = 0;
        Scanner sc;

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

                sc = new Scanner(System.in);
                choice = Integer.parseInt(sc.next());

                if(choice == 1)
                {
                    System.out.println("Enter account name:");
                    String accountName = sc.next();
                    Account account = new Account(accountName, null);

                    BinaryTreeNode<Account> accountNode = tree.find(account);
                    if(accountNode != null)
                    {
                        //TODO: Add null check on accountNode before saying node.data --> this will throw error
                        System.out.println("The profile description is: " + ((Account) accountNode.data).getDescription());
                    }

                    else
                    {
                        System.out.println(String.format(accountName, "Account %s does not exist!"));
                    }
                }

                else if(choice == 2)
                {
                    tree.inOrder();
                }

                else if(choice == 3)
                {
                    System.out.println("Enter the account name: ");
                    String accountName = sc.next();
                    System.out.println("Enter the account description: ");
                    String description = sc.next();
                    Account account = new Account(accountName, description);

                    // Account name can't already exist
                    BinaryTreeNode<Account> existingAccount = tree.find(account);
                    if(existingAccount == null)
                    {
                        tree.insert(account);
                        System.out.println("Successfully created account " + account.getAccountName());
                    }

                    else
                    {
                        System.out.println("An account with that name already exists!");
                    }
                }

                else if(choice == 4)
                {
                    System.out.println("Enter the account name: ");
                    String accountName = sc.next();

                    Account account = new Account(accountName, null);
                    BinaryTreeNode<Account> accountNode = tree.find(account);

                    if(accountNode != null)
                    {
                        tree.delete(account);
                    }

                    else
                    {
                        System.out.println("Account with name " + accountName + " does not exist.");
                    }
                }

                else if(choice == 5)
                {
                    System.out.println("Enter the account name: ");
                    String accountName = sc.next();

                    Account account = new Account(accountName, null);
                    BinaryTreeNode<Account> accountNode = tree.find(account);

                    account = (Account) accountNode.data;
                    
                    System.out.println(account.getPosts());
                }

                else if(choice == 6)
                {
                    System.out.println("Enter account name:");
                    String accountName = sc.next();
                    Account account = new Account(accountName, null);

                    BinaryTreeNode<Account> accountNode = tree.find(account);

                    account = (Account) accountNode.data;

                    // First check if account with name exists
                    // Second check if there are any accounts ; can't have posts without accounts
                    if(account != null && tree.getSize() > 0)
                    {
                        System.out.println("Enter post title:");
                        String title = sc.next();
                        String video = "video" + tree.getSize() + ".mpg";

                        Post post = new Post(title, video);
                        account.addPost(post);

                        System.out.println(String.format(accountName, post.toString(), "Added post to user %s's account!%n%s"));
                    }

                    else
                    {
                        System.out.println(String.format(accountName, "Account %s does not exist!"));
                    }
                }

                else if(choice == 7)
                {
                    
                }
                

        } while(choice != 8);

        sc.close();
    }
}