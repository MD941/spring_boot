package algebra.spring_boot.article;


import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleRowMapper implements RowMapper {
    @Override
    public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
        Integer id = rs.getInt("Id");
        String name = rs.getString("name");
        String description = rs.getString("description");
        BigDecimal price = rs.getBigDecimal("price");
        Integer categoryId = rs.getInt("categoryId");

        return new Article(id, name, description, price);
    }
}
