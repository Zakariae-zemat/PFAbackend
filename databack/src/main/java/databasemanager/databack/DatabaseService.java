package databasemanager.databack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

import java.util.List;
import java.util.Map;

@Service
public class DatabaseService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void displayTableContents() {
        String sql = "SELECT * FROM job";

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        for (Map<String, Object> row : rows) {
            System.out.println(row);
        }
    }
}
