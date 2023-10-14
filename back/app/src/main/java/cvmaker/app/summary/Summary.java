package cvmaker.app.summary;

import cvmaker.app.userdata.UserData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Summary {

    private Long id;

    private String summaryDescription;

    private UserData userData;
}
