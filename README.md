# spring-2019
this is a repo prepare-2019's interview



![](doc/spring-redis.md)

## maven 模块说明
```
mvn deploy:deploy-file -DgroupId=com.youclk -DartifactId=utils -Dversion=0.0.1-SNAPSHOT -Dpackaging=jar -Dfile=target/utils-0.0.1-SNAPSHOT.jar -Durl=https://nexus.youclk.com/repository/youclk/ -DrepositoryId=youclk
```

## 运行
- 打包
```aidl


```


- 使用sonar扫描
```
mvn sonar:sonar   -Dsonar.projectKey=com.klaus.interview:spring-digger   -Dsonar.host.url=http://fun-nearby:8083   -Dsonar.login=4213b05ea2f6b7864e30a4a6c41c35ad49c92177



```