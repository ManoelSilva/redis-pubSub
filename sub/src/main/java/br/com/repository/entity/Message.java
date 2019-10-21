package br.com.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "messages")
@Data
@ToString
public class Message {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String value;
}
