# Utilisation d'API pour la Création de Transactions avec AvaTax

Ce projet Java démontre comment utiliser l'API d'AvaTax pour créer des transactions en utilisant Gson et Unirest. Il est basé sur deux classes : `Main` et `SampleClass`.

## Instructions d'Utilisation

1. Assurez-vous d'avoir le fichier JSON de transaction (transaction.json) correctement formaté. Vous pouvez le modifier selon vos besoins en conséquence.

2. Dans le fichier `Main.java`, remplacez le chemin du fichier JSON (`filename`) par le chemin de votre fichier transaction.json.

3. Assurez-vous d'avoir ajouté les dépendances Gson et Unirest à votre projet Java pour utiliser ces bibliothèques.

4. Exécutez la méthode `main` de la classe `Main` pour envoyer la requête POST à l'API d'AvaTax et créer la transaction.

## Configuration des Identifiants

Assurez-vous de remplacer `{X-Avalara-Client}` et `codeàmettre` par vos véritables identifiants d'authentification fournis par AvaTax.

## Note Importante

Ce projet suppose que vous avez déjà configuré votre compte AvaTax et obtenu les informations d'authentification nécessaires pour interagir avec l'API. Si ce n'est pas le cas, veuillez vous référer à la documentation d'AvaTax pour plus d'informations sur la configuration de votre compte et l'obtention des identifiants d'authentification nécessaires.

**Remarque**

Ce projet est destiné à des fins éducatives et démontre comment utiliser l'API d'AvaTax avec Gson et Unirest pour créer des transactions. Assurez-vous de respecter les règles d'utilisation appropriées lors de l'intégration de l'API d'AvaTax dans votre propre projet.

## Auteur

Ce projet a été développé par [Nerlyss1](https://github.com/Nerlyss1).
