package src;
public class Post
{
    private String title, video;
    private int likes;
    private boolean postLiked;

    public Post(String title, String video, int likes)
    {
        this.title = title;
        this.video = video;
        this.likes = likes;
    }

    public int getLikes() { return likes; }

    public void like()
    {
        if(!postLiked)
        {
            postLiked = true;
            likes++;
        }
    }

    public void unlike()
    {
        if(postLiked)
        {
            postLiked = false;
            likes--;
        }
    }

    public boolean isLiked() { return postLiked; }

    public String toString()
    {
        return "Title: " + title + "\nVideo: " + video + "\nNumber of likes: " + likes;
        // return String.format(title, video, likes, "Title: %s%nVideo: %s%nNumber of likes: %d");
    }
}