package br.com;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

@SpringBootApplication
public class Sub {
	public static void main(String[] args) {
		SpringApplication.run(Sub.class, args);
	}
	
	@Bean
	public TaskScheduler taskScheduler() {
		return new ConcurrentTaskScheduler();
	}

	@Bean
	public Executor taskExecutor() {
		return new SimpleAsyncTaskExecutor();
	}
}
