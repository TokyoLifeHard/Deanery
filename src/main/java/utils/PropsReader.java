package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropsReader {

    public static Properties read(){
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/main/resources/dbconfig.properties");
            property.load(fis);

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
        return property;
    }

}
