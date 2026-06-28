# ---------- Build ----------
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

COPY . .

RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

# ---------- Runtime ----------
FROM eclipse-temurin:21-jre

WORKDIR /app

# Crear un usuario sin privilegios
RUN addgroup --system spring && adduser --system spring --ingroup spring

COPY --from=builder /app/target/*.jar app.jar

USER spring

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]