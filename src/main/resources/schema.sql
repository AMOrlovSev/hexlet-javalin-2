DROP TABLE IF EXISTS courses;

CREATE TABLE courses (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    created_at TIMESTAMP
);

INSERT INTO courses (name, description) VALUES
('name1', 'description1'),
('name2', 'description2'),
('name3', 'description3');