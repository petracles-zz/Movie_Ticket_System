import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

/**
 * Class designed to take a file path given, read/buffer, and return an
 * ArrayList<String> where each index is a line of the file.
 * 
 * @author Jack
 * @version 12/4/2013
 */
public class FileRead {

    /**
     * FIELDS:
     * 
     * File name as a String.
     */
    private String filePath;

    /**
     * Constructor:
     * 
     * @param fileName
     *            File name as a String.
     */
    public FileRead(String fileName) {
        this.filePath = fileName;
    }

    /**
     * METHOS:
     * 
     * Opens the file.
     * 
     * @return ArrayList<String> where each index is a line of the file.
     * @throws IOException
     *             Thrown if failed.
     */
    public ArrayList<String> openFile() throws IOException {
        FileReader fr = new FileReader(filePath);
        BufferedReader reader = new BufferedReader(fr);

        int numOfLines = readLines();
        ArrayList<String> arOfStrings = new ArrayList<String>(numOfLines);

        for (int i = 0; i < numOfLines; i++) {
            arOfStrings.add(reader.readLine());
        }
        reader.close();

        return arOfStrings;
    }

    /**
     * Reads each line of the file.
     * 
     * @return an int.
     * @throws IOException
     *             Thrown if failed.
     */
    public int readLines() throws IOException {
        FileReader fr = new FileReader(filePath);
        BufferedReader reader = new BufferedReader(fr);

        @SuppressWarnings("unused")
        String line;
        int numOfLines = 0;

        while ((line = reader.readLine()) != null) {
            numOfLines++;
        }
        reader.close();

        return numOfLines;
    }
}
