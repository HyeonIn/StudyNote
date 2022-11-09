CREATE TABLE `book` (
  `isbn` char(12) NOT NULL,
  `title` varchar(100) NOT NULL,
  `author` varchar(50) NOT NULL,
  `price` int NOT NULL,
  `content` text,
  `img` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `comments` (
  `comment_no` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(16) NOT NULL,
  `comment` varchar(500) NOT NULL,
  `comment_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `isbn` char(12) NOT NULL,
  PRIMARY KEY (`comment_no`),
  KEY `comment_isbn_idx` (`isbn`),
  CONSTRAINT `comment_isbn` FOREIGN KEY (`isbn`) REFERENCES `book` (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;