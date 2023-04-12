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

    public String getPosts()
    {
        String postsAsStr = "";
        // TODO: find more efficient way to not print last newline char
        if(posts.size() > 0)
        {
            int count = 0;

            for(Post post : posts)
            {
                count++;
                if(count < posts.size())
                {
                    postsAsStr += post.toString() + "\n";
                }

                else
                    postsAsStr += post.toString();
            }

            return postsAsStr;
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

    public String toString()
    {
        return String.format(this.accountName, this.description, "Name:%n%s%nDescription:%n%s");
    }
}