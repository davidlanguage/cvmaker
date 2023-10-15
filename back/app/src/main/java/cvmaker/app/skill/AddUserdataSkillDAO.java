package cvmaker.app.skill;

import cvmaker.app.userdata.UserData;

public interface AddUserdataSkillDAO {

    void addSkill(final Skill skill, final UserData userdata);
}
