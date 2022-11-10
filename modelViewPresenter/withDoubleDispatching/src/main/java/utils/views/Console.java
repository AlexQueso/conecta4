package utils.views;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Console {
    private static Console instance = new Console();

    public static Console getInstance() {
        return instance;
    }

    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public String readString(String title) {
        String input = null;
        write(title);
        try {
            input = bufferedReader.readLine();
        } catch (Exception ignored) {
        }
        return input;
    }

    public int readInt(String title) {
        int input = 0;
        boolean ok = false;
        do {
            try {
                input = Integer.parseInt(readString(title));
                ok = true;
            } catch (Exception ex) {
                writeError("integer");
            }
        } while (!ok);
        return input;
    }

    public void write(String string) {
        System.out.print(string);
    }

    public void writeln() {
        System.out.println();
    }

    public void writeln(String string) {
        write(string);
        writeln();
    }

    public void writeError(String format) {
        write("FORMAT ERROR! Enter a " + format + " formatted value.");
        writeln();
    }
}
