package dao;
import entity.User;


public interface UserDao {
    int addUser(User user); //新增用户
    User findUser(String u_username,String u_password); //查找用户


}
