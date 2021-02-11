import com.github.jknack.handlebars.Handlebars;
import org.sql2o.*;
import java.net.URI;
import java.net.URISyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Database {
    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "wecode", "12345");
//private static URI dbUri;
//    public static Sql2o sql2o;
//    Logger logger = LoggerFactory.getLogger(Database.class);
//
//    static {
//
//        try {
//            if (System.getenv("DATABASE_URL") == null) {
//                dbUri = new URI("postgres://localhost:5432/to_do");
//            } else {
//                dbUri = new URI(System.getenv("DATABASE_URL"));
//            }
//            int port = dbUri.getPort();
//            String host = dbUri.getHost();
//            String path = dbUri.getPath();
//            String username = (dbUri.getUserInfo() == null) ? null : dbUri.getUserInfo().split(":")[0];
//            String password = (dbUri.getUserInfo() == null) ? null : dbUri.getUserInfo().split(":")[1];
//            sql2o = new Sql2o("jdbc:postgresql://" + host + ":" + port + path, username, password);
//        } catch (URISyntaxException e ) {
//            logger.error("Unable to connect to database.");
//        }
//    }
}
