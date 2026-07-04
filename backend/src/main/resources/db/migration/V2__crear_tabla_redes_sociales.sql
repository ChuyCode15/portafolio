CREATE TABLE redes_sociales
(
    id                      UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    plataforma              VARCHAR(100) NOT NULL,
    url                     VARCHAR(255) NOT NULL,
    icono                   VARCHAR(100),
    etiqueta                VARCHAR(100),
    informacion_personal_id UUID,
    CONSTRAINT fk_informacion_personal
        FOREIGN KEY (informacion_personal_id)
            REFERENCES informacion_personal (id)
            ON DELETE CASCADE
);


INSERT INTO redes_sociales (id, plataforma, url, icono, etiqueta, informacion_personal_id)
VALUES (RANDOM_UUID(), 'GITHUB', 'https://github.com/jmcastillo', 'fab fa-github', 'GitHub',
        '88888888-8888-8888-8888-888888888888'),
       (RANDOM_UUID(), 'LINKEDIN', 'https://linkedin.com/in/jmcastillo', 'fab fa-linkedin-in', 'LinkedIn',
        '88888888-8888-8888-8888-888888888888'),
       (RANDOM_UUID(), 'EMAIL', 'mailto:juan@email.com', 'fas fa-envelope', 'Email',
        '88888888-8888-8888-8888-888888888888');