public class Exercise03 {
    //   Если убрать Аннотацию @Override с переопределяемого метода, то программа отработает корректно.
    //   Однако @Override поможет избежать ошибок например при опечатке в названии переопределяемого метода!

// например:

    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.makeSound(); // Вывод: Generic animal sound
    }

}

class Dog extends Animal {
    // Без @Override и с опечаткой
    public void makeSond() {
        System.out.println("Bark!");
    }
}

class Animal {
    public void makeSound() {
        System.out.println("Generic animal sound");
    }
}

//Компилятор не заметит ошибки... и скомпилирует программу
