# ilu4-projet-pirate (Groupe 1)

## Auteurs 

**Chef de projet** : LOUIS Enzo  
**Responsable des tests fonctionnels** : DE CHABANNES CURTON LA PALICE Antoine  
**Responsable du modèle** : MARQUET David  
**Responsable du développement du noyau** : LAGIER Hadrien  
**Responsable du développement de l’IHM** : FRANCES-GENTILLET Solene  
**Responsable technique** : VINTROU Matheo

## Lancer le jeu

Ce projet Java est compatible avec les IDE suivants :

- **Eclipse**
- **NetBeans**


### Prérequis

- Java JDK 8 ou supérieur installé ([télécharger ici](https://www.oracle.com/java/technologies/javase-downloads.html))
- Un IDE Java comme Eclipse ou NetBeans

### Importer le projet

#### Avec Eclipse :
1. Ouvrez Eclipse.
2. Allez dans `File` > `Import`.
3. Sélectionnez `Existing Projects into Workspace` (dans `General`).
4. Choisissez le dossier du projet.
5. Cliquez sur `Finish`.

#### Avec NetBeans :
1. Ouvrez NetBeans.
2. Allez dans `File` > `Open Project`.
3. Sélectionnez le dossier du projet.
4. Cliquez sur `Open Project`.

### Lancer le jeu

Une fois le projet importé :
- Classe principale : `Main.java`.
- Faites un clic droit dessus et sélectionnez **Run** ou **Exécuter le fichier**.  

  

## Arborescence du projet

Voici l'arborescence de nos fichiers. Le modèle ECB se trouve dans `ppirate/src/main/java`.

```
.
├── docs
│   ├── diagramme_classe_v1.png
│   ├── diagramme_classe_v2.pdf
│   ├── maquette_ihm_v1.png
│   ├── PLANIFICATION_GANTT.png
│   └── test
│       ├── ProjetPirate - Spécification Fonctionnelle.pdf
│       ├── ProjetPirate - Test Mutations.pdf
│       └── ProjetPirate - Validation Fonctionnelle.pdf
├── ppirate
│   ├── bin
│   │   └── nbproject
│   │       └── project.properties
│   ├── pom.xml
│   └── src
│       ├── main
│       │   ├── java
│       │   │   ├── boundary
│       │   │   │   └── MainConsole.java
│       │   │   ├── Main.java
│       │   │   ├── noyaufonctionnel
│       │   │   │   ├── controller
│       │   │   │   │   ├── ControlCarte.java
│       │   │   │   │   ├── ControlChoisirNomJoueur.java
│       │   │   │   │   └── ControlJeu.java
│       │   │   │   └── entity
│       │   │   │       ├── cartes
│       │   │   │       │   ├── Attaque.java
│       │   │   │       │   ├── Carte.java
│       │   │   │       │   ├── Echange.java
│       │   │   │       │   ├── GainVie.java
│       │   │   │       │   ├── IEffetCarte.java
│       │   │   │       │   ├── Popularite.java
│       │   │   │       │   └── Protection.java
│       │   │   │       ├── DictionnaireCarte.java
│       │   │   │       ├── Jeu.java
│       │   │   │       ├── Joueur.java
│       │   │   │       └── Pioche.java
│       │   │   ├── util
│       │   │   │   ├── CarteFactory.java
│       │   │   │   ├── EnumCarte.java
│       │   │   │   └── EnumJoueur.java
│       │   │   └── vue
│       │   │       └── ui
│       │   │           ├── dialog
│       │   │           │   ├── AdaptateurDuNoyauFonctionnel.java
│       │   │           │   └── MainDialog.java
│       │   │           └── presentation
│       │   │               ├── CartePanel.form
│       │   │               ├── CartePanel.java
│       │   │               ├── ChargeurImage.java
│       │   │               ├── ChoixNom.form
│       │   │               ├── ChoixNom.java
│       │   │               ├── components
│       │   │               │   ├── CustomJButton.java
│       │   │               │   ├── CustomJTextField.java
│       │   │               │   ├── DescriptionPanel.form
│       │   │               │   ├── DescriptionPanel.java
│       │   │               │   ├── JaugeDePopularitePanel.form
│       │   │               │   ├── JaugeDePopularitePanel.java
│       │   │               │   ├── JaugeDeViePanel.form
│       │   │               │   ├── JaugeDeViePanel.java
│       │   │               │   ├── MainJoueurPanel.form
│       │   │               │   ├── MainJoueurPanel.java
│       │   │               │   ├── Pioche.form
│       │   │               │   ├── Pioche.java
│       │   │               │   ├── ProfilJoueurPanel.form
│       │   │               │   ├── ProfilJoueurPanel.java
│       │   │               │   ├── TimerPanel.form
│       │   │               │   ├── TimerPanel.java
│       │   │               │   ├── ViePanel.form
│       │   │               │   ├── ViePanel.java
│       │   │               │   ├── ZonePopularitePanel.form
│       │   │               │   └── ZonePopularitePanel.java
│       │   │               ├── FinPartie.form
│       │   │               ├── FinPartie.java
│       │   │               ├── Plateau.form
│       │   │               ├── Plateau.java
│       │   │               ├── TimeOutEvent.java
│       │   │               └── TimeOutListener.java
│       │   └── resources
│       │       └── presentation
│       │           ├── bill_jambe_de_bois_joueur.png
│       │           ├── enter_game.png
│       │           ├── icon_ppirate.png
│       │           ├── icon_ppirate.png~
│       │           ├── jack_le_borgne_joueur.png
│       │           ├── logo.png
│       │           ├── logo_ppirate.png
│       │           └── plateau_background.png
│       └── test
│           └── java
│               ├── noyaufonctionnel
│               │   └── entity
│               │       ├── cartes
│               │       │   ├── AttaqueTest.java
│               │       │   ├── CarteTest.java
│               │       │   ├── EchangeTest.java
│               │       │   ├── GainVieTest.java
│               │       │   ├── PopulariteTest.java
│               │       │   └── ProtectionTest.java
│               │       ├── DictionnaireCarteTest.java
│               │       ├── JeuTest.java
│               │       ├── JoueurTest.java
│               │       └── PiocheTest.java
│               └── scenarioDeTest
│                   └── ScenarioDeTests.java
└── README.md

28 directories, 81 files
```

`ppirate` : projet java

`docs` : documents de modélisation, de gestion de projet, de tests, wireframes, ...

`docs/PLANIFICATION_GANTT.png` : premier jet de planification de tâches

`docs/diagramme_sequence_*` : diagramme séquences.

`docs/diagramme_classe_finale.png` : diagramme classe finalisé.

`docs/maquette_ihm_v1.png` : v1 maquette visuel fini sans interaction

`docs/test/` : spécification fonctionnelle, validation fonctionnel et rapport de mutation

`resources` : image de notre projet  

## License

- This project is licensed for personal, non-commercial use only.  
Commercial use, redistribution, or modification without permission is prohibited.