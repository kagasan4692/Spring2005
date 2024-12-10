public class exercise03 {

// Преобразовать можно но с ограничениями. Если наследник сначала преобразуется в родителя,
//    а затем родитель обратно преобразуется в наследника.

    public static void main(String[] args) {
//        Parent parent = new Parent(); // Если так... то ошибка: class Parent cannot be cast to class Child
        Parent parent = new Child(); // Если так ... то работает
        parent.speak();

        Child child = (Child) parent;
        child.play();


    }
}

    class Parent {
        void speak() {
            System.out.println("Parent speaking");
        }
    }

    class Child extends Parent {
        void play() {
            System.out.println("Child playing");
        }
    }


