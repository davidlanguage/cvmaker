package cvmaker.app.skill;

import cvmaker.app.userdata.UserData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserdataSkill {

    private Long id;

    private UserData userdataId;

    private List<Skill> skillId;
}
