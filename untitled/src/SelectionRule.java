import java.util.List;

public interface SelectionRule {
    List<MediaItem> order(List<MediaItem> items);
}
