package functions;

import io.quarkus.funqy.Funq;
import io.quarkus.funqy.knative.events.CloudEvent;
import io.quarkus.funqy.knative.events.CloudEventBuilder;

import org.jboss.logging.Logger;

/**
 * Your Function class
 */
public class Function {

    private static final Logger log = Logger.getLogger(Function.class);

    /**
     * Use the Quarkus Funq extension for the function. This example
     * function simply echoes its input data.
     * @param input a CloudEvent
     * @return a CloudEvent
     */
    @Funq
    public CloudEvent<Output> function(CloudEvent<Input> input) {

        // Add your business logic here

        //System.out.println(input);
        log.info(input);
        Output output = new Output(input.data().getMessage());
        return CloudEventBuilder.create().build(output);
    }

}
