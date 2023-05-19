package vueshop.dao.admin;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface orderBackDao {
    List getAll();
}
