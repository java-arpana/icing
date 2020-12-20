package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Ranjan Mohan
 * @version 1.0.0
 *
 * v1.0.0
 * Added support to convert an InputStream object to a String
 */
public class StreamUtility {

    private static Logger logger = LogManager.getLogger(StreamUtility.class);

    /**
     * Extracts the information from a given InputStream as a string.
     * @param inputStream The InputStream to parse.
     * @return The string extracted from the provided InputStream.
     */
    public static String convertInputStreamToString(InputStream inputStream) {
        String result = null;
        try(InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                result = bufferedReader.lines()
                        .reduce("", (x,y) -> x + "\n" + y)
                        .trim();
        }
        catch (IOException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
        return result;
    }

}
