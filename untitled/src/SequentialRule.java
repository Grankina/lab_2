import java.util.List;

public class SequentialRule implements SelectionRule{
    public List<MediaItem> order(List<MediaItem> items) {
        return List.copyOf(items);                   // как есть
    }
}
