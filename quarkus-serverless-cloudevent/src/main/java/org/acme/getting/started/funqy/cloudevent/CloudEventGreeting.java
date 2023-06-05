package org.acme.getting.started.funqy.cloudevent;

import io.quarkus.funqy.Funq;
import org.jboss.logging.Logger;

import io.quarkus.funqy.knative.events.CloudEvent;
import io.quarkus.funqy.knative.events.CloudEventBuilder;

public class CloudEventGreeting {
    private static final Logger log = Logger.getLogger(CloudEventGreeting.class);

//    @Funq
//    public void myCloudEventGreeting(Person input) {
//        log.info("Hello " + input.getName());
//    }

    @Funq
    public CloudEvent<Output> myCloudEventGreeting(CloudEvent<Person> input) {
        log.info(input);
        log.info("Hello " + input.data().getName());
        Output output = new Output(input.data().getName());
        return CloudEventBuilder.create().build(output);
    }
}
