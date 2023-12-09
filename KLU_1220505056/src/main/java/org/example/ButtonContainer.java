package org.example;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.util.List;
//JFrame yapısını kullanarak butonlarımızı oluşturup şekil ve düzenlerini ayarlamaya başlıyoruz.



public class ButtonContainer extends JFrame {

    List<CustomButton> buttons = new ArrayList<>();

    //butonla ilgili görüntü ve işlemlerin tanımlandığı algoritma yapısını yazıyoruz.



    public ButtonContainer() {

        setTitle("Custom Button Frame");

        setSize(400, 300);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(4, 4, 10, 10));



        initializeButtons();

        setButtonsClickListeners();



        for (CustomButton button : buttons) {

            add(button);

        }

    }

    // Aşağıdaki Kod dizisini Java Swing uygulamasında 16 adet JButton
// nesnesine tıklama olaylarını dinleyen bir dizi ActionListener eklemek için yazdık .



    private void setButtonsClickListeners() {

        for (CustomButton button : buttons) {

            button.addActionListener(e -> checkForRoyalsAndApplyAlgorithm(button));

        }

    }

    //Tanımlarda yaptığımız Royal durumunu kontrol etmek için ve bulunduğu halde ne yapacağını bildirmek
// için yazdığımız bir kod dizisidir.



    private void checkForRoyalsAndApplyAlgorithm(CustomButton clickedButton) {

        if (isThereAnyRoyalBtn()) {

            if (clickedButton.isRoyal) {

                deactivateButtons();

                clickedButton.isActive = !clickedButton.isActive;

                clickedButton.setButtonNotRoyal();

            }

        } else {

            clickedButton.setButtonRoyal();

        }

    }



    private boolean isThereAnyRoyalBtn() {

        for (CustomButton button : buttons) {

            if (button.isRoyal) {

                return true;

            }

        }

        return false;

    }

 /*Aşağıda yazdığımız metodun amacı ise butonlarımızı başlatmak aynı zamanda her birini de
 istediğimiz şekilde özelleştirebilmeyi sağlamaktır*/



    private void initializeButtons() {

        String activeIconPath = "/active.png";

        String passiveIconPath = "/inactive.png";
        String GQLDATA = "{ \"query\": \"{ hello }\" }";

        int buttonCount = 16;



        for (int i = 1; i <= buttonCount; i++) {

            CustomButton button = new CustomButton(

                    false,

                    "Button " + i,

                    "https://www.x.com",

                    Color.BLUE,

                    Color.GRAY,

                    activeIconPath,

                    passiveIconPath

            );

            buttons.add(button);

        }

    }

    //butonları deaktif durumuna getirmek için yazdığımız metot



    private void deactivateButtons() {

        for (CustomButton button : buttons) {

            button.deactivateButton();

        }

    }



    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            ButtonContainer frame = new ButtonContainer();

            frame.setVisible(true);

        });

    }

}

