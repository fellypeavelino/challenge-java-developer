package br.com.neurotech.challenge.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

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