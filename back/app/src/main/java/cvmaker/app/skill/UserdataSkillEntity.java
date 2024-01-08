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

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="userdata_id")
    private Long userdataId;

    @Column(name ="skill_id")
    private Long skillId;
}
