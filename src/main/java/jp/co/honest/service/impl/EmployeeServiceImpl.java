package jp.co.honest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.honest.controller.employee.EmployeeForm;
import jp.co.honest.domain.Employee;
import jp.co.honest.repository.EmployeeRepository;
import jp.co.honest.repository.EmployeeSkillRepository;
import jp.co.honest.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeSkillRepository employeeSkillRepository;

    // 社員リストを取得
    @Override
    public List<Employee> getEmployeeList() {
        return employeeRepository.selectAll();
    }

    // 社員個人スキルを取得
    // @Override
    // public List<String> getEmployeeSkills(Integer employeeId) {

    //     return employeeSkillRepository.selectSkillByEmployeeId(employeeId);
    // }

    
    // 社員個人スキルを取得
    @Override
    public List<EmployeeForm> getEmployeeSkills(List<EmployeeForm> employeeFormList) {

        // DBからスキル検索
        String skillAll = "";
        for (int i = 0; i < employeeFormList.size(); i++) {

            // DBから個人スキル検索
            List<String> employeeSkills = employeeSkillRepository
                .selectEmployeeSkillByEmployeeId(employeeFormList.get(i).getEmployeeId());

            // FORMに置く
            if (employeeSkills != null && !employeeSkills.isEmpty()) {

                // ある場合、スキル表示
                skillAll = String.join(",", employeeSkills.toString());
                employeeFormList.get(i).setSkills(
                    skillAll.substring(1, skillAll.length()-1));
            } else {

                // ない場合、未登録表示
                employeeFormList.get(i).setSkills("未登録");
            }
        }

        return employeeFormList;
    }
}