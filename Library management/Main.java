package library;


import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        input.addFirstBook();
        try {
            input.getIn();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
