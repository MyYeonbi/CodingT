package poly2;

public class AnimalPolyMain1 {
    public static void main(String[] args) {
        Animal dog = new Dog();
        //Animal은 dog의 부모이므로 이렇게 표기 가능.
        //부모 자식 = new 자식()
        Cat cat = new Cat();
        Caw caw = new Caw();
        Duck duck = new Duck();

        soundAnimal(dog);
        soundAnimal(cat);
        soundAnimal(caw);
        soundAnimal(duck);
    }

    private static void soundAnimal(Animal animal) {
        System.out.println("동물 소리 테스트 시작");
        animal.sound();
        System.out.println("동물 소리 테스트 종료");

    }
}
