import java.util.ArrayList;

public class Account
{
    private String accountName, description;
    private ArrayList<Post> posts;

    public Account(String accountName, String description, ArrayList<Post> posts)
    {
        this.accountName = accountName;
        this.description = description;
        posts = null;
    }

    public void addPost(String title)
    {
        Post post = new Post(title);
        posts.add(post);
    }
}