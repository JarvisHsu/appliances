package cn.hellojarvis.service;

import cn.hellojarvis.entity.Role;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/09 15:32
 */
public interface IRoleService {
    public Role getRoleById(Integer roleId);
    public Role getRoleByName(String roleName);
    public List<Role> getAllRole();
}
