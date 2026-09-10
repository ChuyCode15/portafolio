CREATE TABLE social_media
(
    id               UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    platform         VARCHAR(100) NOT NULL UNIQUE,
    url              VARCHAR(255) NOT NULL,
    icon             VARCHAR(100),
    label            VARCHAR(100),
    personal_info_id UUID,
    active           BOOLEAN,
    CONSTRAINT fk_social_media_personal_info
        FOREIGN KEY (personal_info_id)
            REFERENCES personal_info (id)
            ON DELETE CASCADE
);

INSERT INTO social_media (id, platform, url, icon, label, personal_info_id, active)
VALUES (RANDOM_UUID(), 'GITHUB', 'https://github.com/jmcastillo', 'fab fa-github', 'GitHub',
        '88888888-8888-8888-8888-888888888888', true),
       (RANDOM_UUID(), 'LINKEDIN', 'https://linkedin.com/in/jmcastillo', 'fab fa-linkedin-in', 'LinkedIn',
        '88888888-8888-8888-8888-888888888888', true),
       (RANDOM_UUID(), 'EMAIL', 'mailto:juan@email.com', 'fas fa-envelope', 'Email',
        '88888888-8888-8888-8888-888888888888', true);