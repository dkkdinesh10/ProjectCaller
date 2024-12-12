package com.project.called.called.config;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.collection.IQueue;
import com.hazelcast.core.HazelcastInstance;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class HazelcastConfig {
    private static HazelcastInstance client;

    @PostConstruct
    private void getHazelcastConnection(){
        ClientConfig config=new ClientConfig();
        config.setClusterName("dev-testing");
        config.getNetworkConfig().addAddress("127.0.0.1:5701");
        client= HazelcastClient.newHazelcastClient(config);
        IQueue<Object> queue = client.getQueue("my-queue");
        queue.addItemListener(new HazelcastListner(),true);

    }

    public static HazelcastInstance getClient(){
        return client;
    }
}
