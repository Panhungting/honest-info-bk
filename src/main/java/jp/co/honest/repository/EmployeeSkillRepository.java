package jp.co.honest.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import jp.co.honest.domain.EmployeeSkill;

@Mapper
public interface EmployeeSkillRepository {

    @Select("SELECT "
    + " employee_id, skill_id, level, created_at "
    + " FROM employee_skill "
    + " WHERE employee_id = #{employeeId} ")
    List<EmployeeSkill> selectAllByEmployeeId(Integer employeeId);

    @Select("SELECT "
    + " s.skill "
    + " FROM employee_skill AS es"
    + " LEFT JOIN skill AS s "
    + " ON es.skill_id = s.skill_id "
    + " WHERE employee_id = #{employeeId} ")
    List<String> selectEmployeeSkillByEmployeeId(Integer employeeId);

}