FROM openjdk:8-jdk-alpine
ADD target/host.jar /app.jar
# 同步容器时间
RUN ln -snf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
ENTRYPOINT ["java", "-jar"]
EXPOSE 8081
CMD ["/app.jar"]