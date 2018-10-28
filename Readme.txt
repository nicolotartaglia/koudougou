# Test de Primarite
Pour tester l'executable,  javac mullerrabin.jar 200  512

# Test de Gencle
Pour tester l'executable,  javac gencle.jar 1024 : Lui il va creer deux fichiers (golemi.pub et golemi.priv)

# Test de Chiff
Pour tester l'executable,  javac chif.jar "Mon message" golemi.pub  

# Test de deChiff
Pour tester l'executable,  javac dechif.jar "Message_chifrre" golemi.priv

# Test de Sign
Pour tester l'executable,  javac sign.jar "Message_a signer" golemi.priv

# Test de verif
Pour tester l'executable,  javac verif.jar "Message_a signee" golemi.pub
