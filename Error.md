### 报错
##### 1. Hibernate: java.lang.NoClassDefFoundError: javax/transaction/SystemException
```
jboss-transaction-api_1.2_spec-1.0.0.Final.jar 包未导入
```

##### 2. Could not locate cfg.xml resource [/hibernate.cfg.xml]
```
code: config.configure("resources/hibernate.cfg.xml");
```

##### 3. detached entity passed to persist: domain.User
```
orm会按照预定好的方式对数据id经行复制, 手动设置了id
```