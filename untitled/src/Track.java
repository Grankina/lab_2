import java.util.Arrays;

public class Track extends MediaItem
{
    private static int count=0;
    private static final int MAX_DURATION=3600;
    private String song;
    private String singer;
    private final Duration duration;
    private final Medium medium;
    private final AccessLevel accessLevel;
    private final AgeRating ageRating;
    private String[] genres;
    public Track(String song, String singer, int duration, String[] genres,Medium medium, AccessLevel accessLevel,AgeRating ageRating){
        super(song,medium,accessLevel,ageRating);
        if (duration<0){
            throw new IllegalArgumentException("Длительность <= 0");
        }
        if(song.isEmpty()){
            throw new IllegalArgumentException("Нет названия песни!");
        }
        if(singer==null){
            singer="Undifined";
        }


        this.song=song;
        this.singer=singer;
        this.duration = new Duration(duration);
        this.genres=genres.clone();
        this.medium=medium;
        this.accessLevel=accessLevel;
        this.ageRating=ageRating;

    }

    public String getSong(){return song;}
    public String getSinger(){return singer;}
    @Override public int getDuration(){return duration.getSeconds();}
    @Override protected void startPlayback() {
        System.out.println("Track playing"); }
    public String[] getGenres(){
        return genres.clone();
    }
    @Override
    public String toString() {
        return String.format("Song %s (%s)\nListening %d\nDuration %d seconds",
                song,singer,getPlayCount(),duration.getSeconds());
    }


}

