interface test
{
	void automation();
}
public class LambdaExample {
    public static void main(String[] args) {

        // Traditional way using anonymous class
        test t = new test() {
            public void automation() {
                System.out.println("Running with anonymous class");
            }
        };
        t.automation();

        // Lambda expression way (Java 8+)
      //  Runnable r2 = () -> System.out.println("Running with lambda");
        t.automation();
    }
}



