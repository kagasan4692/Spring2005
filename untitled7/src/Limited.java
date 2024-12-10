public class Limited extends Awesome{
    int limit;
    Limited(int inputLimit){
//        super("Super string");
        this.limit = inputLimit;
    }

    Limited(int inputLimit, String inputString){
//        super("Super string");
        this.limit = inputLimit;
        this.string = inputString;
    }

    Limited(int inputLimit, int inputInt){
//        super(50);
        this.limit = inputLimit;
        this.string = String.valueOf(inputInt);
    }

    public void print () {
        System.out.println(this.limit);
    }
}
