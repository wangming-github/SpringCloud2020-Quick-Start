## 1.Eureka集群搭建

![image-20220720053013414](https://tva1.sinaimg.cn/large/e6c9d24egy1h4cy15zh3vj21yg0jcwgb.jpg)

注册原理：互相注册，彼此守望。和ES集群类似皆为互相注册。

![image-20220720054024438](https://tva1.sinaimg.cn/large/e6c9d24egy1h4cybrjqdlj21he0hs75t.jpg)





#### 修改host映射：

sudo atom /etc/hosts

```json
# eureka
127.0.0.1	eureka7001.com
127.0.0.1	eureka7002.com
```

![image-20220720055416115](https://tva1.sinaimg.cn/large/e6c9d24egy1h4cyq6fcsij226w0m0432.jpg)

![image-20220720055527447](https://tva1.sinaimg.cn/large/e6c9d24egy1h4cyrf9nv6j222m0m2wir.jpg)

#### @EnableEurekaServer //标注为此服务为注册中心

http://localhost:7002/  正常

http://localhost:7001/ 正常

http://eureka7001.com:7001/

http://eureka7002.com:7002/

![image-20220720060151290](https://tva1.sinaimg.cn/large/e6c9d24egy1h4cyy313bzj22gz0u0dli.jpg)

![image-20220720060246025](https://tva1.sinaimg.cn/large/e6c9d24egy1h4cyz15vskj22i30u0q8n.jpg)

以上注册中心集群搭建成功！



## 2.将服务注册进集群

![image-20220720060517811](https://tva1.sinaimg.cn/large/e6c9d24egy1h4cz1ntfe9j21l00imq6p.jpg)

以上一步即可！