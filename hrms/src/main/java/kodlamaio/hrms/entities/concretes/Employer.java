package kodlamaio.hrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor

@Data
@Entity
@Table(name = "employers")
public class Employer  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "userid")
    private int userid;

    @Column(name = "companyname")
    private String companyname;

    @Column(name = "website")
    private String website;

    @Column(name = "phonenumber")
    private String phonenumber;

    @Column(name = "email")
    private String email;

}
