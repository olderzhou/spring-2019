## docker run local

```$xslt
docker run --name local-nginx -p 8080:80 nginx -d


```

## init local-nginx
```
winpty docker exec -it local-nginx bash
apt-get update
apt-get upgrade
apt-get install vim -y
apt-get curl vim -y




```

## manage nginx's config

- add conf file for you service
```$xslt
cd /etc/nginx/conf.d

1. cp default.conf spring-redis.conf
2. copy below's configuration content to spring-redis.conf

server spring-redis {
    
}








```