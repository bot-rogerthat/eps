package cli;

public class App {
    public static void main(String[] args) {
        Parser parser = new Parser();
        Matrix matrix = parser.parse(args);
        if (matrix != null) {
            Report report = new Report(matrix);
            System.out.println(report);
        }
    }
}
