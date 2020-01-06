package com.klaus.interview.springelasticsearch.config;


import org.apache.http.HttpHost;
import org.elasticsearch.client.Node;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//@Configuration
public class EsConfig {




//    @Value("${spring.data.elasticsearch.cluster-nodes}")
//    private String nodes;

//    @Bean
//    RestClient restClient() {
//        List<Node> hostNodes = Arrays.stream(nodes.split(",")).map(i -> {
//            String[] hosts = i.split(":");
//            HttpHost httpHost = new HttpHost(hosts[0], Integer.parseInt(hosts[1]));
//            return new Node(httpHost);
//        }).collect(Collectors.toList());
//        RestClientBuilder restClientBuilder = RestClient.builder(hostNodes.toArray(new Node[hostNodes.size()]));
//        return restClientBuilder.build();
//    }
}
