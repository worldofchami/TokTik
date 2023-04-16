package src;
public class Post
{
    private String title, video;
    private int likes;
    private boolean liked;

    public Post(String title, String video, int likes)
    {
        this.title = title;
        this.video = video;
        this.likes = likes;
    }

    public int getLikes() { return likes; }

    public void like()
    {
        if(!liked)
            liked = true;
            likes++;
    }

    public void unlike()
    {
        if(liked)
            liked = false;
            likes--;
    }

    public boolean isLiked() { return liked; }

    public String toString()
    {
        return "Title: " + title + "\nVideo: " + video + "\nNumber of likes: " + likes;
        // return String.format(title, video, likes, "Title: %s%nVideo: %s%nNumber of likes: %d");
    }
}