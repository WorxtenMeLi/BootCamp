package PracticaIntegradora;

import java.lang.Class;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.File;
public class MiFactory {
    public static Object getInstance(String objName) throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream(new File("MiFactory.properties")));
        Sorter sorter = (Sorter) Class.forName(prop.getProperty(objName)).getDeclaredConstructor().newInstance();
        return sorter;
    }
}
