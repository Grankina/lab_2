import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
class RandomNoRepeatRule implements SelectionRule {
    private final Random random = new Random();

    public List<MediaItem> order(List<MediaItem> items) {
        List<MediaItem> result = new ArrayList<>(items);   // копия
        Collections.shuffle(result, random);               // перемешали, каждый элемент один раз
        return result;
    }
}