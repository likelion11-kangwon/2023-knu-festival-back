call gradlew.bat bootJar
scp .\build\libs\daedongje-0.0.1-SNAPSHOT.jar daedongje:~
ssh daedongje "pm2 reload 'Daedongje Backend'"