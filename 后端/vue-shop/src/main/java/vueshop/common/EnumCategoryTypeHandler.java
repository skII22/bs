package vueshop.common;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import vueshop.common.EnumCategory;

@MappedTypes(EnumCategory.class)
@MappedJdbcTypes(JdbcType.INTEGER)
public class EnumCategoryTypeHandler extends BaseTypeHandler<EnumCategory> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, EnumCategory parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setInt(i, parameter.getValue());
    }

    @Override
    public EnumCategory getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int value = rs.getInt(columnName);
        if (rs.wasNull()) {
            return null;
        } else {
            return EnumCategory.fromValue(value);
        }
    }

    @Override
    public EnumCategory getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int value = rs.getInt(columnIndex);
        if (rs.wasNull()) {
            return null;
        } else {
            return EnumCategory.fromValue(value);
        }
    }

    @Override
    public EnumCategory getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int value = cs.getInt(columnIndex);
        if (cs.wasNull()) {
            return null;
        } else {
            return EnumCategory.fromValue(value);
        }
    }

}
