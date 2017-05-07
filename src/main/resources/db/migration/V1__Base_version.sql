CREATE TABLE `airplane` (
  `id_airplane` int(15) NOT NULL AUTO_INCREMENT,
  `model` varchar(25) NOT NULL,
  `airline` varchar(25) NOT NULL,
  `place_number` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id_airplane`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `destination` (
  `id_destination` int(15) NOT NULL AUTO_INCREMENT,
  `id_flight` int(15) NOT NULL,
  `id_city` int(15) NOT NULL,
  `airoport_name` varchar(25) NOT NULL,
  PRIMARY KEY (`id_destination`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `city` (
  `id_city` int(15) NOT NULL AUTO_INCREMENT,
  `id_destination` int(15) NOT NULL,
  `code_country` varchar(25) NOT NULL,
  `city` varchar(25) NOT NULL,
  PRIMARY KEY (`id_city`),
  KEY `id_destination` (`id_destination`),
  CONSTRAINT `city_ibfk_1` FOREIGN KEY (`id_destination`) REFERENCES `destination` (`id_destination`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ticket` (
  `id_ticket` int(15) NOT NULL AUTO_INCREMENT,
  `id_fling` int(15) NOT NULL,
  `cost` int(25) NOT NULL,
  `place` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id_ticket`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `flight` (
  `id_flight` int(15) NOT NULL AUTO_INCREMENT,
  `id_airplane` int(15) NOT NULL,
  `id_ticket` int(15) NOT NULL,
  `id_destination` int(15) NOT NULL,
  `departure_data` varchar(25) NOT NULL,
  `departure_time` varchar(25) NOT NULL,
  `arrival_data` varchar(25) NOT NULL,
  `arrival_time` varchar(25) NOT NULL,
  `aircraft_number` varchar(25) NOT NULL,
  PRIMARY KEY (`id_flight`),
  KEY `id_airplane` (`id_airplane`),
  KEY `id_ticket` (`id_ticket`),
  KEY `id_destination` (`id_destination`),
  FOREIGN KEY (`id_airplane`) REFERENCES `airplane` (`id_airplane`),
  FOREIGN KEY (`id_ticket`) REFERENCES `ticket` (`id_ticket`),
  FOREIGN KEY (`id_destination`) REFERENCES `destination` (`id_destination`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


