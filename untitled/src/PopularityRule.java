import java.util.ArrayList;
import java.util.List;

public class PopularityRule implements SelectionRule{
    public List<MediaItem> order(List<MediaItem> items){
        List<MediaItem> result = new ArrayList<>(items);   // копия, исходный список не трогаем

        result.sort((a, b) -> b.getPlayCount() - a.getPlayCount());
        // если у b прослушиваний больше, он встаёт раньше: сначала самые популярные

        return result;
    }
}
