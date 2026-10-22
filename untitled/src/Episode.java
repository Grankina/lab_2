public class Episode {
    private final String title;
    private final Duration duration;
    public Episode(String title,int duration){
        if (title == null) {
            throw new IllegalArgumentException("Название не может быть пустым");
        }
        if (duration<0) {
            throw new IllegalArgumentException("Длительность не может быть меньше нуля");
        }
        this.title=title;
        this.duration = new Duration(duration);

    }
    public String getTitle(){ return title;}
    public int getDuration() { return duration.getSeconds(); }



}
