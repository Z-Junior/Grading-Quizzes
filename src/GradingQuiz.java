import java.util.Scanner;

public class GradingQuiz
{
    private final static Scanner SCAN = new Scanner(System.in);

    public static void main(String[] args)
    {
        grade();
    }

    protected static void grade()
    {
        int iCorrect = 0;

        int iLen = PromptInt("Number of questions: ");

        char cKey[] = new char[iLen];

        SCAN.nextLine();

        for (int i = 0; i < iLen; i++)
            cKey[i] = PromptString(String.format("Enter the key for question %d: ", i + 1)).charAt(0);

        for (int i = 0; i < iLen; i++)
            if (cKey[i] == PromptString(String.format("Enter the answer for question %d: ", i + 1)).charAt(0))
                iCorrect++;

        System.out.println(String.format("Number Correct: %d\r\nPercentage Correct: %d%%", iCorrect, (iCorrect / iLen) * 100));

        if (PromptString("Grade another quiz? (y/n): ").equalsIgnoreCase("y"))
            grade();
    }

    protected static int PromptInt(String question)
    {
        System.out.print(question);

        while (!SCAN.hasNextInt())
        {
            System.out.flush();

            System.out.print("Enter a number: ");

            SCAN.next();
        }

        return SCAN.nextInt();
    }

    protected static String PromptString(String question)
    {
        System.out.print(question);

        while (!SCAN.hasNextLine())
        {
            System.out.flush();

            System.out.print("Enter a string: ");

            SCAN.next();
        }

        return SCAN.nextLine();
    }
}
