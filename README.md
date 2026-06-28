# SmartRecruit 🤖

> Système intelligent de matching CV / offres d'emploi par Machine Learning

![Java](https://img.shields.io/badge/Java-24-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green)
![DL4J](https://img.shields.io/badge/DL4J-1.0.0--M2.1-blue)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue)
![Python](https://img.shields.io/badge/Python-3.11-yellow)
![Status](https://img.shields.io/badge/Status-En%20développement-red)

---

## 🎯 Objectif

SmartRecruit est une application de matching intelligent entre candidats et offres d'emploi. Elle utilise des techniques de Machine Learning (embeddings + similarité cosinus) pour calculer un score de compatibilité entre un profil candidat et une offre d'emploi — dans les deux sens.

Un employeur obtient les 5 meilleurs candidats pour son offre.
Un candidat obtient les 5 meilleures offres pour son profil.

---

## 🧠 Concepts ML appliqués

| Concept | Description |
|---|---|
| **Embeddings** | Transformation de texte en vecteurs numériques capturant le sens sémantique |
| **Similarité cosinus** | Mesure mathématique de proximité entre deux vecteurs |
| **ML supervisé** | Modèle entraîné sur des données étiquetées pour prédire la compatibilité |
| **Inférence temps réel** | Prédiction instantanée sans bloquer l'interface utilisateur |

---

## 🏗️ Architecture
┌─────────────────────────────────────────────────────┐

│                    FRONTEND                          │

│              JavaFX (Interface)                      │

│       Employeur UI  │  Candidat UI                  │

└──────────────┬───────────────────────────────────────┘

│ HTTP REST

┌──────────────▼───────────────────────────────────────┐

│                 BACKEND Spring Boot                   │

│                                                       │

│  Controller → Service → Repository (JDBC)             │

│                  ↓                                    │

│            ML Engine (DL4J)                           │

│         Embeddings + Similarité cosinus               │

└──────────────────────────────┬────────────────────────┘

│ JDBC

┌──────────▼──────────┐

│     PostgreSQL       │

│  candidats │ offres  │

│       matchings      │

└─────────────────────┘

---

## 🛠️ Stack technique

### Java (Phase 1)
- **Java 24** — langage principal
- **Spring Boot 3.x** — API REST
- **DL4J (Deeplearning4j)** — Machine Learning, embeddings
- **PostgreSQL 16** — base de données relationnelle
- **JDBC** — connexion base de données
- **JavaFX 21** — interface utilisateur
- **JUnit 5** — tests unitaires
- **Maven** — gestion des dépendances

### Python (Phase 2)
- **Python 3.11**
- **sentence-transformers** — embeddings pré-entraînés
- **scikit-learn** — ML et similarité cosinus
- **pandas** — manipulation de données
- **FastAPI** — API REST légère

---

## 📁 Structure du projet
SmartRecruit/

├── src/

│   └── main/

│       ├── java/

│       │   └── ch/smartrecruit/

│       │       ├── controller/     # Routes REST Spring Boot

│       │       ├── service/        # Logique métier + orchestration ML

│       │       ├── repository/     # Accès base de données JDBC

│       │       ├── model/          # Entités Java (Candidat, Offre, Match)

│       │       └── ml/             # Moteur ML (embeddings, similarité)

│       └── resources/

│           └── application.properties

├── src/test/                       # Tests JUnit 5

├── python/                         # Phase 2 — réimplémentation Python

├── data/                           # Datasets d'entraînement

├── pom.xml

└── README.md

---

## 🚀 Fonctionnalités

- [x] Structure du projet
- [ ] Base de données PostgreSQL
- [ ] API REST Spring Boot
- [ ] Moteur ML — embeddings et similarité cosinus
- [ ] Matching candidat → offres
- [ ] Matching employeur → candidats
- [ ] Interface JavaFX
- [ ] Tests JUnit 5
- [ ] Réimplémentation Python

---

## 📈 Progression portfolio

Ce projet est le troisième d'une série démontrant une progression technique claire :

| Projet | Concepts clés |
|---|---|
| [KitchenFlow](https://github.com/WesleyZhv/Restaurant-Brigade) | POO, JavaFX, Gson, Collections |
| [StellarDuel](https://github.com/WesleyZhv/StellarDuel) | MVC, Design Patterns, IA Minimax, JUnit 5 |
| **SmartRecruit** | **ML, Spring Boot, PostgreSQL, REST API, Python** |

---

## 👨‍💻 Auteur

**Wesley** — étudiant en Bachelor Informatique de Gestion à la HES-SO
En reconversion professionnelle (cuisine → informatique)

[GitHub](https://github.com/WesleyZhv)

---

## 📄 Licence

MIT License — voir [LICENSE](LICENSE)