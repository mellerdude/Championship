# Championship
Tournament overview for multiple sports in javaFX 

Using javaFX with Eclipse after recent update to Eclipse:
  must add a plugin downloaded from here https://gluonhq.com/products/javafx/  to the build file of the project
  must add to the run configurations in VM arguments the string:
    --module-path "YOUR_JAVAFX_DIRECTORY\lib" --add-modules javafx.controls,javafx.fxml
  where YOUR_JAVAFX_DIRECTORY is where your javafx folder is downloaded.

Program process:
  1. Sport is chosen and names are entered by the user for competitors in the tournament
  2. Tournament begins. Each round the user enters the scoring and can follow the tournaments process.
      Note that each round must be completed before the next round begins.
  3. After a tournament ends and there is a winner, the user can select a different sport to make a tournament in.
  4. After all tournaments were run, a END GAME button can be selected to terminate the program
  
Know Issues:
   If there is a tie in a match the winner is randomly selected unlesss its soccer where it follows to a shootout
