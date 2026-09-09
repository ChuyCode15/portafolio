CREATE TABLE personal_info
(
    id            UUID DEFAULT RANDOM_UUID() PRIMARY KEY,
    first_name    VARCHAR(255) NOT NULL,
    last_name     VARCHAR(255) NOT NULL,
    title         VARCHAR(255),
    subtitle      VARCHAR(255),
    summary       TEXT,
    email         VARCHAR(255),
    phone         VARCHAR(20),
    location      VARCHAR(255),
    photo_url     VARCHAR(255),
    cv_url        VARCHAR(255),
    availability  VARCHAR(100)
);

INSERT INTO personal_info (id, first_name, last_name, title, subtitle, summary, email, phone,
                           location, photo_url, cv_url, availability)
VALUES ('88888888-8888-8888-8888-888888888888',
        'Juan Manuel',
        'Castillo',
        'Java Backend Developer',
        'Spring Boot | Microservices | Cloud',
        'Backend Developer experienced in designing and implementing REST APIs.',
        'juan@email.com',
        '+52 55 1234 5678',
        'Mexico City, MX',
        '/assets/images/profile.jpg',
        '/api/v1/cv/download',
        'Freelance');