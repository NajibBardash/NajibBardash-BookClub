#!/bin/bash

NAME="bookclub"

echo "Bulding ${NAME}..."
mvn package
echo "running..."
mvn spring-boot:run
echo "Done!"
echo "Go to a web-browser and open: localhost:8080/home"
