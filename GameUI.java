public class GameUI {

    private String welcomeMessage = "Welcome to the Number Guessing Game!";

    private String gameRules = String.format(
        "%nI'm thinking of a number between 1 and 100.%n" +
        "You have some chances to guess the correct number.%n" +
        "================================================="
    );

    private String difficultyMessage = String.format(
        "%nPlease select the difficulty level: %n" +
        "- Enter 1 for Easy (10 chances) %n" +
        "- Enter 2 for Medium (5 chances) %n" +
        "- Enter 3 for Hard (3 chances)"
    );

    // getter(s)

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public String getGameRules() {
        return gameRules;
    }

    public String getDifficultyMessage() {
        return difficultyMessage;
    }

    // method(s)
    public String getSelectedDifficultyStatus(int difficulty) {
        String difficultyLevel = null;
        if (difficulty == 1) {
            difficultyLevel = "Easy";
        } else if (difficulty == 2) {
            difficultyLevel = "Medium";
        } else if (difficulty == 3) {
            difficultyLevel = "Hard";
        }

        return (
            "Great! You have selected " +
            difficultyLevel +
            "Level Difficulty\n" +
            "Let's Start the game\n" +
            "-------------------------------"
        );
    }
}
