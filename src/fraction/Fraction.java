package fraction;

public class Fraction {

    private Integer numerateur;
    private Integer denominateur;

    private double resultat;

    /**
     * Constructeur par défaut :
     * En entrant un numérateur et un dénominateur
     * @param numerateur double
     * @param denominateur double
     */
    public Fraction(Integer numerateur, Integer denominateur) {
        this.setNumerateur(numerateur);
        this.setDenominateur(denominateur);
        if (denominateur == 0){
            System.out.println("Le dénominateur ne peut pas être égal à 0");
            denominateur = 1;
        }
    }

    /**
     * Constructeur inversé :
     * En entrant un entier
     * @param resultat
     */
    public Fraction(double resultat){
        this.setResultat(resultat);
    }

    @Override
    public String toString(){
        String newLine = System.getProperty("line.separator");
        String numerateurString = numerateur + "     <-- Le numérateur ";
        String denominateurString = denominateur + "     <-- Le dénominateur";
        String separateur = "-----";
        String pgcd = "Le PGCD est : " + pgcd().toString();
        String reduire = reduire();
        return (numerateurString +
                newLine + separateur +
                newLine + denominateurString +
                newLine + pgcd +
                newLine + reduire);
    }

    /**
     * Numérateur de la fraction
     */
    public double getNumerateur() {
        return numerateur;
    }

    public void setNumerateur(Integer numerateur) {
        this.numerateur = numerateur;
    }

    /**
     * Dénominateur de la fraction
     */
    public double getDenominateur() {
        return denominateur;
    }

    public void setDenominateur(Integer denominateur) {
        this.denominateur = denominateur;
    }

    /**
     * Résultat de la fraction
     */
    public double getResultat() {
        return resultat;
    }

    public void setResultat(double resultat) {
        this.resultat = resultat;
    }

    /**
     * Trouver le Plus Grand Commun Dénominateur
     * @return Integer
     */
    public Integer pgcd(){
        Integer pgcd;
        Integer numTemporaire = this.numerateur;
        Integer denominateurTemporaire = this.denominateur;
        while (denominateurTemporaire != 0){
            pgcd = numTemporaire % denominateurTemporaire;
            numTemporaire = denominateurTemporaire;
            denominateurTemporaire = pgcd;
        }
        return numTemporaire;
    }

    /**
     * Test : la fraction est-elle égale à une autre ?
     * @param fraction Fraction à comparer
     */
    public boolean egaleA(Fraction fraction){
        return numerateur * fraction.getDenominateur() == fraction.getNumerateur() * denominateur;
    }

    /**
     *  * Réduire et simplifier une fraction
     */
    public String reduire(){
        Integer pgcd = pgcd();
        Integer nouveauNumerateur = numerateur/pgcd;
        Integer nouveauDenominateur = denominateur/pgcd;

        if (nouveauDenominateur < 0) {
            nouveauDenominateur *= -1;
            nouveauNumerateur *= -1;
        }
        return "La fraction peut être réduite à : " + nouveauNumerateur + "/" + nouveauDenominateur;
    }
}
