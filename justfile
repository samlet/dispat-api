dev:
	./gradlew quarkusDev
build:
	./gradlew jar
	cp build/libs/dispat-api-1.0.0-SNAPSHOT.jar {{env_var("HOME")}}/ofbiz/plugins/cc-pay/lib/

uberjar:
	./gradlew quarkusBuild -Dquarkus.package.type=uber-jar
# https://quarkus.io/guides/gradle-tooling#building-with-gradlew-build
native:
	./gradlew build -Dquarkus.package.type=native
run:
	java -jar ./build/dispat-api-1.0.0-SNAPSHOT-runner.jar
br:
	./gradlew build
	java -jar build/quarkus-app/quarkus-run.jar

gen-token:
    java -cp ./build/dispat-api-1.0.0-SNAPSHOT-runner.jar -Dexec.classpathScope=main -Dsmallrye.jwt.sign.key-location=privateKey.pem com.bluecc.api.GenerateToken

ping:
	curl -v -X GET http://localhost:8080/ping
secure:
	curl -v http://127.0.0.1:8080/secured/roles-allowed; echo 
with-jwt:
    bash with-jwt.sh


