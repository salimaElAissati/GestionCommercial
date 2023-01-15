package com.example.partagedonnee.model;



import java.util.Objects;

public class CommandeEntity {

    private int id;

    private String nameCli;

    private String products;

    private String prix;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCli() {
        return nameCli;
    }

    public void setNameCli(String nameCli) {
        this.nameCli = nameCli;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommandeEntity that = (CommandeEntity) o;
        return id == that.id && Objects.equals(nameCli, that.nameCli) && Objects.equals(products, that.products) && Objects.equals(prix, that.prix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameCli, products, prix);
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", nameClient='" + nameCli + '\'' +
                ", products='" + products + '\'' +
                ", prix='" + prix + '\'' +
                '}';
    }
}
