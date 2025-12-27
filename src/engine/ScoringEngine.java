package engine;

import models.HomeData;

public class ScoringEngine {

    public static int calculateScore(HomeData home) {

        int score = 0;

        // INSULATION (auto derived)
        if (home.wallType.equalsIgnoreCase("Concrete") &&
            home.windows.equalsIgnoreCase("Double Glazed")) {
            score += 20;
        } else if (home.wallType.equalsIgnoreCase("Brick")) {
            score += 10;
        }

        // WINDOWS
        if (home.windows.equalsIgnoreCase("Double Glazed")) {
            score += 15;
        }

        // LIGHTING
        if (home.lighting.equalsIgnoreCase("LED")) {
            score += 15;
        }

        // COOLING
        if (home.cooling.equalsIgnoreCase("Fan")) {
            score += 10;
        } else if (home.cooling.equalsIgnoreCase("AC")) {
            score += 5;
        }

        // HEATING
        if (home.heating.equalsIgnoreCase("Heater")) {
            score += 5;
        }

        // VENTILATION (auto derived)
        if (home.ventilationSystem.equalsIgnoreCase("Natural")) {
            score += 10;
        } else if (home.ventilationSystem.equalsIgnoreCase("Exhaust Fan")) {
            score += 5;
        }

        // APPLIANCE AGE
        if (home.applianceAge <= 5) score += 10;
        else if (home.applianceAge <= 8) score += 5;

        // ROOF
        if (home.roofType.equalsIgnoreCase("Concrete")) score += 10;
        else if (home.roofType.equalsIgnoreCase("Tiled")) score += 5;

        // HOUSE TYPE
        if (home.houseType.equalsIgnoreCase("Commercial")) {
            score -= 5;
        }

        return score;
    }

    public static char getGrade(int score) {
        if (score >= 80) return 'A';
        else if (score >= 65) return 'B';
        else if (score >= 50) return 'C';
        else if (score >= 35) return 'D';
        else if (score >= 20) return 'E';
        else return 'F';
    }
}
