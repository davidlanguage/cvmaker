package cvmaker.app.skill;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
//implements AddUserdataSkillDAO
public class AddUserdataUserdataSkillDAOImpl  {

    private final UserdataSkillRepository userdataSkillRepository;

    private final UserdataSkillMapper userdataSkillMapper;

}
