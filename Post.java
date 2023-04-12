public class Post
{
    private String title, video;
    private int likes;

    public Post(String title, String video, int likes)
    {
        this.title = title;
        this.video = video;
        this.likes = likes;
    }

    public int getLikes() { return likes; }

    public String toString()
    {
        return "Title: " + title + "\nVideo: " + video + "\nNumber of likes: " + likes;
        // return String.format(title, video, likes, "Title: %s%nVideo: %s%nNumber of likes: %d");
    }
}