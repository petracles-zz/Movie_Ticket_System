import java.io.IOException;
import java.util.ArrayList;

import tester.*;

/**
 * Testing FileRead methods
 * 
 * @author Jack
 * @version 12/4/2013
 */
public class FileReadTest {
    
    /**
     * Instance of FileRead
     */
    FileRead fr = new FileRead("orders.txt");
    
    /**
     * ArrayList for tests.
     */
    ArrayList<String> arr = new ArrayList<String>();
    
    /**
     * Testing for FileRead
     * 
     * @param t Tester
     * @throws IOException 
     */
    void testFileReadMethods(Tester t) throws IOException {
        t.checkExpect(fr.readLines() == 8, true);
        t.checkExpect(fr.openFile().equals(arr), false);
    }
}
