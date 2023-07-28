package vueshop.service.user;

import vueshop.common.Result;

import java.util.List;

public interface collectService {
    List getCollect(int userId);
    int addCollect(int userId,int productId);
    Result deleteCollect(int userId,int productId);
    List getCollectsEx(int userId);
}
