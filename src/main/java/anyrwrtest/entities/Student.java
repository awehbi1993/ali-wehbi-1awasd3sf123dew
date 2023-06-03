package anyrwrtest.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Entity
//if @Data doenot work we have to add setters and getters manually
@Data
public class Student {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public long studentId;

    public String firstname;
    public String lastname;
   

    @ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_class_id"), name = "class_id", referencedColumnName = "classId")
	@JsonInclude(JsonInclude.Include.ALWAYS)
    public Lecture lecture;

}
