# GestionDesEmployes

## Objectif
L'objectif de ce TP est de modéliser et de développer une application de gestion des employés dans une petite entreprise en utilisant les concepts de la programmation orientée objet et la connectivité à une base de données. Le but est de structurer les données des employés en respectant la hiérarchie existante et de créer les différentes classes nécessaires pour gérer les informations. Ensuite, il s'agit d'implémenter les services permettant d'effectuer des opérations CRUD sur les employés et de tester ces opérations en affichant les noms et les salaires selon l'ordre hiérarchique.

## Outils Utilisés
  - Langage Java
  - IDE NetBeans
  - Base de données MySQL
  - API JDBC

## Structure du Projet
Le projet est organisé de la manière suivante :

  - **Connexion.java** : Gère la connexion à la base de données MySQL.
  - **IDao.java** : Interface générique pour les opérations DAO.
  - **Personne.java** : Classe mère des deux classes Manager et Developpeur.
  - **Developpeur.java** : Classe modèle représentant les données des développeurs.
  - **Manager.java** : Classe modèle représentant les données des managers.
  - **DeveloppeurService.java** et **ManagerService.java** : Implémentent les méthodes pour interagir avec la base de données.
  - **Test.java** : Programme principal pour créer et initialiser la table et tester les difféerents méthodes.
 

## Fonctionnalités
- **Connexion à la base de données** : Établit une connexion avec une base de données MySQL pour gérer les données des employés.

- **Gestion des employés** :
  - Création, lecture, mise à jour et suppression (CRUD) des informations des employés, incluant les développeurs, les managers et le directeur général.
  - Organisation de la hiérarchie des employés avec des relations claires entre les différents niveaux (directeur, manager, développeurs).

- **Affichage de la hiérarchie** :
  - Visualisation des noms et des salaires des employés de l'entreprise, du directeur général jusqu'aux développeurs.
  - Affichage des employés dans l'ordre hiérarchique pour une vue structurée de la gestion de l'entreprise.



## Cloner le Projet
Pour cloner ce projet sur votre machine locale, suivez les étapes ci-dessous :

1. **Assurez-vous d'avoir Git installé**. Si ce n'est pas le cas, vous pouvez le télécharger et l'installer depuis [git-scm.com](https://git-scm.com/).

2. **Ouvrez votre terminal** et exécutez la commande suivante pour cloner le dépôt :

   ```bash
   git clone https://github.com/votre_nom_utilisateur/ScriptsDesDeveloppeurs.git
## Démonstration de l'application


