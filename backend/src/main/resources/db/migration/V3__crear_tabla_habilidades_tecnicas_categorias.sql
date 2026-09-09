CREATE TABLE tech_skill_categories
(
    id             UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    category       VARCHAR(100) NOT NULL,
    category_order INTEGER NOT NULL,
    active         BOOLEAN DEFAULT true
);

INSERT INTO tech_skill_categories (id, category, category_order, active)
VALUES ('a1b2c3d4-e5f6-7890-a1b2-c3d4e5f67890', 'Frontend', 1, true);

INSERT INTO tech_skill_categories (id, category, category_order, active)
VALUES ('b2c3d4e5-f6a7-8901-b2c3-d4e5f67890a1', 'Backend', 2, true);