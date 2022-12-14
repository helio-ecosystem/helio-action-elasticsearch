package helio.actions.database.controller;

import helio.actions.database.exceptions.ElasticsearchConfigurationException;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * A class for validating Elasticsearch parameters provided in the configuration.
 *
 * @author Emilio Crespo Perán
 */
public class ElasticsearchValidationParameterController {

    public static void operation(String value) throws ElasticsearchConfigurationException {
        try {
            empty(value);
        }
        catch (ElasticsearchConfigurationException e) {
            throw new ElasticsearchConfigurationException("Operation cannot be empty");
        }

        if (!value.equalsIgnoreCase("query")
        && !value.equalsIgnoreCase("create")
        && !value.equalsIgnoreCase("update")
        && !value.equalsIgnoreCase("delete")) {
            throw new ElasticsearchConfigurationException("Operation not implemented");
        }
    }

    public static void host(String value) throws ElasticsearchConfigurationException {
        try {
            empty(value);
            new URL(value);
        }
        catch (ElasticsearchConfigurationException e) {
            throw new ElasticsearchConfigurationException("Host cannot be empty");
        }
        catch (MalformedURLException e) {
            throw new ElasticsearchConfigurationException("Malformed host value");
        }
    }

    public static void index(String value) throws ElasticsearchConfigurationException {
        try {
            empty(value);
        }
        catch (ElasticsearchConfigurationException e) {
            throw new ElasticsearchConfigurationException("Index cannot be empty");
        }
    }

    public static void data(String operation, String value) throws ElasticsearchConfigurationException {
        if (!operation.equalsIgnoreCase("delete")) {
            empty(value);
        }
    }

    public static void empty(String value) throws ElasticsearchConfigurationException {
        if (value == null || value.isBlank()) {
            throw new ElasticsearchConfigurationException("Value is empty");
        }
    }

}
