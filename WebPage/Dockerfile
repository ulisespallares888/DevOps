FROM node:18-alpine as build
WORKDIR /app

# Copiar sólo lo necesario para instalar dependencias
COPY web-app/package.json ./
COPY web-app/package-lock.json ./
RUN npm ci

# Copiar el resto del código (sin node_modules gracias a .dockerignore)
COPY web-app/ ./

# Construir la app
RUN npm run build

# Etapa final: servidor
FROM node:18-alpine

WORKDIR /app

RUN npm install -g serve

COPY --from=build /app/build ./build

RUN apk add --no-cache \
    bash \
    curl \
    wget \
    jq

EXPOSE 3000
CMD ["serve", "-s", "build", "-l", "3000"]



# Dockerfile-utils
#FROM alpine:3.20

# Instalar utilidades necesarias
#RUN apk add --no-cache \
#    bash \
#    curl \
#    wget \
#    jq \
#    netcat-openbsd \
#    vim \
#    git \
#    openssh

# Directorio de trabajo
#WORKDIR /app

# Mantener el contenedor activo incluso en modo detached
#CMD ["tail", "-f", "/dev/null"]
