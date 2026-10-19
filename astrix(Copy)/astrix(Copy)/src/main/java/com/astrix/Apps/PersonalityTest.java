package com.astrix.Apps;

import com.astrix.astrixModule.AstrixConsole;

import java.util.Scanner;

public class PersonalityTest extends Apps {

    AstrixConsole con = new AstrixConsole();
    Scanner scanner = new Scanner(System.in);

    public PersonalityTest() {
        super(false);
    }

    @Override
    public String getName() {
        return "MBTI Personality Test";
    }

    @Override
    public String getCode() {
        return "mbti";
    }

    @Override
    public String creatorName() {
        return "Patricia Velasco";
    }

    @Override
    public double sizeFile() {
        return 8.0;
    }

    @Override
    public String version() {
        return "1.0";
    }

    @Override
    public String description() {
        return "A simple personality test based on the four MBTI preference pairs.";
    }

    @Override
    public void run() {

        while (true) {

            int E = 0;
            int I = 0;
            int N = 0;
            int S = 0;
            int T = 0;
            int F = 0;
            int J = 0;
            int P = 0;

            con.clear();

            con.title("PERSONALITY TEST");
            System.out.println();

            System.out.println("Answer each question with 1 or 2");
            con.pause();
            
            con.clear();

            int ans1 = ask(
                    "1. After a tiring week, what would you rather do?",
                    "1. Hang out or talk with friends",
                    "2. Stay alone and recharge"
            );

            if (ans1 == 1) {
                E++;
            } else {
                I++;
            }

            con.clear();

            int ans2 = ask(
                    "2. When you're in a new group, you usually:",
                    "1. Start talking and meeting people",
                    "2. Wait until someone talks to you"
            );

            if (ans2 == 1) {
                E++;
            } else {
                I++;
            }

            con.clear();

            int ans3 = ask(
                    "3. During your free time, you prefer to:",
                    "1. Go out and spend time with other people",
                    "2. Stay home and enjoy your own company"
            );

            if (ans3 == 1) {
                E++;
            } else {
                I++;
            }

            con.clear();

            int ans4 = ask(
                    "4. When learning something new, you prefer:",
                    "1. Real examples and actual facts",
                    "2. Ideas, theories, and possibilities"
            );

            if (ans4 == 1) {
                S++;
            } else {
                N++;
            }

            con.clear();

            int ans5 = ask(
                    "5. When doing a project, you focus more on:",
                    "1. The details and instructions",
                    "2. The overall idea and creativity"
            );

            if (ans5 == 1) {
                S++;
            } else {
                N++;
            }

            con.clear();

            int ans6 = ask(
                    "6. When someone explains something to you, you prefer:",
                    "1. Clear facts and specific examples",
                    "2. Big ideas and possible meanings"
            );

            if (ans6 == 1) {
                S++;
            } else {
                N++;
            }

            con.clear();

            int ans7 = ask(
                    "7. When making an important decision, you usually:",
                    "1. Think about logic and facts",
                    "2. Think about people's feelings"
            );

            if (ans7 == 1) {
                T++;
            } else {
                F++;
            }

            con.clear();

            int ans8 = ask(
                    "8. Your friend has a problem. You would usually:",
                    "1. Give them a practical solution",
                    "2. Comfort them and listen first"
            );

            if (ans8 == 1) {
                T++;
            } else {
                F++;
            }

            con.clear();

            int ans9 = ask(
                    "9. When giving advice to someone, you usually:",
                    "1. Tell them what makes the most logical sense",
                    "2. Consider how your advice might make them feel"
            );

            if (ans9 == 1) {
                T++;
            } else {
                F++;
            }

            con.clear();

            int ans10 = ask(
                    "10. When you have an assignment, you prefer to:",
                    "1. Plan it and finish it early",
                    "2. Do it whenever you feel ready"
            );

            if (ans10 == 1) {
                J++;
            } else {
                P++;
            }

            con.clear();

            int ans11 = ask(
                    "11. Your weekend plans are suddenly changed. You:",
                    "1. Feel bothered because you already planned",
                    "2. Easily adjust and make a new plan"
            );

            if (ans11 == 1) {
                J++;
            } else {
                P++;
            }

            con.clear();

            int ans12 = ask(
                    "12. When starting a school project, you prefer to:",
                    "1. Make a plan and follow it",
                    "2. Start first and decide what to do along the way"
            );

            if (ans12 == 1) {
                J++;
            } else {
                P++;
            }

            showResult(E, I, S, N, T, F, J, P);

            con.lineSpacing(2);

            System.out.println("1. Take Test Again");
            System.out.println("2. Back to Home Screen");

            int choice = con.choose();

            if (choice == 1) {
                continue;
            }

            if (choice == 2) {
                return;
            }

            System.out.println("Invalid Input");
            con.doublePause();
        }
    }

    private int ask(String question, String ch1, String ch2) {

        while (true) {
            
            String asks = question;
            
            con.title(asks);
            
            System.out.println(ch1);
            System.out.println(ch2);

            int answer = con.choose();

            if (answer == 1 || answer == 2) {
                return answer;
            }

            System.out.println();
            System.out.println("Please choose 1 or 2.");
            con.doublePause();
            con.clear();
        }
    }

    private void showResult(
            int E,
            int I,
            int S,
            int N,
            int T,
            int F,
            int J,
            int P) {

        String personality = "";

        if (E > I) {
            personality += "E";
        } else {
            personality += "I";
        }

        if (S > N) {
            personality += "S";
        } else {
            personality += "N";
        }

        if (T > F) {
            personality += "T";
        } else {
            personality += "F";
        }

        if (J > P) {
            personality += "J";
        } else {
            personality += "P";
        }

        con.clear();
        con.title("MBTI RESULT");

        System.out.println("Your personality type is:");
        System.out.println();
        System.out.println("          " + personality);
        System.out.println();

        System.out.println("E : " + E);
        System.out.println("I : " + I);
        System.out.println("S : " + S);
        System.out.println("N : " + N);
        System.out.println("T : " + T);
        System.out.println("F : " + F);
        System.out.println("J : " + J);
        System.out.println("P : " + P);
    }
}