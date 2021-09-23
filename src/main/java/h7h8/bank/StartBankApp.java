package h7h8.bank;

// je hebt je gitignore niet helemaal op orde:
// - git wil de idea folder en iml files toevoegen, dat moet niet
// - je hebt target classes gecommit, dat moet niet
public class StartBankApp {

    // goede scheiding van verantwoordelijkheden!

    public static void main(String[] args) {
        BankApp bankApp = new BankApp();
        bankApp.start();
    }
}
