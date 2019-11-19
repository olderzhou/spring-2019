## docker local running
```

 docker run -d --restart=always -p 8081:8081 --name local-nexus -e NEXUS_CONTEXT=nexus sonatype/nexus3


```


## issues

```
1. 401 unautorized
在setting.xml添加全局认证密码
<server>
    <id>local-nexus</id>   
    <username>admin</username>
    <password>admin</password>  
</server>

2. 400 

需要在控制台配置release仓库的deploy policy开启redeploy

```