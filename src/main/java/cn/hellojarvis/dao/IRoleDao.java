package cn.hellojarvis.dao;

import cn.hellojarvis.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/08 23:13
 */
public interface IRoleDao {
    public List<Role> getAllRole();

    public Role getRoleByName(String roleName);

    public Role getRoleById(Integer roleId);
}
