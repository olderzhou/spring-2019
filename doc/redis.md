# redis 最佳实践

本文将是我从业多年来学到的redis之精华，现总结如下以供日后参考回味
更多精彩请关注如下链接

- [Redis 命令参考](http://doc.redisfans.com/)

## redis运维需求
- 部署单节点
```
本文只提供docker版本安装部署，参考如下
1. pull镜像
> docker pull redis:5.0.0
2. 运行镜像
> docker run --name redids-local-single -p 6379:76379 -d redis
3. 查看示例运行情况
> docker ps | grep redis 
> docker logs -f redis-local-single
linux环境
> docker exec -it r redis-local-single redis-cli
win 10 环境
> winpty docker exec -it r redis-local-single redis-cli

 
```

- 部署集群
```






```


- 高可用
```



```
- 备份机制



## redis数据结构
- string
```
> winpty docker exec -it redis-local-single redis-cli
> keys *
> set name "klaus"
> get name

```


- hash
- set
- zset

## redis常用命令
```




```

## redis 常用业务使用场景

## redis cache

