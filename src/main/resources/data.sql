INSERT INTO `app_users` (`version`, `password`, `username`)
VALUES
    (0, 'password123', 'johndoe'),
    (0, 'mypassword456', 'janedoe'),
    (0, 'securePass789', 'alice'),
    (0, 'password321', 'bob'),
    (0, 'strongpass101', 'charlie');

INSERT INTO `tag_types` (`version`, `name`, `background_color_dark`, `background_color_light`,
                         `text_color_dark`, `text_color_light`)
VALUES
    (1, 'Technologies', '#3479ba', '#3479ba', '#ffffff', '#ffffff'),
    (2, 'Languages', '#401ac9', '#401ac9', '#ffffff', '#ffffff'),
    (1, 'Soft skills', '#3479ba', '#3479ba', '#ffffff', '#ffffff'),
    (3, 'Librairies', '#9c0e7d', '#9c860e', '#918a63', '#639163'),
    (2, 'Design', '#3479ba', '#3479ba', '#ffffff', '#ffffff');

INSERT INTO `tags` (`version`, `name`, `tag_type_id`)
VALUES
    (1, 'Angular', 1),
    (2, 'Java', 2),
    (1, 'React', 1),
    (3, 'Perfectionniste', 3),
    (2, 'SQL', 2);

INSERT INTO `projects` (`version`, `demo_link`, `git_link`, `id_video`, `start_date`, `status`, `summary`, `title`, `category`, `file_name`, `stored_file_name`)
VALUES
    (1, 'https://demo.project1.com', 'https://github.com/user/project1', 'video123', '2024-01-10', 'MAINTAINED', 'This project involves building a fully functional e-commerce platform.', 'E-Commerce Platform', 'PERSONAL_PROJECT', 'cover_image_1.png', NULL),
    (2, 'https://demo.project2.com', 'https://github.com/user/project2', 'video124', '2024-02-15', 'ARCHIVED', 'Mobile app development for health tracking.', 'Health Tracker App', 'PERSONAL_PROJECT', 'cover_image_2.png', NULL),
    (3, 'https://demo.project3.com', 'https://github.com/user/project3', 'video125', '2024-03-05', 'CANCELLED', 'VR game development for immersive experiences.', 'Virtual Reality Game', 'PROFESSIONAL_PROJECT', 'cover_image_3.png', NULL),
    (1, 'https://demo.project4.com', 'https://github.com/user/project4', 'video126', '2024-04-20', 'ARCHIVED', 'A desktop application for cloud-based document management.', 'Document Manager', 'PROFESSIONAL_PROJECT', 'cover_image_4.png', NULL),
    (2, 'https://demo.project5.com', 'https://github.com/user/project5', 'video127', '2024-05-01', 'IN_PROGRESS', 'A project focused on creating an interactive social media platform.', 'Social Media Platform', 'PROFESSIONAL_PROJECT', 'cover_image_5.png', NULL);

INSERT INTO `project_files` (`project_id`, `file_name`, `stored_file_name`)
VALUES
    (1, 'document1.pdf', NULL),
    (2, 'image1.jpg', NULL),
    (1, 'spreadsheet.xlsx', NULL),
    (3, 'presentation.pptx', NULL),
    (2, 'archive.zip', NULL);

INSERT INTO `projects_tags` (`fk_project_id`, `fk_tag_id`)
VALUES
    (1, 1),
    (1, 2),
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

INSERT INTO `settings` (`version`, `setting_key`, `is_protected`, `setting_value`)
VALUES
    (0, 'site_name', 1, 'My Awesome Site'),
    (0, 'site_url', 0, 'https://www.awesomesite.com'),
    (0, 'maintenance_mode', 0, 'false'),
    (0, 'max_upload_size', 1, '50MB'),
    (0, 'timezone', 0, 'UTC');

INSERT INTO `user_roles` (`user_id`, `roles`)
VALUES
    (1, 'ADMIN'),
    (2, 'USER'),
    (3, 'MODERATOR'),
    (4, 'USER'),
    (5, 'ADMIN');