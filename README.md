# Trabajo Práctico N°1 - DevOps  
**Universidad Tecnológica Nacional - Facultad Regional Resistencia**  
**Cátedra:** DevOps – Cultura, Herramientas y Procesos  
**Año lectivo:** 2025  

## Integrantes
- Alexis Medina  
- Ulises Pablo Pallarés  

---

## 🎯 Objetivo
Desarrollar y desplegar una aplicación web contenerizada que integre:  
- Frontend React  
- API Backend con Spring Boot  
- Redis como caché en memoria  
- MySQL como base de datos  
- Orquestación con Docker Compose  
- Despliegue en Azure Container Apps con imágenes desde Docker Hub  

---

## 📌 Escenario Implementado
- **Frontend (Web):** ToDo List en React.  
- **Backend (API):** Servicio REST en Java + Spring Boot que gestiona las tareas.  
- **Redis:** Base en memoria usada como caché.  
- **MySQL:** Base de datos relacional para persistencia.  
- **Orquestación:** Docker Compose.  
- **Cloud:** Azure Container Apps.  

---

## 🛠️ Tecnologías Utilizadas
- **Backend:** Java, Spring Boot  
- **Frontend:** React, JavaScript  
- **Bases de Datos:** MySQL, Redis  
- **Contenerización:** Docker, Docker Compose  
- **Cloud:** Microsoft Azure  

---

## ✅ Resultados Obtenidos
- CRUD completo de tareas: alta, baja, consulta y marcado como completadas.  
- Integración estable **Web → API → Redis** y **Web → API → MySQL**.  
- Servicios contenerizados y publicados en **Docker Hub**.  
- Despliegue exitoso en **Azure Container Apps**.  
- Workflows básicos de **CI/CD con GitHub Actions**.  

## Diagrama del sistema

![ ](https://i.imgur.com/cfZuqER.png)

## Diagrama del sistema en Microsoft Azure

![ ](https://i.imgur.com/7179r2t.png)
---

## ⚠️ Dificultades
- Manejo de credenciales y secretos en GitHub/Azure.  
- Configuración de entornos (dev, test, prod).  
- Adaptación de Redis como caché en memoria.  
- Curva de aprendizaje con Azure (networking y credenciales).  
- Configuración de pipelines de CI/CD.  

---

## 📚 Lecciones Aprendidas
- Definir entornos locales vs cloud desde el inicio es clave.  
- Logs y métricas son esenciales para el debugging en despliegues.  
- Docker Compose facilita en desarrollo, pero en cloud se requieren ajustes.  
- Redis es eficiente, pero exige buena configuración y seguridad.  

---

## 🚀 Posibles Mejoras Futuras
- Autenticación con JWT en la API.  
- Migración a **Kubernetes** para mayor escalabilidad.  
- Mejorar frontend con **React + Tailwind**.  
- Monitoreo con **Grafana + Prometheus**.  
- Integración con un bot vía MCP (ej: Telegram).  

---

## 📌 Conclusión
El proyecto permitió aplicar de forma práctica conceptos de **contenedores, bases de datos en memoria, integración de servicios y despliegue en la nube**.  
Se logró un sistema modular, funcional y escalable, con bases sólidas para futuras mejoras en seguridad, calidad y monitoreo.  
