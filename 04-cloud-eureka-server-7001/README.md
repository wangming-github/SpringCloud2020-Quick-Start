![image-20220720035650048](https://tva1.sinaimg.cn/large/e6c9d24egy1h4cvnnudyvj218s0hct9s.jpg)

#### 什么是服务注册与发现?

Eureka采用了CS的设计架构，Eureka Server作为服务注册功能的服务器，它是服务注册中心。而系统中的其他微服务，使用Eurekat的客户端连接到Eureka Server并维持心
跳连接。这样系统的维护人员就可以通过Eureka Server来监控系统中各个微服务是否正常运行。
在服务注册与发现中，有一个注册中心。当服务器启动的时候，会把当前自己服务器的信息比如服务地址通讯地址等以别名方式注册到注册中心上。另一方（消费者服务提供
者），以该别名的方式去注册中心上获取到实际的服务通讯地址，然后再实现本地RPC调用PC远程调用框架核心设计思想：在于注册中心，因为使用注册中心管理每个服务与服务之间的一个依赖关系（服务治理概念）。在任何RPC远程框架中，都会有一个注册中心（存放服务地址相关信息（接口地址））

![image-20220720040937416](https://tva1.sinaimg.cn/large/e6c9d24egy1h4cvpawzt2j21sa0kwgoq.jpg)





#### Eureka包含两个组件：Eureka Serveri和Eureka Client

Eureka Server提供服务注册服务各个微服务节点通过配置启动后，会在EurekaServer中进行注册，这样EurekaServer中的服务注册表中将会存储所有可用服务节点的
信息，服务节点的信息可以在界面中直观看到。
EurekaClient通过注册中心进行访问是一个Java客户端，用于简化Eureka Server的交互，客户端同时也具备一个内置的、使用轮询（round-robin）负载算法的负载均衡器。
在应用启动后，将会向Eureka Server发送心跳（默认周期为30秒）。如果Eureka Server在多个心跳周期内没有接收到某个节点的心跳，EurekaServer将会从服务注册表中把这个服务节点移除（默认90秒）。

---



### 搭建Eureka注册中心

#### application.yml

```yaml
server:
  port: 7001


eureka:
  instance:
    hostname: localhost #eureka服务端的实例名称
  client:
    register-with-eureka: false     #false表示不向注册中心注册自己。
    fetch-registry: false     #false表示自己端就是注册中心，我的职责就是维护服务实例，并不需要去检索服务
    service-url:
      #集群指向其它eureka
      #defaultZone: http://localhost:7001/eureka/
      #单机就是7001自己
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
    #server:
    #关闭自我保护机制，保证不可用服务被及时踢除
    #enable-self-preservation: false
    #eviction-interval-timer-in-ms: 2000
```

#### @EnableEurekaServer

```java
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaServer //标注为此服务为注册中心
public class EurekaMain7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class, args);
    }
}
```

访问：http://localhost:7001/

![image-20220720044420313](https://tva1.sinaimg.cn/large/e6c9d24egy1h4cwpf7yiqj22cn0u0gpy.jpg)

