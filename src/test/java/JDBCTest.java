import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.Assert.fail;

public class JDBCTest {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void connection() {
        try(Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:orcl", "system", "kimteasu2")) {
            logger.info(conn.toString());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}