package engine;

import java.util.ArrayList;
import java.util.List;
import models.HomeData;

public class RecommendationEngine {

    // ✅ Public API – single entry point
    public List<String> generateRecommendations(HomeData home) {

        List<String> recommendations = new ArrayList<>();

        checkLighting(home, recommendations);
        checkWindows(home, recommendations);
        checkInsulation(home, recommendations);
        checkCooling(home, recommendations);
        checkAppliances(home, recommendations);
        checkVentilation(home, recommendations);

        if (recommendations.isEmpty()) {
            recommendations.add(
                "Your home already follows good energy-efficient practices. " +
                "Continue regular maintenance to retain performance."
            );
        }

        return recommendations;
    }

    // ----------- Individual Rule Checks -----------

    private void checkLighting(HomeData home, List<String> rec) {
        if (!home.lighting.equalsIgnoreCase("LED")) {
            rec.add("Upgrade to LED lighting to reduce electricity consumption by up to 80%.");
        }
    }

    private void checkWindows(HomeData home, List<String> rec) {
        if (home.windows.equalsIgnoreCase("Single Glazed")) {
            rec.add("Install double-glazed windows to reduce heat loss and improve insulation.");
        }
    }

    private void checkInsulation(HomeData home, List<String> rec) {
        if (home.insulation.equalsIgnoreCase("Poor") ||
            home.insulation.equalsIgnoreCase("None")) {
            rec.add("Improve wall and roof insulation to maintain indoor temperature naturally.");
        }
    }

    private void checkCooling(HomeData home, List<String> rec) {
        if (home.cooling.equalsIgnoreCase("Old AC")) {
            rec.add("Replace old AC units with energy-efficient inverter-based models.");
        }
    }

    private void checkAppliances(HomeData home, List<String> rec) {
        if (home.applianceAge > 8) {
            rec.add("Replace appliances older than 8 years with energy-efficient alternatives.");
        }
    }

    private void checkVentilation(HomeData home, List<String> rec) {
        if (home.ventilation.equalsIgnoreCase("Poor")) {
            rec.add("Improve natural ventilation to reduce dependency on artificial cooling.");
        }
    }
}
