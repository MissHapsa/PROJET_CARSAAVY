INSERT INTO garage (`id`, `nom`, `rue`, `cp`, `ville`, `tel`, `email`, `site_web`) VALUES
    (1, 'Garage CARSAVVY', '123 Avenue des Réparations', '57070', 'Metz', '0387456789', 'contact@garagesavvy-metz.com', 'www.garagesavvy.com');

--
-- Déchargement des données de la table `marque`
--

INSERT INTO `marque` (`id`, `nom`) VALUES
                                       (1, 'Toyota'),
                                       (2, 'BMW'),
                                       (3, ' Ford');

--
-- Déchargement des données de la table `materiel`
--

INSERT INTO `materiel` (`id`, `nom`) VALUES
                                         (1, 'Pont Élévateur'),
                                         (2, 'Boite à outil complète'),
                                         (3, 'Compresseur d\'air'),
                                         (4, 'Diagnostiquer OBD-II'),
                                         (5, 'Chariot de Vidange d\'Huile');
--
-- Déchargement des données de la table `modele`
--

INSERT INTO `modele` (`id`, `nom`, `annee`, `id_Marque`) VALUES
                                                             (1, 'Corolla', 2002, 1),
                                                             (2, 'Camry', 2002, 1),
                                                             (3, 'RAV4', 2001, 1),
                                                             (4, 'Prius', 1988, 1),
                                                             (5, '3 Series', 2011, 2),
                                                             (6, '5 Series', 1984, 2),
                                                             (7, 'X3', 1998, 2),
                                                             (8, 'X5', 2007, 2),
                                                             (9, 'Escape', 1980, 3),
                                                             (10, 'Fusion', 2005, 3),
                                                             (11, 'Focus', 1991, 3);

--
-- Déchargement des données de la table `prestation`
--

INSERT INTO prestation (id, libelle, description, image_url, id_garage, duree)
VALUES
    (1, 'Pneus', 'Changement de pneus et équilibrage des roues.', 'src/main/resources/static/images/pneus.png', 1, 60),
    (2, 'Révision', 'Révision générale du véhicule avec vidange des fluides.', 'src/main/resources/static/images/carsavvy presations.jpg', 1, 120),
    (3, 'Vidange', 'Remplacement de lhuile moteur et du filtre à huile', 'src/main/resources/static/images/vidange.png', 1, 30),
    (4, 'Reparation de la carrosserie', 'Reparation des dommages extérieurs au véhicule', 'src/main/resources/static/images/carosserie.png', 1, 120),
    (5, 'Diagnostic electronique', 'Analyse des systemes electroniques du véhicule', 'src/main/resources/static/images/diagnostic.png', 1, 30),
    (6, 'Amortisseurs', 'Remplacement et vérification des amortisseurs', 'src/main/resources/static/images/amortisseurs.png', 1, 90),
    (7, 'Contrôle technique', 'Vérification complète du véhicule pour le contrôle technique obligatoire', 'src/main/resources/static/images/controle.png', 1, 60);


--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`id`, `nom`) VALUES
                                     (1, 'admin'),
                                     (2, 'technicien'),
                                     (3, 'utilisateur');

--
-- Déchargement des données de la table `salaries`
--

INSERT INTO `salaries` (`Id`, `nom`, `prenom`, `passeword`, `email`, `poste`, `id_garage`) VALUES
                                                                                               (1, 'Dubois', 'Mathieu', 'toto1', 'bmathieu@gmail.com', 'Mécanicien automobile', 1),
                                                                                               (2, 'Petit', 'Jeremy', 'toto2', 'petit@gmail.com', 'Chef atelier automobile', 1),
                                                                                               (3, 'Doe', 'Jhon', 'toto3', 'doe@gmail.com', 'Monteur pneumatique', 1),
                                                                                               (6, 'Soulas', 'Ethan', 'toto6', 'soulas@gmail.com', 'Mécanicien automobile', 1);


--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`,`role_id`, `passeword`, `email`, `rue`, `cp`, `ville`, `tel`, `date_creation`) VALUES
                                                                                                                          (1, 'Nina', 'Marie',2, '$2a$10$zcDZd6djp8bzXwP6.ZLUOe8uBo7pB1eeGSWhkhJyRF2TJWX7ISV6u', 'sed@outlook.couk', 'Ap #686-5149 Gravida Av.', '50416', 'Biarritz', '02 14 32 59 70', '2023-04-15'),
                                                                                                                          (2, 'Eric', 'Paul',2, '$2a$10$zcDZd6djp8bzXwP6.ZLUOe8uBo7pB1eeGSWhkhJyRF2TJWX7ISV6u', 'condimentum.donec@hotmail.ca', 'Ap #177-3125 Egestas Av.', '24157', 'Soissons', '06 32 76 58 25', '2023-12-10'),
                                                                                                                          (3, 'Cameron', 'John',3, '$2a$10$zcDZd6djp8bzXwP6.ZLUOe8uBo7pB1eeGSWhkhJyRF2TJWX7ISV6u', 'lorem@outlook.sn', 'P.O. Box 486, 3601 Eros. Ave', '23263', 'Saint-Herblain', '06 46 62 44 16', '2022-07-22'),
                                                                                                                          (4, 'Nigel', 'Patrick',1, '$2a$10$zcDZd6djp8bzXwP6.ZLUOe8uBo7pB1eeGSWhkhJyRF2TJWX7ISV6u', 'quis.urn@aol.com', '565 Mauris Road', '76621', 'Strasbourg', '04 12 27 38 57', '2024-01-18');


--
-- Déchargement des données de la table `vehicule`
--
INSERT INTO `vehicule` (`id`, `annee`, `immat`, `id_utilisateur`, `id_modele`) VALUES
                                                                                   (1, 1997, 'XE007OR', 1, 2),
                                                                                   (2, 1998, 'PB412TE', 3, 7),
                                                                                   (3, 2000, 'NC925AL', 1, 9),
                                                                                   (4, 1988, 'EM924QT', 4, 1),
                                                                                   (5, 1980, 'US169TW', 2, 4),
                                                                                   (6, 2007, 'BU600DN', 2, 1),
                                                                                   (7, 2008, 'EJ224PQ', 2, 5),
                                                                                   (8, 2002, 'JX318NC', 4, 6);

--
-- Déchargement des données de la table `vente`
--

INSERT INTO `vente` (`id`, `prix`, `date_rentre`, `date_vente`, `annee`, `immat`, `id_vehicule`) VALUES
                                                                                                     (1, '15000.000', '2024-04-06', NULL, 2019, 'BM-224-AI', 1),
                                                                                                     (2, '22000.000', '2024-04-18', NULL, 2020, 'HO-567-LK', 6),
                                                                                                     (3, '18000.000', '2024-01-06', NULL, 2018, 'KH-207-VB', 8),
                                                                                                     (4, '17000.000', '2024-05-10', NULL, 2021, 'LM-345-XC', 3),
                                                                                                     (5, '23000.000', '2024-06-15', NULL, 2022, 'TR-678-PO', 4),
                                                                                                     (6, '16000.000', '2024-03-20', NULL, 2017, 'GF-901-ZY', 2);


INSERT INTO `reservation` (`id_utilisateur`, `id_vehicule`, `id_prestation`, `date_reservation`, `statut`) VALUES
                                                                                                               (1, 1, 1, '2024-02-15', 'Effectuée'),
                                                                                                               (1, 3, 2, '2024-03-20', 'Effectuée'),
                                                                                                               (2, 5, 3, '2024-01-10', 'Effectuée'),
                                                                                                               (2, 6, 4, '2024-02-25', 'Effectuée'),
                                                                                                               (2, 7, 5, '2024-05-12', 'Effectuée'),
                                                                                                               (3, 2, 1, '2024-03-05', 'Effectuée'),
                                                                                                               (3, 2, 6, '2024-06-18', 'Effectuée'),
                                                                                                               (4, 4, 4, '2024-01-30', 'Effectuée'),
                                                                                                               (4, 8, 2, '2024-04-08', 'Effectuée'),
                                                                                                               (4, 8, 7, '2024-07-22', 'Effectuée');


