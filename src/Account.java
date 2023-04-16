package src;
import java.util.ArrayList;

public class Account implements Comparable<Account>
{
    private String accountName, description;
    private ArrayList<Post> posts;

    public Account(String accountName, String description)
    {
        this.accountName = accountName;
        this.description = description;
        this.posts = new ArrayList<Post>();
    }

    public void addPost(Post post)
    {
        this.posts.add(post);
    }

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

    @Override
    public int compareTo(Account account)
    {
        return this.accountName.compareTo(account.accountName);
    }

    public String getAccountName() { return this.accountName; }
    public String getDescription() { return this.description; }
    public ArrayList<Post> getPosts() { return posts; }

    public String toString()
    {
        return String.format(this.accountName, this.description, "Name:%n%s%nDescription:%n%s");
    }
}