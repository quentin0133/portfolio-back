INSERT INTO `app_users` (`id`, `password`, `username`)
VALUES
    (1, 'password123', 'johndoe'),
    (2, 'mypassword456', 'janedoe'),
    (3, 'securePass789', 'alice'),
    (4, 'password321', 'bob'),
    (5, 'strongpass101', 'charlie');

INSERT INTO `tags` (`version`, `background_color`, `tag_name`)
VALUES
    (1, '#3479ba', 'General'),
    (2, '#3479ba', 'Spring'),
    (1, '#3479ba', 'Angular'),
    (3, '#3479ba', 'Fullstack'),
    (2, '#3479ba', 'MariaDB');

INSERT INTO `categories` (`version`, `title`, `fk_category_id`)
VALUES
    (1, 'Technology', 1),
    (2, 'Lifestyle', 2),
    (1, 'Business', 1),
    (3, 'Entertainment', 3),
    (2, 'Health', 2);

INSERT INTO `files` (`version`, `data`, `name`, `type`)
VALUES
    (1, NULL, 'document1.pdf', 'application/pdf'),
    (2, NULL, 'image1.jpg', 'image/jpeg'),
    (1, NULL, 'spreadsheet.xlsx', 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'),
    (3, NULL, 'presentation.pptx', 'application/vnd.openxmlformats-officedocument.presentationml.presentation'),
    (2, NULL, 'archive.zip', 'application/zip');

INSERT INTO `projects` (`version`, `demo_link`, `git_link`, `id_video`, `start_date`, `status`, `summary`, `title`, `fk_project_id`)
VALUES
    (1, 'https://demo.project1.com', 'https://github.com/user/project1', 'video123', '2024-01-10', 'IN_PROGRESS', 'This project involves building a fully functional e-commerce platform.', 'E-Commerce Platform', 1),
    (2, 'https://demo.project2.com', 'https://github.com/user/project2', 'video124', '2024-02-15', 'FINISHED', 'Mobile app development for health tracking.', 'Health Tracker App', 2),
    (3, 'https://demo.project3.com', 'https://github.com/user/project3', 'video125', '2024-03-05', 'ON_BREAK', 'VR game development for immersive experiences.', 'Virtual Reality Game', 3),
    (1, 'https://demo.project4.com', 'https://github.com/user/project4', 'video126', '2024-04-20', 'ARCHIVED', 'A desktop application for cloud-based document management.', 'Document Manager', 4),
    (2, 'https://demo.project5.com', 'https://github.com/user/project5', 'video127', '2024-05-01', 'IN_PROGRESS', 'A project focused on creating an interactive social media platform.', 'Social Media Platform', 5);

INSERT INTO `project_category` (`fk_project_id`, `fk_category_id`)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 1),
    (5, 4);

INSERT INTO `project_tags` (`fk_project_id`, `fk_tags_id`)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 1),
    (5, 4);

INSERT INTO `project_features` (`project_id`, `features`)
VALUES
    (1, 'Web development, Responsive design, API integration'),
    (2, 'Mobile app development, Push notifications, Offline mode'),
    (3, 'Game development, Multiplayer support, Virtual reality'),
    (4, 'Desktop application, Data synchronization, Cloud integration'),
    (5, 'E-commerce platform, Payment gateway, User authentication');

INSERT INTO `projects_files` (`project_id`, `files_id`)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5);

INSERT INTO `settings` (`setting_key`, `is_protected`, `setting_value`)
VALUES
    ('site_name', 1, 'My Awesome Site'),    -- Exemple de paramètre protégé (is_protected = 1)
    ('site_url', 0, 'https://www.awesomesite.com'),  -- Exemple de paramètre non protégé
    ('maintenance_mode', 0, 'false'),       -- Exemple de paramètre non protégé (mode maintenance)
    ('max_upload_size', 1, '50MB'),         -- Exemple de paramètre protégé
    ('timezone', 0, 'UTC');                 -- Exemple de paramètre non protégé

INSERT INTO `user_roles` (`user_id`, `roles`)
VALUES
    (1, 'ADMIN'),  -- L'utilisateur avec ID 1 a le rôle ADMIN
    (2, 'USER'),   -- L'utilisateur avec ID 2 a le rôle USER
    (3, 'MODERATOR'),  -- L'utilisateur avec ID 3 a le rôle MODERATOR
    (4, 'USER'),   -- L'utilisateur avec ID 4 a le rôle USER
    (5, 'ADMIN');  -- L'utilisateur avec ID 5 a le rôle ADMIN