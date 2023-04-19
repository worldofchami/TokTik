package src;

/**
 * Creates a new Post that belongs to a particular Account
 */

public class Post
{
    private String title, video;
    private int likes;
    private boolean postLiked;

    /**
     * Creates a new Post object
     */
    public Post(String title, String video, int likes)
    {
        this.title = title;
        this.video = video;
        this.likes = likes;
        this.postLiked = false;
    }

    /**
     * Get method for likes
     * @return this posts's likes
     */
    public int getLikes() { return likes; }

    /**
     * Lets a user like this post
     */
    public void like()
    {
        if(!postLiked)
        {
            postLiked = true;
            likes++;
        }
    }

    /**
     * Lets a user unlike this post
     */
    public void unlike()
    {
        if(postLiked)
        {
            postLiked = false;
            likes--;
        }
    }

    /**
     * Get method for postLiked
     * @return boolean value that states whether a post is liked or not
     */
    public boolean isLiked() { return postLiked; }

    /**
     * Post object toString
     * @return this posts's details neatly formatted
     */
    public String toString()
    {
        return String.format("Title: %s%nVideo: %s%nNumber of likes: %s", title, video, Integer.toString(likes));
    }
}