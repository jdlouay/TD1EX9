public class Main {
    public static void main(String[] args) {

        Dictionnaire dictionnaire = new Dictionnaire("Mon Dictionnaire", 5);


        MotDict mot1 = new MotDict("Rapide", "Qui se déplace rapidement.");
        MotDict mot2 = new MotDict("Vite", "Qui se déplace rapidement.");
        MotDict mot3 = new MotDict("Lent", "Qui se déplace lentement.");
        MotDict mot5 = new MotDict("Tigre", "Un grand félin sauvage.");

        dictionnaire.Ajouter_Mot(mot1);
        dictionnaire.Ajouter_Mot(mot2);
        dictionnaire.Ajouter_Mot(mot3);

        dictionnaire.Ajouter_Mot(mot5);

        System.out.println("Dictionnaire après ajout et tri :");
        dictionnaire.Lister_dictionnaire();

        String motRecherche = "lent";
        String definition = dictionnaire.Recherche_dicho(motRecherche);
        System.out.println("\nRecherche du mot '" + motRecherche + "' : " + definition);

        int nombreSynonymes = dictionnaire.Nombre_synonyme(mot1);
        System.out.println("\nNombre de synonymes pour 'Chien' : " + nombreSynonymes);

        dictionnaire.Supprimer_Mot(mot2);
        System.out.println("\nDictionnaire après suppression de 'Chat' :");
        dictionnaire.Lister_dictionnaire();
    }
}
