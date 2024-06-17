INSERT INTO garage (`id`, `nom`, `rue`, `cp`, `ville`, `tel`, `email`, `site_web`) VALUES
    (1, 'Garage CARSAVVY', '123 Avenue des Réparations', '57070', 'Metz', '0387456789', 'contact@garagesavvy-metz.com', 'www.garagesavvy.com');

--
-- Déchargement des données de la table `marque`
--

INSERT INTO `marque` (`id`, `nom`) VALUES
                                       (1, 'Toyota'),
                                       (2, 'BMW'),
                                       (3, ' Ford'),
                                       (4, 'Chevrolet'),
                                       (5, 'Mercedes-Benz'),
                                       (6, 'Audi'),
                                       (7, 'Nissan'),
                                       (8, 'Volkswagen'),
                                       (9, 'Hyundai'),
                                       (10, 'Honda');

--
-- Déchargement des données de la table `materiel`
--

INSERT INTO `materiel` (`id`, `nom`) VALUES
                                         (1, 'Pont Élévateur 1'),
                                         (2, 'Pont Élévateur 2'),
                                         (3, 'Boite à outil complète 1'),
                                         (4, 'Boite à outil complète 2'),
                                         (5, 'Compresseur d\'air 1'),
                                         (6, 'Compresseur d\'air 2'),
                                         (7, 'Diagnostiquer OBD-II 1'),
                                         (8, 'Diagnostiquer OBD-II 2'),
                                         (9, 'Chariot de Vidange d\'Huile 1'),
                                         (10, 'Chariot de Vidange d\'Huile 2');
--
-- Déchargement des données de la table `modele`
--

INSERT INTO `modele` (`id`, `nom`, `annee`, `id_Marque`) VALUES
                                                             (1, 'Corolla', 2002, 1),
                                                             (2, 'Camry', 2002, 1),
                                                             (3, 'RAV4', 2001, 1),
                                                             (4, 'Prius', 1988, 1),
                                                             (5, 'Highlander', 1989, 1),
                                                             (6, 'Tacoma', 2008, 1),
                                                             (7, 'Sienna', 2004, 1),
                                                             (8, 'Avalon', 1992, 1),
                                                             (9, '4Runner', 1987, 1),
                                                             (10, 'Yaris', 2005, 1),
                                                             (11, '3 Series', 2011, 2),
                                                             (12, '5 Series', 1984, 2),
                                                             (13, 'X3', 1998, 2),
                                                             (14, 'X5', 2007, 2),
                                                             (15, '7 Series', 1999, 2),
                                                             (16, 'X1', 1997, 2),
                                                             (17, '4 Series', 2005, 2),
                                                             (18, '2 Series', 2002, 2),
                                                             (19, 'Z4', 1986, 2),
                                                             (20, 'i3', 1994, 2),
                                                             (21, 'F-150', 2007, 3),
                                                             (22, 'Mustang', 1997, 3),
                                                             (23, 'Explorer', 2004, 3),
                                                             (24, 'Escape', 1980, 3),
                                                             (25, 'Fusion', 2005, 3),
                                                             (26, 'Ranger', 2012, 3),
                                                             (27, 'Edge', 1989, 3),
                                                             (28, 'Expedition', 2002, 3),
                                                             (29, 'Focus', 1991, 3),
                                                             (30, 'EcoSport', 2017, 3),
                                                             (31, 'Civic', 1993, 10),
                                                             (32, 'Accord', 1998, 10),
                                                             (33, 'CR-V', 2006, 10),
                                                             (34, 'Pilot', 1992, 10),
                                                             (35, 'Odyssey', 1994, 10),
                                                             (36, 'Fit', 2011, 10),
                                                             (37, 'HR-V', 1992, 10),
                                                             (38, 'Ridgeline', 1992, 10),
                                                             (39, 'Passport', 2003, 10),
                                                             (40, 'Insight', 1981, 10),
                                                             (41, 'Silverado', 1997, 4),
                                                             (42, 'Equinox', 1995, 4),
                                                             (43, 'Traverse', 2015, 4),
                                                             (44, 'Malibu', 1985, 4),
                                                             (45, 'Tahoe', 2012, 4),
                                                             (46, 'Camaro', 1993, 4),
                                                             (47, 'Colorado', 2001, 4),
                                                             (48, 'Suburban', 2003, 4),
                                                             (49, 'Trax', 1986, 4),
                                                             (50, 'Impala', 2001, 4),
                                                             (51, 'C-Class', 2002, 5),
                                                             (52, 'E-Class', 2007, 5),
                                                             (53, 'GLC', 1989, 5),
                                                             (54, 'GLE', 1998, 5),
                                                             (55, 'A- Class', 1997, 5),
                                                             (56, 'S-Class', 1994, 5),
                                                             (57, 'GLA', 2008, 5),
                                                             (58, 'CLA', 1981, 5),
                                                             (59, 'GLB', 2004, 5),
                                                             (60, 'GLS', 2007, 5),
                                                             (61, 'A4', 2003, 6),
                                                             (62, 'Q5', 1983, 6),
                                                             (63, 'A3', 2010, 6),
                                                             (64, 'Q7', 1989, 6),
                                                             (65, 'A6', 2002, 6),
                                                             (66, 'Q3', 2004, 6),
                                                             (67, 'A5', 1989, 6),
                                                             (68, 'Q8', 1994, 6),
                                                             (69, 'RS3', 2011, 6),
                                                             (70, 'TT', 1995, 6),
                                                             (71, 'Altima', 1996, 7),
                                                             (72, 'Rogue', 1982, 7),
                                                             (73, 'Sentra', 2008, 7),
                                                             (74, 'Pathfinder', 1997, 7),
                                                             (75, 'Versa', 1992, 7),
                                                             (76, 'Maxima', 1992, 7),
                                                             (77, 'Murano', 2002, 7),
                                                             (78, 'Frontier', 2006, 7),
                                                             (79, 'Titan', 1994, 7),
                                                             (80, 'Armada', 2003, 7),
                                                             (81, 'Jetta', 2004, 8),
                                                             (82, 'Passat', 1981, 8),
                                                             (83, 'Tiguan', 1991, 8),
                                                             (84, 'Atlas', 1992, 8),
                                                             (85, 'Golf', 2015, 8),
                                                             (86, 'Beetle', 1986, 8),
                                                             (87, 'Arteon', 2002, 8),
                                                             (88, 'ID.4', 2004, 8),
                                                             (89, 'Touareg', 1988, 8),
                                                             (90, 'Atlas Cross Sport', 1990, 8),
                                                             (91, 'Elantra', 1995, 9),
                                                             (92, 'Sonata', 1989, 9),
                                                             (93, 'Tucson', 2012, 9),
                                                             (94, 'Santa Fe', 2000, 9),
                                                             (95, 'Accent', 2002, 9),
                                                             (96, 'Kona', 1982, 9),
                                                             (97, 'Palisade', 2012, 9),
                                                             (98, 'Venue', 1988, 9),
                                                             (99, 'Veloster', 2004, 9),
                                                             (100, 'Ioniq', 2005, 9);

--
-- Déchargement des données de la table `prestation`
--

INSERT INTO `prestation` (`id`, `libelle`, `description`,image_url, `id_garage`) VALUES
                                                                           (1, 'Pneus', 'Changement de pneus et équilibrage des roues.','src/main/resources/static/images/pneus.png', 1),
                                                                           (2, 'Révision', 'Révision générale du véhicule avec vidange des fluides.','src/main/resources/static/images/carsavvy presations.jpg', 1),
                                                                           (3, 'Vidange', 'Remplacement de lhuile moteur et du filtre à huile','src/main/resources/static/images/vidange.png', 1),
                                                                           (4, 'Reparation de la carrosserie', 'Reparation des dommages extérieurs au véhicule','src/main/resources/static/images/carosserie.png', 1),
                                                                           (5, 'Diagnostic electronique', 'Analyse des systemes electroniques du véhicule','src/main/resources/static/images/diagnostic.png', 1),
                                                                           (6, 'Amortisseurs', 'Remplacement et vérification des amortisseurs','src/main/resources/static/images/amortisseurs.png', 1),
                                                                           (7, 'Contrôle technique', 'Vérification complète du véhicule pour le contrôle technique obligatoire','src/main/resources/static/images/controle.png', 1);




--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`id`, `nom`) VALUES
                                     (1, 'admin'),
                                     (2, 'technicien'),
                                     (3, 'utilisateur'),
                                     (4, 'adherent');

--
-- Déchargement des données de la table `salaries`
--

INSERT INTO `salaries` (`Id`, `nom`, `prenom`, `passeword`, `email`, `poste`, `id_garage`) VALUES
                                                                                               (1, 'Dubois', 'Mathieu', 'toto1', 'bmathieu@gmail.com', 'Mécanicien automobile', 1),
                                                                                               (2, 'Petit', 'Jeremy', 'toto2', 'petit@gmail.com', 'Chef atelier automobile', 1),
                                                                                               (3, 'Doe', 'Jhon', 'toto3', 'doe@gmail.com', 'Monteur pneumatique', 1),
                                                                                               (4, 'Doe', 'Jane', 'toto4', 'janedoe@gmail.com', 'Réceptionniste atelier automobile', 1),
                                                                                               (5, 'Smith', 'Alexandre', 'toto5', 'smith@gmail.com', 'Mécanicien automobile', 1),
                                                                                               (6, 'Soulas', 'Ethan', 'toto6', 'soulas@gmail.com', 'Mécanicien automobile', 1);

--
-- Déchargement des données de la table `sousprestation`
--

INSERT INTO `sousprestation` (`id`, `libelle`, `prix`, `duree`, `id_prestation`) VALUES
                                                                                     (1, 'Changement de pneus', '100.00', '01:30:00', 1),
                                                                                     (2, 'Équilibrage des roues', '50.00', '00:30:00', 1),
                                                                                     (3, 'Vidange dhuile moteur', '80.00', '00:45:00', 2),
                                                                                     (4, 'Inspection des freins', '60.00', '00:30:00', 2),
                                                                                     (5, 'Changement de filtre à air', '40.00', '00:15:00', 2),
                                                                                     (6, 'Remplacement de lhuile moteur', '80.00', '00:30:00', 3),
                                                                                     (7, 'Remplacement du filtre à huile', '30.00', '00:15:00', 3),
                                                                                     (8, 'Vérification du niveau dhuile', '20.00', '00:15:00', 3),
                                                                                     (9, 'Redressage des bosses', '150.00', '02:00:00', 4),
                                                                                     (10, 'Réparation des rayures', '100.00', '01:00:00', 4),
                                                                                     (11, 'Remplacement du pare-chocs', '200.00', '03:00:00', 4),
                                                                                     (12, 'Lecture des codes derreur', '50.00', '00:30:00', 5),
                                                                                     (13, 'Analyse des capteurs', '100.00', '00:15:00', 5),
                                                                                     (14, 'Réparation du système électrique', '150.00', '02:00:00', 5);

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
                                                                                   (1, 1997, 'XE007OR', 1, 55),
                                                                                   (2, 1998, 'PB412TE', 3, 32),
                                                                                   (3, 2000, 'NC925AL', 1, 94),
                                                                                   (4, 1988, 'EM924QT', 4, 98),
                                                                                   (5, 1980, 'US169TW', 2, 24),
                                                                                   (6, 2007, 'BU600DN', 2, 14),
                                                                                   (7, 2008, 'EJ224PQ', 2, 57),
                                                                                   (8, 2002, 'JX318NC', 4, 2);

--
-- Déchargement des données de la table `vente`
--

INSERT INTO `vente` (`id`, `prix`, `date_rentre`, `date_vente`, `annee`, `immat`, `id_vehicule`) VALUES
                                                                                                     (1, '15000.000', '2024-04-06', NULL, 2019, 'TOY-COR-2024', 1),
                                                                                                     (2, '22000.000', '2024-04-18', NULL, 2020, 'HON-CIV-2024', 6),
                                                                                                     (3, '18000.000', '2024-01-06', NULL, 2018, 'FOR-F15-2024', 8);

