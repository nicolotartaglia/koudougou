## TP Crypto
Ce projet a été realisé en Java 8 sur Eclipse. Il est divisée en trois dossiers

 * Le dossier src  contient les sources des classes
 * Le dossier executable contient les executables (les .jar)
 * Les clés générés sont sauvegardées dans le dossier principale dans leur nature et se nomme : golemi.pub et golemi.priv
Les clées qui sont des bigInteger sont sauvegardé à l'etat d'object serializable.

Chaque fonctionnalité à été présentée en package et chaque package a éte divisé en deux classe:

* Une classe d'implementation 
* Une classe de Test qui constitue l'entrée du programme.

Les deux classes Constant et FileUtils sont utilisé dans toutes les packages, ils posséde des méthodes utilitaires.
de la gestion du package.


## 4.1 Test de primality:
Le package algo correspond à la fonctionnalité de test de primarité. Il implemente l'algorithme de MulleRabin pour verifier si un nombre donné est premier ou pas.
 Pour le tester, il faut fournir a la methode main un nombre  (exemple : 512 1024).
 Celle ci va generer un nombre premier.

Pour tester l'executable,  javac mullerrabin.jar 200  512


## 5.1 Generation de clée:

Le package gencle est utilisée pour generer des clées de rsa. Elle fournit un executable qui prend en entrée la taille de la clé et sauvegarde la clé public sous le nom /keys/golemi.pub et la clé privée golemi.priv

Pour le tester, il faut fournir à la methode main la taille de la clée :

  String : Le message à chiffrer.
  String : le chemin complet de la clé public (ici) : golemi.pub


## 5.2 Chiffrement:

Le package chifr fournit un executable qui prend en entrée le message de l'utilisateur et le chemin complet de la clé public et produit en sortie le message chiffré.

Pour le tester, il faut fournir à la methode main les arguments suivants :

  String : Le message a chiffré.
  String : le chemin complet de la cle public (ici) : golemi.pub


## 5.3 Dechiffrement:


Le package dechifr fournit un executable qui prend en entrée le message (chiffré avec golemi.priv ) a dechiffrer et le chemin complet de la clé private et produit en sortie le message dechiffré.

Pour le tester, il faut fournir à la methode main les arguments suivants :

  String : Le message a dechiffrer. (Le message doit etre au prealablement chiffré avec golemi.priv)
  String : le chemin complet de la cle privée (ici) : golemi.priv



## 5.4 Signature:


Le package sign fournit un executable qui prend en entrée le message de l'utilisateur  à signer et le chemin complet de la clé public et produit en sortie le message signée. Le message signée est sortie en format base64.

Pour le tester, il faut fournir à la methode main les arguments suivants :

  String : Le message à signer.
  String : le chemin complet de la cle public (ici) : golemi.pub


## 5.5 Verification:


Le package verif fournit un executable qui prend en entrée le message original, le message chiffree (signée avec golemi.pub ) à verifier la signature et le chemin complet de la clé private et produit en sortie le message dechiffré.

Pour le tester, il faut fournir à la methode main les arguments suivants :

  String  : Le message original
  String : Le message  signé. (Le message doit etre au prealablement signée avec golemi.pub)
  String : le chemin complet de la cle privée (ici) : golemi.priv
  
  java -jar mon_text message_signe golemi.priv

Les executables:

    chifr.jar
    gencle.jar
    dechifr.jar
    sign.jar
    verif.jar
    mullerrabin.jar
