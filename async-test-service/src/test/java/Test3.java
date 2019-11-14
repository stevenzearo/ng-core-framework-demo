import core.framework.util.Properties;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

/**
 * @author steve
 */
public class Test3 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load("test.properties");

        Optional<String> aDefault = properties.get("default");
        System.out.println(aDefault.get());
        System.out.println("hello".hashCode());
        System.out.println(2/3);
    }
}
