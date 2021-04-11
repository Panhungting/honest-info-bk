package jp.co.honest.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import jp.co.honest.domain.Employee;

@Mapper
public interface EmployeeRepository {

    @Select("SELECT "
        + " employee_id, employee_name, gender, address, tel, mail, "
        + " login_id, password, authority, delete_flag, created_at "
        + " FROM employee"
        + " WHERE login_id = #{loginId}"
        + " AND password = #{password}"
        + " AND delete_flag=0 ")
    Optional<Employee> selectByLoginIdAndPassword(String loginId,String password);
    
    @Select("SELECT "
        + " employee_id, employee_name, gender, address, tel, mail, "
        + " login_id, password, authority, delete_flag, created_at "
        + " FROM employee"
        + " WHERE delete_flag=0 ")
    List<Employee> selectAll();

    @Select("SELECT "
        + " count(*) "
        + " FROM employee"
        + " WHERE login_id = #{loginId} "
        + " AND delete_flag=0 ")
    int selectEmployeeCountByLoginId(String loginId);
}