package CS_3700;


public class Main {

    public static void main(String[] args) {
        Main greeter = new Main();
        Greeting helloWorldGreeting = new HelloWorldGreeting();
        greeter.greet(helloWorldGreeting);

        Greeting myLambdaFunction = () -> System.out.println("Hello world!");

    }

    public void greet(Greeting greeting) {
        greeting.perform();
    }
}
