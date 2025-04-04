CREATE TABLE `member` (
    `created_at` datetime(6) DEFAULT NULL,
    `id` bigint PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `updated_at` datetime(6) DEFAULT NULL,
    `email` varchar(255) DEFAULT NULL,
    `password` varchar(255) DEFAULT NULL,
    `user_name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
)

CREATE TABLE `schedule` (
    `created_at` datetime(6) DEFAULT NULL,
    `id` bigint PRIMARY KEY AUTO_INCREMENT NOT NULL,
    `updated_at` datetime(6) DEFAULT NULL,
    `user_id` bigint DEFAULT NULL,
    `contents` longtext,
    `title` varchar(255) NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES `member` (`id`)
)



