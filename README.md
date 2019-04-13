# Tavaux Pratiques sur JPA


## TP 1 et 2: Accéder et récupérer, insérer ou modifier des données via JPA (package dev.bibliotheque)

Utilisation la techno JPA (JAVA Persistence API).

Pour que le code fonctionne, il est nécessaire de créer une base de données nommée jpa-tp de type MySQL sur un serveur local (localhost). Vous pouvez également modifier le fichier persistance api afin de vous connecter à un serveur distant ou toute autre base de données (par défaut une base de données sur un serveur distant est utilisée). Vous trouverez un script SQL dans le dossier ressources vous permettant d'importer les tables et leur contenu.

La partie insersion et modification du code a été commentée. En la décommentant il est possible d'insérer un nouveau livre ou de modifier un livre existant dans la base de données.


## TP 3 et 4: Générer les tables et les données d'une base de données via JPA (package dev.banque)

Utilisation la techno JPA (JAVA Persistence API).

Pour faire fonctionner cette partie, il vous est nécessaire de de configurer le fichier persistence.xml pour utiliser une base de données MySQL de votre choix. Par défaut, cette partie utilise une base de données sur un serveur distant (et donc inaccessible pour vous, cependant une fois la base de données recrée sur le serveur distant, des requêtes sont effectuées pour afficher une partie du contenu).

