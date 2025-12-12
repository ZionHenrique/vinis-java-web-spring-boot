-- Dados iniciais para teste no MySQL
-- Este arquivo é executado automaticamente ao iniciar a aplicação com perfil prod

-- Limpar dados existentes (se houver)
DELETE FROM item_compra;
DELETE FROM compra;
DELETE FROM funcionario;
DELETE FROM vinil;
DELETE FROM cliente;

-- Inserir Clientes
INSERT INTO cliente (nome, email, cpf, tipo_cliente) VALUES 
('João Silva', 'joao@example.com', '12345678901', 'Regular'),
('Maria Santos', 'maria@example.com', '98765432109', 'VIP'),
('Carlos Oliveira', 'carlos@example.com', '55555555555', 'Regular');

-- Inserir Vinis
INSERT INTO vinil (titulo, artista, genero, codigo, preco_venda, qtd_disponivel) VALUES 
('Thriller', 'Michael Jackson', 'Pop', 1001, 150.00, 10),
('The Dark Side of the Moon', 'Pink Floyd', 'Rock Progressivo', 1002, 180.00, 5),
('Abbey Road', 'The Beatles', 'Rock', 1003, 200.00, 8),
('Rumours', 'Fleetwood Mac', 'Rock', 1004, 160.00, 12);

-- Inserir Funcionários
INSERT INTO funcionario (nome, email, cpf, cargo, salario) VALUES 
('Ana Costa', 'ana@loja.com', '11111111111', 'Vendedor', 2500.00),
('Pedro Mendes', 'pedro@loja.com', '22222222222', 'Gerente', 4000.00),
('Lucas Ferreira', 'lucas@loja.com', '33333333333', 'Estoquista', 2000.00);

-- Inserir Compras (exemplo)
INSERT INTO compra (data_compra, cliente_id, valor_total) VALUES 
('2025-12-10 14:30:00', 1, 330.00),
('2025-12-11 10:15:00', 2, 200.00);

-- Inserir Itens da Compra
INSERT INTO item_compra (quantidade, valor_item, compra_id, vinil_id) VALUES 
(1, 150.00, 1, 1),
(1, 180.00, 1, 2),
(1, 200.00, 2, 3);
