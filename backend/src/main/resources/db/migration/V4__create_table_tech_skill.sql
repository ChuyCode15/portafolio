CREATE TABLE tech_skills
(
    id                  UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    name                VARCHAR(100) NOT NULL,
    level               INTEGER,
    icon                VARCHAR(100),
    color               VARCHAR(7),
    years_of_experience INTEGER,
    active              BOOLEAN DEFAULT true,
    skill_category_id   UUID,
    CONSTRAINT fk_tech_skills_skill_category
        FOREIGN KEY (skill_category_id)
            REFERENCES tech_skill_categories (id)
            ON DELETE CASCADE
);

INSERT INTO tech_skills (id, name, level, icon, color, years_of_experience, active, skill_category_id)
VALUES (RANDOM_UUID(), 'React', 90, 'react-icon', '#61DAFB', 3, true, 'a1b2c3d4-e5f6-7890-a1b2-c3d4e5f67890');

INSERT INTO tech_skills (id, name, level, icon, color, years_of_experience, active, skill_category_id)
VALUES (RANDOM_UUID(), 'Java', 85, 'java-icon', '#007396', 4, true, 'b2c3d4e5-f6a7-8901-b2c3-d4e5f67890a1');