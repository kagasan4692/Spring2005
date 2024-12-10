public class Exercise02 {
    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e) {
            printStackTraceTree(e);
        }
    }

    public static void method1() {
        method2();
    }

    public static void method2() {
        method3();
    }

    public static void method3() {
        throw new RuntimeException("Intentional exception");
    }

    public static void printStackTraceTree(Throwable throwable) {
        System.out.println("Exception: " + throwable);
        StackTraceElement[] stackTrace = throwable.getStackTrace();

        System.out.println("Stack trace tree:");
        for (int i = 0; i < stackTrace.length; i++) {

            System.out.println("* " + stackTrace[i].getClassName() + "." + stackTrace[i].getMethodName()
                    + " (" + stackTrace[i].getFileName() + ":" + stackTrace[i].getLineNumber() + ")");
        }
    }
}
