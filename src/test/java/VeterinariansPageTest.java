import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VeterinariansPageTest extends BaseTest {
    @BeforeEach
    public void loadPetClinic() {
        webApp.homePage().gotoPage();
    }

    @Test
    @DisplayName("PC-05: Can go to veterinarians page")
    public void canGoToVeterinariansPage() {
        webApp.components().mainMenu().clickVeterinariansLink();
        webApp.veterinariansPage().verifyHeaderText("Veterinarians");
    }

    @Test
    @DisplayName("PC-05: Can search for existing veterinarians")
    public void canSearchForExistingVeterinarians() {
        webApp.components().mainMenu().clickVeterinariansLink();
        webApp.veterinariansPage().search("Helen");
        webApp.veterinariansPage().verifyTableTotalRows(1);
        webApp.veterinariansPage().verifyTableTextContains("Helen Leary");
    }

    @Test
    @DisplayName("PC-06: Can search for not existing veterinarians")
    public void canSearchForNotExistingVeterinarians() {
        webApp.components().mainMenu().clickVeterinariansLink();
        webApp.veterinariansPage().search("Helenaaaa");
        webApp.veterinariansPage().verifyTableTextContains("No matching records found");
    }
}