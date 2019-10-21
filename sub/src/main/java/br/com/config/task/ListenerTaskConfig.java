package br.com.config.task;

import java.util.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ListenerTaskConfig implements ApplicationListener<ContextRefreshedEvent> {
	private final SubscriberTask subscriberTask;
	private Timer deamon;

	@Autowired
	public ListenerTaskConfig(SubscriberTask subscriberTask) {
		this.subscriberTask = subscriberTask;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		deamon = new Timer("SubscriberTaskDeamon", true);
		deamon.schedule(subscriberTask, 1000);
	}
}
