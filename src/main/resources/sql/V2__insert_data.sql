-- Inserção de Pedidos
INSERT INTO TB_PEDIDO (ST_PEDIDO, TP_CANAL, TS_CRIACAO, PC_PEDIDO, NU_PEDIDO) VALUES
('PENDENTE', 'APLICATIVO', NOW(), 150.00, 'PEDIDO001'),
('CONFIRMADO', 'SITE', NOW(), 200.00, 'PEDIDO002'),
('ENTREGUE', 'MARKETPLACE', NOW(), 300.00, 'PEDIDO003'),
('CANCELADO', 'SITE', NOW(), 50.00, 'PEDIDO004'),
('PENDENTE', 'APLICATIVO', NOW(), 120.00, 'PEDIDO005'),
('CONFIRMADO', 'MARKETPLACE', NOW(), 250.00, 'PEDIDO006'),
('PENDENTE', 'SITE', NOW(), 180.00, 'PEDIDO007'),
('ENTREGUE', 'MARKETPLACE', NOW(), 220.00, 'PEDIDO008'),
('CANCELADO', 'APLICATIVO', NOW(), 90.00, 'PEDIDO009'),
('CONFIRMADO', 'SITE', NOW(), 160.00, 'PEDIDO010');

-- Inserção de Itens para Pedido 1
INSERT INTO TB_ITENS (ID_PEDIDO, NU_ITEM, ID_PRODUTO, NO_PRODUTO, DS_ATRIBUTOS, DS_DESCRICAO, QT_PRODUTO, PC_PRODUTO) VALUES
(1, 1, 101, 'Produto A', 'Tamanho M', 'Descrição do Produto A', 2, 30.00),
(1, 2, 102, 'Produto B', 'Cor Azul', 'Descrição do Produto B', 1, 50.00),
(1, 3, 103, 'Produto C', 'Tamanho P', 'Descrição do Produto C', 1, 70.00);

-- Inserção de Itens para Pedido 2
INSERT INTO TB_ITENS (ID_PEDIDO, NU_ITEM, ID_PRODUTO, NO_PRODUTO, DS_ATRIBUTOS, DS_DESCRICAO, QT_PRODUTO, PC_PRODUTO) VALUES
(2, 1, 104, 'Produto D', 'Tamanho G', 'Descrição do Produto D', 3, 30.00),
(2, 2, 105, 'Produto E', 'Cor Vermelha', 'Descrição do Produto E', 1, 40.00),
(2, 3, 106, 'Produto F', 'Cor Verde', 'Descrição do Produto F', 2, 60.00);

-- Inserção de Itens para Pedido 3
INSERT INTO TB_ITENS (ID_PEDIDO, NU_ITEM, ID_PRODUTO, NO_PRODUTO, DS_ATRIBUTOS, DS_DESCRICAO, QT_PRODUTO, PC_PRODUTO) VALUES
(3, 1, 107, 'Produto G', 'Tamanho M', 'Descrição do Produto G', 2, 40.00),
(3, 2, 108, 'Produto H', 'Cor Preta', 'Descrição do Produto H', 1, 100.00),
(3, 3, 109, 'Produto I', 'Tamanho P', 'Descrição do Produto I', 3, 20.00);

-- Inserção de Itens para Pedido 4
INSERT INTO TB_ITENS (ID_PEDIDO, NU_ITEM, ID_PRODUTO, NO_PRODUTO, DS_ATRIBUTOS, DS_DESCRICAO, QT_PRODUTO, PC_PRODUTO) VALUES
(4, 1, 110, 'Produto J', 'Tamanho Único', 'Descrição do Produto J', 1, 20.00),
(4, 2, 111, 'Produto K', 'Cor Branca', 'Descrição do Produto K', 1, 30.00),
(4, 3, 112, 'Produto L', 'Tamanho M', 'Descrição do Produto L', 1, 50.00);

-- Inserção de Itens para Pedido 5
INSERT INTO TB_ITENS (ID_PEDIDO, NU_ITEM, ID_PRODUTO, NO_PRODUTO, DS_ATRIBUTOS, DS_DESCRICAO, QT_PRODUTO, PC_PRODUTO) VALUES
(5, 1, 113, 'Produto M', 'Tamanho G', 'Descrição do Produto M', 2, 30.00),
(5, 2, 114, 'Produto N', 'Cor Laranja', 'Descrição do Produto N', 1, 50.00),
(5, 3, 115, 'Produto O', 'Cor Azul', 'Descrição do Produto O', 1, 40.00);

-- Inserção de Itens para Pedido 6
INSERT INTO TB_ITENS (ID_PEDIDO, NU_ITEM, ID_PRODUTO, NO_PRODUTO, DS_ATRIBUTOS, DS_DESCRICAO, QT_PRODUTO, PC_PRODUTO) VALUES
(6, 1, 116, 'Produto P', 'Tamanho P', 'Descrição do Produto P', 3, 40.00),
(6, 2, 117, 'Produto Q', 'Cor Rosa', 'Descrição do Produto Q', 2, 70.00),
(6, 3, 118, 'Produto R', 'Cor Amarela', 'Descrição do Produto R', 1, 90.00);

-- Inserção de Itens para Pedido 7
INSERT INTO TB_ITENS (ID_PEDIDO, NU_ITEM, ID_PRODUTO, NO_PRODUTO, DS_ATRIBUTOS, DS_DESCRICAO, QT_PRODUTO, PC_PRODUTO) VALUES
(7, 1, 119, 'Produto S', 'Tamanho M', 'Descrição do Produto S', 2, 50.00),
(7, 2, 120, 'Produto T', 'Cor Azul', 'Descrição do Produto T', 1, 70.00),
(7, 3, 121, 'Produto U', 'Tamanho G', 'Descrição do Produto U', 1, 60.00);

-- Inserção de Itens para Pedido 8
INSERT INTO TB_ITENS (ID_PEDIDO, NU_ITEM, ID_PRODUTO, NO_PRODUTO, DS_ATRIBUTOS, DS_DESCRICAO, QT_PRODUTO, PC_PRODUTO) VALUES
(8, 1, 122, 'Produto V', 'Tamanho G', 'Descrição do Produto V', 1, 30.00),
(8, 2, 123, 'Produto W', 'Cor Preta', 'Descrição do Produto W', 2, 50.00),
(8, 3, 124, 'Produto X', 'Tamanho P', 'Descrição do Produto X', 1, 70.00);

-- Inserção de Itens para Pedido 9
INSERT INTO TB_ITENS (ID_PEDIDO, NU_ITEM, ID_PRODUTO, NO_PRODUTO, DS_ATRIBUTOS, DS_DESCRICAO, QT_PRODUTO, PC_PRODUTO) VALUES
(9, 1, 125, 'Produto Y', 'Tamanho Único', 'Descrição do Produto Y', 1, 40.00),
(9, 2, 126, 'Produto Z', 'Cor Verde', 'Descrição do Produto Z', 3, 30.00),
(9, 3, 127, 'Produto AA', 'Tamanho M', 'Descrição do Produto AA', 2, 20.00);

-- Inserção de Itens para Pedido 10
INSERT INTO TB_ITENS (ID_PEDIDO, NU_ITEM, ID_PRODUTO, NO_PRODUTO, DS_ATRIBUTOS, DS_DESCRICAO, QT_PRODUTO, PC_PRODUTO) VALUES
(10, 1, 128, 'Produto AB', 'Tamanho Único', 'Descrição do Produto AB', 2, 30.00),
(10, 2, 129, 'Produto AC', 'Cor Amarela', 'Descrição do Produto AC', 1, 60.00),
(10, 3, 130, 'Produto AD', 'Tamanho P', 'Descrição do Produto AD', 1, 70.00);
