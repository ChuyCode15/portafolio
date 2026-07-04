# Documento Técnico — Portfolio JMC

## Java Backend Developer | Spring Boot + Angular 21 SPA

---

## 1. Arquitectura General

```
┌──────────────────────────────────────────────────────────┐
│                    OCI VM (Ubuntu 22.04)                  │
│                                                           │
│  ┌─────────────┐    ┌──────────────┐    ┌─────────────┐  │
│  │   Nginx      │───▶│   Angular    │    │  Spring Boot │  │
│  │  (SSL/443)   │    │  (SPA estática) │  │  (API :8080) │  │
│  │  (HTTP :80)  │    │  /var/www/    │    │  /app/*.jar │  │
│  └──────┬───────┘    └──────────────┘    └──────┬───────┘  │
│         │                                       │         │
│         └────────── Proxy Pass ──────────────────┘         │
│                     /api/* → localhost:8080                 │
│                                                           │
│  ┌──────────────────────────────────────────────────┐     │
│  │           PostgreSQL 16 (o MySQL 8)               │     │
│  │           localhost:5432                          │     │
│  └──────────────────────────────────────────────────┘     │
└──────────────────────────────────────────────────────────┘
```

### Stack tecnológico

| Capa | Tecnología | Versión |
|------|-----------|---------|
| Frontend | Angular (standalone + signals) | 21 |
| Estilos | SCSS + animaciones CSS nativas | — |
| Backend | Spring Boot | 3.4+ |
| Java | JDK | 21 LTS |
| Base de datos | PostgreSQL | 16 |
| Servidor web | Nginx | 1.24+ |
| Contenedores | Docker + Docker Compose | Última |
| Cloud | Oracle Cloud Infrastructure (OCI) | VM.Standard.E2.1.Micro |
| SSL | Let's Encrypt + Certbot | — |
| CI/CD | GitHub Actions | — |

---

## 2. Estructura del Proyecto Frontend (Angular)

```
jmc-portfolio/
├── angular.json
├── tsconfig.json
├── package.json
├── src/
│   ├── main.ts                          # Entry point
│   ├── index.html                       # Shell HTML
│   ├── assets/
│   │   ├── portfolio.data.json          # ★ UNICO ARCHIVO DE CONTENIDO
│   │   ├── images/                      # Imágenes estáticas
│   │   └── favicon.ico
│   ├── styles/
│   │   ├── main.scss                    # Estilos globales
│   │   └── abstracts/
│   │       ├── _variables.scss          # Tokens de diseño (colores, fuentes)
│   │       ├── _mixins.scss             # Mixins responsive
│   │       ├── _animations.scss         # Keyframes
│   │       └── _index.scss              # Barrel export
│   └── app/
│       ├── app.component.ts             # Componente raíz (standalone)
│       ├── app.config.ts                # Providers globales
│       ├── core/
│       │   ├── models/
│       │   │   └── portfolio.models.ts   # Interfaces TypeScript
│       │   ├── services/
│       │   │   ├── portfolio.service.ts   # Carga JSON local (data estática)
│       │   │   └── api.service.ts         # ★ Llama al backend Spring Boot
│       │   └── interceptors/
│       │       └── api.interceptor.ts     # ★ Añade base URL del backend
│       ├── shared/
│       │   ├── components/
│       │   │   ├── button/
│       │   │   ├── section-header/
│       │   │   ├── typewriter/
│       │   │   └── particles/
│       │   └── directives/
│       │       └── in-view.directive.ts   # IntersectionObserver
│       ├── layout/
│       │   ├── navbar/                    # Navbar fijo con scroll detection
│       │   └── footer/                    # Footer con redes sociales
│       └── features/
│           ├── home/                      # Hero section
│           ├── about/                     # About + skills + stats
│           ├── projects/                  # Proyectos (grid de tarjetas)
│           └── contact/                   # Formulario de contacto
```

### Flujo de datos

```
portfolio.data.json ──▶ PortfolioService ──▶ signal<PortfolioData>
                         (HttpClient)            │
                                                 ├──▶ HomeComponent
                                                 ├──▶ AboutComponent
                                                 ├──▶ ProjectsComponent
                                                 └──▶ ContactComponent

Spring Boot API ──────▶ ApiService ──────────▶ Componentes (cuando aplique)
  /api/projects              (HttpClient)
  /api/contact
  /api/skills
```

---

## 3. Componentes y sus Responsabilidades

| Componente | Ruta | Responsabilidad |
|-----------|------|----------------|
| `AppComponent` | Raíz | Layout principal: navbar + contenido + footer |
| `NavbarComponent` | layout/navbar | Navegación, scroll spy, modo oscuro, logo |
| `FooterComponent` | layout/footer | Redes sociales, copyright, enlaces |
| `HomeComponent` | features/home | Hero: nombre, rol, typewriter, CTA |
| `AboutComponent` | features/about | Quién soy, skills visuales, stats |
| `ProjectsComponent` | features/projects | Grid de proyectos destacados con filtros |
| `ContactComponent` | features/contact | Formulario + datos de contacto |
| `TypewriterComponent` | shared/typewriter | Animación de escritura para el hero |
| `ParticlesComponent` | shared/particles | Fondo animado con canvas |
| `ButtonComponent` | shared/button | Botón reutilizable con variantes |
| `InViewDirective` | shared/directives | Activa animaciones al hacer scroll |

---

## 4. API Endpoints — Backend Spring Boot

| Método | Endpoint | Descripción | Autenticación |
|--------|----------|-------------|---------------|
| GET | `/api/v1/profile` | Datos del perfil personal | No |
| GET | `/api/v1/skills` | Lista de habilidades técnicas | No |
| GET | `/api/v1/projects` | Proyectos destacados (desde BD) | No |
| GET | `/api/v1/projects/{id}` | Detalle de un proyecto | No |
| POST | `/api/v1/contact` | Enviar mensaje de contacto | No |
| GET | `/api/v1/experience` | Experiencia laboral | No |
| GET | `/api/v1/cv/download` | Descargar CV en PDF | No |
| POST | `/api/v1/auth/login` | Login (para admin) | JWT |
| GET | `/api/v1/admin/projects` | CRUD proyectos (admin) | JWT |
| POST | `/api/v1/admin/projects` | Crear proyecto | JWT |
| PUT | `/api/v1/admin/projects/{id}` | Actualizar proyecto | JWT |
| DELETE | `/api/v1/admin/projects/{id}` | Eliminar proyecto | JWT |
| GET | `/api/v1/admin/messages` | Mensajes de contacto | JWT |

---

## 5. Despliegue en OCI con Nginx

### Estructura de depliegue

```
/var/www/jmc-portfolio/              ← Frontend compilado (Angular)
│   ├── index.html
│   ├── main-*.js
│   ├── polyfills-*.js
│   └── assets/

/home/ubuntu/jmc-backend/            ← Backend Spring Boot
│   ├── Dockerfile
│   ├── docker-compose.yml
│   └── target/jmc-portfolio-backend.jar

/etc/nginx/sites-available/jmc-portfolio
```

### Configuración Nginx (reverse proxy)

```
server {
    listen 80;
    server_name tudominio.com www.tudominio.com;
    return 301 https://$server_name$request_uri;
}

server {
    listen 443 ssl http2;
    server_name tudominio.com;

    ssl_certificate /etc/letsencrypt/live/tudominio.com/fullchain.pem;
    ssl_certificate_key /etc/letsencrypt/live/tudominio.com/privkey.pem;

    root /var/www/jmc-portfolio;
    index index.html;

    # SPA: todas las rutas al index.html
    location / {
        try_files $uri $uri/ /index.html;
    }

    # API: proxy reverso al backend Spring Boot
    location /api/ {
        proxy_pass http://localhost:8080;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
    }

    # Assets con caché
    location ~* \.(js|css|png|jpg|jpeg|gif|ico|svg|woff2)$ {
        expires 1y;
        add_header Cache-Control "public, immutable";
    }
}
```

### Orden de despliegue

```
1. Crear VM en OCI (Ubuntu 22.04, siempre-free)
2. Instalar: Docker, Docker Compose, Nginx, Certbot
3. Clonar repositorio en la VM
4. docker-compose up -d  (backend + BD)
5. ng build --configuration production  (frontend)
6. Copiar dist/ a /var/www/jmc-portfolio/
7. Configurar Nginx y SSL (Certbot)
8. sudo systemctl reload nginx
```

---

## 6. CI/CD (GitHub Actions)

```
┌──────────────┐     ┌─────────────────┐     ┌──────────────┐
│  git push     │────▶│  GitHub Actions  │────▶│    OCI VM    │
│  a main       │     │                  │     │              │
└──────────────┘     │ 1. ng build       │     │ docker pull  │
                     │ 2. docker build   │     │ nginx reload │
                     │ 3. SCP dist/      │     │              │
                     └─────────────────┘     └──────────────┘
```
