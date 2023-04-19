package src;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * CLI for TokTik that interacts with Account and Post classes
 */

public class TokTik
{
    public static void main(String[] args)
    {
        BinarySearchTree<Account> tree = new BinarySearchTree<Account>();
        
        int choice = 0;
        Scanner sc;

        ArrayList<Account> following = new ArrayList<Account>();

        do {
            System.out.println("Choose an action from the menu:");
            System.out.println(
                "\n" +
                "1. Find the profile description for a given account\n" +
                "2. List all accounts\n" +
                "3. Create an account\n" +
                "4. Delete an account\n" +
                "5. Display all posts for a single account\n" +
                "6. Add a new post for an account\n" +
                "7. Load a file of actions from disk and process this\n" +
                "8. Follow an account\n" +
                "9. View your For You page\n" +
                "10. Quit\n" +
                "Enter your choice: \n");

                sc = new Scanner(System.in).useDelimiter("\n");
                choice = Integer.parseInt(sc.next());

                if(choice == 1)
                {
                    System.out.println("Enter account name:");
                    String accountName = sc.next();
                    Account account = new Account(accountName, null);

                    BinaryTreeNode<Account> accountNode = tree.find(account);
                    if(accountNode != null)
                    {
                        System.out.println("The profile description is: " + ((Account) accountNode.data).getDescription());
                    }

                    else
                    {
                        System.out.println(String.format("Account %s does not exist!", accountName));
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
                    Account account = new Account(accountName, null);
                    // Account name can't already exist
                    BinaryTreeNode<Account> accountNode = tree.find(account);
                    if(accountNode == null)
                    {
                        System.out.println("Enter the account description: ");
                        String description = sc.next();
                        account = new Account(accountName, description);

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
                        System.out.println(String.format("Account with name %s has been deleted.", accountName));
                    }
                    else
                    {
                        System.out.println(String.format("Account with name %s does not exist.", accountName));                    }
                }
                else if(choice == 5)
                {
                    System.out.println("Enter the account name: ");
                    String accountName = sc.next();
                    Account account = new Account(accountName, null);
                    BinaryTreeNode<Account> accountNode = tree.find(account);

                    if(accountNode != null)
                    {
                        account = (Account) accountNode.data;
                        System.out.println(account.getPostsAsString());
                    }

                    else
                    {
                        System.out.println(String.format("Account with name %s does not exist.", accountName));
                    }
                }
                else if(choice == 6)
                {
                    System.out.println("Enter account name:");
                    String accountName = sc.next();
                    Account account = new Account(accountName, null);
                    BinaryTreeNode<Account> accountNode = tree.find(account);
                    // First check if account with name exists
                    // Second check if there are any accounts ; can't have posts without accounts
                    if(accountNode != null)
                    {
                        account = (Account) accountNode.data;
                        System.out.println("Enter post title:");
                        String title = sc.next();
                        System.out.println("Enter video name:");
                        String video = sc.next();
                        System.out.println("Enter number of likes:");
                        int likes = sc.nextInt();
                        Post post = new Post(title, video, likes);
                        account.addPost(post);
                        System.out.println(String.format("Added post to user %s's account!\n%s", accountName, post.toString()));
                    }

                    else
                    {
                        System.out.println(String.format("Account %s does not exist!", accountName));
                    }
                }
                else if(choice == 7)
                {
                    System.out.println("Enter a filename");
                    String fileName = sc.next();
                    try
                    {
                        Scanner scFile = new Scanner(new File(fileName));
                        while(scFile.hasNext())
                        {
                            String command = scFile.nextLine();
                            Scanner scLine = new Scanner(command).useDelimiter(" ");
                            String commandType = scLine.next();
                            String accountName = scLine.next();
                            if(commandType.equals("Create"))
                            {
                                String description = "";
                                while (scLine.hasNext())
                                {
                                    description += scLine.next() + " ";
                                }
                                description = description.trim();
                                Account account = new Account(accountName, description);
                                tree.insert(account);
                            }
                            else if(commandType.equals("Add"))
                            {
                                String video = scLine.next();
                                int likes = scLine.nextInt();
                                String title = "";
                                while (scLine.hasNext())
                                {
                                    title += scLine.next() + " ";
                                }
                                Account account = new Account(accountName, null);
                                BinaryTreeNode<Account> accountNode = tree.find(account);
                                if(accountNode != null)
                                {
                                    Post post = new Post(title, video, likes);
                                    account = (Account) accountNode.data;
                                    tree.delete(account);
                                    account.addPost(post);
                                    tree.insert(account);
                                    System.out.println("Succesfully added post to account " + accountName);
                                }
                                else
                                {
                                    System.out.println("Account " + accountName + " does not exist!");
                                }
                                scLine.close();
                            }
                        }
                        System.out.println("Successfully run commands.");
                    }
                    catch(Exception e)
                    {
                        System.out.println("File not found! Try again.");
                    }
                }
                else if(choice == 8)
                {
                    System.out.println("Type in an account name:");
                    String accountName = sc.next();
                    Account account = new Account(accountName, null);
                    BinaryTreeNode<Account> accountNode = tree.find(account);
                    if(accountNode.data != null)
                    {
                        account = (Account) accountNode.data;
                        following.add(account);
                        System.out.println("You are now following " + accountName + "!");
                    }
                }
                else if(choice == 9)
                {
                    if(following.size() == 0)
                    {
                        System.out.println("You aren't following anyone at the moment!");
                        continue;
                    }

                    System.out.println("Welcome to your For You page!");
                    System.out.println("You'll only see posts from people you follow.");
                    System.out.println("--------------------------------------------");
                    System.out.println("To like/unlike a post, press L");
                    System.out.println("To skip to the next post, press >");
                    System.out.println("To skip to the previous post, press <");
                    System.out.println("To exit, press X");

                    ArrayList<Post> allPosts = new ArrayList<Post>();

                    int index = 0;
                    for(Account account: following)
                    {
                        ArrayList<Post> posts = account.getPosts();

                        for(Post post: posts)
                            allPosts.add(post);
                    }

                    String navigationChoice;

                    do
                    {
                        Post post = allPosts.get(index);
                        
                        String heartIcon =
                            post.isLiked() ?
                            "\u2665" :
                            "\u2661";

                        System.out.println("--------------------" + (index+1) + ".---------------------");
                        System.out.println(post.toString());
                        System.out.println(heartIcon);
                        System.out.println("--------------------" + (index+1) + ".---------------------");

                        navigationChoice = sc.next();

                        if(navigationChoice.equalsIgnoreCase("L"))
                        {
                            if(post.isLiked())
                                post.unlike();
                            else
                                post.like();
                        }

                        else if(navigationChoice.equalsIgnoreCase(">"))
                        {
                            if(index < allPosts.size() - 1)
                                index++;
                        }

                        else if(navigationChoice.equalsIgnoreCase("<"))
                        {
                            if(index > 0)
                                index--;
                        }

                    } while(!navigationChoice.equalsIgnoreCase("X"));                    
                }
                
        } while(choice != 10);

        sc.close();
    }
}