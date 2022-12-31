FROM openjdk:17
LABEL org.opencontainers.image.authors="ffinpay.ru"
ADD accounts/target/*.jar accounts.jar
EXPOSE 9080
ENTRYPOINT ["java", "-jar", "accounts.jar"]
