package cvmaker.app.skill;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cvmaker.app.userdata.UserData;
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

    @Id
    @Column(name = "id")
    private Long id;

    @OneToOne(targetEntity = UserDataEntity.class)
    @JoinColumn(name = "userdata_id", referencedColumnName = "id")
    private UserDataEntity userdataId;

    @ManyToOne(targetEntity = SkillEntity.class)
    @JsonIgnore
    @JoinColumn(name = "skill", referencedColumnName = "id")
    private List<SkillEntity> skillId;
}
