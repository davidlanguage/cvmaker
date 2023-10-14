package cvmaker.app.summary;

import cvmaker.app.userdata.UserDataEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "summary", uniqueConstraints = {@UniqueConstraint(columnNames = {"summary"})})
public class SummaryEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "summary")
    private String summaryDescription;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id",referencedColumnName = "id")
    private UserDataEntity userDataEntity;

}
