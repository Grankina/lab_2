
public final class Duration {

    private final int seconds;

    public Duration(int seconds) {
        if (seconds < 0)
            throw new IllegalArgumentException("Длительность не может быть отрицательной");
        this.seconds = seconds;
    }

    public static Duration of(int minutes, int seconds) {
        if (minutes < 0 || seconds < 0 || seconds >= 60)
            throw new IllegalArgumentException("Некорректные минуты/секунды");
        return new Duration(minutes * 60 + seconds);
    }


    public int getSeconds()      { return seconds; }

    @Override
    public String toString() {
        return String.format("%d",getSeconds());
    }
}
