package br.com.neurotech.challenge.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import lombok.Data;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Data
@Table
public class NeurotechClient implements Serializable {
    
	@Id @GeneratedValue
        private Long id;
	private String name;
	private Integer age;
	private Double income;

}