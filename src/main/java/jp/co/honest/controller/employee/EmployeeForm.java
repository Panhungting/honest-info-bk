package jp.co.honest.controller.employee;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeForm implements Serializable{
    
    private static final long serialVersionUID = 1L;

    // 以下一覧機能用
    private Integer employeeId;
    private String employeeName;
    private Integer gender;
    private String skills;

    // 以下登録機能用
    private String address;
    private String tel;
    private String mail;
    private String loginId;
    private String password;
    private Integer authority;
    private Integer deleteFlag;
    private String createdAt;

}