package com.bitrock.springdataproject.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeProjectSkillDto {
    private Long projectId;
    private Long employeeId;
    private Long skillId;

    @Override
    public String toString() {
        return "EmployeeProjectSkillDto{" +
                "projectId=" + projectId +
                ", employeeId=" + employeeId +
                ", skillId=" + skillId +
                '}';
    }
}
