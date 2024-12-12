package com.project.called.called.config;

import com.hazelcast.collection.ItemEvent;
import com.hazelcast.collection.ItemListener;

public class HazelcastListner implements ItemListener<Object> {


    @Override
    public void itemAdded(ItemEvent<Object> itemEvent) {
        Object item = itemEvent.getItem();
        System.out.println("Item Listened:::"+item);
    }

    @Override
    public void itemRemoved(ItemEvent<Object> itemEvent) {

    }
}
