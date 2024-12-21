# Portfolio API

## Description
Portfolio back est une API RESTful simple permettant de gérer les projets d'un portfolio. Elle permet de récupérer des projets, d'ajouter de nouveaux projets ou de les mettre à jour. L'API utilise un système d'authentification JWT pour sécuriser l'ajout et la modification des projets. Elle est conçue pour être utilisée avec le front-end d'un portfolio personnel.

### Fonctionnalités principales :
- **Récupérer la liste des projets** : Permet d'afficher tous les projets du portfolio.
- **Ajouter un projet** : Permet d'ajouter un projet à l'aide d'un token d'authentification valide.
- **Mettre à jour un projet** : Permet de modifier les informations d'un projet existant.

## Sécurité
L'API utilise des tokens JWT pour sécuriser les endpoints qui permettent d'ajouter ou de mettre à jour des projets. Pour utiliser ces fonctionnalités, un utilisateur doit d'abord s'authentifier et récupérer un token JWT qu'il devra fournir dans les requêtes futures.

## Endpoints

### 1. Authentification
- **POST /api/auth/login**
    - Description : Permet d'obtenir un token d'authentification.
    - Body (JSON) :
      ```json
      {
        "username": "votre-nom-utilisateur",
        "password": "votre-mot-de-passe"
      }
      ```
    - Réponse (200 OK) :
      ```json
      {
        "token": "votre-token-jwt"
      }
      ```

### 1. Récupérer tous les projets
- **GET /api/projects**
    - Description : Récupère la liste complète des projets.
    - Réponse (200 OK) :
      ```json
      [
        {
          "id": 1,
          "name": "Projet 1",
          "description": "Description du projet 1",
          "images": [
            "blob1",
            "blob2"
          ]
        },
        {
          "id": 2,
          "name": "Projet 2",
          "description": "Description du projet 2",
          "images": [
            "blob1",
            "blob2"
          ]
        }
      ]
      ```

### 3. Ajouter un projet
- **POST /api/projects**
    - Description : Ajoute un projet (réservé aux utilisateurs authentifiés).
    - Authentification : Token JWT requis.
    - Body (JSON) :
      ```json
      {
        "name": "Nouveau Projet",
        "description": "Description détaillée",
        "images": [
          "blob1",
          "blob2"
        ]
      }
      ```
    - Réponse (201 Created) :
      ```json
      {
        "id": 3,
        "name": "Nouveau Projet",
        "description": "Description détaillée",
        "images": [
          "blob1",
          "blob2"
        ]
      }
      ```

### 4. Mettre à jour un projet
- **PUT /api/projects/{id}**
    - Description : Met à jour un projet existant.
    - Authentification : Token JWT requis.
    - Body (JSON) :
      ```json
      {
        "name": "Projet mis à jour",
        "description": "Nouvelle description",
        "images": [
          "blob1",
          "blob2"
        ]
      }
      ```
    - Réponse (200 OK) :
      ```json
      {
        "id": 3,
        "name": "Projet mis à jour",
        "description": "Nouvelle description",
        "images": [
          "blob1",
          "blob2"
        ]
      }
      ```

## Technologies utilisées
- **Java 17** et **Spring Boot** pour la gestion de l'API
- **H2 Database** pour le stockage des projets en développement
- **JWT** pour la gestion de l'authentification et des tokens sécurisés

## À propos
Ce projet est développé pour être utilisé comme back-end d'un portfolio personnel. Il sert uniquement à gérer la liste de projets et à fournir une API simple pour le front-end Angular. Il est conçu pour offrir une base solide, mais flexible, pour un portfolio évolutif.

## License
Ce projet est sous la license MIT. Voir le fichier [LICENSE](./LICENSE) pour plus de détails.