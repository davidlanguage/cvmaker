package cvmaker.app.skill;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cvmaker.app.userdata.UserDataEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "userdata_skill")
public class UserdataSkillEntity {


    //TODO: try to add just Long values for userdataId and skillId, so that I can add skills for a given user using the ids
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = UserDataEntity.class)
    @JoinColumn(name = "userdata_id", referencedColumnName = "id")
    private UserDataEntity userdataId;

    @ManyToOne(targetEntity = SkillEntity.class)
    @JsonIgnore
    @JoinColumn(name = "skill", referencedColumnName = "id")
    private List<SkillEntity> skillId;
}
