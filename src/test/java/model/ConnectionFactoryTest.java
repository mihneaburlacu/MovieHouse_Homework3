package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionFactoryTest {
    private Connection connection;

    @BeforeEach
    void setUp() {
        connection = ConnectionFactory.getConnection();
    }

    @AfterEach
    void tearDown() {
        ConnectionFactory.close(connection);
    }

    @Test
    void testCreateConnection() {
        Connection conn = ConnectionFactory.createConnection();
        assertNotNull(conn);
    }

    @Test
    void testGetConnection() {
        Connection conn = ConnectionFactory.getConnection();
        assertNotNull(conn);
    }

    @Test
    void testCloseConnection() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        ConnectionFactory.close(conn);
        assertTrue(conn.isClosed());
    }

    @Test
    void testCloseStatement() throws SQLException {
        Statement statement = connection.createStatement();
        ConnectionFactory.close(statement);
        assertTrue(statement.isClosed());
    }

    @Test
    void testCloseResultSet() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM movie");
        ConnectionFactory.close(resultSet);
        assertTrue(resultSet.isClosed());
    }

    @Test
    void testCloseAll() throws SQLException {
        Connection conn = ConnectionFactory.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM movie");
        ConnectionFactory.closeAll(conn, statement, resultSet);
        assertTrue(resultSet.isClosed() && statement.isClosed() && conn.isClosed());
    }
}