-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-01-2018 a las 20:30:06
-- Versión del servidor: 5.6.16
-- Versión de PHP: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `juegostore`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(40) NOT NULL,
  `Tarjeta` int(11) DEFAULT NULL,
  `Activo` tinyint(1) NOT NULL,
  `DNI` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`ID`, `Nombre`, `Tarjeta`, `Activo`, `DNI`) VALUES
(17, 'paco', 12345, 1, 1234);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE IF NOT EXISTS `compra` (
  `ID` int(11) NOT NULL,
  `CosteTotal` double NOT NULL,
  `Fecha` date NOT NULL,
  `Activo` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contiene`
--

CREATE TABLE IF NOT EXISTS `contiene` (
  `Compra` int(11) NOT NULL,
  `Videojuego` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Activo` tinyint(1) NOT NULL,
  PRIMARY KEY (`Compra`,`Videojuego`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dependiente`
--

CREATE TABLE IF NOT EXISTS `dependiente` (
  `id` int(11) NOT NULL,
  `productividad` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `efectua`
--

CREATE TABLE IF NOT EXISTS `efectua` (
  `Cliente` int(11) NOT NULL,
  `Compra` int(11) NOT NULL,
  PRIMARY KEY (`Cliente`,`Compra`),
  KEY `Compra` (`Compra`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE IF NOT EXISTS `empleados` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `dni` varchar(10) NOT NULL,
  `telefono` int(11) NOT NULL,
  `activo` tinyint(4) NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialista`
--

CREATE TABLE IF NOT EXISTS `especialista` (
  `id` int(11) NOT NULL,
  `funcion` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `juegoconsola`
--

CREATE TABLE IF NOT EXISTS `juegoconsola` (
  `ID` int(11) NOT NULL,
  `Marca` varchar(10) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `juegoconsola`
--

INSERT INTO `juegoconsola` (`ID`, `Marca`) VALUES
(29, 'chony'),
(31, 'Gondor');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `juegopc`
--

CREATE TABLE IF NOT EXISTS `juegopc` (
  `ID` int(11) NOT NULL,
  `Sistema` varchar(10) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `juegopc`
--

INSERT INTO `juegopc` (`ID`, `Sistema`) VALUES
(27, 'windows'),
(28, 'windows'),
(30, 'D20');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `presupuesto`
--

CREATE TABLE IF NOT EXISTS `presupuesto` (
  `cantidad` int(11) NOT NULL,
  `activo` tinyint(4) NOT NULL,
  `version` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seccion`
--

CREATE TABLE IF NOT EXISTS `seccion` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `activo` tinyint(4) NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tienda`
--

CREATE TABLE IF NOT EXISTS `tienda` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `activo` tinyint(4) NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tienda`
--

INSERT INTO `tienda` (`id`, `nombre`, `descripcion`, `activo`, `version`) VALUES
(1, 'FNAC', 'madrid', 1, 1),
(2, 'GAME', 'madrid', 1, 1),
(8, 'juego', 'madrid', 1, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `videojuegos`
--

CREATE TABLE IF NOT EXISTS `videojuegos` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `desarrollador` varchar(40) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `precio` double NOT NULL,
  `activo` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=32 ;

--
-- Volcado de datos para la tabla `videojuegos`
--

INSERT INTO `videojuegos` (`ID`, `desarrollador`, `nombre`, `precio`, `activo`) VALUES
(27, 'pont', 'pipo y paco van al circo', 123, 1),
(28, 'pont', 'pipo y paco van al zoo', 129, 1),
(29, 'pont', 'pipo se comrpa una play', 110, 1),
(30, 'PontSW', 'Pont-chis', 999, 0),
(31, 'PontSW', 'pOca', 4, 1);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `juegoconsola`
--
ALTER TABLE `juegoconsola`
  ADD CONSTRAINT `juegoconsola_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `videojuegos` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
