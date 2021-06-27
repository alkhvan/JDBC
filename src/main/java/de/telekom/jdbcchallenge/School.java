package de.telekom.jdbcchallenge;

import java.sql.Date;
import javax.persistence.*;

@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String schoolName;
    private Date schoolFundationDate;
    private String schoolDirector;
    private boolean certificated;

    public School() {

    }
}

