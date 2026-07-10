CREATE TABLE habilidades_tecnicas
(
    id                  UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    nombre              VARCHAR(100) NOT NULL,
    nivel               INTEGER,
    icono               VARCHAR(100),
    color               VARCHAR(7), -- Para guardar códigos HEX como #FFFFFF
    years_of_experience INTEGER,
    activo              BOOLEAN DEFAULT true,
    skill_category_id   UUID,
    CONSTRAINT fk_categoria
        FOREIGN KEY (skill_category_id)
            REFERENCES habilidades_tecnicas_categoria (id)
            ON DELETE CASCADE
);