package cvmaker.app.userdata;

import org.springframework.stereotype.Component;

@Component
public final class UserdataMapper {

    public UserData map(final UserDataEntity userdataEntity){
        return UserData.builder()
                .id(userdataEntity.getId())
                .firstname(userdataEntity.getFirstname())
                .lastname(userdataEntity.getLastname())
                .username(userdataEntity.getUsername())
                .password(userdataEntity.getPassword())
                .country(userdataEntity.getCountry())
                .role(userdataEntity.getRole())
                .build();
    }
    public UserDataEntity mapToEntity(final UserData userdata){
        return UserDataEntity.builder()
                .id(userdata.getId())
                .firstname(userdata.getFirstname())
                .lastname(userdata.getLastname())
                .username(userdata.getUsername())
                .password(userdata.getPassword())
                .country(userdata.getCountry())
                .role(userdata.getRole())
                .build();
    }
}
