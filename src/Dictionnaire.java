public class Dictionnaire {

    private String nom;
    private MotDict[] dict;
    private int nb_mots;

    public Dictionnaire(String nom, int taille) {
        this.nom = nom;
        this.dict = new MotDict[taille];
        this.nb_mots = 0;
    }

    public Dictionnaire(String nom) {
        this(nom, 10);
    }

    public void Ajouter_Mot(MotDict motDict) {
        if (nb_mots < dict.length) {
            dict[nb_mots] = motDict;
            nb_mots++;
            Trier();
        } else {
            System.out.println("Le dictionnaire est plein.");
        }
    }

    public void Trier() {
        for (int i = 0; i < nb_mots - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nb_mots; j++) {
                if (dict[j].getMot().compareToIgnoreCase(dict[min].getMot()) < 0) {
                    min = j;
                }
            }

            MotDict temp = dict[min];
            dict[min] = dict[i];
            dict[i] = temp;
        }
    }

    public void Supprimer_Mot(MotDict motDict) {
        boolean trouve = false;
        for (int i = 0; i < nb_mots; i++) {
            if (this.dict[i].getMot().equalsIgnoreCase(motDict.getMot())) {
                for (int j = i; j < nb_mots - 1; j++) {
                    this.dict[j] = this.dict[j + 1];
                }
                this.dict[nb_mots - 1] = null;
                nb_mots--;
                trouve = true;
                break;
            }
        }
        if (!trouve) {
            System.out.println("Le mot n'existe pas dans le dictionnaire.");
        }
    }



    public String Recherche_dicho(String mot) {
        int debut = 0;
        int fin = nb_mots - 1;
        while (debut <= fin) {
            int milieu = (debut + fin) / 2;
            int compar = dict[milieu].getMot().compareToIgnoreCase(mot);
            if (compar == 0) {
                return dict[milieu].getDefinition();
            } else if (compar < 0) {
                debut = milieu + 1;
            } else {
                fin = milieu - 1;
            }
        }
        return "Mot non trouvé.";
    }
    public void Lister_dictionnaire() {
        if (nb_mots == 0) {
            System.out.println("Le dictionnaire est vide.");
        } else {
            for (int i = 0; i < nb_mots; i++) {
                System.out.println("Mot : " + dict[i].getMot() + " - Définition : " + dict[i].getDefinition());
            }
        }
    }

    public int Nombre_synonyme(MotDict motDict) {
        int count = 0;
        for (int i = 0; i < nb_mots; i++) {

            if (!dict[i].getMot().equalsIgnoreCase(motDict.getMot()) &&
                    dict[i].synoo(motDict)) {
                count++;
            }
        }
        return count;
    }






















    public int getNbMots() {
        return nb_mots;
    }


    public MotDict[] getDict() {
        return dict;
    }}