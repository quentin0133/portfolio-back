CREATE TABLE `app_users`
(
    `id`       BIGINT AUTO_INCREMENT NOT NULL,  -- Auto-incrément pour ID
    `password` VARCHAR(255) DEFAULT NULL,       -- Password nullable
    `username` VARCHAR(255) NOT NULL,           -- Username ne peut pas être null
    PRIMARY KEY (`id`),
    UNIQUE (`username`)                         -- Unicité sur le nom d'utilisateur
);

CREATE TABLE `tags`
(
    `id`                    BIGINT NOT NULL AUTO_INCREMENT,
    `version`               INT     NOT NULL,
    `background_color`      varchar(20) NOT NULL,
    `tag_name`              varchar(40) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE (`tag_name`)
);

CREATE TABLE `categories`
(
    `id`             BIGINT NOT NULL AUTO_INCREMENT,
    `version`        INT     NOT NULL,
    `title`          varchar(40) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE (`title`),
);

CREATE TABLE `files`
(
    `id`      BIGINT NOT NULL AUTO_INCREMENT,
    `version` INT      NOT NULL,
    `data`    longblob DEFAULT NULL,
    `name`    varchar(255) NOT NULL,
    `type`    varchar(255) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE (`name`)
);

CREATE TABLE `projects`
(
    `id`            BIGINT NOT NULL AUTO_INCREMENT,
    `version`       INT      NOT NULL,
    `demo_link`     varchar(255)                                          DEFAULT NULL,
    `git_link`      varchar(255)                                          DEFAULT NULL,
    `id_video`      varchar(255)                                          DEFAULT NULL,
    `start_date`    date                                                  DEFAULT NULL,
    `status`        enum ('ARCHIVED','FINISHED','IN_PROGRESS','ON_BREAK') DEFAULT NULL,
    `summary`       varchar(550)                                          DEFAULT NULL,
    `title`         varchar(100) NOT NULL,
    `fk_cover_image_id` BIGINT NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE (`title`),
    UNIQUE (`fk_project_id`),
    FOREIGN KEY (`fk_project_id`) REFERENCES `files` (`id`)
);

CREATE TABLE `project_category`
(
    `fk_project_id`  BIGINT NOT NULL,
    `fk_category_id` BIGINT NOT NULL,
    FOREIGN KEY (`fk_category_id`) REFERENCES `categories` (`id`),
    FOREIGN KEY (`fk_project_id`) REFERENCES `projects` (`id`)
);

CREATE TABLE `project_features`
(
    `project_id` BIGINT NOT NULL,
    `features`   varchar(255) DEFAULT NULL,
    FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`)
);

CREATE TABLE `projects_files`
(
    `project_id` BIGINT NOT NULL,
    `files_id`   BIGINT NOT NULL,
    FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`),
    FOREIGN KEY (`files_id`) REFERENCES `files` (`id`)
);

CREATE TABLE `settings`
(
    `setting_key`   varchar(50) NOT NULL,
    `is_protected`  BIT       NOT NULL,
    `setting_value` varchar(255) NOT NULL,
    PRIMARY KEY (`setting_key`),
    UNIQUE (`setting_key`)
);

CREATE TABLE `user_roles`
(
    user_id BIGINT       NOT NULL,
    roles   VARCHAR(255) NULL
);

ALTER TABLE user_roles ADD CONSTRAINT fk_user_roles_on_user FOREIGN KEY (user_id) REFERENCES app_users (id);