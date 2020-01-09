### 简单的springboot项目构建docker镜像

#### 1.环境

> 系统：win7
> docker环境：win7安装toolbox: https://docs.docker.com/toolbox/overview/
> jdk:java8

#### 2.构建的镜像的DockerFile
```java

FROM openjdk:8-jdk-alpine   --jdk环境
VOLUME /tmp    
ARG JAR_FILE   
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

```

#### 3.打包镜像的mavne插件

```text
<plugin>
		<groupId>com.spotify</groupId>
		<artifactId>dockerfile-maven-plugin</artifactId>
		<version>1.3.4</version>
		<configuration>
				<repository>${docker.image.prefix}/${project.artifactId}</repository>  --最终形成的镜像名称
				<buildArgs>
					<JAR_FILE>target/${project.build.finalName}.jar</JAR_FILE>
				</buildArgs>
		</configuration>
</plugin>
```

#### 4. 执行打包镜像的命令

> dockerfile:build

#### 5. 执行成功后

> docker images 可以在本地仓库看到生成的镜像

#### 6. 运行打包的镜像

> docker run -p 8080:8080 -t test/demo-docker

#### 7. 在启动的toolbox中查询启动日志中的虚拟ip访问接口

> http://192.168.99.100:8080/
