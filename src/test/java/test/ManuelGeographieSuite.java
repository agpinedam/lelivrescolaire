package test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

public class ManuelGeographieSuite extends BaseTest{

    @Test
    @Feature("Manuel Geographie")
    @Description("Comme utilisateur je dois être capable de naviguer sur le manuelle qui se compose de les annexes thèmes et chapitres")
    public void naviegerSurChapitres() {
        manuelGeographie.chapterSelection("Rome, du mythe à l’histoire");
        manuelGeographie.titleValidation("Rome, du mythe à l'histoire");
        manuelGeographie.subTitleValidation("Introduction");
        manuelGeographie.introductionTextValidation("Rome, petite cité de bergers et de chasseurs, devient en quelques siècles la capitale d'un vaste empire qui s'étend sur toute la Méditerranée. Les Romains réécrivent l'histoire de leurs origines et construisent des mythes expliquant leur puissance. Je suis Rhea Silvia, la mère de Romulus, fondateur mythique de Rome.");
        manuelGeographie.jeContribueButtonIsVisible();
    }
}
