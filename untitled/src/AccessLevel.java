public interface AccessLevel {
    boolean allows(User user);
}
class FreeAccess implements AccessLevel{
    public boolean allows(User user){
        return true;
    }
}
class PremiumAccess implements AccessLevel{
    public boolean allows(User user){
        return user.isPremium();
    }
}
