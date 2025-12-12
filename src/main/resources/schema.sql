-- Criação das tabelas do banco de dados (MySQL e H2)

-- Tabela CLIENTE
CREATE TABLE IF NOT EXISTS cliente (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    cpf VARCHAR(255) NOT NULL UNIQUE,
    tipo_cliente VARCHAR(255) NOT NULL
);

-- Tabela VINIL
CREATE TABLE IF NOT EXISTS vinil (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    artista VARCHAR(255) NOT NULL,
    genero VARCHAR(255) NOT NULL,
    codigo INT NOT NULL UNIQUE,
    preco_venda FLOAT NOT NULL,
    qtd_disponivel INT NOT NULL
);

-- Tabela FUNCIONARIO
CREATE TABLE IF NOT EXISTS funcionario (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    cpf VARCHAR(255) NOT NULL UNIQUE,
    cargo VARCHAR(255) NOT NULL,
    salario FLOAT NOT NULL
);

-- Tabela COMPRA
CREATE TABLE IF NOT EXISTS compra (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    data_compra DATETIME NOT NULL,
    cliente_id BIGINT NOT NULL,
    valor_total FLOAT NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

-- Tabela ITEM_COMPRA (Join table between COMPRA and VINIL)
CREATE TABLE IF NOT EXISTS item_compra (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    quantidade INT NOT NULL,
    valor_item FLOAT NOT NULL,
    compra_id BIGINT NOT NULL,
    vinil_id BIGINT NOT NULL,
    FOREIGN KEY (compra_id) REFERENCES compra(id),
    FOREIGN KEY (vinil_id) REFERENCES vinil(id)
);
