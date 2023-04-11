public class Post
{
    private String title, video;
    private int likes;

    public Post(String title, String video)
    {
        this.title = title;
        this.video = video;
        likes = 0;
    }

    public int getLikes() { return likes; }

    public String toString()
    {
        return String.format(title, video, likes, "Title: %s%nVideo: %s%nNumber of likes: %d");
    }
}