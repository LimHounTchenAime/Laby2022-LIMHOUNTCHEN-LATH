# Laby2022-LIMHOUNTCHEN-LATH
> Binôme:

- LIM HOUN TCHEN Aime
- LATH Victor

>Partie programmation 
- Un descriptif des difficultés rencontrées au cours du TP : 

Quelques difficultés sur les tests d'exceptions car on n'avait pas importé les exceptions créée
dans les tests (voir testLabyDeuxSortie()).

- Explication des choix de programmation :
Les attributs de Position sont en protected ce qui évite l'utilisation répétitive de setter et guetter..  
Dans l'ensemble,on est resté proche du sujet.


- Un descriptif expliquant comment lancer votre application: 
1. lancer la commande: java MainLabyrinthe laby/nomdulabyrinthe.txt
2. le programme vous demandera d'écrire une direction("haut","gauche","droite","bas")

>Résumé et présentation des tests:
  - TestPostion :
    - le but de cette classe de test est de vérifier si la méthode déplacer selon les axes se font dans la bonne direction.
  - LabyrintheTest : 
    - testChargerLabyrintheLaby()
      - Cette méthode a pour but de vérifier si le labyrinthe est bien chargé.
    - testDeplacerPerso : 
      - A pour but de vétifier si le déplacement du personnage a bien exécuté en le comparant avec ce qui était prévue . 
    - testLabyPasDeSortie :
      - Lors des tests, il ya eu un probleme de ligne invisible  "\n" dans les fichiers laby qui n'a pas permis le bon déroulement de la méthode chargerLabyrinthe.
    - testLabyDeuxSortie : 
      - A pour but de vérifier si la méthode a bien trouver deux sortie ce qui lance une exception.
    - testLabyElementIncorrect : 
      - Test l'exception estLabyPasPersonnage() s'est bien levé lorsque le fichier n'existe pas.
    - testLabyPasPersonnage :
      - Test la levé de l'exception FichierIncorrectException lorsque qu'il n'y a pas de personnage.
    - testLabyDeuxPersonnage :
      - Test la levé de l'exception FichierIncorrectException lorsque qu'il a 2 de personnages.
    -testDimensionsIncorrectes : 
      - A pour but de vérifier si les dimensions dans le fichier txt et le labyrinthe correspond au bon nombre de ligne et de colonne. 