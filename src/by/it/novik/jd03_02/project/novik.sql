-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1:2016
-- Время создания: Июл 07 2016 г., 11:28
-- Версия сервера: 10.1.10-MariaDB
-- Версия PHP: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `novik`
--

-- --------------------------------------------------------

--
-- Структура таблицы `account`
--

CREATE TABLE `account` (
  `ID` int(11) NOT NULL,
  `Balans` decimal(50,0) NOT NULL,
  `State` enum('Working','Lock') NOT NULL,
  `FK_Users` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `account`
--

INSERT INTO `account` (`ID`, `Balans`, `State`, `FK_Users`) VALUES
(1, '250', 'Working', 1),
(2, '547', 'Working', 1),
(3, '3456', 'Working', 1);

-- --------------------------------------------------------

--
-- Структура таблицы `payment`
--

CREATE TABLE `payment` (
  `ID` int(11) NOT NULL,
  `FK_Account_Source` int(11) NOT NULL,
  `FK_Account_Destination` int(11) NOT NULL,
  `Description` varchar(200) NOT NULL,
  `Amount` decimal(50,0) NOT NULL,
  `Paydate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `payment`
--

INSERT INTO `payment` (`ID`, `FK_Account_Source`, `FK_Account_Destination`, `Description`, `Amount`, `Paydate`) VALUES
(1, 1, 2, 'Перевод средств', '50', '2016-07-13'),
(2, 3, 1, 'Перевод средств', '100', '2016-07-01'),
(3, 2, 1, 'Перевод средств', '10', '2016-06-06');

-- --------------------------------------------------------

--
-- Структура таблицы `role`
--

CREATE TABLE `role` (
  `ID` int(11) NOT NULL COMMENT 'Primary Key',
  `Role` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `role`
--

INSERT INTO `role` (`ID`, `Role`) VALUES
(1, 'Admin'),
(2, 'User');

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `First_Name` varchar(20) NOT NULL,
  `Middle_Name` varchar(20) NOT NULL,
  `Last_Name` varchar(20) NOT NULL,
  `Passport` varchar(100) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Phone` varchar(13) NOT NULL,
  `Login` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `FK_Role` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`ID`, `First_Name`, `Middle_Name`, `Last_Name`, `Passport`, `Address`, `Phone`, `Login`, `Password`, `Email`, `FK_Role`) VALUES
(1, 'Иван', 'Иванович', 'Иванов', 'MC234567, 15.08.2010', 'г. Жодино, ул. Калиновского 5-8', '+375296785643', 'ivan', '123', 'ivanov_iv@gmail.com', 2),
(2, 'Петр', 'Петрович', 'Петров', 'MC 456789, 12.06.1999', 'г. Минск, ул. Энгельса 6-8', '+375447774323', 'petr', '456', 'petrov_p@gmail.com', 1);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_Users` (`FK_Users`);

--
-- Индексы таблицы `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_Account_Source` (`FK_Account_Source`),
  ADD KEY `FK_Account_Destination` (`FK_Account_Destination`);

--
-- Индексы таблицы `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_Role` (`FK_Role`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `account`
--
ALTER TABLE `account`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT для таблицы `payment`
--
ALTER TABLE `payment`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT для таблицы `role`
--
ALTER TABLE `role`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Primary Key', AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `account_ibfk_1` FOREIGN KEY (`FK_Users`) REFERENCES `users` (`ID`);

--
-- Ограничения внешнего ключа таблицы `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`FK_Account_Source`) REFERENCES `account` (`ID`),
  ADD CONSTRAINT `payment_ibfk_2` FOREIGN KEY (`FK_Account_Destination`) REFERENCES `account` (`ID`);

--
-- Ограничения внешнего ключа таблицы `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`FK_Role`) REFERENCES `role` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
