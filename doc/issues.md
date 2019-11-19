## 问题列表



- RedisTemplate执行lua脚本抛出异常IllegalStateException
```
参考文档描述https://cloud.tencent.com/developer/article/1526390
实际原因是由于返回类型不对，导致数据转换异常
ReturnType 的默认值是 ReturnType.STATUS
而ReturnType.INTEGER 对应的是java的LONG类型
```
- java.lang.ArrayStoreException: sun.reflect.annotation.TypeNotPresentExceptionProxy

```
java.lang.ArrayStoreException: sun.reflect.annotation.TypeNotPresentExceptionProxy
	at sun.reflect.annotation.AnnotationParser.parseClassArray(AnnotationParser.java:724) ~[na:1.8.0_131]
	at sun.reflect.annotation.AnnotationParser.parseArray(AnnotationParser.java:531) ~[na:1.8.0_131]
	at sun.reflect.annotation.AnnotationParser.parseMemberValue(AnnotationParser.java:355) ~[na:1.8.0_131]
	at sun.reflect.annotation.AnnotationParser.parseAnnotation2(AnnotationParser.java:286) ~[na:1.8.0_131]
	at sun.reflect.annotation.AnnotationParser.parseAnnotations2(AnnotationParser.java:120) ~[na:1.8.0_131]
	at sun.reflect.annotation.AnnotationParser.parseAnnotations(AnnotationParser.java:72) ~[na:1.8.0_131]
	at java.lang.Class.createAnnotationData(Class.java:3521) ~[na:1.8.0_131]
	at java.lang.Class.annotationData(Class.java:3510) ~[na:1.8.0_131]
	at java.lang.Class.createAnnotationData(Class.java:3526) ~[na:1.8.0_131]
	at java.lang.Class.annotationData(Class.java:3510) ~[na:1.8.0_131]
	at java.lang.Class.getDeclaredAnnotations(Class.java:3477) ~[na:1.8.0_131]
	at org.springframework.core.annotation.AnnotationsScanner.getDeclaredAnnotations(AnnotationsScanner.java:461) ~[spring-core-5.2.0.RELEASE.jar:5.2.0.RELEASE]
	at org.springframework.core.annotation.AnnotationsScanner.getDeclaredAnnotations(AnnotationsScanner.java:439) ~[spring-core-5.2.0.RELEASE.jar:5.2.0.RELEASE]
	at org.springframework.core.annotation.AnnotationsScanner.processClassHierarchy(AnnotationsScanner.java:210) ~[spring-core-5.2.0.RELEASE.jar:5.2.0.RELEASE]
	at org.springframework.core.annotation.AnnotationsScanner.processClassHierarchy(AnnotationsScanner.java:194) ~[spring-core-5.2.0.RELEASE.jar:5.2.0.RELEASE]
	at org.springframework.core.annotation.AnnotationsScanner.processClass(AnnotationsScanner.java:128) ~[spring-core-5.2.0.RELEASE.jar:5.2.0.RELEASE]
	at org.springframework.core.annotation.AnnotationsScanner.process(AnnotationsScanner.java:107) ~[spring-core-5.2.0.RELEASE.jar:5.2.0.RELEASE]
	at org.springframework.core.annotation.AnnotationsScanner.scan(AnnotationsScanner.java:97) ~[spring-core-5.2.0.RELEASE.jar:5.2.0.RELEASE]
	at org.springframework.core.annotation.AnnotationsScanner.scan(AnnotationsScanner.java:78) ~[spring-core-5.2.0.RELEASE.jar:5.2.0.RELEASE]
	at org.springframework.core.annotation.TypeMappedAnnotations.scan(TypeMappedAnnotations.java:242) ~[spring-core-5.2.0.RELEASE.jar:5.2.0.RELEASE]
	at org.springframework.core.annotation.TypeMappedAnnotations.get(TypeMappedAnnotations.java:149) ~[spring-core-5.2.0.RELEASE.jar:5.2.0.RELEASE]
	at org.springframework.core.annotation.TypeMappedAnnotations.get(TypeMappedAnnotations.java:131) ~[spring-core-5.2.0.RELEASE.jar:5.2.0.RELEASE]
	at org.springframework.core.annotation.AnnotationUtils.findAnnotation(AnnotationUtils.java:563) ~[spring-core-5.2.0.RELEASE.jar:5.2.0.RELEASE]
	at org.springframework.data.repository.config.RepositoryConfigurationExtensionSupport.isStrictRepositoryCandidate(RepositoryConfigurationExtensionSupport.java:314) ~[spring-data-commons-2.2.0.RELEASE.jar:2.2.0.RELEASE]
	at org.springframework.data.repository.config.RepositoryConfigurationExtensionSupport.getRepositoryConfigurations(RepositoryConfigurationExtensionSupport.java:102) ~[spring-data-commons-2.2.0.RELEASE.jar:2.2.0.RELEASE]
	at org.springframework.data.repository.config.RepositoryConfigurationDelegate.registerRepositoriesIn(RepositoryConfigurationDelegate.java:145) ~[spring-data-commons-2.2.0.RELEASE.jar:2.2.0.RELEASE]
	at org.springframework.boot.autoconfigure.data.AbstractRepositoryConfigurationSourceSupport.registerBeanDefinitions(AbstractRepositoryConfigurationSourceSupport.java:62) ~[spring-boot-autoconfigure-2.2.0.RELEASE.jar:2.2.0.RELEASE]
	at org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader.lambda$loadBeanDefinitionsFromRegistrars$1(ConfigurationClassBeanDefinitionReader.java:385) ~[spring-context-5.2.0.RELEASE.jar:5.2.0.RELEASE]
	at java.util.LinkedHashMap.forEach(LinkedHashMap.java:684) ~[na:1.8.0_131]
	at org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader.loadBeanDefinitionsFromRegistrars(ConfigurationClassBeanDefinitionReader.java:384) ~[spring-context-5.2.0.RELEASE.jar:5.2.0.RELEASE]
	at org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader.loadBeanDefinitionsForConfigurationClass(ConfigurationClassBeanDefinitionReader.java:148) ~[spring-context-5.2.0.RELEASE.jar:5.2.0.RELEASE]
	at org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader.loadBeanDefinitions(ConfigurationClassBeanDefinitionReader.java:120) ~[spring-context-5.2.0.RELEASE.jar:5.2.0.RELEASE]
	at org.springframework.context.annotation.ConfigurationClassPostProcessor.processConfigBeanDefinitions(ConfigurationClassPostProcessor.java:337) ~[spring-context-5.2.0.RELEASE.jar:5.2.0.RELEASE]
	at org.springframework.context.annotation.ConfigurationClassPostProcessor.postProcessBeanDefinitionRegistry(ConfigurationClassPostProcessor.java:242) ~[spring-context-5.2.0.RELEASE.jar:5.2.0.RELEASE]
	at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanDefinitionRegistryPostProcessors(PostProcessorRegistrationDelegate.java:275) ~[spring-context-5.2.0.RELEASE.jar:5.2.0.RELEASE]
	at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:95) ~[spring-context-5.2.0.RELEASE.jar:5.2.0.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:706) ~[spring-context-5.2.0.RELEASE.jar:5.2.0.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:532) ~[spring-context-5.2.0.RELEASE.jar:5.2.0.RELEASE]
	at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:141) ~[spring-boot-2.2.0.RELEASE.jar:2.2.0.RELEASE]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:747) [spring-boot-2.2.0.RELEASE.jar:2.2.0.RELEASE]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:397) [spring-boot-2.2.0.RELEASE.jar:2.2.0.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:315) [spring-boot-2.2.0.RELEASE.jar:2.2.0.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1226) [spring-boot-2.2.0.RELEASE.jar:2.2.0.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1215) [spring-boot-2.2.0.RELEASE.jar:2.2.0.RELEASE]
	at com.klaus.interview.springredis.SpringRedisApplication.main(SpringRedisApplication.java:10) [classes/:na]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_131]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_131]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_131]
	at java.lang.reflect.Method.invoke(Method.java:498) ~[na:1.8.0_131]
	at org.springframework.boot.devtools.restart.RestartLauncher.run(RestartLauncher.java:49) [spring-boot-devtools-2.2.0.RELEASE.jar:2.2.0.RELEASE]


Process finished with exit code 0


解决办法
1. spring 版本降低
   降低到版本 2.1.0.RELEASE，2.1.8.RELEASE便可以解决问题
2. 排除依赖
   需要检查那个依赖出现问题了，网上参考
   https://cloud.tencent.com/developer/article/1352737
   https://blog.csdn.net/u011447871/article/details/98943140

```

- Not a managed type: class xxx
```
解决方案
添加po扫描路径
@EntityScan(basePackages = {"com.klaus.interview.basemodel.model.school.po"})
```

-
-







