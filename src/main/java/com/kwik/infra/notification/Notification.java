package com.kwik.infra.notification;

import com.kwik.models.Client;

public interface Notification {

	void send(Client client, String newPassword);

}
