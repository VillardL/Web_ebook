package com.villardl.ebookrealb.repository;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.villardl.ebookrealb.entity.User;
import java.util.List;
@Component
public interface UserDao extends JpaRepository<User, Long> {
//User findByNameAndPassword(String name,String password);
//String addUser(User user);
//void save(User user);
  public User findByNameAndPassword(String name,String password);
  public User findByName(String name);
  public List<User>findByType(Integer type);
//  @Select("select name from user where name=#{name} and password=#{password}")
//public String login(@Param("name") String name, @Param("password") String password);
}

