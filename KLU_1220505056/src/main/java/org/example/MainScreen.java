package org.example;

import javax.swing.*;

public class MainScreen {
    /*Swing arayüz elemanlarını oluşturmak ve görünür hale
 getirmek ve SwingUtilities.invokeLater kullanarak bir iş parçasını (runnable) sürdürmek
  için main içerisine oluşturuyoruz.
 */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ButtonContainer myFrame = new ButtonContainer();
            myFrame.setVisible(true);
        });
    }
}
