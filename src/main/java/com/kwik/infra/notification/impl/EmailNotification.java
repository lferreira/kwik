package com.kwik.infra.notification.impl;

import br.com.caelum.vraptor.ioc.Component;

import com.kwik.infra.notification.Notification;
import com.kwik.models.Client;

@Component
public class EmailNotification implements Notification {

	@Override
	public void send(Client client, String newPassword) {
		System.out.println(String.format("Sending e-mail to %s - password %s" ,client.getEmail(), newPassword));
	}

}
