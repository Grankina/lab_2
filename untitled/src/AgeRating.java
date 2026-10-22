public interface AgeRating {
    boolean allows(User user);
}
class EveryoneRating implements AgeRating{
    public boolean allows(User user){
        return true;
    }
}
class ExplicitRating implements AgeRating{
    public boolean allows(User user){
        if(user.getAge()<18){
            return false;
        }
        return true;
    }
}
