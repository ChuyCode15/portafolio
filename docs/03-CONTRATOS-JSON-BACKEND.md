# Contratos JSON — API REST Backend Spring Boot

## Interfaces de comunicación Frontend ↔ Backend

---

## 1. Perfil Personal

### `GET /api/v1/profile`

**Response 200 OK**

```json
{
  "firstName": "Juan Manuel",
  "lastName": "Castillo",
  "title": "Java Backend Developer",
  "subtitle": "Spring Boot | Microservicios | Cloud",
  "summary": "Backend Developer con X años de experiencia en diseño e implementación de APIs REST con Spring Boot. Especializado en arquitecturas limpias, optimización de consultas JPA y despliegue en entornos cloud. Apasionado por crear sistemas escalables, robustos y bien documentados.",
  "email": "juan@email.com",
  "phone": "+52 55 1234 5678",
  "location": "Ciudad de México, MX",
  "photoUrl": "/assets/images/profile.jpg",
  "resumeUrl": "/api/v1/cv/download",
  "availableFor": "Freelance",
  "socialLinks": [
    {
      "platform": "GITHUB",
      "url": "https://github.com/jmcastillo",
      "icon": "fab fa-github",
      "label": "GitHub"
    },
    {
      "platform": "LINKEDIN",
      "url": "https://linkedin.com/in/jmcastillo",
      "icon": "fab fa-linkedin-in",
      "label": "LinkedIn"
    },
    {
      "platform": "EMAIL",
      "url": "mailto:juan@email.com",
      "icon": "fas fa-envelope",
      "label": "Email"
    }
  ]
}
```

---

## 2. Habilidades Técnicas

### `GET /api/v1/skills`

**Response 200 OK**

```json
[
  {
    "id": 1,
    "category": "Backend",
    "categoryOrder": 1,
    "items": [
      {
        "name": "Java",
        "level": 95,
        "icon": "devicon-java-plain",
        "color": "#b07219",
        "yearsOfExperience": 5
      },
      {
        "name": "Spring Boot",
        "level": 90,
        "icon": "devicon-spring-plain",
        "color": "#6DB33F",
        "yearsOfExperience": 4
      },
      {
        "name": "Spring Security",
        "level": 85,
        "icon": "devicon-spring-plain",
        "color": "#6DB33F",
        "yearsOfExperience": 3
      },
      {
        "name": "JPA / Hibernate",
        "level": 88,
        "icon": "devicon-hibernate-plain",
        "color": "#59666C",
        "yearsOfExperience": 4
      }
    ]
  },
  {
    "id": 2,
    "category": "Base de Datos",
    "categoryOrder": 2,
    "items": [
      {
        "name": "PostgreSQL",
        "level": 85,
        "icon": "devicon-postgresql-plain",
        "color": "#336791",
        "yearsOfExperience": 4
      },
      {
        "name": "MySQL",
        "level": 80,
        "icon": "devicon-mysql-plain",
        "color": "#4479A1",
        "yearsOfExperience": 3
      },
      {
        "name": "MongoDB",
        "level": 65,
        "icon": "devicon-mongodb-plain",
        "color": "#47A248",
        "yearsOfExperience": 1
      }
    ]
  },
  {
    "id": 3,
    "category": "DevOps & Cloud",
    "categoryOrder": 3,
    "items": [
      {
        "name": "Docker",
        "level": 85,
        "icon": "devicon-docker-plain",
        "color": "#2496ED",
        "yearsOfExperience": 3
      },
      {
        "name": "Linux",
        "level": 80,
        "icon": "devicon-linux-plain",
        "color": "#FCC624",
        "yearsOfExperience": 4
      },
      {
        "name": "Nginx",
        "level": 75,
        "icon": "devicon-nginx-original",
        "color": "#009639",
        "yearsOfExperience": 2
      },
      {
        "name": "OCI",
        "level": 70,
        "icon": "devicon-oracle-original",
        "color": "#F80000",
        "yearsOfExperience": 1
      }
    ]
  },
  {
    "id": 4,
    "category": "Frontend",
    "categoryOrder": 4,
    "items": [
      {
        "name": "Angular",
        "level": 75,
        "icon": "devicon-angularjs-plain",
        "color": "#DD0031",
        "yearsOfExperience": 2
      },
      {
        "name": "TypeScript",
        "level": 75,
        "icon": "devicon-typescript-plain",
        "color": "#3178C6",
        "yearsOfExperience": 2
      }
    ]
  },
  {
    "id": 5,
    "category": "Testing",
    "categoryOrder": 5,
    "items": [
      {
        "name": "JUnit 5",
        "level": 90,
        "icon": "devicon-java-plain",
        "color": "#25A162",
        "yearsOfExperience": 4
      },
      {
        "name": "Mockito",
        "level": 85,
        "icon": "devicon-java-plain",
        "color": "#25A162",
        "yearsOfExperience": 3
      },
      {
        "name": "Testcontainers",
        "level": 70,
        "icon": "devicon-docker-plain",
        "color": "#2496ED",
        "yearsOfExperience": 2
      }
    ]
  }
]
```

---

## 3. Proyectos Destacados

### `GET /api/v1/projects`

**Query params:** `?category=backend` (opcional), `?page=0&size=10` (paginación)

**Response 200 OK**

```json
{
  "content": [
    {
      "id": 1,
      "title": "Sistema de Gestión de Inventarios",
      "slug": "sistema-gestion-inventarios",
      "shortDescription": "API REST para gestión de inventarios multitienda con Spring Boot y JPA. Optimización de consultas N+1, caché distribuida con Redis.",
      "fullDescription": "Sistema completo de gestión de inventarios que soporta múltiples tiendas, alertas de stock mínimo, y reportes en tiempo real. Implementé una arquitectura hexagonal con DTOs, mappers, y validaciones personalizadas. Reduje el tiempo de consulta de reportes en un 60% mediante optimización de queries JPA y caching con Redis.",
      "technologies": ["Java", "Spring Boot", "JPA", "PostgreSQL", "Redis", "Docker"],
      "category": "BACKEND",
      "featured": true,
      "projectUrl": "https://github.com/jmcastillo/inventory-api",
      "demoUrl": "https://api.inventory-demo.com/swagger-ui.html",
      "imageUrl": "/assets/projects/inventory.jpg",
      "metrics": [
        { "label": "Latencia reducida", "value": "60%" },
        { "label": "Endpoints REST", "value": "45" },
        { "label": "Cobertura tests", "value": "92%" }
      ],
      "startDate": "2025-03-01",
      "endDate": "2025-06-30",
      "stars": 15,
      "architecturalHighlights": [
        "Arquitectura hexagonal con separación de capas",
        "Patrón DTO con MapStruct",
        "Manejo global de excepciones con @ControllerAdvice",
        "JWT Authentication con Spring Security",
        "Documentación OpenAPI/Swagger",
        "Tests de integración con Testcontainers"
      ]
    },
    {
      "id": 2,
      "title": "Microservicio de Notificaciones",
      "slug": "microservicio-notificaciones",
      "shortDescription": "Microservicio asíncrono para envío de notificaciones email/SMS con colas RabbitMQ y resiliencia con Resilience4j.",
      "fullDescription": "Microservicio desacoplado que procesa notificaciones de forma asíncrona usando RabbitMQ. Implementé circuit breaker con Resilience4j, retry policy, y health checks. Desplegado en Docker con comunicación vía REST entre servicios. Incluye plantillas dinámicas de email con Thymeleaf.",
      "technologies": ["Java", "Spring Boot", "RabbitMQ", "Docker", "PostgreSQL", "Resilience4j"],
      "category": "BACKEND",
      "featured": true,
      "projectUrl": "https://github.com/jmcastillo/notification-service",
      "demoUrl": null,
      "imageUrl": "/assets/projects/notifications.jpg",
      "metrics": [
        { "label": "Tasa de entrega", "value": "99.5%" },
        { "label": "Servicios integrados", "value": "3" },
        { "label": "Disponibilidad", "value": "99.9%" }
      ],
      "startDate": "2025-07-01",
      "endDate": "2025-09-30",
      "stars": 8,
      "architecturalHighlights": [
        "Arquitectura de microservicios",
        "Mensajería asíncrona con RabbitMQ",
        "Circuit Breaker con Resilience4j",
        "Docker Compose multi-servicio",
        "Logs centralizados con ELK"
      ]
    },
    {
      "id": 3,
      "title": "Plataforma Full-Stack de Gestión de Tareas",
      "slug": "plataforma-gestion-tareas",
      "shortDescription": "Aplicación full-stack con Angular + Spring Boot. CRUD completo con autenticación JWT, roles y tablero Kanban.",
      "fullDescription": "Plataforma colaborativa de gestión de tareas con tablero Kanban drag-and-drop. Backend con Spring Security + JWT para autenticación y autorización por roles. Frontend en Angular 21 con componentes standalone y signals. Incluye filtros en tiempo real, notificaciones y exportación a PDF.",
      "technologies": ["Java", "Spring Boot", "Angular", "TypeScript", "PostgreSQL", "Docker", "JWT"],
      "category": "FULLSTACK",
      "featured": false,
      "projectUrl": "https://github.com/jmcastillo/task-manager",
      "demoUrl": "https://task-manager-demo.com",
      "imageUrl": "/assets/projects/taskmanager.jpg",
      "metrics": [
        { "label": "Usuarios simultáneos", "value": "100+" },
        { "label": "Tiempo de respuesta", "value": "<200ms" },
        { "label": "Cobertura tests", "value": "85%" }
      ],
      "startDate": "2026-01-01",
      "endDate": "2026-03-31",
      "stars": 22,
      "architecturalHighlights": [
        "Full-stack: Angular + Spring Boot",
        "Autenticación JWT con refresh token",
        "Roles: ADMIN, USER",
        "API REST documentada con OpenAPI",
        "Client generated con OpenAPI Generator",
        "Despliegue con Docker Compose"
      ]
    }
  ],
  "page": 0,
  "size": 10,
  "totalElements": 3,
  "totalPages": 1,
  "last": true
}
```

### `GET /api/v1/projects/{id}`

**Response 200 OK**

```json
{
  "id": 1,
  "title": "Sistema de Gestión de Inventarios",
  "slug": "sistema-gestion-inventarios",
  "shortDescription": "API REST para gestión de inventarios multitienda con Spring Boot y JPA.",
  "fullDescription": "Sistema completo de gestión de inventarios...",
  "technologies": ["Java", "Spring Boot", "JPA", "PostgreSQL", "Redis", "Docker"],
  "category": "BACKEND",
  "featured": true,
  "projectUrl": "https://github.com/jmcastillo/inventory-api",
  "demoUrl": "https://api.inventory-demo.com/swagger-ui.html",
  "imageUrl": "/assets/projects/inventory.jpg",
  "metrics": [
    { "label": "Latencia reducida", "value": "60%" },
    { "label": "Endpoints REST", "value": "45" },
    { "label": "Cobertura tests", "value": "92%" }
  ],
  "startDate": "2025-03-01",
  "endDate": "2025-06-30",
  "stars": 15,
  "architecturalHighlights": [
    "Arquitectura hexagonal con separación de capas",
    "Patrón DTO con MapStruct",
    "Manejo global de excepciones con @ControllerAdvice"
  ],
  "screenshots": [
    { "url": "/assets/projects/inventory-1.jpg", "alt": "Dashboard de inventarios" },
    { "url": "/assets/projects/inventory-2.jpg", "alt": "Swagger UI" }
  ]
}
```

---

## 4. Formulario de Contacto

### `POST /api/v1/contact`

**Request Body**

```json
{
  "name": "Juan Pérez",
  "email": "juan.perez@email.com",
  "subject": "Propuesta laboral",
  "message": "Hola, vi tu portafolio y me gustaría conversar sobre una oportunidad como Backend Developer en nuestra empresa.",
  "phone": "+52 55 9876 5432"
}
```

**Response 201 Created**

```json
{
  "success": true,
  "message": "Mensaje recibido correctamente. Te responderé a la brevedad.",
  "timestamp": "2026-07-03T10:30:00Z",
  "messageId": "MSG-20260703-001"
}
```

**Response 400 Bad Request**

```json
{
  "success": false,
  "message": "Error de validación",
  "errors": [
    { "field": "email", "message": "El email no es válido" },
    { "field": "message", "message": "El mensaje debe tener al menos 10 caracteres" }
  ]
}
```

**Validaciones del formulario:**

| Campo | Tipo | Requerido | Validación |
|-------|------|-----------|------------|
| name | string | Sí | 3-100 caracteres |
| email | string | Sí | Email válido |
| subject | string | Sí | 5-200 caracteres |
| message | string | Sí | 10-2000 caracteres |
| phone | string | No | Opcional |

---

## 5. Experiencia Laboral

### `GET /api/v1/experience`

**Response 200 OK**

```json
[
  {
    "id": 1,
    "company": "Empresa Tech S.A.",
    "role": "Java Backend Developer",
    "location": "Remoto",
    "startDate": "2024-01",
    "endDate": null,
    "current": true,
    "description": "Desarrollo y mantenimiento de APIs REST para plataforma de e-commerce con más de 100k usuarios activos.",
    "achievements": [
      "Reduje el tiempo de respuesta de consultas críticas en un 40% optimizando queries JPA e implementando caché con Redis",
      "Migré 15 microservicios de monolitos a arquitectura distribuida con Spring Boot y RabbitMQ",
      "Implementé pipeline CI/CD con GitHub Actions reduciendo el tiempo de release de 2 días a 30 minutos",
      "Lideré la migración de Java 11 a Java 21, eliminando 200+ warnings de deprecación"
    ],
    "technologies": ["Java 21", "Spring Boot 3", "Spring Security", "PostgreSQL", "Redis", "Docker", "RabbitMQ"],
    "companyLogo": "/assets/logos/empresa1.png",
    "companyUrl": "https://empresa-tech.com"
  },
  {
    "id": 2,
    "company": "Startup Innovación",
    "role": "Backend Developer Jr.",
    "location": "Ciudad de México",
    "startDate": "2022-06",
    "endDate": "2023-12",
    "current": false,
    "description": "Desarrollo de APIs REST para aplicación SaaS de gestión empresarial.",
    "achievements": [
      "Diseñé e implementé 30+ endpoints REST para el módulo de facturación electrónica",
      "Aumenté la cobertura de tests unitarios del 30% al 85% usando JUnit 5 y Mockito",
      "Implementé autenticación JWT con refresh tokens y roles de usuario"
    ],
    "technologies": ["Java 17", "Spring Boot 2.7", "JPA", "MySQL", "JWT", "JUnit 5"],
    "companyLogo": "/assets/logos/empresa2.png",
    "companyUrl": null
  }
]
```

---

## 6. Authentication (Admin)

### `POST /api/v1/auth/login`

**Request Body**

```json
{
  "email": "admin@jmcportfolio.com",
  "password": "********"
}
```

**Response 200 OK**

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "tokenType": "Bearer",
  "expiresIn": 3600,
  "refreshToken": "dGhpcyBpcyBhIHJlZnJlc2ggdG9rZW4...",
  "user": {
    "id": 1,
    "name": "Juan Manuel Castillo",
    "email": "admin@jmcportfolio.com",
    "role": "ADMIN"
  }
}
```

**Response 401 Unauthorized**

```json
{
  "success": false,
  "message": "Credenciales inválidas"
}
```

---

## 7. Errores Globales

Todos los errores siguen este formato:

```json
{
  "success": false,
  "status": 404,
  "error": "Not Found",
  "message": "El recurso solicitado no existe",
  "path": "/api/v1/projects/999",
  "timestamp": "2026-07-03T10:30:00Z"
}
```

| Status | Significado |
|--------|-------------|
| 400 | Bad Request — validación fallida |
| 401 | Unauthorized — token inválido o ausente |
| 403 | Forbidden — sin permisos |
| 404 | Not Found — recurso inexistente |
| 409 | Conflict — duplicado o conflicto de datos |
| 500 | Internal Server Error — error inesperado |

---

## 8. Entidades JPA (Modelo de Datos)

```sql
-- Tabla: projects
CREATE TABLE projects (
    id              BIGSERIAL PRIMARY KEY,
    title           VARCHAR(200) NOT NULL,
    slug            VARCHAR(255) UNIQUE NOT NULL,
    short_desc      VARCHAR(500) NOT NULL,
    full_desc       TEXT,
    category        VARCHAR(50) NOT NULL,  -- BACKEND, FULLSTACK, DEVOPS
    featured        BOOLEAN DEFAULT FALSE,
    project_url     VARCHAR(500),
    demo_url        VARCHAR(500),
    image_url       VARCHAR(500),
    stars           INT DEFAULT 0,
    start_date      DATE,
    end_date        DATE,
    technologies    TEXT[],     -- Array de strings
    created_at      TIMESTAMP DEFAULT NOW(),
    updated_at      TIMESTAMP DEFAULT NOW()
);

-- Tabla: contact_messages
CREATE TABLE contact_messages (
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    email       VARCHAR(255) NOT NULL,
    phone       VARCHAR(20),
    subject     VARCHAR(200) NOT NULL,
    message     TEXT NOT NULL,
    is_read     BOOLEAN DEFAULT FALSE,
    created_at  TIMESTAMP DEFAULT NOW()
);

-- Tabla: skills
CREATE TABLE skills (
    id              BIGSERIAL PRIMARY KEY,
    category        VARCHAR(100) NOT NULL,
    category_order  INT DEFAULT 0,
    name            VARCHAR(100) NOT NULL,
    level           INT CHECK (level >= 0 AND level <= 100),
    icon            VARCHAR(100),
    color           VARCHAR(7),
    years_exp       INT DEFAULT 0
);

-- Tabla: experiences
CREATE TABLE experiences (
    id          BIGSERIAL PRIMARY KEY,
    company     VARCHAR(200) NOT NULL,
    role        VARCHAR(200) NOT NULL,
    location    VARCHAR(200),
    start_date  VARCHAR(7) NOT NULL,   -- "2024-01"
    end_date    VARCHAR(7),             -- null si es actual
    current     BOOLEAN DEFAULT FALSE,
    description TEXT,
    technologies TEXT[],                -- Array de strings
    company_logo VARCHAR(500),
    company_url VARCHAR(500),
    sort_order  INT DEFAULT 0,
    created_at  TIMESTAMP DEFAULT NOW()
);

-- Tabla: users (admin)
CREATE TABLE users (
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    email       VARCHAR(255) UNIQUE NOT NULL,
    password    VARCHAR(255) NOT NULL,
    role        VARCHAR(20) DEFAULT 'ADMIN',
    created_at  TIMESTAMP DEFAULT NOW()
);
```

---

## 9. Diagrama de Entidad-Relación

```
┌──────────────────┐       ┌───────────────────┐
│     projects      │       │  experiences       │
├──────────────────┤       ├───────────────────┤
│ id (PK)          │       │ id (PK)           │
│ title            │       │ company           │
│ slug (UQ)        │       │ role              │
│ short_desc       │       │ start_date        │
│ full_desc        │       │ end_date          │
│ category         │       │ current           │
│ featured         │       │ description       │
│ technologies[]   │       │ technologies[]    │
│ project_url      │       │ sort_order        │
│ demo_url         │       └───────────────────┘
│ stars            │
│ start_date       │       ┌───────────────────┐
│ end_date         │       │  contact_messages  │
└──────────────────┘       ├───────────────────┤
                            │ id (PK)           │
┌──────────────────┐       │ name              │
│     skills        │       │ email             │
├──────────────────┤       │ subject           │
│ id (PK)          │       │ message           │
│ category         │       │ is_read           │
│ name             │       │ created_at        │
│ level (0-100)    │       └───────────────────┘
│ icon             │
│ color            │       ┌───────────────────┐
│ years_exp        │       │      users         │
└──────────────────┘       ├───────────────────┤
                            │ id (PK)           │
                            │ name              │
                            │ email (UQ)        │
                            │ password          │
                            │ role              │
                            └───────────────────┘
```

---

## 10. Configuración application.yml

```yaml
server:
  port: 8080

spring:
  datasource:
    url: ${DB_URL:jdbc:postgresql://localhost:5432/portfolio}
    username: ${DB_USER:portfolio}
    password: ${DB_PASSWORD:secret}
  jpa:
    hibernate:
      ddl-auto: validate
    show-sql: false
    properties:
      hibernate:
        format_sql: true
  flyway:
    enabled: true
    locations: classpath:db/migration
  mail:
    host: ${SMTP_HOST:smtp.gmail.com}
    port: ${SMTP_PORT:587}
    username: ${SMTP_USER}
    password: ${SMTP_PASS}
    properties:
      mail.smtp.auth: true
      mail.smtp.starttls.enable: true

app:
  jwt:
    secret: ${JWT_SECRET}
    expiration-ms: 3600000  # 1 hora
  cors:
    allowed-origins: ${CORS_ORIGINS:http://localhost:4200,https://tu-dominio.com}
```

---

## 11. Seed Data (data.sql o migration)

```sql
-- Migration V1__init.sql

-- Admin por defecto (password: admin123, hasheado con BCrypt)
INSERT INTO users (name, email, password, role)
VALUES ('Admin', 'admin@jmcportfolio.com',
        '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy',
        'ADMIN');

-- Skills semilla
INSERT INTO skills (category, category_order, name, level, icon, color, years_exp)
VALUES
  ('Backend', 1, 'Java', 95, 'devicon-java-plain', '#b07219', 5),
  ('Backend', 1, 'Spring Boot', 90, 'devicon-spring-plain', '#6DB33F', 4),
  ('Backend', 1, 'Spring Security', 85, 'devicon-spring-plain', '#6DB33F', 3),
  ('Base de Datos', 2, 'PostgreSQL', 85, 'devicon-postgresql-plain', '#336791', 4),
  ('DevOps', 3, 'Docker', 85, 'devicon-docker-plain', '#2496ED', 3),
  ('Testing', 5, 'JUnit 5', 90, 'devicon-java-plain', '#25A162', 4);
```
