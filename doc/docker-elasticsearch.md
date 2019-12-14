# docker elastic-search

## run docker node
- docker-compose.yml
```
version: '2.2'
services:
  elasticsearch:
    image: bolingcavalry/elasticsearch-with-ik:6.5.0
    container_name: elasticsearch
    environment:
      - cluster.name=local-elastic
      - bootstrap.memory_lock=true
      - http.cors.enabled=true
      - http.cors.allow-origin=*
      - "ES_JAVA_OPTS=-Xms2048m -Xmx2048m"
    ulimits:
      memlock:
        soft: -1
        hard: -1
    volumes:
      - esdata1:/usr/share/elasticsearch/data
    ports:
      - 9200:9200
      - 9300:9300
    networks:
      - esnet
  elasticsearch2:
    image: bolingcavalry/elasticsearch-with-ik:6.5.0
    container_name: elasticsearch2
    environment:
      - cluster.name=local-elastic
      - bootstrap.memory_lock=true
      - http.cors.enabled=true
      - http.cors.allow-origin=*
      - "ES_JAVA_OPTS=-Xms2048m -Xmx2048m"
      - "discovery.zen.ping.unicast.hosts=elasticsearch"
    ulimits:
      memlock:
        soft: -1
        hard: -1
    volumes:
      - esdata2:/usr/share/elasticsearch/data
    networks:
      - esnet
  head:
    image: bolingcavalry/elasticsearch-head:6
    container_name: head
    ports:
      - 9100:9100
    networks:
      - esnet
volumes:
  esdata1:
    driver: local
  esdata2:
    driver: local

networks:
  esnet:



```


## test
- normal test command
```

curl http://localhost:9200/_search



```

## 技术趋势
```
随着es的版本越来越高, 会逐步的取消基于tcp协议的TransportClient, 
取而代之的是只提供RestClient对es进行数据操作,因此技术层面应该考虑弃用tcp 客户端
```


## 数据类型测试

```
es 支持的数据类型,有什么特性,适合那些业务场景使用
1. text
2. keyword
3. long
4. double



```

## 常见的业务场景
```
1. 分词
2. 标签
3. 打分

```
