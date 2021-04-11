package jp.co.honest.service;

import java.util.List;

import jp.co.honest.controller.employee.EmployeeForm;
import jp.co.honest.domain.Employee;

/*
 * 社員管理に関するサービスを提供するクラス
 */
public interface EmployeeService {

    /**
     * すべての社員を取得
     *
     * @return 社員リスト
     */
    List<Employee> getEmployeeList();

    /**
     * 社員個人社員を取得
     *
     * @return List<EmployeeForm> スキル文字列（A,B,...）
     */
    List<EmployeeForm> getEmployeeSkills(List<EmployeeForm> employeeFormList);
}