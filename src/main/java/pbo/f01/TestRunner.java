import java.io.*;

public class TestRunner {
    public static void main(String[] args) throws Exception {
        // Redirect stdin from file
        File inputFile = new File(args[0]);
        InputStream input = new FileInputStream(inputFile);
        System.setIn(input);
        
        // Run App
        pbo.f01.App.main(new String[]{});
    }
}
