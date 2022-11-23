package polije.ppl.tailor;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        JSONArray jo = new JSONArray("[{\"userId\":\"1\",\"userName\":\"Yasir\"}]");
        Iterator<Object> itr = jo.iterator();

        System.out.println(itr.next());
        System.out.println( "Hello World!" );
    }
}
