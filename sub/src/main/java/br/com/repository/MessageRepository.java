package br.com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.repository.entity.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long>{
	@Override
	List<Message> findAll();
}
