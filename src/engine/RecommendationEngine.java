package engine;

import java.util.ArrayList;
import java.util.List;
import models.HomeData;

public class RecommendationEngine {

    // Single entry point
    public List<String> generateRecommendations(HomeData home) {

        List<String> rec = new ArrayList<>();

        checkLighting(home, rec);
        checkWindows(home, rec);
        checkInsulationDerived(home, rec);
        checkCooling(home, rec);
        checkAppliances(home, rec);
        checkVentilationDerived(home, rec);
        checkHouseType(home, rec);

        if (rec.isEmpty()) {
            rec.add(
                "Your building already follows good energy-efficient practices. " +
                "Continue regular maintenance to retain performance."
            );
        }

        return rec;
    }

    // -------- RULE CHECKS --------

    private void checkLighting(HomeData home, List<String> rec) {
        if (!home.lighting.equalsIgnoreCase("LED")) {
            rec.add("Upgrade to LED lighting to significantly reduce electricity consumption.");
        }
    }

    private void checkWindows(HomeData home, List<String> rec) {
        if (home.windows.equalsIgnoreCase("Single Glazed")) {
            rec.add("Install double-glazed windows to reduce heat loss and improve insulation.");
        }
    }

    // Insulation derived from wall + windows
    private void checkInsulationDerived(HomeData home, List<String> rec) {
        if (home.wallType.equalsIgnoreCase("Glass") ||
            home.wallType.equalsIgnoreCase("Brick") &&
            home.windows.equalsIgnoreCase("Single Glazed")) {

            rec.add("Improve wall insulation and upgrade windows to maintain indoor temperature efficiently.");
        }
    }

    private void checkCooling(HomeData home, List<String> rec) {
        if (home.cooling.equalsIgnoreCase("Old AC")) {
            rec.add("Replace old AC units with energy-efficient inverter-based models.");
        }
    }

    private void checkAppliances(HomeData home, List<String> rec) {
        if (home.applianceAge > 8) {
            rec.add("Replace old appliances with modern energy-efficient alternatives.");
        }
    }

    // Ventilation derived from system
    private void checkVentilationDerived(HomeData home, List<String> rec) {
        if (home.ventilationSystem.equalsIgnoreCase("Centralized HVAC")) {
            rec.add("Improve natural ventilation to reduce dependency on centralized HVAC systems.");
        }
    }

    private void checkHouseType(HomeData home, List<String> rec) {
        if (home.houseType.equalsIgnoreCase("Commercial")) {
            rec.add("Consider energy audits and smart energy management systems for commercial buildings.");
        }
    }
}
