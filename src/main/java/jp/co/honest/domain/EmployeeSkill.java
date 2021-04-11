package jp.co.honest.domain;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeSkill implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private String employeeId; 
    private Integer skillId;
    private Integer level;
    private String createdAt;
}
