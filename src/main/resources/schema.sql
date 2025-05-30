CREATE TABLE `app_users`
(
    `id`       BIGINT      NOT NULL AUTO_INCREMENT,
    `version`  INT         NOT NULL,
    `password` VARCHAR(60) DEFAULT NULL,
    `username` VARCHAR(60) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE (`username`)
);

CREATE TABLE `tag_types`
(
    `id`                     BIGINT      NOT NULL AUTO_INCREMENT,
    `version`                INT         NOT NULL,
    `name`                   varchar(40) NOT NULL,
    `background_color_dark`  varchar(7)  NOT NULL,
    `background_color_light` varchar(7)  NOT NULL,
    `text_color_dark`        varchar(7)  NOT NULL,
    `text_color_light`       varchar(7)  NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE (`name`)
);

CREATE TABLE `tags`
(
    `id`          BIGINT      NOT NULL AUTO_INCREMENT,
    `version`     INT         NOT NULL,
    `name`        varchar(40) NOT NULL,
    `tag_type_id` BIGINT      NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE (`name`),
    FOREIGN KEY (`tag_type_id`) REFERENCES `tag_types` (`id`)
);

CREATE TABLE `projects`
(
    `id`               BIGINT       NOT NULL AUTO_INCREMENT,
    `version`          INT          NOT NULL,
    `category`         enum('PERSONAL_PROJECT','PROFESSIONAL_PROJECT')  NOT NULL,
    `file_name`        varchar(255) DEFAULT NULL,
    `stored_file_name` varchar(255) DEFAULT NULL,
    `demo_link`        varchar(500) DEFAULT NULL,
    `git_link`         varchar(500) DEFAULT NULL,
    `id_video`         varchar(11)  DEFAULT NULL,
    `start_date`       date         DEFAULT NULL,
    `status`           enum('ARCHIVED','CANCELLED','IN_PROGRESS','MAINTAINED')  NOT NULL,
    `summary`          varchar(550) NOT NULL,
    `title`            varchar(100) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE (`title`)
);

CREATE TABLE `projects_tags`
(
    `fk_project_id` BIGINT NOT NULL,
    `fk_tag_id`     BIGINT NOT NULL,
    FOREIGN KEY (`fk_project_id`) REFERENCES `projects` (`id`),
    FOREIGN KEY (`fk_tag_id`) REFERENCES `tags` (`id`)
);

CREATE TABLE `project_features`
(
    `project_id` BIGINT NOT NULL,
    `features`   varchar(255) DEFAULT NULL,
    FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`)
);

CREATE TABLE `project_files`
(
    `project_id`       bigint NOT NULL,
    `file_name`        varchar(255) DEFAULT NULL,
    `stored_file_name` varchar(255) DEFAULT NULL,
    FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`)
);

CREATE TABLE `settings`
(
    `version`       INT          NOT NULL,
    `setting_key`   varchar(50)  NOT NULL,
    `is_protected`  BIT          NOT NULL,
    `setting_value` varchar(255) NOT NULL,
    PRIMARY KEY (`setting_key`),
    UNIQUE (`setting_key`)
);

CREATE TABLE `user_roles`
(
    user_id BIGINT NOT NULL,
    roles   VARCHAR(255) NULL,
    FOREIGN KEY (user_id) REFERENCES `app_users` (`id`)
);