package cli;

public class App {
    public static void main(String[] args) {
        Parser parser = new Parser();
        Input input = parser.parse(args);
        System.out.println(input);
    }
}
