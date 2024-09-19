package org.example;

import org.example.JavaClassForDbScript.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    public List<MaxSalaryWorker> printMaxSalaruWorker() throws IOException, SQLException {
        List<MaxSalaryWorker> maxSalaryWorkersList = new ArrayList<>();
        Connection conn = Databese.getConnection();
        ResultSet resultSet =  getResutSet(conn, getScript("find_max_salary_worker.sql"));
        while (resultSet.next()) {
            maxSalaryWorkersList.add(new MaxSalaryWorker(
                    resultSet.getString("NAME"),
                    resultSet.getDouble("SALARY")));
        }
        return maxSalaryWorkersList;
    }
    public List<ProjectPrices> printProjectPrise() throws IOException, SQLException {
        List<ProjectPrices> projectPricesList = new ArrayList<>();
        Connection conn = Databese.getConnection();
        ResultSet resultSet = getResutSet(conn, getScript("print_project_prices.sql"));
        while (resultSet.next()) {
            projectPricesList.add(new ProjectPrices(
                    resultSet.getInt("project1"),
                    resultSet.getDouble("project_cost")));
        }
        return projectPricesList;
    }
    public List<YoungestEldestWorkers> printYoungestEldestWorker() throws IOException, SQLException {
        List<YoungestEldestWorkers> youngestEldestWorkersList = new ArrayList<>();
        Connection conn = Databese.getConnection();
        ResultSet resultSet = getResutSet(conn, getScript("find_youngest_eldest_workers.sql"));
        while (resultSet.next()){
            youngestEldestWorkersList.add(new YoungestEldestWorkers(
                    resultSet.getString("TYPE"),
                    resultSet.getString("NAME"),
                    resultSet.getString("BIRTHDAY")));
        }
        return youngestEldestWorkersList;
    }
    public List<MaxProjectClients> printMaxProjectsClient()throws IOException, SQLException {
        List<MaxProjectClients> maxProjectClientsList = new ArrayList<>();
        Connection connection = Databese.getConnection();
        ResultSet resultSet = getResutSet(connection, getScript("find_max_projects_client.sql"));
        while (resultSet.next()) {
            maxProjectClientsList.add(new MaxProjectClients(
                    resultSet.getString("NAME"),
                    resultSet.getInt("project_count")
            ));
        }
        return maxProjectClientsList;
    }
    public List<LongestProject> printLongestProject() throws IOException, SQLException {
        List<LongestProject> longestProjectList = new ArrayList<>();
        Connection conn = Databese.getConnection();
        ResultSet resultSet = getResutSet(conn, getScript("find_longest_project.sql"));
        while (resultSet.next()) {
            longestProjectList.add(new LongestProject(
                    resultSet.getInt("ID"),
                    resultSet.getInt("month_count")
            ));
        }
        return longestProjectList;
    }

    public ResultSet getResutSet(Connection conn, String script) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement(getCurrentTable());
            for (String sql : script.split(";")) {
                if (!sql.trim().isEmpty()) {
                  preparedStatement.execute();
                 return preparedStatement.executeQuery(sql);
                }
            }

        return null;
    }


    private static String getScript(String fileName) throws IOException {
        return new String(Files.readAllBytes(Path.of("src/main/java/org/example/utils/" + fileName)));
    }
    private static String getCurrentTable(){
        return "USE megasofttest12;";
    }
}


