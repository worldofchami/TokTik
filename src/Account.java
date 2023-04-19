package src;
import java.util.ArrayList;

/**
 * Creates a new Account to be implemented into the BinarySearchTree
 */

public class Account implements Comparable<Account>
{
    private String accountName, description;
    private ArrayList<Post> posts;

    /**
     * Creates a new Account object
     */
    public Account(String accountName, String description)
    {
        this.accountName = accountName;
        this.description = description;
        this.posts = new ArrayList<Post>();
    }

    /**
     * Adds a new post to the user
     * @param post the post to be added to the user
     */
    public void addPost(Post post)
    {
        this.posts.add(post);
    }

    /**
     * Traverses through the posts ArrayList and returns each of the posts belonging to the user on a new line
     */
    public String getPostsAsString()
    {
        String postsAsStr = "";
        if(posts.size() > 0)
        {
            for(Post post : posts)
                    postsAsStr += post.toString() + "\n";

            // Removes last newline character
            return postsAsStr.trim();
        }

        return "No posts exist for user " + this.accountName;
    }

    /**
     * Compares 2 accounts by lexicographically comparing their account names
     * @param account the account being compared to this account
     */
    @Override
    public int compareTo(Account account)
    {
        return this.accountName.compareTo(account.accountName);
    }

    /**
     * Get method for accountName
     * @return this account's name
     */
    public String getAccountName() { return this.accountName; }

    /**
     * Get method for description
     * @return this account's description
     */
    public String getDescription() { return this.description; }

    /**
     * Get method for posts
     * @return this account's posts
     */
    public ArrayList<Post> getPosts() { return posts; }

    /**
     * Account object toString
     * @return this account's details neatly formatted
     */
    public String toString()
    {
        return String.format("Name:%n%s%nDescription:%n%s", this.accountName, this.description);
    }
}