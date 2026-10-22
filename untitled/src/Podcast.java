import java.util.ArrayList;
import java.util.List;

public class Podcast extends MediaItem{
    private final String title;
    private Duration duration;
    private final Medium medium;
    private final AccessLevel accessLevel;
    private final AgeRating ageRating;
    private List<Episode> episodes= new ArrayList<>();
    public Podcast(String title,Medium medium, AccessLevel accessLevel,AgeRating ageRating){
        super(title,medium,accessLevel,ageRating);
        if (title.isEmpty()){
            throw new IllegalArgumentException("Автор не может быть пустым");
        }
        if (episodes==null){
            throw new IllegalArgumentException("Автор не может быть пустым");
        }
        this.title=title;

        this.medium=medium;
        this.accessLevel=accessLevel;
        this.ageRating=ageRating;

    }

    public String getTitle() {
        return title;
    }

    public void addEpisode(String title, int duration){
        episodes.add(new Episode(title,duration));
    }
    @Override protected void startPlayback() {
        System.out.printf("Podcast %s playing\n", getTitle());
        for (Episode e: episodes) {
            System.out.printf("Episode %s playing\n",e.getTitle());
        }
    }
    @Override
    public int getDuration() {
        int sum = 0;
        for (Episode e : episodes) sum += e.getDuration();
        return sum;
    }
}
