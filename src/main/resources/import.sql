-- Insertar 10 empresas
INSERT INTO company (id, name, date_of_accession) VALUES ('550e8400-e29b-41d4-a716-446655440000', 'Tech Solutions', '2025-02-15 10:30:00');
INSERT INTO company (id, name, date_of_accession) VALUES ('550e8400-e29b-41d4-a716-446655440001', 'Global Corp', '2025-02-10 14:15:00');
INSERT INTO company (id, name, date_of_accession) VALUES ('550e8400-e29b-41d4-a716-446655440002', 'InnovaSoft', '2025-01-05 09:00:00');
INSERT INTO company (id, name, date_of_accession) VALUES ('550e8400-e29b-41d4-a716-446655440003', 'Smart Finance', '2025-02-01 16:45:00');
INSERT INTO company (id, name, date_of_accession) VALUES ('550e8400-e29b-41d4-a716-446655440004', 'FinancePro', '2024-12-12 11:00:00');
INSERT INTO company (id, name, date_of_accession) VALUES ('550e8400-e29b-41d4-a716-446655440005', 'GreenTech', '2025-02-05 08:30:00');
INSERT INTO company (id, name, date_of_accession) VALUES ('550e8400-e29b-41d4-a716-446655440006', 'NextGen Solutions', '2025-02-09 13:20:00');
INSERT INTO company (id, name, date_of_accession) VALUES ('550e8400-e29b-41d4-a716-446655440007', 'Cloud Innovators', '2025-02-12 15:45:00');
INSERT INTO company (id, name, date_of_accession) VALUES ('550e8400-e29b-41d4-a716-446655440008', 'Solar Impact', '2025-01-30 10:25:00');
INSERT INTO company (id, name, date_of_accession) VALUES ('550e8400-e29b-41d4-a716-446655440009', 'AquaTech', '2024-07-11 14:50:00');

-- Insertar 50 transferencias para 10 empresas (5 transferencias por empresa)
INSERT INTO transfer (id, amount, transfer_type, date_of_transfer, company_id) VALUES ('fcd846d1-350f-45cf-b881-799a7e319d62', 1200.00, 'CUENTA_DEBITO', '2024-12-15 10:00:00', '550e8400-e29b-41d4-a716-446655440000');
INSERT INTO transfer (id, amount, transfer_type, date_of_transfer, company_id) VALUES ('c4b32d1a-e3cb-4d9c-b088-8bbf6a4bb2a7', 3500.00, 'CUENTA_CREDITO', '2025-02-09 13:20:00', '550e8400-e29b-41d4-a716-446655440000');
INSERT INTO transfer (id, amount, transfer_type, date_of_transfer, company_id) VALUES ('0a379406-2223-4895-b909-cde9c6e4c2a5', 2200.00, 'CUENTA_DEBITO', '2025-02-02 09:00:00', '550e8400-e29b-41d4-a716-446655440000');
INSERT INTO transfer (id, amount, transfer_type, date_of_transfer, company_id) VALUES ('9c8d1f35-bd83-49b1-87c2-e8e5706762f7', 4800.00, 'CUENTA_CREDITO', '2025-01-17 15:30:00', '550e8400-e29b-41d4-a716-446655440000');
INSERT INTO transfer (id, amount, transfer_type, date_of_transfer, company_id) VALUES ('3de35b7e-74f9-4266-846d-84260dbd9876', 2000.00, 'CUENTA_DEBITO', '2025-01-25 12:45:00', '550e8400-e29b-41d4-a716-446655440000');

INSERT INTO transfer (id, amount, transfer_type, date_of_transfer, company_id) VALUES ('d21f4656-c5f0-40cd-81a0-99b1c9fa7e4e', 3000.00, 'CUENTA_CREDITO', '2025-02-05 11:00:00', '550e8400-e29b-41d4-a716-446655440001');
INSERT INTO transfer (id, amount, transfer_type, date_of_transfer, company_id) VALUES ('d9ca122b-1d50-46c4-b967-5050c07e1cd0', 1500.00, 'CUENTA_DEBITO', '2025-01-18 08:30:00', '550e8400-e29b-41d4-a716-446655440001');
INSERT INTO transfer (id, amount, transfer_type, date_of_transfer, company_id) VALUES ('e0f44f8b-6b4b-4da1-9be3-b8b0b0135c17', 4200.00, 'CUENTA_CREDITO', '2025-02-10 14:00:00', '550e8400-e29b-41d4-a716-446655440001');
INSERT INTO transfer (id, amount, transfer_type, date_of_transfer, company_id) VALUES ('d2fcfd07-d8b9-41b9-99de-35f2f1de4f3f', 1800.00, 'CUENTA_DEBITO', '2025-01-05 09:45:00', '550e8400-e29b-41d4-a716-446655440001');
INSERT INTO transfer (id, amount, transfer_type, date_of_transfer, company_id) VALUES ('fba9516e-d47a-475e-918d-76b2068a45b6', 2700.00, 'CUENTA_CREDITO', '2025-01-15 16:30:00', '550e8400-e29b-41d4-a716-446655440001');

INSERT INTO transfer (id, amount, transfer_type, date_of_transfer, company_id) VALUES ('5c87a63e-cfa5-4fc5-b373-e5abdb674218', 3400.00, 'CUENTA_DEBITO', '2024-11-22 11:20:00', '550e8400-e29b-41d4-a716-446655440002');
INSERT INTO transfer (id, amount, transfer_type, date_of_transfer, company_id) VALUES ('f35e0812-4e73-48b3-85b3-c571ec4f1b61', 2900.00, 'CUENTA_CREDITO', '2024-10-25 13:10:00', '550e8400-e29b-41d4-a716-446655440002');
INSERT INTO transfer (id, amount, transfer_type, date_of_transfer, company_id) VALUES ('57850c95-ef88-44d1-b740-e2f3323c6d59', 4500.00, 'CUENTA_DEBITO', '2025-01-30 12:00:00', '550e8400-e29b-41d4-a716-446655440002');
INSERT INTO transfer (id, amount, transfer_type, date_of_transfer, company_id) VALUES ('69f2777d-bbc6-4634-8c1d-8c9f4f7c7ca6', 2200.00, 'CUENTA_CREDITO', '2025-02-11 10:15:00', '550e8400-e29b-41d4-a716-446655440002');
INSERT INTO transfer (id, amount, transfer_type, date_of_transfer, company_id) VALUES ('fbc0de76-3375-4a8c-8b7e-6c4c1c0fbe3b', 3800.00, 'CUENTA_DEBITO', '2025-01-20 14:40:00', '550e8400-e29b-41d4-a716-446655440002');

INSERT INTO transfer (id, amount, transfer_type, date_of_transfer, company_id) VALUES ('923f67e8-5d92-45fe-8c8f-b3fdb746c179', 1500.00, 'CUENTA_CREDITO', '2024-12-10 09:25:00', '550e8400-e29b-41d4-a716-446655440003');
INSERT INTO transfer (id, amount, transfer_type, date_of_transfer, company_id) VALUES ('535f5a74-4d02-4330-b59f-cf9e7f33c2a2', 2000.00, 'CUENTA_DEBITO', '2025-01-08 12:50:00', '550e8400-e29b-41d4-a716-446655440003');
INSERT INTO transfer (id, amount, transfer_type, date_of_transfer, company_id) VALUES ('a5945be0-2d58-4673-92a1-7c90a05753fc', 1200.00, 'CUENTA_CREDITO', '2025-02-14 10:10:00', '550e8400-e29b-41d4-a716-446655440003');
INSERT INTO transfer (id, amount, transfer_type, date_of_transfer, company_id) VALUES ('d65c29b2-f7d2-433d-a53d-9b818edabae6', 4800.00, 'CUENTA_DEBITO', '2025-01-22 13:00:00', '550e8400-e29b-41d4-a716-446655440003');
INSERT INTO transfer (id, amount, transfer_type, date_of_transfer, company_id) VALUES ('9c5a2837-9c6f-4299-8fe3-8ea0d1a97e8e', 2500.00, 'CUENTA_CREDITO', '2025-01-30 11:15:00', '550e8400-e29b-41d4-a716-446655440003');