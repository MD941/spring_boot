package algebra.spring_boot.category;

import algebra.spring_boot.article.Article;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper implements RowMapper<Category> {

    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        Integer id = rs.getInt("Id");
        String name = rs.getString("name");
        String description = rs.getString("description");

        Category category = new Category(id, name, description);

        return category;
    }
}