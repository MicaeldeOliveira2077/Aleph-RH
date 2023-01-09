-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 19-Dez-2022 às 23:04
-- Versão do servidor: 10.4.8-MariaDB
-- versão do PHP: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `rh`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `admin`
--

CREATE TABLE `admin` (
  `ad_id` int(11) NOT NULL,
  `ad_nome` varchar(50) NOT NULL,
  `ad_cpf` char(11) NOT NULL,
  `ad_senha` varchar(160) NOT NULL,
  `credencial` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `admin`
--

INSERT INTO `admin` (`ad_id`, `ad_nome`, `ad_cpf`, `ad_senha`, `credencial`) VALUES
(1, 'André Luferat', '00987654321', '701b389b848a2b1cfab867093101d8d5ac56addd', ''),
(2, 'Micael de Oliveira Santana', '14524563898', '93d51f52fbdfe1e944f084727df24993e88caee7', ''),
(3, 'João Jones', '98765432100', '1019f9f8bbd917cbb3f39d6afa655baf1c2aae26', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `agenda`
--

CREATE TABLE `agenda` (
  `Agd_id` int(11) NOT NULL,
  `Data_agd` date NOT NULL,
  `Assunto` varchar(50) NOT NULL,
  `Texto` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `agenda`
--

INSERT INTO `agenda` (`Agd_id`, `Data_agd`, `Assunto`, `Texto`) VALUES
(2, '2022-12-30', 'Encontro de manhã', 'Encontro de gerentes da empresa para discutir sobre a contratação de novos funcionários'),
(4, '2022-12-27', 'Cadastro', 'Cadastro de novo funcionário às 12:30');

-- --------------------------------------------------------

--
-- Estrutura da tabela `escala`
--

CREATE TABLE `escala` (
  `esc_id` int(11) NOT NULL,
  `expediente` varchar(50) NOT NULL,
  `folga` date NOT NULL,
  `falta` date NOT NULL,
  `ferias` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `fun_id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `data_nascimento` date NOT NULL,
  `cpf` char(21) NOT NULL,
  `tel` varchar(20) NOT NULL,
  `endereco` varchar(50) NOT NULL,
  `entrada` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`fun_id`, `nome`, `data_nascimento`, `cpf`, `tel`, `endereco`, `entrada`) VALUES
(14, 'André Luferat', '2022-12-13', '606.060.606-06', '(21)96895-5669', 'Rua Jacobina, No 211, bairro Pequena Vila', '2022-12-14'),
(15, 'Filipino Fernandes', '2022-12-14', '987.654.321-00', '(21)94516-4211', 'Rua Paranã, 211, bairro Bonsucesso', '2022-12-22'),
(16, 'Gabriel Jr.', '2022-12-23', '845.121.518-15', '(21)54212-1212', 'Rua Caxias, No 101, bairro Vasconcellos', '2022-12-31'),
(17, 'Ferdinand Guimarães', '2022-12-14', '696.969.696-96', '(21)95445-2424', 'Rua de Janeiro, No 988, bairro Rousseau', '2022-12-13'),
(18, 'Jorge Figueiredo', '2022-12-30', '707.070.707-07', '(21)99967-2234', 'Rua Catacumba, No 95, bairro Campo Grande', '2022-12-21'),
(19, 'José Maranã', '2022-12-14', '123.456.789-00', '(99)93333-3333', 'Rua da Maçã, 233, Bloco 11, Ap 507', '2022-12-14'),
(20, 'João Marquês de Sade', '1999-07-22', '852.654.789-21', '(22)99874-5211', 'Rua Perdizes, No 99, bairro Tijucano', '2019-02-05');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`ad_id`);

--
-- Índices para tabela `agenda`
--
ALTER TABLE `agenda`
  ADD PRIMARY KEY (`Agd_id`);

--
-- Índices para tabela `escala`
--
ALTER TABLE `escala`
  ADD PRIMARY KEY (`esc_id`);

--
-- Índices para tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`fun_id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `admin`
--
ALTER TABLE `admin`
  MODIFY `ad_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `agenda`
--
ALTER TABLE `agenda`
  MODIFY `Agd_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `escala`
--
ALTER TABLE `escala`
  MODIFY `esc_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `fun_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `escala`
--
ALTER TABLE `escala`
  ADD CONSTRAINT `escala_ibfk_1` FOREIGN KEY (`esc_id`) REFERENCES `funcionario` (`fun_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
