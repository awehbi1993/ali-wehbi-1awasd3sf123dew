package anyrwrtest.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Lecture {
	  @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	    public long classId;

	    public String className;

}
