

public class RadioStream extends MediaItem{
    private Duration duration;
    private final String title;
    private final Medium medium;
    private final AccessLevel accessLevel;
    private final AgeRating ageRating;
    public RadioStream(String title,Medium medium, AccessLevel accessLevel,AgeRating ageRating){
        super(title,medium,accessLevel,ageRating);
        this.title=title;
        this.medium=medium;
        this.accessLevel=accessLevel;
        this.ageRating=ageRating;
    }
    @Override protected void startPlayback() {
        System.out.println("Radio playing"); }
    @Override public int getDuration() {return 0;}
}
