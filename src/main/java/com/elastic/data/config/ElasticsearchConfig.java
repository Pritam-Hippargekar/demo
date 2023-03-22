package com.elastic.data.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ElasticsearchConfig {

    @Value("${es.index-name}")
    private String indexName;

    @Value("${es.index-type}")
    private String indexType;

    @Bean
    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    @Bean
    public String getIndexType() {
        return indexType;
    }

    public void setIndexType(String indexType) {
        this.indexType = indexType;
    }
}
