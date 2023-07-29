package cvmaker.app.userdata;

import org.springframework.stereotype.Component;

@Component
public class UserdataMapper {

    UserData map(final UserDataEntity userdataEntity){
        return UserData.builder()
                .id(userdataEntity.getId())
                .name(userdataEntity.getName())
                .lastname(userdataEntity.getLastname())
                .email(userdataEntity.getEmail())
                .password(userdataEntity.getPassword())
                .build();
    }
    UserDataEntity mapToEntity(final UserData userdata){
        return UserDataEntity.builder()
                .id(userdata.getId())
                .name(userdata.getName())
                .lastname(userdata.getLastname())
                .email(userdata.getEmail())
                .password(userdata.getPassword())
                .build();
    }
}
