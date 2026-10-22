public class User {
    private boolean premium;
    private int age;
    User(boolean premium, int age){
        if(age<0){
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }


        this.premium=premium;
        this.age=age;


    }
    boolean isPremium(){ return premium;}
    int getAge(){return age;}
}
