package si.fri.rso.katalog_dogodkov.rest;

import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

import javax.enterprise.context.ApplicationScoped;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

@Health
@ApplicationScoped
public class KatalogDogodkovHealth implements HealthCheck {

    private static final String url = "http://localhost:8080/v1/katalog_dogodkov/";

    private static final Logger LOG = Logger.getLogger(KatalogDogodkovHealth.class.getSimpleName());

    public HealthCheckResponse call() {

        try {

            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");

            if (connection.getResponseCode() == 200) {
                return HealthCheckResponse.named(KatalogDogodkovHealth.class.getSimpleName()).up().withData(url, "UP").build();
            }
        }  catch (Exception exception) {
            LOG.severe(exception.getMessage());
        }

        return HealthCheckResponse.named(KatalogDogodkovHealth.class.getSimpleName()).down().withData(url, "DOWN").build();
    }

}

