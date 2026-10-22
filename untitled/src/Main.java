import java.util.Scanner;
void main() {
    System.out.print("Музыкальный сервис ABOBA MUSIC\n");
    User linka_69=new User(true,20);
    User sanek=new User(false,17);
    Track Ritual=new Track("Rutual","Black Veil Brides",210,new String[]{"rock","punk","metal"},Medium.IOS,new FreeAccess(),new EveryoneRating());
    Track INVISIBLE =new Track("INVISIBLE","Duran Duran",192,new String[]{"electronic","pop","new-wave"},Medium.IOS,new FreeAccess(),new ExplicitRating());
    Track September =new Track("Сентябрь","Stigmata",245,new String[]{"emo-punk","pop-punk","rock"},Medium.ANDROID,new PremiumAccess(),new ExplicitRating());
    Track Ne_boise =new Track("Не бойся ночи","NZRO",190,new String[]{"neiroslop","electronic","pop"},Medium.WINDOWS,new FreeAccess(),new EveryoneRating());
    Track Ya_tebya =new Track("Я тебя могну","ЦУЕФА",180,new String[]{"neiroslop","pop","pfonk"},Medium.ANDROID,new PremiumAccess(),new EveryoneRating());
    System.out.println(Ritual);
    Playlist Like=new Playlist("Liked",6);
    Like.addTrack(Ritual);
    Like.addTrack(INVISIBLE);
    Like.addTrack(September);
    Like.addTrack(Ne_boise);
    Like.addTrack(Ya_tebya);
    System.out.println(Like);
    Audiobook quiet_dans=new Audiobook("Quiet Dan0", "Роман Александрович Мальцев", 90001, Medium.WINDOWS, new FreeAccess(), new EveryoneRating());
    Audiobook quiet_dans1=new Audiobook("Quiet Dan1", "Роман Александрович Мальцев", 90002, Medium.WINDOWS, new FreeAccess(), new EveryoneRating());

    Podcast podcast=new Podcast("Hamster combat", Medium.IOS, new FreeAccess(),new EveryoneRating());
    podcast.addEpisode("Blockcahain",2000);
    podcast.addEpisode("Trump coin",4580);

    Audiobook quiet_dan=new Audiobook("Quiet Dan", "Роман Александрович Мальцев", 9000, Medium.WINDOWS, new FreeAccess(), new EveryoneRating());

    SelectionRule rule;

    RadioStream analog=new RadioStream("Analog",Medium.ANDROID,new FreeAccess(),new EveryoneRating());

    Scanner scanner = new Scanner(System.in);

    try {
        Track test_1 = new Track("Aboba", "aboba", 0, new String[]{"pop"},Medium.ANDROID,new FreeAccess(),new EveryoneRating());
    }catch(IllegalArgumentException err){
        System.out.println("Ошибка!! "+err.getMessage());
    }
    
    try {
        Like.deleteTrack("Гой");

    }catch(IllegalArgumentException err){
        System.out.println("Ошибка!! "+err.getMessage());
    }
    try {
        Track test_2=new Track("","popa",200,new String[]{"pop"}, Medium.ANDROID,new FreeAccess(),new EveryoneRating());

    }catch(IllegalArgumentException err){
        System.out.println("Ошибка!! "+err.getMessage());
    }
    String[] gen=Ne_boise.getGenres();
    gen[0]="89098765";
    gen[1]="fuck";
    System.out.println("Массив жанров (взломанный): "+Arrays.toString(gen));
    System.out.println("Массив жвнров настоящий: "+Arrays.toString(Ne_boise.getGenres()));
    System.out.println("\n\nВторая лаба");
    INVISIBLE.play(linka_69);
    try {
        INVISIBLE.play(sanek);
    }catch(IllegalArgumentException err){
        System.out.println("Ошибка!! "+err.getMessage());
    }
    podcast.play(linka_69);

    quiet_dan.addBookmark(sanek,650);

    analog.play(linka_69);

    INVISIBLE.getListening();
    INVISIBLE.play(linka_69);
    INVISIBLE.getListening();
    System.out.println("Выберите способ воспроизведения: по порядку(1), по популярности(2), перемешать(2)");
    int chose = scanner.nextInt();
    switch (chose) {
        case 1:
            rule = new SequentialRule();
            break;
        case 2:
            rule = new PopularityRule();
            break;
        case 3:
            rule = new RandomNoRepeatRule();
            break;
        default:
            System.out.println("Неверно введённое значение");
            return;
    }

    printOrder(Like.playOrder(rule));





}
static void printOrder(List<MediaItem> items) {
    for (MediaItem item : items) {
        System.out.println("  " + item.getTitle() + " (" + item.getPlayCount() + ")");
    }
}