CREATE TABLE informacion_personal
(
    id                 UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    nombre             VARCHAR(255) NOT NULL,
    apellido           VARCHAR(255) NOT NULL,
    titulo             VARCHAR(255),
    subtitulo          VARCHAR(255),
    resumen            TEXT,
    correo_electronico VARCHAR(255),
    telefono           VARCHAR(20),
    ubicacion          VARCHAR(255),
    url_foto           VARCHAR(255),
    url_cv             VARCHAR(255),
    disponibilidad     VARCHAR(100)
);

INSERT INTO informacion_personal (id, nombre, apellido, titulo, subtitulo, resumen, correo_electronico, telefono,
                                  ubicacion, url_foto, url_cv, disponibilidad)
VALUES ('88888888-8888-8888-8888-888888888888',
        'Juan Manuel',
        'Castillo',
        'Java Backend Developer',
        'Spring Boot | Microservicios | Cloud',
        'Backend Developer con experiencia en diseño e implementación de APIs REST.',
        'juan@email.com',
        '+52 55 1234 5678',
        'Ciudad de México, MX',
        '/assets/images/profile.jpg',
        '/api/v1/cv/download',
        'Freelance');