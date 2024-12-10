public class Exercise04 {
    public static void main(String[] args) {
        method1();
    }

    public static void method1() {
        method2();
    }

    public static void method2() {
        method3();
    }

    public static void method3() {
        printCurrentStackTrace();
    }

    public static void printCurrentStackTrace() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        System.out.println("Current Stack Trace:");
        for (int i = 0; i < stackTrace.length; i++) {
            System.out.println("* " + stackTrace[i].getClassName() + "." + stackTrace[i].getMethodName() +
                    " (" + stackTrace[i].getFileName() + ":" + stackTrace[i].getLineNumber() + ")");
        }
    }
}
