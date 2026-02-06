
-- UE
INSERT INTO UE (id, code, nom) VALUES
(1, 'UE-INFO', 'Informatique'),
(2, 'UE-MATH', 'Mathématiques'),
(3, 'UE-DATA', 'Data');


-- MATIERE
INSERT INTO MATIERE (id, code, nom, credits, ue_id) VALUES
(1, 'MAT-ALGO', 'Algorithmique', 6, 1),
(2, 'MAT-POO',  'Programmation OO', 5, 1),
(3, 'MAT-WEB',  'Développement Web', 3, 1),

(4, 'MAT-ANA',  'Analyse', 5, 2),
(5, 'MAT-STAT', 'Statistiques', 4, 2),
(6, 'MAT-LIN',  'Algèbre Linéaire', 3, 2),

(7, 'MAT-DB',   'Bases de Données', 5, 3),
(8, 'MAT-ML',   'Machine Learning', 6, 3),
(9, 'MAT-NLP',  'IA Symbolique', 4, 3),
(10,'MAT-ETL',  'ETL', 3, 3);


-- ETUDIANT
INSERT INTO ETUDIANT (id, matricule, nom, prenom, master_type) VALUES
(1, 'M0001', 'George', 'Lucas', 'IA'),
(2, 'M0002', 'Jeffrey', 'Epstein', 'DATA'),
(3, 'M0003', 'Macron', 'Brigitte',  'INFO'),
(4, 'M0004', 'Louis','Dupont',  'INFO'),   -- Sans notes (test erreur / cas vide)
(5, 'M0005', 'Petit',  'Lina',  'DATA'),
(6, 'M0006', 'Grand', 'Nina',  'IA'),
(7, 'M0007', 'Titeuf','Teteuf',  'INFO'),
(8, 'M0008', 'Star', 'Wars',   'DATA'),
(9, 'M0009', 'Caraibe',  'Jack',   'IA'),
(10,'M0010', 'Damn','Right',  'INFO');


-- NOTES
-- (Valeur sur 20)

-- Etudiant 1 : REUSSITE
-- Moyenne pondérée = (14*3 + 12*5 + 11*6) / (3+5+6) = 168/14 = 12.00
INSERT INTO NOTE (id, valeur, etudiant_id, matiere_id) VALUES
(1,  14, 1, 3),
(2,  12, 1, 2),
(3,  11, 1, 1);

-- Etudiant 2 : ECHEC
-- Moyenne pondérée = (8*5 + 8*5) / 10 = 8.00
INSERT INTO NOTE (id, valeur, etudiant_id, matiere_id) VALUES
(4,  8, 2, 2),
(5,  8, 2, 7);

-- Etudiant 3 : EXACTEMENT 10.00 -> doit réussir (>=10)
-- Moyenne pondérée = (10*6 + 10*4)/(6+4) = 100/10 = 10.00
INSERT INTO NOTE (id, valeur, etudiant_id, matiere_id) VALUES
(6,  10, 3, 8),
(7,  10, 3, 9);

-- Etudiant 4 : aucune note donc renvoie erreur -> OK

-- Etudiant 5 :
INSERT INTO NOTE (id, valeur, etudiant_id, matiere_id) VALUES
(8,  13, 5, 4),
(9,  9,  5, 5),
(10, 12, 5, 6),
(11, 11, 5, 7);

-- Etudiant 6
INSERT INTO NOTE (id, valeur, etudiant_id, matiere_id) VALUES
(12, 15, 6, 8),
(13, 12, 6, 7),
(14, 10, 6, 10),
(15, 9,  6, 5);

-- Etudiant 7
INSERT INTO NOTE (id, valeur, etudiant_id, matiere_id) VALUES
(16, 8,  7, 1),
(17, 11, 7, 2),
(18, 14, 7, 3),
(19, 10, 7, 6);

-- Etudiant 8
INSERT INTO NOTE (id, valeur, etudiant_id, matiere_id) VALUES
(20, 12, 8, 7),
(21, 9,  8, 9),
(22, 13, 8, 10);

-- Etudiant 9
INSERT INTO NOTE (id, valeur, etudiant_id, matiere_id) VALUES
(23, 16, 9, 8),
(24, 11, 9, 4),
(25, 10, 9, 5),
(26, 14, 9, 7);

-- Etudiant 10
INSERT INTO NOTE (id, valeur, etudiant_id, matiere_id) VALUES
(27, 7,  10, 4),
(28, 8,  10, 5),
(29, 9,  10, 6),
(30, 10, 10, 2);
