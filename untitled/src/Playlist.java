import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Playlist {
    private String name;
    private final int capacity;
    private final List<MediaItem> tracks = new ArrayList<>();

    public Playlist(String name, int capacity) {
        if (name == null) {
            throw new IllegalArgumentException("Сумма < 0");
        }
        if (capacity < 0) {
            throw new IllegalArgumentException("Сумма < 0");
        }
        this.name = name;
        this.capacity=capacity;

    }

    void addTrack(MediaItem t) {
        if (t == null) {
            throw new IllegalArgumentException("Сумма < 0");
        }

        for(MediaItem ex: tracks) {
            if (ex.getTitle().equals(t.getTitle())){
                throw new IllegalArgumentException(
                        "Элемент" + ex.getTitle() + " уже есть в плейлисте");
            }

        }
        tracks.add(t);
    }

    public void deleteTrack(String song) {
        for (int i = 0; i < tracks.size(); i++) {
            if ((tracks.get(i)).getTitle().equals(song)) {
                tracks.remove(i);
                return;



            }

        }
        throw new IllegalArgumentException("Такого трека нет в плейлисте!");
    }

    public int summary() {
        int sum = 0;
        for(MediaItem t: tracks){
            sum+=t.getDuration();
        }
        return sum;
    }
    public int getCount(){
        int count=0;
        for(MediaItem t: tracks){
            count+=1;
        }
        return count;
    }

    public void popular() {
        MediaItem popular=null;
        for(MediaItem t: tracks){
            if(popular == null ||t.getPlayCount()>popular.getPlayCount()){
                popular=t;
            }
        }
       System.out.printf("Most popular song: %s\nCount of listening: %d\n", popular.getTitle(), popular.getPlayCount());
    }
    public List<MediaItem> playOrder(SelectionRule rule) {
        if (rule == null) {
            throw new IllegalArgumentException("Правило не задано");
        }
        return rule.order(tracks);
    }


    @Override
    public String toString() {
        return String.format("Playlist name %s\nCount of tracks %d",
                name,getCount());
    }

}
