# TP20 — Architecture Micro-services avec RestTemplate

TP de la formation **JEE Microservices** (EMSI Marrakech, 5IIR / 2DSI).
Mise en place d'une architecture micro-services avec **Spring Boot**, **Spring Cloud Netflix Eureka**, **Spring Cloud Gateway** et communication inter-services via **RestTemplate**.

## Architecture

```
                     ┌──────────────────────┐
   Client HTTP ───▶  │  Gateway  (:8888)    │
                     └──────────┬───────────┘
                                │  routage dynamique (Discovery Locator)
              ┌─────────────────┼─────────────────┐
              ▼                                   ▼
   ┌────────────────────┐   RestTemplate   ┌────────────────────┐
   │  Service Client    │ ◀─────────────── │  Service Voiture   │
   └─────────┬──────────┘                  └─────────┬──────────┘
             └───────────── s'enregistrent ──────────┘
                              ▼
                   ┌────────────────────┐
                   │ Eureka Server      │
                   │      (:8761)       │
                   └────────────────────┘
```

## Modules

| Dossier | Rôle | Port |
|---|---|---|
| `Tp20-eureka-server` | Serveur de découverte de services (Eureka) | 8761 |
| `TP20-GateWay` | API Gateway (Spring Cloud Gateway WebFlux) | 8888 |
| `Tp20-client-service` | Micro-service de gestion des clients | *(à compléter)* |
| `TP20-service-voiture` | Micro-service de gestion des voitures, appelle le service client via RestTemplate | *(à compléter)* |

## Technologies

- Java 21
- Spring Boot 4.1.x
- Spring Cloud 2025.1.x (Eureka Client/Server, Gateway, LoadBalancer)
- Spring Data JPA, Lombok
- Base de données : H2 / MySQL
- Maven

## Modèle de données

**Client**

| Champ | Type |
|---|---|
| id | Long (auto-incrément) |
| nom | String |
| age | Float |

**Car**

| Champ | Type |
|---|---|
| id | Long (auto-incrément) |
| brand | String |
| model | String |
| matricule | String |
| client_id | Long (propriétaire) |

Les données de test sont insérées au démarrage via un `CommandLineRunner`.

## Lancer le projet

Prérequis : JDK 21, Maven 3.9+ (ou `mvnw` fourni), MySQL si utilisé.

**Respecter cet ordre de démarrage :**

1. `Tp20-eureka-server`
2. `Tp20-client-service`
3. `TP20-service-voiture`
4. `TP20-GateWay`

Dans chaque dossier :

```bash
./mvnw spring-boot:run
```

(sous Windows : `mvnw.cmd spring-boot:run`)

Vérifier ensuite le tableau de bord Eureka : <http://localhost:8761>
Les trois services (client, voiture, Gateway) doivent apparaître comme `UP`.

## Utilisation via la Gateway

Grâce au *Discovery Locator*, la Gateway crée les routes automatiquement à partir des noms de services enregistrés dans Eureka :

```
http://localhost:8888/<NOM-DU-SERVICE>/<endpoint>
```

Exemples *(à adapter aux noms réels des services et aux endpoints)* :

```
GET http://localhost:8888/CLIENT-SERVICE/clients
GET http://localhost:8888/SERVICE-VOITURE/voitures
```

Actuator de la Gateway : <http://localhost:8888/actuator/gateway/routes>

## Captures d'écran

![Capture 1](https://github.com/user-attachments/assets/2e61f44c-b30e-42a0-a356-9a06f46a2401)

![Capture 2](https://github.com/user-attachments/assets/4edd8d93-5a7b-42e5-b7cb-58226a6c9b28)

![Capture 3](https://github.com/user-attachments/assets/086e8bc8-0628-4312-884e-11d2951166f2)

## Auteur

**Dihi Fatima** — 5ᵉ année, Ingénierie du Développement Digital et Systèmes d'Information, EMSI Marrakech
GitHub : [@dihifatima](https://github.com/dihifatima)
