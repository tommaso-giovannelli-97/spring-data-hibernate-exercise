package com.bitrock.springdataproject.dtos;


import com.bitrock.springdataproject.entities.ProjectSkill;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectSkillDto {
    private Long projectId;
    private Long skillId;

    public static ProjectSkillDto of(ProjectSkill projectSkill) {
        return new ProjectSkillDto(projectSkill.getProject().getId(), projectSkill.getSkill().getId());
    }

    @Override
    public String toString() {
        return "ProjectSkillDto{" +
                "projectId=" + projectId +
                ", skillId=" + skillId +
                '}';
    }
}
