CREATE TABLE habilidades_tecnicas_categoria
(
    id             UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    category       VARCHAR(100) NOT NULL,
    category_order INTEGER NOT NULL,
    activo              BOOLEAN DEFAULT true
);

