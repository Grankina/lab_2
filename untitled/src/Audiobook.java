public class Audiobook extends MediaItem {
    private int bookmark;
    private final String title;
    private final String author;
    private final Duration duration;
    private final Medium medium;
    private final AccessLevel accessLevel;
    private final AgeRating ageRating;
    public Audiobook(String title,String author, int duration,Medium medium, AccessLevel accessLevel,AgeRating ageRating) {
        super(title,medium,accessLevel,ageRating);
        if (title == null) {
            throw new IllegalArgumentException("Название не может быть пустым");
        }
        if (author == null) {
            throw new IllegalArgumentException("Автор не может быть пустым");
        }
        if (duration <0) {
            throw new IllegalArgumentException("Длительность не может быть меньше нуля");
        }
        this.title=title;
        this.author = author;
        this.duration = new Duration(duration);
        this.medium=medium;
        this.accessLevel=accessLevel;
        this.ageRating=ageRating;

    }

    void addBookmark(User user,int seconds) {
        if (seconds < 0 || seconds > duration.getSeconds()) {
            throw new IllegalArgumentException(
                    "Закладка вне диапазона");
        }
        bookmark = seconds;
        System.out.printf("Закладка добавлена на %d секунде\n",seconds);
    }
    @Override protected void startPlayback() {System.out.printf("Audiobook %s playing",title);}
    @Override
    public String toString() {
        return String.format("Aidiobook %s (%s)\nListening %d\nDuration %d seconds",
                title,author,getPlayCount(),duration.getSeconds());
    }
    @Override public int getDuration(){return duration.getSeconds();}



}
