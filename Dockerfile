FROM openjdk:8-jdk-alpine
ADD target/host.jar /app.jar
RUN ln -snf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' > /etc/timezone
ENTRYPOINT ["java", "-jar"]
CMD ["/app.jar"]