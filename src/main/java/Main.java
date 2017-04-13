import org.flywaydb.core.Flyway;

/**
 * Created by Olechka on 06.04.2017.
 */
public class Main{
    public static void main(String[] args) {
        Flyway flyway = new Flyway ();
        flyway.setDataSource ("jdbc:mysql://localhost:3306/airport?createDatabaseIfNotExist=true","root","123654");
        flyway.migrate ();

    }
    }