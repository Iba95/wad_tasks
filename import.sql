

-- Datenbank: `tasksdb`


-- --------------------------------------------------------
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


-- --------------------------------------------------------


-- Tabellenstruktur für Tabelle `tasks`



CREATE TABLE `tasks` (
  `id` int(10) UNSIGNED NOT NULL,
  `title` varchar(32) NOT NULL,
  `description` varchar(128) NOT NULL,
  `date` datetime NOT NULL,
  `id_status` int(10) UNSIGNED NOT NULL,
  `id_reference` int(10) UNSIGNED NOT NULL,
  `id_contact` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- Daten für Tabelle `tasks`


INSERT INTO `tasks` (`id`, `title`, `description`, `date`, `id_status`, `id_reference`, `id_contact`) VALUES
(1, 'task1', 'A dummy description for task1', '2020-12-16 13:10:14', 1, 1, 2),
(2, 'task2', 'A dummy description for task2', '2020-12-16 14:10:14', 4, 2, 1),
(3, 'task3', 'A dummy description for task3', '2020-12-16 15:10:14', 2, 1, 3),
(4, 'task4', 'A dummy description for task4', '2020-12-16 16:10:14', 5, 2, 1),
(5, 'task5', 'A dummy description for task5', '2020-12-16 17:10:14', 2, 3, 1),
(6, 'task6', 'A dummy description for task6', '2020-12-16 18:10:14', 3, 3, 2),
(7, 'task7', 'A dummy description for task7', '2020-12-16 19:10:14', 4, 2, 1),
(8, 'task8', 'A dummy description for task8', '2020-12-16 20:10:14', 3, 1, 2),
(9, 'task9', 'A dummy description for task9', '2020-12-16 21:10:14', 1, 1, 1);

-- --------------------------------------------------------


-- Tabellenstruktur für Tabelle `status` 



CREATE TABLE `status` (
  `id` int(10) UNSIGNED NOT NULL,
  `status` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- Daten für Tabelle `status`


INSERT INTO `status` (`id`, `status`) VALUES
(1, 'Idea'),
(2, 'Todo Next'),
(3, 'Doing'),
(4, 'In Review'),
(5, 'Done');

-- --------------------------------------------------------


-- Tabellenstruktur für Tabelle `contacts` 



CREATE TABLE `contacts` (
  `id` int(10) UNSIGNED NOT NULL,
  `email` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `contacts`
--

INSERT INTO `contacts` (`id`, `email`) VALUES
(1, 'contact1@example.com'),
(2, 'contact2@example.com'),
(3, 'contact3@example.com');

-- --------------------------------------------------------


-- Tabellenstruktur für Tabelle `reference` 



CREATE TABLE `reference` (
  `id` int(10) UNSIGNED NOT NULL,
  `url` varchar(128) NOT NULL,
  `type` varchar(32) NOT NULL DEFAULT 'url'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- Daten für Tabelle `reference`


INSERT INTO `reference` (`id`, `url`, `type`) VALUES
(1, 'https://www.paper.com','paper'),
(2, 'https://www.document.com','document'),
(3, 'https://www.reference.com', 'reference');


ALTER TABLE `tasks`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_status_idx` (`id_status`),
  ADD KEY `id_reference_idx` (`id_reference`),
  ADD KEY `id_contact_idx` (`id_contact`);
  
ALTER TABLE `status`
  ADD PRIMARY KEY (`id`);
  
ALTER TABLE `contacts`
  ADD PRIMARY KEY (`id`);
  
ALTER TABLE `reference`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `tasks`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;


ALTER TABLE `contacts`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

ALTER TABLE `reference`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=110;
