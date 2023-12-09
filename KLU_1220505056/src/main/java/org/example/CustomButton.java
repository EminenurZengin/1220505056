package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class CustomButton extends JButton{
    //Buton için gerekli tanımlamaları evrensel olarak anlaşılabilmesi için ingilizce tanımladık.
    GraphQLClient graphQLClient = new GraphQLClient();

    Boolean isActive;
    Boolean isRoyal; //ödevimizin koşullarından biri olan buton aktifliği hakkındaki diziyi gerçekleştirmek için yazılmıştır.
    //Bu buton ilk tıklanılan ve daha sonra tıklandığında sonraki aktifleştirilen butonları deaktif eden bir özelliktedir.
    String title ;
    String GQLData ;
    Color activeColor;
    Color passiveColor;
    String activeIconPath;
    String passiveIconPath;

    //constructor yazımı
    public CustomButton(Boolean isRoyal, String title, String GQLData, Color activeColor, Color passiveColor,
                        String activeIconPath, String passiveIconPath) {
        super(title);

        this.isRoyal = isRoyal;
        this.title = title;
        this.GQLData = GQLData;
        this.activeColor = activeColor;
        this.passiveColor = passiveColor;
        this.activeIconPath = activeIconPath;
        this.passiveIconPath = passiveIconPath;

        // Başlangıçta buton pasif durumda
        isActive = false;
        setPassiveStyle();



        addActionListener(e -> {
            isActive = !isActive;
            if (isActive) {
                setActiveStyle();
                executeMutation();
            } else {
                setPassiveStyle();
            }
        });
    }
    //GraphQL sorgularını yürütmek için kullanılan metodu ayarlıyoruz.
    private void executeMutation() {
        GraphQLClient.executeGraphQLQuery(GQLData);
    }
    //aktif olduğundaki durumun metodunu ayarlıyoruz
    private void setActiveStyle() {
        setBackground(activeColor);
        setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource(activeIconPath))));
    }
    //pasif olduğundaki durumun metodunu ayarlıyoruz
    private void setPassiveStyle() {
        setBackground(passiveColor);
        setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource(passiveIconPath))));
    }
    //deaktif olduğundaki durumun metodunu ayarlıyoruz
    public void deactivateButton(){
        isActive = false;
        setPassiveStyle();
    }
    public void setButtonRoyal(){
        isRoyal = true;
    }
    public void setButtonNotRoyal(){
        isRoyal = false;
    }






}
