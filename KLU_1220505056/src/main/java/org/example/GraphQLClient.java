package org.example;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import okhttp3.*;

import java.io.IOException;
import java.util.Objects;

public class GraphQLClient {

    /*
    https://www.google.com/search endpointine hello query si göndermek istedim fakat galiba google graphql sunucusu değil.
    Bu yüzden loglarda 405 response code unu görüyorum.
    Method Not Allowed
     */
    private static final String GRAPHQL_ENDPOINT = "https://www.google.com/search";

    public static void main(String[] args) {
        String sampleQuery = "{ \"query\": \"{ hello }\" }";
        executeGraphQLQuery(sampleQuery);
    }

    public static void executeGraphQLQuery(String query) {
        OkHttpClient client = new OkHttpClient();

        // GraphQL isteği oluştur
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), "{\"query\":\"" + query + "\"}");

        Request request = new Request.Builder()
                .url(GRAPHQL_ENDPOINT)
                .addHeader("Content-Type", "application/json")
                .post(requestBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            // Response'ı yazdır
            if (response.isSuccessful()) {
                System.out.println("Response: " + Objects.requireNonNull(response.body()).string());
            } else {
                System.out.println("Error: " + response.code() + " - " + response.message());
            }
            //hataları yazdır.
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}