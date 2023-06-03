package anyrwrtest.entities;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;


@Entity
//if @Data doenot work we have to add setters and getters manually
@Data


public class Teacher {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public long teacherId;

    public String firstname;
    public String lastname;
   

    @OneToOne
	@JoinColumn(name = "class_id", referencedColumnName = "classId")
	@JsonInclude(JsonInclude.Include.ALWAYS)
    public Lecture lecture;

}