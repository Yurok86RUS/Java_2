package Marathon;

public class Team {

    public String nameComand;

    Competitor[] competitors = {new Cat("Cat"), new Dog("Dog"), new Human("Gary"), new Mouse("Mouse")};

    public Team(String nameComand) {
        this.nameComand = nameComand;
    }


    public void getComand(){
        System.out.println("Состав команды " + nameComand + ":");
        for (Competitor c : competitors){
            c.info();
        }
    }
}
