public class Post
{
    private String title, video;
    private int likes;

    public Post(String title)
    {
        this.title = title;
        // Add logic to keep track of number of posts
        // Set video = "video{count}.mpg"
    }

    public int getLikes() {return likes;}
}