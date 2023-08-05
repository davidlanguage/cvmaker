package cvmaker.app.userdata;

import org.springframework.stereotype.Component;

@Component
public class UserdataMapper {

    UserData map(final UserDataEntity userdataEntity){
        return UserData.builder()
                .id(userdataEntity.getId())
                .firstname(userdataEntity.getFirstname())
                .lastname(userdataEntity.getLastname())
                .email(userdataEntity.getEmail())
                .password(userdataEntity.getPassword())
                .build();
    }
    UserDataEntity mapToEntity(final UserData userdata){
        return UserDataEntity.builder()
                .id(userdata.getId())
                .firstname(userdata.getFirstname())
                .lastname(userdata.getLastname())
                .email(userdata.getEmail())
                .password(userdata.getPassword())
                .build();
    }
}
