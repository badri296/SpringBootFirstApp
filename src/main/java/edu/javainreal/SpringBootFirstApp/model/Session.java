package edu.javainreal.SpringBootFirstApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name="sessions")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Session {
    public Session(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long session_id;
    private String session_name;
    private String session_description;
    private Integer session_length;
    @ManyToMany
    @JoinTable(
            name="session_speakers",
            joinColumns = @JoinColumn(name="session_id"),
            inverseJoinColumns = @JoinColumn(name="speaker_id")
    )
    private List<Speaker> speakers;
}
