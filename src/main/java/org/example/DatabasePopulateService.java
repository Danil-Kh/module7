package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService
{
    public static void main(String[] args) throws SQLException, IOException {
        String script = getScript();
        try(Connection conn = Databese.getConnection()){
            Statement stmt = conn.createStatement();
            for (String sql : script.split(";")) {
                if (!sql.trim().isEmpty()) {
                    stmt.execute(sql);
                }
            }
        }


    }
    private static String getScript() throws IOException {
        final String script = new String(Files.readAllBytes(Path.of("C:\\Java programs\\module6\\src\\main\\java\\org\\example\\utils\\populate_db.sql")));
        return script;
    }
}

