//package com.elastic.data.config;
//
//import co.elastic.clients.elasticsearch.ElasticsearchClient;
//import co.elastic.clients.json.jackson.JacksonJsonpMapper;
//import co.elastic.clients.transport.ElasticsearchTransport;
//import co.elastic.clients.transport.rest_client.RestClientTransport;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//import lombok.Getter;
//import lombok.Setter;
//import org.apache.http.HttpHost;
//import org.apache.http.auth.AuthScope;
//import org.apache.http.auth.UsernamePasswordCredentials;
//import org.apache.http.client.CredentialsProvider;
//import org.apache.http.impl.client.BasicCredentialsProvider;
//import org.elasticsearch.client.RestClient;
//import org.elasticsearch.client.RestClientBuilder;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@ConfigurationProperties("elasticsearchclient")
//@Getter
//@Setter
//public class ElasticsearchJavaClient {
//
//    private String hostName;
//    private Integer port;
//    private String username;
//    private String password;
//
//    @Bean
//    public ElasticsearchClient getElasticSearchJavaApiClient() {
//        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
//        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(username, password));
////        RestClientBuilder builder = RestClient.builder(new HttpHost(hostName, port))
////                .setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder
////                        .setSSLContext(sslContext)
////                        .setDefaultCredentialsProvider(credentialsProvider)
////                        .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE));
//// OR
//        RestClientBuilder builder = RestClient.builder(new HttpHost(hostName, port))
//                .setHttpClientConfigCallback(httpClientBuilder ->  httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider));
//// OR
////        RestClientBuilder builder = RestClient.builder(new HttpHost(hostName, port))
////                .setHttpClientConfigCallback(httpClientBuilder -> {
////                    httpClientBuilder.disableAuthCaching();  //Disable preemptive authentication
////                   return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider)
////                });
//
//        // Create the low-level client
//        RestClient restClient = builder.build();
//        ObjectMapper mapper = new ObjectMapper()
//                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
//                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
//                .registerModule(new JavaTimeModule());
//        // Create the transport with a Jackson mapper
//        ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper(mapper));
//
//        // And create the API client
//        return new ElasticsearchClient(transport);
//    }
//
////    @Bean
////    public RestClient getRestClient() {
////        RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200)).build();
////        return restClient;
////    }
////
////    @Bean
////    public  ElasticsearchTransport getElasticsearchTransport() {
////        return new RestClientTransport(getRestClient(), new JacksonJsonpMapper());
////    }
////
////
////    @Bean
////    public ElasticsearchClient getElasticsearchClient(){
////        return new ElasticsearchClient(getElasticsearchTransport());
////    }
//
////    ObjectMapper objectMapper = new ObjectMapper();
////            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
////            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
////            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
////            objectMapper.registerModule(new JavaTimeModule());
//
//
//}
