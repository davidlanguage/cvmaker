package cvmaker.app.skill;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "skill")
public class SkillEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "skill_name")
    private String skillName;
}
