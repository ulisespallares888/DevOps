#FROM node:18-alpine as build
#WORKDIR /app
#COPY package.json package-lock.json ./
#RUN npm ci
#COPY . .
#RUN npm run build

#FROM node:18-alpine
#WORKDIR /app
#RUN npm install -g serve
#COPY --from=build /app/build ./build
#EXPOSE 3000
#CMD ["serve","-s","build","-l","3000"]

# Dockerfile-utils
FROM alpine:3.20

# Instalar utilidades necesarias
RUN apk add --no-cache \
    bash \
    curl \
    wget \
    jq \
    netcat-openbsd \
    vim \
    git \
    openssh

# Directorio de trabajo
WORKDIR /app

# Mantener el contenedor activo incluso en modo detached
CMD ["tail", "-f", "/dev/null"]
