package cn.hellojarvis.service.impl;

import cn.hellojarvis.dao.IRoleDao;
import cn.hellojarvis.entity.Role;
import cn.hellojarvis.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/08 23:17
 */
@Repository("RoleServiceImpl")
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> getAllRole() {
        return roleDao.getAllRole();
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleDao.getRoleByName(roleName);
    }
    @Override
    public Role getRoleById(Integer roleId){
        return roleDao.getRoleById(roleId);
    }
}
