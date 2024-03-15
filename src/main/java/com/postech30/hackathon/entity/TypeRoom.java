package com.postech30.hackathon.entity;

public enum TypeRoom {

    STANDARD(1, "Standard", "Quarto simples com cama de casal ou solteiro, ideal para viajantes solitários ou casais.", 100.0),
    MASTER(2, "Master", "Quarto mais espaçoso com cama king-size, TV a cabo e Wi-Fi gratuito.", 150.0),
    DELUXE(3, "Deluxe", "Quarto luxuoso com sala de estar separada, minibar e vista para a localidade e sacada.", 200.0),
    PREMIUM(4, "Premium", "Suíte com mordomo, jacuzzi e acesso ao lounge VIP.", 300.0);

    TypeRoom(int id, String standard, String description, double price) {
    }
}
