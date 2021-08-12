package kodlamaio.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor

@Entity

@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
@EqualsAndHashCode(callSuper = false)
@Data
@Table(name="jobs_seekers")
public class JobSeekers extends User {

    @Id
    @GeneratedValue

    @Column(name = "userid")
    private int userid;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "tcno")
    private String tcno;

    @Column(name = "birthdate")
    private int birthdate;

    @JsonInclude
    @Transient
    private String passwordCheck;


}


