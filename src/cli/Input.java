package cli;

public class Input {
    private String[] parameters;

    public Input(String[] parameters){
        this.parameters = parameters;
    }

    private String run() {
        return null;
    }

    @Override
    public String toString() {
        return run();
    }
}
