# Documento de Desarrollo — Portfolio JMC

## Guía de trabajo para construir el portafolio

---

## 1. Prerrequisitos

```
Node.js     ≥ 20.19
npm         ≥ 9
Angular CLI ≥ 21     (npm install -g @angular/cli)
Java        ≥ 21 LTS (JDK)
Maven       ≥ 3.9
Docker      ≥ 24
Docker Compose ≥ 2
```

---

## 2. Setup Inicial — Frontend Angular

### 2.1 Clonar template base

```bash
git clone https://github.com/Anglesvar/Angular-Digital-Portfolio.git jmc-portfolio
cd jmc-portfolio
npm install
npm start
# Abre http://localhost:4200
```

### 2.2 Renombrar el proyecto

Editar `package.json`:

```json
{
  "name": "jmc-portfolio",
  "version": "1.0.0"
}
```

Editar `angular.json` → cambiar `anglesvar-portfolio` por `jmc-portfolio` en todas las referencias.

### 2.3 Verificar build

```bash
npm run build
# Debe generar: dist/jmc-portfolio/
```

---

## 3. Personalización de Contenido

### 3.1 Editar el JSON de datos

Archivo único: `src/assets/portfolio.data.json`

| Sección JSON | ¿Qué contiene? | Instrucciones |
|-------------|----------------|---------------|
| `personal` | Nombre, título, email, teléfono | Cambiar todo por tus datos reales |
| `social` | Links a GitHub, LinkedIn, etc. | Reemplazar URLs con tus perfiles |
| `about` | Texto "Sobre mí", skills, stats | Escribe tu historia, lista tus tecnologías |
| `projects` | Proyectos destacados (fallback) | Cambia por tus proyectos reales |
| `contact` | Texto del llamado a contacto | Ajusta el mensaje |
| `navigation` | Links del navbar | Puedes añadir "Experience" o "Blog" |
| `backgrounds` | URLs de imágenes de fondo | Reemplaza con imágenes propias o Unsplash |
| `languageColors` | Colores para badges de lenguajes | Añade: "Java": "#b07219" |

### 3.2 Personalizar el theme (colores)

Editar `src/styles/abstracts/_variables.scss`:

```scss
$color-accent:     #4CAF50;   // Color principal (verde Java, o tu color)
$color-bg-primary: #0a0a0a;   // Fondo oscuro
$color-text:       #e0e0e0;   // Texto principal
$font-mono:        'JetBrains Mono', monospace;
$font-display:     'Inter', sans-serif;
```

### 3.3 Personalizar index.html

Editar `src/index.html`:

```html
<title>JMC | Java Backend Developer</title>
<meta name="description" content="Portfolio de [Tu Nombre] — Java Backend Developer especializado en Spring Boot, Microservicios y Arquitectura Cloud" />
<meta property="og:title" content="JMC | Java Backend Developer" />
```

---

## 4. Guía de Contenido — Paso a Paso

### FASE 1: Identidad (día 1)

| Elemento | Dónde editarlo | Qué poner |
|----------|---------------|-----------|
| Nombre | `personal.firstName + lastName` | Tu nombre real |
| Título profesional | `personal.devDesc` | `"| Java Backend Developer | Spring Boot | Microservicios |"` |
| Logo texto | `personal.logoText` | `"<JMC />"` o `"{JMC}"` |
| Foto de perfil | Añadir en `assets/images/` y referenciar en `about` | Foto profesional o avatar |

### FASE 2: Sobre Mí (día 1-2)

```
Párrafo de 3-4 líneas que responda:
1. ¿Quién soy? → "Java Backend Developer con X años de experiencia..."
2. ¿Qué hago? → "Especializado en Spring Boot, diseño de APIs REST, microservicios..."
3. ¿Qué busco? → "Apasionado por crear sistemas escalables y robustos..."

Skills sugeridos para tu perfil:
  Java | Spring Boot | Spring Security | JPA/Hibernate | REST APIs
  PostgreSQL | MySQL | Docker | Kubernetes | Git | CI/CD
  Angular | TypeScript | HTML/CSS
  Microservicios | Arquitectura Hexagonal | TDD
```

### FASE 3: Proyectos (día 2-3)

Para cada proyecto en `projects.fallbackRepos[]`, completa:

```json
{
  "name": "Nombre del Proyecto",
  "description": "Problema que resuelve + stack + logro concreto. Ej: 'API REST para gestión de inventarios con Spring Boot y JPA. Reduje consultas N+1 en un 60% con optimización de queries.'",
  "language": "Java",
  "stargazers_count": 0,
  "html_url": "https://github.com/tuusuario/proyecto"
}
```

**Regla de oro:** 3 proyectos bien explicados > 10 proyectos genéricos.

Elige proyectos que demuestren:

| Proyecto | Demuestra |
|----------|-----------|
| **API REST con Spring Boot** | CRUD, JPA, validaciones, excepciones, DTOs |
| **Microservicio con Docker** | Dockerización, compose, comunicación entre servicios |
| **Aplicación full-stack** | Angular + Spring Boot, integración front-back |

### FASE 4: Stats con impacto (día 3)

```json
"stats": [
  { "value": "X+",  "label": "Años de Experiencia" },
  { "value": "X+",  "label": "Proyectos Entregados" },
  { "value": "X",   "label": "Tecnologías Dominadas" },
  { "value": "★",   "label": "Certificaciones" }
]
```

### FASE 5: Contacto (día 3)

Asegúrate de que:

- `personal.emailId` sea tu email real
- `social` incluya LinkedIn (imprescindible), GitHub, y opcionalmente Stack Overflow
- El formulario de contacto funcione (requiere backend Spring Boot)

---

## 5. Backend Spring Boot — Guía Rápida

### 5.1 Crear proyecto base

```bash
# Usando Spring Initializr o CLI:
curl https://start.spring.io/starter.zip \
  -d type=maven-project \
  -d language=java \
  -d bootVersion=3.4.0 \
  -d baseDir=jmc-backend \
  -d groupId=com.jmcportfolio \
  -d artifactId=jmc-backend \
  -d packageName=com.jmcportfolio \
  -d javaVersion=21 \
  -d dependencies=web,data-jpa,postgresql,validation,mail,security,lombok,actuator \
  -o jmc-backend.zip
```

### 5.2 Estructura del backend

```
jmc-backend/
├── Dockerfile
├── docker-compose.yml
├── pom.xml
├── src/
│   └── main/
│       ├── java/com/jmcportfolio/
│       │   ├── JmcBackendApplication.java
│       │   ├── config/
│       │   │   ├── CorsConfig.java
│       │   │   └── SecurityConfig.java
│       │   ├── controller/
│       │   │   ├── ProfileController.java
│       │   │   ├── ProjectController.java
│       │   │   ├── ContactController.java
│       │   │   ├── SkillController.java
│       │   │   └── AuthController.java
│       │   ├── model/
│       │   │   ├── Project.java
│       │   │   ├── ContactMessage.java
│       │   │   ├── Skill.java
│       │   │   └── User.java
│       │   ├── repository/
│       │   │   ├── ProjectRepository.java
│       │   │   ├── ContactMessageRepository.java
│       │   │   └── SkillRepository.java
│       │   ├── service/
│       │   │   ├── ProjectService.java
│       │   │   ├── ContactService.java
│       │   │   └── SkillService.java
│       │   └── dto/
│       │       ├── ProjectDTO.java
│       │       ├── ContactRequestDTO.java
│       │       └── ProfileDTO.java
│       └── resources/
│           ├── application.yml
│           └── db/migration/
│               └── V1__init.sql
```

### 5.3 Comandos de desarrollo backend

```bash
# Iniciar base de datos con Docker
docker run --name portfolio-db -e POSTGRES_DB=portfolio \
  -e POSTGRES_USER=portfolio -e POSTGRES_PASSWORD=secret \
  -p 5432:5432 -d postgres:16

# Iniciar backend
cd jmc-backend
./mvnw spring-boot:run

# Verificar health
curl http://localhost:8080/actuator/health

# Ver swagger
# http://localhost:8080/swagger-ui.html
```

---

## 6. Dockerización

### Frontend (Dockerfile)

```dockerfile
FROM node:22-alpine AS build
WORKDIR /app
COPY package.json package-lock.json ./
RUN npm ci
COPY . .
RUN npm run build -- --configuration production

FROM nginx:1.25-alpine
COPY --from=build /app/dist/jmc-portfolio/browser /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
```

### Backend (Dockerfile)

```dockerfile
FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app
COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:go-offline
COPY src src
RUN ./mvnw package -DskipTests

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

### Docker Compose

```yaml
version: '3.8'
services:
  db:
    image: postgres:16-alpine
    environment:
      POSTGRES_DB: portfolio
      POSTGRES_USER: portfolio
      POSTGRES_PASSWORD: ${DB_PASSWORD}
    volumes:
      - pgdata:/var/lib/postgresql/data
    ports:
      - "5432:5432"

  backend:
    build: ./jmc-backend
    ports:
      - "8080:8080"
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://db:5432/portfolio
      SPRING_DATASOURCE_USERNAME: portfolio
      SPRING_DATASOURCE_PASSWORD: ${DB_PASSWORD}
    depends_on:
      - db

volumes:
  pgdata:
```

---

## 7. Checklist de Desarrollo

### Fase 1 — Fundación (Día 1)
- [ ] Clonar template Angular
- [ ] Renombrar proyecto (package.json, angular.json)
- [ ] Cambiar colores en `_variables.scss`
- [ ] Editar `index.html` (title, meta, favicon)
- [ ] Editar `portfolio.data.json` con datos personales
- [ ] `npm start` y verificar visual

### Fase 2 — Contenido (Día 2)
- [ ] Redactar "Sobre mí" (3 líneas de impacto)
- [ ] Listar skills técnicas (priorizar Java, Spring Boot, etc.)
- [ ] Seleccionar 3 proyectos estrella
- [ ] Escribir descripciones con métricas concretas
- [ ] Configurar stats reales
- [ ] Añadir foto profesional

### Fase 3 — Backend (Día 3-4)
- [ ] Crear proyecto Spring Boot con dependencias
- [ ] Configurar PostgreSQL (local o Docker)
- [ ] Implementar entidades JPA (Project, Skill, ContactMessage)
- [ ] Implementar controladores REST
- [ ] Configurar CORS para el frontend
- [ ] Probar endpoints con Postman/curl
- [ ] Configurar Swagger/OpenAPI
- [ ] Implementar formulario de contacto (JavaMailSender)

### Fase 4 — Integración (Día 5)
- [ ] Crear `ApiService` en Angular para conectar con backend
- [ ] Configurar proxy en `angular.json` para desarrollo local
- [ ] Probar flujo completo frontend → backend → BD
- [ ] Implementar generación de CV PDF (opcional)

### Fase 5 — Deploy (Día 6-7)
- [ ] Dockerizar frontend y backend
- [ ] Probar `docker-compose up` localmente
- [ ] Crear VM en OCI
- [ ] Instalar Docker, Nginx, Certbot
- [ ] Configurar Nginx (reverse proxy + SPA)
- [ ] Configurar SSL (Let's Encrypt)
- [ ] Configurar GitHub Actions para CI/CD
- [ ] Verificar Lighthouse (>90)
- [ ] Registrar dominio y apuntar DNS

---

## 8. Comandos Útiles — Resumen Rápido

```bash
# Frontend
npm start                    # Dev server :4200
npm run build                # Build producción → dist/

# Backend
./mvnw spring-boot:run       # Dev server :8080
./mvnw package -DskipTests   # Build JAR

# Docker
docker-compose up -d         # Levantar todo
docker-compose down          # Detener todo

# Deploy OCI
ssh -i ~/.ssh/oci_key ubuntu@<IP_OCI>
```

---

## 9. Recursos visuales recomendados

| Recurso | Para qué |
|---------|----------|
| `https://unsplash.com` | Imágenes de fondo libres |
| `https://devicon.dev` | Iconos de tecnologías (Java, Spring, etc.) |
| `https://simpleicons.org` | Iconos de redes sociales |
| `https://coolors.co` | Paletas de color |
| `https://fonts.google.com` | Fuentes (JetBrains Mono, Inter) |
| `https://fontawesome.com` | Iconos para skills y botones |
