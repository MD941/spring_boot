package algebra.spring_boot.article;

import algebra.spring_boot.category.Category;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleRowMapper implements RowMapper<Article> {
    @Override
    public Article mapRow(ResultSet rs, int rowNum) throws SQLException {

        Integer id = rs.getInt("Id");
        String name = rs.getString("name");
        String description = rs.getString("description");
        BigDecimal price = rs.getBigDecimal("price");
        Integer categoryId = rs.getInt("category_id");
        String categoryName = rs.getString("categoryName");
        String categoryDescription = rs.getString("categoryDescription");

        Category category = new Category(categoryId, categoryName, categoryDescription);

        return new Article(id, name, description, price, category);
    }
}