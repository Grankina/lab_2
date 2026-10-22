import java.util.List;

public abstract class MediaItem {
    private final Medium medium;
    private final AccessLevel accessLevel;
    private final AgeRating ageRating;
    private final String title;
    private int playCount;

    protected MediaItem(String title, Medium medium,AccessLevel  accessLevel,AgeRating ageRating) {
        if (title == null) throw new IllegalArgumentException();
        this.title = title;
        this.medium=medium;
        this.accessLevel=accessLevel;
        this.ageRating=ageRating;
    }

    public final boolean CanBePlayed(User user){
        return accessLevel.allows(user)&& ageRating.allows(user);
    }
    public final void play(User user) {
        if(!CanBePlayed(user)) {// final: учёт прослушиваний единый
            throw new IllegalArgumentException("Нет доступа!");
        }
        playCount++;
        startPlayback();// различие — в наследнике
    }

    public final int getPlayCount() {
        return playCount;
    }
    public String getTitle(){return title;}
    public void getListening(){System.out.printf("Count of listening %d\n",getPlayCount());};

    protected abstract void startPlayback();
    public abstract int getDuration();


}
