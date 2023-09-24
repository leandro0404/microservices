#!/bin/bash

# Script para automatizar a construção e execução do Docker Compose

# Obter o diretório absoluto do script
SCRIPT_DIR=$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)

# Função para construir a imagem Docker
build_image() {
    echo "Construindo imagem para $1"
    cd "$SCRIPT_DIR/$1"
    mvn clean install -DskipTests 
    if [ "$1" == "resources/api-account" ]; then
        docker build -t api-account .
    elif [ "$1" == "resources/api-user" ]; then
        docker build -t api-user .
    elif [ "$1" == "resources/api-application" ]; then
        docker build -t api-application .
     elif [ "$1" ==  "authentication/auth-server" ]; then
        docker build -t auth-server .
    fi
    cd "$SCRIPT_DIR"
}



# Esperar alguns segundos para que os serviços da infraestrutura sejam iniciados
sleep 10

# Construir as imagens para cada aplicação
build_image "resources/api-user"
build_image "resources/api-account"
build_image "resources/api-application"
build_image "authentication/auth-server"

# Executar o Docker Compose para as aplicações
docker-compose  docker-compose.yml up -d
