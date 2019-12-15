package dbflow.google.web.rest;

import dbflow.google.service.DbFlow10GoogleConnectorKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/db-flow-10-google-connector-kafka")
public class DbFlow10GoogleConnectorKafkaResource {

    private final Logger log = LoggerFactory.getLogger(DbFlow10GoogleConnectorKafkaResource.class);

    private DbFlow10GoogleConnectorKafkaProducer kafkaProducer;

    public DbFlow10GoogleConnectorKafkaResource(DbFlow10GoogleConnectorKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
