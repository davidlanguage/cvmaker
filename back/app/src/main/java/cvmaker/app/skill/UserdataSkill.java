package cvmaker.app.skill;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserdataSkill {

    private Long id;

    private Long userdataId;

    private Long skillId;
}
